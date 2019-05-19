package io.muzoo.ooc.ecosystems;

public class SimulatorFactory {
    public Simulator create(int dept, int width){ return new Simulator(dept,width);}
}
