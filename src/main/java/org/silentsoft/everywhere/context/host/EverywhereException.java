package org.silentsoft.everywhere.context.host;

import org.slf4j.Logger;
import org.slf4j.helpers.MessageFormatter;

/**
 * Custom Everywhere Exception. Throws an exception with pre formatted text.
 */
public class EverywhereException extends Exception {

	private static final long serialVersionUID = -4266593093567964736L;

	/**
	 * Throws an exception using the given message. The message should pre
	 * formatted the same way as a {@link Logger} would accept it. That means
	 * the message shall contain the necessary placeholders and the given
	 * parameters shall match to those.
	 * 
	 * @param message
	 *            the error message to be used for the exception
	 * @param parameters
	 *            the parameters for the passed in error message
	 */
	public EverywhereException(String message, Object[] parameters) {
		super(MessageFormatter.arrayFormat(message, parameters).getMessage());
	}
	
	/**
	 * Throws an exception using the given message and cause. The message should pre
	 * formatted the same way as a {@link Logger} would accept it. That means
	 * the message shall contain the necessary placeholders and the given
	 * parameters shall match to those.
	 * 
	 * @param message
	 * 			the error message to be used for the exception
	 * @param parameters
	 * 			the parameters for the passed in error message
	 * @param cause
	 * 			cause
	 */
	public EverywhereException(String message, Object[] parameters, Throwable cause) {
		super(MessageFormatter.arrayFormat(message, parameters).getMessage(), cause);
	}
}