/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package jp.go.aist.rtm.toolscommon.model.component.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jp.go.aist.rtm.toolscommon.model.component.ComponentPackage;
import jp.go.aist.rtm.toolscommon.model.component.ConnectorProfile;
import jp.go.aist.rtm.toolscommon.model.component.NameValue;
import jp.go.aist.rtm.toolscommon.model.component.Port;
import jp.go.aist.rtm.toolscommon.model.component.PortConnector;
import jp.go.aist.rtm.toolscommon.model.component.PortSynchronizer;
import jp.go.aist.rtm.toolscommon.model.component.SystemDiagram;
import jp.go.aist.rtm.toolscommon.model.component.util.PortConnectorFactory;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Port Synchronizer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link jp.go.aist.rtm.toolscommon.model.component.impl.PortSynchronizerImpl#getOriginalPortString <em>Original Port String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PortSynchronizerImpl extends EObjectImpl implements PortSynchronizer {
	/**
	 * The default value of the '{@link #getOriginalPortString() <em>Original Port String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalPortString()
	 * @generated
	 * @ordered
	 */
	protected static final String ORIGINAL_PORT_STRING_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getOriginalPortString() <em>Original Port String</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOriginalPortString()
	 * @generated
	 * @ordered
	 */
	protected String originalPortString = ORIGINAL_PORT_STRING_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PortSynchronizerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return ComponentPackage.Literals.PORT_SYNCHRONIZER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOriginalPortString() {
		return originalPortString;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOriginalPortString(String newOriginalPortString) {
		String oldOriginalPortString = originalPortString;
		originalPortString = newOriginalPortString;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComponentPackage.PORT_SYNCHRONIZER__ORIGINAL_PORT_STRING, oldOriginalPortString, originalPortString));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public void disconnectAll() {
		// �����ł̓I�t���C���̃|�[�g�S�ؒf���s��
		Port port = (Port) eContainer();
		SystemDiagram diagram = (SystemDiagram) port.eContainer().eContainer();
		diagram = diagram.getRootDiagram();
		
		List<ConnectorProfile> profiles = new ArrayList<ConnectorProfile>(port.getConnectorProfiles());
		for (ConnectorProfile profile : profiles) {
			PortConnector connector = PortConnectorFactory.createPortConnectorSpecification();
			connector.setConnectorProfile(profile);
			connector.setSource(port.findPort(diagram, profile.getSourceString()));
			connector.setTarget(port.findPort(diagram, profile.getTargetString()));
			connector.deleteConnectorR();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ComponentPackage.PORT_SYNCHRONIZER__ORIGINAL_PORT_STRING:
				return getOriginalPortString();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ComponentPackage.PORT_SYNCHRONIZER__ORIGINAL_PORT_STRING:
				setOriginalPortString((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case ComponentPackage.PORT_SYNCHRONIZER__ORIGINAL_PORT_STRING:
				setOriginalPortString(ORIGINAL_PORT_STRING_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ComponentPackage.PORT_SYNCHRONIZER__ORIGINAL_PORT_STRING:
				return ORIGINAL_PORT_STRING_EDEFAULT == null ? originalPortString != null : !ORIGINAL_PORT_STRING_EDEFAULT.equals(originalPortString);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (originalPortString: ");
		result.append(originalPortString);
		result.append(')');
		return result.toString();
	}

//	@Override
	public String getDataflowType() {
		return null;
	}

//	@Override
	public String getDataType() {
		return null;
	}

//	@Override
	public String getInterfaceType() {
		return null;
	}

//	@Override
	public String getSubscriptionType() {
		return null;
	}

//	@Override
	public List<NameValue> getProperties() {
		return Collections.emptyList();
	}

//	@Override
	public String getProperty(String name) {
		return null;
	}


} //PortSynchronizerImpl