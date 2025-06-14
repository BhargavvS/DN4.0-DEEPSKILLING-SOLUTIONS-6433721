package BuilderPatternExample;

public class ComputerMain {
    public static void main(String[] args) {
        Computer comp = new ComputerBuilder().setRam(16).setProcessor("intel i5").build();
        System.out.println(comp.toString());
    }
}
