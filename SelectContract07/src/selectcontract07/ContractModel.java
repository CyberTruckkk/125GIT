/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selectcontract07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author c0527253
 */
class ContractModel {
    public static final int NUMBER_OF_CONTRACT_ATTRIBUTES = 4;
    public static final int INDEX_OF_CONTRACT_ID = 0;
    public static final int INDEX_OF_ORIGIN_CITY = 1;
    public static final int INDEX_OF_DEST_CITY = 2;
    public static final int INDEX_OF_ORDER_ITEM = 3;

    private int contractCounter;
    private ArrayList<Contract> theContracts;
    private ArrayList<Contract> theContractsAll;
    private SortedSet<String> originCityList;

    public ContractModel() {
        this.contractCounter = 0;
        this.theContracts = new ArrayList<>();
        this.originCityList = new TreeSet<>();
        this.theContractsAll =new ArrayList<>();

        String filename = "M:\\125GIT\\SelectContract\\src\\selectcontract\\contracts.txt";
        //M:\125GIT\SelectContract\src\selectcontract
        String[] token;
        try (FileReader fileReader = new FileReader(filename);
             BufferedReader bufferedReader = new BufferedReader(new FileReader(filename));) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                token = line.split(",", NUMBER_OF_CONTRACT_ATTRIBUTES);
                Contract contract = new Contract(token[INDEX_OF_CONTRACT_ID], token[INDEX_OF_ORIGIN_CITY], token[INDEX_OF_DEST_CITY], token[INDEX_OF_ORDER_ITEM]);
                this.theContracts.add(contract);
            }
            fileReader.close();
            for(Contract c:this.theContracts){
                this.originCityList.add(c.getOriginCity());
            }
            this.theContractsAll = new ArrayList<>(this.theContracts);
            this.originCityList.add("All");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String[] getOriginCityList(){
        String[] a;
        a = originCityList.toArray(new String[originCityList.size()]);
        return a;
    }

    public void updateContractList(String city) {
        theContracts = new ArrayList<>(theContractsAll);
        if (city != "All") {
            theContracts.removeIf(s -> !s.contains(city));
        }
        contractCounter = 0;
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
        if (this.contractCounter < (this.getContractCount() - 1)) {
            this.contractCounter++;
        }
    }

    public void prevContract() {
        if (this.contractCounter > 0) {
            this.contractCounter--;
        }
    }
}
