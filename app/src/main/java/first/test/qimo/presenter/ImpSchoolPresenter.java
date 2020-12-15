package first.test.qimo.presenter;

import first.test.qimo.bean.SchoolBean;
import first.test.qimo.callback.SchoolCallBack;
import first.test.qimo.model.ImpSchoolModel;
import first.test.qimo.view.SchooView;

public class ImpSchoolPresenter implements SchoolPresenter, SchoolCallBack {
    private SchooView schooView;
    private final ImpSchoolModel impSchoolModel;

    public ImpSchoolPresenter(SchooView schooView) {
        this.schooView = schooView;
        impSchoolModel = new ImpSchoolModel();
    }

    @Override
    public void onSuccess(SchoolBean schoolBean) {
        schooView.onSuccess(schoolBean);
    }

    @Override
    public void onFail(String error) {
        schooView.onFail(error);
    }

    @Override
    public void getSchool() {
            impSchoolModel.getsShool(this);
    }
}
