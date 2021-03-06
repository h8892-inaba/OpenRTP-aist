// -*- Java -*-
/*!
 * @file  fooImpl.java
 * @brief MDesc
 * @date  $Date$
 *
 * $Id$
 */
import jp.go.aist.rtm.RTC.DataFlowComponentBase;
import jp.go.aist.rtm.RTC.Manager;
import jp.go.aist.rtm.RTC.util.ShortHolder;
import jp.go.aist.rtm.RTC.util.IntegerHolder;
import jp.go.aist.rtm.RTC.util.LongHolder;
import jp.go.aist.rtm.RTC.util.FloatHolder;
import jp.go.aist.rtm.RTC.util.DoubleHolder;
import jp.go.aist.rtm.RTC.util.StringHolder;
import RTC.ReturnCode_t;
/**
 * fooImpl
 * <p>
 * MDesc
 *
 */
public class fooImpl extends DataFlowComponentBase {
  /**
   * constructor
   * @param manager Manager Object
   */
    public fooImpl(Manager manager) {  
        super(manager);
        // <rtc-template block="initializer">
        // </rtc-template>
    }
    /*!
     *
     * The initialize action (on CREATED-&gt;ALIVE transition)
     *
     * @return RTC::ReturnCode_t
     * 
     * 
     */
    @Override
    protected ReturnCode_t onInitialize() {
        // Registration: InPort/OutPort/Service
        // <rtc-template block="registration">
        // </rtc-template>
        bindParameter("short_param", m_short_param, "0");
        bindParameter("int_param", m_int_param, "1");
        bindParameter("long_param", m_long_param, "14");
        bindParameter("float_param", m_float_param, "0.11");
        bindParameter("double_param", m_double_param, "4.11");
        bindParameter("str_param0", m_str_param0, "hoge");
        bindParameter("str_param1", m_str_param1, "dara");
        return super.onInitialize();
    }
    /**
     *
     * The finalize action (on ALIVE-&gt;END transition)
     *
     * @return RTC::ReturnCode_t
     * 
     * 
     */
//    @Override
//    protected ReturnCode_t onFinalize() {
//        return super.onFinalize();
//    }
    /**
     *
     * The startup action when ExecutionContext startup
     *
     * @param ec_id target ExecutionContext Id
     *
     * @return RTC::ReturnCode_t
     * 
     * 
     */
//    @Override
//    protected ReturnCode_t onStartup(int ec_id) {
//        return super.onStartup(ec_id);
//    }
    /**
     *
     * The shutdown action when ExecutionContext stop
     *
     * @param ec_id target ExecutionContext Id
     *
     * @return RTC::ReturnCode_t
     * 
     * 
     */
//    @Override
//    protected ReturnCode_t onShutdown(int ec_id) {
//        return super.onShutdown(ec_id);
//    }
    /**
     *
     * The activated action (Active state entry action)
     *
     * @param ec_id target ExecutionContext Id
     *
     * @return RTC::ReturnCode_t
     * 
     * 
     */
//    @Override
//    protected ReturnCode_t onActivated(int ec_id) {
//        return super.onActivated(ec_id);
//    }
    /**
     *
     * The deactivated action (Active state exit action)
     *
     * @param ec_id target ExecutionContext Id
     *
     * @return RTC::ReturnCode_t
     * 
     * 
     */
//    @Override
//    protected ReturnCode_t onDeactivated(int ec_id) {
//        return super.onDeactivated(ec_id);
//    }
    /**
     *
     * The execution action that is invoked periodically
     *
     * @param ec_id target ExecutionContext Id
     *
     * @return RTC::ReturnCode_t
     * 
     * 
     */
//    @Override
//    protected ReturnCode_t onExecute(int ec_id) {
//        return super.onExecute(ec_id);
//    }
    /**
     *
     * The aborting action when main logic error occurred.
     *
     * @param ec_id target ExecutionContext Id
     *
     * @return RTC::ReturnCode_t
     * 
     * 
     */
//  @Override
//  public ReturnCode_t onAborting(int ec_id) {
//      return super.onAborting(ec_id);
//  }
    /**
     *
     * The error action in ERROR state
     *
     * @param ec_id target ExecutionContext Id
     *
     * @return RTC::ReturnCode_t
     * 
     * 
     */
//    @Override
//    public ReturnCode_t onError(int ec_id) {
//        return super.onError(ec_id);
//    }
    /**
     *
     * The reset action that is invoked resetting
     *
     * @param ec_id target ExecutionContext Id
     *
     * @return RTC::ReturnCode_t
     * 
     * 
     */
//    @Override
//    protected ReturnCode_t onReset(int ec_id) {
//        return super.onReset(ec_id);
//    }
    /**
     *
     * The state update action that is invoked after onExecute() action
     *
     * @param ec_id target ExecutionContext Id
     *
     * @return RTC::ReturnCode_t
     * 
     * 
     */
//    @Override
//    protected ReturnCode_t onStateUpdate(int ec_id) {
//        return super.onStateUpdate(ec_id);
//    }
    /**
     *
     * The action that is invoked when execution context's rate is changed
     *
     * @param ec_id target ExecutionContext Id
     *
     * @return RTC::ReturnCode_t
     * 
     * 
     */
//    @Override
//    protected ReturnCode_t onRateChanged(int ec_id) {
//        return super.onRateChanged(ec_id);
//    }
//
    /**
     */
    // Configuration variable declaration
    // <rtc-template block="config_declare">
    /*!
     * 
     * - Name:  short_param
     * - DefaultValue: 0
     */
    protected ShortHolder m_short_param = new ShortHolder();
    /*!
     * 
     * - Name:  int_param
     * - DefaultValue: 1
     */
    protected IntegerHolder m_int_param = new IntegerHolder();
    /*!
     * 
     * - Name:  long_param
     * - DefaultValue: 14
     */
    protected LongHolder m_long_param = new LongHolder();
    /*!
     * 
     * - Name:  float_param
     * - DefaultValue: 0.11
     */
    protected FloatHolder m_float_param = new FloatHolder();
    /*!
     * 
     * - Name:  double_param
     * - DefaultValue: 4.11
     */
    protected DoubleHolder m_double_param = new DoubleHolder();
    /*!
     * 
     * - Name:  str_param0
     * - DefaultValue: hoge
     */
    protected StringHolder m_str_param0 = new StringHolder();
    /*!
     * 
     * - Name:  str_param1
     * - DefaultValue: dara
     */
    protected StringHolder m_str_param1 = new StringHolder();
    // </rtc-template>
    /**
     */
    // DataInPort declaration
    // <rtc-template block="inport_declare">
    
    // </rtc-template>
    // DataOutPort declaration
    // <rtc-template block="outport_declare">
    
    // </rtc-template>
    // CORBA Port declaration
    // <rtc-template block="corbaport_declare">
    
    // </rtc-template>
    // Service declaration
    // <rtc-template block="service_declare">
    
    // </rtc-template>
    // Consumer declaration
    // <rtc-template block="consumer_declare">
    
    // </rtc-template>
}
