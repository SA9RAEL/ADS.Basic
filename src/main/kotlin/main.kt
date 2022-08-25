package ADS.Basic.src.main.kotlin

fun main() {
//    val list = DynamicArray()
//    var n = 15
//    repeat(n) {
//        list.add(n--)
//    }
//
//    println(list)
//    list.remove(13)
//    list.remove(12)
//    list.remove(11)
//    list.remove(10)
//    list.remove(9)
//    list.remove(8)
//    list.remove(7)
//    list.remove(6)
//    println(list)
    val list = UnionFind(10)
    println(list.find(3))
    println(list.find(5))
    list.union(3,5)
    println(list.find(3))


}