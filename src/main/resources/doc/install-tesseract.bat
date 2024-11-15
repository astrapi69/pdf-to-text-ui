@echo off
REM This batch script installs Tesseract OCR on Windows without using Chocolatey.
REM It downloads the Tesseract installer from the official source and runs it.

SETLOCAL

REM Set the download URL for Tesseract installer
SET TESSERACT_URL=https://github.com/tesseract-ocr/tesseract/releases/download/v5.3.1/tesseract-ocr-w64-setup-v5.3.1.20230401.exe
SET INSTALLER_NAME=tesseract-ocr-w64-setup.exe

REM Check if curl or PowerShell is available for downloading
if exist "%SYSTEMROOT%\System32\curl.exe" (
    echo Downloading Tesseract OCR installer using curl...
    curl -L -o %INSTALLER_NAME% %TESSERACT_URL%
) else (
    echo Downloading Tesseract OCR installer using PowerShell...
    powershell -Command "& {[Net.ServicePointManager]::SecurityProtocol = [Net.SecurityProtocolType]::Tls12; Invoke-WebRequest -Uri '%TESSERACT_URL%' -OutFile '%INSTALLER_NAME%'}"
)

REM Check if the installer was downloaded
if not exist %INSTALLER_NAME% (
    echo Failed to download Tesseract installer.
    exit /b 1
)

REM Run the installer
echo Running Tesseract OCR installer...
%INSTALLER_NAME%

REM Clean up the installer after installation
if exist %INSTALLER_NAME% (
    echo Cleaning up installer...
    del %INSTALLER_NAME%
)

echo Tesseract OCR installation completed!
ENDLOCAL
