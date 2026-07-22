class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> s = new Stack<>();
        for(String op : operations){
            if(op.equals("+")){
                int first = s.pop();
                int sec = s.peek();
                s.push(first);
                s.push(first + sec);
            }else if(op.equals("C")){
                s.pop();
            }else if(op.equals("D")){
                s.push(s.peek() * 2);
            }else{
                int num = Integer.parseInt(op);
                s.push(num);
            }
        }
        int sum = 0;
        while(!s.isEmpty()){
            sum += s.pop();
        }
        return sum;
    }
}