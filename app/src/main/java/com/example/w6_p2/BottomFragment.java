package com.example.w6_p2;

import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import java.io.Serializable;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BottomFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BottomFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ImageView imageView;
    private String id;
    private int [] stars;
    private EditText rating;
    public BottomFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BottomFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BottomFragment newInstance(String param1, String param2) {
        BottomFragment fragment = new BottomFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onSaveInstanceState(final Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntArray("key", stars);
        System.out.println("instance saved");
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
        if (container != null) {
            container.removeAllViews();
        }
        if (savedInstanceState != null) {
            stars = savedInstanceState.getIntArray("key");
        }
        else {
            stars = new int[] {1,2,3,4,5};
        }
        View v = inflater.inflate(R.layout.fragment_bottom, container, false);
        imageView = v.findViewById(R.id.imageView);
        rating = v.findViewById(R.id.rating);
        rating.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() != 0){
                    switch(id){
                        case "dog":
                            stars[0] = (int)charSequence.charAt(0);
                            break;
                        case "cat":
                            stars[1] = (int)charSequence.charAt(0);
                            break;
                        case "lion":
                            stars[2] = (int)charSequence.charAt(0);
                            break;
                        case "wolf":
                            stars[3] = (int)charSequence.charAt(0);
                            break;
                        case "cow":
                            stars[4] = (int)charSequence.charAt(0);
                            break;
                    }
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        if (this.getArguments() == null){
            id = "dog";
        }else {
            id=this.getArguments().getString("animal");
        }
        switch(id){
            case "dog":
                imageView.setImageResource(R.drawable.dog);
                rating.setText(String.valueOf(stars[0]));
                break;
            case "cat":
                imageView.setImageResource(R.drawable.cat);
                rating.setText(String.valueOf(stars[1]));
                break;
            case "lion":
                imageView.setImageResource(R.drawable.lion);
                rating.setText(String.valueOf(stars[2]));
                break;
            case "wolf":
                imageView.setImageResource(R.drawable.wolf);
                rating.setText(String.valueOf(stars[3]));
                break;
            case "cow":
                imageView.setImageResource(R.drawable.cow);
                rating.setText(String.valueOf(stars[4]));
                break;
        }
        return v;
    }
}