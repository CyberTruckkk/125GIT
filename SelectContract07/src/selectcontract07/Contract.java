package selectcontract07;

public class Contract {
    private String contractID;
    private String originCity;
    private String destCity;
    private String orderItem;

    public Contract(String contractID, String originCity, String destCity, String orderItem) {
        this.contractID = contractID;
        this.originCity = originCity;
        this.destCity = destCity;
        this.orderItem = orderItem;
    }

    public String getContractID() {
        return contractID;
    }

    public String getOriginCity() {
        return originCity;
    }

    public String getDestCity() {
        return destCity;
    }

    boolean contains(String city) {
        return originCity.equals(city);
    }

    public String getOrderItem() {
        return orderItem;
    }
}
