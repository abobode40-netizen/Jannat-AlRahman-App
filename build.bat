@REM سكريبت بناء للويندوز
@echo off
chcp 65001 >nul
echo 🌿 مرحباً بك في تطبيق جنّة الرحمن
echo ====================================
echo.
echo اختر الخيار المطلوب:
echo 1. بناء Debug APK
echo 2. بناء Release APK
echo 3. تثبيت على جهاز
echo 4. تنظيف المشروع
echo 5. الخروج
echo.
set /p choice="اختيارك (1-5): "

if %choice%==1 (
    echo 📦 جاري بناء Debug APK...
    call gradlew.bat assembleDebug
    echo ✅ تم! الملف في: app\build\outputs\apk\debug\app-debug.apk
) else if %choice%==2 (
    echo 📦 جاري بناء Release APK...
    call gradlew.bat assembleRelease
    echo ✅ تم! الملف في: app\build\outputs\apk\release\app-release-unsigned.apk
) else if %choice%==3 (
    echo 📦 جاري التثبيت على الجهاز...
    call gradlew.bat installDebug
    echo ✅ تم التثبيت!
) else if %choice%==4 (
    echo 🧹 جاري تنظيف المشروع...
    call gradlew.bat clean
    echo ✅ تم التنظيف!
) else if %choice%==5 (
    echo 👋 وداعاً!
    exit /b 0
) else (
    echo ❌ اختيار غير صحيح!
    exit /b 1
)