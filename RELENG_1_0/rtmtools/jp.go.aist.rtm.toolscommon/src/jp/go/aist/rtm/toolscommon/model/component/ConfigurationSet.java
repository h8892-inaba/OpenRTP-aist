package jp.go.aist.rtm.toolscommon.model.component;

import jp.go.aist.rtm.toolscommon.model.core.WrapperObject;

import org.eclipse.emf.common.util.EList;

/**
 * ConfigurationSet��\������N���X
 * <p>
 * 
 * @model ���̃I�u�W�F�N�g�́A�o�����[�I�u�W�F�N�g�ł��邱�Ƃɒ��ӂ��邱�ƁB<br>
 *        ���̃I�u�W�F�N�g���͓̂������s���Ȃ����߁A���̃I�u�W�F�N�g�̎Q�Ƃ�ێ��������邱�Ƃ́A�댯�ł���B<br>
 *        �����������A�Q�ƌ��̃I�u�W�F�N�g���Q�Ƃ��āA�K�v�ɂȂ邽�тɂ��������ɓ���邱�ƁB
 */
public interface ConfigurationSet extends WrapperObject{
	/**
	 * @model
	 * @return �R���t�B�O�Z�b�g��ID
	 */
	public String getId();

	/**
	 * Sets the value of the '{@link jp.go.aist.rtm.toolscommon.model.component.ConfigurationSet#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * @model containment="true"
	 *        type="jp.go.aist.rtm.toolscommon.model.component.NameValue"
	 * @return�@�R���t�B�O�f�[�^���i�[����NameValue�̃��X�g
	 */
	public EList<NameValue> getConfigurationData();

}