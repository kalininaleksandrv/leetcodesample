package Strings;

public class StringIsAnagram {

    /**
     * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
     * typically using all the original letters exactly once.
     * Example 1:
     * Input: s = "anagram", t = "nagaram"
     * Output: true
     * Example 2:
     * Input: s = "rat", t = "car"
     * Output: false
     */

    public boolean isAnagram(String sample, String candidate) {
        if(sample.length() != candidate.length()) return false;

        /*
          idea is - lets create array for all english letters and increment value on letter's index
          then if frequency of same letters is not equal  -is not anagram
          we also can improve this solution and use HashMap instead of array
         */

        int[] freq = new int[26];
        int[] freq2 = new int[26];

        /*
          The statement ++array[s.charAt(i) - 'A']; is incrementing the value in the array indexed by s.charAt(i) - 'A'.
          What this loop does is that it counts up the number of occurrences of each letter in s.
          The reason for - 'A', is that it "shifts" the ascii/unicode value so that A - Z have values 0 - 25.
         */

        for (char c : sample.toCharArray()) {
            freq[c - 'a']++;
        }
        for (char c : candidate.toCharArray()) {
            freq2[c - 'a']++;
        }
        for (int i = 0; i < freq.length; i++) {
            if(freq[i]!=freq2[i]){
                return false;
            }
        }
        return true;
    }
}
