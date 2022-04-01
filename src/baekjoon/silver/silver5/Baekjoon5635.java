package baekjoon.silver.silver5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon5635 {

    static class Person implements Comparable<Person> {

        String name;
        int day;
        int month;
        int year;

        public Person(String name, int day, int month, int year) {
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }

        @Override
        public int compareTo(Person o) {
            if (this.year != o.year)
                return Integer.compare(this.year, o.year);
            else if (this.month != o.month)
                return Integer.compare(this.month, o.month);
            return Integer.compare(this.day, o.day);
        }
    }

    private static List<Person> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());
            Person person = new Person(name, day, month, year);
            list.add(person);
        }

        Collections.sort(list);

        Person person1 = list.get(0);
        Person person2 = list.get(list.size() - 1);

        System.out.println(person2.name);
        System.out.println(person1.name);
    }
}
