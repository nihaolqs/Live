package live.lqs.com.live.presenter;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import live.lqs.com.live.bean.vo.ifs.ILiveVo;
import live.lqs.com.live.model.ifs.IListLiveModel;
import live.lqs.com.live.view.ifs.IListLiveView;

/**
 * Created by dell on 2017/1/20.
 */

public class HotLivePresenter implements Observer {

    private final Context mContext;
    private final IListLiveModel mModel;
    private final IListLiveView mView;
    private List<ILiveVo> mLiveList = new ArrayList<>();

    public HotLivePresenter(Context mContext, IListLiveModel model, IListLiveView view) {
        this.mContext = mContext;
        this.mModel = model;
        this.mView = view;
    }

    public void replaceLives() {
        mLiveList.clear();
        mModel.replaceData(this);
    }

    public void moreLives(){
        mModel.replaceData(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        mLiveList.addAll(mModel.getLiveList());
        mView.showListLive(mLiveList);
    }
}
