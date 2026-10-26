package org.example.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import org.jetbrains.compose.resources.painterResource

import hafta5_1.shared.generated.resources.Res
import hafta5_1.shared.generated.resources.compose_multiplatform
import hafta5_1.shared.generated.resources.outline_arrow_back_24
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

@Composable

fun App(navController: NavController) {
    Scaffold(topBar = { TopAppBar(title = {Text(text = "Sayfa-1")}) })
    {paddingValues ->
        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally)
        {
            val adres= Adres("Atakent","Prof Aziz Ergin","12. cadde",5)
            val jsonAdres= Json.encodeToString(adres)
            Button(onClick = {navController.navigate(route = "sayfa2/Ahmetİnan/45/timurinan@hotmail.com/232323232/$jsonAdres")},){
                Text(text = "İkinci Sayfaya Geç")
            }

        }
    }
}