package lucas.api.fala;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.ai.openai.OpenAiAudioTranscriptionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class OpenAiTranscriptionModelIT {

    @Autowired
    OpenAiAudioTranscriptionModel openAiAudioTranscriptionModel;

    @ParameterizedTest
    @CsvSource({
            "recording-1.m4a, 80",
            "recording-2.m4a, 40",
            "recording-3.m4a, 120",
            "recording-4.m4a, 90",
            "recording-5.m4a, 200",
            "recording-6.m4a, 60",
    })
    public void should_containExpectedKeywords_when_audioFolesAreProcessed(String fileName, String expectedKeyword){
        var recording = new ClassPathResource("audio/" + fileName);

        var response = openAiAudioTranscriptionModel.call(recording);

        System.out.println(response);
        assertThat(response).contains(expectedKeyword);
    }

}
