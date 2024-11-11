package io.github.astrapi69.swing.app.pdf.to.text;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.*;

import io.github.astrapi69.file.create.DirectoryFactory;
import io.github.astrapi69.file.read.ReadFileExtensions;
import io.github.astrapi69.file.system.SystemFileExtensions;
import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.api.IModel;
import io.github.astrapi69.swing.app.ApplicationModelBean;
import io.github.astrapi69.swing.base.BasePanel;
import io.github.astrapisixtynine.pdf.to.text.info.ConversionResult;
import io.github.astrapisixtynine.pdf.to.text.pdfbox.PdfToTextExtensions;
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

	/**
	 * Constructor with a specified model
	 *
	 * @param model
	 *            the model to be used by this panel
	 */
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

		// Create a TextArea for displaying the text
		textArea = new JTextArea(20, 50);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		scrollPane = new JScrollPane(textArea);

		// Create Import and Export buttons
		importButton = new JButton("Import PDF");
		importButton.addActionListener(new ImportButtonListener());

		exportButton = new JButton("Export to File");
		exportButton.addActionListener(new ExportButtonListener());

		// Create Progress Bar
		progressBar = new JProgressBar();
		// progressBar.setStringPainted(true); // Show progress percentage
		progressBar.setVisible(false); // Initially hidden
		progressBar.setIndeterminate(true);

		// Add buttons and progress bar to a panel
		controlPanel = new JPanel();
		controlPanel.add(importButton);
		controlPanel.add(exportButton);
		controlPanel.add(progressBar);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onInitializeLayout()
	{
		super.onInitializeLayout();
		setLayout(new BorderLayout());
		// Add components to the main panel
		add(controlPanel, BorderLayout.NORTH);
		add(scrollPane, BorderLayout.CENTER);
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
					// Start PDF processing with a progress bar
					new PdfProcessingWorker(file).execute();
				}
			}
		}
	}


	private class PdfProcessingWorker extends SwingWorker<String, Void>
	{
		private File pdfFile;

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
			}
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(PdfToTextPanel.this,
					"Error processing PDF: " + e.getMessage());
			}
		}

		@Override
		protected String doInBackground()
		{
			progressBar.setVisible(true);
			progressBar.setIndeterminate(true); // Show indeterminate progress while processing
			// Call your PDF-to-text conversion method here
			return convertPdfToText(pdfFile); // Replace with actual conversion logic
		}

		// Dummy PDF-to-text conversion method
		@SneakyThrows
		private String convertPdfToText(File pdfFile)
		{
			// Implement your PDF-to-text conversion logic here
			File outputDir = DirectoryFactory.newDirectory(SystemFileExtensions.getTempDir(),
				"pdf-to-text");

			ConversionResult conversionResult = PdfToTextExtensions.convertPdfToTextfile(pdfFile,
				outputDir);
			String string = ReadFileExtensions.fromFile(conversionResult.getResultTextFile());
			return string; // Placeholder text
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
					JOptionPane.showMessageDialog(PdfToTextPanel.this,
						"Text exported successfully!");
				}
				catch (IOException ex)
				{
					JOptionPane.showMessageDialog(PdfToTextPanel.this,
						"Error exporting text: " + ex.getMessage());
				}
			}
		}
	}

}
