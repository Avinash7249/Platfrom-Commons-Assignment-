package com.commons.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.commons.app.model.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Integer> {

}
