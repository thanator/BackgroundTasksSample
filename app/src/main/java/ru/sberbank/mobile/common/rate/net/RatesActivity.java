package ru.sberbank.mobile.common.rate.net;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import ru.sberbank.backgroundtaskssample.R;
import ru.sberbank.mobile.common.rate.entity.RatesBundle;
import ru.sberbank.mobile.common.rate.ui.RatesAdapter;

/**
 * Created by Tan-DS on 5/18/2017.
 */

public class RatesActivity extends AppCompatActivity {

    private final static int LOADER_ID = 123;
    private final static String TAG = "RatesActivity";

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
        getSupportLoaderManager().initLoader(LOADER_ID, null, new RatesLoaderCallBacks());
        Log.v(TAG, "onCreate");


    }



    private class RatesLoaderCallBacks implements LoaderManager.LoaderCallbacks <RatesBundle>{


        @Override
        public Loader<RatesBundle> onCreateLoader(int id, Bundle args) {
            return new RatesLoader(RatesActivity.this);
        }

        @Override
        public void onLoadFinished(Loader<RatesBundle> loader, RatesBundle data) {
            mRatesAdapter.setRates(data.getRates());
            mProgressBar.setVisibility(View.GONE);
            mSwipeRefreshLayout.setVisibility(View.VISIBLE);
        }

        @Override
        public void onLoaderReset(Loader<RatesBundle> loader) {
            mProgressBar.setVisibility(View.VISIBLE);
            mSwipeRefreshLayout.setVisibility(View.GONE);
        }
    }

}
