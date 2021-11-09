import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class BufferedWriterTest {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write("1");
        bw.write("\n");
        bw.write("2");
        bw.write("\n");
        bw.flush();
        bw.close();
    }
}
