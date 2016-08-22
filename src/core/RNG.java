package core;

public class RNG {
    protected java.util.Random rnd;

    public RNG(int seed) {
        seed(seed);
    }

    public void seed(int seed) {
        this.rnd = new java.util.Random(seed);
    }

    public double uniformFloat() {
        return this.rnd.nextDouble();
    }
}
