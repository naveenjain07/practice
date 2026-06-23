class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
if(tokens.length ==1){
    return Integer.valueOf(tokens[0]);
}
int res =   0;
        for(int i=0; i< tokens.length; i++){
            if(tokens[i].equals("+") || tokens[i].equals("*")  || tokens[i].equals("/")  ||tokens[i].equals("-") )
            {
                res =  calc(Integer.valueOf(st.pop()), Integer.valueOf(st.pop()), tokens[i]);
                    st.push(res);
            }else {
                st.push(Integer.valueOf(tokens[i]));
            }
        
        }

        return res;
    }


    private int calc(int j, int i , String exp){

        switch(exp){
            case "+":
                return i+j;
            case "*":
                return i*j;
            case "-":
                return i-j;
            case "/":
                return i/j;
        }
            return 0;
    }
}
