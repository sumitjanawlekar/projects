/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.WorkQueue;

import Business.UserAccount.UserAccount;

/**
 *
 * @author sumitjanawlekar
 */
public class trashCollectWorkRequest extends WorkRequest {
    private String trashType;
    private String pickedUp;
    private String quantityFinalized;
    private UserAccount deliveryBoyName;

    public UserAccount getDeliveryBoyName() {
        return deliveryBoyName;
    }

    public void setDeliveryBoyName(UserAccount deliveryBoyName) {
        this.deliveryBoyName = deliveryBoyName;
    }
    
    

    public String getQuantityFinalized() {
        return quantityFinalized;
    }

    public void setQuantityFinalized(String quantityFinalized) {
        this.quantityFinalized = quantityFinalized;
    }

    public String getTrashType() {
        return trashType;
    }

    public void setTrashType(String trashType) {
        this.trashType = trashType;
    }

    public String getPickedUp() {
        return pickedUp;
    }

    public void setPickedUp(String pickedUp) {
        this.pickedUp = pickedUp;
    }
    
    @Override
    public String toString(){
        return trashType;
    }
    
    
}
