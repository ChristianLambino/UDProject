package com.castres.breand.block6.p1.androidproject


var gpuList = mutableListOf<Gpu>()

class Gpu(
    var cpu: Int,
    var name: String,
    var price: String,
    var add: String,
    val id: Int? = gpuList.size
)