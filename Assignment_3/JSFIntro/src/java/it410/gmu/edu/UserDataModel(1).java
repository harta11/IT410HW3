/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package it410.gmu.edu;

import java.util.List;  
import javax.faces.model.ListDataModel;  
import org.primefaces.model.SelectableDataModel;  
  
public class UserDataModel extends ListDataModel<User> implements SelectableDataModel<User> {    
  
    public UserDataModel() {  
    }  
  
    public UserDataModel(List<User> data) {  
        super(data);  
    }  
      
    @Override  
    public User getRowData(String rowKey) {  
        //In a real app, a more efficient way like a query by rowKey should be implemented to deal with huge data 
          
        System.out.println(" Key = " + rowKey);
        List<User> users = (List<User>) getWrappedData();  
          
        for(User user : users) {  
            if(user.getId().equals(rowKey))  
                return user;  
        }  
        System.out.println(" Valid User not found");
        return null;  
    }  
  
    @Override  
    public Object getRowKey(User user) {  
        return user.getId();
    }  
}  