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

import java.awt.Component;
import java.awt.Frame;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;

import io.github.astrapi69.lang.ClassExtensions;
import io.github.astrapi69.swing.base.BaseDesktopMenu;
import io.github.astrapi69.swing.dialog.info.InfoDialog;
import io.github.astrapi69.swing.dialog.info.InfoPanel;
import io.github.astrapi69.swing.panel.info.InfoModelBean;
import lombok.NonNull;
import lombok.extern.java.Log;

/**
 * The class {@link ApplicationDesktopMenu}
 */
@Log
public class ApplicationDesktopMenu extends BaseDesktopMenu
{

	/**
	 * Instantiates a new {@link BaseDesktopMenu}
	 *
	 * @param applicationFrame
	 *            the application frame
	 */
	public ApplicationDesktopMenu(@NonNull Component applicationFrame)
	{
		super(applicationFrame);
	}


	@Override
	protected String newLabelTextApplicationName()
	{
		return Messages.getString("InfoJPanel.application.name.value");
	}

	@Override
	protected String newLabelTextCopyright()
	{
		return Messages.getString("InfoJPanel.copyright.value");
	}

	@Override
	protected String newLabelTextLabelApplicationName()
	{
		return Messages.getString("InfoJPanel.application.name.key");
	}

	@Override
	protected String newLabelTextLabelCopyright()
	{
		return Messages.getString("InfoJPanel.copyright.key");
	}

	@Override
	protected String newLabelTextLabelVersion()
	{
		return Messages.getString("InfoJPanel.version.key");
	}

	@Override
	protected String newLabelTextVersion()
	{
		return Messages.getString("InfoJPanel.version.value");
	}

	@Override
	protected String newTextWarning()
	{
		return Messages.getString("InfoJPanel.license.information.value");
	}

	protected InfoDialog onNewInfoDialog(Frame owner, String title)
	{
		return new InfoDialog(owner, title)
		{

			@Override
			protected InfoPanel newInfoPanel()
			{
				final InfoModelBean infoModelBean = InfoModelBean.builder()
					.labelApplicationName(
						Messages.getString("InfoJPanel.application.name.key", "Application name:"))
					.applicationName(
						Messages.getString("InfoJPanel.application.name.value", "pdf-to-text-ui"))
					.labelCopyright(Messages.getString("InfoJPanel.copyright.key", "Copyright(C):"))
					.copyright(
						Messages.getString("InfoJPanel.copyright.value", "2024 Asterios Raptis"))
					.labelVersion(Messages.getString("InfoJPanel.version.key", "Version:"))
					.version(Messages.getString("InfoJPanel.version.value", "1.1.0"))
					.licence(Messages.getString("InfoJPanel.license.information.value",
						"This Software is licensed under the MIT License"))
					.build();
				return new InfoPanel()
				{

					@Override
					protected String newLabelTextApplicationName()
					{
						return infoModelBean.getApplicationName();
					}

					@Override
					protected String newLabelTextCopyright()
					{
						return infoModelBean.getCopyright();
					}

					@Override
					protected String newLabelTextLabelApplicationName()
					{
						return infoModelBean.getLabelApplicationName();
					}

					@Override
					protected String newLabelTextLabelCopyright()
					{
						return infoModelBean.getLabelCopyright();
					}

					@Override
					protected String newLabelTextLabelVersion()
					{
						return infoModelBean.getLabelVersion();
					}

					@Override
					protected String newLabelTextVersion()
					{
						return infoModelBean.getVersion();
					}

					@Override
					protected String newTextWarning()
					{
						return infoModelBean.getLicence();
					}

				};
			}

			@Override
			protected String newLabelTextPlaceholder()
			{
				return "";
			}

		};
	}

	@Override
	protected String onNewLicenseText()
	{
		final StringBuilder license = new StringBuilder();
		try (InputStream is = ClassExtensions.getResourceAsStream("LICENSE.txt"))
		{
			String thisLine;
			final BufferedReader br = new BufferedReader(new InputStreamReader(is));
			while ((thisLine = br.readLine()) != null)
			{
				license.append(thisLine);
				license.append("\n");
			}
		}
		catch (final IOException e)
		{
			log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}

		// Replace placeholders
		String year = Messages.getString("license.year", "2024");
		String owner = Messages.getString("license.owner", "Asterios Raptis");
		String licenseText = license.toString();

		// Replace placeholders using String's replace method
		licenseText = licenseText.replace("${year}", year).replace("${owner}", owner);

		return licenseText;
	}

}
