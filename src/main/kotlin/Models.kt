// Фаил с моделями данных (архив/заметка)

data class Archive(val name: String, val notes: MutableList<Note>)
data class Note(val title: String, val content: String)