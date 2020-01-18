package com.ben.exhibitionapp.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ben.exhibitionapp.R
import com.ben.exhibitionapp.util.StateEnum
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.apply {

            state.observe(this@MainActivity,
                Observer {
                    when (it) {
                        StateEnum.COMPLETE -> {
                            exhibitionList.layoutManager =
                                LinearLayoutManager(
                                    this@MainActivity,
                                    LinearLayoutManager.VERTICAL,
                                    false
                                )

                            exhibitionList.adapter = adapter
                        }
                        StateEnum.ERROR -> {

                        }
                        else -> {
                        }
                    }
                })
        }
    }
}