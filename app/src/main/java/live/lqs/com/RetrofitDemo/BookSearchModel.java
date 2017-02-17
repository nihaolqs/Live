package live.lqs.com.RetrofitDemo;


import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by dell on 2017/2/17.
 */

public class BookSearchModel {
    public void searchBook() {

        BlueService blueService = ApiFactoryTest.getInstance().getBlueService();
        Call<BookSearchRespose> call = blueService.getSearchBook("小王子", "", 0, 3);
        Log.e("异步请求", "开始");
        call.enqueue(new Callback<BookSearchRespose>() {
            @Override
            public void onResponse(Call<BookSearchRespose> call, Response<BookSearchRespose> response) {
                String s = response.body().getBooks().get(0).getAuthor_intro();
                Log.e("异步请求结果", s);
            }

            @Override
            public void onFailure(Call<BookSearchRespose> call, Throwable t) {
                Log.e("异步请求结果", "失败");
            }
        });
    }
}
