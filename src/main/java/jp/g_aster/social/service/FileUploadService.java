package jp.g_aster.social.service;

import java.io.File;

import org.apache.commons.fileupload.FileItem;

import facebook4j.User;

/**
 * アップロードに関する処理を実施します。
 * @author hiroshi-abe
 *
 */
public interface FileUploadService {

	/**
	 * アップロードされたファイルを保存し、画像ＤＢへ登録する。
	 *
	 * @param item
	 * @param file
	 * @param user
	 */
	void upload(FileItem item,File file,User user);
}
