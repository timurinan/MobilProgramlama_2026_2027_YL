package org.example.project

import kotlinx.serialization.Serializable

@Serializable
data class Adres(val mahalle:String,val sokak:String,val cadde:String,val binano:Int) {
}