package com.bavuta.mylie;

import com.bavuta.mylie.database.dao.AddressMapper;
import com.bavuta.mylie.database.dao.CountryMapper;
import com.bavuta.mylie.database.models.Address;
import com.bavuta.mylie.database.models.Country;
import com.bavuta.mylie.database.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by bogdan on 12/20/2016.
 */

@Test
@ContextConfiguration("classpath:com/bavuta/mylie/database/test-dbaccess.xml")
public class AddressTests extends AbstractTestNGSpringContextTests {

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private CountryMapper countryMapper;

    private static final Address ADDRESS = new Address() {
        private static final long serialVersionUID = 1L;
        {
            setStreet("s1");
            setHouseNumber(1);
        }
    };

    @Test
    public void createAddressTest() {
        Country country = countryMapper.getCountryById(1L);
        ADDRESS.setCountry(country);
        ADDRESS.setCity(country.getCityList().get(0));
        addressMapper.createAddress(ADDRESS);
        Assert.assertNotEquals(ADDRESS.getId(), null, "");
    }

    @Test(dependsOnMethods = {"createAddressTest"})
    public void getAllAddressesTest() {
        List<Address> addressList = addressMapper.getAllAddresses();
        checkAddress(addressList.get(addressList.size() - 1));
    }

    @Test(dependsOnMethods = {"createAddressTest"})
    public void getAddressByIdTest() {
        Address address = addressMapper.getAddressById(ADDRESS.getId());
        checkAddress(address);
    }

    @Test(dependsOnMethods = {"createAddressTest"})
    public void updateAddressTest() {
        Country country = countryMapper.getCountryById(2L);
        ADDRESS.setCountry(country);
        ADDRESS.setCity(country.getCityList().get(1));
        ADDRESS.setStreet("s2");
        ADDRESS.setHouseNumber(2);
        addressMapper.updateAddress(ADDRESS);
        Address address = addressMapper.getAddressById(ADDRESS.getId());
        checkAddress(address);
    }

    @Test(dependsOnMethods = {"createAddressTest", "updateAddressTest"})
    public void deleteAddressByIdTest() {
        addressMapper.deleteAddressById(ADDRESS.getId());
        Assert.assertNull(addressMapper.getAddressById(ADDRESS.getId()));
    }

    private void checkAddress(Address address) {
        Assert.assertEquals(ADDRESS.getId(), address.getId(), "");
        Assert.assertEquals(ADDRESS.getCountry().getId(), address.getCountry().getId(), "");
        Assert.assertEquals(ADDRESS.getCity().getId(), address.getCity().getId(), "");
        Assert.assertEquals(ADDRESS.getStreet(), address.getStreet(), "");
        Assert.assertEquals(ADDRESS.getHouseNumber(), address.getHouseNumber(), "");
    }
}
