import java.util.*;

public class Main {
    public static void main(String[] args) {

        String fileName = "students.txt";

        ArrayList<Student> list = FileUtil.readFromFile(fileName);
        StudentManager manager = new StudentManager(list);

        Scanner sc = new Scanner(System.in);
        int ch;

        System.out.println("Loaded students from file:");
        manager.viewAll();

        do {
            System.out.println("\n===== Capstone Student Menu =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search by Name");
            System.out.println("4. Delete by Name");
            System.out.println("5. Sort by Marks");
            System.out.println("6. Save and Exit");
            System.out.print("Enter choice: ");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    System.out.print("Roll No: ");
                    int r = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Name: ");
                    String n = sc.nextLine();

                    System.out.print("Email: ");
                    String e = sc.nextLine();

                    System.out.print("Course: ");
                    String c = sc.nextLine();

                    System.out.print("Marks: ");
                    double m = sc.nextDouble();

                    manager.addStudent(new Student(r, n, e, c, m));
                    break;

                case 2:
                    manager.viewAll();
                    break;

                case 3:
                    sc.nextLine();
                    System.out.print("Enter name: ");
                    manager.searchByName(sc.nextLine());
                    break;

                case 4:
                    sc.nextLine();
                    System.out.print("Enter name: ");
                    manager.deleteByName(sc.nextLine());
                    break;

                case 5:
                    manager.sortByMarks();
                    manager.viewAll();
                    break;

                case 6:
                    FileUtil.writeToFile(fileName, list);
                    FileUtil.displayFileAttributes(fileName);
                    FileUtil.randomAccessRead(fileName);

                    System.out.println("Saved. Exiting...");
                    break;
            }

        } while (ch != 6);

        sc.close();
    }
}

