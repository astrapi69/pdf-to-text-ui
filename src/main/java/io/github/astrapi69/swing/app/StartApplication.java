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
package io.github.astrapi69.swing.app;

import javax.swing.JOptionPane;

import io.github.astrapi69.awt.screen.ScreenSizeExtensions;
import io.github.astrapi69.swing.dialog.DialogExtensions;
import io.github.astrapisixtynine.easy.logger.LoggingConfiguration;
import io.github.astrapisixtynine.pdf.to.text.tess4j.ImagePdfToTextExtensions;
import lombok.extern.java.Log;

/**
 * The class {@link StartApplication} starts the application
 */
@Log
public class StartApplication
{

	/**
	 * The main method that starts the application
	 *
	 * @param args
	 *            the arguments passed to the application
	 */
	public static void main(final String[] args)
	{
		ApplicationLoggingConfiguration.setDefaultSystemProperties();
		LoggingConfiguration.setup();
		log.info("JUL logs are now routed to SLF4J.");
		boolean tesseractInstalled = ImagePdfToTextExtensions.isTesseractInstalled();
		if (!tesseractInstalled)
		{
			log.info("Tesseract is not installed");
			int option = DialogExtensions.showConfirmDialog(null, "Tesseract not installed",
				"<div align='center' width='300'>Tesseract is not installed</div>"
					+ "<div>You have to install tesseract on your local machine</div>"
					+ "<div>How to install tesseract on your local machine is documented on the official site."
					+ "<br><a href='https://tesseract-ocr.github.io/tessdoc/Installation.html'>https://tesseract-ocr.github.io/tessdoc/Installation.html</a></div>",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE, null);
			if (option == JOptionPane.OK_OPTION)
			{
				System.exit(0);
			}
			if (option == JOptionPane.CANCEL_OPTION)
			{
				System.exit(0);
			}
		}
		else
		{
			PdfToTextApplicationFrame frame = new PdfToTextApplicationFrame();
			while (!frame.isVisible())
			{
				ScreenSizeExtensions.showFrame(frame);
			}
		}
	}

}
