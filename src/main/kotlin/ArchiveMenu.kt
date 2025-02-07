// класс работы с архивами

class ArchiveMenu : CommonMenu<String>(
    mutableListOf(), MenuUtils(), "архивов", "Создать архив"
) {

    private val noteMenu = NoteMenu()

    override fun menuItemSelected(item: String) {
        println("Выбран архив: $item")
        noteMenu.show()
    }

    override fun createItem() {
        println("Введите название архива:")
        val name = readln().trim()
        if (name.isNotEmpty()) {
            items.add(name)
            println("Архив \"$name\" успешно создан.")
        } else {
            println("Название архива не может быть пустым, введите название.")
        }
    }

    fun show() {
        showMenu()
    }
}