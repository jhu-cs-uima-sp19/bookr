package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Minutes;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.room.Room;

// Instances of this class are fragments representing a single
// object in our collection.
public class RoomFragment extends Fragment {
    public static final String ARG_OBJECT = "eid";
    private BookingDatabase bookingDatabase;
    private ImageButton[] buttons;
    private ArrayList<String> selection = new ArrayList<>();
    private RoomViewModel roomViewModel;

    // Store instance variables
    private int eid;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // The last two arguments ensure LayoutParams are inflated
        // properly.
        View rootView = inflater.inflate(
                R.layout.activity_rooms, container, false);
        Bundle args = getArguments();

        // init ViewModel
        roomViewModel = ViewModelProviders.of(requireActivity()).get(RoomViewModel.class);

        eid = Integer.parseInt(args.getString(ARG_OBJECT));
        bookingDatabase = BookingDatabase.getBookingDatabase(getActivity());
        Rooms room = bookingDatabase.daoAccess().fetchById(eid);

        boolean[] availabilities = createBooleanArray(room);
        createButtonArray(rootView);
        colorButtons(rootView, availabilities);

        System.out.println(rootView + " frag");
        return rootView;
    }

    private void colorButtons(View view, boolean[] input) {
        for (int i = 0; i < input.length; i++) {
            // Set color and OnClick for corresponding buttons
            if (input[i]) {
                ImageButton button = buttons[i];
                button.setImageResource(R.color.lightGreen);
                button.setTag(R.color.lightGreen);

                button.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v)
                    {
                        ImageButton button = view.findViewById(v.getId());
                        if (button.getTag().equals(R.color.blue)) {
                            button.setImageResource(R.color.lightGreen);
                            button.setTag(R.color.lightGreen);
                            selection.remove(button.getId()+"");
                        }
                        else {
                            button.setImageResource(R.color.blue);
                            button.setTag(R.color.blue);
                            selection.add(button.getId() + "");
                        }
                        roomViewModel.setName(selection);
                    }
                });
            }
            else {
                ImageButton button = buttons[i];
                // Check if its before current time or not
                /*
                DateTime dt = new DateTime();
                DateTime back_date = new DateTime("2019-11-11T08:00:00.000");
                Duration duration = new Duration(back_date, dt); */
                int cur_index = getCurrentIndex();//Minutes.minutesBetween(back_date, dt).getMinutes()/30;

                if (i > cur_index) {
                    button.setImageResource(R.color.darkRed);
                    button.setTag(R.color.darkRed);
                    button.setOnClickListener(null);
                } else {
                    button.setImageResource(R.color.inactive);
                    button.setTag(R.color.inactive);
                    button.setOnClickListener(null);
                }
            }
        }

    }

    public ArrayList<String> getSelection() {
        ArrayList<String> selections = new ArrayList<>();
        // find the blue ones!
        for (ImageButton button : buttons) {
            if (button.getTag().equals(R.color.blue)) {
                selections.add(button.getId() + "");
            }
        }
        return selections;
    }

    private int getCurrentIndex() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        int currentIndex = getIndex(dateFormat.format(date).substring(0,2),
                dateFormat.format(date).substring(3), false, false);
        return currentIndex;
    }

    private int getIndex(String hour, String min, boolean isDay2, boolean isEndIndex) {
        int index = 2 * Integer.parseInt(hour);
        if (isEndIndex) {
            index--;
        }
        if (Integer.parseInt(min) >= 30) {
            index++;
        }
        if (isDay2) {
            index += 48;
        }

        return index;
    }

    private boolean[] createBooleanArray(Rooms room) {
        boolean[] b = {
                room.twelveAMday1, room.twelveThirtyAMday1,
                room.oneAMday1, room.oneThirtyAMday1,
                room.twoAMday1, room.twoThirtyAMday1,
                room.threeAMday1, room.threeThirtyAMday1,
                room.fourAMday1, room.fourThirtyAMday1,
                room.fiveAMday1, room.fiveThirtyAMday1,
                room.sixAMday1, room.sixThirtyAMday1,
                room.sevenAMday1, room.sevenThirtyAMday1,
                room.eightAMday1, room.eightThirtyAMday1,
                room.nineAMday1, room.nineThirtyAMday1,
                room.tenAMday1, room.tenThirtyAMday1,
                room.elevenAMday1, room.elevenThirtyAMday1,
                room.twelvePMday1, room.twelveThirtyPMday1,
                room.onePMday1, room.oneThirtyPMday1,
                room.twoPMday1, room.twoThirtyPMday1,
                room.threePMday1, room.threeThirtyPMday1,
                room.fourPMday1, room.fourThirtyPMday1,
                room.fivePMday1, room.fiveThirtyPMday1,
                room.sixPMday1, room.sixThirtyPMday1,
                room.sevenPMday1, room.sevenThirtyPMday1,
                room.eightPMday1, room.eightThirtyPMday1,
                room.ninePMday1, room.nineThirtyPMday1,
                room.tenPMday1, room.tenThirtyPMday1,
                room.elevenPMday1, room.elevenThirtyPMday1,
                room.twelveAMday2, room.twelveThirtyAMday2,
                room.oneAMday2, room.oneThirtyAMday2,
                room.twoAMday2, room.twoThirtyAMday2,
                room.threeAMday2, room.threeThirtyAMday2,
                room.fourAMday2, room.fourThirtyAMday2,
                room.fiveAMday2, room.fiveThirtyAMday2,
                room.sixAMday2, room.sixThirtyAMday2,
                room.sevenAMday2, room.sevenThirtyAMday2,
                room.eightAMday2, room.eightThirtyAMday2,
                room.nineAMday2, room.nineThirtyAMday2,
                room.tenAMday2, room.tenThirtyAMday2,
                room.elevenAMday2, room.elevenThirtyAMday2,
                room.twelvePMday2, room.twelveThirtyPMday2,
                room.onePMday2, room.oneThirtyPMday2,
                room.twoPMday2, room.twoThirtyPMday2,
                room.threePMday2, room.threeThirtyPMday2,
                room.fourPMday2, room.fourThirtyPMday2,
                room.fivePMday2, room.fiveThirtyPMday2,
                room.sixPMday2, room.sixThirtyPMday2,
                room.sevenPMday2, room.sevenThirtyPMday2,
                room.eightPMday2, room.eightThirtyPMday2,
                room.ninePMday2, room.nineThirtyPMday2,
                room.tenPMday2, room.tenThirtyPMday2,
                room.elevenPMday2, room.elevenThirtyPMday2};
        return b;
    }

    private void createButtonArray(View view) {
        buttons = new ImageButton[]{view.findViewById(R.id.twelveaml), view.findViewById(R.id.twelveamr),
                view.findViewById(R.id.oneaml), view.findViewById(R.id.oneamr),
                view.findViewById(R.id.twoaml), view.findViewById(R.id.twoamr),
                view.findViewById(R.id.threeaml), view.findViewById(R.id.threeamr),
                view.findViewById(R.id.fouraml), view.findViewById(R.id.fouramr),
                view.findViewById(R.id.fiveaml), view.findViewById(R.id.fiveamr),
                view.findViewById(R.id.sixaml), view.findViewById(R.id.sixamr),
                view.findViewById(R.id.sevenaml), view.findViewById(R.id.sevenamr),
                view.findViewById(R.id.eightaml), view.findViewById(R.id.eightamr),
                view.findViewById(R.id.nineaml), view.findViewById(R.id.nineamr),
                view.findViewById(R.id.tenaml), view.findViewById(R.id.tenamr),
                view.findViewById(R.id.elevenaml), view.findViewById(R.id.elevenamr),
                view.findViewById(R.id.twelvepml), view.findViewById(R.id.twelvepmr),
                view.findViewById(R.id.onepml), view.findViewById(R.id.onepmr),
                view.findViewById(R.id.twopml), view.findViewById(R.id.twopmr),
                view.findViewById(R.id.threepml), view.findViewById(R.id.threepmr),
                view.findViewById(R.id.fourpml), view.findViewById(R.id.fourpmr),
                view.findViewById(R.id.fivepml), view.findViewById(R.id.fivepmr),
                view.findViewById(R.id.sixpml), view.findViewById(R.id.sixpmr),
                view.findViewById(R.id.sevenpml), view.findViewById(R.id.sevenpmr),
                view.findViewById(R.id.eightpml), view.findViewById(R.id.eightpmr),
                view.findViewById(R.id.ninepml), view.findViewById(R.id.ninepmr),
                view.findViewById(R.id.tenpml), view.findViewById(R.id.tenpmr),
                view.findViewById(R.id.elevenpml), view.findViewById(R.id.elevenpmr),
                view.findViewById(R.id.twelveaml2), view.findViewById(R.id.twelveamr2),
                view.findViewById(R.id.oneaml2), view.findViewById(R.id.oneamr2),
                view.findViewById(R.id.twoaml2), view.findViewById(R.id.twoamr2),
                view.findViewById(R.id.threeaml2), view.findViewById(R.id.threeamr2),
                view.findViewById(R.id.fouraml2), view.findViewById(R.id.fouramr2),
                view.findViewById(R.id.fiveaml2), view.findViewById(R.id.fiveamr2),
                view.findViewById(R.id.sixaml2), view.findViewById(R.id.sixamr2),
                view.findViewById(R.id.sevenaml2), view.findViewById(R.id.sevenamr2),
                view.findViewById(R.id.eightaml2), view.findViewById(R.id.eightamr2),
                view.findViewById(R.id.nineaml2), view.findViewById(R.id.nineamr2),
                view.findViewById(R.id.tenaml2), view.findViewById(R.id.tenamr2),
                view.findViewById(R.id.elevenaml2), view.findViewById(R.id.elevenamr2),
                view.findViewById(R.id.twelvepml2), view.findViewById(R.id.twelvepmr2),
                view.findViewById(R.id.onepml2), view.findViewById(R.id.onepmr2),
                view.findViewById(R.id.twopml2), view.findViewById(R.id.twopmr2),
                view.findViewById(R.id.threepml2), view.findViewById(R.id.threepmr2),
                view.findViewById(R.id.fourpml2), view.findViewById(R.id.fourpmr2),
                view.findViewById(R.id.fivepml2), view.findViewById(R.id.fivepmr2),
                view.findViewById(R.id.sixpml2), view.findViewById(R.id.sixpmr2),
                view.findViewById(R.id.sevenpml2), view.findViewById(R.id.sevenpmr2),
                view.findViewById(R.id.eightpml2), view.findViewById(R.id.eightpmr2),
                view.findViewById(R.id.ninepml2), view.findViewById(R.id.ninepmr2),
                view.findViewById(R.id.tenpml2), view.findViewById(R.id.tenpmr2),
                view.findViewById(R.id.elevenpml2), view.findViewById(R.id.elevenpmr2),
        };
    }
}