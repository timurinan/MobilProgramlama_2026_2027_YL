package org.example.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import org.jetbrains.compose.resources.painterResource

import denemehafta6.shared.generated.resources.Res
import denemehafta6.shared.generated.resources.compose_multiplatform
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun App() {
    val scope=rememberCoroutineScope ()
    val snackbarHostState=remember{ SnackbarHostState() }
    val acikmi=remember { mutableStateOf(false) }
    Scaffold (topBar = { TopAppBar(title = {Text(text = "Ana Sayfa")}) },
            snackbarHost = { SnackbarHost(hostState = snackbarHostState){
                Snackbar(
                    containerColor =Color.Yellow,
                    contentColor = Color.Blue,
                    actionColor = Color.Red,
                    snackbarData = it
                )
            } }
        ) {paddingValues ->
        Column (modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally ){
            Button(onClick = {scope.launch{
                val sb=snackbarHostState.showSnackbar("Silmek İstermisin?", actionLabel = "Evet")
                if (sb== SnackbarResult.ActionPerformed){
                    snackbarHostState.showSnackbar("Silindi")
                }
            }})

            {
                Text(text = "Snack Bar")
            }
            Button(onClick = {acikmi.value=true}){
                Text(text = "Alert")

            }
            if (acikmi.value){
                AlertDialog(
                    onDismissRequest = {acikmi.value=false},
                    title = {Text(text = "Başlık")},
                    text = {Text(text = "Mesaj")},
                    confirmButton = {
                        OutlinedButton(onClick = {
                            acikmi.value=false
                            scope.launch {
                            snackbarHostState.showSnackbar("Onay Seçildi...")
                            }
                        }){
                            Text(text = "Onayla")
                        }
                    },
                    dismissButton = {
                        OutlinedButton(onClick = {
                            acikmi.value=false
                            scope.launch {
                                snackbarHostState.showSnackbar("İptal Seçildi...")
                            }
                        }){
                            Text(text = "İptal")
                        }
                    }
                )
            }

        }

    }
}