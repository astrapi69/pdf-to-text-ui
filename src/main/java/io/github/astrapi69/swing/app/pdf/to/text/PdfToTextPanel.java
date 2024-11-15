/**
 * The MIT License
 *
 * Copyright (C) 2024 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.astrapi69.swing.app.pdf.to.text;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.*;

import io.github.astrapi69.collection.list.ListExtensions;
import io.github.astrapi69.file.create.DirectoryFactory;
import io.github.astrapi69.file.read.ReadFileExtensions;
import io.github.astrapi69.file.system.SystemFileExtensions;
import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.api.IModel;
import io.github.astrapi69.swing.app.ApplicationModelBean;
import io.github.astrapi69.swing.base.BasePanel;
import io.github.astrapi69.swing.io.TeeOutputStream;
import io.github.astrapi69.swing.io.TextAreaOutputStream;
import io.github.astrapisixtynine.pdf.to.text.info.ConversionResult;
import io.github.astrapisixtynine.pdf.to.text.info.OcrLanguage;
import io.github.astrapisixtynine.pdf.to.text.pdfbox.PdfToTextExtensions;
import io.github.astrapisixtynine.pdf.to.text.tess4j.ImagePdfToTextExtensions;
import lombok.AccessLevel;
import lombok.SneakyThrows;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
public class PdfToTextPanel extends BasePanel<ApplicationModelBean>
{

	JTextArea textArea;
	JScrollPane scrollPane;
	JButton importButton;
	JButton exportButton;
	JProgressBar progressBar;
	JPanel controlPanel;

	// New log text area
	JTextArea logTextArea;
	JScrollPane logScrollPane;
	private JComboBox<OcrLanguage> languageComboBox;

	public PdfToTextPanel(final IModel<ApplicationModelBean> model)
	{
		super(model);
	}

	public PdfToTextPanel()
	{
		this(BaseModel.of(ApplicationModelBean.builder().build()));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onInitializeComponents()
	{
		super.onInitializeComponents();
		ApplicationModelBean modelObject = getModelObject();

		// Initialize language selection combo box
		List<String> tesseractSupportedLanguages = ImagePdfToTextExtensions
			.getTesseractSupportedLanguages();
		List<OcrLanguage> supportedLanguages = PdfToTextPanel
			.filterLanguagesByCodes(tesseractSupportedLanguages);

		languageComboBox = new JComboBox<>(ListExtensions.toArray(supportedLanguages));
		languageComboBox.setSelectedItem(supportedLanguages.get(0)); // Set default language

		// Text area for displaying extracted text
		textArea = new JTextArea(20, 50);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		scrollPane = new JScrollPane(textArea);

		// Log text area for displaying log messages
		logTextArea = new JTextArea(5, 50);
		logTextArea.setEditable(false);
		logScrollPane = new JScrollPane(logTextArea);

		// copy the System.out and System.err to logTextArea
		TextAreaOutputStream textAreaOutputStream = new TextAreaOutputStream(logTextArea);

		// Create TeeOutputStreams that copy to both the original console streams and the JTextArea
		System.setOut(new PrintStream(new TeeOutputStream(System.out, textAreaOutputStream)));
		System.setErr(new PrintStream(new TeeOutputStream(System.err, textAreaOutputStream)));

		// Import and Export buttons
		importButton = new JButton("Import PDF");
		importButton.addActionListener(new ImportButtonListener());

		exportButton = new JButton("Export to File");
		exportButton.addActionListener(new ExportButtonListener());

		// Progress bar
		progressBar = new JProgressBar();
		progressBar.setVisible(false); // Initially hidden
		progressBar.setIndeterminate(true);

		// Control panel
		controlPanel = new JPanel();

		controlPanel.add(new JLabel("Select OCR Language:"));
		controlPanel.add(languageComboBox);
		controlPanel.add(importButton);
		controlPanel.add(exportButton);
		controlPanel.add(progressBar);
	}

	/**
	 * Filters the {@link OcrLanguage} enum values based on the provided list of language codes.
	 *
	 * @param codes
	 *            the list of Tesseract language codes to filter by
	 * @return a list of {@link OcrLanguage} enums that match the provided codes
	 */
	public static List<OcrLanguage> filterLanguagesByCodes(List<String> codes)
	{
		return codes.stream().map(PdfToTextPanel::getLanguageByCode)
			.filter(language -> language != null).collect(Collectors.toList());
	}

	/**
	 * Finds an {@link OcrLanguage} by its language code.
	 *
	 * @param code
	 *            the Tesseract language code
	 * @return the corresponding {@link OcrLanguage}, or {@code null} if not found
	 */
	private static OcrLanguage getLanguageByCode(String code)
	{
		for (OcrLanguage language : OcrLanguage.values())
		{
			if (language.getCode().equals(code))
			{
				return language;
			}
		}
		return null;
	}

	@Override
	protected void onInitializeLayout()
	{
		super.onInitializeLayout();
		setLayout(new BorderLayout());

		// Main layout
		add(controlPanel, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
		add(logScrollPane, BorderLayout.SOUTH); // Log text area at the bottom
	}

	/**
	 * Returns the selected OCR language code for Tesseract.
	 *
	 * @return the Tesseract language code of the selected language
	 */
	public String getSelectedLanguageCode()
	{
		OcrLanguage selectedLanguage = (OcrLanguage)languageComboBox.getSelectedItem();
		return selectedLanguage != null
			? selectedLanguage.getCode()
			: OcrLanguage.ENGLISH.getCode();
	}


	private class ImportButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			JFileChooser fileChooser = new JFileChooser();
			int option = fileChooser.showOpenDialog(PdfToTextPanel.this);
			if (option == JFileChooser.APPROVE_OPTION)
			{
				File file = fileChooser.getSelectedFile();
				if (file != null)
				{
					appendLog("Selected PDF file: " + file.getName());
					new PdfProcessingWorker(file).execute();
				}
			}
		}
	}

	private class PdfProcessingWorker extends SwingWorker<String, Void>
	{
		private final File pdfFile;

		public PdfProcessingWorker(File pdfFile)
		{
			this.pdfFile = pdfFile;
		}

		@Override
		protected void done()
		{
			progressBar.setIndeterminate(false);
			progressBar.setVisible(false);
			try
			{
				textArea.setText(get());
				appendLog("PDF processed successfully.");
			}
			catch (Exception e)
			{
				appendLog("Error processing PDF: " + e.getMessage());
				JOptionPane.showMessageDialog(PdfToTextPanel.this,
					"Error processing PDF: " + e.getMessage());
			}
		}

		@Override
		protected String doInBackground()
		{
			progressBar.setVisible(true);
			progressBar.setIndeterminate(true);
			appendLog("Starting PDF-to-text conversion...");
			return convertPdfToText(pdfFile);
		}

		@SneakyThrows
		private String convertPdfToText(File pdfFile)
		{
			File userTempDir = SystemFileExtensions.getUserTempDir();
			if (!userTempDir.exists())
			{
				DirectoryFactory.newDirectory(userTempDir);
			}
			File outputDir = DirectoryFactory.newDirectory(userTempDir, "pdf-to-text");
			String selectedLanguageCode = getSelectedLanguageCode();
			ConversionResult conversionResult = PdfToTextExtensions.convertPdfToTextfile(pdfFile,
				outputDir, selectedLanguageCode);
			appendLog("PDF conversion complete.");
			return ReadFileExtensions.fromFile(conversionResult.getResultTextFile());
		}
	}

	private class ExportButtonListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			JFileChooser fileChooser = new JFileChooser();
			int option = fileChooser.showSaveDialog(PdfToTextPanel.this);
			if (option == JFileChooser.APPROVE_OPTION)
			{
				File file = fileChooser.getSelectedFile();
				try (FileWriter writer = new FileWriter(file))
				{
					writer.write(textArea.getText());
					appendLog("Text exported to file: " + file.getName());
					JOptionPane.showMessageDialog(PdfToTextPanel.this,
						"Text exported successfully!");
				}
				catch (IOException ex)
				{
					appendLog("Error exporting text: " + ex.getMessage());
					JOptionPane.showMessageDialog(PdfToTextPanel.this,
						"Error exporting text: " + ex.getMessage());
				}
			}
		}
	}

	// Method to append log messages to the log text area
	private void appendLog(String message)
	{
		logTextArea.append(message + "\n");
		logTextArea.setCaretPosition(logTextArea.getDocument().getLength());
	}
}
