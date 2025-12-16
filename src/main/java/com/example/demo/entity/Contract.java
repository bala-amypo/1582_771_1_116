package com.example.demo.entity;

public class Contract {
    private long id;
    private String contractNumber;
    private String title;
    private String counterpartyName;
    private Date agreedDeliveryDate;
    private BigDecimal baseContractValue;
    private String status;
    private Timestamp createdAt;
    private Timestamp updatedAt;


public Contract(){
}
public Contract(long id,String contractNumber,String title,String counterpartyName,Date agreedDeliveryDate,BigDecimal baseContractValue,String status,Timestamp createdAt,Timestamp updatedAt){
    this.id=id;
    this.contractNumber=contractNumber;
    this.title=title;
    this.counterpartyName=counterpartyName;
    this.agreedDeliveryDate=agreedDeliveryDate;
    this.baseContractValue=baseContractValue;
    this.sta

}
    
}
