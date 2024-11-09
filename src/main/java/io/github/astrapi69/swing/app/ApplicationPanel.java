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

import java.awt.BorderLayout;

import javax.swing.JLabel;

import io.github.astrapi69.model.BaseModel;
import io.github.astrapi69.model.api.IModel;
import io.github.astrapi69.swing.base.BasePanel;

/**
 * The class {@code ApplicationPanel} represents a custom panel that extends {@link BasePanel} and
 * is designed to display a label with the title from the {@link ApplicationModelBean}
 */
public class ApplicationPanel extends BasePanel<ApplicationModelBean>
{
	/** The label component that displays the title */
	JLabel lblTemplate;

	/**
	 * Constructor with a specified model
	 *
	 * @param model
	 *            the model to be used by this panel
	 */
	public ApplicationPanel(final IModel<ApplicationModelBean> model)
	{
		super(model);
	}

	/**
	 * Default constructor that initializes the panel with a default model
	 */
	public ApplicationPanel()
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
		lblTemplate = new JLabel(modelObject.getTitle());
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onInitializeLayout()
	{
		super.onInitializeLayout();
		this.setLayout(new BorderLayout());
		this.add(lblTemplate, BorderLayout.CENTER);
	}

}
