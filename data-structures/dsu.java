class DisjointSet{
    int[] par;
    int[] rank;
    int[] size;

    DisjointSet(int n){
        par = new int[n];
        rank = new int[n];
        size = new int[n];
        for(int i=0;i<n;i++){
            par[i] = i;
            rank[i] = 0;
            size[i] = 1;
        }
    }

    public int findPar(int node){
        if(node==par[node]) return node;
        int ulp = findPar(par[node]);
        par[node] = ulp;
        return par[node];
    }

    public void unionByRank(int u,int v){
        int ulp_u = findPar(u);
        int ulp_v = findPar(v);

        if(ulp_u==ulp_v) return;

        if(rank[ulp_u]<rank[ulp_v]){
            par[ulp_u] = ulp_v;
        }
        else if(rank[ulp_v]<rank[ulp_u]){
            par[ulp_v] = ulp_u;
        }
        else{
            par[ulp_u] = ulp_v;
            rank[ulp_v] = rank[ulp_v]+1;
        }
    }

    public void unionBySize(int u,int v){
        int ulp_u = findPar(u); 
        int ulp_v = findPar(v); 
        if(ulp_u == ulp_v) return; 

        if(size[ulp_u]<size[ulp_v]){
            par[ulp_u] = ulp_v;
            size[ulp_v] = size[ulp_v]+size[ulp_u];
        }
        else{
            par[ulp_v] = ulp_u;
            size[ulp_u] = size[ulp_v]+size[ulp_u];
        }
    }
}