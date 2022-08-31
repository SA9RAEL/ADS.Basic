package ADS.Basic.src.main.kotlin

class DoubleLinkedList {
    /**
     * Инициализация головного узла с пустым значением
     */
    private var head = Node("")

    /**
     * Операция, которая возвращает размер списка,
     * если список пустой - вернёт 0
     * Так как головной узел нельзя переместить,
     * @temp - вспомогательная врЕменная точка обхода
     */
    fun size(head: Node): Int {
        if (head.next == null) {
            return 0
        }
        var temp: Node? = head
        var count = 0
        while (temp?.next != null) {
            temp = temp.next
            count++
        }
        return count
    }

    /**
     * Операция добавления узла в конец списка.
     * При добавлени каждый узел будет иметь ссылку на
     * предыдущий и следующий элементы.
     * Так как головной узел нельзя переместить,
     * @temp - вспомогательная временная точка обхода
     * Обход всего списка, доходим до конца.
     * При выходе из цикла @temp указывает на конец связного списка.
     */
    fun add(node: Node) {
        var temp: Node? = head
        while (temp?.next != null) {
            temp = temp.next
        }
        temp?.next = node
        node.prev = temp
    }

    /**
     * Операция возвращения элемента по его индексу
     * Если указан несуществующий индекс -
     * выбрасывает IndexOutOfBoundsException
     */
    fun get(index: Int): String {
        var currentNode = head
        repeat(index) {
            currentNode = currentNode.next ?: throw IndexOutOfBoundsException("The element was not found")
        }
        return currentNode.data
    }

    /**
     * Операция удаления элемента по указанному индексу
     * Так как головной узел нельзя переместить,
     * @temp - вспомогательная временная точка обхода
     */
    fun remove(index: Int) {
        var temp = head.next
        for (i in 0 until index) {
            if (temp == null) {
                throw IndexOutOfBoundsException("The element was not found")
            }
            if (i == index - 1) {
                temp.prev?.next = temp.next
                if (temp.next != null) {
                    temp.next?.prev = temp.prev
                }
            }
            temp = temp.next
        }
    }

    /**
     * Операция вывода всех значений списка.
     * Обход списка.
     */
    fun printList() {
        if (head.next == null) {
            println("Связанный список пуст")
            return
        }
        var temp = head.next
        while (temp != null) {
            println(temp)
            temp = temp.next
        }
    }

}

class Node(val data: String) {
    var next: Node? = null
    var prev: Node? = null

    override fun toString(): String {
        return "Значение узла = $data"
    }

}

