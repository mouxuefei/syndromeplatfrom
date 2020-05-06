package com.huaxi.syndromeplatfrom.contract

import com.exmple.corelib.mvp.IPresenter
import com.exmple.corelib.mvp.IView

/**
 * @describe
 * @author  mou
 * @date 2020/5/6  19:57
 * 								 - generate by MvpAutoCodePlus plugin.
 */

interface ISplashContract {
    interface View : IView<Presenter> {}
    interface Presenter : IPresenter<View> {}
}
