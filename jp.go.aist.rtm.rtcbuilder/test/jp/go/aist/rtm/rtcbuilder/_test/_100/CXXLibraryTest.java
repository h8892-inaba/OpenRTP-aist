package jp.go.aist.rtm.rtcbuilder._test._100;

import java.util.ArrayList;
import java.util.List;

import jp.go.aist.rtm.rtcbuilder.Generator;
import jp.go.aist.rtm.rtcbuilder.IRtcBuilderConstants;
import jp.go.aist.rtm.rtcbuilder._test.TestBase;
import jp.go.aist.rtm.rtcbuilder.generator.GeneratedResult;
import jp.go.aist.rtm.rtcbuilder.generator.param.GeneratorParam;
import jp.go.aist.rtm.rtcbuilder.generator.param.RtcParam;

public class CXXLibraryTest extends TestBase {

	protected void setUp() throws Exception {
	}

	public void testLibrary2() throws Exception{
		GeneratorParam genParam = new GeneratorParam();
		RtcParam rtcParam = new RtcParam(genParam, true);
		rtcParam.setOutputProject(rootPath + "\\resource\\work");
		rtcParam.setLanguage(IRtcBuilderConstants.LANG_CPP);
		rtcParam.setLanguageArg(IRtcBuilderConstants.LANG_CPP_ARG);
		rtcParam.setName("foo");
		rtcParam.setDescription("MDesc");
		rtcParam.setVersion("1.0.1");
		rtcParam.setVender("TA");
		rtcParam.setCategory("Manip");
		rtcParam.setComponentType("STATIC2");
		rtcParam.setActivityType("PERIODIC2");
		rtcParam.setMaxInstance(5);
		List<String> libraries = new ArrayList<String>();
		libraries.add("RTC");
		libraries.add("RTC2");
		rtcParam.getLibraryPathes().addAll(libraries);
		genParam.getRtcParams().add(rtcParam);
		rtcParam.setComponentKind("DataFlowComponent");
		rtcParam.setRtmVersion("1.0.0");
		rtcParam.setIsTest(true);
		
		Generator generator = new Generator();
		List<GeneratedResult> result = generator.generateTemplateCode(genParam);

		String resourceDir = rootPath +  "\\resource\\CXX\\library\\library2\\";

		assertEquals(13, result.size());
		checkCode(result, resourceDir, "fooComp.cpp");
		checkCode(result, resourceDir, "Makefile.foo");
		checkCode(result, resourceDir, "foo.h");
		checkCode(result, resourceDir, "foo.cpp");
		try {
			checkCode(result, resourceDir, "README.foo");
			fail();
		} catch(Exception ex) {
		}
	}

	public void testLibrary1() throws Exception{
		GeneratorParam genParam = new GeneratorParam();
		RtcParam rtcParam = new RtcParam(genParam, true);
		rtcParam.setOutputProject(rootPath + "\\resource\\work");
		rtcParam.setLanguage(IRtcBuilderConstants.LANG_CPP);
		rtcParam.setLanguageArg(IRtcBuilderConstants.LANG_CPP_ARG);
		rtcParam.setName("foo");
		rtcParam.setDescription("MDesc");
		rtcParam.setVersion("1.0.1");
		rtcParam.setVender("TA");
		rtcParam.setCategory("Manip");
		rtcParam.setComponentType("STATIC2");
		rtcParam.setActivityType("PERIODIC2");
		rtcParam.setMaxInstance(5);
		List<String> libraries = new ArrayList<String>();
		libraries.add("RTC");
		rtcParam.getLibraryPathes().addAll(libraries);
		genParam.getRtcParams().add(rtcParam);
		rtcParam.setComponentKind("DataFlowComponent");
		rtcParam.setRtmVersion("1.0.0");
		rtcParam.setIsTest(true);
		
		Generator generator = new Generator();
		List<GeneratedResult> result = generator.generateTemplateCode(genParam);

		String resourceDir = rootPath +  "\\resource\\CXX\\library\\library1\\";

		assertEquals(13, result.size());
		checkCode(result, resourceDir, "fooComp.cpp");
		checkCode(result, resourceDir, "Makefile.foo");
		checkCode(result, resourceDir, "foo.h");
		checkCode(result, resourceDir, "foo.cpp");
		try {
			checkCode(result, resourceDir, "README.foo");
			fail();
		} catch(Exception ex) {
		}
	}
}