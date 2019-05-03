package com.example.ejemplo09

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity(), FakeBarFragment.OnSelectOption {

    override fun onAction(id: Int) {
        var content = when (id) {
            1 -> {
                "Hola"
            }
            2 -> {
                "Wiii"
            }
            3 -> {
                "Bye"
            }
            else -> {
                "Fuck!"
            }
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_content, ContentFragment.newInstance(content))
            .addToBackStack("Co")
            .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var barFragment = FakeBarFragment.newInstace(
            "Op1",
            "Op2",
            "Op3"
        )
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_bar, barFragment)
                .commit()
        }
    }
}
