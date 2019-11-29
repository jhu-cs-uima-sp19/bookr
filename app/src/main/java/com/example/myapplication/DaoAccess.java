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
    List<Rooms> fetchByTwelveAMday1(boolean twelveAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE twelveThirtyAMday1 = :twelvethirtyAM")
    List<Rooms> fetchByTwelveThirtyAMday1(boolean twelvethirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE oneAMday1 = :oneam")
    List<Rooms> fetchByoneAMday1(boolean oneam);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE oneThirtyAMday1 = :oneThirtyAM")
    List<Rooms> fetchByoneThirtyAMday1(boolean oneThirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE twoAMday1 = :twoAM")
    List<Rooms> fetchBytwoAMday1(boolean twoAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE twoThirtyAMday1 = :twoThirtyAM")
    List<Rooms> fetchBytwoThirtyAMday1(boolean twoThirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE threeAMday1 = :threeAM")
    List<Rooms> fetchBythreeAMday1(boolean threeAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE threeThirtyAMday1 = :threeThirtyAM")
    List<Rooms> fetchBythreeThirtyAMday1(boolean threeThirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE fourAMday1 = :fourAM")
    List<Rooms> fetchByfourAMday1(boolean fourAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE fourThirtyAMday1 = :fourThirtyAM")
    List<Rooms> fetchByfourThirtyAMday1(boolean fourThirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE fiveAMday1 = :fiveAM")
    List<Rooms> fetchByfiveAMday1(boolean fiveAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE fiveThirtyAMday1 = :fiveThirtyAM")
    List<Rooms> fetchByfiveThirtyAMday1(boolean fiveThirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE sixAMday1 = :sixAM")
    List<Rooms> fetchBysixAMday1(boolean sixAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE sixThirtyAMday1 = :sixThirtyAM")
    List<Rooms> fetchBysixThirtyAMday1(boolean sixThirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE sevenAMday1 = :sevenAM")
    List<Rooms> fetchBysevenAMday1(boolean sevenAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE sevenThirtyAMday1 = :sevenThirtyAM")
    List<Rooms> fetchBysevenThirtyAMday1(boolean sevenThirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE eightAMday1 = :eightAM")
    List<Rooms> fetchByeightAMday1(boolean eightAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE eightThirtyAMday1 = :eightThirtyAM")
    List<Rooms> fetchByeightThirtyAMday1(boolean eightThirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE nineAMday1 = :nineAM")
    List<Rooms> fetchBynineAMday1(boolean nineAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE nineThirtyAMday1 = :nineThirtyAM")
    List<Rooms> fetchBynineThirtyAMday1(boolean nineThirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE tenAMday1 = :tenAM")
    List<Rooms> fetchBytenAMday1(boolean tenAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE tenThirtyAMday1 = :tenThirtyAM")
    List<Rooms> fetchBytenThirtyAMday1(boolean tenThirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE elevenAMday1 = :elevenAM")
    List<Rooms> fetchByelevenAMday1(boolean elevenAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE elevenThirtyAMday1 = :elevenThirtyAM")
    List<Rooms> fetchByelevenThirtyAMday1(boolean elevenThirtyAM);

    //pms here
    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE twelvePMday1 = :twelvePM")
    List<Rooms> fetchByTwelvePMday1(boolean twelvePM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE twelveThirtyPMday1 = :twelvethirtyPM")
    List<Rooms> fetchByTwelveThirtyPMday1(boolean twelvethirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE onePMday1 = :onePM")
    List<Rooms> fetchByonePMday1(boolean onePM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE oneThirtyPMday1 = :oneThirtyPM")
    List<Rooms> fetchByoneThirtyPMday1(boolean oneThirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE twoPMday1 = :twoPM")
    List<Rooms> fetchBytwoPMday1(boolean twoPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE twoThirtyPMday1 = :twoThirtyPM")
    List<Rooms> fetchBytwoThirtyPMday1(boolean twoThirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE threePMday1 = :threePM")
    List<Rooms> fetchBythreePMday1(boolean threePM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE threeThirtyPMday1 = :threeThirtyPM")
    List<Rooms> fetchBythreeThirtyPMday1(boolean threeThirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE fourPMday1 = :fourPM")
    List<Rooms> fetchByfourPMday1(boolean fourPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE fourThirtyPMday1 = :fourThirtyPM")
    List<Rooms> fetchByfourThirtyPMday1(boolean fourThirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE fivePMday1 = :fivePM")
    List<Rooms> fetchByfivePMday1(boolean fivePM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE fiveThirtyPMday1 = :fiveThirtyPM")
    List<Rooms> fetchByfiveThirtyPMday1(boolean fiveThirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE sixPMday1 = :sixPM")
    List<Rooms> fetchBysixPMday1(boolean sixPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE sixThirtyPMday1 = :sixThirtyPM")
    List<Rooms> fetchBysixThirtyPMday1(boolean sixThirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE sevenPMday1 = :sevenPM")
    List<Rooms> fetchBysevenPMday1(boolean sevenPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE sevenThirtyPMday1 = :sevenThirtyPM")
    List<Rooms> fetchBysevenThirtyPMday1(boolean sevenThirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE eightPMday1 = :eightPM")
    List<Rooms> fetchByeightPMday1(boolean eightPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE eightThirtyPMday1 = :eightThirtyPM")
    List<Rooms> fetchByeightThirtyPMday1(boolean eightThirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE ninePMday1 = :ninePM")
    List<Rooms> fetchByninePMday1(boolean ninePM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE nineThirtyPMday1 = :nineThirtyPM")
    List<Rooms> fetchBynineThirtyPMday1(boolean nineThirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE tenPMday1 = :tenPM")
    List<Rooms> fetchBytenPMday1(boolean tenPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE tenThirtyPMday1 = :tenThirtyPM")
    List<Rooms> fetchBytenThirtyPMday1(boolean tenThirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE elevenPMday1 = :elevenPM")
    List<Rooms> fetchByelevenPMday1(boolean elevenPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE elevenThirtyPMday1 = :elevenThirtyPM")
    List<Rooms> fetchByelevenThirtyPMday1(boolean elevenThirtyPM);
    ///







    ///
    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE twelveAMday2 = :twelveAM")
    List<Rooms> fetchByTwelveAMday2(boolean twelveAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE twelveThirtyAMday2 = :twelvethirtyAM")
    List<Rooms> fetchByTwelveThirtyAMday2(boolean twelvethirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE oneAMday2 = :oneam")
    List<Rooms> fetchByoneAMday2(boolean oneam);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE oneThirtyAMday2 = :oneThirtyAM")
    List<Rooms> fetchByoneThirtyAMday2(boolean oneThirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE twoAMday2 = :twoAM")
    List<Rooms> fetchBytwoAMday2(boolean twoAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE twoThirtyAMday2 = :twoThirtyAM")
    List<Rooms> fetchBytwoThirtyAMday2(boolean twoThirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE threeAMday2 = :threeAM")
    List<Rooms> fetchBythreeAMday2(boolean threeAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE threeThirtyAMday2 = :threeThirtyAM")
    List<Rooms> fetchBythreeThirtyAMday2(boolean threeThirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE fourAMday2 = :fourAM")
    List<Rooms> fetchByfourAMday2(boolean fourAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE fourThirtyAMday2 = :fourThirtyAM")
    List<Rooms> fetchByfourThirtyAMday2(boolean fourThirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE fiveAMday2 = :fiveAM")
    List<Rooms> fetchByfiveAMday2(boolean fiveAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE fiveThirtyAMday2 = :fiveThirtyAM")
    List<Rooms> fetchByfiveThirtyAMday2(boolean fiveThirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE sixAMday2 = :sixAM")
    List<Rooms> fetchBysixAMday2(boolean sixAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE sixThirtyAMday2 = :sixThirtyAM")
    List<Rooms> fetchBysixThirtyAMday2(boolean sixThirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE sevenAMday2 = :sevenAM")
    List<Rooms> fetchBysevenAMday2(boolean sevenAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE sevenThirtyAMday2 = :sevenThirtyAM")
    List<Rooms> fetchBysevenThirtyAMday2(boolean sevenThirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE eightAMday2 = :eightAM")
    List<Rooms> fetchByeightAMday2(boolean eightAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE eightThirtyAMday2 = :eightThirtyAM")
    List<Rooms> fetchByeightThirtyAMday2(boolean eightThirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE nineAMday2 = :nineAM")
    List<Rooms> fetchBynineAMday2(boolean nineAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE nineThirtyAMday2 = :nineThirtyAM")
    List<Rooms> fetchBynineThirtyAMday2(boolean nineThirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE tenAMday2 = :tenAM")
    List<Rooms> fetchBytenAMday2(boolean tenAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE tenThirtyAMday2 = :tenThirtyAM")
    List<Rooms> fetchBytenThirtyAMday2(boolean tenThirtyAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE elevenAMday2 = :elevenAM")
    List<Rooms> fetchByelevenAMday2(boolean elevenAM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE elevenThirtyAMday2 = :elevenThirtyAM")
    List<Rooms> fetchByelevenThirtyAMday2(boolean elevenThirtyAM);

    //pms here
    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE twelvePMday2 = :twelvePM")
    List<Rooms> fetchByTwelvePMday2(boolean twelvePM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE twelveThirtyPMday2 = :twelvethirtyPM")
    List<Rooms> fetchByTwelveThirtyPMday2(boolean twelvethirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE onePMday2 = :onePM")
    List<Rooms> fetchByonePMday2(boolean onePM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE oneThirtyPMday2 = :oneThirtyPM")
    List<Rooms> fetchByoneThirtyPMday2(boolean oneThirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE twoPMday2 = :twoPM")
    List<Rooms> fetchBytwoPMday2(boolean twoPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE twoThirtyPMday2 = :twoThirtyPM")
    List<Rooms> fetchBytwoThirtyPMday2(boolean twoThirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE threePMday2 = :threePM")
    List<Rooms> fetchBythreePMday2(boolean threePM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE threeThirtyPMday2 = :threeThirtyPM")
    List<Rooms> fetchBythreeThirtyPMday2(boolean threeThirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE fourPMday2 = :fourPM")
    List<Rooms> fetchByfourPMday2(boolean fourPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE fourThirtyPMday2 = :fourThirtyPM")
    List<Rooms> fetchByfourThirtyPMday2(boolean fourThirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE fivePMday2 = :fivePM")
    List<Rooms> fetchByfivePMday2(boolean fivePM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE fiveThirtyPMday2 = :fiveThirtyPM")
    List<Rooms> fetchByfiveThirtyPMday2(boolean fiveThirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE sixPMday2 = :sixPM")
    List<Rooms> fetchBysixPMday2(boolean sixPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE sixThirtyPMday2 = :sixThirtyPM")
    List<Rooms> fetchBysixThirtyPMday2(boolean sixThirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE sevenPMday2 = :sevenPM")
    List<Rooms> fetchBysevenPMday2(boolean sevenPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE sevenThirtyPMday2 = :sevenThirtyPM")
    List<Rooms> fetchBysevenThirtyPMday2(boolean sevenThirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE eightPMday2 = :eightPM")
    List<Rooms> fetchByeightPMday2(boolean eightPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE eightThirtyPMday2 = :eightThirtyPM")
    List<Rooms> fetchByeightThirtyPMday2(boolean eightThirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE ninePMday2 = :ninePM")
    List<Rooms> fetchByninePMday2(boolean ninePM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE nineThirtyPMday2 = :nineThirtyPM")
    List<Rooms> fetchBynineThirtyPMday2(boolean nineThirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE tenPMday2 = :tenPM")
    List<Rooms> fetchBytenPMday2(boolean tenPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE tenThirtyPMday2 = :tenThirtyPM")
    List<Rooms> fetchBytenThirtyPMday2(boolean tenThirtyPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE elevenPMday2 = :elevenPM")
    List<Rooms> fetchByelevenPMday2(boolean elevenPM);

    @Query("SELECT * FROM " + BookingDatabase.TABLE_NAME_BOOKING + " WHERE elevenThirtyPMday2 = :elevenThirtyPM")
    List<Rooms> fetchByelevenThirtyPMday2(boolean elevenThirtyPM);

    // For updating available times
    @Update
    int updateRoom(Rooms room);

    // We should never need this method but just in case
    @Delete
    int deleteRoom(Rooms room);

    @Query("DELETE FROM " + BookingDatabase.TABLE_NAME_BOOKING)
    public void nukeTable();
}