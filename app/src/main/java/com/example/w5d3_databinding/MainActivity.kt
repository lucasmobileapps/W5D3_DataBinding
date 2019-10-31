package com.example.w5d3_databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.w5d3_databinding.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val fragmentFirst = Fragment1()
    private val fragmentSecond = Fragment2()
    private val fragmentThird = Fragment3()


    lateinit var myViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding : ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        myViewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.mainViewModel = myViewModel.viewProperties

        my_edittext.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {
                myViewModel.setText(p0.toString().toUpperCase())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }
        })


        supportFragmentManager.beginTransaction()
            .add(R.id.frame1_framelayout, fragmentFirst)
            .commit()
        supportFragmentManager.beginTransaction()
            .add(R.id.frame2_framelayout, fragmentSecond)
            .commit()
        supportFragmentManager.beginTransaction()
            .add(R.id.frame3_framelayout, fragmentThird)
            .commit()


    }
}
