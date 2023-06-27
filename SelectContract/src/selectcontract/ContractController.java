/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selectcontract;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author c0527253
 */
class ContractController {
    private ContractView theView;
    private ContractModel theModel;

    ContractController(ContractView theView, ContractModel theModel) {
        this.theModel = theModel;
        this.theView = theView;
        this.theView.addPrevListener(new PrevButtonListener());
        this.theView.addBidListener(new BidButtonListener());
        this.theView.addNextListener(new NextButtonListener());
        setUpDisplay();
    }

    class PrevButtonListener implements ActionListener {

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (theModel.getCurrentContractNum() == 0) {
                return;
            }
            try {
                theModel.prevContract();
            } catch (Exception ex) {
                System.out.println(ex);
                theView.displayErrorMessage("Error: There is a problem setting a previous contract.");
            }
            setUpDisplay();
        }
    }

    //not used in lab5
    class BidButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (theModel.getCurrentContractNum() == 0) {
                return;
            }
            try {
                theModel.prevContract();
            } catch (Exception ex) {
                System.out.println(ex);
                theView.displayErrorMessage("Error: There is a problem setting a previous contract.");
            }
            setUpDisplay();
        }
    }

    class NextButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (theModel.getCurrentContractNum() == theModel.getContractCount()) {
                return;
            }
            try {
                theModel.nextContract();
            } catch (Exception ex) {
                System.out.println(ex);
                theView.displayErrorMessage("Error: There is a problem setting a previous contract.");
            }
            setUpDisplay();
        }
    }

    private void setUpDisplay() {
        try {
            if(theModel.getCurrentContractNum()>=0&&theModel.getCurrentContractNum()<theModel.getContractCount()){
                Contract c =theModel.getTheContract();
                theView.setContractID(c.getContractID());
                theView.setDestCity(c.getDestCity());
                theView.setOriginCity(c.getOriginCity());
                theView.setOrderItem(c.getOrderItem());
                theView.updateContractViewPanel(theModel.getCurrentContractNum(),this.theModel.getContractCount());
            }else {
                theView.setContractID("???");
                theView.setDestCity("???");
                theView.setOriginCity("???");
                theView.setOrderItem("???");
            }
            theView.setNextButton(theModel.getCurrentContractNum()<(theModel.getContractCount()-1));
            theView.setPrevButton(theModel.getCurrentContractNum() > 0);

        } catch (Error ex) {
            System.out.println(ex);
            theView.displayErrorMessage(
                    "Error: There was a problem setting the contract.\n"+
                    " Contract Number: "+theModel.getCurrentContractNum());
        }

    }

}
