package ua.lviv.iot.kmp;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class KmpManager {
    public static int[] piArrCreating(char[] pattern) {
        int maxLength = pattern.length;
        int[] pi = new int[maxLength];
        pi[0] = 0;
        int suffix = 1, prefix = 0;
        while(suffix < maxLength) {
            
            if(pattern[suffix] == pattern[prefix]) {
                
                pi[suffix] = prefix+1;
                suffix++;
                prefix++;
                
            } else if(prefix == 0) {
                
                pi[suffix] = 0;
                suffix++;
                
            } else {
                prefix = pi[prefix - 1];
            }
        }
        return pi;
    }
    
    public static List<int[]> searchIndexes(char[] pattern, char[] string, int[] pi) {
        int stringIterator = 0, patternIterator = 0;
        int start = 0, end = 0;
        List<int[]> foundIndexes = new ArrayList<int[]>(); 
        
        while(stringIterator < string.length) {
            if (string[stringIterator] == pattern[patternIterator]) {
                
                stringIterator++;
                patternIterator++;
                
                if (patternIterator == pattern.length) {
                    end = stringIterator - 1;
                    int[] interval = {start, end};
                    foundIndexes.add(interval);
                    patternIterator = pi[patternIterator - 1];
                    start = stringIterator - patternIterator;
                } 
                
            } else if (patternIterator == 0) {
                
                stringIterator++;
                start = stringIterator;
                
            } else {
                
                patternIterator = pi[patternIterator - 1];
                start = stringIterator - patternIterator;
                
            }
        
        }
        return foundIndexes;
    }
    
    public static void writeFoundIntervals(String output, List<int[]> foundIndexes) {
        try {
            FileWriter myWriter = new FileWriter(output);
            for(int[] pair : foundIndexes) {
                for(int limit : pair) {
                    myWriter.write(" " + String.valueOf(limit) + " ");
                }
                myWriter.write(System.getProperty( "line.separator" ));
            }
            myWriter.close();
          } catch (IOException e) {
            e.printStackTrace();
          }       
    }
    
    public static String readProcessingString(String fileName) {
        String processingString = null;
        Path pathToFile = Paths.get(fileName);
        
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) { 
        
            processingString = br.readLine(); 

        
        } catch (IOException ioe) { 
            ioe.printStackTrace(); 
        } 
        return processingString;
    }
    
    public static String readPattern(String fileName) {
        String pattern = null;
        Path pathToFile = Paths.get(fileName);
        
        try (BufferedReader br = Files.newBufferedReader(pathToFile, StandardCharsets.US_ASCII)) { 
            br.readLine();
            pattern = br.readLine(); 
        } catch (IOException ioe) { 
            ioe.printStackTrace(); 
        } 
        return pattern;
    }

}
