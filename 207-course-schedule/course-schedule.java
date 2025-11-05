class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i=0; i<numCourses; i++)
        ans.add(new ArrayList<>());

        for(int[] pre : prerequisites)
        ans.get(pre[1]).add(pre[0]);

        boolean vis[] = new boolean[numCourses];
        boolean path[] = new boolean[numCourses];

        for(int i=0; i<numCourses; i++)
        if(!vis[i] && dfs(i,ans,vis,path))
        return false;

        return true;
    }
    private boolean dfs(int curr, ArrayList<ArrayList<Integer>> ans, boolean vis[], boolean path[]){

    vis[curr] = path[curr] = true;
    for(int next : ans.get(curr)){
    if(!vis[next] && dfs(next, ans, vis, path)) return true;
    else if(path[next]) return true;
    }

    path[curr] = false;
    return false;
}
}