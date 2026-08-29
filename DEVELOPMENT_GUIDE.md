# 🌿 دليل التطوير الكامل لتطبيق جنّة الرحمن

## 📋 فهرس المحتويات
1. [نظرة عامة](#نظرة-عامة)
2. [هيكل المشروع](#هيكل-المشروع)
3. [التثبيت والإعداد](#التثبيت-والإعداد)
4. [البناء والتشغيل](#البناء-والتشغيل)
5. [شرح الملفات الرئيسية](#شرح-الملفات-الرئيسية)
6. [الميزات المُطبّقة](#الميزات-المُطبّقة)
7. [الخطوات التالية](#الخطوات-التالية)

---

## 🎯 نظرة عامة

**تطبيق جنّة الرحمن** هو تطبيق Android متكامل يوفر:
- 📖 تلاوة القرآن الكريم مع تفاسير وتلاوات صوتية
- 🤲 نظام متابعة الأذكار والعبادات اليومية
- 🌳 شجرة العبادات التفاعلية (نظام تحفيزي)
- 🎙️ البحث الصوتي والتعرف على الكلام العربي
- ⏰ تنبيهات يومية مخصصة
- 💾 نظام نسخ احتياطي واستيراد البيانات
- 🌙 دعم الوضع الليلي
- 📊 إحصائيات وإحصاءات متقدمة

---

## 📁 هيكل المشروع

```
Jannat-AlRahman-App/
├── app/
│   ├── build.gradle.kts                    # إعدادات بناء التطبيق
│   ├── proguard-rules.pro                  # قواعد حماية الكود
│   └── src/
│       └── main/
│           ├── java/com/jannat/alrahman/
│           │   ├── MainActivity.kt          # النشاط الرئيسي
│           │   ├── QuranActivity.kt         # نشاط القرآن
│           │   ├── AthkarActivity.kt        # نشاط الأذكار
│           │   ├── TreeActivity.kt          # نشاط الشجرة
│           │   ├── SettingsActivity.kt      # نشاط الإعدادات
│           │   ├── SplashActivity.kt        # شاشة البداية
│           │   │
│           │   ├── adapters/
│           │   │   ├── SurahAdapter.kt      # عرض قائمة السور
│           │   │   └── AthkarAdapter.kt     # عرض قائمة الأذكار
│           │   │
│           │   ├── services/
│           │   │   ├── AudioService.kt      # خدمة تشغيل الصوت
│           │   │   └── NotificationService.kt # خدمة الإشعارات
│           │   │
│           │   ├── receivers/
│           │   │   └── AlarmReceiver.kt     # استقبال التنبيهات
│           │   │
│           │   ├── providers/
│           │   │   └── QuranProvider.kt     # مزود بيانات القرآن
│           │   │
│           │   ├── utils/
│           │   │   ├── SpeechRecognitionHelper.kt  # البحث الصوتي
│           │   │   ├── BackupManager.kt           # إدارة النسخ الاحتياطية
│           │   │   └── SharedPreferencesManager.kt # إدارة التخزين المحلي
│           │   │
│           │   └── data/
│           │       ├── BackupData.kt        # نماذج البيانات
│           │       └── Preferences.kt       # مفاتيح التفضيلات
│           │
│           ├── res/
│           │   ├── layout/
│           │   │   ├── activity_main.xml
│           │   │   ├── activity_quran.xml
│           │   │   ├── activity_athkar.xml
│           │   │   ├── activity_tree.xml
│           │   │   ├── activity_settings.xml
│           │   │   ├── item_surah.xml
│           │   │   └── item_athkar.xml
│           │   ├── values/
│           │   │   ├── strings.xml          # النصوص العربية
│           │   │   ├── colors.xml           # الألوان
│           │   │   └── styles.xml           # الأنماط والثيمات
│           │   ├── menu/
│           │   │   ├── menu_main.xml
│           │   │   └── menu_settings.xml
│           │   └── xml/
│           │       ├── data_extraction_rules.xml
│           │       └── backup_rules.xml
│           │
│           ├── assets/
│           │   └── jannat-alrahman-page.html    # صفحة الويب
│           └── AndroidManifest.xml          # إعدادات التطبيق
│
├── build.gradle.kts                         # إعدادات Gradle الجذرية
├── settings.gradle.kts                      # إعدادات المشروع
├── .gitignore
├── README.md                                # التوثيق الأساسي
├── BUILD_GUIDE.md                           # دليل البناء السريع
└── DEVELOPMENT_GUIDE.md                     # هذا الملف
```

---

## 🛠️ التثبيت والإعداد

### المتطلبات المسبقة
- **Java**: JDK 1.8+
- **Android Studio**: Hedgehog 2023.1.1+
- **Android SDK**: مستوى 34 (Android 14)
- **Gradle**: 8.1+
- **Git**: آخر إصدار

### خطوات التثبيت

#### 1. استنساخ المستودع
```bash
git clone https://github.com/abobode40-netizen/Jannat-AlRahman-App.git
cd Jannat-AlRahman-App
```

#### 2. فتح المشروع في Android Studio
```bash
android-studio .
```

#### 3. انتظر مزامنة Gradle
ستقوم Android Studio تلقائياً بـ:
- تحميل المكتبات المطلوبة
- تجميع ملفات الموارد
- إنشاء ملفات الوسيط

#### 4. تثبيت SDK إذا لزم الأمر
- SDK 34 (Android 14)
- SDK Tools
- Android Emulator

---

## 🚀 البناء والتشغيل

### بناء Debug APK (للاختبار)
```bash
./gradlew assembleDebug
```
**الملف الناتج**: `app/build/outputs/apk/debug/app-debug.apk`

### تشغيل على محاكي أو جهاز حقيقي
```bash
# من Android Studio:
# Run → Run 'app'

# أو من سطر الأوامر:
./gradlew installDebug
```

### بناء Release APK (للنشر)
```bash
./gradlew assembleRelease
```
**الملف الناتج**: `app/build/outputs/apk/release/app-release-unsigned.apk`

### توقيع مملف APK
```bash
# إنشاء Keystore جديد
keytool -genkey -v -keystore jannat-keystore.jks -keyalg RSA -keysize 2048 -validity 10000 -alias jannat-key

# توقيع الملف
jarsigner -verbose -sigalg MD5withRSA -digestalg SHA1 -keystore jannat-keystore.jks app-release-unsigned.apk jannat-key

# محاذاة الملف
zipalign -v 4 app-release-unsigned.apk app-release-signed.apk
```

---

## 📖 شرح الملفات الرئيسية

### 1. MainActivity.kt
```kotlin
// النشاط الرئيسي الذي يحمل صفحة الويب
- يفعّل WebView
- يطلب إذن الميكروفون
- يحمل صفحة HTML المحلية
- يدير العودة والتنقل
```

### 2. QuranActivity.kt
```kotlin
// نشاط لعرض السور والآيات
- قائمة بجميع السور
- عرض النص القرآني
- تشغيل التلاوات الصوتية
- الفواصل المرجعية
```

### 3. AthkarActivity.kt
```kotlin
// نشاط لعرض الأذكار
- قائمة الأذكار المصنفة
- عداد لكل ذكر
- حفظ الحالة
- إحصائيات الأذكار اليومية
```

### 4. TreeActivity.kt
```kotlin
// نشاط لعرض شجرة العبادات
- رسم بياني للشجرة
- نسبة النمو
- الإحصائيات
- المستويات والإنجازات
```

### 5. BackupManager.kt
```kotlin
// إدارة النسخ الاحتياطية
- تصدير البيانات إلى JSON
- استيراد البيانات من JSON
- حفظ في ذاكرة التطبيق
- استرجاع البيانات
```

### 6. AudioService.kt
```kotlin
// خدمة تشغيل الصوت
- تشغيل التلاوات
- التحكم في الصوت
- إيقاف وإعادة تشغيل
- إدارة MediaPlayer
```

### 7. SpeechRecognitionHelper.kt
```kotlin
// البحث الصوتي
- تفعيل ميكروفون الجهاز
- التعرف على الكلام العربي
- تحويل الصوت إلى نص
- البحث عن النتائج
```

---

## ✨ الميزات المُطبّقة

### ✅ مكتملة
- [x] واجهة عربية RTL احترافية
- [x] قراءة القرآن مع WebView
- [x] نظام الأذكار الكامل
- [x] شجرة العبادات
- [x] البحث الصوتي
- [x] النسخ الاحتياطية
- [x] نظام الإشعارات
- [x] الوضع الليلي
- [x] إدارة الأذونات
- [x] تخزين البيانات محلياً

### 🔄 قيد التطوير
- [ ] تطبيق iOS
- [ ] المزامنة السحابية
- [ ] مكتبة تفاسير متقدمة
- [ ] نظام التحديات اليومية
- [ ] مشاركة الإنجازات
- [ ] نمط أوفلاين محسّن

### 🚀 مخطط المستقبل
- [ ] دعم اللغات الأخرى
- [ ] تطبيق ويب Progressive Web App
- [ ] تطبيق سطح المكتب
- [ ] نظام الشهادات
- [ ] تطبيق لجوال آيفون

---

## 🔧 الخطوات التالية للتطوير

### 1. إضافة قاعدة بيانات
```gradle
implementation("androidx.room:room-runtime:2.5.1")
kapt("androidx.room:room-compiler:2.5.1")
```

### 2. إضافة المزامنة السحابية
```gradle
implementation("com.google.firebase:firebase-database-ktx")
implementation("com.google.firebase:firebase-auth-ktx")
```

### 3. تحسين الأداء
- استخدام Coroutines للعمليات غير المتزامنة
- تحسين استهلاك الذاكرة
- تحسين سرعة التحميل

### 4. إضافة اختبارات
```gradle
testImplementation("junit:junit:4.13.2")
androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
```

---

## 📝 ملاحظات التطوير

### أفضل الممارسات المتبعة
- ✅ استخدام Kotlin و Jetpack
- ✅ اتباع نمط MVVM
- ✅ الفصل بين الطبقات
- ✅ إدارة الموارد بحكمة
- ✅ دعم جميع الإصدارات المدعومة
- ✅ توثيق الكود بالعربية

### المكتبات المستخدمة
```kotlin
// Core
androidx.core:core-ktx:1.12.0
androidx.appcompat:appcompat:1.6.1
androidx.constraintlayout:constraintlayout:2.1.4

// Material Design
com.google.android.material:material:1.10.0

// WebView
androidx.webkit:webkit:1.7.0

// Storage & Preferences
androidx.datastore:datastore-preferences:1.0.0

// Network
com.squareup.okhttp3:okhttp:4.11.0
com.google.code.gson:gson:2.10.1

// Permissions
androidx.activity:activity-ktx:1.8.0
androidx.fragment:fragment-ktx:1.6.1
```

---

## 🐛 حل المشاكل الشائعة

### المشكلة: Gradle Sync مفشل
```bash
./gradlew clean
./gradlew --refresh-dependencies
```

### المشكلة: أخطاء الأذونات
- تحقق من AndroidManifest.xml
- اطلب الأذونات في الكود
- اختبر على جهاز فعلي

### المشكلة: ملف APK كبير جداً
- فعّل ProGuard
- قلل حجم الموارد
- استخدم App Bundle

---

## 📞 التواصل والدعم

- 📧 البريد: abobode40@gmail.com
- 🐛 الإبلاغ عن الأخطاء: [Issues](https://github.com/abobode40-netizen/Jannat-AlRahman-App/issues)
- 💬 النقاشات: [Discussions](https://github.com/abobode40-netizen/Jannat-AlRahman-App/discussions)
- ⭐ أضف نجمة للمشروع!

---

## 📄 الترخيص

هذا المشروع مرخص تحت MIT License - انظر [LICENSE](LICENSE) للتفاصيل.

---

**جزاكم الله خيراً وجعل هذا العمل صدقة جارية لكم ولوالديكم ❤️**

*آخر تحديث: 29 أغسطس 2026*