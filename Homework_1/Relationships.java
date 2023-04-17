package Homework_1;

public enum Relationships {
    PARENT("Parents"),
    CHILDREN("Children");
    private String description;
    Relationships(String description) {
        this.description = description;
    }
}
