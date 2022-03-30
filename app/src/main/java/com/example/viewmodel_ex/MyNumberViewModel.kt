package com.example.viewmodel_ex

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

enum class ActionType{
    PLUS, MINUS
}

class MyNumberViewModel: ViewModel() {
    val TAG: String = "로그"
    
    //뮤터블 라이브 데이터 - 수정 가능
    //라이브 데이터 - 수정 불가능
    
    private val _currentValue = MutableLiveData<Int>()

    val currentValue : LiveData<Int> get() = _currentValue
    
    //초기값 설정
    init {
        Log.d(TAG, "MyNumberViewModel - () called")
    }

    fun updateValue(actionType: ActionType, input : Int){
        when(actionType){
            ActionType.PLUS ->
                _currentValue.value = _currentValue.value?.plus(input)
            ActionType.MINUS ->
                _currentValue.value = _currentValue.value?.minus(input)
        }
    }
}