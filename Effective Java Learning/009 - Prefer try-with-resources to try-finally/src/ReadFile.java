import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ReadFile implements AutoCloseable {

    private static final int BUFFER_SIZE = 100;

    /**
     * Function to read first line of file with try-finally approach.
     * @param path - path of the file to be read.
     * @return String - string returned.
     * @throws IOException - throw Input/Output exception.
     */
    static String firstLineOfFileV1(String path) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(path));
        try {
            return br.readLine();
        } finally {
            br.close();
        }
    }

    /**
     * Function to read first line of file with try-with-resources approach.
     * @param path - path of the file to be read.
     * @return string - string returned.
     * @throws IOException - throw Input/Output exception.
     */
    static String firstLineOfFileV2(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            return br.readLine();
        }
    }

    /**
     * Function to copy data from one file to another file using try-finally approach.
     * @param src - path of input file.
     * @param dst - path of output file.
     * @throws IOException - throw Input/Output exception.
     */
    static void copyV1(String src, String dst) throws IOException {
        InputStream in = new FileInputStream(src);
        try {
            OutputStream out = new FileOutputStream(dst);
            try {
                byte [] buf = new byte[BUFFER_SIZE];
                int n;
                while((n = in.read(buf)) >= 0) {
                    out.write(buf, 0, n);
                }
            } finally {
                out.close();
            }
        } finally {
            in.close();
        }
    }

    /**
     * Function to copy data from one file to another file using try-with-resources approach.
     * @param src - path of input file.
     * @param dst - path of output file.
     * @throws IOException - throw Input/Output exception.
     */
    static void copyV2(String src, String dst) throws IOException {
        try (InputStream in   = new FileInputStream(src);
             OutputStream out = new FileOutputStream(dst)) {
            byte [] buf = new byte[BUFFER_SIZE];
            int n;
            while((n = in.read(buf)) >= 0) {
                out.write(buf, 0, n);
            }
        }
    }

    public static void main(String [] args) throws IOException {
        System.out.println(firstLineOfFileV1("random/path"));
        System.out.println(firstLineOfFileV2("random/path"));

        copyV1("from/path/file1.txt", "to/path/file2.txt");
        copyV2("from/path/file1.txt", "to/path/file3.txt");
    }

    @Override
    public void close() {
        System.out.println("Over-ridden AutoCloseable's close() function.");
    }
}
