package com.huaxi.syndromeplatfrom.http

import com.exmple.corelib.http.entity.BaseBean
import com.exmple.corelib.http.entity.ListBean
import com.huaxi.syndromeplatfrom.bean.ArticleData
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * @FileName: MainApi.java
 * @author: villa_mou
 * @date: 05-21:47
 * @version V1.0 <描述当前版本功能>
 * @desc
 */
interface MainApi {


    /**
     * 统计活跃度
     */
    @GET("article/list/0/json")
    fun getArticle(): Observable<BaseBean<ListBean<ArticleData>>>


}