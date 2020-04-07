package com.example.ribpush.second_child

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.badoo.ribs.core.view.RibView
import com.badoo.ribs.core.view.ViewFactory
import com.badoo.ribs.customisation.inflate
import com.example.ribpush.R
import com.example.ribpush.second_child.SecondChildView.Event
import com.example.ribpush.second_child.SecondChildView.ViewModel
import com.jakewharton.rxrelay2.PublishRelay
import io.reactivex.ObservableSource
import io.reactivex.functions.Consumer

interface SecondChildView : RibView,
    ObservableSource<Event>,
    Consumer<ViewModel> {

    sealed class Event

    data class ViewModel(
        val i: Int = 0
    )

    interface Factory : ViewFactory<Nothing?, SecondChildView>
}


class SecondChildViewImpl private constructor(
    override val androidView: ViewGroup,
    private val events: PublishRelay<Event> = PublishRelay.create()
) : SecondChildView,
    ObservableSource<Event> by events,
    Consumer<ViewModel> {

    class Factory : SecondChildView.Factory {
        override fun invoke(deps: Nothing?): (ViewGroup) -> SecondChildView = {
            SecondChildViewImpl(
                inflate(it, R.layout.rib_second_child)
            )
        }
    }

    override fun accept(vm: ViewModel) {
    }
}
