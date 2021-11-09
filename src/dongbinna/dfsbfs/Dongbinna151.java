package dongbinna.dfsbfs;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Dongbinna151 {

    public static int n, m;
    public static int result = 0;
    public static int[][] graph = new int[1000][1000];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
//            st = new StringTokenizer(br.readLine(),"");
            String[] split = br.readLine().split("");
            for(int j = 0; j < m; j++) {
//                int num = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(split[j]);
                graph[i][j] = num;
            }
        }

        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m ; j++) {
                if (dfs(i,j) == true) {
                    result ++;
                }
            }
        }

        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }

    public static boolean dfs(int x, int y) {
        if (x<0 || x>=n || y<0 || y>=m) {
            return false;
        }

        if (graph[x][y]==0) {
            graph[x][y] = 1;
            dfs(x-1,y);
            dfs(x+1,y);
            dfs(x,y-1);
            dfs(x,y+1);
            return true;
        }
        return false;
    }
}