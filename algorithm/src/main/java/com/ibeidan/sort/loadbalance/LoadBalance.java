package com.ibeidan.sort.loadbalance;

import com.ibeidan.sort.robin.Node;

import java.util.List;

/**
 * @author libeibei
 * 2020/10/9 15:04
 * 负载均衡算法选择器
 **/
public interface LoadBalance {



    Node select(List<Node> nodeList);

}
