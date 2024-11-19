package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import javax.swing.JOptionPane;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private static final String HOME = System.getProperty("user.home");
    private static final String SEPARATOR = System.getProperty("file.separator");

    private File currentFile = new File(HOME + SEPARATOR + "output.txt");

    public void setFile(final File f){
        currentFile = f;
    }

    public File getFile(){
        return currentFile;
    }

    public String getPath(){
        return currentFile.getPath();
    }

    public void write(final String s){
        try (PrintStream ps = new PrintStream(currentFile.getPath(), StandardCharsets.UTF_8)) {
            ps.println(s);
        } catch (IOException e1) {
            System.out.println(e1.getMessage());
        }
    }
}
