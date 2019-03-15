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
