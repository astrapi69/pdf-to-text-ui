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

import java.util.ResourceBundle;

import io.github.astrapi69.resourcebundle.locale.ResourceBundleExtensions;

/**
 * The class {@link Messages} holds extension methods for accessing string resources from the
 * application's {@link ResourceBundle} object
 */
public final class Messages
{
	/**
	 * Private constructor to prevent instantiation
	 */
	private Messages()
	{
	}

	/** The name of the resource bundle file */
	private static final String BUNDLE_NAME = "ui.messages"; //$NON-NLS-1$

	/** The {@link ResourceBundle} instance for the application */
	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

	/**
	 * Gets the string from the application's {@link ResourceBundle} object
	 *
	 * @param key
	 *            the key for the desired string
	 * @return the {@link String} value corresponding to the given key
	 */
	public static String getString(final String key)
	{
		return ResourceBundleExtensions.getStringQuietly(RESOURCE_BUNDLE, key);
	}

	/**
	 * Gets the string from the application's {@link ResourceBundle} object
	 *
	 * @param key
	 *            the key for the desired string
	 * @param defaultValue
	 *            the default value to return if the key is not found
	 * @return the {@link String} value corresponding to the given key or the given default value if
	 *         the key is not found
	 */
	public static String getString(final String key, final String defaultValue)
	{
		return ResourceBundleExtensions.getStringQuietly(RESOURCE_BUNDLE, key, defaultValue);
	}
}
