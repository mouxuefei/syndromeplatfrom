package com.huaxi.syndromeplatfrom.viewss

import android.content.Context
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
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
class CustomSettingItemView : LinearLayout {

    private var mContext: Context? = null
    private var mainView: View? = null

    private val settingItem: LinearLayout? = null
    private var settingItemLogo: ImageView? = null//第一张图片
    private var settingItemMore: ImageView? = null//第二张图片
    private var settingItemTitle: TextView? = null//标题
    private var settingItemDesc: TextView? = null//概述
    private var settingItemUnderLine: View? = null//下划线

    //将内容设置进控件中
    var settingItemTitleText: String? = null
        set(settingItemTitleText) {
            if (settingItemTitleText != null) {
                field = settingItemTitleText
                settingItemTitle!!.text = settingItemTitleText
            }

        }//标题内容
    //将内容设置进控件中
    var settingItemDescText: String? = null
        set(settingItemDescText) {
            if (settingItemDescText != null) {
                field = settingItemDescText
                settingItemDesc!!.text = settingItemDescText
            }
        }//概述内容
    //将图片地址设置进控件中
    var settingItemLogoSrc: Int = 0
        set(settingItemLogoSrc) {
            if (settingItemLogoSrc != 10000) {
                field = settingItemLogoSrc
                settingItemLogo!!.setImageResource(settingItemLogoSrc)
            }
        }//第一张图片路径
    //将图片地址设置进控件中
    var settingItemMoreSrc: Int = 0
        set(settingItemMoreSrc) {
            if (settingItemMoreSrc != 10000) {
                field = settingItemMoreSrc
                settingItemMore!!.setImageResource(settingItemMoreSrc)
            }
        }//第二张图片路径
    var settingItemLineVisibility: Boolean = false
        private set//下划线显示与否判断

    var settingLeftIconVisible: Boolean = false

    fun setSettingItemLineSize(settingItemLineVisibility: Boolean) {
        this.settingItemLineVisibility = settingItemLineVisibility
        //判断是否显示下划线
        if (settingItemLineVisibility) {
            settingItemUnderLine!!.visibility = View.VISIBLE
        } else {
            settingItemUnderLine!!.visibility = View.INVISIBLE
        }
    }

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
        mainView = inflater.inflate(R.layout.item_select_view, this, true)
        initView(mainView!!)//初始布局中的控件

        val typedArray = mContext!!.obtainStyledAttributes(attrs, R.styleable.CustomSettingItemView)
        settingItemTitleText = typedArray.getString(R.styleable.CustomSettingItemView_settingItemTitle)
        settingItemDescText = typedArray.getString(R.styleable.CustomSettingItemView_settingItemDesc)
        settingItemLogoSrc = typedArray.getResourceId(R.styleable.CustomSettingItemView_settingLogoSrc, 10000)
        settingItemMoreSrc = typedArray.getResourceId(R.styleable.CustomSettingItemView_settingMoreSrc, 10000)

        settingLeftIconVisible = typedArray.getBoolean(R.styleable.CustomSettingItemView_settingLeftIconVisible, false)
        setSettingItemLineSize(
            typedArray.getBoolean(
                R.styleable.CustomSettingItemView_settingItemUnderLineVisibility,
                true
            )
        )

        if(settingLeftIconVisible){
            settingItemLogo?.visibility=View.VISIBLE
        }else{
            settingItemLogo?.visibility=View.GONE
        }

    }

    /**
     * 初始化控件
     * @param mainView
     */
    private fun initView(mainView: View) {
        settingItemTitle = mainView.findViewById(R.id.setting_item_title)
        settingItemDesc = mainView.findViewById(R.id.setting_item_desc)
        settingItemLogo = mainView.findViewById(R.id.setting_item_logo)
        settingItemMore = mainView.findViewById(R.id.setting_item_more)
        settingItemUnderLine = mainView.findViewById(R.id.setting_item_line)
    }
}