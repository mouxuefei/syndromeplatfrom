package com.huaxi.syndromeplatfrom.view

import com.exmple.corelib.mvp.MBaseMvpActivity
import com.huaxi.syndromeplatfrom.R
import com.huaxi.syndromeplatfrom.contract.IHomeContract
import com.huaxi.syndromeplatfrom.presenter.HomePresenter
import kotlinx.android.synthetic.main.activity_main.*

/**
 * @describe
 * @author  mou
 * @date 2020/5/6  20:07
 * 								 - generate by MvpAutoCodePlus plugin.
 */

class HomeActivity : MBaseMvpActivity<IHomeContract.View, IHomeContract.Presenter>(), IHomeContract.View {
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

    override var mPresenter: IHomeContract.Presenter = HomePresenter()


}

