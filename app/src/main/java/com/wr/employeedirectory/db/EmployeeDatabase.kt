package com.wr.employeedirectory.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.wr.employeedirectory.models.AddressConverter
import com.wr.employeedirectory.models.CompanyConverter
import com.wr.employeedirectory.models.EmployeeItem

@Database(entities = [EmployeeItem::class], version = 1)
@TypeConverters(AddressConverter::class, CompanyConverter::class)
abstract class EmployeeDatabase : RoomDatabase() {
    abstract fun employeeDao(): EmployeeDao

    companion object {
        @Volatile
        private var INSTANCE: EmployeeDatabase? = null

        fun getDatabase(context: Context): EmployeeDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        EmployeeDatabase::class.java,
                        "employeeDB"
                    )
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}