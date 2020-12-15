package first.test.qimo.presenter;

import first.test.qimo.bean.ClasBean;
import first.test.qimo.callback.ClasCallBack;
import first.test.qimo.model.ImpClasModel;
import first.test.qimo.view.ClasView;

public class ImpClasPresenter implements ClasPresenter, ClasCallBack {
    private ClasView clasView;
    private final ImpClasModel impClasModel;

    public ImpClasPresenter(ClasView clasView) {
        this.clasView = clasView;
        impClasModel = new ImpClasModel();
    }

    @Override
    public void onSuccess(ClasBean clasBean) {
        clasView.onSuccess(clasBean);
    }

    @Override
    public void onFail(String error) {
        clasView.onFail(error);
    }

    @Override
    public void getClas() {
        impClasModel.getClas(this);
    }
}
