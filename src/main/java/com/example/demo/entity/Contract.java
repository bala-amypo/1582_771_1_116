package com.example.demo.entity;

public class Contract {
    private long id;
    private String contractNumber;
    private String title;
    private Date agreedDeliveryDate;
    private BigDecimal baseContractValue;
    private String status;
    private Timestamp createdAt;
    private Timestamp updatedAt;


public Contract(){
}
public Contract(long id,String contractNumber,String title,Date agreedDeliveryDate,BigDecimal baseContractValue,String status,Timestamp createdAt,Timestamp updatedAt){
    this.id=id;
    this.contractNumber=contractNumber;
    

}
    
}
