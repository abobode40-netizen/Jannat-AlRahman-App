#!/bin/bash
# سكريبت بناء وإطلاق التطبيق بسهولة

echo "🌿 مرحباً بك في تطبيق جنّة الرحمن"
echo "===================================="
echo ""
echo "اختر الخيار المطلوب:"
echo "1. بناء Debug APK"
echo "2. بناء Release APK"
echo "3. تثبيت على جهاز"
echo "4. تشغيل الاختبارات"
echo "5. تنظيف المشروع"
echo "6. الخروج"
echo ""
read -p "اختيارك (1-6): " choice

case $choice in
    1)
        echo "📦 جاري بناء Debug APK..."
        ./gradlew assembleDebug
        echo "✅ تم! الملف في: app/build/outputs/apk/debug/app-debug.apk"
        ;;
    2)
        echo "📦 جاري بناء Release APK..."
        ./gradlew assembleRelease
        echo "✅ تم! الملف في: app/build/outputs/apk/release/app-release-unsigned.apk"
        ;;
    3)
        echo "📦 جاري التثبيت على الجهاز..."
        ./gradlew installDebug
        echo "✅ تم التثبيت!"
        ;;
    4)
        echo "🧪 جاري تشغيل الاختبارات..."
        ./gradlew test
        ;;
    5)
        echo "🧹 جاري تنظيف المشروع..."
        ./gradlew clean
        echo "✅ تم التنظيف!"
        ;;
    6)
        echo "👋 وداعاً!"
        exit 0
        ;;
    *)
        echo "❌ اختيار غير صحيح!"
        exit 1
        ;;
esac