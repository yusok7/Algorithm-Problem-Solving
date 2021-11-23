import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class HeapTest {

    public static PriorityQueue<Integer> pq1 = new PriorityQueue<>();
    public static PriorityQueue<Integer> pq2 = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pq1.add(2);
        pq1.add(3);
        pq1.add(1);
        pq1.add(100);
        pq1.add(34);

        for (int i = 0; i < 5; i++) {
            int n = Integer.parseInt(br.readLine());
            pq2.add(n);
        }

        for (int i = 0; i < 5; i++) {
            Integer poll = pq1.poll();
            System.out.println("poll1 = " + poll);
        }

        for (int i = 0; i < 5; i++) {
            Integer poll = pq2.poll();
            System.out.println("poll2 = " + poll);
        }
    }
}
