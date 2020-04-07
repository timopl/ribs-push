package com.example.ribpush.root

import android.os.Bundle
import android.view.ViewGroup
import com.badoo.ribs.core.Node
import com.example.ribpush.root.feature.RootFeature
import io.reactivex.ObservableSource
import io.reactivex.Single
import io.reactivex.functions.Consumer

class RootNode internal constructor(
    savedInstanceState: Bundle?,
    viewFactory: ((ViewGroup) -> RootView?)?,
    private val router: RootRouter,
    private val input: ObservableSource<Root.Input>,
    private val output: Consumer<Root.Output>,
    private val feature: RootFeature,
    private val interactor: RootInteractor
) : Node<RootView>(
    savedInstanceState = savedInstanceState,
    identifier = object : Root {},
    viewFactory = viewFactory,
    router = router,
    interactor = interactor
), Root.Workflow {

    /**
     * TODO:
     *  - use router / input / output / feature for Root.Workflow method implementations
     *  - remove them from constructor if they are not needed (don't forget to remove in RootModule, too)
     *  - keep in mind that in most cases you probably don't need to use interactor reference directly
     *      - its lifecycle methods are not accessible publicly (and it's good this way)
     *      - its internal consumers are usually reacting to children, and then it's better to
     *          trigger child workflows instead of faking them directly on the parent
     *  - as a general advice, try to trigger actions at points that are closest to where they would happen naturally,
     *      such that triggering involves executing all related actions (analytics, logging, etc)
     */

    override fun businessLogicOperation(): Single<Root.Workflow> =
        executeWorkflow {
            // todo e.g. push wish to feature / trigger input / output
            // feature.accept()
        }

    // todo: expose ALL possible children (even permanent parts), or remove if there's none
    // override fun attachChild1(): Single<Child.Workflow> =
    //     attachWorkflow {
    //         // router.push(ConfigurationForChild)
    //     }
}
