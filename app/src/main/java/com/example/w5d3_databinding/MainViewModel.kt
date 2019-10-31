package com.example.w5d3_databinding

import android.app.Application
import android.util.Log
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import androidx.lifecycle.AndroidViewModel

class MainViewModel(application: Application) : AndroidViewModel(application){

    val viewProperties: MyViewObservable = MyViewObservable()

    fun setText(newName: String){
        viewProperties.apply {
            myName = newName
        }
    }

    inner class MyViewObservable: BaseObservable(){
        @get: Bindable
        var myName: String = "Starter Name"
            set(myName){
                field = myName
                notifyPropertyChanged(BR.myName)
                Log.d("LOG_X", field)

            }
    }

}