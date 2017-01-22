package live.lqs.com.live.api;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.Observable;
import java.util.Observer;

import live.lqs.com.live.bean.dto.HotLiveDto;

/**
 * Created by dell on 2017/1/20.
 */

public class LiveApi {

    private  Context mContext;

    private RequestQueue mRequestQueue;
    private Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(mContext,"网络错误" + error.getMessage(),Toast.LENGTH_SHORT).show();
        }
    };
    private final Gson gson = new Gson();
    private HotLiveDto mHotLiveDto;

    public void initVolley(Context context) {
        if (mContext == null) {
            mContext = context.getApplicationContext();  //确保有可用的Context对象
        }
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(mContext);
        }
    }

    private static final String HOT_LIVE_URL = "";

    private Observable mHotLiveObservable;

    public void addHotLiveObserver(Observer observer) {
        if(mHotLiveObservable == null){
            mHotLiveObservable = new Observable();
        }
        mHotLiveObservable.addObserver(observer);
    }

    public void replaceHotLive() {

        StringRequest request = new StringRequest(Request.Method.GET, HOT_LIVE_URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                mHotLiveDto = gson.fromJson(response, HotLiveDto.class);
                mHotLiveObservable.notifyObservers();
            }
        }, errorListener);
    }

    public HotLiveDto getHotLiveDto(){
        return mHotLiveDto;
    }

}
