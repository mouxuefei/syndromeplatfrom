package com.huaxi.syndromeplatfrom.viewss

import android.content.Context
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import com.huaxi.syndromeplatfrom.R

/**
 * Create by 25497 on 2019/10/6
 * The project name is CustomView-setting_item
 * Leo Mark
 *
 * Desc:  自定义控件（继承FrameLayout）
 */
class CustomInputItemView : LinearLayout {

    private var mContext: Context? = null

    private var settingItemTitle: TextView? = null//标题
     var settingItemEt: EditText? = null//概述
    private var settingItemUnderLine: View? = null//下划线
    private var settingItemMust: TextView? = null//

    var settingItemEtText: String? = null
        set(settingItemDescText) {
            if (settingItemDescText != null) {
                field = settingItemDescText
                settingItemEt!!.setText(settingItemDescText)
            }
        }//概述内容





    constructor(context: Context) : super(context) {}

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        init(context, attrs)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init(context, attrs)
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(
        context,
        attrs,
        defStyleAttr,
        defStyleRes
    ) {
        init(context, attrs)
    }

    /**
     * 定义自定义控件中的属性
     * @param context
     * @param attrs
     */
    private fun init(context: Context, attrs: AttributeSet?) {
        this.mContext = context
        val inflater = mContext!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
       val mainView = inflater.inflate(R.layout.item_input_view, this, true)
        initView(mainView)//初始布局中的控件

        val typedArray = mContext!!.obtainStyledAttributes(attrs, R.styleable.CustomInputItemView)
       val settingItemTitleText = typedArray.getString(R.styleable.CustomInputItemView_inputTitle)
        settingItemTitle?.text = settingItemTitleText
        val   settingItemDescText = typedArray.getString(R.styleable.CustomInputItemView_inputHint)
        settingItemEt?.hint=settingItemDescText

       val isMust= typedArray.getBoolean(R.styleable.CustomInputItemView_inputMust,false)
        if(isMust){
            settingItemMust?.visibility=View.VISIBLE
        }else{
            settingItemMust?.visibility=View.GONE
        }
        setSettingItemLineSize(
            typedArray.getBoolean(
                R.styleable.CustomInputItemView_inputItemUnderLineVisibility,
                true
            )
        )
    }

    private fun setSettingItemLineSize(settingItemLineVisibility: Boolean) {
        //判断是否显示下划线
        if (settingItemLineVisibility) {
            settingItemUnderLine?.visibility = View.VISIBLE
        } else {
            settingItemUnderLine?.visibility = View.INVISIBLE
        }
    }


    private fun initView(mainView: View) {
        settingItemTitle = mainView.findViewById(R.id.input_title)
        settingItemEt = mainView.findViewById(R.id.input_et)
        settingItemUnderLine = mainView.findViewById(R.id.input_line)
        settingItemMust = mainView.findViewById(R.id.input_must)
    }
}