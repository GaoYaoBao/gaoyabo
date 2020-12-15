package first.test.qimo.presenter;

import first.test.qimo.bean.BannerBean;
import first.test.qimo.callback.BannerCallBack;
import first.test.qimo.view.BannerView;

public class ImpBannerModel implements BannerPresenter, BannerCallBack {
    private final first.test.qimo.model.ImpBannerModel impBannerModel;
    private BannerView bannerView;


    public ImpBannerModel(BannerView bannerView) {
        this.bannerView = bannerView;
        impBannerModel = new first.test.qimo.model.ImpBannerModel();
    }

    @Override
    public void getBanner() {
        impBannerModel.getBanner(this);
    }

    @Override
    public void onSuccess(BannerBean bannerBean) {
        bannerView.onSuccess(bannerBean);
    }

    @Override
    public void onFail(String error) {
bannerView.onFail(error);
    }
}
