/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package chat.rest.api;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.Test;

import com.google.gson.Gson;

import chat.rest.api.ChatBot.API;
import chat.rest.api.service.core.ChatBotService;
import chat.rest.api.service.core.VelocitySupport;

public class AppTest {
	/**
	 * chat gpt 모델 응답 테스트
	 * 
	 * @throws Exception
	 */
	@Test
	public void testChatGpt3() throws Exception {
		ChatBotService newBotService = ChatBot.newBotService(API.GTP_3_5);

		// chatgpt template binding
		String message = VelocitySupport.toString(new File("scripts/chat_gpt/midjourney/chat_script"),
				Map.of("script", "긴 생머리의 20세 여자. 서울 동대문 시장에서 매운 떡볶이를 먹고 매워하는 모습", "language", "English"));

		System.out.println("#################");
		System.out.println(message);
		System.out.println("#################");
		String send = newBotService.send(message);
		System.out.println("#################");
		System.out.println(send);
		System.out.println("#################");
		Gson gson = new Gson();
		HashMap fromJson = gson.fromJson(send, HashMap.class);
		System.out.println(((Map) ((Map) ((List) fromJson.get("choices")).get(0)).get("message")).get("content"));
	}
	
	@Test
	public void testChatGpt4o() throws Exception {
		ChatBotService newBotService = ChatBot.newBotService(API.GTP_4_o);

		// chatgpt template binding
		String message = VelocitySupport.toString(new File("scripts/chat_gpt/midjourney/chat_script"),
				Map.of("script", "긴 생머리의 20세 여자. 서울 동대문 시장에서 매운 떡볶이를 먹고 매워하는 모습", "language", "English"));

		System.out.println("#################");
		System.out.println(message);
		System.out.println("#################");
		String send = newBotService.send(message);
		System.out.println("#################");
		System.out.println(send);
		System.out.println("#################");
		Gson gson = new Gson();
		HashMap fromJson = gson.fromJson(send, HashMap.class);
		System.out.println(((Map) ((Map) ((List) fromJson.get("choices")).get(0)).get("message")).get("content"));
	}

	/**
	 * ollama3 데이터 응답 테스트
	 * 
	 * @throws Exception
	 */
	@Test
	public void testOllama3() throws Exception {
		ChatBotService newBotService = ChatBot.newBotService(API.OLLAMA_3);

		// chatgpt template binding
		String message = VelocitySupport.toString(new File("scripts/chat_gpt/midjourney/chat_script"),
				Map.of("script", "일본소녀가 서울 야경 도시에서 매운 떡볶이를 먹는 모습", "language", "Korean"));

		System.out.println("#################");
		System.out.println(message);
		System.out.println("#################");
		String send = newBotService.send(message);
		System.out.println("########\tResult\t#########");
		System.out.println(send);
		System.out.println("#################");

	}

	/**
	 * ollama 모델 동시 연결 테스트
	 */
	@Test
	public void ollama3_병렬테스트() {
		Stream.iterate(0, a -> a + 1).limit(50).parallel().forEach(idx -> {
			System.out.printf("%d send test \n", idx);
			try {
				testOllama3();
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
	
	/**
	 * ollama 모델 동시 연결 테스트
	 * @throws Exception 
	 */
	@Test
	public void java_code_generate_test() throws Exception {
		ChatBotService newBotService = ChatBot.newBotService(API.GTP_3_5);

		// chatgpt template binding
		String message = VelocitySupport.toString(new File("scripts/chat_gpt/code_gen/java_code_generate"),
				Map.of("code", "현재 시간을 기준으로 일주일 뒤의 시간을 출력 ", "language", "Korean"));

		System.out.println("#################");
		System.out.println(message);
		System.out.println("#################");
		String send = newBotService.send(message);
		System.out.println("########\tResult\t#########");
//		System.out.println(send);
		System.out.println("#################");
		
		Gson gson = new Gson();
//		HashMap fromJson = gson.fromJson(send, HashMap.class);
//		System.out.println(((Map) ((Map) ((List) fromJson.get("choices")).get(0)).get("message")).get("content"));
		ResponseModelDVO fromJson = gson.fromJson(send, ResponseModelDVO.class);
		fromJson.getChoices().forEach(d ->{
			System.out.println(d.getMessage().getContent());
		});
	}
	
	
	
	
	@Test
	public void java_code_generate_image_test() throws Exception {
		ChatBotService newBotService = ChatBot.newBotService(API.OLLAMA_3);

		// chatgpt template binding
		String message = "You are an artist who draws pictures.\r\n"
				+ "\r\n"
				+ "Draw a dog realistically.\r\n"
				+ "\r\n"
				+ "The result is in base64 format.\r\n"
				+ "\r\n"
				+ "Additionally, please generate Java code that can save the base64 format result as an image file.";

		System.out.println("#################");
		System.out.println(message);
		System.out.println("#################");
		String send = newBotService.send(message);
		System.out.println("########\tResult\t#########");
		System.out.println(send);
		System.out.println("#################");
		
//		Gson gson = new Gson();
//		HashMap fromJson = gson.fromJson(send, HashMap.class);
//		System.out.println(((Map) ((Map) ((List) fromJson.get("choices")).get(0)).get("message")).get("content"));
//		ResponseModelDVO fromJson = gson.fromJson(send, ResponseModelDVO.class);
//		fromJson.getChoices().forEach(d ->{
//			System.out.println(d.getMessage().getContent());
//		});
	}
	
	
	@Test
	public void testReka() throws Exception {
		ChatBotService newBotService = ChatBot.newBotService(API.REKA);

		// chatgpt template binding
		String message = VelocitySupport.toString(new File("scripts/chat_gpt/midjourney/chat_script"),
				Map.of("script", "일본소녀가 서울 야경 도시에서 매운 떡볶이를 먹는 모습", "language", "English"));

		System.out.println("#################");
		System.out.println(message);
		System.out.println("#################");
		String send = newBotService.send(message);
		System.out.println("#################");
		System.out.println(send);
		System.out.println("#################");
	}
}
