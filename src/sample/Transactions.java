package sample;

import java.util.LinkedList;

public class Transactions {

    LinkedList<String> linkedList = new LinkedList<>();
    LinkedList<Double> doublelist = new LinkedList<>();

    private String x;
    private Double y;

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = linkedList.getLast();
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = doublelist.getLast();
    }

    public void LinkedString(String type) {
        linkedList.add(type);
        if (linkedList.size() > 5) {
            linkedList.remove();
        }
        System.out.println(" " + linkedList);
    }

    public void DoubleString(double amount) {
        doublelist.add(amount);
        if (doublelist.size() > 5) {
            doublelist.remove();
        }
        System.out.println(" " + doublelist);
    }

    public String getNextString() {
        int idx = linkedList.indexOf(getX());
        return linkedList.get(++idx);
    }

    public String getPreviousString() {
        int idx = linkedList.indexOf(getX());
        return linkedList.get(--idx);
    }

    public double getNextDouble() {
        int idx = doublelist.indexOf(getY());
        return doublelist.get(++idx);
    }

    public double getPreviousDouble() {
        int idx = doublelist.indexOf(getY());
        return doublelist.get(--idx);
    }
}
