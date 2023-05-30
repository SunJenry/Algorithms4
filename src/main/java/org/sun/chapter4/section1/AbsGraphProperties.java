package org.sun.chapter4.section1;

public abstract class AbsGraphProperties {
    public AbsGraphProperties(AbsGraph G) {
    }

    public abstract int eccentricity(int v);

    public abstract int diameter();

    public abstract int radius();

    public abstract int center();
}
