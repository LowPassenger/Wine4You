package com.sommelier.wine4you.repository;

import com.sommelier.wine4you.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {
}
