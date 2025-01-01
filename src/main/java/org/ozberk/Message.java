package org.ozberk;

import java.util.ArrayList;
import java.util.List;

public class Message {
        private String content;
        private List<String> tags;

        public Message(String content, List<String> tag) {
            this.content = content;
            this.tags=tag;
        }

        public List<String> getTags() {
            return tags;
        }
    }
