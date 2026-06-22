class Solution {
    public boolean isValid(String s) {
        //   ([{}])
        int count = 0;
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '(' || s.charAt(i) == '[') {
                st.push(s.charAt(i));
            }

            else {
                if (st.isEmpty()) {
                    return false;
                }
                if (!st.isEmpty() && st.pop() != getValid(s.charAt(i))) {
                    return false;
                }
            }
        }

        return st.isEmpty();
    }

    private Character getValid(Character ch) {
        Character res = null;
        switch (ch) {
            case '}':
                res = '{';
                break;

            case ')':
                res = '(';
                break;

            case ']':
                res = '[';
                break;
        }
        return res;
    }
}
