package br.com.fiap.navi;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class NaviService {

    private final ChatClient chatClient;

    public NaviService(ChatClient.Builder buider) {
        this.chatClient = buider.build();
    }

    public String translate(String text, String style) {
        return chatClient
                .prompt()
                .user(text)
                .system(String.format("""
                    Você é um tradutor de textos.
                    Traduza o texto com o estilo \"%s\".
                    Mantenha a clareza e a simplicidade.
                    """, style))
                .call()
                .content();
    }
}
