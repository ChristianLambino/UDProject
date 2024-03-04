package com.castres.breand.block6.p1.androidproject

var componentsList = mutableListOf<ComponentsItems>()

val COMPONENTS_ID_EXTRA = "componentsExtra"

class ComponentsItems (
    var componentsCover: Int,
    var componentsItemName: String,
    var componentsPrice: String,
    var componentsDescription: String,
    val id: Int? = componentsList.size

)



