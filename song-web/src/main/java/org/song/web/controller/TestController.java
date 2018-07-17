package org.song.web.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.common.utils.StringUtils;

@Controller
@RequestMapping("/test")
public class TestController {

	public static final String LINE_SEPARATOR = System.getProperty("line.separator");
	
	public static final String JAVA_CONFIG_XMS = "-Xms";
	public static final String JAVA_CONFIG_XMX = "-Xmx";
	public static final String JAVA_CONFIG_XSS = "-Xss";
	public static final String JAVA_CONFIG_MS = "-XX:MetaspaceSize=";
	public static final String JAVA_CONFIG_MMS = "-XX:MaxMetaspaceSize=";

	@ResponseBody
	@RequestMapping("/a")
	public String test(HttpServletRequest request) throws IOException{
		List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
		putInMessage(request, resultList);
		return "";
	}

	private void putInMessage(HttpServletRequest request, List<Map<String, Object>> resultList) throws IOException {
		Map<String, Object> inMap;
		//		ServletInputStream ris = request.getInputStream();
		BufferedReader in=new BufferedReader(new InputStreamReader(request.getInputStream()));
		String line = null;  
		Integer appType = null;
		while ((line = in.readLine()) != null) {
			if(StringUtils.isNotEmpty(line)){
				if(appType == null && line.startsWith("#")){
					appType = Integer.parseInt(line.substring(1));
				} else if(appType != null && line.startsWith("#")){
					inMap = new HashMap<String, Object>();
					inMap.put("appType", appType);
					inMap.put("runningState", 0);
					resultList.add(inMap);
					appType = Integer.parseInt(line.substring(1));
				} else if(appType != null && !line.startsWith("#")){
					Pattern pattern4line = Pattern.compile(""
							+ "([^\\s]+)\\s+"	// user
							+ "(\\d+)\\s+"		// pid
							+ "([\\d\\.]+)\\s+"	// cpu
							+ "([\\d\\.]+)\\s+"	// mem
							+ "(\\d+)\\s+"		// vsz
							+ "(\\d+)\\s+"		// rss
							+ "([^\\s]+)\\s+"	// tty
							+ "([\\w]+)\\s+"	// stat
							+ "([^\\s]+)\\s+"	// start
							+ "([^\\s]+)\\s+"	// time
							+ "(.+)");			// cmd
					Matcher m = pattern4line.matcher(line);
					if (!m.find()) {
						//TODO匹配失败
						continue;
					}
//					String user = m.group(1);
//					Integer pid = Integer.parseInt(m.group(2));
//					Float cpu = Float.parseFloat(m.group(3));
//					Float mem = Float.parseFloat(m.group(4));
					Long vsz = Long.parseLong(m.group(5));
					Long rss = Long.parseLong(m.group(6));
//					String tty = m.group(7);
//					String stat = m.group(8);
//					String start = m.group(9);
//					String time = m.group(10);
					String cmd = m.group(11);
					
					inMap = new HashMap<String, Object>();
					inMap.put("appType", appType);
					inMap.put("runningState", 1);
					inMap.put("vsz", vsz);
					inMap.put("rss", rss);
					String[] javaConfigs = cmd.split(" ");
					for(String javaConfig : javaConfigs){
						putJavaConfig(javaConfig, inMap);
					}
					resultList.add(inMap);
					appType = null;
				}
			} else {
				break;
			}  
		} 
	}

	private void putJavaConfig(String javaConfig, Map<String, Object> inMap) {
		if(javaConfig.startsWith(JAVA_CONFIG_XMS)){
			javaConfig = javaConfig.replaceAll(JAVA_CONFIG_XMS, "");
			inMap.put("Xms", javaConfig);
		} else if(javaConfig.startsWith(JAVA_CONFIG_XMX)){
			javaConfig = javaConfig.replaceAll(JAVA_CONFIG_XMX, "");
			inMap.put("Xmx", javaConfig);
		} else if(javaConfig.startsWith(JAVA_CONFIG_XSS)){
			javaConfig = javaConfig.replaceAll(JAVA_CONFIG_XSS, "");
			inMap.put("Xss", javaConfig);
		} else if(javaConfig.startsWith(JAVA_CONFIG_MS)){
			javaConfig = javaConfig.replaceAll(JAVA_CONFIG_MS, "");
			inMap.put("ms", javaConfig);
		} else if(javaConfig.startsWith(JAVA_CONFIG_MMS)){
			javaConfig = javaConfig.replaceAll(JAVA_CONFIG_MMS, "");
			inMap.put("mms", javaConfig);
		}
	}

}
