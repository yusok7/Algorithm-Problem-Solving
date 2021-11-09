package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon7568 {
    public static class Person {
        int weight;
        int height;

        public int getWeight() {
            return weight;
        }

        public int getHeight() {
            return height;
        }

        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Person> personList = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            Person person = new Person(weight, height);
            personList.add(person);
        }

        for (int i = 0; i < n; i++) {
            Person person = personList.get(i);
            int count = 1;
            for (int j = 0; j < n; j++) {
                Person person2 = personList.get(j);
                if (person2.getWeight() > person.getWeight() && person2.getHeight() > person.getHeight()) {
                    count++;
                }
            }
            result.add(count);
        }

        for (int i = 0; i < result.size(); i++) {
            if (i == result.size()-1) {
                System.out.print(result.get(i));
            } else {
                System.out.print(result.get(i)+" ");
            }
        }
    }
}
