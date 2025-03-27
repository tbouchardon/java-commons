package fr.ksuto.commons.helpers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

public class InOut {
    
    public static void writeImage(BufferedImage capturedScreen, String name) {
        
        String[] split = name.split("/");
        
        String folders = "";
        if (split.length > 1) {
            
            for (int i = 0, splitLength = split.length; i < splitLength - 1; i++) {
                String folder = split[i];
                folders += folder + "/";
            }
            
            try {
                Files.createDirectories(Paths.get(folders));
            }
            catch (IOException ignore) {}
        }
        
        String fileName = split[split.length - 1];
        
        try {
            String cleanFileName = fileName.replaceAll("[,;:!|]", "_");
            File   outputfile    = new File(folders + cleanFileName);
            ImageIO.write(capturedScreen, "png", outputfile);
        }
        catch (IOException ignore) {}
    }
}
