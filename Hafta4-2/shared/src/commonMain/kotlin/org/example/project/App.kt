package org.example.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource

import hafta4_2.shared.generated.resources.Res
import hafta4_2.shared.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {

    val sayac=remember { mutableStateOf(value = 0) }
    Scaffold(topBar =
        {
            TopAppBar(title = {Text(text = "Ana Sayfa")})
        })
    {paddingValues ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally)
        {
            Text(text = "Sayac: ${sayac.value}", fontSize = 30.sp)
            Row {
                Button(onClick = {sayac.value=sayac.value+1})
                {
                    Text(text = "Arttır")
                }
                Spacer(modifier = Modifier.size(50.dp))
                Button(onClick = {sayac.value=sayac.value-1})
                {
                    Text(text = "Azalt")
                }
            }

        }
    }
}