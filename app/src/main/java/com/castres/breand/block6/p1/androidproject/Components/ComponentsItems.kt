package com.castres.breand.block6.p1.androidproject.Components


val COMPONENTS_ID_EXTRA = "componentsExtra"

data class ComponentsItems(
    var category: String,
    var id: Int,
    var description: String,
    var prod_name: String,
    var image: String,
    var price: String
)


data class ComponentsDetailItems(
    var id: Int,
    var prod_name: String,
    var description: String,
    var price: String,
    var image: String,
    var category: String
)

