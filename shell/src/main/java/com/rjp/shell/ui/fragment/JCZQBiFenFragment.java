package com.rjp.shell.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.rjp.shell.R;
import com.rjp.shell.R2;
import com.rjp.shell.base.BaseFragment;
import com.rjp.shell.listviews.JCZQBiFenListView;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 */
public class JCZQBiFenFragment extends BaseFragment {

    @BindView(R2.id.bifen_list_view)
    JCZQBiFenListView bifenListView;

    public JCZQBiFenFragment() {
        // Required empty public constructor
    }

    public static JCZQBiFenFragment getInstance(){
        return new JCZQBiFenFragment();
    }

    public static JCZQBiFenFragment getInstance(String tag){
        JCZQBiFenFragment homeNewsFragment = new JCZQBiFenFragment();
        Bundle args = new Bundle();
        args.putString("tag", tag);
        homeNewsFragment.setArguments(args);
        return homeNewsFragment;
    }

    @Override
    public int getChildViewLayoutId() {
        return R.layout.fragment_jczq_bifen;
    }

    @Override
    public void initView() {
        Bundle arguments = getArguments();
        if(arguments.containsKey("tag")){
            String tag = arguments.getString("tag");
            bifenListView.requestData(tag);
        }
    }

    @Override
    public void reload() {

    }
}
