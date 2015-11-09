package com.divyeshbc.NHSF.tabs.events;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.divyeshbc.NHSF.R;

/**
 * Created by DivyeshBC on 04/06/15.
 */
public class Tab3 extends Fragment implements RecyclerViewAdapterEvents.ClickListener{

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_3,container,false);
        return v;

        }
    }
