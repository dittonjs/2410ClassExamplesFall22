import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.thread
import kotlin.concurrent.withLock

class Looper: EventDispatcher {
    private val eventQueue = ArrayDeque<String>()
    private var running = false
    private val lock = ReentrantLock()
    private val condition = lock.newCondition()
    private val eventHandlers = mutableListOf<(String) -> Unit>()

    private fun run() {
        while(running) {
            lock.withLock {
                while (eventQueue.isNotEmpty()) {
                    val event = eventQueue.removeFirst()
                    eventHandlers.forEach {
                        it.invoke(event)
                    }
                }
                condition.await()
            }
        }
    }

    public fun start() {
        running = true
        thread(start = true) {
            run()
        }

    }

    public fun stop() {
        running = false
        lock.withLock {
            condition.signal()
        }
    }

    public fun enqueueEvent(event: String) {
        lock.withLock {
            eventQueue.add(event)
            condition.signal()
        }
    }

    override fun registerEventHandler(eventHandler: (String) -> Unit) {
        eventHandlers.add(eventHandler)
    }
}