package com.example.androiddevchallenge

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import java.util.Date

class HelloViewModel : ViewModel() {

    // LiveData holds state which is observed by the UI
    // (state flows down from ViewModel)
    private val _name = MutableLiveData("")
    val name: LiveData<String> = _name

    // onNameChanged is an event we're defining that the UI can invoke
    // (events flow up from UI)
    fun onNameChanged(newName: String) {
        _name.value = newName
    }
}

@Composable
fun MainScreen(viewModel: HelloViewModel = viewModel()) {
    viewModel.name.observeasstate
    val scope = rememberCoroutineScope()
    Column {
        Text(text = "Ready... Set... GO!")

        Timer(Date())
    }

}

@Composable
fun Timer(time: Date) {
    Text(time.toString())
}