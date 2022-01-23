package expertacademy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Expert1926 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();
        list.add("3");
        list.add("6");
        list.add("9");

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            String str = String.valueOf(i);
            if (str.contains("3") || str.contains("6") || str.contains("9")) {
                String[] strArr = str.split("");
                for (String val : strArr) {
                    if (list.contains(val))
                        sb.append("-");
                }
                sb.append(" ");
            } else {
                sb.append(str).append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}
