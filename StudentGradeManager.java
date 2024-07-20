import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeManager {

    private ArrayList<Double> grades;

    public StudentGradeManager() {
        grades = new ArrayList<>();
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public double calculateAverage() {
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return grades.size() > 0 ? sum / grades.size() : 0;
    }

    public String getLetterGrade(double average) {
        if (average >= 90) return "A";
        if (average >= 80) return "B";
        if (average >= 70) return "C";
        if (average >= 60) return "D";
        return "F";
    }

    public double calculateGPA(double average) {
        if (average >= 90) return 4.0;
        if (average >= 80) return 3.0;
        if (average >= 70) return 2.0;
        if (average >= 60) return 1.0;
        return 0.0;
    }

    public void displayGrades() {
        System.out.println("Grades:");
        for (double grade : grades) {
            System.out.println(grade);
        }
        double average = calculateAverage();
        System.out.printf("Average Grade: %.2f\n", average);
        System.out.println("Letter Grade: " + getLetterGrade(average));
        System.out.printf("GPA: %.2f\n", calculateGPA(average));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentGradeManager gradeManager = new StudentGradeManager();

        while (true) {
            System.out.println("1. Add grade");
            System.out.println("2. Display grades");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            if (option == 1) {
                System.out.print("Enter grade: ");
                double grade = scanner.nextDouble();
                gradeManager.addGrade(grade);
            } else if (option == 2) {
                gradeManager.displayGrades();
            } else if (option == 3) {
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }
        scanner.close();
    }
}
