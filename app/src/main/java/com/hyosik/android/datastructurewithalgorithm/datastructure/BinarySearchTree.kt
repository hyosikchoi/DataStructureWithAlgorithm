package com.hyosik.android.datastructurewithalgorithm.datastructure


/**
 * 이진 탐색 트리
 * 장점1 : 데이터 삽입 , 제거 , 검색이 빠름
 * 장점2 : 메모리도 해시 테이블보다 적게 요구함
 *
 * 규칙
 * 1. 중복된 노드가 없어야함 (즉 데이터 5가 담긴 노드가 있다면 이 트리에는 5를 더 이상 추가할 수 없습니다.)
 * 2. 특정 노드의 왼쪽 자식노드는 그 노드의 값보다 항상 작은 값들로만 이루어짐.
 * 3. 특정 노드의 오른쪽 자식노드는 그 노드의 값보다 항상 큰 값들로만 이루어짐.
 * 4. 모든 자식트리 노드에도 위의 1,2,3 규칙이 적용 되어야 한다.
 *
 * 이진 탐색 트리의 기능
 * 1. 데이터 삽입
 * 2. 데이터 제거
 * 3. 데이터 탐색
 */

data class BinarySearchTree(
    var rootNode : BinaryTree? = null
) {
    /** 데이터 삽입 */
    fun insert(data : Int) {
        if(rootNode == null) {
            rootNode = BinaryTree(data = data)
        }

        /** 현재 노드 */
        var currentNode = rootNode
        /** 현재 노드의 부모 노드 */
        var parentNode : BinaryTree?= null

        /** 삽입을 할 위치 찾기 */
        while(currentNode != null) {
            /** 처음엔 루트 노드 위에 부모노드가 없으므로 현재 노드로 설정 */
            parentNode = currentNode

            currentNode = if(currentNode.getData() > data) {
                currentNode.getLeftSubTree()
            } else if(currentNode.getData() < data) {
                currentNode.getRightSubTree()
            } else {
                break
            }
        }

        /** 위치를 찾았다면 삽입 해준다. */
        val newNode = BinaryTree(data)
        parentNode?.let {
            if(it.getData() > data) {
                it.setLeftSubTree(newNode)
            } else {
                it.setRightSubTree(newNode)
            }
        }
    }
    /** 데이터 검색 */
    fun search(targetData: Int) : Int? {
        var currentNode = rootNode

        while(currentNode != null) {
            currentNode = if(currentNode.getData() == targetData) {
                break
            } else if(currentNode.getData() > targetData) {
                currentNode.getLeftSubTree()
            } else {
                currentNode.getRightSubTree()
            }
        }

        return currentNode?.data

    }

}

fun main() {

    val binarySearchTree = BinarySearchTree()
    /** 데이터 삽입 */
    /** 순서 중요! */
    binarySearchTree.insert(18)
    binarySearchTree.insert(15)
    binarySearchTree.insert(10)
    binarySearchTree.insert(6)
    binarySearchTree.insert(3)
    binarySearchTree.insert(8)
    binarySearchTree.insert(12)
    binarySearchTree.insert(11)
    binarySearchTree.insert(31)
    binarySearchTree.insert(27)
    binarySearchTree.insert(24)
    binarySearchTree.insert(20)
    binarySearchTree.insert(33)
    binarySearchTree.insert(35)
    binarySearchTree.insert(37)
    /** 중위 순회 */
    binarySearchTree.rootNode?.inOrderTraversal(binarySearchTree.rootNode)

    /** 데이터 검색 */
    println("============ Search 6 ============")
    println(binarySearchTree.search(6))
    println("============ Search 2 ============")
    println(binarySearchTree.search(2))

}