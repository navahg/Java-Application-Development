/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;

/**
 * Class for storing details about a person
 * @author raghavan
 */
public class Person {
    // Declaring private classes that will be used for storing details about a 
    // person
    public class Name {
        private String firstName;
        private String middleName;
        private String lastName;
        
        private Name() {
            firstName = "";
            middleName = "";
            lastName = "";
        }
        
        private Name(String firstName, String lastName) {
            this.firstName = firstName;
            this.middleName = "";
            this.lastName = lastName;
        }
        
        private Name(String firstName, String middleName, String lastName) {
            this.firstName = firstName;
            this.middleName = middleName;
            this.lastName = lastName;
        }
        
        public String getFirstName() {
            return firstName;
        }

        private void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getMiddleName() {
            return middleName;
        }

        private void setMiddleName(String middleName) {
            this.middleName = middleName;
        }

        public String getLastName() {
            return lastName;
        }

        private void setLastName(String lastName) {
            this.lastName = lastName;
        }
        
        @Override
        public String toString() {
            return (firstName + " " + middleName).trim() + " " + lastName;
        }
    }
    public class ConfidentialInformations {
        private String bankAccountNumber;
        private String socialSecurityNumber;
        private String medicalRecordNumber;
        
        private ConfidentialInformations() {
            bankAccountNumber = "n/a";
            socialSecurityNumber = "n/a";
            medicalRecordNumber = "n/a";
        }
        
        private HashMap<String, String> getConfidentialInformation() {
            HashMap<String, String> information = new HashMap<>();
        
            information.put("bankAccountNumber", info.getBankAccountNumber());
            information.put("socialSecurityNumber", info.getSocialSecurityNumber());
            information.put("medicalRecordNumber", info.getMedicalRecordNumber());

            return information;
        }
        
        private void setConfidentialInformation(HashMap<String, String> info) {
            setBankAccountNumber(info.get("bankAccountNumber"));
            setSocialSecurityNumber(info.get("socialSecurityNumber"));
            setMedicalRecordNumber(info.get("medicalRecordNumber"));
        }

        public String getBankAccountNumber() {
            return bankAccountNumber;
        }

        private void setBankAccountNumber(String bankAccountNumber) {
            this.bankAccountNumber = bankAccountNumber;
        }

        public String getSocialSecurityNumber() {
            return socialSecurityNumber;
        }

        private void setSocialSecurityNumber(String socialSecurityNumber) {
            this.socialSecurityNumber = socialSecurityNumber;
        }

        public String getMedicalRecordNumber() {
            return medicalRecordNumber;
        }

        private void setMedicalRecordNumber(String medicalRecordNumber) {
            this.medicalRecordNumber = medicalRecordNumber;
        }
    }
    public class Address {
        private String addressLine1;
        private String addressLine2;
        private String city;
        private String state;
        private String zipcode;
        private String type;
        
        private Address() {
            this.addressLine1 = "";
            this.addressLine2 = "";
            this.city = "";
            this.state = "";
            this.zipcode = "";
            this.type = "default";
        }
        
        private Address(String addressLine1, String addressLine2, String city,
                String state, String zipcode) {
            this.addressLine1 = addressLine1;
            this.addressLine2 = addressLine2;
            this.city = city;
            this.state = state;
            this.zipcode = zipcode;
        }
        
        private String getAddress() {
            return this.addressLine1 + "\n" + this.addressLine2 + "\n" +
                    this.city + "\n" + this.state + " - " + this.zipcode;
        }

        public String getAddressLine1() {
            return addressLine1;
        }

        private void setAddressLine1(String addressLine1) {
            this.addressLine1 = addressLine1;
        }

        public String getAddressLine2() {
            return addressLine2;
        }

        private void setAddressLine2(String addressLine2) {
            this.addressLine2 = addressLine2;
        }

        public String getCity() {
            return city;
        }

        private void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        private void setState(String state) {
            this.state = state;
        }

        public String getZipcode() {
            return zipcode;
        }

        private void setZipcode(String zipcode) {
            this.zipcode = zipcode;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
    public class TelephoneNumber {
        private String countryCode;
        private String areaCode;
        private String number;
        
        private TelephoneNumber() {
            countryCode = "1";
            areaCode = "000";
            number = "0000000";
        }
        
        private void setTelephoneNumber(String input) {
            areaCode = input.substring(input.length() - 10, input.length() - 7);
            number = input.substring(input.length() - 7);
        }
        
        public String getTelephoneNumber() {
            return String.format("+%s (%s) %s - %s", countryCode, areaCode,
                    number.substring(0, 3), number.substring(3));
        }
    }
    
    // Declaring private members
    private String id;
    private Name name;
    private Address address;
    private TelephoneNumber contactNumber;
    private Date dateOfBirth;
    private String email;
    private String linkedInProfile;
    private String profilePicturePath;
    private ConfidentialInformations info;
    
    // Declaring helper variables
    private final DateFormat df = new SimpleDateFormat("dd MMMM yyyy");
    
    // Defining constructors
    public Person() {
        id = UUID.randomUUID().toString();
        name = new Name();
        address = new Address();
        contactNumber = new TelephoneNumber();
        dateOfBirth = new Date();
        email = "you@example.com";
        linkedInProfile = "";
        profilePicturePath = System.getProperty("user.dir") + 
                                            "/resources/images/default-profile-picture.jpg";
        info = new ConfidentialInformations();
    }

    public String getId() {
        return id;
    }

    public Name getName() {
        return name;
    }

    public void setName(String ...args) {
        if(args.length == 2) { 
            name.setFirstName(args[0]);
            name.setFirstName(args[1]);
        } else if(args.length == 3) {
            name.setFirstName(args[0]);
            name.setMiddleName(args[1]);
            name.setLastName(args[2]);
        }
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(String ...args) {
        if(args.length != 5)
            return;
        
        address.setAddressLine1(args[0]);
        address.setAddressLine2(args[1]);
        address.setCity(args[2]);
        address.setState(args[3]);
        address.setZipcode(args[4]);
    }

    public String getContactNumber() {
        return contactNumber.getTelephoneNumber();
    }

    public void setContactNumber(String number) {
        contactNumber.setTelephoneNumber(number);
    }

    public String getDateOfBirth() {
        return df.format(dateOfBirth);
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLinkedInProfile() {
        return linkedInProfile;
    }

    public void setLinkedInProfile(String linkedInProfile) {
        this.linkedInProfile = linkedInProfile;
    }

    public String getProfilePicturePath() {
        return profilePicturePath;
    }

    public void setProfilePicturePath(String profilePicturePath) {
        if(! "".equals(profilePicturePath))
            this.profilePicturePath = profilePicturePath;
    }   

    public HashMap<String, String> getInfo() {
        return this.info.getConfidentialInformation();
    }

    public void setInfo(HashMap<String, String> info) {
        this.info.setConfidentialInformation(info);
    }    
}
