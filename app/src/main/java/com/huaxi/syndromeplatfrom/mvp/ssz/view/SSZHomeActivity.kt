package com.huaxi.syndromeplatfrom.mvp.ssz.view

import com.huaxi.syndromeplatfrom.mvp.ssz.contract.ISSZHomeContract
import com.exmple.corelib.mvp.MBaseMvpActivity
import com.huaxi.syndromeplatfrom.R
import com.huaxi.syndromeplatfrom.mvp.pgz.contract.IPGZHomeContract
import com.huaxi.syndromeplatfrom.mvp.pgz.presenter.PGZHomePresenter
import com.huaxi.syndromeplatfrom.mvp.ssz.presenter.SSZHomePresenter
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @describe
 * @author  mou
 * @date 2020/5/7  9:26 AM
 * 								 - generate by MvpAutoCodePlus plugin.
 */

class SSZHomeActivity : MBaseMvpActivity<ISSZHomeContract.View, ISSZHomeContract.Presenter>(),
    ISSZHomeContract.View {
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

    override var mPresenter: ISSZHomeContract.Presenter =
        SSZHomePresenter()

}

