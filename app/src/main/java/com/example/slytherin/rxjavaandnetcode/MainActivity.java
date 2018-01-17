package com.example.slytherin.rxjavaandnetcode;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.slytherin.rxjavaandnetcode.util.LogUtils;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;

import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;



public class MainActivity extends AppCompatActivity {
    TextView tv_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    public void init(){
        tv_show =(TextView) findViewById(R.id.tv_show);
    }

    public void btn_changeText(View v){
        String uri = "http://likedev.applinzi.com";
        LogUtils.INFO("1.当前线程为");
//        Observable.just("123")
//                .map(new Func1<String, Integer>() {
//
//                    @Override
//                    public Integer call(String s) {
//                        LogUtils.INFO("2.当前线程为");
//                        return 123;
//                    }
//                }).subscribe(new Action1<Integer>() {
//            @Override
//            public void call(Integer integer) {
//                LogUtils.INFO("3.当前线程为");
//                LogUtils.INFO(integer.toString());
//            }
//        });

        Observable.just(uri)
                .subscribeOn(Schedulers.io())
                .map(new Function<String, String>() {

                    @Override
                    public String apply(@NonNull String s) throws Exception {
                        return doPsot(s);
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .doOn

    }

    public void btn_test(View v){
        String uri = "http://likedev.applinzi.com";
        LogUtils.INFO("1.当前线程为");
        doPsot(uri);
    }

    public String doPsot(String Uri){
        String resp;
        //创建一个retrofit对象，设置好返回值的支持
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Uri)
                //添加String返回的支持
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        //通过retrofit创建一个noParmGet的接口对象
        NoParmGet noParmGet = retrofit.create(NoParmGet.class);
        //通过接口对象获取Call
        Call<String> call = noParmGet.GetWithoutPram();
        //通过call进行网络请求
        LogUtils.INFO("3.当前线程为");
        call.enqueue(new Callback<String>() {

            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                LogUtils.INFO("4.当前线程为");
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
            }
        });
        return null;
    }

    public Response<String> receiveResp(Response<String> response){
        return response;
    }
}
