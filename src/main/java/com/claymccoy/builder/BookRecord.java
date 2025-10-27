package com.claymccoy.builder;

import java.util.Optional;
import static java.util.Objects.requireNonNull;

public record BookRecord(
        String title,
        String author,
        int yearPublished,
        Optional<String> description)
{

    public BookRecord
    {
        requireNonNull(title, "title is null");
        requireNonNull(author, "author is null");
    }

    public static class Builder {
        private final String title;
        private String author;
        private int yearPublished;
        private Optional<String> description;

        public Builder(String title)
        {
            this.title = title;
        }

        public Builder author(String author)
        {
            this.author = author;
            return this;
        }

        public Builder yearPublished(int yearPublished)
        {
            this.yearPublished = yearPublished;
            return this;
        }

        public Builder description(Optional<String> description)
        {
            this.description = description;
            return this;
        }

        public BookRecord build() throws IllegalStateException
        {
            return new BookRecord(this.title, this.author, this.yearPublished, this.description);
        }
    }
}
