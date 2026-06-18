class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        

        Map<String, List<String>> map = new HashMap<>();

        for(String st : strs){
            int a[] = new int[26];

            for(int j=0; j< st.length();j++){

                a[st.charAt(j)-'a']++;
            }

            map.computeIfAbsent(Arrays.toString(a), k -> new ArrayList<String>()).add(st);


        }

        List<List<String>> res = new ArrayList<>();
        for(List<String> val : map.values()){

            res.add(val);

        }

        return res;


    }
}
