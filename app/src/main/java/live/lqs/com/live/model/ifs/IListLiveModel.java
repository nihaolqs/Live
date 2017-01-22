package live.lqs.com.live.model.ifs;

import java.util.List;
import java.util.Observer;

import live.lqs.com.live.bean.vo.ifs.ILiveVo;

/**
 * Created by dell on 2017/1/20.
 */

public interface IListLiveModel {
    List<ILiveVo> getLiveList();
    void replaceData(Observer observer);

}
