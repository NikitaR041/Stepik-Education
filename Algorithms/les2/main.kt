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