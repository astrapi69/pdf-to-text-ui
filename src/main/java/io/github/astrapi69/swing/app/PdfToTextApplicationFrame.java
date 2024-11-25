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
import java.nio.file.Paths;

import javax.swing.JMenu;

import org.pf4j.CompoundPluginRepository;
import org.pf4j.DefaultExtensionFinder;
import org.pf4j.DefaultPluginRepository;
import org.pf4j.ExtensionFinder;
import org.pf4j.JarPluginLoader;
import org.pf4j.JarPluginManager;
import org.pf4j.JarPluginRepository;
import org.pf4j.PluginLoader;
import org.pf4j.PluginManager;
import org.pf4j.PluginRepository;

import io.github.astrapi69.awt.screen.ScreenSizeExtensions;
import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.swing.app.pdf.to.text.PdfToTextPanel;
import io.github.astrapi69.swing.base.ApplicationPanelFrame;
import io.github.astrapi69.swing.base.BasePanel;
import io.github.astrapi69.swing.plaf.LookAndFeels;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

/**
 * The class {@link PdfToTextApplicationFrame} represents the main frame of the application that
 * sets up and initializes the application window with specific settings and components
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PdfToTextApplicationFrame extends ApplicationPanelFrame<ApplicationModelBean>
{

	/**
	 * The single instance of {@link PdfToTextApplicationFrame}
	 */
	@Getter
	private static PdfToTextApplicationFrame instance;

	/** The main application panel */
	BasePanel<ApplicationModelBean> applicationPanel;

	/** The plugin manager */
	PluginManager pluginManager;

	/**
	 * Constructs a new {@link PdfToTextApplicationFrame} with the specified title from the resource
	 * bundle
	 */
	public PdfToTextApplicationFrame()
	{
		super(Messages.getString("mainframe.title"));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onBeforeInitialize()
	{
		if (instance == null)
		{
			instance = this;
		}
		pluginManager = newPluginManager();
		// initialize model and model object
		ApplicationModelBean applicationModelBean = ApplicationModelBean.builder()
			.title(Messages.getString("mainframe.title")).build();
		setModel(BaseModel.of(applicationModelBean));
		super.onBeforeInitialize();
	}

	/**
	 * Factory method for create a new {@link PluginManager} object
	 *
	 * @return the new created {@link PluginManager} object for this application
	 */
	protected PluginManager newPluginManager()
	{
		return new JarPluginManager(Paths.get("plugins"))
		{
			/**
			 * {@inheritDoc}
			 */
			protected ExtensionFinder createExtensionFinder()
			{
				DefaultExtensionFinder extensionFinder = (DefaultExtensionFinder)super.createExtensionFinder();
				extensionFinder.addServiceProviderExtensionFinder();
				return extensionFinder;
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			protected PluginRepository createPluginRepository()
			{
				return new CompoundPluginRepository()
					.add(new DefaultPluginRepository(getPluginsRoot()))
					.add(new JarPluginRepository(getPluginsRoot()));
			}

			/**
			 * {@inheritDoc}
			 */
			@Override
			protected PluginLoader createPluginLoader()
			{
				return new JarPluginLoader(this);
			}

		};
	}

	/**
	 * Starts and loads all plugins of the application
	 */
	protected void startAndLoadAllPlugins()
	{
		pluginManager.loadPlugins();
		pluginManager.startPlugins();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onAfterInitialize()
	{
		super.onAfterInitialize();
		startAndLoadAllPlugins();
		setTitle(Messages.getString("mainframe.title"));
		setDefaultLookAndFeel(LookAndFeels.NIMBUS, this);
		this.setSize(ScreenSizeExtensions.getScreenWidth(), ScreenSizeExtensions.getScreenHeight());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected JMenu newDesktopMenu(@NonNull Component applicationFrame)
	{
		return new ApplicationDesktopMenu(applicationFrame);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected String newIconPath()
	{
		return Messages.getString("global.icon.app.path");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected BasePanel<ApplicationModelBean> newMainComponent()
	{
		applicationPanel = newApplicationPanel();
		return applicationPanel;
	}

	/**
	 * Factory method for create a new {@link BasePanel} object
	 *
	 * @return the new {@link BasePanel} object
	 */
	protected BasePanel<ApplicationModelBean> newApplicationPanel()
	{
		return new PdfToTextPanel(getModel());
	}

}
