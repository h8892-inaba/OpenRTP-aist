// -*- Java -*-
/*!
 * @file foo.java
 * @date $Date$
 *
 * $Id$
 */
import jp.go.aist.rtm.RTC.Manager;
import jp.go.aist.rtm.RTC.RTObject_impl;
import jp.go.aist.rtm.RTC.RtcDeleteFunc;
import jp.go.aist.rtm.RTC.RtcNewFunc;
import jp.go.aist.rtm.RTC.RegisterModuleFunc;
import jp.go.aist.rtm.RTC.util.Properties;
/**
 * foo
 * <p> 
 * MDesc
 */
public class foo implements RtcNewFunc, RtcDeleteFunc, RegisterModuleFunc {
//  Module specification
//  <rtc-template block="module_spec">
    public static String component_conf[] = {
            "implementation_id", "foo",
            "type_name",         "foo",
            "description",       "MDesc",
            "version",           "1.0.3",
            "vendor",            "TA2",
            "category",          "manip2",
            "activity_type",     "STATIC2",
            "max_instance",      "3",
            "language",          "Java",
            "lang_type",         "compile",
            // Configuration variables
            "conf.default.int_param0", "0",
            "conf.default.int_param1", "1",
            "conf.default.double_param0", "0.11",
            "conf.default.str_param0", "hoge",
            "conf.default.str_param1", "dara",
            // Widget
            // Constraints
            "conf.__type__.int_param0", "int",
            "conf.__type__.int_param1", "int",
            "conf.__type__.double_param0", "double",
            "conf.__type__.str_param0", "String",
            "conf.__type__.str_param1", "String",
    	    ""
            };
//  </rtc-template>
    public RTObject_impl createRtc(Manager mgr) {
        return new fooImpl(mgr);
    }
    public void deleteRtc(RTObject_impl rtcBase) {
        rtcBase = null;
    }
    public void registerModule() {
        Properties prop = new Properties(component_conf);
        final Manager manager = Manager.instance();
        manager.registerFactory(prop, new foo(), new foo());
    }
}
