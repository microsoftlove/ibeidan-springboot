package com.ibeidan.sort.robin;

/**
 * @author lee
 * DATE 2020/8/4 20:45
 */
public class Node {
    private final int weight ;  // 初始权重 （保持不变）
    private final String serverName ; // 服务名

    private int currentWeight ; // 当前权重

    public Node( String serverName, int weight) {
        this.weight = weight;
        this.serverName = serverName ;
        this.currentWeight = weight ;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }

    public int getWeight() {
        return weight;
    }

    public void setCurrentWeight(int currentWeight) {
        this.currentWeight = currentWeight;
    }

    public String getServerName() {
        return serverName;
    }

    @Override
    public String toString() {
        return "Node{" +
                "weight=" + weight +
                ", serverName='" + serverName + '\'' +
                ", currentWeight=" + currentWeight +
                '}';
    }
}
