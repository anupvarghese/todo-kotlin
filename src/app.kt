data class Todo(val title: String = "", val id: Int = 0, val completed: Boolean = false, val deleted: Boolean = false)

fun addTodo(todos: ArrayList<Todo>, todo: Todo) {
    todos.add(todo)
}

fun removeTodo(todos: ArrayList<Todo>, id: Int) {
    todos.removeIf { todo -> todo.id == id }
}

fun markAsDone(todos: ArrayList<Todo>, id: Int) {
    val todo = todos.find { todo -> todo.id == id }
    removeTodo(todos, id)
    if (todo != null)
        addTodo(todos, todo.copy(completed = true))
}


fun main(args: Array<String>) {
    val todo1: Todo = Todo("Buy Milk", 12, false, false)
    val todos: ArrayList<Todo> = ArrayList<Todo>()
    addTodo(todos, todo1)
    removeTodo(todos, 12)
    addTodo(todos, todo1)
    markAsDone(todos, 12)
    println(todos)
}