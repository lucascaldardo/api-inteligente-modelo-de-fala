package lucas.api.fala;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ChatClientController {
    private final ChatClient chatClient;

    public ChatClientController(ChatClient chatClient){
        this.chatClient = chatClient;
    }

    public record ChatRequest(String prompt) {}
    public record ChatResponse(String resposta) {}

    // Requisições GET: /api/chat?prompt=...
    @GetMapping("/chat")
    public ChatResponse chatGet(@RequestParam(value = "prompt", defaultValue = "Olá") String prompt) {
        String resposta = this.chatClient.prompt().user(prompt).call().content();
        return new ChatResponse(resposta);
    }

    // Requisições POST com JSON: {"prompt": "..."}
    @PostMapping("/chat")
    public ChatResponse chatPost(@RequestBody(required = false) ChatRequest request) {
        String prompt = (request != null && request.prompt() != null && !request.prompt().isBlank()) 
                ? request.prompt() 
                : "Olá";
        String resposta = this.chatClient.prompt().user(prompt).call().content();
        return new ChatResponse(resposta);
    }
}

