package com.example.hafta2

fun main(){
    var dizi= ArrayList<String>()

    dizi.add("Elma")
    dizi.add("Armut")
    dizi.add("Muz")

    for (t in 0 until dizi.size){
        println(dizi.get(t))
    }

    for ((index,deger) in dizi.withIndex()){
        println("$index .indeksin değeri: $deger")
    }

}