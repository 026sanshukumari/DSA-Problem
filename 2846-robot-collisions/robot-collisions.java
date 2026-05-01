class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        int[][] robort = new int[n][4];
        for(int i=0; i<n; i++){
            robort[i][0] = positions[i];
            robort[i][1] = healths[i];
            robort[i][2] = directions.charAt(i);
            robort[i][3] = i;
        }
        Arrays.sort(robort,(a,b) -> a[0] - b[0]);
        Stack<int[]> s = new Stack<>();
        for(int i=0; i<n; i++){
            if(robort[i][2] == 'R'){
                s.push(robort[i]);
            }else{
                int health = robort[i][1];
                while(!s.isEmpty() && s.peek()[2] == 'R'){
                    int top[] = s.peek();
                    if(top[1] < health){
                        s.pop();
                        health--;
                    }else if(top[1] > health){
                        top[1]--;
                        health = 0;
                        break;
                    }
                    else{
                        s.pop();
                        health = 0;
                        break;
                    }
                }
                if(health > 0){
                    robort[i][1] = health;
                    s.push(robort[i]);
                }
            }
        }
        List<int[]> list = new ArrayList<>(s);
        Collections.sort(list,(a,b) -> a[3] - b[3]);

        List<Integer> res = new ArrayList<>();
        for(int[] r : list){
            res.add(r[1]);
        }
        return res;
    }
}