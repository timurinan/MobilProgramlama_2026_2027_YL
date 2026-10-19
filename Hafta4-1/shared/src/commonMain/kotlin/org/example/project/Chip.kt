package org.example.project

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun Chip(icerik:String){
    Button(onClick = {}, colors = ButtonDefaults.buttonColors(contentColor = yazirengi, containerColor = anarenk)){
        Text(text = icerik)
    }

}