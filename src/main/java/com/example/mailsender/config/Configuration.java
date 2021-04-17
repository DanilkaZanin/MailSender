package com.example.mailsender.config;

public class Configuration {
    public static int a = 0; //Указывает с какого элемента начинать рассылку
    public static String csvFile = "/home/danila/IdeaProjects/MailSender/src/main/resources/data.csv"; //Указывает на файл csv, с которым работать
    public static int timeSleep = 2; //Время паузы межу отправками писем (указывается только в минутах)
    public static String message = " some message"; //сообщение,которое будет отправляться на мэйлы, к сожалению я не очень понял как парсить html письмо
    public static String subject = "some subject";
}
