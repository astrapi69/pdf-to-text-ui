<div style="text-align: center">

# 📄 PDF-to-Text UI

[![License: MIT](https://img.shields.io/badge/license-MIT-blue.svg)](LICENSE)
[![Release](https://img.shields.io/github/v/release/astrapi69/pdf-to-text-ui?color=brightgreen)](https://github.com/astrapi69/pdf-to-text-ui/releases)
[![Java](https://img.shields.io/badge/Java-21+-orange.svg)](https://adoptium.net)
[![Donate](https://img.shields.io/badge/donate-❤-ff2244.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=GVBTWLRAZ7HB8)
[![Hits of Code](https://hitsofcode.com/github/astrapi69/pdf-to-text-ui?branch=develop)](https://hitsofcode.com/github/astrapi69/pdf-to-text-ui/view?branch=develop)

</div>

---
## 🧩 Overview

**PDF-to-Text UI** is a lightweight, cross-platform **desktop tool** for extracting **plain text from PDF files**,
built with **Java Swing** and **Apache PDFBox**.
It can handle single documents or entire folders in batch mode
completely **offline**, with no cloud upload.

> ⚠️ Before running the application, make sure **Tesseract OCR** and **Poppler (pdftoppm)** are installed
> if you plan to convert scanned image-based PDFs.
> See the [**Prerequisites**](https://github.com/astrapi69/pdf-to-text-ui/wiki/Prerequisites) page for detailed setup instructions (Linux & Windows).

---

## 🚀 Features

- 🖥️ Simple and intuitive **Swing interface**
- 📂 Convert **single files or entire folders**
- ⚙️ Powered by **Apache PDFBox** (no external dependencies)
- 🧾 **Batch processing** with progress indicator
- 🌍 Full **Unicode** and multi-language support
- 💾 Save all extracted text files in the chosen output folder
- 🔒 **100 % offline** – no cloud upload or telemetry

---

## 📦 Installation & Usage

### 1️⃣ Download

👉 [**Get the latest release**](https://github.com/astrapi69/pdf-to-text-ui/releases/latest)
Download the `pdf-to-text-ui-<version>-all.jar` or `pdf-to-text-ui-<version>-installer.jar`  file.

### 2️⃣ Run the app

```bash
java -jar pdf-to-text-ui-<version>-all.jar
```

or simply double-click the JAR file.

> Requires **Java 21 or newer** (recommended: [Adoptium Temurin](https://adoptium.net)).

---

## 🧭 Typical Workflow

1. Launch the app
2. Select a PDF file or directory
3. Choose an output folder
4. Click **Convert**
5. Find the resulting `.txt` files in your target directory

---

## 🧩 Build from Source

```bash
git clone https://github.com/astrapi69/pdf-to-text-ui.git
cd pdf-to-text-ui
./gradlew run
```

**Create a fat JAR:**

```bash
./gradlew clean shadowJar
# output: build/libs/pdf-to-text-ui-*-all.jar
```

Optional native packages:

```bash
./gradlew jpackage
```

---

## 🧪 Run Tests

```bash
./gradlew test
```

---

## 🧱 Architecture Overview

| Module                        | Description                               |
| :---------------------------- | :---------------------------------------- |
| `pdf-to-text-core`            | Core logic – text extraction using PDFBox |
| `pdf-to-text-ui`              | Swing desktop interface                   |
| *(planned)* `pdf-to-text-cli` | Command-line batch tool                   |

---

## 📘 Documentation & Wiki

Visit the [**Wiki**](https://github.com/astrapi69/pdf-to-text-ui/wiki) for detailed information.

---

## 🗺️ Roadmap

* [ ] CLI mode for headless batch processing
* [ ] Optional OCR (Tesseract/Tess4J integration)
* [ ] Progress bar & cancel operation
* [ ] Multi-language UI (English / German)
* [ ] Native installers (.deb, .msi, .dmg)

See progress in the [**project board**](https://github.com/astrapi69/pdf-to-text-ui/projects).

---

## 📜 License

Licensed under the [MIT License](LICENSE).
Includes components from **Apache PDFBox** (Apache License 2.0).

---

## 💖 Donations & Support

This project is open source and maintained in personal time.
If you find it useful, please consider supporting the development:

[![Donate](https://img.shields.io/badge/donate-❤-ff2244.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=MJ7V43GU2H386)

---

## 🧮 Versioning

Follows **[Semantic Versioning](https://semver.org)**: `<major>.<minor>.<patch>`
Detailed guidelines are available in the [mvn-parent-projects wiki](https://github.com/lightblueseas/mvn-parent-projects/wiki/Semantic-Versioning).

---

## 📫 Contact / Contribute

* Feature requests & bug reports → [GitHub Issues](https://github.com/astrapi69/pdf-to-text-ui/issues)
* Fork → [Create a PR](https://github.com/astrapi69/pdf-to-text-ui/fork)
* Please add unit tests for any code changes.

---

## 🐾 Note

No animals were harmed in the making of this software.

---
