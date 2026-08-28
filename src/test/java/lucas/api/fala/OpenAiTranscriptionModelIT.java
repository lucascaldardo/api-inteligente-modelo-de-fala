package lucas.api.fala;

import org.springframework.ai.openai.OpenAiAudioTranscriptionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OpenAiTranscriptionModelIT {

    @Autowired
    OpenAiAudioTranscriptionModel openAiAudioTranscriptionModel;

}
