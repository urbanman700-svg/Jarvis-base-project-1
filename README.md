# 🎙️ JARVIS Voice Assistant (Base Project)

एक अत्यंत शक्तिशाली और पूरी तरह से ऑफलाइन काम करने वाला वॉइस असिस्टेंट जो **Accessibility Service** और **Vosk Offline Engine** का उपयोग करके आपके फोन को नियंत्रित कर सकता है।

---

## ✨ Features (मुख्य विशेषताएं)
- **Offline Voice Recognition:** Vosk Offline Speech Model के उपयोग से बिना इंटरनेट के कमांड्स पहचान सकता है।
- **Accessibility Integration:** ऐप्स खोलना, स्क्रॉल करना, क्लिक करना और सिस्टम सेटिंग्स को आवाज से कंट्रोल करना।
- **Aesthetic UI/UX:** `index.html` बेस्ड डार्क मोड और सॉफ्ट पलसेटिंग (Breathing Effect) एनिमेशन के साथ प्रीमियम लुक।
- **Helper Foreground Service:** बैकग्राउंड और स्टैंडबाय में माइक्रोफ़ोन रिकॉर्डिंग और CPU वेक-लॉक को लगातार बनाए रखना।

---

## 🚀 GitHub Automated Build (GitHub से Real 19 MB APK डाउनलोड करें)

चूंकि AI Studio का वेब डाउनलोडर कई बार JNI libraries को पूरी तरह सिंक नहीं कर पाता जिससे 3.54 MB का खाली APK डाउनलोड हो जाता है, हमने इस प्रोजेक्ट में **GitHub Actions CI/CD** सेटअप कर दिया है। 

हर बार जब आप कोड को GitHub पर पुश करेंगे, GitHub का क्लाउड प्रोसेसर अपने आप बैकग्राउंड पर असली और पूरे साइज़ का APK (**~19.06 MB**) कम्पाइल कर देगा।

### APK डाउनलोड करने का तरीका (How to download working APK):
1. अपने इस GitHub Repository के ऊपर बने **"Actions"** टैब पर जाएं।
2. सबसे ऊपर वाले लेटेस्ट रन (Run) पर क्लिक करें।
3. नीचे स्क्रॉल करके **Artifacts** सेक्शन में जाएं।
4. वहाँ आपको **`jarvis-voice-assistant-apk`** नाम की फाइल मिलेगी। इसपर क्लिक करके पूरी तरह वर्किंग JNI-सपोर्टेड APK डाउनलोड करें!

---

## 🛠️ GitHub Push Failure Fix (गिथुब पर पुश फेल होने का कारण और समाधान)

अगर AI Studio में **"Failed to push commit to GitHub"** एरर आ रही है, तो इसके 2 मुख्य कारण होते हैं:

### 1. Remote Branch Conflict (सबसे आम कारण)
यदि आपने GitHub पर नया रिपोजिटरी बनाते समय **"Create README.md"** या **".gitignore"** विकल्प चुन लिया था, तो आपके क्लाउड (Remote) पर एक कमिट पहले से बन गया है जो आपके लोकल (Local) AI Studio में नहीं है।
*   **समाधान:** 
    अपने लोकल कंप्यूटर पर Git खोलें और यह कमांड्स रन करें:
    ```bash
    git clone https://github.com/urbanman700-svg/Jarvis-base-project-1.git
    # इसमें प्रोजेक्ट फाइल्स कॉपी करें और:
    git add .
    git commit -m "feat: complete real voice assistant with breathing standby core"
    git push origin main --force
    ```

### 2. Authentication / Token Expiry
कई बार GitHub Integration टोकन की परमिशन एक्सपायर हो जाती है। AI Studio के दाएँ हाथ के पैनल में ऊपर **"GitHub"** इंटीग्रेशन वाले बटन पर क्लिक करके डिस्कनेक्ट करें और दोबारा ऑथराइज़ (Re-authorize) करें।

---

## 🛠️ Project Structure
*   `app/src/main/assets/index.html` — आकर्षक UI, नियंत्रण और डायग्नोस्टिक्स।
*   `app/src/main/java/com/example/myapplication/` — मुख्य जावा/कोटलिन सोर्स कोड।
    *   `JarvisAccessibilityService.kt` — एक्सेसिबिलिटी एक्सेस और रिमोट कमांड एक्जीक्यूशन।
    *   `JarvisService.kt` — लॉन्ग-रनिंग फोरग्राउंड सर्विस (Microphone context संरक्षण के लिए)।
    *   `SilentVoiceEngine.kt` — Vosk JNI ब्रिज और लाइव PCM रिकॉर्डर बफर।
