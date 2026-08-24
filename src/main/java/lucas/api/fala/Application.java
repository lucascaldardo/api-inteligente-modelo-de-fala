package lucas.api.fala;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.nio.file.Files;

@SpringBootApplication
public class Application {

	@Bean
	ChatClient chatClient(ChatClient.Builder builder){
		return builder.build();
	}

	public static void main(String[] args) {
		loadEnv();
		SpringApplication.run(Application.class, args);
	}

	private static void loadEnv() {
		try {
			File envFile = new File(".env");
			if (envFile.exists()) {
				for (String line : Files.readAllLines(envFile.toPath())) {
					String trimmed = line.trim();
					if (!trimmed.isEmpty() && !trimmed.startsWith("#") && trimmed.contains("=")) {
						int idx = trimmed.indexOf('=');
						String key = trimmed.substring(0, idx).trim();
						String value = trimmed.substring(idx + 1).trim();
						if (System.getProperty(key) == null && System.getenv(key) == null) {
							System.setProperty(key, value);
						}
					}
				}
			}
		} catch (Exception ignored) {}
	}

}

