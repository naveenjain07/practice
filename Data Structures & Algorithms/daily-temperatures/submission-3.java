class Solution {

    //Monotonic STack
    public int[] dailyTemperatures(int[] t) {
        
       
        Stack<Integer> st = new Stack<>();
        st.push(0);
        int []a = new int[t.length];
        for(int i = 1 ;i <t.length; i++){
            
            while(!st.isEmpty()  && t[i] > t[st.peek()] ){
                int j = st.pop();
                a[j] = i-j;
               
            } 
             st.push(i);
        }

        return a;

    }






}




/**
 GrEedey 
public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];

        for (int i = n - 2; i >= 0; i--) {
            int j = i + 1;
            while (j < n && temperatures[j] <= temperatures[i]) {
                if (res[j] == 0) {
                    j = n;
                    break;
                }
                j += res[j];
            }

            if (j < n) {
                res[i] = j - i;
            }
        }
        return res;
    }
}
**/