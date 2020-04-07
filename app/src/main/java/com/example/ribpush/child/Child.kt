package com.example.ribpush.child

import com.badoo.ribs.core.Rib
import com.badoo.ribs.core.routing.transition.handler.TransitionHandler
import com.badoo.ribs.customisation.CanProvideRibCustomisation
import com.badoo.ribs.customisation.RibCustomisation
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.Single
import io.reactivex.functions.Consumer

interface Child : Rib {

    interface Dependency  {
        fun childInput(): ObservableSource<Input> = Observable.empty()
        fun childOutput(): Consumer<Output> = Consumer {  }
    }

    sealed class Input

    sealed class Output

    class Customisation(
        val viewFactory: ChildView.Factory = ChildViewImpl.Factory(),
        val transitionHandler: TransitionHandler<ChildRouter.Configuration>? = null
    ) : RibCustomisation

    interface Workflow {
        // todo: do not delete - rename, and add more
        // todo: expose all meaningful operations
        fun businessLogicOperation(): Single<Child.Workflow>

        // todo: expose all possible children (even permanent parts), or remove if there's none
        // fun attachChild1(): Single<Child.Workflow>
    }
}
