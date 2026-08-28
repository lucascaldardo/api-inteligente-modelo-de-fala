package lucas.api.fala;

import org.junit.jupiter.api.Test;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class TollCallingIT {

    @Autowired
    OpenAiChatModel openAiChatModel;

    static class MathTools{

        @Tool(description = "Soma dois numeros inteiros")
        public int sum(int a, int b){
            System.out.println("🔥 [TOOL CALLED] Executando sum com a=" + a + " e b=" + b);
            return a + b;
        }

        @Tool(description = "Subtrai dois numeros inteiros")
        public int diff(int a, int b){
            System.out.println(" [TOOL CALLED] Executando diff com a=" + a + " e b=" + b);
            return a - b;
        }

    }


    @Test
    void should_excuteSum_when_prompted(){
        var chatClient = ChatClient.builder(openAiChatModel).defaultSystem("Você é um matematico")
                .defaultTools(new MathTools())
                .build();

        var response = chatClient.prompt("Some 10 + 20. Depois subtraia 30 do resultado anterior. Exiba apenas o resultado final sem explicações mas dentro de uma caixa com formada por varios simbolos pra que fica facil de ler")
                .call().content();

        assertThat(response).contains("0");
        System.out.println(response);

    }

}
