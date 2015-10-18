package hackatl.com.roadieforpeople.model;

/**
 * Created by javier on 10/17/15.
 */
public class RoadieUser
{

    Long id;
    String firstName;
    String lastName;
    String phoneNumber;

    public RoadieUser(String newFirstName, String newLastName, String newPhoneNumber, Long newId)
    {
        phoneNumber = newPhoneNumber;
        firstName = newFirstName;
        lastName = newLastName;
        id = newId;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public Long getId()
    {
        return id;
    }

}
