package com.ismailmesutmujde.kotlinpersonsappbasicdesign.data.entity
/*
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull*/
import com.google.gson.annotations.SerializedName
import java.io.Serializable

// coding for Retrofit
data class Persons (@SerializedName("kisi_id") var person_id : Int,
                    @SerializedName("kisi_ad") var person_name : String,
                    @SerializedName("kisi_tel") var person_phone : String) : Serializable {
}

// coding for Room
/*
@Entity(tableName = "persons")
data class Persons (@PrimaryKey(autoGenerate = true)
                    @ColumnInfo("person_id") @NotNull var person_id : Int,
                    @ColumnInfo("person_name") @NotNull var person_name : String,
                    @ColumnInfo("person_phone") @NotNull var person_phone : String) : Serializable {
}*/