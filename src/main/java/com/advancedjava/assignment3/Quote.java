package com.advancedjava.assignment3;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by srathi on 8/9/16.
 * This demonstrates how to consume a web service in spring
 */
public class Quote {

    @JsonIgnoreProperties(ignoreUnknown = true)
        private String type;
        private Value value;

        public Quote() {
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Value getValue() {
            return value;
        }

        public void setValue(Value value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Quote{" +
                    "type='" + type + '\'' +
                    ", value=" + value +
                    '}';
        }
    }
