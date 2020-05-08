package com.huaxi.syndromeplatfrom.mvp.pgz.view

import android.support.v4.app.Fragment
import com.chaychan.library.BottomBarItem
import com.huaxi.syndromeplatfrom.mvp.pgz.contract.IPGZHomeContract
import com.exmple.corelib.mvp.MBaseMvpActivity
import com.huaxi.syndromeplatfrom.R
import com.huaxi.syndromeplatfrom.adapter.MyAdapter
import com.huaxi.syndromeplatfrom.mvp.pgz.presenter.PGZHomePresenter
import com.huaxi.syndromeplatfrom.mvp.ssz.view.TabFragment
import kotlinx.android.synthetic.main.activity_main_pgz.*

/**
 * @describe
 * @author  mou
 * @date 2020/5/7  9:25 AM
 * 								 - generate by MvpAutoCodePlus plugin.
 */

class PGZHomeActivity : MBaseMvpActivity<IPGZHomeContract.View, IPGZHomeContract.Presenter>(),
    IPGZHomeContract.View {

    private lateinit var titles: MutableList<String>
    private lateinit var normalIconIds: MutableList<Int>
    private lateinit var selectIconIds: MutableList<Int>

    override fun getContentView() = R.layout.activity_main_pgz

    override fun initView() {
        titles = mutableListOf("评估塞选", "培训考试", "个人中心")
        normalIconIds = mutableListOf(
            R.mipmap.tab_home_unselect,
            R.mipmap.tab_circle_unselect,
            R.mipmap.tab_mine_unselect
        )
        selectIconIds = mutableListOf(
            R.mipmap.tab_home_select,
            R.mipmap.tab_circle_select,
            R.mipmap.tab_mine_select
        )
        val mFragmentList = ArrayList<Fragment>()
        titles.forEachIndexed { index, s ->
            val tabItem = createBottomBarItem(index)
            bottomBar.addItem(tabItem)
            mFragmentList.add(TabFragment())
        }
        main_vp.adapter = MyAdapter(supportFragmentManager, mFragmentList)
        main_vp.setNoScroll(true)
        bottomBar.setViewPager(main_vp)
//        msv.onRetry = {
//            getData()
//        }

//        getData()


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

    private fun createBottomBarItem(i: Int): BottomBarItem {
        val item = BottomBarItem.Builder(this)
            .titleTextSize(8)
            .titleNormalColor(R.color.color_gray_69)
            .titleSelectedColor(R.color.color_black)
//          .openTouchBg(false)
//          .marginTop(5)
//          .itemPadding(5)
//          .unreadNumThreshold(99)
//          .unreadTextColor(R.color.white)

            //还有很多属性，详情请查看Builder里面的方法
            .create(normalIconIds[i], selectIconIds[i], titles[i]);
        return item
    }

    override var mPresenter: IPGZHomeContract.Presenter =
        PGZHomePresenter()

}

