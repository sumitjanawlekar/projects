/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.OrderManagementOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import javax.swing.JPanel;
import UserInterface.orderManagementRole.orderManagemntWorkArea;
/**
 *
 * @author Kunal
 */
public class OrderManagerRole extends Role{

   
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new orderManagemntWorkArea(userProcessContainer,account,(OrderManagementOrganization)organization,enterprise,business);
    }
    

    
}
