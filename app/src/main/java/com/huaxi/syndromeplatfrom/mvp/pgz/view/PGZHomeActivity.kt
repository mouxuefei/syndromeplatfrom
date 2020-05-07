package com.huaxi.syndromeplatfrom.mvp.pgz.view

import com.huaxi.syndromeplatfrom.mvp.pgz.contract.IPGZHomeContract
import com.exmple.corelib.mvp.MBaseMvpActivity
import com.huaxi.syndromeplatfrom.R
import com.huaxi.syndromeplatfrom.mvp.pgz.presenter.PGZHomePresenter
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @describe
 * @author  mou
 * @date 2020/5/7  9:25 AM
 * 								 - generate by MvpAutoCodePlus plugin.
 */

class PGZHomeActivity : MBaseMvpActivity<IPGZHomeContract.View, IPGZHomeContract.Presenter>(),
    IPGZHomeContract.View {
    override fun getContentView() = R.layout.activity_main

    override fun initView() {
        msv.onRetry = {
            getData()
        }
        getData()
    }

    fun getData() {
        mPresenter.getData({
            msv.showLoading()
        }, {
            msv.showError()
        }, {
            msv.showSuccess()
        })
    }

    override var mPresenter: IPGZHomeContract.Presenter =
        PGZHomePresenter()

}

