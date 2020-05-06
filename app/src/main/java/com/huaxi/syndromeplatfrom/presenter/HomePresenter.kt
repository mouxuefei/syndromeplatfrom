package com.huaxi.syndromeplatfrom.presenter

import com.exmple.corelib.http.async
import com.exmple.corelib.http.bindDisposable
import com.exmple.corelib.http.entity.BaseBean
import com.exmple.corelib.http.entity.ListBean
import com.exmple.corelib.http.onResult
import com.exmple.corelib.mvp.MBasePresenterKt
import com.huaxi.syndromeplatfrom.bean.ArticleData
import com.huaxi.syndromeplatfrom.contract.IHomeContract
import com.huaxi.syndromeplatfrom.http.MainRetrofit

/**
 * @describe
 * @author  mou
 * @date 2020/5/6  20:07
 * 								 - generate by MvpAutoCodePlus plugin.
 */

class HomePresenter : MBasePresenterKt<IHomeContract.View>(), IHomeContract.Presenter {

    override fun getData(start: () -> Unit, fail: () -> Unit, succuss: (BaseBean<ListBean<ArticleData>>?) -> Unit) {
        MainRetrofit.apiService.getArticle()
            .async()
            .bindDisposable(this)
            .doOnSubscribe {
                start.invoke()
            }
            .onResult({
                fail.invoke()
            }, {
                succuss.invoke(it)
            })
    }

}

