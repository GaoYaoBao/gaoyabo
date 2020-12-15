package first.test.qimo.api;

import first.test.qimo.bean.BannerBean;
import first.test.qimo.bean.ClasBean;
import first.test.qimo.bean.SchoolBean;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {
    String banner_Url="http://cdwan.cn:7000/";
    String School_Url="http://cdwan.cn:7000/";
    String Class_Url="http://cdwan.cn:7000/";
    @GET("exam2003/abannerlist.json")
    Observable<BannerBean> getBanner();
    @GET("exam2003/anewslist.json")
    Observable<SchoolBean> getSchool();
    @GET("exam2003/astudent.json")
    Observable<ClasBean> getClas();
}
