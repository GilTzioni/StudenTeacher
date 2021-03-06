package com.example.helloworld.models
import android.os.Parcel
import android.os.Parcelable

data class User(
    val uid: String = "",
    val name: String = "",
    val email: String = "",
    var allProfession: ArrayList<String> = ArrayList(),
    var mobile: Long = 0,
    var area: String = "",
    val gender: String = "",
    var image: String = "",
    var age: Int = 0,
    var price: HashMap<String, Int> = HashMap(),
    var chatList: HashMap<String, User> = HashMap()



) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.createStringArrayList()!!,
        parcel.readLong(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt()!!,
        parcel.readHashMap(Int::class.java.classLoader)!! as HashMap<String, Int>,
        parcel.readHashMap(User::class.java.classLoader)!! as HashMap<String, User>
    )

   
    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(uid)
        writeString(name)
        writeString(email)
        writeStringList(allProfession)
        writeLong(mobile)
        writeString(area)
        writeString(gender)
        writeString(image)
        writeInt(age)
        writeMap(price)
        writeMap(chatList)

//        writeString(profession2)
//        writeString(profession3)
    }

//    companion object CREATOR : Parcelable.Creator<User> {
//        override fun createFromParcel(parcel: Parcel): User {
//            return User(parcel)
//        }
//
//        override fun newArray(size: Int): Array<User?> {
//            return arrayOfNulls(size)
//        }
//    }


    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<User> = object : Parcelable.Creator<User> {
            override fun createFromParcel(source: Parcel): User = User(source)
            override fun newArray(size: Int): Array<User?> = arrayOfNulls(size)
        }
    }
}