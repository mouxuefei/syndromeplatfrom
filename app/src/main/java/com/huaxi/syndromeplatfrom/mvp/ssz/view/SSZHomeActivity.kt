package com.huaxi.syndromeplatfrom.mvp.ssz.view

import android.support.v4.app.Fragment
import com.exmple.corelib.mvp.MBaseMvpActivity
import com.huaxi.syndromeplatfrom.R
import com.huaxi.syndromeplatfrom.adapter.MyAdapter
import com.huaxi.syndromeplatfrom.mvp.ssz.contract.ISSZHomeContract
import com.huaxi.syndromeplatfrom.mvp.ssz.presenter.SSZHomePresenter
import kotlinx.android.synthetic.main.activity_main_ssz.*


/**
 * @describe
 * @author  mou
 * @date 2020/5/7  9:26 AM
 * 								 - generate by MvpAutoCodePlus plugin.
 */

class SSZHomeActivity : MBaseMvpActivity<ISSZHomeContract.View, ISSZHomeContract.Presenter>(),
    ISSZHomeContract.View {

    override fun getContentView() = R.layout.activity_main_ssz

    override fun initView() {
        val mFragmentList = ArrayList<Fragment>()
        mFragmentList.add(TabFragment())
        mFragmentList.add(TabFragment())
        mFragmentList.add(TabFragment())
        main_vp.adapter = MyAdapter(supportFragmentManager, mFragmentList)
        main_vp.setNoScroll(true)
        bottomBar.setViewPager(main_vp)
////        msv.onRetry = {
////            getData()
////        }
////        getData()
//
//        bottomBar.setOnItemSelectedListener(object : BottomBarLayout.OnItemSelectedListener {
//            fun onItemSelected(bottomBarItem: BottomBarItem?, position: Int) {
//                //do something
//            }
//
//            override fun onItemSelected(p0: BottomBarItem?, p1: Int, p2: Int) {
//            }
//        })
    }

    fun getData() {
//        mPresenter.getData({
//            msv.showLoading()
//        }, {
//            msv.showError()
//        }, {
//            msv.showSuccess()
//        })
    }

    override var mPresenter: ISSZHomeContract.Presenter =
        SSZHomePresenter()

}

