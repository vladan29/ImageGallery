package com.vladan.imagegallery;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PickImageFragment extends ListFragment {
    FragmentActivity listener;
    int offerImageId[];
    // static ArrayList<Integer> pickImageId=new ArrayList<>();
    CustomListAdapter cla;
    CheckBox cb;
    boolean isBoxChecked[];

    public PickImageFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Activity) {
            this.listener = (FragmentActivity) context;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = this.getArguments();
        offerImageId = bundle.getIntArray("offerId");


        // cla = new CustomListAdapter(getActivity(), offerImageId,isBoxChecked);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        LinearLayout fragmentItem = (LinearLayout) inflater.inflate(R.layout.fragment_item, null);
        cb = (CheckBox) fragmentItem.findViewById(R.id.check_box);
        return inflater.inflate(R.layout.fragment_list, container, false);

    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        int k = offerImageId.length;
        isBoxChecked = new boolean[k];
        for (int i = 0; i < k; i++) {
            isBoxChecked[i] = false;
        }
        cla = new CustomListAdapter(getActivity(), offerImageId, isBoxChecked);
        ListView lv = (ListView) view.findViewById(R.id.fragment_list_view);

        lv.setAdapter(cla);


    }


}
