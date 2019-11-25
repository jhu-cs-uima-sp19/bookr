package com.example.myapplication;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface DaoAccess {

    @Insert
    long insertRoom(Rooms room);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING)
    List<Rooms> fetchAllRooms();

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE category = :category")
    List<Rooms> fetchByCategory(String category);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE eid = :EID")
    Rooms fetchById(int EID);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE name = :name")
    Rooms fetchByName(String name);

    // filter by time slot
    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE twelveAM = :twelveAM")
    List<Rooms> fetchByTwelveAM(boolean twelveAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE twelveThirtyAM = :twelvethirtyAM")
    List<Rooms> fetchByTwelveThirtyAM(boolean twelvethirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE oneAM = :oneam")
    List<Rooms> fetchByoneAM(boolean oneam);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE oneThirtyAM = :oneThirtyAM")
    List<Rooms> fetchByoneThirtyAM(boolean oneThirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE twoAM = :twoAM")
    List<Rooms> fetchBytwoAM(boolean twoAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE twoThirtyAM = :twoThirtyAM")
    List<Rooms> fetchBytwoThirtyAM(boolean twoThirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE threeAM = :threeAM")
    List<Rooms> fetchBythreeAM(boolean threeAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE threeThirtyAM = :threeThirtyAM")
    List<Rooms> fetchBythreeThirtyAM(boolean threeThirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE fourAM = :fourAM")
    List<Rooms> fetchByfourAM(boolean fourAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE fourThirtyAM = :fourThirtyAM")
    List<Rooms> fetchByfourThirtyAM(boolean fourThirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE fiveAM = :fiveAM")
    List<Rooms> fetchByfiveAM(boolean fiveAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE fiveThirtyAM = :fiveThirtyAM")
    List<Rooms> fetchByfiveThirtyAM(boolean fiveThirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE sixAM = :sixAM")
    List<Rooms> fetchBysixAM(boolean sixAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE sixThirtyAM = :sixThirtyAM")
    List<Rooms> fetchBysixThirtyAM(boolean sixThirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE sevenAM = :sevenAM")
    List<Rooms> fetchBysevenAM(boolean sevenAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE sevenThirtyAM = :sevenThirtyAM")
    List<Rooms> fetchBysevenThirtyAM(boolean sevenThirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE eightAM = :eightAM")
    List<Rooms> fetchByeightAM(boolean eightAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE eightThirtyAM = :eightThirtyAM")
    List<Rooms> fetchByeightThirtyAM(boolean eightThirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE nineAM = :nineAM")
    List<Rooms> fetchBynineAM(boolean nineAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE nineThirtyAM = :nineThirtyAM")
    List<Rooms> fetchBynineThirtyAM(boolean nineThirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE tenAM = :tenAM")
    List<Rooms> fetchBytenAM(boolean tenAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE tenThirtyAM = :tenThirtyAM")
    List<Rooms> fetchBytenThirtyAM(boolean tenThirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE elevenAM = :elevenAM")
    List<Rooms> fetchByelevenAM(boolean elevenAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE elevenThirtyAM = :elevenThirtyAM")
    List<Rooms> fetchByelevenThirtyAM(boolean elevenThirtyAM);

    //pms here
    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE twelvePM = :twelvePM")
    List<Rooms> fetchByTwelvePM(boolean twelvePM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE twelveThirtyPM = :twelvethirtyPM")
    List<Rooms> fetchByTwelveThirtyPM(boolean twelvethirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE onePM = :onePM")
    List<Rooms> fetchByonePM(boolean onePM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE oneThirtyPM = :oneThirtyPM")
    List<Rooms> fetchByoneThirtyPM(boolean oneThirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE twoPM = :twoPM")
    List<Rooms> fetchBytwoPM(boolean twoPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE twoThirtyPM = :twoThirtyPM")
    List<Rooms> fetchBytwoThirtyPM(boolean twoThirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE threePM = :threePM")
    List<Rooms> fetchBythreePM(boolean threePM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE threeThirtyPM = :threeThirtyPM")
    List<Rooms> fetchBythreeThirtyPM(boolean threeThirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE fourPM = :fourPM")
    List<Rooms> fetchByfourPM(boolean fourPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE fourThirtyPM = :fourThirtyPM")
    List<Rooms> fetchByfourThirtyPM(boolean fourThirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE fivePM = :fivePM")
    List<Rooms> fetchByfivePM(boolean fivePM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE fiveThirtyPM = :fiveThirtyPM")
    List<Rooms> fetchByfiveThirtyPM(boolean fiveThirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE sixPM = :sixPM")
    List<Rooms> fetchBysixPM(boolean sixPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE sixThirtyPM = :sixThirtyPM")
    List<Rooms> fetchBysixThirtyPM(boolean sixThirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE sevenPM = :sevenPM")
    List<Rooms> fetchBysevenPM(boolean sevenPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE sevenThirtyPM = :sevenThirtyPM")
    List<Rooms> fetchBysevenThirtyPM(boolean sevenThirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE eightPM = :eightPM")
    List<Rooms> fetchByeightPM(boolean eightPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE eightThirtyPM = :eightThirtyPM")
    List<Rooms> fetchByeightThirtyPM(boolean eightThirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE ninePM = :ninePM")
    List<Rooms> fetchByninePM(boolean ninePM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE nineThirtyPM = :nineThirtyPM")
    List<Rooms> fetchBynineThirtyPM(boolean nineThirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE tenPM = :tenPM")
    List<Rooms> fetchBytenPM(boolean tenPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE tenThirtyPM = :tenThirtyPM")
    List<Rooms> fetchBytenThirtyPM(boolean tenThirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE elevenPM = :elevenPM")
    List<Rooms> fetchByelevenPM(boolean elevenPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE elevenThirtyPM = :elevenThirtyPM")
    List<Rooms> fetchByelevenThirtyPM(boolean elevenThirtyPM);

    // For updating available times
    @Update
    int updateRoom(Rooms room);

    // We should never need this method but just in case
    @Delete
    int deleteRoom(Rooms room);
}