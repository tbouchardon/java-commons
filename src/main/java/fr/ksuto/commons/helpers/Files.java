package fr.ksuto.commons.helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by thomas.bouchardon on 24/10/2016!
 */
public class Files {
    
    private static final Logger logger = LoggerFactory.getLogger(Files.class);
    
    public static boolean moveFileTo(File oldFile, File newFile, boolean overWrite) {
        
        if (overWrite && newFile.exists()) {
            //			System.out.println("        Destination file exists, deleting...");
            boolean deleted = newFile.delete();
            if (!deleted) {
                //				System.out.println("        /!\\ Failed to delete duplicate.");
                return false;
            }
            //			System.out.println("        Deleted !");
        }
        
        return oldFile.renameTo(newFile);
    }
    
    public static void openDir(File file) {
        
        Desktop desktop = Desktop.getDesktop();
        
        try {
            
            //			File dirToOpen = new File(url);
            desktop.open(file);
        }
        catch (IllegalArgumentException | IOException iae) {
            
            logger.warn("Impossible d'ouvrir {}", file, iae);
        }
    }
}
