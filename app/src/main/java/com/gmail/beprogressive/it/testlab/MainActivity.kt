package com.gmail.beprogressive.it.testlab

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.gmail.beprogressive.it.testlab.databinding.ActivityMainBinding
import com.gmail.beprogressive.it.testlab.exp.ExpRxJava

class MainActivity : AppCompatActivity(), FabInterface {

    private lateinit var binding: ActivityMainBinding


    private val exp by lazy {
//        ExpBuilder
//        ExpArrayReverse
//        TestMath
//        ExpCoroutine
        ExpRxJava
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView<ActivityMainBinding?>(this, R.layout.activity_main)
            .apply {
                fabInterface = this@MainActivity
                title.text = exp::class.java.simpleName
            }
    }

    override fun onFABClick() {
        exp.run()
    }
}