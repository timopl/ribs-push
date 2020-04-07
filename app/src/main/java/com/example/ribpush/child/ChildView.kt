package com.example.ribpush.child

import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.LayoutRes
import com.badoo.ribs.core.view.RibView
import com.badoo.ribs.core.view.ViewFactory
import com.badoo.ribs.customisation.inflate
import com.example.ribpush.R
import com.example.ribpush.child.ChildView.Event
import com.example.ribpush.child.ChildView.ViewModel
import com.jakewharton.rxrelay2.PublishRelay
import io.reactivex.ObservableSource
import io.reactivex.functions.Consumer

interface ChildView : RibView,
    ObservableSource<Event>,
    Consumer<ViewModel> {

    sealed class Event {
        object Navigate: Event()
    }

    data class ViewModel(
        val i: Int = 0
    )

    interface Factory : ViewFactory<Nothing?, ChildView>
}


class ChildViewImpl private constructor(
    override val androidView: ViewGroup,
    private val events: PublishRelay<Event> = PublishRelay.create()
) : ChildView,
    ObservableSource<Event> by events,
    Consumer<ViewModel> {

    class Factory(
        @LayoutRes private val layoutRes: Int = R.layout.rib_child
    ) : ChildView.Factory {
        override fun invoke(deps: Nothing?): (ViewGroup) -> ChildView = {
            ChildViewImpl(
                inflate(it, layoutRes)
            )
        }
    }

    init {
        androidView.findViewById<Button>(R.id.go_to_second).setOnClickListener {
            events.accept(Event.Navigate)
        }
    }

    override fun accept(vm: ChildView.ViewModel) {
    }
}
