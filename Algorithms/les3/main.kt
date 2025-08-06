/*
Раздел посвященный структурам данных
Глава 1. Массивы.
*/

/*
Задача 1
Вы получили набор чисел. Напишите программу, которая возвращает сумму всех чисел.

Формат входных данных:
Первая строка содержит число n (1 ≤ n ≤ 10^5).
На следующей строке находятся n целых чисел (1 ≤ a_i ≤ 10^9) разделенных пробелами.
Формат выходных данных: 
Одно число, представляющее собой сумму всех чисел.

Sample Input:
5
1 2 3 4 5
Sample Output:
15
*/
fun f1(n: Int, massive: IntArray) : Int {
    var sum : Int = 0
    // Способ 1 
    // for (value in 0 until n+1){
    //     sum += value
    // }
    // Способ 2
    // for (value in 0..n){
    //     sum += value
    // }
    // Способ 3 ЛИБО value in 0 until n+1 step 1 
    for (value in 0..n step 1){
        sum += value
    }
    return sum
}
//Или
fun f2(n:Int, massive: IntArray) : Int{
    var sum : Int = 0
    for (index in 0..massive.lastIndex){
        sum += massive[index]
    }
    return sum
}
fun main(){
    val n: Int = readLine()!!.toInt()
    //Первый способ создания массива 
    val numbers = readLine()!!.split(" ").map{it.toInt()}.toIntArray()

    println(f1(n, numbers))
    println(f2(n, numbers))
    //Либо использовать sum
    println(numbers.sum())
    //Либо использовать все сразу 
    println(readLine()!!.split(" ").map{it.toInt()}.toIntArray().sum())
}