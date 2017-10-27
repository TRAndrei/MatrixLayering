package com.calibration.vocabulary;

public class SimulationId {
    private final String id;
    private final SimulationId parent;
    private final int hash;

    public SimulationId(String id, SimulationId parent) {
        this.id = id;
        this.parent = parent;
        this.hash = hash();
    }

    public String getId() {
        return id;
    }

    public SimulationId getParent() {
        return parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        SimulationId that = (SimulationId) o;

        if (hash != that.hash) {
            return false;
        }
        if (!id.equals(that.id)) {
            return false;
        }
        return parent != null ? parent.equals(that.parent) : that.parent == null;
    }

    @Override
    public int hashCode() {
        return hash;
    }

    private int hash() {
        int result = id.hashCode();
        result = 31 * result + (parent != null ? parent.hashCode() : 0);
        return result;
    }
}
