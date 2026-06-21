class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int freq[] = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
        }
        int l = 0;
        int r = 0;
        int sub[] = new int[26];
        int count = 0;

        while (l < s2.length()) {
            while (count < s1.length() && l < s2.length()) {
                sub[s2.charAt(l) - 'a']++;
                count++;
                l++;
            }
            count--;

            if (Arrays.toString(freq).equals(Arrays.toString(sub))) {
                return true;
            }
            sub[s2.charAt(r) - 'a']--;
            r++;
        }
        return false;
    }

/***

import java.util.Arrays;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int freq[] = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
        }
        
        int l = 0;
        int r = 0;
        int sub[] = new int[26];

        // Single while loop moving 'l' forward
        while (l < s2.length()) {
            // 1. Always add the current character at 'l'
            sub[s2.charAt(l) - 'a']++;
            
            // 2. Once the window size equals s1.length(), check and slide
            if (l - r + 1 == s1.length()) {
                // Efficient O(26) comparison
                if (Arrays.equals(freq, sub)) {
                    return true;
                }
                
                // Slide the left boundary: remove s2[r] and increment r
                sub[s2.charAt(r) - 'a']--;
                r++;
            }
            
            l++; // Expand the right boundary
        }
        return false;
    }
}
*/



}


