package com.huaxi.syndromeplatfrom.http

import com.exmple.corelib.http.retrofit.RetrofitFactory
import okhttp3.Request

/**
 * @FileName: MainRetrofit.java
 * @author: villa_mou
 * @date: 05-21:48
 * @version V1.0 <描述当前版本功能>
 * @desc
 */
object MainRetrofit : RetrofitFactory<MainApi>() {

    override fun getBaseUrl()="https://www.wanandroid.com/"

    override fun getHeader(builder: Request.Builder): Request.Builder {
        return builder.addHeader("token","1233333333333333")
    }
    override fun getApiService(): Class<MainApi> {
        return MainApi::class.java
    }
}