package com.example.ribpush.child

import android.os.Bundle
import com.badoo.ribs.core.Builder
import com.badoo.ribs.customisation.customisationsBranchFor
import com.badoo.ribs.customisation.getOrDefault
import com.example.ribpush.child.feature.ChildFeature
import com.example.ribpush.second_child.SecondChild
import com.example.ribpush.second_child.SecondChildBuilder

class ChildBuilder(
    override val dependency: Child.Dependency
) : Builder<Child.Dependency>() {

    fun build(savedInstanceState: Bundle?): ChildNode {
        val customisation = Child.Customisation()
        val feature = ChildFeature()
        val router = ChildRouter(
            savedInstanceState, customisation.transitionHandler,
            SecondChildBuilder(object : SecondChild.Dependency {})
        )
        val interactor = createInteractor(savedInstanceState, router, dependency, feature)

        return ChildNode(
            savedInstanceState,
            customisation.viewFactory(null),
            router,
            dependency.childInput(),
            dependency.childOutput(),
            feature,
            interactor
        )
    }

    private fun createInteractor(
        savedInstanceState: Bundle?,
        router: ChildRouter,
        dependency: Child.Dependency,
        feature: ChildFeature
    ) =
        ChildInteractor(
            savedInstanceState,
            router,
            dependency.childInput(),
            dependency.childOutput(),
            feature
        )
}
