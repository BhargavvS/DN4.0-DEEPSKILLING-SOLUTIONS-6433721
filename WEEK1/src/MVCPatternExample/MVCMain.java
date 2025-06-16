package MVCPatternExample;

public class MVCMain {
    public static void main(String[] args) {
        // Create model and view
        Student model = new Student("Alice", "S101", "A");
        StudentView view = new StudentView();

        // Create controller
        StudentController controller = new StudentController(model, view);

        // Display initial details
        controller.updateView();

        // Update student data
        controller.setStudentName("Alice Smith");
        controller.setStudentGrade("A+");

        // Display updated details
        System.out.println();
        controller.updateView();
    }
}
