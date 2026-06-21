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
//         s1="ab"
// s2="lecabee"
// int r=0;
        while (l < s2.length()) {
            count = 0;
            
            while (count < s1.length() && l < s2.length()) {
                sub[s2.charAt(l) - 'a']++;
                count++;
                l++;
            }
           r++;
           
            if (Arrays.toString(freq).equals(Arrays.toString(sub))) {
                return true;
            }
            sub = new int[26];
            l=r;
        }
        return false;
    }
}
