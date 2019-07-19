package com.amazon.device.iap.model;

import com.amazon.device.iap.internal.model.ReceiptBuilder;
import com.amazon.device.iap.internal.util.d;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

public final class Receipt
{
  private static final String CANCEL_DATE = "endDate";
  private static final Date DATE_CANCELED = new Date(1L);
  private static final String PRODUCT_TYPE = "itemType";
  private static final String PURCHASE_DATE = "purchaseDate";
  private static final String RECEIPT_ID = "receiptId";
  private static final String SKU = "sku";
  private final Date cancelDate;
  private final ProductType productType;
  private final Date purchaseDate;
  private final String receiptId;
  private final String sku;

  public Receipt(ReceiptBuilder paramReceiptBuilder)
  {
    d.a(paramReceiptBuilder.getSku(), "sku");
    d.a(paramReceiptBuilder.getProductType(), "productType");
    if (ProductType.SUBSCRIPTION == paramReceiptBuilder.getProductType())
      d.a(paramReceiptBuilder.getPurchaseDate(), "purchaseDate");
    this.receiptId = paramReceiptBuilder.getReceiptId();
    this.sku = paramReceiptBuilder.getSku();
    this.productType = paramReceiptBuilder.getProductType();
    this.purchaseDate = paramReceiptBuilder.getPurchaseDate();
    this.cancelDate = paramReceiptBuilder.getCancelDate();
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    Receipt localReceipt;
    do
    {
      do
      {
        return true;
        if (paramObject == null)
          return false;
        if (getClass() != paramObject.getClass())
          return false;
        localReceipt = (Receipt)paramObject;
        if (this.cancelDate == null)
        {
          if (localReceipt.cancelDate != null)
            return false;
        }
        else if (!this.cancelDate.equals(localReceipt.cancelDate))
          return false;
        if (this.productType != localReceipt.productType)
          return false;
        if (this.purchaseDate == null)
        {
          if (localReceipt.purchaseDate != null)
            return false;
        }
        else if (!this.purchaseDate.equals(localReceipt.purchaseDate))
          return false;
        if (this.receiptId == null)
        {
          if (localReceipt.receiptId != null)
            return false;
        }
        else if (!this.receiptId.equals(localReceipt.receiptId))
          return false;
        if (this.sku != null)
          break;
      }
      while (localReceipt.sku == null);
      return false;
    }
    while (this.sku.equals(localReceipt.sku));
    return false;
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

  public int hashCode()
  {
    int i;
    int k;
    label26: int n;
    label44: int i2;
    label64: int i3;
    int i4;
    if (this.cancelDate == null)
    {
      i = 0;
      int j = 31 * (i + 31);
      if (this.productType != null)
        break label105;
      k = 0;
      int m = 31 * (k + j);
      if (this.purchaseDate != null)
        break label116;
      n = 0;
      int i1 = 31 * (n + m);
      if (this.receiptId != null)
        break label128;
      i2 = 0;
      i3 = 31 * (i2 + i1);
      String str = this.sku;
      i4 = 0;
      if (str != null)
        break label140;
    }
    while (true)
    {
      return i3 + i4;
      i = this.cancelDate.hashCode();
      break;
      label105: k = this.productType.hashCode();
      break label26;
      label116: n = this.purchaseDate.hashCode();
      break label44;
      label128: i2 = this.receiptId.hashCode();
      break label64;
      label140: i4 = this.sku.hashCode();
    }
  }

  public boolean isCanceled()
  {
    return this.cancelDate != null;
  }

  public JSONObject toJSON()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("receiptId", this.receiptId);
      localJSONObject.put("sku", this.sku);
      localJSONObject.put("itemType", this.productType);
      localJSONObject.put("purchaseDate", this.purchaseDate);
      localJSONObject.put("endDate", this.cancelDate);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
    }
    return localJSONObject;
  }

  public String toString()
  {
    try
    {
      String str = toJSON().toString(4);
      return str;
    }
    catch (JSONException localJSONException)
    {
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.amazon.device.iap.model.Receipt
 * JD-Core Version:    0.6.2
 */