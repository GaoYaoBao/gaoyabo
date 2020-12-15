package first.test.qimo.model;

import first.test.qimo.api.ApiService;
import first.test.qimo.bean.SchoolBean;
import first.test.qimo.callback.SchoolCallBack;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImpSchoolModel implements SchoolModel {
    @Override
    public void getsShool(final SchoolCallBack schoolCallBack) {
        new Retrofit.Builder()
                .baseUrl(ApiService.School_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getSchool()
                 .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SchoolBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SchoolBean schoolBean) {
                        schoolCallBack.onSuccess(schoolBean);
                    }

                    @Override
                    public void onError(Throwable e) {
    schoolCallBack.onFail("错误信息"+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
