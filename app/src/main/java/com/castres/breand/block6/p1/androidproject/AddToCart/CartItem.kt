package com.castres.breand.block6.p1.androidproject.AddToCart

// CartItem.kt

import android.os.Parcel
import android.os.Parcelable

data class CartItem(
    val productImageResId: Int,
    val productName: String,
    val productPrice: String,
    val productDescription: String
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!! // Added missing line
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(productImageResId)
        parcel.writeString(productName)
        parcel.writeString(productPrice)
        parcel.writeString(productDescription) // Added missing line
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<CartItem> {
        override fun createFromParcel(parcel: Parcel): CartItem {
            return CartItem(parcel)
        }

        override fun newArray(size: Int): Array<CartItem?> {
            return arrayOfNulls(size)
        }
    }
}








