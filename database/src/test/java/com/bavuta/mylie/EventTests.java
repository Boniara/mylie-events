package com.bavuta.mylie;

import com.bavuta.mylie.database.dao.*;
import com.bavuta.mylie.database.models.*;
import com.bavuta.mylie.database.utils.KeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static com.bavuta.mylie.database.models.Gender.MALE;

/**
 * Created by bogdan on 12/20/2016.
 */

@Test
@ContextConfiguration("classpath:com/bavuta/mylie/database/test-dbaccess.xml")
public class EventTests extends AbstractTestNGSpringContextTests {

    private static KeyGenerator generator = new KeyGenerator();

    @Autowired
    private EventMapper eventMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CountryMapper countryMapper;

    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private EventImageMapper eventImageMapper;

    private static final Address ADDRESS = new Address() {
        private static final long serialVersionUID = 1L; {
            setStreet("s1");
            setHouseNumber(1);
        }
    };

    private static final User EVENT_OWNER = new User() {
        private static final long serialVersionUID = 1L;
        {
            Calendar calendar = Calendar.getInstance();
            calendar.set(1980, 01, 01);
            setId(0L);
            setName("n1");
            setEmail("my_email" + generator.getNewKey() + "@gmail.com");
            setPassword("qwerty1234asd");
            setDateOfBirth(calendar.getTime());
            setGender(MALE);
            setAbout("My name is Cool");
            setPriority(10);
        }
    };

    private static final Event EVENT = new Event() {
        private static final long serialVersionUID = 1L; {
            Calendar calendar = Calendar.getInstance();
            calendar.set(2016, 01, 01);
            setDate(calendar.getTime());
            setDescription("Great party");
            setLikes(4);
            setPriority(10);
            setEventOwner(EVENT_OWNER);
            setImageList(initImageList());
        }
    };

    @Test
    public void createEventTest() {
        Country country = countryMapper.getCountryById(1L);
        ADDRESS.setCountry(country);
        ADDRESS.setCity(country.getCityList().get(0));
        addressMapper.createAddress(ADDRESS);
        EVENT.setAddress(ADDRESS);
        userMapper.createUser(EVENT_OWNER);
        EVENT.setEventOwner(EVENT_OWNER);
        eventMapper.createEvent(EVENT);
        Assert.assertNotEquals(EVENT.getId(), null, "");
    }

    @Test(dependsOnMethods = {"createEventTest"})
    public void createImageTest() {
        for(Image image: EVENT.getImageList()) {
            eventImageMapper.createImage(image, EVENT.getId());
            Assert.assertNotEquals(image.getId(), null, "");
        }
    }

    @Test(dependsOnMethods = {"createEventTest"})
    public void getAllEventsTest() {
        List<Event> eventList = eventMapper.getAllEvents();
        checkEvent(eventList.get(eventList.size() - 1));
    }

    @Test(dependsOnMethods = {"createEventTest"})
    public void getEventByIdTest() {
        Event event = eventMapper.getEventById(EVENT.getId());
        checkEvent(event);
    }

    @Test(dependsOnMethods = {"createEventTest"})
    public void updateEventTest() {
        List<User> userList = userMapper.getAllUsers();
        List<Address> addressList = addressMapper.getAllAddresses();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, 01, 02);
        EVENT.setEventOwner(userList.get(0));
        EVENT.setAddress(addressList.get(0));
        EVENT.setDate(calendar.getTime());
        EVENT.setDescription("Greate party2");
        EVENT.setLikes(8);
        EVENT.setPriority(12);
        eventMapper.updateEvent(EVENT);
        Event event = eventMapper.getEventById(EVENT.getId());
        checkEvent(event);
    }

    @Test(dependsOnMethods = {"createEventTest", "updateEventTest"})
    public void deleteEventByIdTest() {
        eventMapper.deleteEventById(EVENT.getId());
        Assert.assertNull(eventMapper.getEventById(EVENT.getId()));
    }

    private void checkEvent(Event event) {
        Assert.assertEquals(EVENT.getId(), event.getId(), "");
        Assert.assertEquals(EVENT.getEventOwner().getId(), event.getEventOwner().getId(), "");
        Assert.assertEquals(EVENT.getAddress().getId(), event.getAddress().getId(), "");
        Assert.assertEquals(EVENT.getDate().getYear(), event.getDate().getYear(), "");
        Assert.assertEquals(EVENT.getDate().getMonth(), event.getDate().getMonth(), "");
        Assert.assertEquals(EVENT.getDate().getDate(), event.getDate().getDate(), "");
        Assert.assertEquals(EVENT.getDescription(), event.getDescription(), "");
        Assert.assertEquals(EVENT.getLikes(), event.getLikes(), "");
        Assert.assertEquals(EVENT.getPriority(), event.getPriority(), "");
    }

    private static List<Image> initImageList() {
        List<Image> imageList= new ArrayList();
        Image image = new Image();
        Image image1 = new Image();
        Image image2 = new Image();
        Image image3 = new Image();
        image.setImage(("/com/bavuta/mylie/database/images/party1.jpg"));
        image1.setImage(("/com/bavuta/mylie/database/images/party2.jpg"));
        image2.setImage(("/com/bavuta/mylie/database/images/party3.jpg"));
        image3.setImage(("/com/bavuta/mylie/database/images/party4.jpg"));
        imageList.add(image);
        imageList.add(image1);
        imageList.add(image2);
        imageList.add(image3);
        return imageList;
    }
}
