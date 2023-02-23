package com.my1.storepage.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotificationsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "진행중인 프로모션이 없습니다."
    }
    val text: LiveData<String> = _text
}