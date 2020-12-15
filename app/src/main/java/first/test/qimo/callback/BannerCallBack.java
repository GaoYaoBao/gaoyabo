package first.test.qimo.callback;

import first.test.qimo.bean.BannerBean;

public interface BannerCallBack {
    void onSuccess(BannerBean bannerBean);
    void onFail(String error);
}
