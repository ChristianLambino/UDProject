package com.castres.breand.block6.p1.androidproject

var partnershipsList = mutableListOf<PartnershipsItems>()

val PARTNERSHIPS_ID_EXTRA = "partnershipsExtra"

class PartnershipsItems (
    var partnershipsCover: Int,
    var partnershipsItemName: String,
    var partnershipsPrice: String,
    var partnershipsDescription: String,
    var partnershipsAddToCart: Int,
    val id: Int = partnershipsList.size
)