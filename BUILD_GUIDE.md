# Jannat AlRahman Android App - دليل البناء السريع

## 🚀 الخطوات السريعة لبناء وتشغيل التطبيق

### المرحلة 1: التحضير
```bash
# استنساخ المستودع
git clone https://github.com/abobode40-netizen/Jannat-AlRahman-App.git
cd Jannat-AlRahman-App

# فتح المشروع في Android Studio
android-studio .
```

### المرحلة 2: بناء APK Debug (للاختبار على جهازك)
```bash
# من سطر الأوامر
./gradlew assembleDebug

# سيتم إنشاء ملف APK في:
app/build/outputs/apk/debug/app-debug.apk

# تثبيت على جهازك
adb install app/build/outputs/apk/debug/app-debug.apk
```

### المرحلة 3: بناء APK Release (للنشر على Google Play)
```bash
# بناء ملف APK النهائي
./gradlew assembleRelease

# سيتم إنشاء ملف APK في:
app/build/outputs/apk/release/app-release-unsigned.apk

# توقيع ملف APK (تحتاج إلى Keystore)
# (سيتم شرح هذا في القسم التالي)
```

### المرحلة 4: توقيع ملف APK
```bash
# إنشاء Keystore جديد
keytool -genkey -v -keystore jannat-keystore.jks -keyalg RSA -keysize 2048 -validity 10000 -alias jannat-key

# توقيع ملف APK
jarsigner -verbose -sigalg MD5withRSA -digestalg SHA1 -keystore jannat-keystore.jks \
  app/build/outputs/apk/release/app-release-unsigned.apk jannat-key

# محاذاة الملف النهائي
zipalign -v 4 app-release-unsigned.apk app-release-signed.apk
```

## 📝 متطلبات التطوير

- **Android Studio**: Hedgehog 2023.1.1 أو أحدث
- **Android SDK**: SDK 34 (Android 14)
- **Gradle**: 8.1+
- **Java/Kotlin**: SDK 1.8+
- **RAM**: 4GB حد أدنى

## 🔧 إعدادات Gradle

جميع الإعدادات موجودة في:
- `build.gradle.kts` (الملف الجذري)
- `app/build.gradle.kts` (إعدادات التطبيق)
- `settings.gradle.kts` (إعدادات الحل)

## 📱 أجهزة الاختبار

### الحد الأدنى:
- **API Level**: 24 (Android 7.0)
- **الذاكرة**: 1GB RAM
- **التخزين**: 50MB

### الموصى به:
- **API Level**: 30+ (Android 11+)
- **الذاكرة**: 2GB+ RAM
- **التخزين**: 100MB+

## 🎯 ميزات الإصدار

### في Debug:
- ProGuard معطّل (أسرع في البناء)
- رسائل تصحيح مفصلة
- حجم أكبر (يحتوي على رموز التصحيح)

### في Release:
- ProGuard مفعّل (تقليل الكود)
- بدون رسائل تصحيح
- حجم ملف أصغر
- أداء أفضل

## ✅ قائمة التحقق قبل النشر

- [ ] تم اختبار التطبيق على أجهزة متعددة
- [ ] تم التحقق من جميع الأذونات
- [ ] تم اختبار البحث الصوتي
- [ ] تم اختبار النسخة الاحتياطية
- [ ] تم اختبار الوضع الليلي
- [ ] تم تحديث رقم الإصدار في build.gradle
- [ ] تم إنشاء ملف Keystore
- [ ] تم توقيع ملف APK

## 🐛 حل المشاكل الشائعة

### مشكلة: Gradle sync مفشل
```bash
# الحل: تحديث Gradle
./gradlew clean
./gradlew --refresh-dependencies
```

### مشكلة: أخطاء الأذونات
```bash
# التحقق من الأذونات المطلوبة في AndroidManifest.xml
# والتأكد من طلبها في الكود
```

### مشكلة: ملف APK كبير جداً
```bash
# تفعيل ProGuard والتقليل
# جزء من build.gradle:
release {
    isMinifyEnabled = true
    proguardFiles getDefaultProguardFile('proguard-android-optimize.txt')
}
```

## 📊 حجم الملفات المتوقع

| الإصدار | الحجم |
|---------|-------|
| Debug APK | 25-30 MB |
| Release APK (غير موقّع) | 15-18 MB |
| Release APK (موقّع) | 15-18 MB |

## 🌐 النشر على Google Play

1. إنشاء حساب مطور (إذا لم تكن لديك حساب)
2. تحضير الملفات المطلوبة:
   - الأيقونات
   - لقطات الشاشة
   - الوصف والخصوصية
3. بناء Release APK
4. توقيع الملف
5. تحميل على Google Play Console

## 💡 نصائح تطوير

- استخدم Android Emulator لـ fast development
- اختبر على أجهزة حقيقية قبل النشر
- راقب حجم APK
- استخدم ProGuard لتقليل الحجم
- اختبر الأداء على أجهزة منخفضة الإمكانيات

---

**جزاك الله خيراً!** 💚