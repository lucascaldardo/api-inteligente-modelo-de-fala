package lucas.api.fala;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.ai.openai.OpenAiAudioSpeechModel;
import org.springframework.ai.openai.OpenAiAudioTranscriptionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.file.Files;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class OpenAiSpeechModelIT {

    @Autowired
    OpenAiAudioSpeechModel openAiAudioSpeechModel;

    @Test
    public void should_produceAudio_when_textIsProvided() throws IOException {
        var response = openAiAudioSpeechModel.call("O Valor total do serviço ficou 89 reais. Posso confirmar o oagamento?");
        assertThat(response).hasSizeGreaterThan(1024);
        var tempFile = Files.createTempFile("AUDIO", ".mp3");
        Files.write(tempFile, response);
        System.out.println(tempFile.toAbsolutePath());



    }

}
