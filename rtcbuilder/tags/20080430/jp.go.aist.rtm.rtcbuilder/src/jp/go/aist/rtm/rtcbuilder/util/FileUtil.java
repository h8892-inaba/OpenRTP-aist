package jp.go.aist.rtm.rtcbuilder.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import jp.go.aist.rtm.rtcbuilder.IRtcBuilderConstants;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * ���[�e�B���e�B�N���X
 */
public class FileUtil {

	/**
	 * �_�C�A���O�ɂ���āA�f�B���N�g���̃p�X���擾����
	 * 
	 * @param defaultValue
	 *            �f�t�H���g�l
	 * @return �f�B���N�g���̃p�X
	 */
	public static IPath getDirectoryPathByDialog(IFile defaultFile) {
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
		Shell shell = window.getShell();
		DirectoryDialog dialog = new DirectoryDialog(shell, SWT.OPEN);
		
		if (defaultFile != null) {
			dialog.setFilterPath(defaultFile.getFullPath().toOSString());
		}
		String pathString = dialog.open();
		if (pathString == null) return null;
		
		IPath result = new Path(pathString + File.separator + IRtcBuilderConstants.DEFAULT_RTC_XML);
		
		return result;
	}

	/**
	 * �_�C�A���O�ɂ���āAIDL�t�@�C���̃p�X���擾����
	 * 
	 * @param defaultValue
	 *            �f�t�H���g�l
	 * @return IDL�t�@�C���̃p�X
	 */
	public static IPath getFilePathByDialog(IFile defaultFile, int style) {
		IWorkbench workbench = PlatformUI.getWorkbench();
		IWorkbenchWindow window = workbench.getActiveWorkbenchWindow();
		Shell shell = window.getShell();
		FileDialog dialog = new FileDialog(shell, style);

		if (defaultFile != null) {
			dialog.setFileName(defaultFile.toString());
			dialog.setFilterNames(new String[] { "RTC�r���_�ݒ�t�@�C��" });
			dialog.setFilterExtensions(new String[] { "*.xml" });
		}

		String pathString = dialog.open();

		if (pathString == null) {
			return null;
		}

		IPath result = new Path(pathString);

		return result;
	}

	/**
	 * �t�@�C����ǂݍ��݁A���e��Ԃ�
	 * 
	 * @param path
	 *            �p�X
	 * @return �t�@�C�����e
	 */
	public static String readFile(String path) {
		StringBuffer result = null;
		try {
			FileReader fr = new FileReader(path);
			BufferedReader br = new BufferedReader(fr);

			result = new StringBuffer();
			int count;
			char[] buff = new char[1024];
			while ((count = br.read(buff)) != -1) {
				result.append(buff, 0, count);
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			throw new RuntimeException("�t�@�C����������܂��� path:" + path);
		}

		return result == null ? null : result.toString();
	}
}