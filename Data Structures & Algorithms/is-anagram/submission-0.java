class Solution {
    public boolean isAnagram(String s, String t) {


        int s_len = s.length();
        int t_len = t.length();
        if(s_len != t_len) return false;
        int[] a = new int[26];
        int j =s_len-1;
        for(int i=0; i<s_len; i++){
            a[s.charAt(i)-'a']++;
            a[t.charAt(j)-'a']--;
            j--;
        }

        for(int i =0 ; i < 26; i++){
            if(a[i]!=0){
                return false;
            }
        }

        return true;

    }
}
