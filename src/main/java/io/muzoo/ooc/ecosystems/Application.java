package io.muzoo.ooc.ecosystems;

public class Application {
    public static void main(String[] args) {
        SimulatorFactory simulatorFactory = new SimulatorFactory();
        Simulator sim = simulatorFactory.create(100,180);
        sim.simulate(500);
        System.exit(0);
    }

}
