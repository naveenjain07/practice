class Solution {

    // Can Use Character.isLetterOrDigit(c)
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        s = s.toLowerCase();
        while (i <= j) {
            if (!(s.charAt(i) >= '0' && s.charAt(i) <= '9')
                && !(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
                && !(s.charAt(i) >= 'a' && s.charAt(i) <= 'z')) {
                i++;
                continue;
            }

            if (!(s.charAt(j) >= '0' && s.charAt(j) <= '9')
                && !(s.charAt(j) >= 'A' && s.charAt(j) <= 'Z')
                && !(s.charAt(j) >= 'a' && s.charAt(j) <= 'z')) {
                j--;
                continue;
            }

            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
