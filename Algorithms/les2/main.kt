/*
Задача 1 - OK
Напишите рекурсивную функцию countDigits, которая вычисляет количество цифр в заданном целом числе. 
Функция countDigits должна принимать целое число n в качестве аргумента и возвращать количество цифр в числе n.
*/
import kotlin.math.abs

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

