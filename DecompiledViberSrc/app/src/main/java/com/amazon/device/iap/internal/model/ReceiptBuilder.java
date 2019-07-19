package com.amazon.device.iap.internal.model;

import com.amazon.device.iap.model.ProductType;
import com.amazon.device.iap.model.Receipt;
import java.util.Date;

public class ReceiptBuilder
{
  private Date cancelDate;
  private ProductType productType;
  private Date purchaseDate;
  private String receiptId;
  private String sku;

  public Receipt build()
  {
    return new Receipt(this);
  }

  public Date getCancelDate()
  {
    return this.cancelDate;
  }

  public ProductType getProductType()
  {
    return this.productType;
  }

  public Date getPurchaseDate()
  {
    return this.purchaseDate;
  }

  public String getReceiptId()
  {
    return this.receiptId;
  }

  public String getSku()
  {
    return this.sku;
  }

  public ReceiptBuilder setCancelDate(Date paramDate)
  {
    this.cancelDate = paramDate;
    return this;
  }

  public ReceiptBuilder setProductType(ProductType paramProductType)
  {
    this.productType = paramProductType;
    return this;
  }

  public ReceiptBuilder setPurchaseDate(Date paramDate)
  {
    this.purchaseDate = paramDate;
    return this;
  }

  public ReceiptBuilder setReceiptId(String paramString)
  {
    this.receiptId = paramString;
    return this;
  }

  public ReceiptBuilder setSku(String paramString)
  {
    this.sku = paramString;
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.amazon.device.iap.internal.model.ReceiptBuilder
 * JD-Core Version:    0.6.2
 */