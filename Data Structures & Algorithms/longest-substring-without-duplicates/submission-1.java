class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        if (len == 1) {
            return 1;
        }
        if (len == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();

        int i = 0;
        int j = 1;
        int max = 1;
        set.add(s.charAt(i));

        // pwwkew
        while (i < j && j < len) {
            
            if (set.contains(s.charAt(j))) {
                
                while (s.charAt(i) != s.charAt(j)) {
                    set.remove(s.charAt(i));
                    i++;
                }
                set.remove(s.charAt(i));
                i++;
                
            } 

                set.add(s.charAt(j));
                j++;
            

            max = Math.max(max, j - i);
        }

        return Math.max(max, set.size());
    }
}
