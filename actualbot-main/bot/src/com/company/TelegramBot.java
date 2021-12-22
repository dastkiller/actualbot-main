package com.company;

import com.company.api.IBotLogic;
import com.company.api.State;
import lombok.SneakyThrows;
import org.telegram.telegrambots.bots.DefaultAbsSender;
import org.telegram.telegrambots.bots.DefaultBotOptions;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.MessageEntity;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Hashtable;
import java.util.Optional;
import java.util.logging.Logger;

public class TelegramBot extends TelegramLongPollingBot {

    public IBotLogic logic;
    public String token;
    public String name;


    public TelegramBot(String name, String token, IBotLogic logic) {
        this.name = name;
        this.token = token;
        this.logic = logic;
    }

    @Override
    public String getBotUsername() {
        return name;
    }

    @Override
    public String getBotToken() {
        return token;
    }


    @SneakyThrows
    public void messageHandler(Message message) {
        if (message.hasText()) {
            String id = message.getChatId().toString();
            Logger log = Logger.getLogger("BotLogic");
            try {
                execute(
                        SendMessage.builder()
                                .text(logic.handleMessage(message.getText(), id))
                                .chatId(id)
                                .build());
            }
            catch (Exception e) {
                log.info("Исключение. Сообщение пользователя: " + message.getText());
                execute(
                        SendMessage.builder()
                                .text("Извините. Что-то пошло не так")
                                .chatId(id)
                                .build());
            }
        }
    }

    @SneakyThrows
    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage()) {
            messageHandler(update.getMessage());
        }
    }
}