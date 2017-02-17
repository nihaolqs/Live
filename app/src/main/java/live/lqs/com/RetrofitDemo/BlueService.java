package live.lqs.com.RetrofitDemo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by dell on 2017/2/17.
 */

public interface BlueService {

    String BASE_URL = "https://api.douban.com/v2/";

    @GET("book/search")
    Call<BookSearchRespose> getSearchBook(@Query("q") String name,
                               @Query("tag") String tag,
                               @Query("start") int start,
                               @Query("count") int count);

}
