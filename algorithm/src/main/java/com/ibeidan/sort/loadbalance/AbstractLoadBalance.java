package com.ibeidan.sort.loadbalance;

import com.ibeidan.sort.robin.Node;

import java.util.List;

/**
 * @author lee
 * DATE 2020/10/9 15:13
 */
public abstract class AbstractLoadBalance implements LoadBalance{


    public Node select(List<Node> nodeList) {

        if (nodeList == null || nodeList.isEmpty())
            return null;
        // 如果 节点 列表中仅有一个 node，直接返回即可，无需进行负载均衡

        if (nodeList.size() == 1)
            return nodeList.get(0);

        // 调用 doSelect 方法进行负载均衡，该方法为抽象方法，由子类实现
        return doSelect(nodeList);

    }

    protected abstract Node doSelect(List<Node> nodeList);



    protected int getWeight(Node node) {
        int weight = node.getWeight();
        return weight;
    }

}
