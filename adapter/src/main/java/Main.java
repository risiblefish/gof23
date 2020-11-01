import java.io.*;

/**
 * 假设想把inputStream 按行读取，但按行读取只有reader才能做到，所以要把inputStream转换成reader
 * 所以要用inputStreamReader来读取stream，然后用reader来读取inputStreamReader
 * @author: Sean Yu
 * @create: 2020-10-29 22:29
 **/
public class Main {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("/test.text");
        InputStreamReader fisr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(fisr);
        String line = br.readLine();
        while(line != null && !line.equals("")) {
            System.out.println(line);
        }
        br.close();
    }
}
