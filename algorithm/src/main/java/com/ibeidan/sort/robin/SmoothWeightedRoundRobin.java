package com.ibeidan.sort.robin;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lee
 * DATE 2020/8/4 20:45
 * 在Nginx加权轮询算法中，每个节点有三个权重变量
 * weight : 配置的权重，即在配置文件或初始化时约定好的每个节点的权重
 * currentWeight : 节点当前权重，会一直变化
 * effectiveWeight ：有效权重，初始值为weight, 通讯过程中发现节点异常，则-1 ，之后再次选取本节点，调用成功一次则+1，直达恢复到weight 。 用于健康检查，处理异常节点，降低其权重。
 * 算法逻辑
 * (1) 轮询所有节点，计算当前状态下所有节点的 effectiveWeight之和totalWeight；
 * (2) currentWeight = currentWeight + effectiveWeight; 选出所有节点中currentWeight中最大的一个节点作为选中节点；
 * (3) 选中节点的currentWeight = currentWeight - totalWeight；
 * 注：（为了简单清晰，后面的实现不考虑健康检查effectiveWeight这个功能实现，假设所有节点都是100%可用，所以上面的逻辑要把使用effectiveWeight的地方换成weight
 * totaoWeight = 4 + 3 + 2 = 9 ,
 * 第一次请求 serverA= 4 + 4(原始比重) = 8 ,serverB= 3+3(原始比重) = 6,serverC= 2+2(原始比重) = 4 ， 最大的是serverA , 所以 serverA= 8 - 9 (权重总和) = -1 ，所以最后值为 serverA= -1,serverB= 6,serverC= 4
 * 第二次请求 serverA= -1 + 4(原始比重) = 3 ,serverB= 6+3(原始比重) = 9,serverC= 4+2(原始比重) = 6 ， 最大的是serverB , 所以 serverB= 9 - 9 (权重总和) = 0 ，所以最后值为 serverA= 3,serverB= 0,serverC= 6
 **/

public class SmoothWeightedRoundRobin {
    private volatile List<Node> nodeList = new ArrayList<Node>() ; // 保存权重
    private ReentrantLock lock = new ReentrantLock() ;

    public SmoothWeightedRoundRobin(Node ...nodes) {
        for (Node node : nodes) {
            nodeList.add(node) ;
        }
    }

    public Node select(){
        try {
            lock.lock();
            return this.selectInner() ;
        }finally {
            lock.unlock();
        }
    }

    private Node selectInner(){
        int totalWeight = 0 ;
        Node maxNode = null ;
        int maxWeight = 0 ;

        for (int i = 0; i < nodeList.size(); i++) {
            Node n = nodeList.get(i);
            totalWeight += n.getWeight() ;

            // 每个节点的当前权重要加上原始的权重
            n.setCurrentWeight(n.getCurrentWeight() + n.getWeight());

            // 保存当前权重最大的节点
            if (maxNode == null || maxWeight < n.getCurrentWeight() ) {
                maxNode = n ;
                maxWeight = n.getCurrentWeight() ;
            }
        }
        // 被选中的节点权重减掉总权重
        maxNode.setCurrentWeight(maxNode.getCurrentWeight() - totalWeight);

//        nodeList.forEach(node -> System.out.print(node.getCurrentWeight()));
        return maxNode ;
    }


    public static void main(String[] args) {
        /**
         * 假设有三个服务器权重配置如下：
         * server A  weight = 4 ;
         * server B  weight = 3 ;
         * server C  weight = 2 ;
         */
        Node serverA = new Node("serverA", 9);
        Node serverB = new Node("serverB", 1);
        Node serverC = new Node("serverC", 2);

        SmoothWeightedRoundRobin smoothWeightedRoundRobin = new SmoothWeightedRoundRobin(serverA,serverB ,serverC);
        for (int i = 0; i < 10; i++) {
            Node i1 = smoothWeightedRoundRobin.select();
            System.out.println(i1.getServerName());
        }
    }

}
