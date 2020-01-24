package com.ben.exhibitionapp.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.ben.exhibitionapp.R
import com.ben.exhibitionapp.ui.main.adapter.ExhibitItemAdapter
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel by inject()

    val adapter = ExhibitItemAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.apply {

            getData().observe(this@MainActivity, Observer {
                adapter.sedData(it)
            })

            exhibitionList.layoutManager =
                LinearLayoutManager(
                    this@MainActivity,
                    LinearLayoutManager.VERTICAL,
                    false
                )

            exhibitionList.adapter = adapter
        }
    }
}