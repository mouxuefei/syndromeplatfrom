package com.huaxi.syndromeplatfrom.view

import com.exmple.corelib.base.LibApplication
import com.exmple.corelib.exts.myStartActivity
import com.exmple.corelib.mvp.MBaseMvpActivity
import com.huaxi.syndromeplatfrom.R
import com.huaxi.syndromeplatfrom.contract.ISplashContract
import com.huaxi.syndromeplatfrom.presenter.SplashPresenter

/**
 * @describe
 * @author  mou
 * @date 2020/5/6  19:57
 * 								 - generate by MvpAutoCodePlus plugin.
 */

class SplashActivity : MBaseMvpActivity<ISplashContract.View, ISplashContract.Presenter>(), ISplashContract.View {
    override fun getContentView()= R.layout.activity_splash

    override fun initView() {
        LibApplication.appHandler?.postDelayed({
            myStartActivity<LoginActivity>()
        },1000)
    }

    override var mPresenter: ISplashContract.Presenter= SplashPresenter()

}

