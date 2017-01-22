package live.lqs.com.live.model.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

import live.lqs.com.live.api.ApiFactory;
import live.lqs.com.live.api.LiveApi;
import live.lqs.com.live.bean.dto.LiveDto;
import live.lqs.com.live.bean.vo.ifs.ILiveVo;
import live.lqs.com.live.model.ifs.IListLiveModel;

/**
 * Created by dell on 2017/1/20.
 */

public class HotLiveModel implements IListLiveModel {

    private LiveApi mLiveApiSingleton = ApiFactory.getLiveApiSingleton();
    private ArrayList<ILiveVo> mLiveVos;

    @Override
    public List<ILiveVo> getLiveList() {
        List<LiveDto> hotLives = mLiveApiSingleton.getHotLiveDto().getHotLives();
        if (mLiveVos == null) {
            mLiveVos = new ArrayList<>();
        } else {
            mLiveVos.clear();
        }
        for (LiveDto dto : hotLives) {
            ILiveVo transform = dto.transform();
            mLiveVos.add(transform);
        }
        return mLiveVos;
    }

    @Override
    public void replaceData(Observer observer) {
        mLiveApiSingleton.addHotLiveObserver(observer);
    }
}
