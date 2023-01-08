package com.hyosik.android.datastructurewithalgorithm.datastructure

/**
 * 트리 구조는 하나의 노드에서 나무가 가지를 치듯이 내려가는 구조
 */

/**
 * 이진 트리(Binary Tree)
 * 하나의 노드가 2개 이하의 노드를 가지고 있는 경우
 */
/**
 * 포화 이진 트리 (트리의 최대 레벨에 있는 모든 터미널 노드가 꽉 찬 트리)
 * 완전 이진 트리 (최대 레벨을 제외한 나머지 레벨에는 모두 채워져 있고, 최대 레벨의 노드들은 왼쪽부터 채워진 트리)
 */
/**
 * 이진 트리 사용처
 * 이진 트리는 컴파일러가 사용하는 구문 트리를 만들거나 JPEG , MPEG 파일을 만드는 압축 알고리즘인
 * 허프만 트리를 만들 때 유용하게 쓰입니다.
 */
data class BinaryTree(
    var data : Int,
    var leftSubTree : BinaryTree ?= null,
    var rightSubTree : BinaryTree ?= null
) {

    @JvmName("getData1")
    fun getData() : Int {
        return this.data
    }

    @JvmName("setData1")
    fun setData(data: Int) {
        this.data = data
    }

    @JvmName("getLeftSubTree1")
    fun getLeftSubTree() : BinaryTree? {
        return this.leftSubTree
    }

    @JvmName("getRightSubTree1")
    fun getRightSubTree() : BinaryTree? {
        return this.rightSubTree
    }

    @JvmName("setLeftSubTree1")
    fun setLeftSubTree(tree : BinaryTree?) {
        this.leftSubTree = tree
    }

    @JvmName("setRightSubTree1")
    fun setRightSubTree(tree : BinaryTree?) {
        this.rightSubTree = tree
    }
    /** 전위순회 : 루트노드를 먼저 출력하고 왼쪽 , 오른쪽을 재귀로 접근 */
    fun preOrderTraversal(tree : BinaryTree?) {
        /** 재귀 호출이므로 기저조건을 넣어준다. */
        if (tree == null) return
        println(tree.data)
        this.preOrderTraversal(tree.getLeftSubTree())
        this.preOrderTraversal(tree.getRightSubTree())
    }
    /** 중위순회 : 루트노드의 왼쪽 먼저 출력하고 루트노드 , 오른쪽을 재귀로 접근 */
    fun inOrderTraversal(tree: BinaryTree?) {
        if(tree == null) return

        this.inOrderTraversal(tree.getLeftSubTree())
        println(tree.data)
        this.inOrderTraversal(tree.getRightSubTree())
    }

    /** 후위순회 : 루트노드의 오른쪽 먼저 출력하고  */
    fun postOrderTraversal(tree : BinaryTree?) {
        if(tree == null) return

        this.postOrderTraversal(tree.getLeftSubTree())
        this.postOrderTraversal(tree.getRightSubTree())
        println(tree.data)

    }

    fun removeLeftSubTree() : BinaryTree? {
        // 제거할 노드는 반환해야 하므로 지역변수에 저장
        val deletingNode = this.getLeftSubTree()
        // 그리고 자식변수는 제거할 것이므로 null 지정
        this.setLeftSubTree(null)

        return deletingNode
    }

    fun removeRightSubTree() : BinaryTree? {
        // 제거할 노드는 반환해야 하므로 지역변수에 저장
        val deletingNode = this.getRightSubTree()
        // 그리고 자식변수는 제거할 것이므로 null 지정
        this.setRightSubTree(null)

        return deletingNode
    }

}

fun main() {
    val tree1 = BinaryTree(1)
    val tree2 = BinaryTree(2)
    val tree3 = BinaryTree(3)
    val tree4 = BinaryTree(4)
    val tree5 = BinaryTree(5)
    val tree6 = BinaryTree(6)
    val tree7 = BinaryTree(7)

    tree1.setLeftSubTree(tree2)
    tree1.setRightSubTree(tree3)
    tree2.setLeftSubTree(tree4)
    tree2.setRightSubTree(tree5)
    tree3.setLeftSubTree(tree6)
    tree3.setRightSubTree(tree7)

    println("루트노드의 오른쪽 자식 노드 : ${tree1.getRightSubTree()?.data}")
    println("루트노드의 오른쪽 자식 노드의 왼쪽 자식노드 : ${tree3.getLeftSubTree()?.data}")

    // 순회
    println("전위 순회")
    tree1.preOrderTraversal(tree1)
    println("중위 순회")
    tree1.inOrderTraversal(tree1)
    println("후위 순회")
    tree1.postOrderTraversal(tree1)
}