# 👗 Namma Vastra

> **Namma Vastra** (ನಮ್ಮ ವಸ್ತ್ರ) — *"Our Clothing"* in Kannada — is an Android e-commerce application for browsing and purchasing clothing and apparel.

---

## 📱 About

Namma Vastra is a native Android shopping app built with a mix of **Java** and **Kotlin**. It leverages **Firebase** for backend services such as authentication, real-time database, and cloud storage, providing a seamless and responsive shopping experience.

---

## 🛠️ Tech Stack

| Layer | Technology |
|---|---|
| Language | Java (54.7%) + Kotlin (45.3%) |
| Platform | Android |
| Build System | Gradle |
| Backend / Auth | Firebase (Google Services) |
| Min SDK | Android (configured via app module) |

---

## 🚀 Getting Started

### Prerequisites

- Android Studio (Hedgehog or later recommended)
- JDK 11 or higher
- A Firebase project with `google-services.json`

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/KarthickHullur/NammaVastra.git
   cd NammaVastra
   ```

2. **Add Firebase configuration**

   Download your `google-services.json` from the [Firebase Console](https://console.firebase.google.com/) and place it inside the `app/` directory:
   ```
   app/google-services.json
   ```

3. **Open in Android Studio**

   Open the project folder in Android Studio and let Gradle sync automatically.

4. **Run the app**

   Connect an Android device or start an emulator, then click **Run ▶** or use:
   ```bash
   ./gradlew assembleDebug
   ```

---

## 📂 Project Structure

```
NammaVastra/
├── app/                    # Main application module
│   └── src/
│       ├── main/
│       │   ├── java/       # Java source files
│       │   ├── kotlin/     # Kotlin source files
│       │   ├── res/        # Layouts, drawables, strings
│       │   └── AndroidManifest.xml
│       └── ...
├── build.gradle            # Root build configuration
├── settings.gradle         # Project settings
├── gradle.properties       # Gradle properties
└── gradle/wrapper/         # Gradle wrapper files
```

---

## 🔧 Build Configuration

Key dependency versions (from `build.gradle`):

- Android Gradle Plugin: `8.1.2`
- Kotlin: `1.9.0`
- Google Services (Firebase): `4.4.0`

---

## 🤝 Contributing

Contributions are welcome! To get started:

1. Fork the repository
2. Create a new branch: `git checkout -b feature/your-feature-name`
3. Make your changes and commit: `git commit -m 'Add your feature'`
4. Push to your fork: `git push origin feature/your-feature-name`
5. Open a Pull Request

---

## 📄 License

This project is open source. See the repository for details.

---

## 👤 Author

**Karthick Hullur**
- GitHub: [@KarthickHullur](https://github.com/KarthickHullur)

---

*Built with ❤️ for the local clothing community*
