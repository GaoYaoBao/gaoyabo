package first.test.qimo.callback;

import first.test.qimo.bean.BannerBean;
import first.test.qimo.bean.SchoolBean;

public interface SchoolCallBack {
    void onSuccess(SchoolBean schoolBean);
    void onFail(String error);
}
