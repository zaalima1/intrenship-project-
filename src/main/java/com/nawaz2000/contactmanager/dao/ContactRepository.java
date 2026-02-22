package com.nawaz2000.contactmanager.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nawaz2000.contactmanager.entity.ContactDetails;

@Repository
public interface ContactRepository extends JpaRepository<ContactDetails, Integer> {

    // ✅ Correct method – matches field name in ContactDetails
    List<ContactDetails> findByUseridOrderByNameAsc(int userid);

    // ✅ Search query (case-insensitive)
    @Query(
        value = "SELECT * FROM contactdetails WHERE LOWER(name) LIKE LOWER(CONCAT('%', ?1, '%')) AND userid = ?2 ORDER BY name",
        countQuery = "SELECT COUNT(*) FROM contactdetails WHERE LOWER(name) LIKE LOWER(CONCAT('%', ?1, '%')) AND userid = ?2",
        nativeQuery = true
    )
    Page<ContactDetails> search(String search, int userid, Pageable pageable);

    // ✅ Assuming 'favourite' is a column in the entity
    List<ContactDetails> findByFavouriteOrderByNameAsc(String favourite);

    // ✅ Pagination query by user id
    @Query(
        value = "SELECT * FROM contactdetails WHERE userid = ?1 ORDER BY name",
        countQuery = "SELECT COUNT(*) FROM contactdetails WHERE userid = ?1",
        nativeQuery = true
    )
    Page<ContactDetails> findByUserid(int userid, Pageable pageable);
}
