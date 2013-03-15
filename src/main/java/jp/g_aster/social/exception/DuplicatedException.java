package jp.g_aster.social.exception;

public class DuplicatedException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = -5186276944702049861L;

	public DuplicatedException(){
	}

	public DuplicatedException(String paramString){
		super(paramString);
	}

	public DuplicatedException(String paramString, Throwable paramThrowable){
		super(paramString, paramThrowable);
	}

	public DuplicatedException(Throwable paramThrowable){
		super(paramThrowable);
	}


}
