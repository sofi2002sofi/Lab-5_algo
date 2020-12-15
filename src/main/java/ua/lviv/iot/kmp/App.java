package ua.lviv.iot.kmp;

import java.util.List;

public class App {
//    public static int[] pattern(char[] arr) {
//        int[] pi = new int[arr.length];
//        pi[0] = 0;
//        int i = 1, j = 0;
//        while(i < arr.length) {
//            if(arr[i] == arr[j]) {
//                pi[i] = j+1;
//                i++;
//                j++;
//                System.out.println("Pattern");
//            } else if(j == 0) {
//                pi[i] = 0;
//                i++;
//            } else {
//                j = pi[j - 1];
//            }
//        }
//        return pi;
//    }
    

//  public static List<int[]> search(char[] a, char[] t, int[] pi) {
//      int k = 0, l = 0;
//      // start and end index
//      int start = 0;
//      int end = 0;
//      List<int[]> foundIdx = new ArrayList<int[]>(); 
//      while(k < t.length) {
//          if(t[k] == a[l]) {
//              k++;
//              l++;
//              System.out.println("Equall");
//              if(l == a.length) {
//                  //add to array indexes of beginning and ending
//                  end = k-1;
//                  int[] pair = {start, end};
//                  foundIdx.add(pair);
//                  System.out.println("ADDED");
////                  start = k;
////                  l=0;
//                  l = pi[l-1];
//                  start = k-l;
//              } 
//          }else if(l == 0){
//              k++;
//              start = k;
//              System.out.println("l====00000");
//              if(k == t.length-1) {
//                  //there is no substring found
//                  return foundIdx;
//              }
//          } else {
//              l = pi[l - 1];
//              start = k - l;
//              System.out.println("push");
//          }
//      
//      }
//      return foundIdx;
//  }

    public static void main( String[] args ) {
        //ababa
        //abcbababaabcbababa
        
        //efe
        //efffefefe
        char[] string = KmpManager.readProcessingString("input").toCharArray();
        char[] pattern = KmpManager.readPattern("input").toCharArray();
        
        int[] pi = KmpManager.piArrCreating(pattern);
        List<int[]> foundIndexes = KmpManager.searchIndexes(pattern, string, pi);
        KmpManager.writeFoundIntervals("output", foundIndexes);
    }
}
