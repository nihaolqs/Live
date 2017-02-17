package live.lqs.com.live.EvenBus;

import com.squareup.otto.Bus;

/**
 * Created by dell on 2017/1/23.
 * 单实例的事件总线,作为各个控件之间的事件传递采用线程安全的
 */

public final class BusFactory {

    private BusFactory() { //禁止实例化对象

    }

    protected static final Object monitor = new Object();
    private static Bus mEvenBus;
    public static Bus getSingletonEvevBus(){
        synchronized (monitor){
            if(mEvenBus == null){
                mEvenBus = new Bus();
            }

            return mEvenBus;
        }
    }
}
