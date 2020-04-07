package com.example.ribpush

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.ViewGroup
import com.badoo.ribs.android.RibActivity
import com.badoo.ribs.core.Node
import com.example.ribpush.root.Root
import com.example.ribpush.root.RootBuilder

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : RibActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main)
        super.onCreate(savedInstanceState)
    }

    override val rootViewGroup: ViewGroup
        get() = findViewById(R.id.main)

    override fun createRib(savedInstanceState: Bundle?): Node<*> {
        return RootBuilder(object : Root.Dependency {}).build(savedInstanceState)
    }
}
