package com.rjp.shell.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.rjp.shell.R;
import com.rjp.shell.R2;
import com.rjp.shell.base.BaseFragment;
import com.rjp.shell.listviews.PlayerListView;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PlayerFragment extends BaseFragment {

    @BindView(R2.id.player_list_view)
    PlayerListView playerListView;

    public PlayerFragment() {
        // Required empty public constructor
    }

    public static PlayerFragment getInstance(){
        return new PlayerFragment();
    }

    public static PlayerFragment getInstance(String tag){
        PlayerFragment homeNewsFragment = new PlayerFragment();
        Bundle args = new Bundle();
        args.putString("tag", tag);
        homeNewsFragment.setArguments(args);
        return homeNewsFragment;
    }

    @Override
    public int getChildViewLayoutId() {
        return R.layout.fragment_player;
    }

    @Override
    public void initView() {
        Bundle arguments = getArguments();
        if(arguments.containsKey("tag")){
            String tag = arguments.getString("tag");
            playerListView.requestData(tag);
        }
    }

    @Override
    public void reload() {

    }
}
