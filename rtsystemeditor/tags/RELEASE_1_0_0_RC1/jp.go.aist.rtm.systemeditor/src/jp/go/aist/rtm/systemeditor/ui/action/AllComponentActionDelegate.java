package jp.go.aist.rtm.systemeditor.ui.action;

import java.lang.reflect.InvocationTargetException;

import jp.go.aist.rtm.systemeditor.nl.Messages;
import jp.go.aist.rtm.systemeditor.ui.editor.SystemDiagramEditor;
import jp.go.aist.rtm.toolscommon.model.component.CorbaComponent;
import jp.go.aist.rtm.toolscommon.model.component.SystemDiagram;
import jp.go.aist.rtm.toolscommon.model.core.ModelElement;
import jp.go.aist.rtm.toolscommon.model.core.Visiter;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.ui.IEditorActionDelegate;
import org.eclipse.ui.IEditorPart;

/**
 * AllStart,AllStop�����s����A�N�V����
 */
public class AllComponentActionDelegate implements IEditorActionDelegate {

	/**
	 * AllStart�Ɏg�p�����ID�B���̒l���APlugin.XML�Ɏw�肳��Ȃ���΂Ȃ�Ȃ��B
	 */
	public static final String ALL_START_ACTION_ID = AllComponentActionDelegate.class
			.getName()
			+ ".AllStart"; //$NON-NLS-1$

	/**
	 * AllStop�Ɏg�p�����ID�B���̒l���APlugin.XML�Ɏw�肳��Ȃ���΂Ȃ�Ȃ��B
	 */
	public static final String ALL_STOP_ACTION_ID = AllComponentActionDelegate.class
			.getName()
			+ ".AllStop"; //$NON-NLS-1$

	/**
	 * AllActivate�Ɏg�p�����ID�B���̒l���APlugin.XML�Ɏw�肳��Ȃ���΂Ȃ�Ȃ��B
	 */
	public static final String ALL_ACTIVATE_ACTION_ID = AllComponentActionDelegate.class
			.getName()
			+ ".AllActivate"; //$NON-NLS-1$

	/**
	 * AllDeactivate�Ɏg�p�����ID�B���̒l���APlugin.XML�Ɏw�肳��Ȃ���΂Ȃ�Ȃ��B
	 */
	public static final String ALL_DEACTIVATE_ACTION_ID = AllComponentActionDelegate.class
			.getName()
			+ ".AllDeactivate"; //$NON-NLS-1$

	private SystemDiagramEditor targetEditor;

	/**
	 * �A�N�V�����̃��C���̎��s���\�b�h
	 * <p>
	 * ���s�ۂ̊m�F�����߁A���s���s���B
	 */
	public void run(final IAction action) {
		final SystemDiagram systemDiagram = targetEditor.getSystemDiagram();

		String comfirmMessage = Messages.getString("AllComponentActionDelegate.4"); //$NON-NLS-1$
		if (ALL_START_ACTION_ID.equals(action.getId())) {
			comfirmMessage = Messages.getString("AllComponentActionDelegate.5"); //$NON-NLS-1$
		} else if (ALL_STOP_ACTION_ID.equals(action.getId())) {
			comfirmMessage = Messages.getString("AllComponentActionDelegate.6"); //$NON-NLS-1$
		} else if (ALL_ACTIVATE_ACTION_ID.equals(action.getId())) {
			comfirmMessage = Messages.getString("AllComponentActionDelegate.7"); //$NON-NLS-1$
		} else if (ALL_DEACTIVATE_ACTION_ID.equals(action.getId())) {
			comfirmMessage = Messages.getString("AllComponentActionDelegate.8"); //$NON-NLS-1$
		}

		boolean isOk = MessageDialog.openConfirm(targetEditor.getSite()
				.getShell(), Messages.getString("AllComponentActionDelegate.9"), comfirmMessage); //$NON-NLS-1$
		if (isOk) {

			ProgressMonitorDialog dialog = new ProgressMonitorDialog(
					targetEditor.getSite().getShell());
			IRunnableWithProgress runable = new IRunnableWithProgress() {
				public void run(IProgressMonitor monitor)
						throws InvocationTargetException, InterruptedException {

					monitor.beginTask(Messages.getString("AllComponentActionDelegate.10"), 100); //$NON-NLS-1$

					monitor.subTask(Messages.getString("AllComponentActionDelegate.11")); //$NON-NLS-1$

					try {
						if (ALL_START_ACTION_ID.equals(action.getId())) {
							doAllStart(systemDiagram);
						} else if (ALL_STOP_ACTION_ID.equals(action.getId())) {
							doAllStop(systemDiagram);
						} else if (ALL_ACTIVATE_ACTION_ID
								.equals(action.getId())) {
							doAllActivate(systemDiagram);
						} else if (ALL_DEACTIVATE_ACTION_ID.equals(action
								.getId())) {
							doAllDectivate(systemDiagram);
						}
					} catch (Exception e) {
						throw new InvocationTargetException(e);
					}

					monitor.subTask(Messages.getString("AllComponentActionDelegate.12")); //$NON-NLS-1$
					monitor.done();
				}

			};

			try {
				dialog.run(false, false, runable);
			} catch (InvocationTargetException e) {
				MessageDialog.openError(targetEditor.getSite().getShell(),
						Messages.getString("AllComponentActionDelegate.13"), Messages.getString("AllComponentActionDelegate.14") + e.getMessage()); //$NON-NLS-1$ //$NON-NLS-2$
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	private void doAllStop(SystemDiagram systemDiagram) {
		systemDiagram.accept(new Visiter() {
			@SuppressWarnings("unchecked")
			public void visit(ModelElement element) {
				if (element instanceof CorbaComponent) {
					((CorbaComponent) element).stopAll();
				}
			}
		});
	}

	private void doAllStart(SystemDiagram systemDiagram) {
		systemDiagram.accept(new Visiter() {
			@SuppressWarnings("unchecked")
			public void visit(ModelElement element) {
				if (element instanceof CorbaComponent) {
					((CorbaComponent) element).startAll();
				}
			}
		});
	}

	private void doAllActivate(SystemDiagram systemDiagram) {
		systemDiagram.accept(new Visiter() {
			@SuppressWarnings("unchecked")
			public void visit(ModelElement element) {
				if (element instanceof CorbaComponent) {
					((CorbaComponent) element).activateAll();
				}
			}
		});
	}

	private void doAllDectivate(SystemDiagram systemDiagram) {
		systemDiagram.accept(new Visiter() {
			@SuppressWarnings("unchecked")
			public void visit(ModelElement element) {
				if (element instanceof CorbaComponent) {
					((CorbaComponent) element).deactivateAll();
				}
			}
		});
	}

	public void setActiveEditor(IAction action, IEditorPart targetEditor) {
		this.targetEditor = (SystemDiagramEditor) targetEditor;
	}

	public void selectionChanged(IAction action, ISelection selection) {
	}
}