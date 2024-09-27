package com.ismailmesutmujde.kotlinpersonsappbasicdesign.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "persons")
data class Persons (@PrimaryKey(autoGenerate = true)
                    @ColumnInfo("person_id") @NotNull var person_id : Int,
                    @ColumnInfo("person_name") @NotNull var person_name : String,
                    @ColumnInfo("person_phone") @NotNull var person_phone : String) : Serializable {
}