package com.github.catvod.spider;

import android.content.Context;
import com.github.catvod.crawler.Spider;
import com.github.catvod.crawler.SpiderDebug;
import com.github.catvod.utils.okhttp.OkHttpUtil;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.HashMap;
import java.util.List;

/**
 * @author Libs
 * @date 2023/6/20
 */
public class Zhuiju extends Spider
{
	private static final String API_URL = "http://192.168.10.113:8082/api/public/tvbox";
	public void init(Context context) {
		super.init(context);
	}
	public String homeContent(boolean filter) {
		return OkHttpUtil.string(API_URL+"/homeContent", null);
	}
	public String categoryContent(String tid, String pg, boolean filter, HashMap<String, String> extend) {
		return OkHttpUtil.string(String.format(API_URL+"/categoryContent?tid=%s&pg=%s", tid, pg), null);
	}

	public String detailContent(List<String> ids) {
		return OkHttpUtil.string(String.format(API_URL+"/detailContent?id=%s", ids.get(0)), null);
	}
	public String searchContent(String key, boolean quick) {
		return OkHttpUtil.string(String.format(API_URL+"/searchContent?key=%s", key), null);
	}

	public String playerContent(String flag, String id, List<String> vipFlags) {
		try {
			JSONObject result = new JSONObject();
			result.put("parse", 0);
			result.put("playUrl", "");
			result.put("url", id);
			result.put("header", "");
			return result.toString();
		} catch (Exception e) {
			SpiderDebug.log(e);
		}
		return "";

	}
}
