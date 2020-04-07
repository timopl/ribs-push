package com.example.ribpush.child

import android.os.Bundle
import com.badoo.common.ribs.RibsRule
import com.badoo.ribs.RibTestActivity
import com.badoo.ribs.customisation.RibCustomisationDirectory
import io.reactivex.Observable.empty
import io.reactivex.ObservableSource
import io.reactivex.functions.Consumer
import org.junit.Rule
import org.junit.Test

class ChildTest {

    @get:Rule
    val ribsRule = RibsRule { activity, savedInstanceState -> buildRib(activity, savedInstanceState) }

    private fun buildRib(ribTestActivity: RibTestActivity, savedInstanceState: Bundle?) =
        ChildBuilder(object : Child.Dependency {
            override fun childInput(): ObservableSource<Child.Input> = empty()
            override fun childOutput(): Consumer<Child.Output> = Consumer {}
            override fun ribCustomisation(): RibCustomisationDirectory = TODO()
        }).build(savedInstanceState)

    @Test
    fun testTextDisplayed() {
        TODO("Write UI tests")
    }
}
