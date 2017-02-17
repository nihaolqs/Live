package live.lqs.com.RetrofitDemo;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by dell on 2017/2/17.
 */

public class ApiFactoryTest {
    private static ApiFactoryTest sInstance;
    private BlueService mBlueService;
    private Retrofit mRetrofit;

    private ApiFactoryTest(){
        if(sInstance != null){
            return;
        }
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BlueService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mBlueService = mRetrofit.create(BlueService.class);
    }

    //单实例模式
    public static ApiFactoryTest getInstance() {
        if (sInstance == null) {
            sInstance = new ApiFactoryTest();
        }
        return sInstance;
    }

    public BlueService getBlueService(){

        return mBlueService;
    }
}
