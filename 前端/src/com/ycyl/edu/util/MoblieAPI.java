package com.ycyl.edu.util;

import com.jasson.im.api.APIClient;

public class MoblieAPI {
//	private long SMSID = 0L;

	// 移动网关配置
//	private String url = "sms.telemedicine.net.cn";
//	private String host = "11.0.0.64";
	private String host = "sms.telemedicine.net.cn";
	private String dbName = "mas";
	private String apiId = "sdslyy";
	private String name = "sdslyy";
	private String pwd = "sdslyy";
	private APIClient handlerMobile = null; // 移动网关

	/**
	 * 
	 * <b>功能：初始化移动网关信息</b><br>
	 * <br>
	 * 
	 * @Author:guokb , Sep 17, 2013 void
	 * 
	 */
	public void MobileInit() {
		if (handlerMobile != null)
			return;
		// 实例化网关接口
		handlerMobile = new APIClient();
		// 连接数据库
		int connectRe = handlerMobile.init(host, name, pwd, apiId, dbName);
		// 判断连接状态
		if (connectRe != APIClient.IMAPI_SUCC) {
			// System.out.println("---------------->" + connectRe);
			handlerMobile.release();
			handlerMobile = null;
		}

	}

	/**
	 * 
	 * <b>功能：发送短信</b><br>
	 * <br>
	 * 
	 * @Author:guokb , Sep 17, 2013
	 * @param mobiles
	 * @param content
	 * @param smsID
	 *            void
	 * 
	 */
	public String sendSM(String[] mobiles, String content) {
		MobileInit();
		int iRet = -1000;
		if (handlerMobile != null) {
			long smsID = 10086;
			// 这里我们smsID自定义，以后若需要回复短信则需要生成唯一的
			iRet = handlerMobile.sendSM(mobiles, content, smsID);
		}
		String result = "";
		switch (iRet) {
		case APIClient.IMAPI_SUCC:
			result = "发送成功";
			break;
		case APIClient.IMAPI_CONN_ERR:
			result = "连接数据库出错";
			break;
		case APIClient.IMAPI_CONN_CLOSE_ERR:
			result = "数据库关闭失败";
			break;
		case APIClient.IMAPI_INS_ERR:
			result = "数据库插入错误";
			break;
		case APIClient.IMAPI_DEL_ERR:
			result = "数据库删除错误";
			break;
		case APIClient.IMAPI_QUERY_ERR:
			result = "数据库查询错误";
			break;
		case APIClient.IMAPI_DATA_ERR:
			result = "参数错误";
			break;
		case APIClient.IMAPI_API_ERR:
			result = "API 编码非法";
			break;
		case APIClient.IMAPI_DATA_TOOLONG:
			result = "参数超长";
			break;
		case APIClient.IMAPI_INIT_ERR:
			result = "没有初始化或初始化失败";
			break;
		default:
			result = "发送失败";
			break;
		}
		return result;
	}

}
