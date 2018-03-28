package com.rjp.shell.base;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;

import com.rjp.baselistview.simple.SimpleListView;
import com.rjp.shell.R;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;

import java.util.List;

public abstract class LoadMoreListView<T> extends SimpleListView<T> {

    public LoadMoreListView(Context context) {
        super(context);
    }

    public LoadMoreListView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected RefreshFooter getRefreshFooter() {
        return new ClassicsFooter(mContext);
    }

    @Override
    protected RefreshHeader getRefreshHeader() {
        return new DefaultHeader(mContext);
    }

    @Override
    protected View getEmptyView() {
        return LayoutInflater.from(mContext).inflate(R.layout.empty_view, null);
    }

    @Override
    protected void filterData(List<T> mDatas) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    protected void pageNext() {
        mPage ++;
    }

    @Override
    protected boolean hasMoreData(List<T> list) {
        return list.size() >= mPageSize;
    }
}
