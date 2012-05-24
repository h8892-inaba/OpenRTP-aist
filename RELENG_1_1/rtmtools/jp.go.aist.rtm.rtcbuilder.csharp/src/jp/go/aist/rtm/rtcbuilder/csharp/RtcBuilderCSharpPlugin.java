package jp.go.aist.rtm.rtcbuilder.csharp;

import java.util.logging.Logger;

import jp.go.aist.rtm.rtcbuilder.RtcBuilderPlugin;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class RtcBuilderCSharpPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "jp.go.aist.rtm.rtcbuilder.csharp";

	// The shared instance
	private static RtcBuilderCSharpPlugin plugin;
	
	/**
	 * The constructor
	 */
	public RtcBuilderCSharpPlugin() {
		plugin = this;
		getLogger();
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		RtcBuilderPlugin.addLogger(getLogger());
		//
		super.start(context);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		RtcBuilderPlugin.removeLogger(getLogger());
		//
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static RtcBuilderCSharpPlugin getDefault() {
		return plugin;
	}

	static Logger log;

	public static Logger getLogger() {
		if (log == null) {
			log = Logger.getLogger(PLUGIN_ID);
		}
		return log;
	}

}