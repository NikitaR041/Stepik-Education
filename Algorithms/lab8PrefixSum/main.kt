/*
Раздел посвященный алгоритмам и структурам данных
Глава 8. Префиксные суммы.
*/

/*
Теория:
Префиксные суммы – это метод, который позволяет быстро (за O(1)) находить сумму элементов подмассива в массиве чисел. 
Концепция проста: для данного массива a создается новый массив p, 
где каждый элемент p[i] представляет собой сумму всех элементов массива a до позиции i (включительно).

Формально: p[i]=a[0]+a[1]+⋯+a[i].

С префиксными суммами задача поиска суммы элементов подмассива a[i…j] сводится к разности двух префиксных сумм: 
p[j]−p[i−1] (если i>0, иначе просто p[j]).

Основные шаги работы с префиксными суммами:
1)Вычислить префиксные суммы для массива.
2)Для получения суммы подмассива вычесть соответствующие префиксные суммы.
*/

//Реализация на Kotlin
fun compute_prefix_sums(arr : IntArray ) : IntArray {
    var n = arr.size
    var prefix_sums = IntArray(n+1){0} 
    for (i in 0 until n){
        prefix_sums[i+1] = prefix_sums[i] + arr[i]
    }
    return prefix_sums
}

fun subarray_sum(prefix_sums : IntArray,  i : Int, j : Int) : Int {
    return prefix_sums[j+1] - prefix_sums[i]
}

/*
fun main(){
    var arr = intArrayOf(1, 2, 3, 4, 5, 6)
    var prefix_sums : IntArray= compute_prefix_sums(arr)
    for (i in prefix_sums){
        println(i)
    }
    println(subarray_sum(prefix_sums, 1, 4))
}
*/

/*
Задача 1
Вам дан массив a длины n и q запросов вида «посчитайте сумму некоторого отрезка массива a». 
Выведите сумму ответов на все запросы.

Входные данные
На первой строке числа n и q (1 ≤ n, q ≤ 10^5). 

На второй строке массив a из n целых чисел от 0 до 9999.

Далее q строк, каждая описывает один запрос-отрезок парой числе l_i, r_i (1≤ l_i ≤ r_i ≤ n).

Выходные данные
Выведите одно число — сумму ответов на все запросы. В первом примере это 35 = 18 + 5 + 12.

Шаблоны
В этой задаче есть шаблоны кода для языков python3.10 и c++20.
*/
fun main(){
    var sum : Int = 0
    val (n, q) = readLine()!!.trim().split(" ").map{it.toInt()}
    var prefix_sums = readLine()!!.trim().split(" ").map{it.toInt()}.toIntArray() 
    prefix_sums = compute_prefix_sums(prefix_sums)
    for (i in 0 until q){
        val (N, M) = readLine()!!.trim().split(" ").map{it.toInt()}
        sum += subarray_sum(prefix_sums, N-1, M-1)
    }
    println(sum)
}

/*
[+] Test #1. OK
[+] Test #2. OK
[+] Test #3. OK
[+] Test #4. OK
[ ] Test #5. Time limit exceeded
[ ] Test #6. Wrong answer

4 of 6 test(s) passed.
*/