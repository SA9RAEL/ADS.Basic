package ADS.Basic.src.main.kotlin

fun hashMapImpl() {
    /**
     * Пример реализации HashMap в Котлине
     * Для примера ключом будет модель айфона,
     * а значением "цена".
     *
     * Инициализация изначально пустой коллекции:
     */
    val hashMap: HashMap<String, Int> = HashMap()

    /**
     * Вывод пустой ХМ:
     */
    print("$hashMap\n")

    /**
     * Добавление элементов в коллекцию:
     */
    hashMap.put("IPhone11", 35000)
    hashMap.put("IPhone12", 45000)
    hashMap.put("IPhone13", 55000)
    hashMap.put("IPhone14", 95000)
    hashMap.put("IPhone15", 125000)

    /**
     * Вывод не-пустого HashMap
     */
    println("Телефоны и цена: $hashMap\n")

    /**
     * Обход (и вывод) информации по ключу в цикле:
     */
    for (key in hashMap.keys) {
        println("Цена за $key : ${hashMap[key]}")
    }

    /**
     * Создание второго ХМ, копирующего значения первого
     */
    val secondHashMap: HashMap<String, Int> = HashMap(hashMap)
    println("\nВторая коллекция:\n ")
    for (key in secondHashMap.keys) {
        println("Цена за $key : ${hashMap.get(key)}") // можно и через get
    }

    /**
     * Выводит размер коллекции
     */
    println("\n Размер коллекции: ${hashMap.size}\n")

    /**
     * Удаление элемента по ключу:
     */
    hashMap.remove("IPhone12")
    /**
     * Изменение значения указанного ключа:
     */
    hashMap.replace("IPhone13", 76990)
    hashMap.put("IPhone11", 89990)
    hashMap["IPhone15"] = 34500

    for (key in hashMap.keys) {
        println("Цена после изменения на $key : ${hashMap[key]} ")
    }


    /**
     * Очистка коллекции.
     */
    hashMap.clear()
    println(if (hashMap.isEmpty()) "\nКоллекция пуста" else "$hashMap")
}