fun main(args: Array<String>) {
    println("Hello World!")
    val queue = Queue()
    queue.addToEnd("Joseph")
    println(queue.removeFromFront())

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}