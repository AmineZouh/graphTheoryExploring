package graphTheory;

import java.util.Objects;

class Road {
    private int node1;
    private int node2;
    private int time;

    public Road(int node1, int node2, int time) {
        this.node1 = node1;
        this.node2 = node2;
        this.time = time;
    }

    // Override equals and hashCode based on desired equality criteria

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Road road = (Road) o;
        return node1 == road.node1 && node2 == road.node2 && time==road.time;
    }

    @Override
    public int hashCode() {
        return Objects.hash(node1, node2, time);
    }

}