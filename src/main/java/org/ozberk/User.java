package org.ozberk;

import java.util.ArrayList;
import java.util.List;

public class User {
        private String username;
        private int age;
        private String gender;
        private List<Message> messages;

        public User(String username, int age, String gender) {
            this.username = username;
            this.age = age;
            this.gender = gender;
            this.messages = new ArrayList<Message>();
        }

        public int getAge() {
            return age;
        }

        public String getGender() {
            return gender;
        }

        public List<Message> getMessages() {
            return messages;
        }

        public void setMessages(Message message) {
            messages.add(message);
        }
    }
