package org.example.project

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json


@Composable
fun SayfaGecisleri(){
    val navController= rememberNavController()
    NavHost(navController=navController,startDestination="app"){

        composable(route="app"){
            App(navController=navController)
        }
        composable(route="sayfa2/{adsoyad}/{yas}/{mail}/{telefon}/{adres}",
            listOf(
                navArgument(name = "adsoyad"){type= NavType.StringType},
                navArgument(name = "yas"){type= NavType.IntType},
                navArgument(name = "mail"){type= NavType.StringType},
                navArgument(name = "telefon"){type= NavType.StringType},
                navArgument(name = "adres"){type= NavType.StringType}
            ))
        {
            val adsoyad=it.arguments?.getString("adsoyad")!!
            val yas=it.arguments?.getInt("yas")!!
            val mail=it.arguments?.getString("mail")!!
            val telefon=it.arguments?.getString("telefon")!!
            val jsonAdres=it.arguments?.getString("adres")!!
            val adres=Json.decodeFromString<Adres>(jsonAdres)
            Sayfa2(navController=navController,adsoyad,yas,mail,telefon,adres)
        }
    }
}