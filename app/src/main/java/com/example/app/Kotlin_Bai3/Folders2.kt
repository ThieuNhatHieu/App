package com.example.app.Kotlin_Bai3

import android.os.Parcel
import android.os.Parcelable

class Folders2(var Id: Int?, var Name: String?, var Content: String?): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString().toString(),
        parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(Id)
        parcel.writeString(Name)
        parcel.writeString(Content)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Folders2> {
        override fun createFromParcel(parcel: Parcel): Folders2 {
            return Folders2(parcel)
        }

        override fun newArray(size: Int): Array<Folders2?> {
            return arrayOfNulls(size)
        }
    }

}