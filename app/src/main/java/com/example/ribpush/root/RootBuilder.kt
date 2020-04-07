package com.example.ribpush.root

import android.os.Bundle
import com.badoo.ribs.core.Builder
import com.badoo.ribs.customisation.customisationsBranchFor
import com.badoo.ribs.customisation.getOrDefault
import com.example.ribpush.child.Child
import com.example.ribpush.child.ChildBuilder
import com.example.ribpush.root.feature.RootFeature

class RootBuilder(
    override val dependency: Root.Dependency
) : Builder<Root.Dependency>() {

    fun build(savedInstanceState: Bundle?): RootNode {
        val customisation = Root.Customisation()
        val feature = RootFeature()
        val router = RootRouter(
            savedInstanceState,
            customisation.transitionHandler,
            ChildBuilder(object : Child.Dependency {})
        )
        val interactor = createInteractor(savedInstanceState, router, dependency, feature)

        return RootNode(
            savedInstanceState,
            customisation.viewFactory(null),
            router,
            dependency.rootInput(),
            dependency.rootOutput(),
            feature,
            interactor
        )
    }

    private fun createInteractor(
        savedInstanceState: Bundle?,
        router: RootRouter,
        dependency: Root.Dependency,
        feature: RootFeature
    ) =
        RootInteractor(
            savedInstanceState,
            router,
            dependency.rootInput(),
            dependency.rootOutput(),
            feature
        )
}
