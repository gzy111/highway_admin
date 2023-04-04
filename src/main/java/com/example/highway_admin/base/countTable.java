package com.example.highway_admin.base;

public class countTable {

    private String maxName;
    private String minName;
    private int count;

    public String getMaxName() {
        return maxName;
    }

    public void setMaxName(String maxName) {
        this.maxName = maxName;
    }

    public String getMinName() {
        return minName;
    }

    public void setMinName(String minName) {
        this.minName = minName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "countTable{" +
                "maxName='" + maxName + '\'' +
                ", minName='" + minName + '\'' +
                ", count=" + count +
                '}';
    }
}
