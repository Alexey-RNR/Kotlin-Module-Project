// класс работы с заметками

class NoteMenu : CommonMenu<Pair<String, String>>(
    mutableListOf(), MenuUtils(), "заметок", "Создать заметку"
) {

    override fun menuItemSelected(item: Pair<String, String>) {
        println("Заметка: ${item.first}")
        println("Текст заметки:\n${item.second}")

        println("Выберите действие:")
        println("0. Добавить текст")
        println("1. Выход")

        val choice = menuUtils.readInput()

        when (choice) {
            0 -> {
                appendContent(item)
            }

            1 -> {
                return
            }

            else -> {
                println("Некорректный ввод. Пожалуйста выберите 0 или 1.")
            }
        }
    }

    override fun createItem() {
        println("Введите название заметки:")
        val title = readln().trim()
        if (title.isEmpty()) {
            println("Название заметки не может быть пустым.")
            return
        }

        println("Введите текст заметки:")
        val content = readln().trim()
        if (content.isEmpty()) {
            println("Текст заметки не может быть пустым.")
            return
        }

        items.add(Pair(title, content))
        println("Заметка \"$title\" успешно создана.")
    }

    private fun appendContent(item: Pair<String, String>) {
        println("Введите текст, который вы хотите добавить:")
        val additionalText = readln().trim()
        if (additionalText.isNotEmpty()) {
            val updateContent = item.second + "\n" + additionalText
            val index = items.indexOf(item)
            if (index != -1) {
                items[index] = Pair(item.first, updateContent)
                println("Текст успешно добавлен в заметку \"${item.first}\".")
            } else {
                println("Ошибка: Не удалось найти заметку.")
            }
        } else {
            println("Поле ввода текста не может оставаться пустым.")
        }
    }

    fun show() {
        showMenu()
    }
}