package ADS.Basic.src.main.kotlin

fun hashMapImpl() {
    /**
     * ������ ���������� HashMap � �������
     * ��� ������� ������ ����� ������ ������,
     * � ��������� "����".
     *
     * ������������� ���������� ������ ���������:
     */
    val hashMap: HashMap<String, Int> = HashMap()

    /**
     * ����� ������ ��:
     */
    print("$hashMap\n")

    /**
     * ���������� ��������� � ���������:
     */
    hashMap.put("IPhone11", 35000)
    hashMap.put("IPhone12", 45000)
    hashMap.put("IPhone13", 55000)
    hashMap.put("IPhone14", 95000)
    hashMap.put("IPhone15", 125000)

    /**
     * ����� ��-������� HashMap
     */
    println("�������� � ����: $hashMap\n")

    /**
     * ����� (� �����) ���������� �� ����� � �����:
     */
    for (key in hashMap.keys) {
        println("���� �� $key : ${hashMap[key]}")
    }

    /**
     * �������� ������� ��, ����������� �������� �������
     */
    val secondHashMap: HashMap<String, Int> = HashMap(hashMap)
    println("\n������ ���������:\n ")
    for (key in secondHashMap.keys) {
        println("���� �� $key : ${hashMap.get(key)}") // ����� � ����� get
    }

    /**
     * ������� ������ ���������
     */
    println("\n ������ ���������: ${hashMap.size}\n")

    /**
     * �������� �������� �� �����:
     */
    hashMap.remove("IPhone12")
    /**
     * ��������� �������� ���������� �����:
     */
    hashMap.replace("IPhone13", 76990)
    hashMap.put("IPhone11", 89990)
    hashMap["IPhone15"] = 34500

    for (key in hashMap.keys) {
        println("���� ����� ��������� �� $key : ${hashMap[key]} ")
    }


    /**
     * ������� ���������.
     */
    hashMap.clear()
    println(if (hashMap.isEmpty()) "\n��������� �����" else "$hashMap")
}