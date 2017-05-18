package ru.sberbank.mobile.common.rate.net;

import android.content.Context;
import android.support.v4.content.AsyncTaskLoader;

import ru.sberbank.mobile.common.rate.entity.RatesBundle;

/**
 * Created by Tan-DS on 5/18/2017.
 */

public class RatesLoader extends AsyncTaskLoader<RatesBundle> {

    

    public RatesLoader(Context context) {
        super(context);
    }

    @Override
    public RatesBundle loadInBackground() {
        return null;
    }
}
