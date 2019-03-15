package com.demo.palette

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.PixelFormat
import android.graphics.drawable.Drawable
import android.support.v7.graphics.Palette
import android.widget.ImageView

/**
 * @author : created by archerLj
 * date: 2019/3/5 14
 * usage:
 */

fun Drawable.toBitmap(): Bitmap {
    // 取 drawable 的长宽
    val w = intrinsicWidth
    val h = intrinsicHeight

    // 取 drawable 的颜色格式
    val config = if (opacity != PixelFormat.OPAQUE) Bitmap.Config.ARGB_8888 else Bitmap.Config.RGB_565
    // 建立对应 bitmap
    val bitmap = Bitmap.createBitmap(w, h, config);
    // 建立对应 bitmap 的画布
    val canvas = Canvas(bitmap);
    setBounds(0, 0, w, h);
    // 把 drawable 内容画到画布中
    draw(canvas);
    return bitmap;
}

fun Bitmap.analyse(left: Int = 0, top: Int = 0, right: Int = this.width, bottom: Int = this.height, result: (mainColor: Int?, isDark: Boolean) -> Unit) {
    Palette.from(this)
        .maximumColorCount(3)
        .clearFilters()
        .setRegion(left, top, right, bottom)
        .generate { palette ->
            var populousColor: Int? = null
            val swatch = ColorUtils.getMostPopulousSwatch(palette)
            swatch?.let {
                populousColor = it.rgb
            }

            val isDark = ColorUtils.isBitmapDark(palette, this)
            result(populousColor, isDark)
        }
}

fun ImageView.analyse(result: (mainColor: Int?, isDark: Boolean) -> Unit) {
    val bitmap = this.drawable.toBitmap()
    bitmap.analyse { mainColor, isDark ->
        result(mainColor, isDark)
    }
}