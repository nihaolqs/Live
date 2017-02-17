package live.lqs.com.live.base;

/**
 * Created by dell on 2017/1/23.
 * 接口用于Presenter 与 View 之间的相助注册,
 */

public interface IPresenterView {

    void registerView();

    void unregisterView();

    ABasePresenter getPresenter(String tag);
}
