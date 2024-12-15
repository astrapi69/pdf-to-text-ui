## Change log
----------------------

Version 1.4.0-SNAPSHOT
-------------

## [Unreleased]
## Added
- **Task**: `prepareIzpackInstallerJars`
  - Handles JAR preparation and signing.
  - Depends on `withAllDependendiesJar`.
  - Automatically triggers `izPackCreateInstaller` after signing.
- **Helper Method**: `signJarsWithAnt`
  - Centralized logic for signing JAR files using Ant.

## Changed
- **Dependency Management**:
  - Updated `commons-text-version` to `1.13.0` in `gradle/libs.versions.toml`.

## Fixed
- Improved validation for keystore configuration:
  - Ensures the keystore file exists before signing.
  - Added detailed debugging messages for signing properties and process.

This update streamlines the workflow for creating IzPack installers by ensuring proper preparation and signing of JAR files.

Version 1.3.0
-------------

### Added
- Dynamic button state management in `PdfToTextPanel`:
    - Import button is always enabled.
    - Start OCR Process button is enabled only when a PDF file is selected.
    - Export button is enabled only when the text area contains text.
    - Clear Editors button remains always enabled.

### Changed
- Upgraded Gradle to version 8.12-rc-1
- Updated action listeners in `PdfToTextPanel` to trigger state updates, ensuring buttons reflect the current application state.

### Fixed
- Buttons no longer remain enabled when actions cannot be performed, improving user interaction and preventing invalid operations.

Version 1.2.0
-------------

### Changed

- Upgraded Gradle to version 8.11.1
- Updated `silly-io` dependency to version 3.6
- Improved OCR processing for non-normalized file names

Version 1.1.0
-------------

### Added
- Installation script for Tesseract OCR on Linux using Bash
- Installation script for Tesseract OCR on Windows using Batch (without Chocolatey)
- Installation script for Tesseract OCR on Windows with Chocolatey (via Bash)
- New field in `ApplicationModelBean` for the selected PDF file
- new dependency `io.github.astrapi69:jobj-core` in version 9.1

### Changed
- Updated Lombok dependency to patch version `1.18.36`
- Upgraded Gradle plugin `io.freefair.lombok` to version 8.11
- Updated dependency `pdf-to-text-extensions` to minor version `1.4`
- Updated dependency `silly-io` to minor version `3.4`

Version 1.0.0
-------------

### Added
- Created `CHANGELOG.md` file

---

**Notable links:**
[Keep a Changelog](http://keepachangelog.com/en/1.0.0/) — Don’t let your friends dump git logs into changelogs
