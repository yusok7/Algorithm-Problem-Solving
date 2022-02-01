package dongbinna.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dongbinna113 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int result = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    sb.setLength(0);
                    sb.append(i).append(j).append(k);
                    if (sb.toString().contains("3"))
                        result++;
                }
            }
        }
        System.out.println(result);
    }
}
