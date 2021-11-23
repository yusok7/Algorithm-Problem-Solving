package programmers.levelthree;

import java.util.*;
import java.io.*;

public class BestAlbum {

    public static Map<String, Integer> map = new HashMap<>();

    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        for (int i = 0; i < genres.length; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }

        return answer;
    }
}
