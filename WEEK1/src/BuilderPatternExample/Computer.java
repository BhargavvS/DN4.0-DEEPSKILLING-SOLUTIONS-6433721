package BuilderPatternExample;

public class Computer {
    private int cpu;
    private int ram;
    private int storage;
    private String processor;
    private int battery;

    Computer(int cpu, int ram,int storage,String processor, int battery){
        this.cpu = cpu;
        this.ram = ram;
        this.storage = storage;
        this.processor = processor;
        this.battery = battery;
    }

    public String toString() {
        return "Computer [ cpu = " + cpu + ", ram = " + ram + ", storage = " + storage + ", processor = " + processor + " , Battery =" + battery + " ]";
    }
}
