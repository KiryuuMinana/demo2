package gpt;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class GPT4Request{

	/** chat url */
	public final static String API_ENDPOINT = "https://api.openai.com/v1/chat/completions";
	/** token：从环境变量 OPENAI_API_KEY 读取，勿把真实密钥写进代码 */
	public final static String API_KEY = System.getenv("OPENAI_API_KEY");

	public static String chat(String message) {
		try {
			//国内访问需要做代理，国外服务器不需要，host填入代理IP，如果本地开vpn，一般就是本机ip地址，port根据vpn的port填写
			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("127.0.0.1", 1080));
			HttpURLConnection conn = (HttpURLConnection) new URL(API_ENDPOINT).openConnection(proxy);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Type", "application/json");
			conn.setRequestProperty("Authorization", "Bearer " + API_KEY);
			conn.setDoOutput(true);

			// 构建请求体
			Map<String, Object> data = new HashMap<>();
			data.put("model", "gpt-4");

			List<Map<String, String>> messages = new ArrayList<>();

			// 添加用户消息
			Map<String, String> userMsg = new HashMap<>();
			userMsg.put("role", "user");
			userMsg.put("content", message);
			messages.add(userMsg);

			data.put("messages", messages);
			//该值越大每次返回的结果越随机，即相似度越小，可选参数，默认值为 1，取值 0-2
			data.put("temperature", 0.7);

			Gson gson = new Gson();
			String requestBody = gson.toJson(data);

			// 发送请求
			conn.getOutputStream().write(requestBody.getBytes(StandardCharsets.UTF_8));
			// 读取响应
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			StringBuilder response = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				response.append(line);
			}
			reader.close();
			String res = response.toString();
			JSONObject jsonObject = JSON.parseObject(res);
			JSONObject mess = (JSONObject)jsonObject.getJSONArray("choices").get(0);
			return mess.getJSONObject("message").getString("content");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) {
		boolean flag = true;
		while (flag) {
			System.out.println("Question(exit结束):\t");
			Scanner scanner = new Scanner(System.in);
			String question = scanner.nextLine();
			if ("exit".equals(question)) {
				flag = false;
			} else {
				// 调用 ChatGPTAPI 工具类生成答案
				String answer = chat(question);
				System.out.println("ChatGPT:" + answer);
			}
		}
	}
}