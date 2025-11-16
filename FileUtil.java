import java.io.*;
import java.util.*;

public class FileUtil {

    public static ArrayList<Student> readFromFile(String fileName) {
        ArrayList<Student> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] s = line.split(",");
                if (s.length == 5) {
                    list.add(new Student(
                            Integer.parseInt(s[0]),
                            s[1],
                            s[2],
                            s[3],
                            Double.parseDouble(s[4])
                    ));
                }
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return list;
    }

    public static void writeToFile(String fileName, ArrayList<Student> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            for (Student s : list) {
                bw.write(s.toString());
                bw.newLine();
            }
        } catch (Exception e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    // Demonstrate File Attributes
    public static void displayFileAttributes(String fileName) {
        File file = new File(fileName);
        System.out.println("\n=== File Attributes ===");
        System.out.println("Name: " + file.getName());
        System.out.println("Absolute Path: " + file.getAbsolutePath());
        System.out.println("Readable: " + file.canRead());
        System.out.println("Writable: " + file.canWrite());
        System.out.println("Size: " + file.length() + " bytes");
    }

    // Random Access File reading (roll number search)
    public static void randomAccessRead(String fileName) {
        try (RandomAccessFile raf = new RandomAccessFile(fileName, "r")) {
            System.out.println("\n=== Random Access File Read ===");
            String line;
            while ((line = raf.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("RandomAccessFile Error: " + e.getMessage());
        }
    }
}

