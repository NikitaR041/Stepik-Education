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
// fun main(){
//     val n: Int = readLine()!!.toInt()
//     //Первый способ создания массива 
//     val numbers = readLine()!!.split(" ").map{it.toInt()}.toIntArray()

//     println(f1(n, numbers))
//     println(f2(n, numbers))
//     //Либо использовать sum
//     println(numbers.sum())
//     //Либо использовать все сразу 
//     println(readLine()!!.split(" ").map{it.toInt()}.toIntArray().sum())
// }

/*
Задача 2
Вы получили набор чисел. Напишите программу, которая возвращает наибольшее число в этом наборе.
Формат входных данных:
Первая строка содержит число n (1 ≤ n ≤ 10^5).
На следующей строке расположены n целых чисел -10^9 ≤ a_i ≤ 10^9 , разделенных пробелами.

Формат выходных данных:
Одно число, представляющее наибольшее число в наборе чисел.

Sample Input:
5
1 2 3 4 5
Sample Output:
5
*/
fun f3(n:Int, num: IntArray):Int{
    var tmp : Int = Int.MIN_VALUE 
    for (index in 0..num.lastIndex){
        if (tmp < num[index]){
            tmp = num[index]
        }
    }
    return tmp
}

// fun main(){
//     val n : Int = readLine()!!.toInt()
//     val numbers = readLine()!!.split(" ").map{it.toInt()}.toIntArray()

//     // 1
//     println(readLine()!!.split(" ").map{it.toInt()}.toIntArray().maxOrNull())
//     // 2
//     println(numbers.maxOrNull())
//     // 3
//     println(f3(n, numbers))
// }

/*
Задача 3
Вы получили набор чисел и конкретное число. Напишите программу, которая возвращает, сколько раз конкретное число встречается в этом наборе.

Формат входных данных:
Первая строка содержит число n (1 ≤ n ≤ 10^5).
На второй строке расположены n целых чисел (1 ≤ a_i ≤ 10^9), разделенных пробелами.
Третья строка содержит конкретное число, которое нужно посчитать (1 ≤ number ≤ 10^9).

Формат выходных данных:
Одно число, представляющее количество вхождений конкретного числа в набор чисел.

Sample Input:
5
1 2 3 2 2
2
Sample Output:
3
*/

fun f4(n:Int, numbers:IntArray, correct:Int) : Int{
    var count : Int = 0
    for (index in 0..numbers.lastIndex){
        if (numbers[index] == correct) count++ 
    }
    return count
}

// fun main(){
//     var N : Int = readLine()!!.toInt()
//     var numbers = readLine()!!.split(" ").map{ it.toInt() }.toIntArray()
//     var correct : Int = readLine()!!.toInt()

//     println(f4(N,numbers, correct))
//     //Либо 
//     println(numbers.count { it == correct })
// }

/*
Задача 4
Найдите второе по величине число в массиве чисел. Максимальное число в массиве встречается единожды.

Формат входных данных:
Первая строка содержит число n (2 ≤ n ≤ 10^5).
На второй строке находятся n  целых чисел (1 ≤ a_i ≤ 10^9), разделенных пробелами.

Формат выходных данных:
Второе по величине число.

Sample Input:
5
1 3 3 5 4
Sample Output:
4
*/

fun f5(n:Int, numbers:IntArray) : Int{
    numbers.sorted()
    return numbers.get(numbers.size-1)
}
// Или
fun secondMax(arr: IntArray): Int {
    var max1 = Int.MIN_VALUE
    var max2 = Int.MIN_VALUE

    for (num in arr) {
        if (num > max1) {
            max2 = max1
            max1 = num
        } else if (num > max2 && num != max1) {
            max2 = num
        }
    }

    return max2
}


// fun main(){
//     var N : Int = readLine()!!.toInt()
//     var numbers = readLine()!!.split(" ").map{ it.toInt() }.toIntArray()
//     println(f5(N, numbers))
//     println(secondMax(numbers))
// }

