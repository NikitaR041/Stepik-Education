/*
Задача 1 - OK
Напишите рекурсивную функцию countDigits, которая вычисляет количество цифр в заданном целом числе. 
Функция countDigits должна принимать целое число n в качестве аргумента и возвращать количество цифр в числе n.
*/
import kotlin.math.*

fun fun1(num: Int, c: Int = 0) : Int{   
    if (num == 0)  {return c}
    else {return fun1(num/10, c+1)}
}
// или
fun fun2(num: Int, c: Int = 0) : Int {
    return if (num == 0) c else fun1(num/10, c+1)
}

// fun main(){
//     var r : Int = readLine()!!.toInt()
//     println(fun1(abs(r)))
//     println(fun2(abs(r)))
// }

/*
Задача 2 - OK 
Напишите рекурсивную функцию calculatePower, которая вычисляет степень числа. 
Функция calculatePower должна принимать два аргумента: число base и целое число exponent. 
Она должна возвращать результат возведения числа base в степень exponent
*/

fun fun3(base: Double, exponent: Int):Double {
    return when {
        exponent == 0 -> 1.0
        exponent > 0 -> base * fun3(base, exponent - 1)
        else -> 1.0 / fun3(base, -exponent)
    }
}

// fun main(){
//     val (baseStr, exponentStr) = readLine()!!.split(' ')
//     val base = baseStr.toDouble()
//     val exponent = exponentStr.toInt()
//     // println(fun3(base, exponent))
//     println("%.2f".format(fun3(base, exponent))) 
// }

/*
Задача 3 - пока сложная задача
Напишите рекурсивную функцию, которая будет решать задачу о Ханойских башнях.
Задача о Ханойской башне является классической задачей теории алгоритмов, представляющей собой головоломку, которая была придумана в 1883 году французским математиком Эдуардом Лукасом.
Представьте три стержня, на один из которых нанизаны N дисков разного размера в порядке возрастания к вершине (самый большой диск находится снизу). 
Задача состоит в том, чтобы переместить всю стопку дисков на другой стержень, соблюдая следующие правила:
За один ход можно переместить только один диск.
Ни в какой момент времени диск большего размера не может находиться поверх диска меньшего размера.
*/

/*
Задача 4 - OK
Создайте рекурсивную функцию isPalindrome, которая проверяет, является ли строка палиндромом.
*/

fun fun4(stroka: String, lenStroka: Int, index: Int, count: Int):Boolean{
    return when{
        lenStroka in 0..1 -> true 
        count == 0 -> true
        count != 0 && stroka[index] == stroka[lenStroka-1] -> fun4(stroka, lenStroka-1,index+1, count-1)
        else -> false
    }
}

// ИЛИ 

fun fun5(s: String, left: Int = 0, right: Int = s.length - 1): Boolean {
    return when {
        left >= right -> true
        s[left] != s[right] -> false
        else -> fun5(s, left + 1, right - 1)
    }
}

// fun main(){
//     val s : String = readLine()!!
//     val index : Int = 0
//     println(if (fun4(s, s.length, index, s.length/2)) "True" else "False")
//     println(if (fun5(s)) "True" else "False")
// }

/*
Задача 5 - OK
Создайте рекурсивную функцию countZeros, 
которая принимает целое число и возвращает количество нулей в его десятичной записи.
*/

fun fun6(num_str: String, count: Int = 0, index: Int = 0):Int{
    return when {
        index >= num_str.length -> count
        num_str[index] == '0' -> fun6(num_str, count + 1, index + 1)
        else -> fun6(num_str, count, index+1)
    }
}

// fun main(){
//     val num_str : Int = readLine()!!.toInt()
//     val sortedText : String = num_str.toString().toList().sorted().joinToString("")
//     println(fun6(sortedText))
// }

/*

*/