package live.lqs.com.live.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by dell on 2017/1/20.
 */

public class FragmentFactory {
    public static <T extends ABaseFragment> Fragment getFragmentInstance(Class<T> tClass, Bundle bundle) {
        try {
            T t = tClass.newInstance();
            t.setArguments(bundle);
            return t;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
