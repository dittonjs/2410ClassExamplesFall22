fun main(args: Array<String>) {
    val looper = Looper()
    looper.start()
    val mainActivity = MainActivity(looper)
    mainActivity.onCreate()
    while(true) {
        val input = readLine()
        if (input == "quit") break
        // do some stuff with the looper
        // one way to do it
//        if (input != null) {
//            looper.enqueueEvent(input)
//        }
        // elvis operator!
        looper.enqueueEvent(input ?: "Invalid input")
    }
}