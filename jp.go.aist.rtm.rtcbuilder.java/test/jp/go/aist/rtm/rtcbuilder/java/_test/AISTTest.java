package jp.go.aist.rtm.rtcbuilder.java._test;

import java.util.ArrayList;
import java.util.List;

import jp.go.aist.rtm.rtcbuilder.Generator;
import jp.go.aist.rtm.rtcbuilder.generator.GeneratedResult;
import jp.go.aist.rtm.rtcbuilder.generator.param.ConfigSetParam;
import jp.go.aist.rtm.rtcbuilder.generator.param.DataPortParam;
import jp.go.aist.rtm.rtcbuilder.generator.param.GeneratorParam;
import jp.go.aist.rtm.rtcbuilder.generator.param.RtcParam;
import jp.go.aist.rtm.rtcbuilder.generator.param.ServicePortInterfaceParam;
import jp.go.aist.rtm.rtcbuilder.generator.param.ServicePortParam;
import jp.go.aist.rtm.rtcbuilder.java.IRtcBuilderConstantsJava;
import jp.go.aist.rtm.rtcbuilder.java.manager.JavaGenerateManager;
import jp.go.aist.rtm.rtcbuilder.manager.GenerateManager;

public class AISTTest extends TestBase {
	private GeneratorParam genParam;
	private RtcParam rtcParam;

	protected void setUp() throws Exception {
		genParam = new GeneratorParam();
		rtcParam = new RtcParam(genParam, true);
		rtcParam.setOutputProject(rootPath + "\\resource\\work");
		rtcParam.setLanguage(IRtcBuilderConstantsJava.LANG_JAVA);
		rtcParam.setLanguageArg(IRtcBuilderConstantsJava.LANG_JAVA_ARG);
		rtcParam.setRtmVersion("0.4.2");
	}

	public void testAIST6() throws Exception{
		rtcParam.setName("ModuleName");
		rtcParam.setDescription("ModuleDescription");
		rtcParam.setVersion("1.0.0");
		rtcParam.setVender("VenderName");
		rtcParam.setCategory("Category");
		rtcParam.setComponentType("DataFlowComponent");
		rtcParam.setActivityType("PERIODIC");
		rtcParam.setMaxInstance(1);

		genParam.getRtcParams().add(rtcParam);
		List<ConfigSetParam> configset = new ArrayList<ConfigSetParam>(); 
		configset.add(new ConfigSetParam("int_param0","int","","0"));
		configset.add(new ConfigSetParam("vector_param","Vector","", "1.0,2.0,3.0"));
		rtcParam.getConfigParams().addAll(configset);

		Generator generator = new Generator();
		GenerateManager manager = new JavaGenerateManager();
		generator.addGenerateManager(manager);
		List<GeneratedResult> result = generator.generateTemplateCode(genParam);

		String targetDir = rootPath + "\\resource\\Java\\ConfigSet\\AIST6\\";
		checkCode(result, targetDir, "ModuleNameComp.java");
		checkCode(result, targetDir, "build_ModuleName.xml");
		checkCode(result, targetDir, "ModuleName.java");
		checkCode(result, targetDir, "ModuleNameImpl.java");
		checkCode(result, targetDir, "README.ModuleName");
	}

	public void testAIST5() throws Exception{
		rtcParam.setName("test");
		rtcParam.setDescription("test component");
		rtcParam.setVersion("1.0.0");
		rtcParam.setVender("S.Kurihara");
		rtcParam.setCategory("sample");
		rtcParam.setComponentType("STATIC");
		rtcParam.setActivityType("PERIODIC");
		rtcParam.setMaxInstance(1);

		ServicePortParam service1 = new ServicePortParam("MySVPro0",0);
		List<ServicePortInterfaceParam> srvinterts = new ArrayList<ServicePortInterfaceParam>(); 
		ServicePortInterfaceParam int1 = new ServicePortInterfaceParam(service1, "myservice0", "", "", 
				rootPath + "resource\\Java\\AIST5\\MyService.idl", "MyServiceT", "", 0);
		srvinterts.add(int1);
		service1.getServicePortInterfaces().addAll(srvinterts);
		List<ServicePortParam> srvports = new ArrayList<ServicePortParam>();
		srvports.add(service1);

		ServicePortParam service2 = new ServicePortParam("MySVPro1",0);
		List<ServicePortInterfaceParam> srvinterts2 = new ArrayList<ServicePortInterfaceParam>(); 
		ServicePortInterfaceParam int2 = new ServicePortInterfaceParam(service1, "myservice", "", "", 
				rootPath + "resource\\Java\\AIST5\\MyService.idl", "MyServiceOpen", "", 0);
		srvinterts2.add(int2);
		service2.getServicePortInterfaces().addAll(srvinterts2);
		srvports.add(service2);
		rtcParam.getServicePorts().addAll(srvports);
		genParam.getRtcParams().add(rtcParam);

		Generator generator = new Generator();
		GenerateManager manager = new JavaGenerateManager();
		generator.addGenerateManager(manager);
		List<GeneratedResult> result = generator.generateTemplateCode(genParam);

		String resourceDir = rootPath +  "\\resource\\Java\\AIST5\\";

		checkCode(result, resourceDir, "testComp.java");
		checkCode(result, resourceDir, "build_test.xml");
		checkCode(result, resourceDir, "test.java");
		checkCode(result, resourceDir, "testImpl.java");
		checkCode(result, resourceDir, "MyServiceTSVC_impl.java");
		checkCode(result, resourceDir, "MyServiceOpenSVC_impl.java");
		checkCode(result, resourceDir, "README.test");
	}

