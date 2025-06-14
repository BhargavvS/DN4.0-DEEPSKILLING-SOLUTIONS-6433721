package BuilderPatternExample;

public class ComputerBuilder {
    private int cpu;
    private int ram;
    private int storage;
    private String processor;
    private int battery;

    public ComputerBuilder setStorage(int storage) {
        this.storage = storage;
        return this;
    }

    public ComputerBuilder setBattery(int battery) {
        this.battery = battery;
        return this;
    }

    public ComputerBuilder getCpu(int cpu) {
        this.cpu = cpu;
        return this;
    }

    public ComputerBuilder setRam(int ram) {
        this.ram = ram;
        return this;
    }

    public ComputerBuilder setProcessor(String processor) {
        this.processor = processor;
        return this;
    }

    public Computer build() {
        return new Computer(cpu,ram,storage,processor,battery);
    }

}
