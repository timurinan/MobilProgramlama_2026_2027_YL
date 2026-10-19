package org.example.project

import androidx.annotation.Size
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource

import hafta3_2.shared.generated.resources.Res
import hafta3_2.shared.generated.resources.compose_multiplatform
import hafta3_2.shared.generated.resources.pizza

@Composable
@Preview
fun App() {
    Column (modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally)
    {
        //Komponentler burada yer alır...
        Text(text = "Pizza", fontWeight = FontWeight.Bold, fontSize= 30.sp, color = anarenk)
        Image(painter = painterResource(Res.drawable.pizza), contentDescription = "")
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly)
        {
            Chip("Peynir")
            Chip("Sos")
            Chip("Zeytin")
            Chip("Biber")
        }
        Text(text = "20 Dakikada Teslim",fontWeight = FontWeight.Bold, fontSize= 22.sp, color = yazirengi2)
        Text(text = "Gel Al da İkinci Pizza %50 indirimli", fontSize= 22.sp, color = anarenk)
        Row(modifier = Modifier.fillMaxWidth().padding(start = 10.dp, end = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween)
        {

            Text(text="200 TL", fontSize = 25.sp,)
            Spacer(modifier = Modifier.size(100.dp))
            Button(onClick = {},colors = ButtonDefaults.buttonColors(contentColor = yazirengi, containerColor = anarenk)){
                Text("Sepete Ekle", fontSize = 15.sp)
            }
        }

    }
}