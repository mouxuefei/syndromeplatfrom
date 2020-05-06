package com.huaxi.syndromeplatfrom.contract

import com.exmple.corelib.http.entity.BaseBean
import com.exmple.corelib.http.entity.ListBean
import com.exmple.corelib.mvp.IPresenter
import com.exmple.corelib.mvp.IView
import com.huaxi.syndromeplatfrom.bean.ArticleData

/**
 * @describe
 * @author  mou
 * @date 2020/5/6  20:07
 * 								 - generate by MvpAutoCodePlus plugin.
 */

interface IHomeContract {
    interface View : IView<Presenter> {}
    interface Presenter : IPresenter<View> {
      fun  getData(start: () -> Unit, fail: () -> Unit, succuss: (BaseBean<ListBean<ArticleData>>?) -> Unit)
    }
}
