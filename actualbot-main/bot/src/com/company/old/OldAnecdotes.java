package com.company.old;

public class OldAnecdotes {
    public static String GetAnecdote(int number) {
        return switch (number) {
            case 1 -> "— Изя, ты помнишь, как у меня болели ноги в сорок первом?\n" +
                    "— Абраша, шо за вопросы! Конечно помню, ну и?\n" +
                    "— Ношу 43-й и не болят.";
            case 2 -> "Учительница диктует задачу:\n" +
                    "— 30 учеников съели 120 яблок, 150 слив и 60 абрикосов. Вовочка, ответь, что будет у каждого?\n" +
                    "— Расстройство желудка!";
            case 3 -> "Я работаю ветеринаром вот уже 30 лет! Надо же! 30 лет — коту под хвост!";
            case 4 -> "Во время сессии вызывают студента в деканат.\n" +
                    "— Какой экзамен не сдал?\n" +
                    "— Физику.\n" +
                    "Декан поднимается и спрашивает:\n" +
                    "— А хочешь автомат?\n" +
                    "Радостный студент отвечает:\n" +
                    "— Да!\n" +
                    "— Отчислен! — говорит декан.";
            case 5 -> "Две блондинки у машины:\n" +
                    "— Блин, колесо спустило!\n" +
                    "— Совсем?\n" +
                    "— Нет, только снизу.";
            default -> throw new IllegalArgumentException("Unexpected value:" + number);
        };
    }
}