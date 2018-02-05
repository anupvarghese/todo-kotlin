data class Todo(val title: String = "", val id: Int = 0, val completed: Boolean = false, val deleted: Boolean = false)

fun addTodo(todos: ArrayList<Todo>, todo: Todo): ArrayList<Todo> {
    val todosCopy = ArrayList<Todo>(todos)
    todosCopy.add(todo)
    return todosCopy
}

fun removeTodo(todos: ArrayList<Todo>, id: Int): ArrayList<Todo> {
    val todosCopy = ArrayList<Todo>(todos)
    todosCopy.removeIf { todo -> todo.id == id }
    return todosCopy
}

fun markAsDone(todos: ArrayList<Todo>, id: Int): ArrayList<Todo> {
    val todosCopy = ArrayList<Todo>(todos)
    val todo = todosCopy.find { todo -> todo.id == id }
    val removed = removeTodo(todos, id)
    if (todo != null)
        return addTodo(removed, todo.copy(completed = true))
    return todosCopy
}


fun main(args: Array<String>) {
    val todo1: Todo = Todo("Buy Milk", 12, false, false)
    val todos: ArrayList<Todo> = ArrayList<Todo>()
    val newTodos = addTodo(todos, todo1)
    val removedTodos = removeTodo(newTodos, 12)
    val newTodos1 = addTodo(removedTodos, todo1)
    val finalTodos = markAsDone(newTodos1, 12)
    println(finalTodos)
}