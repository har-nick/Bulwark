package uk.co.harnick.bulwark.core.ui.presentation

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

abstract class StatefulViewModel<State, Event>(
    initialState: State
) : StateScreenModel<State>(initialState) {
    protected val vmScope
        get() = screenModelScope
    protected val vmContext = vmScope.coroutineContext

    private val _uiEvent = Channel<Event>()
    val uiEvent = _uiEvent.consumeAsFlow()

    protected fun sendEvent(event: Event) = vmScope.launch { _uiEvent.send(event) }

    abstract fun onEvent(event: Event)
}
