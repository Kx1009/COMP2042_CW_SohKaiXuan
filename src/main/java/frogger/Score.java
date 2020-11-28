package frogger;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class Score {
    /** list of high score */
    private ArrayList<Integer> score = new ArrayList<Integer>();
    /** level of current game */
    private int level;

    /**
     * Construct a Score object
     * @param x the level of current game
     */
    public Score(int x){
        level = x;
    }

    /**
     * Read the existing high score from the respective high score file for current game level
     * Store the high score into the list
     * If the text file is empty, store 0 into the list
     */
    public void readScore() {
        BufferedReader br = null;
        try {
            File file = new File("src/main/resources/Highscore/Highscore" + level + ".txt");
            if (!file.exists()) {
                file.createNewFile();
            }
            FileReader filereader = new FileReader("src/main/resources/Highscore/Highscore" + level + ".txt");
            br = new BufferedReader(filereader);
            String contentLine = br.readLine();
            while (contentLine != null) {
                score.add(Integer.parseInt(contentLine));
                contentLine = br.readLine();
            }
            // storing 0 into the high score list if it is empty
            if (score.isEmpty()) {
                score.add(0);
                score.add(0);
                score.add(0);
            }
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        finally {
            try {
                if (br != null)
                    br.close();
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    /**
     * Check if the current high score higher than any existing high score
     * @param h current high score
     * @return the position of current high score in the renewed high score list else -1
     */
    public int changeScore(int h) {
        if (score.stream().anyMatch(n -> (n < h))) {
            score.add(h);
            Collections.sort(score,Collections.reverseOrder());
            score = new ArrayList<Integer>(score.subList(0,3));
            renew();
            return (score.indexOf(h)+1);
        }
        else { return -1; }
    }

    /**
     * Rewriting the renewed high score list back to the respective high score file for current game level
     */
    public void renew() {
        FileWriter file;
        BufferedWriter bw = null;
        try{
            file = new FileWriter("src/main/resources/Highscore/Highscore" + level + ".txt");
            bw = new BufferedWriter(file);
            for (Integer num:score) {
                bw.write(num.toString());
                bw.newLine();
            }
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        finally {
            try {
                if (bw != null) {
                    bw.close();
                }
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

    /**
     * Print the high score list
     * @return the high score list
     */
    public String toString () {
        String scorestring = "";
        int i = 1;
        for (Integer num:score) {
            scorestring += i + ".\t" + num + "\n";
            i++;
        }
        return scorestring;
    }

}
