package com.example.project;

public enum Pages {

    EMPLOYEE("employee"),
    HOME("home"),
    ABOUT("about"),
    CONTACT("contact"),
    SERVICES("services"),
    ERROR("error");

    private final String page;

    Pages(String page) {
        this.page = page;
    }

    public String getPage() {
        return page;
    }

    public static Pages fromString(String page) {
        for (Pages pages : Pages.values()) {
            if (pages.getPage().equalsIgnoreCase(page)) {
                return pages;
            }
        }
        return ERROR; // Default or fallback case
    }
}
