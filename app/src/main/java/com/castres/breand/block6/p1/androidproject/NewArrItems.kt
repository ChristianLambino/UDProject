package com.castres.breand.block6.p1.androidproject

var newArrList = mutableListOf<NewArrItems>()

val NEW_ARR_ID_EXTRA = "newArrExtra"

class NewArrItems(
    var cover: Int,
    var itemName: String,
    var itemPrice: String,
    var description: String,
    var addToCart: Int,
    val id: Int? = newArrList.size
)
