package frogger;

import java.io.*;

import static frogger.Main.score;

public class Score {
    private final String newscore[] = new String[10];
    private int position = -1;
    public Score(){

    }

    public void readScore() {
        BufferedReader br = null;
        int i = 0;
        try {
            br = new BufferedReader(new FileReader("src/main/resources/Highscore/Highscore1.txt"));
            String contentLine = br.readLine();
            while (contentLine != null) {
                score[i] = contentLine;
                contentLine = br.readLine();
                i++;
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
        int j = 0;
        boolean change = false;
        for (int i = 0; i < 3; i++) {
            if (!change) {
                newscore[i] = score[i];
                if (h >= Integer.parseInt(score[i])) {
                    position = i;
                    j = i;
                    newscore[i] = Integer.toString(h);
                    change = true;
                }
            }
            else {
                newscore[i] = score[j];
                j++;
            }
        }
        if (change) {
            score = newscore;
        }
        return (position+1);
    }

    public void renew() {
        FileOutputStream fos = null;
        File file;
        String text = "";
        for (int i = 0; i < 3; i++) {
            text += score[i] + "\n";
        }
        try{
            file = new File("src/main/resources/Highscore/Highscore1.txt");
            fos = new FileOutputStream(file);
            byte[] bytesArray = text.getBytes();
            fos.write(bytesArray);
            fos.flush();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
    }

}
