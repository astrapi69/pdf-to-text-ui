### Documentation for PDF-to-Text UI

#### Overview
The PDF-to-Text UI is a Java Swing-based application designed to extract text from PDF files using OCR technology. This application provides a user-friendly interface for importing PDF files, selecting OCR language options, and exporting extracted text to a file.

#### Features
1. **Select OCR Language**: Users can choose from multiple languages for OCR processing via a dropdown menu.
2. **Import PDF**: A button to upload a PDF file for text extraction.
3. **Export to File**: A button to save the extracted text to a file.
4. **Preview Text**: Displays the extracted text in a large, editable text area.
5. **Logging Panel**: A console-like area to display logs and debug information.

#### User Interface Components
- **Menu Bar**:
    - **File**: Placeholder for future options.
    - **Look and Feel**: Allows users to customize the appearance of the application.
    - **Help**: Links to application help and support.
- **Toolbar**:
    - **Select OCR Language**: Dropdown menu for selecting the desired OCR language.
    - **Import PDF**: Button to open a file chooser dialog for selecting a PDF file.
    - **Export to File**: Button to export the extracted text to a file.
- **Text Area**:
    - A large, editable space to display the extracted text.
- **Logging Panel**:
    - Located at the bottom of the application, it shows debug information and application logs.

#### Usage Instructions
1. **Select OCR Language**:
    - From the dropdown menu in the toolbar, choose the desired language for OCR processing.

2. **Import a PDF**:
    - Click the **Import PDF** button.
    - A file chooser dialog will appear. Navigate to the desired PDF file and click **Open**.

3. **Extract Text**:
    - The application will process the PDF and display the extracted text in the text area.

4. **Edit Text (Optional)**:
    - The text displayed in the text area can be manually edited if needed.

5. **Export to File**:
    - Click the **Export to File** button.
    - Choose a location to save the file, specify a file name, and click **Save**.

#### Troubleshooting
- If no plugins are found, ensure the plugin directory is correctly set up and contains valid plugins.
- If the OCR process fails:
    - Verify that the PDF file is not corrupted.
    - Check the selected OCR language compatibility.

#### Logs
The logging panel at the bottom displays messages for:
- Debugging
- Errors
- Status updates

#### Requirements
- **Java Version**: Ensure Java 8 or higher is installed.
- **Dependencies**: Apache PDFBox, Tesseract OCR, and related libraries.

#### Future Enhancements
- Add more OCR languages.
- Support for batch processing of multiple PDFs.
- Improved error handling and notifications.

#### Help and Support
For further assistance, consult the documentation or contact the developer.

