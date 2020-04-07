package com.example.ribpush.root

import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.LayoutRes
import com.badoo.ribs.core.view.RibView
import com.badoo.ribs.core.view.ViewFactory
import com.badoo.ribs.customisation.inflate
import com.example.ribpush.R
import com.example.ribpush.root.RootView.Event
import com.example.ribpush.root.RootView.ViewModel
import com.example.ribpush.root.feature.RootFeature
import com.jakewharton.rxrelay2.PublishRelay
import io.reactivex.ObservableSource
import io.reactivex.functions.Consumer

interface RootView : RibView,
    ObservableSource<Event>,
    Consumer<ViewModel> {

    sealed class Event {
        object Navigate: Event()
    }

    data class ViewModel(
        val i: Int = 0
    )

    interface Factory : ViewFactory<Nothing?, RootView>
}


class RootViewImpl private constructor(
    override val androidView: ViewGroup,
    private val events: PublishRelay<Event> = PublishRelay.create()
) : RootView,
    ObservableSource<Event> by events,
    Consumer<ViewModel> {

    class Factory(
        @LayoutRes private val layoutRes: Int = R.layout.rib_root
    ) : RootView.Factory {
        override fun invoke(deps: Nothing?): (ViewGroup) -> RootView = {
            RootViewImpl(
                inflate(it, layoutRes)
            )
        }
    }

    init {
        androidView.findViewById<Button>(R.id.button_navigate).setOnClickListener {
            events.accept(Event.Navigate)
        }
    }

    override fun accept(vm: RootView.ViewModel) {
    }
}
