package first.test.qimo.view;

import first.test.qimo.bean.BannerBean;

public interface BannerView {
    void onSuccess(BannerBean bannerBean);
    void onFail(String error);
}
