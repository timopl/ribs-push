package com.example.ribpush.child

import com.badoo.ribs.customisation.RibCustomisationDirectory
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.ObservableSource
import io.reactivex.functions.Consumer
import org.junit.After
import org.junit.Before
import org.junit.Test

class ChildWorkflowTest {

    private lateinit var workflow: Child.Workflow

    @Before
    fun setup() {
        workflow = ChildBuilder(object :
            Child.Dependency {
            override fun childInput(): ObservableSource<Child.Input> = mock()
            override fun childOutput(): Consumer<Child.Output> = mock()
            override fun ribCustomisation(): RibCustomisationDirectory = mock()
        }).build(null).also {
            it.onAttach()
        }
    }

    @After
    fun tearDown() {
    }

    /**
     * TODO: Add tests for every workflow action that operates on the node
     */
    @Test
    fun `business logic operation test`() {
        workflow.businessLogicOperation()
        // verify(feature).accept(Wish)

        throw RuntimeException("Add real tests.")
    }

    /**
     * TODO: Add tests for every workflow action that attaches a child to ensure workflow step can be fulfilled
     */
    @Test
    fun `attach child workflow step is fulfillable`() {
        // val testObserver = TestObserver<Child.Workflow>()

        // workflow.attachChild1().subscribe(testObserver)

        // testObserver.assertValueCount(1)
        // testObserver.assertComplete()

        throw RuntimeException("Add real tests.")
    }
}
