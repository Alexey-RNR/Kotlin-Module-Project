// класс для отоброжения содержимого заметок

class ViewNote(private val note: Note) {

    init {
        viewNote()
    }

    private fun viewNote() {
        println("Заголовок: ${note.title}")
        println("Содержание:\n${note.content}")

        println("\nНажмите Enter для возврата...")
        readLine()
    }
}