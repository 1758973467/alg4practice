
* 无向图（简单连接）
* 有向图（连接有方向性）
* 加权图（连接带有权值）
* 加权有向图（连接既有方向又带有权值）

1. 边edge
2. 顶点vertex

特殊的图:
* 自环：一条连接一个顶点和其自身的边
* 平行边：连接同一对顶点的两条边


* 相邻：两个顶点通过一条边相连，并称该连接依附于这两个顶点
* 顶点的度数：依附于此顶点的边的总数
* 连通：两个顶点之间存在一条连接双方的路径，称一个顶点和另一个顶点连通。
* 连通图：如果从任意一个顶点都存在一条路径道路另一任意顶点。一幅非连通的图由若干连通的部分组成
* 树：无环连通图。
* 森林：互不相连的树是森林。
* 密度：已经连接的顶点对占所有可能被连接的顶点对的比例。
* 二分图：能够将所有结点分为两部分的图，其中图的每条边所连接的两个顶点都分别属于不同的部分。

有向图
* 顶点的入度：指向该顶点的边的总数
* 顶点的出度：由该顶点指出的边的总数

多点可达性-标记清除算法
* 拓扑排序：给定一幅有向图，将所有顶点排序，
使得所有的有向边均从排在前面的元素指向排在后面的元素（或者说明无法做到这一点）
* 有向无环图DAG:不含有环的有向图

顶点的排序：
* 前序：
* 后序：
* 逆后序：

* 强连通：两个顶点v,w是互相可达，则称它们为强连通的。
* 强连通图：如果一幅有向图中的任意两个顶点都是强连通的，则这幅有向图是强连通图。
调度问题-拓扑排序
* 终点：出度为0的顶点
* 起点：入度为0的顶点

