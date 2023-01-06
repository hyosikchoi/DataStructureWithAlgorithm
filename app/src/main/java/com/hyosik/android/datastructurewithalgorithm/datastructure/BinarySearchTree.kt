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
            } else if(it.getData() < data) {
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


    /** 데이터 삭제 */
    fun remove(targetData : Int) : BinaryTree? {
        // 루트노드를 제거할 때 사용하기 위한 페이크 노드
        var fakeParentRootNode = BinaryTree(0)

        var parentNode = fakeParentRootNode
        var currentNode = this.rootNode
        var deletingNode : BinaryTree ?= null


        fakeParentRootNode.setRightSubTree(this.rootNode)

        // 제거한 노드를 담아서 함수에서 반환할 때 넘겨준다.(왼쪽 오른쪽은 상관이 없음.)
        // 제거할 노드 위치찾기
        while(currentNode != null && currentNode.getData() != targetData) {
            parentNode = currentNode

           currentNode = if(currentNode.getData() > targetData) {
                currentNode.getLeftSubTree()
            } else if(currentNode.getData() < targetData) {
                currentNode.getRightSubTree()
           } else {
               break
           }
        }

        // 1.제거할 노드가 없는 경우(null) , 2.있는 경우(notNull)
        // 1번 경우
        if(currentNode == null) {
            return null
        }

        // 2번 경우 (2번 경우에는 삭제 시켜야하는데 3가지 조건이 이 있다.)
        deletingNode = currentNode

        /** 삭제의 첫번째 조건인 터미널 노드인 경우(왼쪽 오른쪽 둘다 자식 노드가 없는 상태) */
        if(deletingNode.getLeftSubTree() == null && deletingNode.getRightSubTree() == null) {
            if(parentNode.getLeftSubTree() == deletingNode) {
                parentNode.removeLeftSubTree()
            } else {
                parentNode.removeRightSubTree()
            }
        }

        /** 삭제의 두번째 조건인 자식노드가 한쪽만 있는 경우 */
       else if(deletingNode.getLeftSubTree() == null || deletingNode.getRightSubTree() == null) {
            /** 제거할 노드의 자식 노드를 담는 변수 */
            var deletingChildNode : BinaryTree ?= null

            /** 제거할 노드의 자식 노드를 찾는다. */
            if(deletingNode.getLeftSubTree() != null) {
                deletingChildNode = deletingNode.getLeftSubTree()
            } else {
                deletingChildNode = deletingNode.getRightSubTree()
            }

            /** 제거할 노드의 자식 노드와 제거할 노드의 부모노드와 연결만 해주면 된다. */
            /** 그러면 자식노드가 한쪽만 있는 경우에는 삭제가 된다. */
            if(parentNode.getLeftSubTree() == deletingNode) {
                parentNode.setLeftSubTree(deletingChildNode)
            } else {
                parentNode.setRightSubTree(deletingChildNode)
            }
        }
        /** 삭제의 세번째 조건인 자식노드가 둘다 있는 경우 */
        /** 삭제할 타겟 노드의 왼쪽에서 젤큰 노드 혹은 오른쪽에서 젤 작은 노드 중 선택 (지금은 왼쪽) */
        else {
            var replacingNode = deletingNode.getLeftSubTree()
            var replacingNodeParent = deletingNode

            /** 왼쪽에서 젤 큰 노드는 왼쪽노드(위에서 replacingNode) 에서 가장 오른쪽 노드를 찾는다. */
            while(replacingNode?.getRightSubTree() != null) {
                replacingNodeParent = replacingNode
                replacingNode = replacingNode.getRightSubTree()
            }

            /** 삭제된 노드는 반환용도로 (deletingNodeData) 삭제 될 노드의 위치에는 대체될 노드의 값으로 바꿔준다. */
            /**  deletingNode = currentNode 하고 있으므로  deletingNode.setData(replacingNode!!.getData()) 경우에는 */
            /** call by reference 로 currentNode(제거할 노드 위치) 값에도 setData 가 영향을 끼치게 된다.(중요!!) */
            var deletingNodeData = deletingNode.getData()
            deletingNode.setData(replacingNode!!.getData())

            /** 그리고 replacingNodeParent 의 왼쪽 노드가 replacingNode 라면  replacingNode 의 왼쪽 노드를 */
            /** replacingNodeParent 의 왼쪽 노드 에 대체한다. 그리고 오른쪽이라면 오른쪽에 replacingNode 의 왼쪽 노드를 셋팅한다. */
            /** replacingNode 의 왼쪽 노드만 신경 쓰는 이유는 이미 위에 while 문에서 가장 오른쪽 노드를 찾았기 때문에 이 값보다 큰 값은 없기 때문이다. */
            if(replacingNodeParent?.getLeftSubTree() == replacingNode) {
                replacingNodeParent?.setLeftSubTree(replacingNode?.getLeftSubTree())
            } else {
                replacingNodeParent?.setRightSubTree(replacingNode?.getLeftSubTree())
            }

            /** 마찬가지로 call by reference 로 currentNode(제거할 노드 위치) 값에 영향 끼치지 않게 하기 위해 참조를 replacingNode 로 바꾼다. */
            deletingNode = replacingNode.copy()
            deletingNode?.setData(deletingNodeData)

        }

        /** 예외 경우  */
        /** 우리는 노드를 제거할 때 노드가 부모노드를 가지고 있다는 가정을 했다. */
        /** 혹시라도 루트노드가 제거된 경우라면 부모노드가 없으므로 */
        if(fakeParentRootNode.getRightSubTree() != this.rootNode) {
            this.rootNode = fakeParentRootNode.getRightSubTree()
        }

        return deletingNode
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

    /** 데이터 삭제 */
    println(binarySearchTree.remove(3))
    println(binarySearchTree.rootNode?.inOrderTraversal(binarySearchTree.rootNode))
}