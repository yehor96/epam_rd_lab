package com.epam.test.ht16.task2.pages;

public enum Pages {
    React {
        @Override
        String getLocator() {
            return TODO_PAGE_REACT;
        }

        @Override
        public String toString(){
            return "react";
        }
    },
    Dart {
        @Override
        String getLocator() {
            return TODO_PAGE_DART;
        }

        @Override
        public String toString(){
            return "dart";
        }
    };

    abstract String getLocator();

    private static final String TODO_PAGE_REACT =
            "//li[@class='routing']/a[@data-source='http://facebook.github.io/react/']";

    private static final String TODO_PAGE_DART =
            "//li[@class='routing']/a[@data-source='http://dartlang.org']";
}
