package com.mossartscenter.mossartscenterpatrons.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.mossartscenter.mossartscenterpatrons.FeedbackActivity;
import com.mossartscenter.mossartscenterpatrons.MainActivity;
import com.mossartscenter.mossartscenterpatrons.R;
import com.mossartscenter.mossartscenterpatrons.ShowParserJSON;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ShowFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ShowFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShowFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Bundle bundle;
    int showNumber;
    ImageView showImage;
    TextView showTitle;
    TextView showDate;
    TextView showDescription;
    View rootView;
    Button feedback;
    String showString;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ShowFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ShowFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ShowFragment newInstance(String param1, String param2) {
        ShowFragment fragment = new ShowFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_show2, container, false);
        showImage = (ImageView) rootView.findViewById(R.id.showImage);
        showTitle = (TextView) rootView.findViewById(R.id.myShowTitle);
        showDate = (TextView) rootView.findViewById(R.id.myShowDate);
        showDescription = (TextView) rootView.findViewById(R.id.myShowDescription);

        feedback = (Button) rootView.findViewById(R.id.feedback);
        feedback.setOnClickListener(this);
        ShowParserJSON showParserJSON = new ShowParserJSON(getContext(), "showinfo");
        String showString = "";

        if (showNumber == 1) {
            showString = "RoanokeSymphonyOrchestra";
            showImage.setImageResource(R.drawable.orchestra);
        }
        if (showNumber == 2) {
            showString = "Belonging";
        }
        if (showNumber == 3) {
            showString = "KidKoala";
        }
        if (showNumber == 4) {
            showString = "SouthwestVirginiaBallet";
            showImage.setImageResource(R.drawable.romeoandjuliet);
        }
        if (showNumber == 5) {
            showString = "SecretAgent23Skidoo";
        }
        if (showNumber == 6) {
            showString = "StuartPimslerDanceandTheater";
        }
        if (showNumber == 7) {
            showString = "NewYorkGilbertandSullivanPlayers";
        }
        showTitle.setText(showParserJSON.getTitle(showString));
        showDate.setText(showParserJSON.getDate(showString));
        showDescription.setText(showParserJSON.getDescription(showString));
        return rootView;


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
        this.bundle = this.getArguments();
        showNumber = bundle.getInt("titleNumber");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.feedback:
                // Pass the show title onto the feedback activity
                Intent intent = new Intent(getActivity(), FeedbackActivity.class);
                intent.putExtra("showString", showTitle.getText().toString());
                System.out.println(showTitle.getText().toString());
                startActivity(intent);
                break;
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
