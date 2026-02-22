package com.nawaz2000.contactmanager.dao;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.nawaz2000.contactmanager.entity.ContactDetails;

@Service
public class ContactStorageService {

    @Autowired
    private ContactRepository contactRepository;

    // ✅ Make sure this matches your entity field name (userId or userid)
    public List<ContactDetails> findByUserIdOrderByNameAsc(int userId) {
        return contactRepository.findByUseridOrderByNameAsc(userId);
    }

    public Page<ContactDetails> search(String search, int userId, Pageable pageable) {
        return contactRepository.search(search, userId, pageable);
    }

    public List<ContactDetails> findByFavouriteOrderByNameAsc(String favourite) {
        return contactRepository.findByFavouriteOrderByNameAsc(favourite);
    }

    public Page<ContactDetails> findByUserId(int userId, Pageable pageable) {
        return contactRepository.findByUserid(userId, pageable);
    }

    public void deleteById(Integer id) {
        contactRepository.deleteById(id);
    }

    public ContactDetails findById(Integer id) {
        Optional<ContactDetails> contact = contactRepository.findById(id);
        return contact.orElse(null); // ✅ Avoid NoSuchElementException
    }

    // ✅ Fixed: assign current user ID correctly
    public ContactDetails save(ContactDetails newContact, MultipartFile multipartFile, Integer currUserId) throws IOException {
        if (multipartFile != null && !multipartFile.isEmpty()) {
            newContact.setImage(multipartFile.getBytes());
        }

        // ✅ Link contact to the logged-in user
        newContact.setUserid(currUserId); // ← change to setUserid(currUserId) if your entity field is 'userid'

        return contactRepository.save(newContact);
    }
}
