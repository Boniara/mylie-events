package com.bavuta.mylie.database.dao;

import com.bavuta.mylie.database.models.Address;

import java.util.List;

/**
 * Created by bogdan on 11/7/2016.
 */
public interface AddressMapper {

    Address getAddressById(Long id);
    List<Address> getAllAddresses();
    Long createAddress(Address address);
    void updateAddress(Address address);
    void deleteAddressById(Long id);
}
