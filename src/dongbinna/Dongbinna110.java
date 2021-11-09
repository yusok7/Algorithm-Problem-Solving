package dongbinna;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Dongbinna110 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 전체 지도 사이즈
        int N = Integer.parseInt(br.readLine());
        // 시작 위치
        int x = 1;
        int y = 1;

        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        int nx=0;
        int ny=0;
        String[] move = {"L","R","U","D"};

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        List<String> list = new ArrayList<>();

        while(st.hasMoreTokens()) {
            list.add(st.nextToken());
        }

        for(String val : list) {
            for(int i =0; i<4; i++) {
                if(val.equals(move[i])) {
                    nx = x + dx[i];
                    ny = y + dy[i];
                }
                if(nx<1 || nx>N || ny <1 || ny >N) {
                    continue;
                }
                x=nx;
                y=ny;
            }
        }

        System.out.println(x);
        System.out.println(y);

    }

}
