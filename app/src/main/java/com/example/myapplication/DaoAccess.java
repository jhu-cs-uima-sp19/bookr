package com.example.myapplication;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface DaoAccess {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertRoom(Rooms room);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING)
    List<Rooms> fetchAllRooms();

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE category = :category")
    List<Rooms> fetchByCategory(String category);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE eid = :EID")
    Rooms fetchById(int EID);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE name = :name")
    Rooms fetchByName(String name);

    // filter by time slot
    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE twelveAMday1 = :twelveAM")
    List<Rooms> fetchByTwelveAM(boolean twelveAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE twelveThirtyAMday1 = :twelvethirtyAM")
    List<Rooms> fetchByTwelveThirtyAM(boolean twelvethirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE oneAMday1 = :oneam")
    List<Rooms> fetchByoneAM(boolean oneam);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE oneThirtyAMday1 = :oneThirtyAM")
    List<Rooms> fetchByoneThirtyAM(boolean oneThirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE twoAMday1 = :twoAM")
    List<Rooms> fetchBytwoAM(boolean twoAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE twoThirtyAMday1 = :twoThirtyAM")
    List<Rooms> fetchBytwoThirtyAM(boolean twoThirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE threeAMday1 = :threeAM")
    List<Rooms> fetchBythreeAM(boolean threeAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE threeThirtyAMday1 = :threeThirtyAM")
    List<Rooms> fetchBythreeThirtyAM(boolean threeThirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE fourAMday1 = :fourAM")
    List<Rooms> fetchByfourAM(boolean fourAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE fourThirtyAMday1 = :fourThirtyAM")
    List<Rooms> fetchByfourThirtyAM(boolean fourThirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE fiveAMday1 = :fiveAM")
    List<Rooms> fetchByfiveAM(boolean fiveAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE fiveThirtyAMday1 = :fiveThirtyAM")
    List<Rooms> fetchByfiveThirtyAM(boolean fiveThirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE sixAMday1 = :sixAM")
    List<Rooms> fetchBysixAM(boolean sixAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE sixThirtyAMday1 = :sixThirtyAM")
    List<Rooms> fetchBysixThirtyAM(boolean sixThirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE sevenAMday1 = :sevenAM")
    List<Rooms> fetchBysevenAM(boolean sevenAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE sevenThirtyAMday1 = :sevenThirtyAM")
    List<Rooms> fetchBysevenThirtyAM(boolean sevenThirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE eightAMday1 = :eightAM")
    List<Rooms> fetchByeightAM(boolean eightAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE eightThirtyAMday1 = :eightThirtyAM")
    List<Rooms> fetchByeightThirtyAM(boolean eightThirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE nineAMday1 = :nineAM")
    List<Rooms> fetchBynineAM(boolean nineAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE nineThirtyAMday1 = :nineThirtyAM")
    List<Rooms> fetchBynineThirtyAM(boolean nineThirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE tenAMday1 = :tenAM")
    List<Rooms> fetchBytenAM(boolean tenAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE tenThirtyAMday1 = :tenThirtyAM")
    List<Rooms> fetchBytenThirtyAM(boolean tenThirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE elevenAMday1 = :elevenAM")
    List<Rooms> fetchByelevenAM(boolean elevenAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE elevenThirtyAMday1 = :elevenThirtyAM")
    List<Rooms> fetchByelevenThirtyAM(boolean elevenThirtyAM);

    //pms here
    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE twelvePMday1 = :twelvePM")
    List<Rooms> fetchByTwelvePM(boolean twelvePM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE twelveThirtyPMday1 = :twelvethirtyPM")
    List<Rooms> fetchByTwelveThirtyPM(boolean twelvethirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE onePMday1 = :onePM")
    List<Rooms> fetchByonePM(boolean onePM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE oneThirtyPMday1 = :oneThirtyPM")
    List<Rooms> fetchByoneThirtyPM(boolean oneThirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE twoPMday1 = :twoPM")
    List<Rooms> fetchBytwoPM(boolean twoPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE twoThirtyPMday1 = :twoThirtyPM")
    List<Rooms> fetchBytwoThirtyPM(boolean twoThirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE threePMday1 = :threePM")
    List<Rooms> fetchBythreePM(boolean threePM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE threeThirtyPMday1 = :threeThirtyPM")
    List<Rooms> fetchBythreeThirtyPM(boolean threeThirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE fourPMday1 = :fourPM")
    List<Rooms> fetchByfourPM(boolean fourPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE fourThirtyPMday1 = :fourThirtyPM")
    List<Rooms> fetchByfourThirtyPM(boolean fourThirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE fivePMday1 = :fivePM")
    List<Rooms> fetchByfivePM(boolean fivePM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE fiveThirtyPMday1 = :fiveThirtyPM")
    List<Rooms> fetchByfiveThirtyPM(boolean fiveThirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE sixPMday1 = :sixPM")
    List<Rooms> fetchBysixPM(boolean sixPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE sixThirtyPMday1 = :sixThirtyPM")
    List<Rooms> fetchBysixThirtyPM(boolean sixThirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE sevenPMday1 = :sevenPM")
    List<Rooms> fetchBysevenPM(boolean sevenPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE sevenThirtyPMday1 = :sevenThirtyPM")
    List<Rooms> fetchBysevenThirtyPM(boolean sevenThirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE eightPMday1 = :eightPM")
    List<Rooms> fetchByeightPM(boolean eightPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE eightThirtyPMday1 = :eightThirtyPM")
    List<Rooms> fetchByeightThirtyPM(boolean eightThirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE ninePMday1 = :ninePM")
    List<Rooms> fetchByninePM(boolean ninePM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE nineThirtyPMday1 = :nineThirtyPM")
    List<Rooms> fetchBynineThirtyPM(boolean nineThirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE tenPMday1 = :tenPM")
    List<Rooms> fetchBytenPM(boolean tenPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE tenThirtyPMday1 = :tenThirtyPM")
    List<Rooms> fetchBytenThirtyPM(boolean tenThirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE elevenPMday1 = :elevenPM")
    List<Rooms> fetchByelevenPM(boolean elevenPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE elevenThirtyPMday1 = :elevenThirtyPM")
    List<Rooms> fetchByelevenThirtyPM(boolean elevenThirtyPM);

    // For updating available times
    @Update
    int updateRoom(Rooms room);

    // We should never need this method but just in case
    @Delete
    int deleteRoom(Rooms room);

    @Query("DELETE FROM " + BookingDatabase.TABLE_NAME_BOOKING)
    public void nukeTable();
}