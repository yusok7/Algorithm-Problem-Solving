package baekjoon.silver.silver2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1713 {

    static class Photo implements Comparable<Photo> {

        int id;
        int count;
        int time;

        public Photo(int id, int count, int time) {
            this.id = id;
            this.count = count;
            this.time = time;
        }

        @Override
        public int compareTo(Photo photo) {
            if (this.count == photo.count) {
                return Integer.compare(this.time, photo.time);
            }
            return Integer.compare(this.count, photo.count);
        }
    }

    public static Map<Integer, Photo> map = new HashMap<>();
    public static List<Photo> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            int id = Integer.parseInt(st.nextToken());
            if (map.size() < n) {
                if (map.containsKey(id)) {
                    func1(id);
                } else {
                    Photo photo = new Photo(id, 0, i);
                    map.put(id, photo);
                    list.add(photo);
                }
            } else {
                Collections.sort(list);
                if (map.containsKey(id)) {
                    func1(id);
                } else {
                    Photo photo = new Photo(id, 0, i);
                    int removeId = list.get(0).id;
                    map.remove(removeId);
                    map.put(id, photo);
                    list.set(0, photo);
                }
            }
        }
        int[] arr = new int[map.size()];
        int index = 0;
        for (Integer key : map.keySet()) {
            arr[index] = key;
            index++;
        }
        Arrays.sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }

    }

    private static void func1(int id) {
        Photo photo = map.get(id);
        photo = new Photo(id, photo.count + 1, photo.time);
        map.put(id, photo);
        for (int j = 0; j < list.size(); j++) {
            if (list.get(j).id == photo.id)
                list.set(j, photo);
        }
    }
}
