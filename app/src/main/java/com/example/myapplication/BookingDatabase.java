package com.example.myapplication;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Rooms.class}, version = 1, exportSchema = false)
public abstract class BookingDatabase extends RoomDatabase {

    public static final String DB_NAME = "bookings_db";
    public static final String TABLE_NAME_BOOKING = "bookings";

    public abstract DaoAccess daoAccess();

}