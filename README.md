# JavaDataStructure

Java实现基本数据结构

### Array

### Queue

- 队列（数组实现）
- 循环队列（数组实现）
    
### Stack
    
- 数组实现
    
### LinkedList

- LinkedList
- LinkedListStack
- LinkedListQueue
   
### BinarySearchTree

- preOrder() 前序遍历
- inOrder() 中序遍历
- postOrder() 后序遍历
  
### Heap

- MaxHeap(底层用动态数组)
   
### PriorityQueue

- 底层MaxHeap
   
### Set
    
无重复元素

- 链表实现 

    - add（） O（1）为了保证不重复 首先需要查找O(N) 最终时间复杂度O(N) 
    - contains() O(N) 
    - remove（）O(N) 

- 二分搜索树实现
    
    - add()
        复杂度：二分搜索树 O(H) h为搜索树的高度  2^(h-1) + ··· + 2^0 = 2 ^ h  - 1 = n 
        O(h) = O(log2n)
    - contains()
        复杂度：O(H) h为搜索树的高度 O(logN)
    - remove()
        复杂度：O(H) h为搜索树的高度 O(logN)    
    - logN 和 N 的区别
        随着N的增大 越差越大
   
-  二分搜索树 退化成链表（按照顺序排列）

- Leetcode issue

    - 804 摩斯密码问题
    
- 有序集合 无序集合

    - 有序集合 的元素具有顺序性  (搜索树)
    - 无序集合中的元素没有顺序性 （基于哈希表）
    
- 多重集合

    允许容纳重复元素
    
### Map 映射 存储键值对的数据结构

- 链表 LinkedMap<K,V>

- 二份搜索树 BSTreeMap<K,V>






   
