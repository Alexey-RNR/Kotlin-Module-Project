// класс для методов работы с меню и обработкой ввода

import java.util.Scanner
import java.util.InputMismatchException

abstract class CommonMenu {

    protected var scanner = Scanner(System.`in`)

    protected fun showMenu(options: List<Pair<String, () -> Any?>>) {
        println("Доступные опции:")

        options.forEachIndexed { index, option ->
            println("${index + 1}. ${option.first}")
        }

        println("0. Назад")

        while (true) {
            print("Введите номер опции: ")

            try {
                val choice = scanner.nextInt()

                if (choice == 0) {
                    return
                } else if (choice in 1..options.size) {
                    options[choice - 1].second.invoke()
                } else {
                    println("Неверная цифра! Введите число от 1 до ${options.size}")
                }
            } catch (e: InputMismatchException) {
                println("Пожалуйста, введите число!")
                scanner.nextLine() // Очистка буфера
            }
        }
    }
}