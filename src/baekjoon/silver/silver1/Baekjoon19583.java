package baekjoon.silver.silver1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Baekjoon19583 {

    private static Map<String, Integer> start = new HashMap<>();
    private static Map<String, Integer> end = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int startTime = parsing(st.nextToken());
        int endTime = parsing(st.nextToken());
        int streamingEnd = parsing(st.nextToken());

        String input = "";
        while((input = br.readLine()) != null) {
            st = new StringTokenizer(input);
            int time = parsing(st.nextToken());
            String name = st.nextToken();

            if (time <= startTime)
                start.put(name, 0);
            if (time >= endTime && time <= streamingEnd)
                end.put(name, 0);
        }
        int result = 0;
        for (String key : start.keySet()) {
            if (end.containsKey(key))
                result++;
        }
        System.out.println(result);

    }

    private static int parsing(String str) {
        String[] split = str.split(":");
        str = split[0] + split[1];
        return Integer.parseInt(str);
    }
}
