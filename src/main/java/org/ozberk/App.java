package org.ozberk;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class App
{
    public static void main( String[] args )
    {
        Message message1 = new Message("Spor için motivasyon kaynağını bir türlü sağlıyamıyorum ", List.of("#spor"));
        Message message2 = new Message("AI kodlamayı biterecek galiba", List.of("#teknoloji", "#yazılım"));
        Message message3 = new Message("GotY kadar taraflı bir ödül töreni görmedim ", List.of("#teknoloji", "#oyun"));
        Message message4 = new Message("Az yemek en sağlıklı yeme alışkanlığıdır", List.of("#yemek", "#sağlık"));
        Message message5 = new Message("E - ticaret sitelerinde çok vergi var ://",List.of("#teknoloji","#alıveris"));


        User ali = new User("Ali", 18, "male");
        ali.setMessages(message1);
        ali.setMessages(message2);

        User ayse = new User("Ayşe", 22, "female");
        ayse.setMessages(message3);


        User mehmet = new User("Mehmet", 23, "male");
        mehmet.setMessages(message5);

        User elif = new User("Elif", 30, "female");
       elif.setMessages(message4);

        List<User> users = List.of(ali, ayse, mehmet, elif);

        List<String> tags = users.stream()
                .filter(user -> user.getAge() >= 15 && user.getAge() <= 25 && user.getGender().equals("male"))
                .flatMap(user -> user.getMessages().stream())
                .flatMap(message -> message.getTags().stream())
                .collect(Collectors.toList());

        Map<String, Long> tagFrequency = tags.stream()
                .collect(Collectors.groupingBy(tag -> tag, Collectors.counting()));


        String mostUsedTag = tagFrequency.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("Hiçbir etiket bulunamadı");


        System.out.println("En çok kullanılan etiket: " + mostUsedTag);
        System.out.println("Tüm etiketler ve sıklıkları: " + tagFrequency);
    }
}
