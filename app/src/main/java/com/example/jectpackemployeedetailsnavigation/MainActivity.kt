package com.example.jectpackemployeedetailsnavigation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.ui.tooling.preview.Preview
import com.example.jectpackemployeedetailsnavigation.model.DataModel
import com.example.jectpackemployeedetailsnavigation.navigation.Navigation
import com.example.jectpackemployeedetailsnavigation.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()
    private val employeeList = mutableStateListOf<DataModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation(list = employeeList)
//            Navigation(list = employeeList)
        }
        observeUserDetails()
        observeCount()
        observeLocalUserDetails()
        viewModel.getAllDataCount()
    }

    private fun observeLocalUserDetails() {
        viewModel.userDetailsLocalLiveData.observe(this) {
            it?.let { it1 ->
                employeeList.addAll(it1)
            }
        }
    }

    private fun observeCount() {
        viewModel.userDetailsLiveDataCount.observe(this) {
            if ((it ?: 0) > 0) {
                viewModel.getAllData()
            } else {
                viewModel.fetchUserDetails()
            }
        }
    }


    private fun observeUserDetails() {
        viewModel.userDetailsLiveData.observe(this) {
            if (it != null) {
                Log.e("userDetails", "${it.size}")
                viewModel.insertDetails(it)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {

}