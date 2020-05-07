package com.huaxi.syndromeplatfrom.mvp.ssz.contract

import com.exmple.corelib.http.entity.BaseBean
import com.exmple.corelib.http.entity.ListBean
import com.exmple.corelib.mvp.IView
import com.exmple.corelib.mvp.IPresenter
import com.huaxi.syndromeplatfrom.bean.ArticleData

/**
 * @describe
 * @author  mou
 * @date 2020/5/7  9:26 AM
 * 								 - generate by MvpAutoCodePlus plugin.
 */

interface ISSZHomeContract {
    interface View : IView<Presenter> {}
    interface Presenter : IPresenter<View> {
        fun  getData(start: () -> Unit, fail: () -> Unit, succuss: (BaseBean<ListBean<ArticleData>>?) -> Unit)
    }
}
