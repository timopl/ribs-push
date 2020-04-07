package com.example.ribpush.root

import android.os.Bundle
import android.os.Parcelable
import com.badoo.ribs.core.Router
import com.badoo.ribs.core.routing.action.AttachRibRoutingAction.Companion.attach
import com.badoo.ribs.core.routing.action.RoutingAction
import com.badoo.ribs.core.routing.transition.handler.TransitionHandler
import com.example.ribpush.child.ChildBuilder
import com.example.ribpush.root.RootRouter.Configuration
import com.example.ribpush.root.RootRouter.Configuration.Content
import com.example.ribpush.root.RootRouter.Configuration.Overlay
import com.example.ribpush.root.RootRouter.Configuration.Permanent
import kotlinx.android.parcel.Parcelize

class RootRouter(
    savedInstanceState: Bundle?,
    transitionHandler: TransitionHandler<Configuration>? = null,
    private val childBuilder: ChildBuilder
) : Router<Configuration, Permanent, Content, Overlay, RootView>(
    savedInstanceState = savedInstanceState,
    transitionHandler = transitionHandler,
    initialConfiguration = Content.Default,
    permanentParts = emptyList()
) {
    sealed class Configuration : Parcelable {
        sealed class Permanent : Configuration()
        sealed class Content : Configuration() {
            @Parcelize
            object Default : Content()
            @Parcelize
            object Child : Content()
        }

        sealed class Overlay : Configuration()
    }

    override fun resolveConfiguration(configuration: Configuration): RoutingAction<RootView> =
        when (configuration) {
            is Content.Child -> attach { childBuilder.build(it) }
            else -> RoutingAction.noop()
        }

}
