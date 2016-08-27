package com.advancedjava.assignment3;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by srathi on 8/9/16.
 */
public class Value {

    @JsonIgnoreProperties(ignoreUnknown = true)
        private Long id;
        private String quote;

        public Value() {
        }

        public Long getId() {
            return this.id;
        }

        public String getQuote() {
            return this.quote;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public void setQuote(String quote) {
            this.quote = quote;
        }

        @Override
        public String toString() {
            return "Value{" +
                    "id=" + id +
                    ", quote='" + quote + '\'' +
                    '}';
        }
    }
