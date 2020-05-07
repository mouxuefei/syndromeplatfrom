package com.huaxi.syndromeplatfrom.mvp.common.presenter

import com.exmple.corelib.http.entity.BaseBean
import com.exmple.corelib.http.entity.ListBean
import com.exmple.corelib.http.http
import com.exmple.corelib.mvp.MBasePresenterKt
import com.exmple.corelib.utils.showToastBottom
import com.huaxi.syndromeplatfrom.bean.ArticleData
import com.huaxi.syndromeplatfrom.mvp.common.contract.ILoginContract
import com.huaxi.syndromeplatfrom.http.MainRetrofit

/**
 * @describe
 * @author  mou
 * @date 2020/5/6  19:55
 * 								 - generate by MvpAutoCodePlus plugin.
 */

class LoginPresenter : MBasePresenterKt<ILoginContract.View>(), ILoginContract.Presenter {
     override fun getData(succuss: (BaseBean<ListBean<ArticleData>>?) -> Unit) {
        http<ListBean<ArticleData>> {
            api {
                MainRetrofit.apiService.getArticle()
            }
            loadingView(mView)
            disPool(this@LoginPresenter)
            onSuccess {
                showToastBottom("成功")
            }
            onError {

            }
        }


    }
}