	public void testAIST4() throws Exception{
		rtcParam.setName("test");
		rtcParam.setDescription("test component");
		rtcParam.setVersion("1.0.0");
		rtcParam.setVender("S.Kurihara");
		rtcParam.setCategory("sample");
		rtcParam.setComponentType("STATIC");
		rtcParam.setActivityType("PERIODIC");
		rtcParam.setMaxInstance(1);

		ServicePortParam service1 = new ServicePortParam("MySVPro0",0);
		List<ServicePortInterfaceParam> srvinterts = new ArrayList<ServicePortInterfaceParam>(); 
		ServicePortInterfaceParam int1 = new ServicePortInterfaceParam(service1, "myservice0", "", "", 
				rootPath + "resource\\Java\\AIST4\\MyService.idl", "MyService", "", 0);
		srvinterts.add(int1);
		service1.getServicePortInterfaces().addAll(srvinterts);
		List<ServicePortParam> srvports = new ArrayList<ServicePortParam>();
		srvports.add(service1);

		ServicePortParam service2 = new ServicePortParam("MySVPro1",0);
		List<ServicePortInterfaceParam> srvinterts2 = new ArrayList<ServicePortInterfaceParam>(); 
		ServicePortInterfaceParam int2 = new ServicePortInterfaceParam(service1, "myservice", "", "", 
				rootPath + "resource\\Java\\AIST4\\MyService.idl", "MyService", "", 0);
		srvinterts2.add(int2);
		service2.getServicePortInterfaces().addAll(srvinterts2);
		srvports.add(service2);
		rtcParam.getServicePorts().addAll(srvports);
		genParam.getRtcParams().add(rtcParam);

		Generator generator = new Generator();
		GenerateManager manager = new JavaGenerateManager();
		generator.addGenerateManager(manager);
		List<GeneratedResult> result = generator.generateTemplateCode(genParam);

		String resourceDir = rootPath +  "\\resource\\Java\\AIST4\\";

		checkCode(result, resourceDir, "testComp.java");
		checkCode(result, resourceDir, "build_test.xml");
		checkCode(result, resourceDir, "test.java");
		checkCode(result, resourceDir, "testImpl.java");
		checkCode(result, resourceDir, "MyServiceSVC_impl.java");
		checkCode(result, resourceDir, "README.test");
	}

	public void testAIST3() throws Exception{
		rtcParam.setName("test");
		rtcParam.setDescription("test component");
		rtcParam.setVersion("1.0.0");
		rtcParam.setVender("S.Kurihara");
		rtcParam.setCategory("example");
		rtcParam.setComponentType("STATIC");
		rtcParam.setActivityType("PERIODIC");
		rtcParam.setMaxInstance(1);

		List<DataPortParam> dataport = new ArrayList<DataPortParam>(); 
		dataport.add(new DataPortParam("in", "RTC::TimedFloatSeq", "", 0));
		rtcParam.getInports().addAll(dataport);

		List<DataPortParam> dataoutport = new ArrayList<DataPortParam>(); 
		dataoutport.add(new DataPortParam("out", "RTC::TimedFloatSeq", "", 0));
		rtcParam.getOutports().addAll(dataoutport);

		ServicePortParam service1 = new ServicePortParam("MySVPro",0);
		List<ServicePortInterfaceParam> srvinterts = new ArrayList<ServicePortInterfaceParam>(); 
		ServicePortInterfaceParam int1 = new ServicePortInterfaceParam(service1, "myservice0", "", "", 
				rootPath + "resource\\Java\\AIST3\\MyService.idl", "MyService", "", 0);
		srvinterts.add(int1);
		service1.getServicePortInterfaces().addAll(srvinterts);
		List<ServicePortParam> srvports = new ArrayList<ServicePortParam>();
		srvports.add(service1);

		ServicePortParam service2 = new ServicePortParam("MySVCon",0);
		List<ServicePortInterfaceParam> srvinterts2 = new ArrayList<ServicePortInterfaceParam>(); 
		ServicePortInterfaceParam int2 = new ServicePortInterfaceParam(service1, "myservice1", "", "", 
				rootPath + "resource\\Java\\AIST3\\MyService.idl", "MyService", "", 1);
		srvinterts2.add(int2);
		service2.getServicePortInterfaces().addAll(srvinterts2);
		srvports.add(service2);
		rtcParam.getServicePorts().addAll(srvports);
		genParam.getRtcParams().add(rtcParam);

		Generator generator = new Generator();
		GenerateManager manager = new JavaGenerateManager();
		generator.addGenerateManager(manager);
		List<GeneratedResult> result = generator.generateTemplateCode(genParam);

		String resourceDir = rootPath +  "\\resource\\Java\\AIST3\\";

		checkCode(result, resourceDir, "testComp.java");
		checkCode(result, resourceDir, "build_test.xml");
		checkCode(result, resourceDir, "test.java");
		checkCode(result, resourceDir, "testImpl.java");
		checkCode(result, resourceDir, "MyServiceSVC_impl.java");
		checkCode(result, resourceDir, "README.test");
	}
	
