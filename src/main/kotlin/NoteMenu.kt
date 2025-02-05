// класс работы с заметками

class NoteMenu(private val archive: Archive) : CommonMenu() {

    init {
        noteMenu()
    }

    private fun noteMenu() {
        val options = listOf(
            Pair("Создать новую заметку", ::createNewNote),
            Pair("Выбрать заметку", ::selectNote)
        )

        showMenu(options)
    }

    private fun createNewNote() {
        print("Введите заголовок новой заметки: ")
        val noteTitle = scanner.nextLine().trim()

        if (noteTitle.isNotBlank()) {
            print("Введите содержание заметки: ")
            val noteContent = scanner.nextLine().trim()

            if (noteContent.isNotBlank()) {
                archive.notes.add(Note(noteTitle, noteContent))
                println("Заметка '$noteTitle' создана.")
            } else {
                println("Содержание заметки не может быть пустым.")
            }
        } else {
            println("Заголовок заметки не может быть пустым.")
        }

        noteMenu()
    }

    private fun selectNote() {
        if (archive.notes.isEmpty()) {
            println("Нет доступных заметок. Пожалуйста, создайте хотя бы одну.")
            noteMenu()
            return
        }

        val options = archive.notes.mapIndexed { index, note ->
            Pair(index.toString(), { ViewNote(note) as Any? })
        }.toMutableList()

        options.add(Pair("Назад", {}))

        showMenu(options)
    }
}