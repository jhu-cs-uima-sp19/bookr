# UIMA Fall 2019
## Team 5 Assignment 4
* Nikhil Baddam		nbaddam1@jhu.edu 
* Emma Gan		egan1@jhu.edu
* Lingxi Shang		lshang2@jhu.edu 
* Yuming (Carol) Li 	yli316@jhu.edu

## Implemented features:

There are 7 activities in total, but only four are in use: LaunchActivity, RoomsActivity, ConfirmPage, OnSwipeTouchListener. The rest of the activities are in progress and are for sprint 2 (no links yet).

LaunchActivity is the launch page, with the “BookR” logo and a single button labeled “Book Rooms.” Once the user clicks the button, it launches RoomsActivity, where a single room’s available rooms are displayed.

RoomsActivity shows a grid of clickable buttons that are gray, red, green, or blue. Each button corresponds to a 30 minute time slot. Gray means already past times (before the current time), red means unavailable time slot, green is available, and blue is current selection. If you click on a green time slot, it changes to blue. If you click on the blue button, it changes to green. On onCreate(), we only define onClick() for the green buttons.

RoomsActivity uses the OnSwipeTouchListener in order to change the displayed room. From left to right, we display from smallest to largest room number. Currently, the first room shown has real data pulled from the LibCal API. The rest of the rooms are populated using fake data hard-coded from a copy of that information. We do have all the API booking data saved for each room, but for testing purposes (color, clickable properties), it was easier to work with the fake data. (Also, if you test past 5pm, we don’t display those bookings, since we automatically gray out previous times).

Finally, once you select the “Book Rooms” button in RoomsActivity, we launch the ConfirmPage. It shows a hard-coded map image, the corresponding room number, a hard-coded time slot, and confirm and cancel buttons. We have read-only access to the LibCal API, so we can’t make actual bookings. The confirm button goes to LaunchActivity, and the cancel button goes to RoomsActivity. 

Nikhil and Emma worked on the back-end API communication, while Lingxi and Carol worked on the front-end design.
 
## Non-implemented features:
No filters were implemented. We have a MainActivity that shows the filters we want to have in the future, but it has no links to any other layouts and activities yet. After we pull in data from the API, we don’t rank or filter the rooms: we display rooms in sequential order, by room number. The only API endpoint we use is /spaces/bookings/, which returns all the current bookings. We parse through all bookings and extract the room id, start time, and end time. Then, we translate that to a boolean array of 96 time slots and mark each one with true if available and after the current time and false otherwise. 


## Challenges:
Getting the API to work in Android Studio was difficult. Nikhil and Emma met with the library app manager, Mark Cyzyk, to get the client_id and client_url and ask about OAuth2 authentication. It was relatively easy to communicate with the API through terminal, but we struggled translating that to Android Studio. We experimented with many libraries for Android Studio (OAuth2, ScribeJava, Volley) and also tried to manually post and get requests to the jhu libcal website. Most of the support is for OAuth2 grant type authorization code. However, our grant type was client_credentials, for machine-to-machine interactions. We ended up using Volley and getting the access token as a String, then substringing the relevant portion.

Another back-end difficulty was with the initialization of the app. In onCreate(), we call a method that communicates with the API and saves the access token to SharedPreferences. However, that process is slow, but we need the access token for the next methods called onCreate(), to make GET requests and parse through the data.
