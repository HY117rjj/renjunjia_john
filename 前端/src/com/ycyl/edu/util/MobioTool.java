package com.ycyl.edu.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.jasson.im.api.APIClient;

public class MobioTool {
	private String mobileStr;
	private String content;
	private long smId = 1;
	private String host = "11.0.0.64";
	private String dbName = "mas";
	private String apiId = "sdslyy";
	private String name = "sdslyy";
	private String pwd = "sdslyy";
	private APIClient handler = new APIClient();
	BufferedReader in = null;

	public MobioTool(String haoma, String neirong) {
		init();
		this.mobileStr = haoma;
		this.content = neirong;
	}

	public void sendSM() {
		String tmpContent = null;
		String tmpSrcID = null;
		tmpContent = content;
		tmpSrcID = "" + smId;
		String[] mobiles = { mobileStr };
		int result = 0;
		result = handler.sendSM(mobiles, tmpContent, smId,
				Long.parseLong(tmpSrcID));
		if (result == APIClient.IMAPI_SUCC) {
			info("发送成功\n");
		} else if (result == APIClient.IMAPI_INIT_ERR)
			info("未初始化");
		else if (result == APIClient.IMAPI_CONN_ERR)
			info("数据库连接失败");
		else if (result == APIClient.IMAPI_DATA_ERR)
			info("参数错误");
		else if (result == APIClient.IMAPI_DATA_TOOLONG)
			info("消息内容太长");
		else if (result == APIClient.IMAPI_INS_ERR)
			info("数据库插入错误");
		else
			info("出现其他错误");
	}

	public MobioTool(String[] args) {
		super();
		parseCmd(args);
		init();
		in = new BufferedReader(new InputStreamReader(System.in), 512);
	}

	public void parseCmd(String[] args) {
		String tmp = "";
		int index = 0;
		int len = args.length;
		if (args.length > 0) {
			info("parse argements....");
			while (index < len) {
				tmp = args[index++].trim();
				if (tmp.equalsIgnoreCase("-h")) {
					host = args[index++];
					info(" host  = " + host);
				} else if (tmp.equalsIgnoreCase("-n")) {
					name = args[index++];
					info(" name  = " + name);
				} else if (tmp.equalsIgnoreCase("-p")) {
					pwd = args[index++];
					info(" pwd   = " + pwd);
				} else if (tmp.equalsIgnoreCase("-i")) {
					apiId = args[index++];
					info(" apiId = " + apiId);
				} else {
					index += 2;
					continue;
				}
			}
		}
	}

	public void init() {
		int connectRe = handler.init(host, name, pwd, apiId, dbName);
		if (connectRe == APIClient.IMAPI_SUCC)
			info("初始化成功");
		else if (connectRe == APIClient.IMAPI_CONN_ERR)
			info("连接失败");
		else if (connectRe == APIClient.IMAPI_API_ERR)
			info("apiID不存在");
		if (connectRe != APIClient.IMAPI_SUCC) {
			usage();
			System.exit(-1);
		}
	}

	public void info(Object obj) {
		// System.out.println(obj);
	}

	public void usage() {
		info("Usage : java ApiTestDemo [-h host] [-n name] [-p password] [-i apiCode]");
		info("\t-h host        信息机地址");
		info("\t-n name       API登陆名");
		info("\t-p password    API登陆密码");
		info("\t-i apiCode     API编码");

	}

	public static void main(String[] args) {
		// MobioTool demo = new MobioTool("13608943249", "我的测试");
		// demo.sendSM();
		MoblieAPI ma = new MoblieAPI();
		ma.MobileInit();
		System.out.println("333");
		String rs = ma.sendSM(new String[] { "13608943249" }, "aaaa");
		System.out.println("444  " + rs);
	}
}
