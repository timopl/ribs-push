package com.example.ribpush.child

import com.nhaarman.mockitokotlin2.mock
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner


@RunWith(RobolectricTestRunner::class)
class ChildRouterTest {

    private var interactor: ChildInteractor = mock()
    private var router: ChildRouter? = null

    @Before
    fun setup() {
        router = ChildRouter(
            savedInstanceState = null
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
