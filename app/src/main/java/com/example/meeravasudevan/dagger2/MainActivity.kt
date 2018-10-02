package com.example.meeravasudevan.dagger2

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.Component
import dagger.Module
import dagger.Provides
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var someText: SomeText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerInjectTextComponent.create().inject(this)
        fooText.text = someText.text
    }
}

@Module
class TextModule {
    @Provides
    fun providesSomeText(): SomeText {
        return SomeText("Learning Dagger Provides")
    }
}

class SomeText(val text: String)

@Component(modules = [TextModule::class])
interface InjectTextComponent {
    fun inject(app: MainActivity)
}
