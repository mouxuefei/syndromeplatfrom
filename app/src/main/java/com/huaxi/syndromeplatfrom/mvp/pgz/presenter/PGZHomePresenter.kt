package com.huaxi.syndromeplatfrom.mvp.pgz.presenter

import com.exmple.corelib.http.async
import com.exmple.corelib.http.bindDisposable
import com.exmple.corelib.http.entity.BaseBean
import com.exmple.corelib.http.entity.ListBean
import com.exmple.corelib.http.onResult
import com.huaxi.syndromeplatfrom.mvp.pgz.contract.IPGZHomeContract
import com.exmple.corelib.mvp.MBasePresenterKt
import com.huaxi.syndromeplatfrom.bean.ArticleData
import com.huaxi.syndromeplatfrom.http.MainRetrofit

/**
 * @describe
 * @author  mou
 * @date 2020/5/7  9:25 AM
 * 								 - generate by MvpAutoCodePlus plugin.
 */

class PGZHomePresenter : MBasePresenterKt<IPGZHomeContract.View>(), IPGZHomeContract.Presenter {
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

