package programmers.kakao;

import java.util.HashMap;

public class NewsClustering {

    private HashMap<String, Integer> map1 = new HashMap<>();
    private HashMap<String, Integer> map2 = new HashMap<>();

    public int solution(String str1, String str2) {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        int a = 0;
        int b = 0;
        for (int i = 0; i < str1.length() - 1; i++) {
            String str = str1.substring(i, i + 2);
            boolean bool = false;
            bool = func(str, bool);
            if (bool)
                continue;
            map1.put(str, map1.getOrDefault(str, 0) + 1);
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            String str = str2.substring(i, i + 2);
            boolean bool = false;
            bool = func(str, bool);
            if (bool)
                continue;
            map2.put(str, map2.getOrDefault(str, 0) + 1);
        }
        if (map1.isEmpty() && map2.isEmpty())
            return 65536;
        for (String key : map1.keySet()) {
            if (map2.containsKey(key)) {
                a += Math.min(map1.get(key), map2.get(key));
                b += Math.max(map1.get(key), map2.get(key));
            } else {
                b += map1.get(key);
            }
        }
        for (String key : map2.keySet()) {
            if (!map1.containsKey(key))
                b += map2.get(key);
        }

        double result = (double)a / b;
        double answer = result * 65536;
        return (int)answer;
    }

    private boolean func(String str, boolean bool) {
        for (int j = 0; j < 2; j++) {
            char c = str.charAt(j);
            if (Character.isDigit(c) || !(Character.isLowerCase(c)))
                bool = true;
        }
        return bool;
    }
}
