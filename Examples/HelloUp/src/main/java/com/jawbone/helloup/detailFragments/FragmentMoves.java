package com.jawbone.helloup.detailFragments;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.jawbone.helloup.R;
import com.jawbone.helloup.base.DefaultFragment;
import com.jawbone.upplatformsdk.api.ApiManager;
import com.jawbone.upplatformsdk.endpointModels.move.Move;
import com.jawbone.upplatformsdk.utils.UpPlatformSdkConstants;

import java.util.HashMap;

import butterknife.ButterKnife;
import butterknife.InjectView;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by <a href="mailto:marcusandreog@gmail.com">Marcus Gabilheri</a>
 *
 * @author Marcus Gabilheri
 * @version 1.0
 * @since 2/13/15.
 */
public class FragmentMoves extends DefaultFragment {

    private static final String TAG = FragmentMoves.class.getSimpleName();

    @InjectView(R.id.moveListText)
    TextView movesListText;

    //TODO make a design to actually show the Data in a more readable way.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        ButterKnife.inject(this, view);
        ApiManager.getRestApiInterface().getMoveEventsList(
                UpPlatformSdkConstants.API_VERSION_STRING,
                getMoveEventsListRequestParams(),
                new Callback<Move>() {
                    @Override
                    public void success(Move move, Response response) {
                        movesListText.setText(move.toString());
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Log.d(TAG, error.getMessage());
                    }
                });
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_move_list;
    }

    private static HashMap<String, Integer> getMoveEventsListRequestParams() {
        HashMap<String, Integer> queryHashMap = new HashMap<>();

        //uncomment to add as needed parameters
//        queryHashMap.put("date", "<insert-date>");
//        queryHashMap.put("page_token", "<insert-page-token>");
//        queryHashMap.put("start_time", "<insert-time>");
//        queryHashMap.put("end_time", "<insert-time>");
//        queryHashMap.put("updated_after", "<insert-time>");

        return queryHashMap;
    }

}
