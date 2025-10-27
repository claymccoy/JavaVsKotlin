package com.claymccoy.builder;

import java.util.Optional;

public class BookMain
{
    public static void main(String[] args) {
        final var bookBuilder = new BookRecord.Builder("Effective Java")
                .author("Joshua Bloch")
                .yearPublished(2001);
        System.out.println(bookBuilder.build());

        bookBuilder.yearPublished(2008).description(Optional.of("Second Edition"));
        System.out.println(bookBuilder.build());
    }
}
