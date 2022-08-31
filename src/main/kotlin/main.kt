package ADS.Basic.src.main.kotlin

fun main() {
    val list = DynamicArray()
    var n = 15
    repeat(n) {
        list.add(n--)
    }

    println(list)
    list.remove(13)
    list.remove(12)
    list.remove(11)
    list.remove(10)
    list.remove(9)
    list.remove(8)
    list.remove(7)
    list.remove(6)
    println(list)

    val node1 = Node("Один")
    val node2 = Node("Два")
    val node3 = Node("Три")
    val node4 = Node("Четыре")


    val double = DoubleLinkedList()
    double.add(node1)
    double.add(node2)
    double.add(node3)
    double.add(node4)
    println("Второй элемент до удаления: ${double.get(2)}")
    double.remove(2)
    println("Второй элемент после удаления: ${double.get(2)}")
    double.printList()

}