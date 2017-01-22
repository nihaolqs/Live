package live.lqs.com.live.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

 }
