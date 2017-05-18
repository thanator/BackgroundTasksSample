package ru.sberbank.mobile.common.rate.net;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import ru.sberbank.backgroundtaskssample.R;
import ru.sberbank.mobile.common.rate.ui.RatesAdapter;

/**
 * Created by Tan-DS on 5/18/2017.
 */

public class RatesActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RatesActivity mRatesActivity;
    private RatesAdapter mRatesAdapter;
    private ProgressBar mProgressBar;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_activity);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        mRatesAdapter = new RatesAdapter();
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh_layout);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
        mRecyclerView.setAdapter(mRatesAdapter);


    }
}
