class Solution {
//   2 solutions 
  
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



/**
     public int lengthOfLongestSubstring(String s) {
        HashSet<Character> charSet = new HashSet<>();
        int l = 0;
        int res = 0;

        for (int r = 0; r < s.length(); r++) {
            while (charSet.contains(s.charAt(r))) {
                charSet.remove(s.charAt(l));
                l++;
            }
            charSet.add(s.charAt(r));
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
**/
}