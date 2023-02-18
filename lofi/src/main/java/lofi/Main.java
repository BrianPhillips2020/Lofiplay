package lofi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;


import java.awt.Desktop;


/**
 * Stupid little app that will display some ascii art and open your default browser with a lofi-hiphop stream
 */
public class Main{

public static void main(String[] args) throws URISyntaxException, IOException {
    InputStream art = getArt("/lofi.txt");

    System.out.print(String.join("\n", Collections.nCopies(5, "\n")));
    BufferedReader reader = new BufferedReader(new InputStreamReader(art));
    try{
            String readLine = "";
            while ((readLine = reader.readLine()) != null) {
                System.out.println(readLine);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        reader.close();


    try {
        Thread.sleep(100);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    playThatShit();
}

/**
 * 
 * @param filename
 * @return {@link InputStream} of the ascii art
 * @throws URISyntaxException
 */
 private static InputStream getArt(final String filename) throws URISyntaxException {
    InputStream is = Main.class.getResourceAsStream(filename);
    if(is == null){
        throw new IllegalArgumentException("Art file not found");
    }else{
        return is;        
    }
}

/**
 * Opens a browser with the lofi-hiphop stream
 */
private static void playThatShit(){
    try{
        if(Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=jfKfPfyJRdk"));
        }
    }catch(IOException | URISyntaxException e){ 
    throw new RuntimeException("Something went wrong while playing stream" + e);
}
    }
}
