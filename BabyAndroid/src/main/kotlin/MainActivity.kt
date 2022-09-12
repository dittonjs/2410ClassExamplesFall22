class MainActivity(val eventDispatcher: EventDispatcher) {

    fun onCreate() {

        println("Input an event name (touch, scroll, swipe):")
        eventDispatcher.registerEventHandler {
            if (it == "touch") {
                println("You touched the screen!")
            }
        }

        eventDispatcher.registerEventHandler {
            if (it == "swipe") {
                println("You swiped the screen")
            }
        }

        eventDispatcher.registerEventHandler {
            if (it == "open file") {

            }
        }

    }
}