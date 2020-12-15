package first.test.qimo.model;

import first.test.qimo.api.ApiService;
import first.test.qimo.bean.ClasBean;
import first.test.qimo.callback.ClasCallBack;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImpClasModel implements ClasModel{
    @Override
    public void getClas(final ClasCallBack clasCallBack) {
        new Retrofit.Builder()
                .baseUrl(ApiService.Class_Url)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
                .create(ApiService.class)
                .getClas()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ClasBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ClasBean clasBean) {
                        clasCallBack.onSuccess(clasBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                        clasCallBack.onFail("错误信息"+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
