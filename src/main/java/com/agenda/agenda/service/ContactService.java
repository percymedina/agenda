package com.agenda.agenda.service;

import java.time.LocalDateTime;
import org.springframework.stereotype.Service;
import com.agenda.agenda.entity.Contact;
import com.agenda.agenda.repository.ContactRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public Iterable<Contact> findAll() {
        return contactRepository.findAll();
    }

    public Contact findById(Integer id) {
        return contactRepository
                .findById(id)
                .orElse(null);
    }

    public Contact create(Contact contact) {
        contact.setCreatedAt(LocalDateTime.now());
        return contactRepository.save(contact);
    }

    public Contact update(Integer id, Contact contact) {
        Contact contactFromDb = findById(id);
        contactFromDb.setNombre(contact.getNombre());
        contactFromDb.setEmail(contact.getEmail());
        return contactRepository.save(contactFromDb);
    }

    public void delete(Integer id) {
        Contact contactFromDb = findById(id);
        contactRepository.delete(contactFromDb);
    }
}
