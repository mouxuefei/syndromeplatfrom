package com.huaxi.syndromeplatfrom.bean

/**
 * @FileName: ArticleData.java
 * @author: villa_mou
 * @date: 05-21:48
 * @version V1.0 <描述当前版本功能>
 * @desc
 */
data class ArticleData(
    val apkLink: String,
    val author: String,
    val chapterId: Int,
    val chapterName: String,
    val collect: Boolean,
    val courseId: Int,
    val desc: String,
    val envelopePic: String,
    val fresh: Boolean,
    val id: Int,
    val link: String,
    val niceDate: String,
    val origin: String,
    val prefix: String,
    val projectLink: String,
    val publishTime: Long,
    val superChapterId: Int,
    val superChapterName: String,
    val title: String,
    val type: Int,
    val userId: Int,
    val visible: Int,
    val zan: Int
)