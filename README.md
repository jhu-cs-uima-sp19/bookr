# UIMA Fall 2019
## Team 5 Assignment 4
* Nikhil Baddam		nbaddam1@jhu.edu 
* Emma Gan		egan1@jhu.edu
* Lingxi Shang		lshang2@jhu.edu 
* Yuming (Carol) Li 	yli316@jhu.edu

## Implemented features:
Activities:
* LaunchActivity - “BookR” logo and a button labeled “Book Rooms”
* MainActivity - two filters and active booking banner
* SwipeRoomsActivity
* ConfirmActivity - map image, room number, time slots, and confirm/cancel button
Classes for data storage: (SPRINT 2)
* ObjectSerializer - for saving ArrayList to SharedPreferences
* RoomsViewModel - for fragment to activity communication
* BookingDatabase
* DaoAccess
* Rooms
Classes for navigation: (SPRINT 2)
* RoomFragment
* RoomPagerAdapter
* MyRecyclerViewAdapter
Deprecated/unused classes:
* OnSwipeTouchListener (dep.)
* RoomActivity (dep.)
* ActiveRoomsActivity


# Sprint II:

# Summary
* Instantiated relational database with Room
* Created filtering algorithm using database
* Implemented navigation with fragments and scrollable views

# Details:
Database: Read in all the data from the API and store it efficiently. To more easily filter the rooms, we decided to create a database with each row corresponding to a single room. The primary key was the eid, and we had a column for the room name (string) and one for every time slot (boolean). 

Filters: Based on the results of user research, we implemented two filters that users most care about, i.e., the start time and duration. Users are able to select the time they want to use room and all the possible durations they accept, and our filtering algorithm will recommend rooms that satisfy the requirements. 

Navigation: We choose to use lateral swipe to show the list of filtered rooms. Users are able to swipe left and right to see all the rooms that satisfy the requirements. We implemented the navigation page with fragments and scrollable views.

# Non-implemented features:
We didn’t enforce that each booking needed to be a continuous time slot. We didn’t add in Settings, and the login/authentication wasn’t one of our goals for this sprint. It would have been nice if we could’ve made actual bookings. Lingxi was mostly working on redirecting the user to the final confirmation webpage, but we decided to shelve that for sprint 3, if needed.


# Sprint I:

# Summary
* Created a launch activity
* Created a main activity for home page
* Created a room activity
* Created a confirm activity
* Pulled data from API
* Met with Mark Cyzyk for authentication
* Parsed through current bookings to find available time per room
* Implemented the design with font and color consistency

# Details
There are 7 activities in total, but only four are in use: LaunchActivity, RoomsActivity, ConfirmPage, OnSwipeTouchListener. The rest of the activities are in progress and are for sprint 2 (no links yet).

LaunchActivity is the launch page, with the “BookR” logo and a single button labeled “Book Rooms.” Once the user clicks the button, it launches RoomsActivity, where a single room’s available rooms are displayed.

RoomsActivity shows a grid of clickable buttons that are gray, red, green, or blue. Each button corresponds to a 30 minute time slot. Gray means already past times (before the current time), red means unavailable time slot, green is available, and blue is current selection. If you click on a green time slot, it changes to blue. If you click on the blue button, it changes to green. On onCreate(), we only define onClick() for the green buttons.

RoomsActivity uses the OnSwipeTouchListener in order to change the displayed room. From left to right, we display from smallest to largest room number. Currently, the first room shown has real data pulled from the LibCal API. The rest of the rooms are populated using fake data hard-coded from a copy of that information. We do have all the API booking data saved for each room, but for testing purposes (color, clickable properties), it was easier to work with the fake data. (Also, if you test past 5pm, we don’t display those bookings, since we automatically gray out previous times).

Finally, once you select the “Book Rooms” button in RoomsActivity, we launch the ConfirmPage. It shows a hard-coded map image, the corresponding room number, a hard-coded time slot, and confirm and cancel buttons. We have read-only access to the LibCal API, so we can’t make actual bookings. The confirm button goes to LaunchActivity, and the cancel button goes to RoomsActivity.

Nikhil and Emma worked on the back-end API communication, while Lingxi and Carol worked on the front-end design.


