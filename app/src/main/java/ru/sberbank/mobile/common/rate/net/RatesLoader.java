package ru.sberbank.mobile.common.rate.net;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;

import ru.sberbank.mobile.common.rate.entity.RatesBundle;

/**
 * Created by Tan-DS on 5/18/2017.
 */

public class RatesLoader extends AsyncTaskLoader<RatesBundle> {

    private static final String TAG= "RatesLoader";
    private final ICurrencyRateApiMapper mRatesApi;


    public RatesLoader(Context context) {
        super(context);
        mRatesApi = ApiFactory.createApi();

    }

    @Override
    public RatesBundle loadInBackground() {
        Log.v(TAG, "on back");
        return mRatesApi.getRatesBundle();
    }



    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
        Log.v(TAG, "on start loading");
    }
}
