# Jannat AlRahman - Islamic Quran & Worship Tracker App

## 📱 نبذة عن المشروع

تطبيق قرآني إسلامي متكامل يجمع بين:
- 📖 **تلاوة القرآن الكريم** مع تفاسير وتلاوات صوتية
- 🤲 **تتبع الأذكار والعبادات** بشكل يومي
- 🌳 **نظام شجرة العبادات** - شجرة تنمو مع كل عبادة
- 🎙️ **البحث الصوتي** والتعرف على الكلام
- ⏰ **تنبيهات يومية** للأذكار والصلوات
- 📊 **إحصائيات وإحصاءات** متقدمة للتقدم الإيماني

## 🎨 المميزات

✅ **واجهة عربية أصيلة** - تصميم إسلامي جميل وهادئ  
✅ **استقلالية كاملة** - يعمل بدون إنترنت  
✅ **أمان عالي** - بيانات محفوظة محلياً  
✅ **دعم الصوت** - تسجيل والتعرف على الكلام العربي  
✅ **نسخة احتياطية** - تصدير واستيراد البيانات بسهولة  
✅ **تعدد المنصات** - ويب + أندرويد  

## 🛠️ المتطلبات

- Android Studio (Hedgehog أو أحدث)
- Android SDK 24+
- Gradle 8.1+
- Java/Kotlin SDK

## 📦 البناء والتشغيل

### 1. استنساخ المستودع
```bash
git clone https://github.com/abobode40-netizen/Jannat-AlRahman-App.git
cd Jannat-AlRahman-App
```

### 2. فتح المشروع في Android Studio
```bash
android-studio .
```

### 3. تثبيت المتطلبات
- سيقوم Gradle تلقائياً بتحميل المكتبات

### 4. بناء ملف APK
```bash
# Debug APK
./gradlew assembleDebug

# Release APK
./gradlew assembleRelease
```

### 5. تشغيل على جهاز أو محاكي
```bash
./gradlew installDebug
```

## 📁 هيكل المشروع

```
Jannat-AlRahman-App/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/jannat/alrahman/
│   │       │   ├── MainActivity.kt              # النشاط الرئيسي
│   │       │   ├── QuranActivity.kt             # نشاط القرآن
│   │       │   ├── AthkarActivity.kt            # نشاط الأذكار
│   │       │   ├── TreeActivity.kt              # نشاط الشجرة
│   │       │   ├── adapters/                    # محولات RecyclerView
│   │       │   ├── services/                    # الخدمات
│   │       │   ├── receivers/                   # المستقبلات
│   │       │   ├── providers/                   # مزودو البيانات
│   │       │   ├── utils/                       # أدوات مساعدة
│   │       │   └── data/                        # نماذج البيانات
│   │       ├── res/
│   │       │   ├── layout/                      # ملفات XML للواجهات
│   │       │   ├── values/                      # الموارد (الألوان، النصوص)
│   │       │   └── xml/                         # ملفات XML إضافية
│   │       └── assets/
│   │           └── jannat-alrahman-page.html    # صفحة الويب
│   ├── build.gradle.kts                         # ملف بناء المشروع
│   └── proguard-rules.pro                       # قواعد ProGuard
├── build.gradle.kts                             # ملف بناء جذر
└── settings.gradle.kts                          # إعدادات Gradle
```

## 🔐 الأذونات المطلوبة

- `RECORD_AUDIO` - لتسجيل الصوت والبحث الصوتي
- `INTERNET` - لتحميل التلاوات والتفاسير
- `ACCESS_NETWORK_STATE` - للتحقق من الاتصال
- `READ_EXTERNAL_STORAGE` - لقراءة ملفات التلاوات
- `WRITE_EXTERNAL_STORAGE` - لحفظ التسجيلات
- `POST_NOTIFICATIONS` - للتنبيهات

## 📖 التوثيق

### إضافة صفحة HTML
1. ضع ملف HTML في `app/src/main/assets/`
2. حمّله في MainActivity عبر:
```kotlin
webView.loadUrl("file:///android_asset/filename.html")
```

### استخدام البحث الصوتي
```kotlin
val speechIntent = SpeechRecognitionHelper.startListening(context)
startActivityForResult(speechIntent, SPEECH_REQUEST_CODE)
```

### إدارة النسخة الاحتياطية
```kotlin
val backupManager = BackupManager(context)
val backupJson = backupManager.exportBackup()
backupManager.importBackup(backupJson)
```

## 🎯 الميزات المخطط إضافتها

- [ ] تطبيق آي فون (iOS)
- [ ] مزامنة سحابية للبيانات
- [ ] مكتبة تفاسير متقدمة
- [ ] نظام تحديات يومية
- [ ] مشاركة الإنجازات
- [ ] وضع أوفلاين محسّن

## 📝 الترخيص

هذا المشروع مرخص تحت رخصة MIT - انظر ملف [LICENSE](LICENSE) للتفاصيل.

## 🙏 شكر خاص

شكراً لكل من ساهم في هذا المشروع. نسأل الله أن يجعله صدقة جارية.

## 📧 التواصل والدعم

- 📌 للإبلاغ عن الأخطاء: [Issues](https://github.com/abobode40-netizen/Jannat-AlRahman-App/issues)
- 💬 للمناقشات: [Discussions](https://github.com/abobode40-netizen/Jannat-AlRahman-App/discussions)
- 📬 البريد الإلكتروني: abobode40@gmail.com

---

**جزاكم الله خيراً وجعل هذا العمل صدقة جارية لكم ولوالديكم ❤️**

*آخر تحديث: 26 أغسطس 2026*