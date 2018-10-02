package com.example.meeravasudevan.dagger2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import dagger.Component
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var someText: SomeText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerInjectTextComponent.create().inject(this)
        fooText.text = someText.text
    }
}

class SomeText @Inject constructor() {
    var text = "Dagger 2 Experiment"
}

@Component
interface InjectTextComponent {
    fun inject(app: MainActivity)
}
