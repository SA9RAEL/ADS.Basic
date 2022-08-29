package ADS.Basic.src.main.kotlin

import java.util.*

/**
 * ��������� ������: ���(������� ���������������� ��������)
 * ��������: ���� �� �������� ���������� N ����� (����� - �����)
 * ��������� ������ ����� ���������� � ���������.
 * ��������: union(x,y) - ����������� ���������, ����������� � � �
 * find(x) - ���������� ������������� ���������, � ������� ��������� �.
 */

class UnionFind(private val size: Int) {
    private val parent = IntArray(size)
    var count = size
        private set

    /** MakeSet(X) - ������ � ��������� ����� ������� X,
     * ������� ��� ���� ��������� ������� 1 �� ������ ����.
     * */
    init {
        for (i in parent.indices) {
            parent[i] = i
        }
    }

    fun connected(x: Int, y: Int): Boolean {
        return find(x) == find(y)
    }

    /**
     * find(X) - ��������� ������������� ���������, �������� ����������� ������� �.
     * ������������� = ������������� ��������� = ������ = ��������.
     * �������������, ��� ��� ������ � ���� �� ���������
     * ������������� ����� ������������ ���� � ��� ��.
     */
    fun find(x: Int): Int {
        return if (x == parent[x]) {
            x
        } else find(parent[x]).also { parent[x] = it }
    }

    /**
     * ���������� ��� ���������, � ������ ����� �������� � � Y. � ���� �����.
     */
    fun union(x: Int, y: Int) {
        val rootX = find(x)
        val rootY = find(y)
        if (rootX == rootY) return
        if ((0..1).random() % 2 == 0) {
            parent[rootX] = rootY
        } else {
            parent[rootY] = rootX
        }
        count--
    }
}

