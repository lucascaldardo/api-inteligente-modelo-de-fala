package lucas.api.fala;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;





public class ChatModelController {

    @Autowired
    OpenAiChatModel openAiChatModel;




    void should_excuteSum_when_prompted(){
        var chatClient = ChatClient.builder(openAiChatModel).defaultSystem("Você é um matematico").build();

        var response = chatClient.prompt("Some 10 + 10. Depois subtraia 30 do resultado anterior. Exiba apenas o resultado final sem explicações mas dentro de uma caixa com formada por varios simbolos pra que fica facil de ler")
                .call().content();


        System.out.println(response);

    }

}
