package com.importsource.orange.common.excpt;

/**
 * 重复键异常
 * @author Hezf
 *
 */
public class MultipleKeyException extends RuntimeException {
	private static final long serialVersionUID = -5646366482218098141L;

	public MultipleKeyException() {
		super();
	}

	public MultipleKeyException(String message) {
		super(message);
	}

}
