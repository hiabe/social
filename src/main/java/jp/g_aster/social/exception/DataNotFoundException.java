package jp.g_aster.social.exception;

public class DataNotFoundException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = -5346129521458093430L;

	public DataNotFoundException(){
	}

	public DataNotFoundException(String paramString){
		super(paramString);
	}

	public DataNotFoundException(String paramString, Throwable paramThrowable){
		super(paramString, paramThrowable);
	}

	public DataNotFoundException(Throwable paramThrowable){
		super(paramThrowable);
	}


}
