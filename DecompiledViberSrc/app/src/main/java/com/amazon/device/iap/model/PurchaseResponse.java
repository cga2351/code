package com.amazon.device.iap.model;

import com.amazon.device.iap.internal.model.PurchaseResponseBuilder;
import com.amazon.device.iap.internal.util.d;
import org.json.JSONException;
import org.json.JSONObject;

public final class PurchaseResponse
{
  private static final String RECEIPT = "receipt";
  private static final String REQUEST_ID = "requestId";
  private static final String REQUEST_STATUS = "requestStatus";
  private static final String TO_STRING_FORMAT = "(%s, requestId: \"%s\", purchaseRequestStatus: \"%s\", userId: \"%s\", receipt: %s)";
  private static final String USER_DATA = "userData";
  private final Receipt receipt;
  private final RequestId requestId;
  private final RequestStatus requestStatus;
  private final UserData userData;

  public PurchaseResponse(PurchaseResponseBuilder paramPurchaseResponseBuilder)
  {
    d.a(paramPurchaseResponseBuilder.getRequestId(), "requestId");
    d.a(paramPurchaseResponseBuilder.getRequestStatus(), "requestStatus");
    if (paramPurchaseResponseBuilder.getRequestStatus() == RequestStatus.SUCCESSFUL)
    {
      d.a(paramPurchaseResponseBuilder.getReceipt(), "receipt");
      d.a(paramPurchaseResponseBuilder.getUserData(), "userData");
    }
    this.requestId = paramPurchaseResponseBuilder.getRequestId();
    this.userData = paramPurchaseResponseBuilder.getUserData();
    this.receipt = paramPurchaseResponseBuilder.getReceipt();
    this.requestStatus = paramPurchaseResponseBuilder.getRequestStatus();
  }

  public Receipt getReceipt()
  {
    return this.receipt;
  }

  public RequestId getRequestId()
  {
    return this.requestId;
  }

  public RequestStatus getRequestStatus()
  {
    return this.requestStatus;
  }

  public UserData getUserData()
  {
    return this.userData;
  }

  public JSONObject toJSON()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("requestId", this.requestId);
    localJSONObject.put("requestStatus", this.requestStatus);
    Object localObject1;
    if (this.userData != null)
    {
      localObject1 = this.userData.toJSON();
      localJSONObject.put("userData", localObject1);
      if (getReceipt() == null)
        break label89;
    }
    label89: for (Object localObject2 = getReceipt().toJSON(); ; localObject2 = "")
    {
      localJSONObject.put("receipt", localObject2);
      return localJSONObject;
      localObject1 = "";
      break;
    }
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = super.toString();
    arrayOfObject[1] = this.requestId;
    if (this.requestStatus != null);
    for (String str = this.requestStatus.toString(); ; str = "null")
    {
      arrayOfObject[2] = str;
      arrayOfObject[3] = this.userData;
      arrayOfObject[4] = this.receipt;
      return String.format("(%s, requestId: \"%s\", purchaseRequestStatus: \"%s\", userId: \"%s\", receipt: %s)", arrayOfObject);
    }
  }

  public static enum RequestStatus
  {
    static
    {
      FAILED = new RequestStatus("FAILED", 1);
      INVALID_SKU = new RequestStatus("INVALID_SKU", 2);
      ALREADY_PURCHASED = new RequestStatus("ALREADY_PURCHASED", 3);
      NOT_SUPPORTED = new RequestStatus("NOT_SUPPORTED", 4);
      RequestStatus[] arrayOfRequestStatus = new RequestStatus[5];
      arrayOfRequestStatus[0] = SUCCESSFUL;
      arrayOfRequestStatus[1] = FAILED;
      arrayOfRequestStatus[2] = INVALID_SKU;
      arrayOfRequestStatus[3] = ALREADY_PURCHASED;
      arrayOfRequestStatus[4] = NOT_SUPPORTED;
    }

    public static RequestStatus safeValueOf(String paramString)
    {
      if (d.a(paramString))
        return null;
      if ("ALREADY_ENTITLED".equalsIgnoreCase(paramString))
        return ALREADY_PURCHASED;
      return valueOf(paramString.toUpperCase());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.amazon.device.iap.model.PurchaseResponse
 * JD-Core Version:    0.6.2
 */