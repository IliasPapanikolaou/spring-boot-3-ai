package com.ipap.springboot3ai.service;

import com.ipap.springboot3ai.dto.SingersResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.ChatClient;
import org.springframework.ai.chat.ChatResponse;
import org.springframework.ai.chat.Generation;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.openai.api.OpenAiApi;
import org.springframework.ai.parser.BeanOutputParser;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ChatService {

    Logger log = LoggerFactory.getLogger(ChatService.class);

    private final ChatClient chatClient;

    public ChatService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    public String getTopSingers(String country) {
        String promptString = "Top singer details of " + country;

        String response = "";
        try {
            response = chatClient.call(promptString);
        } catch (OpenAiApi.OpenAiApiClientErrorException e) {
            log.error(e.getLocalizedMessage());
        }
        return response;
    }

    public SingersResponse getTopSingersStructured(String country) {

        BeanOutputParser<SingersResponse> parser = new BeanOutputParser<>(SingersResponse.class);

        String promptString = "Top singer details of {country} {format}";

        PromptTemplate template = new PromptTemplate(promptString);
        template.add("country", country);
        template.add("format", parser.getFormat());
        template.setOutputParser(parser);

        Prompt prompt = template.create();

        ChatResponse response = chatClient.call(prompt);
        Generation result = response.getResult();

        return parser.parse(String.valueOf(result));
    }
}
