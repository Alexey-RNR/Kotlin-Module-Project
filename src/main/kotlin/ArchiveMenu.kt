// класс работы с архивами

class ArchiveMenu : CommonMenu() {

    companion object {
        private var archives: MutableList<Archive> = mutableListOf()
    }

    init {
        mainMenu()
    }

    private fun mainMenu() {
        val options = listOf(
            Pair("Создать новый архив", ::createNewArchive),
            Pair("Выбрать архив", ::selectArchive)
        )

        showMenu(options)
    }

    private fun createNewArchive() {
        print("Введите имя нового архива: ")
        val archiveName = scanner.nextLine().trim()

        if (archiveName.isNotBlank()) {
            archives.add(Archive(archiveName, mutableListOf()))
            println("Архив '$archiveName' создан.")
        } else {
            println("Имя архива не может быть пустым.")
        }

        mainMenu()
    }

    private fun selectArchive() {
        if (archives.isEmpty()) {
            println("Нет доступных архивов. Пожалуйста, создайте хотя бы один.")
            mainMenu()
            return
        }

        val options = archives.mapIndexed { index, archive ->
            Pair(index.toString(), { NoteMenu(archive) as Any? })
        }.toMutableList()

        options.add(Pair("Назад", {}))

        showMenu(options)
    }
}