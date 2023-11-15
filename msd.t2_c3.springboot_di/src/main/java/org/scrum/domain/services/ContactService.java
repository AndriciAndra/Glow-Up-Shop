package org.scrum.domain.services;

import org.scrum.domain.project.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactService {
    private List<Contact> contacts = new ArrayList<>();
    private int id = 1;

    public Contact addContact(Contact contact) {
        contact.setId(id++);
        contacts.add(contact);
        return contact;
    }

    public List<Contact> getAllContacts() {
        return contacts;
    }
}
