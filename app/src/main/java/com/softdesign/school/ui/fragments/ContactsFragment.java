package com.softdesign.school.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.softdesign.school.MainActivity;
import com.softdesign.school.R;
import com.softdesign.school.data.storage.models.User;
import com.softdesign.school.ui.adapters.UsersAdapter;
import com.softdesign.school.utils.BlockToolbar;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ContactsFragment extends Fragment {

    @Bind(R.id.recycle_view) RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<User> users = new ArrayList<User>();
    View mainView;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        generateData();
        mAdapter = new UsersAdapter(users);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (mainView == null) {

            mainView = inflater.inflate(R.layout.fragment_contacts, container, false);
        }

        NavigationView navigationView = (NavigationView) getActivity().findViewById(R.id.navigation_view);
        navigationView.getMenu().findItem(R.id.drawer_contacts).setChecked(true);
        getActivity().setTitle(getResources().getString(R.string.drawer_contacts));

        ButterKnife.bind(this, mainView);
        mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new UsersAdapter(users);
        mRecyclerView.setAdapter(mAdapter);


        return mainView;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        FloatingActionButton fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        CoordinatorLayout.LayoutParams params = (CoordinatorLayout.LayoutParams) fab.getLayoutParams();
        params.setAnchorId(R.id.coordinator_layout);
        params.anchorGravity = Gravity.BOTTOM|Gravity.END;
        fab.setLayoutParams(params);
        fab.setImageResource(R.drawable.ic_mail_24dp);
        AppBarLayout appBar = (AppBarLayout) getActivity().findViewById(R.id.appbar_layout);

        mRecyclerView.setNestedScrollingEnabled(false);
        appBar.setExpanded(false);
        BlockToolbar.setDrag(false, appBar);

    }

    private void generateData() {
        users.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp), "Вова", "Ленин"));
        users.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp), "Иося", "Сталин"));
        users.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp), "Никита", "Хрущев"));
        users.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp), "Леня", "Брежнев"));
        users.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp), "Юра", "Андропов"));
        users.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp), "Костя", "Черненко"));
        users.add(new User(getResources().getDrawable(R.drawable.ic_account_circle_24dp), "Миша", "Горбачев"));
    }
}
