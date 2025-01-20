import java.util.*;
import java.io.*;

public class StudentAndCourseManagementSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int systemSelected;

        do {
            System.out.println("Welcome to the Student and Course Management System!");
            System.out.println("1: Student Management System (SMS)");
            System.out.println("2: Course Management System (CMS)");
            System.out.println("0: Exit");
            
            systemSelected = getValidIntInput(scanner, "Please enter your choice:", 0, 2);

            switch (systemSelected) {
                case 1 -> handleStudentManagement(scanner);
                case 2 -> handleCourseManagement(scanner);
                case 0 -> System.out.println("Goodbye!");
            }
        } while (systemSelected != 0);

        scanner.close();
    }

    // Handles student management system
    private static void handleStudentManagement(Scanner scanner) {
        List<Student> students = new ArrayList<>();
        List<Student_Employee> studentEmployees = new ArrayList<>();

        int choice;
        do {
            displayStudentMenu();
            choice = getValidIntInput(scanner, "Select an option:", 0, 6);

            switch (choice) {
                case 1 -> {
                    Student newStudent = createNewStudent(scanner);
                    students.add(newStudent);
                    System.out.println("Added: " + newStudent);
                }
                case 2 -> deactivateStudent(scanner, students);
                case 3 -> displayAllStudents(students);
                case 4 -> searchStudentByID(scanner, students);
                case 5 -> assignOnCampusJob(scanner, students, studentEmployees);
                case 6 -> displayStudentEmployees(studentEmployees);
                case 0 -> System.out.println("Exiting SMS");
            }
        } while (choice != 0);
    }

    // Handles course management system
    private static void handleCourseManagement(Scanner scanner) {
        List<Course> courses = loadCourses();
        Map<Integer, List<Course>> studentCourses = new HashMap<>();

        int choice;
        do {
            displayCourseMenu();
            choice = getValidIntInput(scanner, "Select an option:", 0, 3);

            switch (choice) {
                case 1 -> addNewCourse(scanner, courses);
                case 2 -> assignCourseToStudent(scanner, courses, studentCourses);
                case 3 -> displayStudentsWithCourses(studentCourses);
                case 0 -> System.out.println("Exiting CMS");
            }
        } while (choice != 0);

        saveCourses(courses);
    }

    // Displays the student menu
    private static void displayStudentMenu() {
        System.out.println("*** Student Management System ***");
        System.out.println("1: Add a student");
        System.out.println("2: Deactivate a student");
        System.out.println("3: Display all students");
        System.out.println("4: Search for a student by ID");
        System.out.println("5: Assign on-campus job");
        System.out.println("6: Display students with on-campus jobs");
        System.out.println("0: Exit SMS");
    }

    // Displays the course menu
    private static void displayCourseMenu() {
        System.out.println("*** Course Management System ***");
        System.out.println("1: Add a new course");
        System.out.println("2: Assign a course to a student");
        System.out.println("3: Display students with assigned courses");
        System.out.println("0: Exit CMS");
    }

    // Creates a new student
    private static Student createNewStudent(Scanner scanner) {
        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter level: ");
        String level = scanner.nextLine();
        int studentID = new Random().nextInt(10000);
        return new Student(studentID, firstName, lastName, level);
    }

    // Deactivates a student
    private static void deactivateStudent(Scanner scanner, List<Student> students) {
        int id = getValidIntInput(scanner, "Enter student ID to deactivate:");
        for (Student student : students) {
            if (student.getStudentID() == id) {
                student.setActive(false);
                System.out.println("Deactivated: " + student);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Displays all students
    private static void displayAllStudents(List<Student> students) {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        for (Student student : students) {
            System.out.println(student);
        }
    }

    // Searches for a student by ID
    private static void searchStudentByID(Scanner scanner, List<Student> students) {
        int id = getValidIntInput(scanner, "Enter student ID to search:");
        for (Student student : students) {
            if (student.getStudentID() == id) {
                System.out.println(student);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Assigns an on-campus job
    private static void assignOnCampusJob(Scanner scanner, List<Student> students, List<Student_Employee> studentEmployees) {
        int id = getValidIntInput(scanner, "Enter student ID:");
        for (Student student : students) {
            if (student.getStudentID() == id) {
                System.out.print("Enter job title: ");
                String jobTitle = scanner.nextLine();
                System.out.print("Enter job type: ");
                String jobType = scanner.nextLine();
                Student_Employee employee = new Student_Employee(student, jobTitle, jobType);
                studentEmployees.add(employee);
                System.out.println("Assigned: " + employee);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    // Displays students with on-campus jobs
    private static void displayStudentEmployees(List<Student_Employee> studentEmployees) {
        if (studentEmployees.isEmpty()) {
            System.out.println("No student employees found.");
            return;
        }
        for (Student_Employee employee : studentEmployees) {
            System.out.println(employee);
        }
    }

    // Adds a new course
    private static void addNewCourse(Scanner scanner, List<Course> courses) {
        System.out.print("Enter course ID: ");
        String courseID = scanner.nextLine();
        System.out.print("Enter course name: ");
        String courseName = scanner.nextLine();
        courses.add(new Course(courseID, courseName));
        System.out.println("Added course: " + courseID + " - " + courseName);
    }

    // Assigns a course to a student
    private static void assignCourseToStudent(Scanner scanner, List<Course> courses, Map<Integer, List<Course>> studentCourses) {
        int studentID = getValidIntInput(scanner, "Enter student ID:");
        System.out.print("Enter course ID: ");
        String courseID = scanner.nextLine();

        for (Course course : courses) {
            if (course.getCourseID().equals(courseID)) {
                studentCourses.putIfAbsent(studentID, new ArrayList<>());
                studentCourses.get(studentID).add(course);
                System.out.println("Assigned course: " + course);
                return;
            }
        }
        System.out.println("Course not found.");
    }

    // Displays students with their assigned courses
    private static void displayStudentsWithCourses(Map<Integer, List<Course>> studentCourses) {
        if (studentCourses.isEmpty()) {
            System.out.println("No courses assigned.");
            return;
        }
        for (Map.Entry<Integer, List<Course>> entry : studentCourses.entrySet()) {
            System.out.println("Student ID: " + entry.getKey());
            for (Course course : entry.getValue()) {
                System.out.println("  - " + course);
            }
        }
    }

    // Loads courses from a file
    private static List<Course> loadCourses() {
        List<Course> courses = new ArrayList<>();
        try (Scanner fileScanner = new Scanner(new File("courses.txt"))) {
            while (fileScanner.hasNextLine()) {
                String[] parts = fileScanner.nextLine().split(" ", 2);
                if (parts.length == 2) {
                    courses.add(new Course(parts[0], parts[1]));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No courses found. Starting fresh.");
        }
        return courses;
    }

    // Saves courses to a file
    private static void saveCourses(List<Course> courses) {
        try (PrintWriter writer = new PrintWriter("courses.txt")) {
            for (Course course : courses) {
                writer.println(course.getCourseID() + " " + course.getCourseName());
            }
        } catch (IOException e) {
            System.out.println("Error saving courses.");
        }
    }

    // Gets a valid integer input
    private static int getValidIntInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt + " ");
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    // Overloaded version with range
    private static int getValidIntInput(Scanner scanner, String prompt, int min, int max) {
        while (true) {
            int value = getValidIntInput(scanner, prompt);
            if (value >= min && value <= max) {
                return value;
            }
            System.out.println("Please enter a number between " + min + " and " + max + ".");
        }
    }
}

class Student {
    private final int studentID;
    private final String firstName;
    private final String lastName;
    private final String studentLevel;
    private boolean isActive;

    public Student(int studentID, String firstName, String lastName, String studentLevel) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentLevel = studentLevel;
        this.isActive = true;
    }

    public int getStudentID() {
        return studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getStudentLevel() {
        return studentLevel;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (ID: " + studentID + ", Level: " + studentLevel + ", Status: " + (isActive ? "Active" : "Inactive") + ")";
    }
}

class Student_Employee extends Student {
    private final String jobTitle;
    private final String jobType;

    public Student_Employee(Student student, String jobTitle, String jobType) {
        super(student.getStudentID(), student.getFirstName(), student.getLastName(), student.getStudentLevel());
        this.jobTitle = jobTitle;
        this.jobType = jobType;
    }

    @Override
    public String toString() {
        return super.toString() + " - Job: " + jobTitle + " (" + jobType + ")";
    }
}

class Course {
    private final String courseID;
    private final String courseName;

    public Course(String courseID, String courseName) {
        this.courseID = courseID;
        this.courseName = courseName;
    }

    public String getCourseID() {
        return courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    @Override
    public String toString() {
        return courseID + " - " + courseName;
    }
}
