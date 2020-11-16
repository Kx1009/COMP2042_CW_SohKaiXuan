package frogger;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;


public class Score {
    private ArrayList<Integer> score = new ArrayList<Integer>();
    private int level;
    public Score(int x){
        level = x;
    }

    public void readScore() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("src/main/resources/Highscore/Highscore" + level + ".txt"));
            String contentLine = br.readLine();
            while (contentLine != null) {
                score.add(Integer.parseInt(contentLine));
                contentLine = br.readLine();
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
