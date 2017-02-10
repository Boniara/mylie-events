package com.bavuta.mylie.database.services;

import com.bavuta.mylie.database.dao.AddressMapper;
import com.bavuta.mylie.database.models.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by bogdan on 12/20/2016.
 */

@Service
public class AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Transactional(rollbackFor = Exception.class)
    public Address createAddress(Address address) {
        addressMapper.createAddress(address);
        return address;
    }

    @Transactional(rollbackFor = Exception.class)
    public Address getAddressById(Long id) {
        Address address = addressMapper.getAddressById(id);
        return address;
    }

    @Transactional(rollbackFor = Exception.class)
    public List<Address> getAllAddresses() {
        List<Address> addressList = addressMapper.getAllAddresses();
        return addressList;
    }

    @Transactional(rollbackFor = Exception.class)
    public Address updateAddress(Address address) {
        addressMapper.updateAddress(address);
        Address updatingAddress = addressMapper.getAddressById(address.getId());
        return updatingAddress;
    }

    @Transactional(rollbackFor = Exception.class)
    public Address deleteAddressById(Long id) {
        Address address = addressMapper.getAddressById(id);
        addressMapper.deleteAddressById(id);
        return address;
    }
}
