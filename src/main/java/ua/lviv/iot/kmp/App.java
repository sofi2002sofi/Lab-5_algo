package ua.lviv.iot.kmp;

import java.util.List;

public class App {
    
    public static void main( String[] args ) {
        
        char[] string = KmpManager.readProcessingString("input").toCharArray();
        char[] pattern = KmpManager.readPattern("input").toCharArray();
        
        int[] pi = KmpManager.piArrCreating(pattern);
        List<int[]> foundIndexes = KmpManager.searchIndexes(pattern, string, pi);
        KmpManager.writeFoundIntervals("output", foundIndexes);
    }
}
