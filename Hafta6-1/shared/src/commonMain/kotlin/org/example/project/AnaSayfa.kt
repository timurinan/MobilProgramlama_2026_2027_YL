package org.example.project

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hafta6_1.shared.generated.resources.Res
import hafta6_1.shared.generated.resources.baseline_arrow_drop_down_24
import hafta6_1.shared.generated.resources.book
import org.jetbrains.compose.resources.painterResource

@Composable
@Preview
fun AnaSayfa(){

    val tfdeger= remember { mutableStateOf(value = "") }
    val switchdurum=remember { mutableStateOf(false) }
    val checkboxdeger=remember { mutableStateOf(false) }
    val radiodeger=remember { mutableStateOf(0) }
    val pbdurum=remember { mutableStateOf(false) }
    val sliderdeger=remember { mutableStateOf(30f) }
    val ulkelistesi=listOf("Türkiye","İtalya","Japonya")
    val aciliskontrol=remember { mutableStateOf(false) }
    val secilenindeks=remember { mutableStateOf(0) }

    Scaffold (topBar = { TopAppBar(title = { Text(text = "Ana Sayfa") }) }){paddingValues ->
        Column (modifier = Modifier.fillMaxSize().padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally ) {
            TextField(value = tfdeger.value,
                onValueChange = {tfdeger.value=it},
                label = {Text(text = "Veri Giriniz")},
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword))
            Button(onClick = {}){
                Text(text = "Giriş Yap")
            }
            Image(painter = painterResource(Res.drawable.book), contentDescription = "")
            Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                Row (verticalAlignment = Alignment.CenterVertically){
                    Switch(checked = switchdurum.value, onCheckedChange = {switchdurum.value=it})
                    Text(text = "Seçim")
                }
                Row (verticalAlignment = Alignment.CenterVertically){
                    Checkbox(checked = checkboxdeger.value, onCheckedChange = {checkboxdeger.value=it})
                    Text(text = "Seçim")
                }

            }
            Row {
                Row (verticalAlignment = Alignment.CenterVertically){
                    RadioButton(selected = (1==radiodeger.value), onClick = {radiodeger.value=1})
                    Text(text = "Barcelona")
                }
                Row (verticalAlignment = Alignment.CenterVertically){
                    RadioButton(selected = (2==radiodeger.value), onClick = {radiodeger.value=2})
                    Text(text = "Real Madrid")
                }
            }
            Row (modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceEvenly){
                Button(onClick = {pbdurum.value=true}){
                  Text(text = "Başlat")
                }
                if (pbdurum.value){
                    CircularProgressIndicator(color = Color.Blue)
                }
                Button(onClick = {pbdurum.value=false}){
                    Text(text = "Durdur")
                }
            }
            Text(text = "Sonuç: ${sliderdeger.value.toInt()} ")
            Slider(value = sliderdeger.value, onValueChange = {sliderdeger.value=it}, valueRange = 0f..100f, modifier = Modifier.padding(10.dp))
            Box(){
                Row (verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.size(100.dp,50.dp).clickable{aciliskontrol.value}){
                  Text(text = ulkelistesi[secilenindeks.value])
                    Icon(painter = painterResource(Res.drawable.baseline_arrow_drop_down_24), contentDescription = "")
                }
                DropdownMenu(expanded = aciliskontrol.value, onDismissRequest = {aciliskontrol.value=false}){
                    ulkelistesi.forEachIndexed { indeks, ulke ->
                        DropdownMenuItem(text = {ulkelistesi[indeks]}, onClick = {secilenindeks.value=indeks
                            aciliskontrol.value=false
                        })
                    }
                }
            }
            Box(modifier = Modifier.size(100.dp,50.dp)
                .background(Color.Red).pointerInput(Unit){
                    detectTapGestures (
                        onTap = {println("Box a tek tıklandı...")},
                        onDoubleTap = {println("Box a çift tıklandı...")},
                        onLongPress = {println("Box a uzun basıldı...")}
                    )
                })
        }
    }

}