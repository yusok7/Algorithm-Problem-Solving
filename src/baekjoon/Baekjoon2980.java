package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon2980 {

    public static List<Integer> traffic = new ArrayList<>();
    public static List<int[][]> time = new ArrayList<>();
    public static List<Boolean> list = new ArrayList<>();
    public static int count = 0;
    public static int[][] arr;
    public static int red;
    public static int green;

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        // 총 걸린 시간
        int length = 0;

        for(int i = 0; i < n; i++) {
            int[][] arr = new int[1][2];
            st = new StringTokenizer(br.readLine(), " ");
            traffic.add(Integer.parseInt(st.nextToken()));
            arr[0][0] = Integer.parseInt(st.nextToken());
            arr[0][1] = Integer.parseInt(st.nextToken());
            time.add(arr);
        }

        System.out.println("hi");

        while(true) {
            // 신호등이 있다면
            if (check(length)) {
                while(true) {
                    // 빨간불이라면
                    if(!isGreen(count)) {
                        count++;
                    } else { // 초록불이라면
                        int index =  (count-1) % (red + green);
                        if(!(list.get(index-1)== false && list.get(index) == true)) {
                            time.remove(0);
                            count++;
                        }
                        length++;
                        for(int i = 0; i < list.size(); i++) {
                            list.remove(0);
                        }
                        break;
                    }
                }
                // 신호등이 없다면
            } else {
                count++;
                length++;
            }

            if (length == l) {
                break;
            }
        }

        System.out.println(count);

    }

    public static boolean check(int index) {
        if (traffic.contains(index)) {
            return true;
        }
        return false;
    }

    // 현재 시간을
    public static boolean isGreen(int index) {
        arr = time.get(0);
        red = arr[0][0];
        green = arr[0][1];
        for(int i = 0; i < red; i++) {
            list.add(false);
        }
        for(int i = 0; i < green; i++) {
            list.add(true);
        }
        index =  (index-1) % (red + green);
        return list.get(index);

    }

}

