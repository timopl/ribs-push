package com.example.ribpush.child

import android.os.Bundle
import android.os.Parcelable
import com.badoo.ribs.core.Router
import com.badoo.ribs.core.routing.action.AttachRibRoutingAction.Companion.attach
import com.badoo.ribs.core.routing.action.RoutingAction
import com.badoo.ribs.core.routing.transition.handler.TransitionHandler
import com.example.ribpush.child.ChildRouter.Configuration
import com.example.ribpush.child.ChildRouter.Configuration.Content
import com.example.ribpush.child.ChildRouter.Configuration.Overlay
import com.example.ribpush.child.ChildRouter.Configuration.Permanent
import com.example.ribpush.second_child.SecondChildBuilder
import kotlinx.android.parcel.Parcelize

class ChildRouter(
    savedInstanceState: Bundle?,
    transitionHandler: TransitionHandler<Configuration>? = null,
    private val secondChildBuilder: SecondChildBuilder
): Router<Configuration, Permanent, Content, Overlay, ChildView>(
    savedInstanceState = savedInstanceState,
    transitionHandler = transitionHandler,
    initialConfiguration = Content.Default,
    permanentParts = emptyList()
) {
    sealed class Configuration : Parcelable {
        sealed class Permanent : Configuration()
        sealed class Content : Configuration() {
            @Parcelize object Default : Content()
            @Parcelize object SecondChild: Content()
        }
        sealed class Overlay : Configuration()
    }

    override fun resolveConfiguration(configuration: Configuration): RoutingAction<ChildView> =
        when (configuration) {
            is Content.SecondChild -> attach { secondChildBuilder.build(it) }
            else -> RoutingAction.noop()
        }
}
