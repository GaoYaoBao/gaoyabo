package first.test.qimo.view;

import first.test.qimo.bean.ClasBean;

public interface ClasView {
    void onSuccess(ClasBean clasBean);
    void onFail(String error);
}
