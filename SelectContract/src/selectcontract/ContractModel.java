/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selectcontract;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author c0527253
 */
class ContractModel {
    public static final int NUMBER_OF_CONTRACT_ATTRIBUTES=4;
    public static final int INDEX_OF_CONTRACT_ID=0;
    public static final int INDEX_OF_ORIGIN_CITY=1;
    public static final int INDEX_OF_DEST_CITY=2;
    public static final int INDEX_OF_ORDER_ITEM=3;

   private int contractCounter;
    private  ArrayList theContracts;

    public ContractModel() {
        this.contractCounter = 0;
        this.theContracts = new ArrayList<>();
        String filename = "M:\\125GIT\\SelectContract\\src\\selectcontract\\contracts.txt";
        String[] token;
        try (FileReader fileReader = new FileReader(filename);
             BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                token = line.split(",",NUMBER_OF_CONTRACT_ATTRIBUTES);
                Contract contract = new Contract(token[INDEX_OF_CONTRACT_ID], token[INDEX_OF_ORIGIN_CITY], token[INDEX_OF_DEST_CITY], token[INDEX_OF_ORDER_ITEM]);
                this.theContracts.add(contract);
            }
            fileReader.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public boolean foundContracts() {
        return this.theContracts.size() > 0;
    }

    public Contract getTheContract() {
        return (Contract) this.theContracts.get(this.contractCounter);
    }

    public int getContractCount() {
        return this.theContracts.size();
    }

    public int getCurrentContractNum() {
        return this.contractCounter;
    }

    public void nextContract() {
        if (this.contractCounter < (this.getContractCount()-1)) {
//            System.out.println("nextContract() "+this.contractCounter++);
            this.contractCounter++;
        }
    }

    public void prevContract() {
        if (this.contractCounter > 0) {
            this.contractCounter--;
        }
    }
}
