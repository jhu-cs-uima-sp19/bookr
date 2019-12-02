package com.example.myapplication;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Rooms.class}, version = 1, exportSchema = false)
public abstract class BookingDatabase extends RoomDatabase {
    private static BookingDatabase INSTANCE;
    public static final String DB_NAME = "bookings_db";
    public static final String TABLE_NAME_BOOKING = "bookings";

    public abstract DaoAccess daoAccess();

    public static BookingDatabase getBookingDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), BookingDatabase.class,
                            BookingDatabase.DB_NAME).fallbackToDestructiveMigration()
                            .allowMainThreadQueries().build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }
}