package org.example.project

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import hafta5_1.shared.generated.resources.Res
import hafta5_1.shared.generated.resources.outline_arrow_back_24
import org.jetbrains.compose.resources.painterResource

@Composable
fun Sayfa2(navController: NavController,gelenAdSoyad:String,gelenYas:Int,gelenMail:String,gelenTel:String,adres: Adres){

    MaterialTheme {
        Scaffold(topBar = { TopAppBar(title = {Text(text = "Sayfa-2")},
            navigationIcon = {
                IconButton(onClick = {navController.popBackStack()}){
                    Icon(painter = painterResource(Res.drawable.outline_arrow_back_24), contentDescription = "")
                }
            }) })
        {paddingValues ->

            Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceEvenly, horizontalAlignment = Alignment.CenterHorizontally)
            {
                Button(onClick = {navController.navigate(route="app")},){
                    Text(text = "İlk Sayfaya Geri Dön")
                }
                Text(text = "Adı Soyadı=${gelenAdSoyad}")
                Text(text = "Yaşı=${gelenYas}")
                Text(text = "Maili=${gelenMail}")
                Text(text = "Telefonu=${gelenTel}")
                Text(text = "Mahallesi:${adres.mahalle}")
                Text(text = "Sokağı:${adres.sokak}")
                Text(text = "Caddesi:${adres.cadde}")
                Text(text = "Bina No:${adres.binano}")

            }
        }

    }

}