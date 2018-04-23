/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it410.gmu.edu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author gmuclass
 */
@ManagedBean(name="UserRegistration")
@SessionScoped
public class UserRegistration implements Serializable {
    private User user;
    private List<User> userList = new ArrayList<User>();
    private List<Credits> creditList = new ArrayList<Credits>();
    private UserDataModel   dataModel;
    private static int id = 0;
    
    private String[] courses = {"History", "Calculus", "Biology", "Physics", "Chemistry"};
    private String[] states = 
    {
        "Alabama", "Alaska", "Arizona", "Arkansas", "California", "Colorado", "Connecticut", "Delwaare",
        "Disctrict of Columbia", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa",
        "Kansas", "Kentucky", "Lousiana", "Maine" , "Maryland", "Massachusetts", "Michigan", "Minnesota",
        "Mississippi", "Missouri", "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey",
        "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", 
        "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota", "Tennessee", "Texas", "Utah",
        "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"
    };
    
    public UserRegistration() {
        user = new User();
        dataModel = new UserDataModel(userList);
        
        creditList.add(new Credits("Three", "3"));
        creditList.add(new Credits("Six", "6"));
        creditList.add(new Credits("Nine", "9"));
        creditList.add(new Credits("Twelve", "12"));
        creditList.add(new Credits("Full", "16+"));
        
    }

    public String[] getStates() {
        return this.states;
    }
    
    public List<Credits> getCreditsList() {
        return this.creditList;
    }
    
    public String getCredits() {
        return user.getCredits();
    }

    public void setCredits(String credits) {
        user.setCredits(credits);
    }
    
    
    public String getFirstName() {
        return user.getFirstName();
    }

    public void setFirstName(String firstName) {
        user.setFirstName(firstName);
    }

    public String getLastName() {
        return user.getLastName();
    }

    public void setLastName(String lastName) {
        user.setLastName(lastName);
    }

    public String getAddress() {
        return user.getAddress();
    }

    public void setAddress(String address) {
        user.setAddress(address);
    }

    public String getCity() {
        return user.getCity();
    }

    public void setCity(String city) {
        user.setCity(city);
    }

    public String getState() {
        return user.getState();
    }

    public void setState(String state) {
        user.setState(state);
    }

    public String getZipcode() {
        return user.getZipcode();
    }

    public void setZipcode(String zipcode) {
        user.setZipcode(zipcode);
    }

    public String getComments() {
        return user.getComments();
    }

    public void setComments(String comments) {
        user.setComments(comments);
    }

    public Date getRegistrationDate() {
        return user.getRegistrationDate();
    }

    public void setRegistrationDate(Date registrationDate) {
          user.setRegistrationDate(registrationDate);
    }

    public String getPayment() {
        return user.getPayment();
    }

    public void setPayment(String payment) {
        user.setPayment(payment);
    }

    public String getCreditCard() {
        return user.getCreditCard();
    }

    public void setCreditCard(String creditCard) {
        user.setCreditCard(creditCard);
    }
    
    public Float getGPA() {
        return user.getGpa();
    }

    public void setGPA(Float gpa) {
        user.setGpa(gpa);
    }

    public Integer getCreditHours() {
        return user.getCreditHours();
    }

    public void setCreditHours(Integer credits) {
        user.setCreditHours(credits);
    }
    
    public String[] getCourses() {
        return this.courses;
    }    
    
    public String[] getSubjects() {
        return user.getSubjects();
    }

    public void setSubjects(String[] subjects) {
        user.setSubjects(subjects);
    }
    
    
    public void registerUser() {
        System.out.println(" Submit Button clicked..");
        System.out.println(" First Name  = " + user.getFirstName());
        System.out.println(" Last Name  = " + user.getLastName());
        System.out.println(" Address  = " + user.getAddress());
        System.out.println(" City  = " + user.getCity());
        System.out.println(" State  = " + user.getState());
        System.out.println(" Zip  = " + user.getZipcode());
        System.out.println(" comments  = " + user.getComments());
        System.out.println(" Registration Date  = " + user.getRegistrationDate());
        System.out.println(" Credits  = " + user.getCredits());
        System.out.println(" Payment Type  = " + user.getPayment());
        for(String subject : user.getSubjects())
        System.out.println(" Subjects  = " + subject);
        System.out.println(" GPA = " + user.getGpa());
        System.out.println(" CredHours = " + user.getCreditHours());
        System.out.println(" Credit Card Number = " + user.getCreditCard() );
        
        // The following code should handle both inserts and updates
        
        if (user.getId() == null || user.getId().equalsIgnoreCase("-1")) {
            // New User
                    user.setId("" + (id++));
                    userList.add(user);
                    user = new User(); user.setId("-1");
        } else {
            // No need to add him to the list
        }
        
        this.generateThankyouNote();
    }
       
    public void processUserSelection(SelectEvent evt) {
            System.out.println(" Row selected from the Data Table . ");
            this.user = (User) evt.getObject();
    }

    public void processUserUnselection(UnselectEvent evt) {
            System.out.println(" Row unselected from the Data Table . ");
            this.user = new User();
            this.user.setId("-1");
    }
    
    public UserDataModel getDataModel() {
        return this.dataModel;
    }
    
    
    public List searchStates(String searchCriteria) {
        int i = 0;
        ArrayList result = new ArrayList();
        
        for(String state : states) {
            if (state.startsWith(searchCriteria)) {
                result.add(state);
            }
        }
               
        return result;
    }

   private void generateThankyouNote() {
           FacesContext context = FacesContext.getCurrentInstance();
           context.addMessage(null,  new FacesMessage("Thank you for Registering with us!"));
   }    
}
