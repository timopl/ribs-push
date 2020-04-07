package com.example.ribpush.root

import com.badoo.ribs.core.Rib
import com.badoo.ribs.core.routing.transition.handler.TransitionHandler
import com.badoo.ribs.customisation.CanProvideRibCustomisation
import com.badoo.ribs.customisation.RibCustomisation
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.Single
import io.reactivex.functions.Consumer

interface Root : Rib {

    interface Dependency  {
        fun rootInput(): ObservableSource<Input> = Observable.empty()
        fun rootOutput(): Consumer<Output> = Consumer {  }
    }

    sealed class Input

    sealed class Output

    class Customisation(
        val viewFactory: RootView.Factory = RootViewImpl.Factory(),
        val transitionHandler: TransitionHandler<RootRouter.Configuration>? = null
    ) : RibCustomisation

    interface Workflow {
        // todo: do not delete - rename, and add more
        // todo: expose all meaningful operations
        fun businessLogicOperation(): Single<Root.Workflow>

        // todo: expose all possible children (even permanent parts), or remove if there's none
        // fun attachChild1(): Single<Child.Workflow>
    }
}
