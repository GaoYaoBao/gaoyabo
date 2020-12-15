package first.test.qimo.view;

import first.test.qimo.bean.SchoolBean;

public interface SchooView {
    void onSuccess(SchoolBean schoolBean);
    void onFail(String error);
}
