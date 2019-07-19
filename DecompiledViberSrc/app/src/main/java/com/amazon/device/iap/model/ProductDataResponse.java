package com.amazon.device.iap.model;

import com.amazon.device.iap.internal.model.ProductDataResponseBuilder;
import com.amazon.device.iap.internal.util.d;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class ProductDataResponse
{
  private static final String PRODUCT_DATA = "productData";
  private static final String REQUEST_ID = "requestId";
  private static final String REQUEST_STATUS = "requestStatus";
  private static final String TO_STRING_FORMAT = "(%s, requestId: \"%s\", unavailableSkus: %s, requestStatus: \"%s\", productData: %s)";
  private static final String UNAVAILABLE_SKUS = "UNAVAILABLE_SKUS";
  private final Map<String, Product> productData;
  private final RequestId requestId;
  private final RequestStatus requestStatus;
  private final Set<String> unavailableSkus;

  public ProductDataResponse(ProductDataResponseBuilder paramProductDataResponseBuilder)
  {
    d.a(paramProductDataResponseBuilder.getRequestId(), "requestId");
    d.a(paramProductDataResponseBuilder.getRequestStatus(), "requestStatus");
    if (paramProductDataResponseBuilder.getUnavailableSkus() == null)
      paramProductDataResponseBuilder.setUnavailableSkus(new HashSet());
    if (RequestStatus.SUCCESSFUL == paramProductDataResponseBuilder.getRequestStatus())
      d.a(paramProductDataResponseBuilder.getProductData(), "productData");
    this.requestId = paramProductDataResponseBuilder.getRequestId();
    this.requestStatus = paramProductDataResponseBuilder.getRequestStatus();
    this.unavailableSkus = paramProductDataResponseBuilder.getUnavailableSkus();
    this.productData = paramProductDataResponseBuilder.getProductData();
  }

  public Map<String, Product> getProductData()
  {
    return this.productData;
  }

  public RequestId getRequestId()
  {
    return this.requestId;
  }

  public RequestStatus getRequestStatus()
  {
    return this.requestStatus;
  }

  public Set<String> getUnavailableSkus()
  {
    return this.unavailableSkus;
  }

  public JSONObject toJSON()
    throws JSONException
  {
    JSONObject localJSONObject1 = new JSONObject();
    localJSONObject1.put("requestId", this.requestId);
    localJSONObject1.put("UNAVAILABLE_SKUS", this.unavailableSkus);
    localJSONObject1.put("requestStatus", this.requestStatus);
    JSONObject localJSONObject2 = new JSONObject();
    if (this.productData != null)
    {
      Iterator localIterator = this.productData.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localJSONObject2.put(str, ((Product)this.productData.get(str)).toJSON());
      }
    }
    localJSONObject1.put("productData", localJSONObject2);
    return localJSONObject1;
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = super.toString();
    arrayOfObject[1] = this.requestId;
    String str1;
    String str2;
    if (this.unavailableSkus != null)
    {
      str1 = this.unavailableSkus.toString();
      arrayOfObject[2] = str1;
      if (this.requestStatus == null)
        break label91;
      str2 = this.requestStatus.toString();
      label53: arrayOfObject[3] = str2;
      if (this.productData == null)
        break label97;
    }
    label91: label97: for (String str3 = this.productData.toString(); ; str3 = "null")
    {
      arrayOfObject[4] = str3;
      return String.format("(%s, requestId: \"%s\", unavailableSkus: %s, requestStatus: \"%s\", productData: %s)", arrayOfObject);
      str1 = "null";
      break;
      str2 = "null";
      break label53;
    }
  }

  public static enum RequestStatus
  {
    static
    {
      FAILED = new RequestStatus("FAILED", 1);
      NOT_SUPPORTED = new RequestStatus("NOT_SUPPORTED", 2);
      RequestStatus[] arrayOfRequestStatus = new RequestStatus[3];
      arrayOfRequestStatus[0] = SUCCESSFUL;
      arrayOfRequestStatus[1] = FAILED;
      arrayOfRequestStatus[2] = NOT_SUPPORTED;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.amazon.device.iap.model.ProductDataResponse
 * JD-Core Version:    0.6.2
 */