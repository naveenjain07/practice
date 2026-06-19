class Solution {

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        s = s.toLowerCase();
        
        while (i <= j) {
            // Skip non-alphanumeric characters from the left
            if (!isValid(s.charAt(i))) {
                i++;
                continue;
            }

            // Skip non-alphanumeric characters from the right
            if (!isValid(s.charAt(j))) {
                j--;
                continue;
            }

            // Compare characters
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    // Separate helper method to eliminate repetitive code
    private boolean isValid(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}