# LJAndroidUtils
Some useful Android tools

### 使用方法&配置
在项目`build.gradle`文件中添加以下配置
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
添加依赖
```
dependencies {
	        implementation 'com.github.archerLj:LJAndroidUtils:1.0'
	}
```

### 1. 获取图片的主色值以及Dark类型
```
<ImageView android:id="@+id/demoImg"
 .../>
```

```
	// 直接调用ImageView的扩展方法
        demoImg.analyse { mainColor, isDark ->
            mainColor?.let {
	    	// 获取到图片的主色
            }
	    // isDark: true，则可以在图片上添加白色系的字体； false，则可以在图片上添加一些黑色系的字体
        }

	// 调用Bitmap的扩展方法，这里可以指定获取主色值的范围
        demoImg.drawable.toBitmap().analyse(0,0,10,10) { mainColor, isDark ->
		//...
        }
```
