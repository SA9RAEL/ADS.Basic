package ADS.Basic.src.main.kotlin

class LinkedList {
    var first: Node? = null

    private val lastNode: Node?
        get() {
            var currentNode: Node? = first
            while (currentNode?.next != null) {
                currentNode = currentNode.next
            }
            return currentNode
        }
    val size: Int
        get() {
            var count = 0
            var currentNode = first
            while (currentNode != null) {
                count++
                currentNode = currentNode.next
            }
            return count
        }

    fun add(data: String) {
        val newNode = Node(data, null)
        if (first == null) {
            first = newNode
        } else {
            lastNode!!.next = newNode
        }
    }

    fun get(index: Int): String {
        var currentNode = first
        repeat(index){
            currentNode = currentNode!!.next
        }
        return currentNode!!.data
    }

    fun remove(index: Int) {
        if (index == 0) {
            first = first?.next
            return
        }

        var before = first
        repeat(index - 1) {
            before = before?.next
        }


        before?.next = before?.next?.next
    }
}

class Node(val data: String, var next: Node?)
