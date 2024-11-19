#!/bin/bash

# This script installs Tesseract OCR on Windows or Linux.
# Run this script with administrative privileges.

# Function to detect OS
function detect_os() {
  if [[ "$OSTYPE" == "linux-gnu"* ]]; then
    echo "linux"
  elif [[ "$OSTYPE" == "msys" || "$OSTYPE" == "cygwin" ]]; then
    echo "windows"
  else
    echo "unsupported"
  fi
}

# Function to install Tesseract on Linux
function install_tesseract_linux() {
  echo "Updating package lists..."
  sudo apt update || { echo "Failed to update package lists"; exit 1; }

  echo "Installing Tesseract OCR..."
  sudo apt install -y tesseract-ocr || { echo "Failed to install Tesseract"; exit 1; }

  echo "Tesseract installation completed!"
}

# Function to install Tesseract on Windows (using Chocolatey)
function install_tesseract_windows() {
  echo "Checking if Chocolatey is installed..."
  if ! command -v choco &> /dev/null; then
    echo "Chocolatey not found. Installing Chocolatey..."
    powershell -NoProfile -ExecutionPolicy Bypass -Command \
      "Set-ExecutionPolicy Bypass -Scope Process -Force; \
      [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; \
      iex ((New-Object System.Net.WebClient).DownloadString('https://chocolatey.org/install.ps1'))" || { echo "Failed to install Chocolatey"; exit 1; }
  fi

  echo "Installing Tesseract OCR using Chocolatey..."
  choco install -y tesseract || { echo "Failed to install Tesseract with Chocolatey"; exit 1; }

  echo "Tesseract installation completed!"
}

# Main script execution
OS=$(detect_os)

if [[ "$OS" == "linux" ]]; then
  install_tesseract_linux
elif [[ "$OS" == "windows" ]]; then
  install_tesseract_windows
else
  echo "Unsupported operating system: $OSTYPE"
  exit 1
fi
