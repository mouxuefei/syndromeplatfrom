package com.huaxi.syndromeplatfrom.mvp.common.view

import android.graphics.Color
import android.view.View
import com.exmple.corelib.exts.myStartActivity
import com.exmple.corelib.mvp.MBaseMvpActivity
import com.exmple.corelib.utils.nicedialog.DialogListner
import com.exmple.corelib.utils.nicedialog.MNiceDialog
import com.exmple.corelib.utils.nicedialog.getViewById
import com.exmple.corelib.utils.nicedialog.mDialog
import com.huaxi.syndromeplatfrom.R
import com.huaxi.syndromeplatfrom.mvp.common.contract.ILoginContract
import com.huaxi.syndromeplatfrom.mvp.common.presenter.LoginPresenter
import com.huaxi.syndromeplatfrom.mvp.pgz.view.PGZHomeActivity
import com.huaxi.syndromeplatfrom.mvp.ssz.view.SSZHomeActivity
import kotlinx.android.synthetic.main.activity_login.*

/**
 * @describe
 * @author  mou
 * @date 2020/5/6  19:55
 * 								 - generate by MvpAutoCodePlus plugin.
 */

class LoginActivity : MBaseMvpActivity<ILoginContract.View, ILoginContract.Presenter>(), ILoginContract.View {
    override fun getContentView() = R.layout.activity_login

    override fun initView() {
        containerSsz.visibility = View.VISIBLE
        containerPgz.visibility=View.GONE
        btnSSz.setOnClickListener {
            btnSSz.setBackgroundColor(Color.parseColor("#ff0000"))
            btnPgz.setBackgroundColor(Color.parseColor("#ffffff"))
            containerSsz.visibility = View.VISIBLE
            containerPgz.visibility=View.GONE
        }
        btnPgz.setOnClickListener {
            btnPgz.setBackgroundColor(Color.parseColor("#ff0000"))
            btnSSz.setBackgroundColor(Color.parseColor("#ffffff"))
            containerSsz.visibility = View.GONE
            containerPgz.visibility=View.VISIBLE
        }
        wjmm.setOnClickListener {
            mDialog(supportFragmentManager) {
                layoutId=R.layout.dialog_wjmm
                margin = 30
                outCancel = true
                viewClick = object : DialogListner() {
                    override fun convertView(view: View,dialog: MNiceDialog) {
                        view.getViewById(R.id.dialog_wjmm_sure).setOnClickListener {
                            showToast("button")
                            dialog.dismiss()
                        }
                    }
                }
            }

        }

        login_ssz.setOnClickListener {
            myStartActivity<SSZHomeActivity>()
        }
        login_pgz.setOnClickListener {
            myStartActivity<PGZHomeActivity>()
        }
    }

    override var mPresenter: ILoginContract.Presenter =
        LoginPresenter()

}