	public void testAIST2() throws Exception{
		rtcParam.setName("test");
		rtcParam.setDescription("test component");
		rtcParam.setVersion("1.0.0");
		rtcParam.setVender("S.Kurihara");
		rtcParam.setCategory("example");
		rtcParam.setComponentType("STATIC");
		rtcParam.setActivityType("PERIODIC");
		rtcParam.setMaxInstance(1);

		List<DataPortParam> dataport = new ArrayList<DataPortParam>(); 
		dataport.add(new DataPortParam("in", "RTC::TimedFloatSeq", "", 0));
		rtcParam.getInports().addAll(dataport);

		List<DataPortParam> dataoutport = new ArrayList<DataPortParam>(); 
		dataoutport.add(new DataPortParam("out", "RTC::TimedFloatSeq", "", 0));
		rtcParam.getOutports().addAll(dataoutport);

		ServicePortParam service1 = new ServicePortParam("MySVCon",0);
		List<ServicePortInterfaceParam> srvinterts = new ArrayList<ServicePortInterfaceParam>(); 
		ServicePortInterfaceParam int1 = new ServicePortInterfaceParam(service1, "myservice", "", "", 
				rootPath + "resource\\Java\\AIST2\\MyService.idl", "MyService", "", 1);
		srvinterts.add(int1);
		service1.getServicePortInterfaces().addAll(srvinterts);
		List<ServicePortParam> srvports = new ArrayList<ServicePortParam>();
		srvports.add(service1);
		rtcParam.getServicePorts().addAll(srvports);
		genParam.getRtcParams().add(rtcParam);

		Generator generator = new Generator();
		GenerateManager manager = new JavaGenerateManager();
		generator.addGenerateManager(manager);
		List<GeneratedResult> result = generator.generateTemplateCode(genParam);

		String resourceDir = rootPath +  "\\resource\\Java\\AIST2\\";

		checkCode(result, resourceDir, "testComp.java");
		checkCode(result, resourceDir, "build_test.xml");
		checkCode(result, resourceDir, "test.java");
		checkCode(result, resourceDir, "testImpl.java");
		checkCode(result, resourceDir, "README.test");
	}

	public void testServicePort() throws Exception{
		rtcParam.setName("test");
		rtcParam.setDescription("test component");
		rtcParam.setVersion("1.0.0");
		rtcParam.setVender("S.Kurihara");
		rtcParam.setCategory("exmple");
		rtcParam.setComponentType("STATIC");
		rtcParam.setActivityType("PERIODIC");
		rtcParam.setMaxInstance(1);

		ServicePortParam service1 = new ServicePortParam("MySVPro",0);
		List<ServicePortInterfaceParam> srvinterts = new ArrayList<ServicePortInterfaceParam>(); 
		ServicePortInterfaceParam int1 = new ServicePortInterfaceParam(service1, "myservice", "", "", 
				rootPath + "resource\\Java\\AIST1\\MyService.idl", "MyService", "", 0);
		srvinterts.add(int1);
		service1.getServicePortInterfaces().addAll(srvinterts);
		List<ServicePortParam> srvports = new ArrayList<ServicePortParam>();
		srvports.add(service1);
		rtcParam.getServicePorts().addAll(srvports);
		genParam.getRtcParams().add(rtcParam);

		Generator generator = new Generator();
		GenerateManager manager = new JavaGenerateManager();
		generator.addGenerateManager(manager);
		List<GeneratedResult> result = generator.generateTemplateCode(genParam);

		String resourceDir = rootPath +  "\\resource\\Java\\AIST1\\";

		checkCode(result, resourceDir, "testComp.java");
		checkCode(result, resourceDir, "build_test.xml");
		checkCode(result, resourceDir, "test.java");
		checkCode(result, resourceDir, "testImpl.java");
		checkCode(result, resourceDir, "MyServiceSVC_impl.java");
		checkCode(result, resourceDir, "README.test");
	}
}
