import java.util.*;

public class StudentManager {
    private ArrayList<Student> students;

    public StudentManager(ArrayList<Student> students) {
        this.students = students;
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public void viewAll() {
        for (Student s : students) {
            System.out.println(s);
        }
    }

    public void searchByName(String name) {
        for (Student s : students) {
            if (s.getName().equalsIgnoreCase(name)) {
                System.out.println("Found: " + s);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void deleteByName(String name) {
        Iterator<Student> it = students.iterator();
        while (it.hasNext()) {
            Student s = it.next();
            if (s.getName().equalsIgnoreCase(name)) {
                it.remove();
                System.out.println("Deleted Successfully.");
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void sortByMarks() {
        students.sort(Comparator.comparingDouble(Student::getMarks).reversed());
        System.out.println("Sorted by Marks.");
    }
}

