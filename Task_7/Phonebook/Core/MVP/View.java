package Task_7.Phonebook.Core.MVP;

public interface View {
    String getFirstName();
    void setFirstName(String value);
    String getLastName();
    void setLastName(String value);
    String getDescription();
    void setDescription(String value);
    String getPhone();
    void setPhone(String value);
}
