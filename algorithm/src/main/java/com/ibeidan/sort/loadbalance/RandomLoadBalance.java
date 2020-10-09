package com.ibeidan.sort.loadbalance;

import com.ibeidan.sort.robin.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author lee
 * DATE 2020/10/9 15:57
 * RandomLoadBalance 的算法思想比较简单，在经过多次请求后，能够将调用请求按照权重值进行“均匀”分配
 * RandomLoadBalance 是一个简单，高效的负载均衡实现
 */
public class RandomLoadBalance extends AbstractLoadBalance {


    private final Random random = new Random();

    protected Node doSelect(List<Node> nodeList) {
        int length = nodeList.size();
        int totalWeight = 0;
        boolean sameWeight = true;
        // 下面这个循环有两个作用，第一是计算总权重 totalWeight，
        // 第二是检测每个服务提供者的权重是否相同
        for (int i = 0; i < length; i++) {
            int weight = getWeight(nodeList.get(i));
            // 累加权重
            totalWeight += weight;
            // 检测当前服务提供者的权重与上一个服务提供者的权重是否相同，
            // 不相同的话，则将 sameWeight 置为 false。
            if (sameWeight && i > 0 && weight != getWeight(nodeList.get(i-1))) {
                sameWeight = false;
            }
        }
        // 下面的 if 分支主要用于获取随机数，并计算随机数落在哪个区间上
        if (totalWeight >0 && !sameWeight) {
            // 随机获取一个 [0, totalWeight) 区间内的数字
            int offset = random.nextInt(totalWeight);
            // 循环让 offset 数减去服务提供者权重值，当 offset 小于0时，返回相应的 node。
            // 举例说明一下，我们有 servers = [A, B, C]，weights = [5, 3, 2]，offset = 7。
            // 第一次循环，offset - 5 = 2 > 0，即 offset > 5
            // 表明其不会落在服务器 A 对应的区间上。
            // 第二次循环，offset - 3 = -1 < 0，即 5 < offset < 8，
            // 表明其会落在服务器 B 对应的区间上
            for (int i = 0; i < length; i++) {
                // 让随机值 offset 减去权重值
                offset -= getWeight(nodeList.get(i));
                if (offset < 0) {
                    // 返回相应的 node
                    return nodeList.get(i);
                }
            }
        }

        // 如果所有服务提供者权重值相同，此时直接随机返回一个即可
        return nodeList.get(random.nextInt(length));
    }


    public static void main(String[] args) {
        /**
         * 假设有三个服务器权重配置如下：
         * server A  weight = 4 ;
         * server B  weight = 3 ;
         * server C  weight = 2 ;
         */
        Node serverA = new Node("serverA", 5);
        Node serverB = new Node("serverB", 3);
        Node serverC = new Node("serverC", 2);
        List<Node> nodeList = new ArrayList<Node>();
        nodeList.add(serverA);
        nodeList.add(serverB);
        nodeList.add(serverC);
        AbstractLoadBalance randomLoadBalance = new RandomLoadBalance();
        for (int i = 0; i < 10; i++) {
            Node node =  randomLoadBalance.doSelect(nodeList);
            System.out.println(node.toString());
        }

    }





}
