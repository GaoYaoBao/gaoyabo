package first.test.qimo.callback;

import first.test.qimo.bean.ClasBean;
import first.test.qimo.bean.SchoolBean;

public interface ClasCallBack {
    void onSuccess(ClasBean clasBean);
    void onFail(String error);
}
