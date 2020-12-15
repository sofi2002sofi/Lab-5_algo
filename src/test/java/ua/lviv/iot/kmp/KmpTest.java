package ua.lviv.iot.kmp;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class KmpTest {
    String firstString = "abcbababaabcbababa";
    String secondString = "efffefefe";
    String thirdString = "pypypypypypyp";
    String forthString = "efesseffereefesfesfsefsfesfefsefefsefefesfsfse";
    String fifthString = "efesrtcsehkhd";
    String sixthString = "rfgdgekesefesekedredseker dsdsa";
    

    String firstPattern = "ababa";
    String secondPattern = "efe";
    String thirdPattern = "pypyp";
    String forthPattern = "efes";
    String fifthPattern = "ifos";
    String sixthPattern = "eker";

    
    @Test
    public void testFirstString() {
        List<int[]> intervals = new ArrayList<int[]>();
        int[][] pairs = {{4, 8}, {13, 17}};
        for(int[]pair : pairs) {
            intervals.add(pair);
        }
        
        char[] string = firstString.toCharArray();
        char[] pattern = firstPattern.toCharArray();
        
        int[] pi = KmpManager.piArrCreating(pattern);
        List<int[]> foundIndexes = KmpManager.searchIndexes(pattern, string, pi);
        assertArrayEquals(intervals.toArray(), foundIndexes.toArray());
    }

    @Test
    public void testSecondString() {
        List<int[]> intervals = new ArrayList<int[]>();
        int[][] pairs = {{4, 6}, {6, 8}};
        for(int[]pair : pairs) {
            intervals.add(pair);
        }
        
        char[] string = secondString.toCharArray();
        char[] pattern = secondPattern.toCharArray();
        
        int[] pi = KmpManager.piArrCreating(pattern);
        List<int[]> foundIndexes = KmpManager.searchIndexes(pattern, string, pi);
        assertArrayEquals(intervals.toArray(), foundIndexes.toArray());
    }
    
    @Test
    public void testThirdString() {
        List<int[]> intervals = new ArrayList<int[]>();
        int[][] pairs = {{0, 4}, {2, 6}, {4, 8}, {6, 10}, {8, 12}};
        for(int[]pair : pairs) {
            intervals.add(pair);
        }
        
        char[] string = thirdString.toCharArray();
        char[] pattern = thirdPattern.toCharArray();
        
        int[] pi = KmpManager.piArrCreating(pattern);
        List<int[]> foundIndexes = KmpManager.searchIndexes(pattern, string, pi);
        assertArrayEquals(intervals.toArray(), foundIndexes.toArray());
    }

    @Test
    public void testForthString() {
        List<int[]> intervals = new ArrayList<int[]>();
        int[][] pairs = {{0, 3}, {11, 14}, {37, 40}};
        for(int[]pair : pairs) {
            intervals.add(pair);
        }
        
        char[] string = forthString.toCharArray();
        char[] pattern = forthPattern.toCharArray();
        
        int[] pi = KmpManager.piArrCreating(pattern);
        List<int[]> foundIndexes = KmpManager.searchIndexes(pattern, string, pi);
        assertArrayEquals(intervals.toArray(), foundIndexes.toArray());
    }
    
    @Test
    public void testFifthString() {
        List<int[]> intervals = new ArrayList<int[]>();
        
        char[] string = fifthString.toCharArray();
        char[] pattern = fifthPattern.toCharArray();
        
        int[] pi = KmpManager.piArrCreating(pattern);
        List<int[]> foundIndexes = KmpManager.searchIndexes(pattern, string, pi);
        assertArrayEquals(intervals.toArray(), foundIndexes.toArray());
    }

    @Test
    public void testSixthString() {
        List<int[]> intervals = new ArrayList<int[]>();
        int[][] pairs = {{21, 24}};
        for(int[]pair : pairs) {
            intervals.add(pair);
        }
        
        char[] string = sixthString.toCharArray();
        char[] pattern = sixthPattern.toCharArray();
        
        int[] pi = KmpManager.piArrCreating(pattern);
        List<int[]> foundIndexes = KmpManager.searchIndexes(pattern, string, pi);
        assertArrayEquals(intervals.toArray(), foundIndexes.toArray());
    }
        
}
