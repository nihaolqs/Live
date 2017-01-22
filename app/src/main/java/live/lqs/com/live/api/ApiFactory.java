package live.lqs.com.live.api;

/**
 * Created by dell on 2017/1/20.
 */

public class ApiFactory {

    protected static final Object monitor = new Object();
    static LiveApi sLiveApiSingleton = null;


    //return Singleton
    public static LiveApi getLiveApiSingleton() {
        synchronized (monitor) {
            if (sLiveApiSingleton == null) {
                sLiveApiSingleton = new LiveApi();
            }
            return sLiveApiSingleton;
        }
    }
}
