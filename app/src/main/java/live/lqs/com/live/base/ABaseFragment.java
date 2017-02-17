package live.lqs.com.live.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import live.lqs.com.live.EvenBus.BusFactory;

/**
 * Created by dell on 2017/1/20.
 */

public abstract class ABaseFragment extends Fragment {

    private View mFragmentLayout;
    private LayoutInflater mInflater;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mInflater = inflater;
        mFragmentLayout = inflater.inflate(getLayoutRes(), null);
        initView();
        initData(savedInstanceState);
        return mFragmentLayout;
    }

    protected abstract void initData(Bundle savedInstanceState);

    protected abstract void initView();

    protected abstract int getLayoutRes();

    //注册事件总线<OTTO>
    @Override
    public void onResume() {
        BusFactory.getSingletonEvevBus().register(this);
        super.onResume();
    }

    @Override
    public void onPause() {
        BusFactory.getSingletonEvevBus().unregister(this);
        super.onPause();
    }
}
