package Task_7.Phonebook.Core.Models;

public class Contact  implements Comparable<Contact> {
    public String firstName;
    public String lastName;
    public String phone;
    public String description;

    public Contact(String firstName, String lastName, String description, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.phone = phone;
    }


    @Override
    public int compareTo(Contact o) {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        Contact t = (Contact)obj;
        return this.firstName == t.firstName
                && this.lastName == t.lastName
        ;
    }

}
