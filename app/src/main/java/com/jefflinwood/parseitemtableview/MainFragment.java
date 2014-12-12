package com.jefflinwood.parseitemtableview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.jefflinwood.util.ParseItemPositionQueryAdapter;

/**
 * Created by jlinwood on 12/12/14.
 */
public class MainFragment extends Fragment {

    ListView mListView;
    ParseItemPositionQueryAdapter mItemPositionQueryAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        mListView = (ListView) rootView.findViewById(R.id.listView);
        mItemPositionQueryAdapter = new ParseItemPositionQueryAdapter(getActivity(),"Item");
        mListView.setAdapter(mItemPositionQueryAdapter);


        return rootView;
    }
}
