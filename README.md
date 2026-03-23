# 📱 Ringtones Gallery App - Buen Fin 2026

![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Android Studio](https://img.shields.io/badge/Android%20Studio-3DDC84?style=for-the-badge&logo=android-studio&logoColor=white)

Este proyecto es una aplicación móvil nativa para Android desarrollada como parte de la formación académica en **Ingeniería en Desarrollo de Software**. La aplicación consiste en una galería interactiva de 10 ringtones diseñados para la campaña promocional del "Buen Fin".

## 🚀 Características
* **Interfaz de Usuario (UI):** Implementación de una lista navegable mediante `ScrollView` con elementos organizados horizontalmente (`LinearLayout`).
* **Control de Audio:** Gestión de archivos multimedia utilizando la clase `MediaPlayer` de Android.
* **Lógica de Estados (Toggle):** Sistema dinámico que alterna iconos de `play` y `pause` según el estado de reproducción y detiene audios previos al iniciar uno nuevo.
* **Optimización de Recursos:** Normalización de nomenclatura de archivos según estándares de Google para evitar errores de compilación en el archivo `R`.

## 🛠️ Stack Tecnológico
* **Lenguaje:** Kotlin
* **Diseño:** XML (Android Views)
* **Gestión de Versiones:** Git / GitHub
* **Entorno de Desarrollo:** Android Studio (Ladybug)

## 📂 Estructura del Proyecto
```text
├── app/src/main/
│   ├── java/com/pascal/ringtone/
│   │   └── MainActivity.kt      # Lógica de reproducción y manejo de eventos
│   └── res/
│       ├── drawable/            # Recursos gráficos (iconos play/pause)
│       ├── layout/              # Diseño de la interfaz (activity_main.xml)
│       └── raw/                 # Archivos de audio .mp3 normalizados
```

## 📝 Metodología de Desarrollo
El desarrollo se centró en la creación de una arquitectura orientada a eventos. Se aplicaron conceptos de:

* **Ciclo de Vida de Android:** Liberación de recursos de memoria en el método `onDestroy`.
* **Manejo de Recursos:** Solución de conflictos de referencias (`Unresolved reference R`) mediante la gestión correcta de paquetes e imports.
* **Automation:** Uso de scripts en terminal para el refactor de nombres de archivos multimedia de forma masiva.
