package com.example.ribpush.second_child

import com.badoo.ribs.core.Rib
import com.badoo.ribs.core.routing.transition.handler.TransitionHandler
import com.badoo.ribs.customisation.CanProvideRibCustomisation
import com.badoo.ribs.customisation.RibCustomisation
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.Single
import io.reactivex.functions.Consumer

interface SecondChild : Rib {

    interface Dependency {
        fun secondChildInput(): ObservableSource<Input> = Observable.empty()
        fun secondChildOutput(): Consumer<Output> = Consumer {}
    }

    sealed class Input

    sealed class Output

    class Customisation(
        val viewFactory: SecondChildView.Factory = SecondChildViewImpl.Factory(),
        val transitionHandler: TransitionHandler<SecondChildRouter.Configuration>? = null
    ) : RibCustomisation
}
