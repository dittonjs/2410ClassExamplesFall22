interface EventDispatcher {
    fun registerEventHandler(eventHandler: (String) -> Unit)
}