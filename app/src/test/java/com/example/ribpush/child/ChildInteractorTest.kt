package com.example.ribpush.child

import com.example.ribpush.child.feature.ChildFeature
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.ObservableSource
import io.reactivex.functions.Consumer
import org.junit.After
import org.junit.Before
import org.junit.Test

class ChildInteractorTest {

    private val input: ObservableSource<Child.Input> = mock()
    private val output: Consumer<Child.Output> = mock()
    private val feature: ChildFeature = mock()
    private val router: ChildRouter = mock()
    private lateinit var interactor: ChildInteractor

    @Before
    fun setup() {
        interactor = ChildInteractor(
            savedInstanceState = null,
            input = input,
            output = output,
            feature = feature,
            router = router
        )
    }

    @After
    fun tearDown() {
    }

    /**
     * TODO: Add real tests.
     */
    @Test
    fun `an example test with some conditions should pass`() {
        throw RuntimeException("Add real tests.")
    }
}
