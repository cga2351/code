package com.amazon.device.iap.model;

import com.amazon.device.iap.internal.model.PurchaseUpdatesResponseBuilder;
import com.amazon.device.iap.internal.util.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class PurchaseUpdatesResponse
{
  private static final String HAS_MORE = "HAS_MORE";
  private static final String RECEIPTS = "RECEIPTS";
  private static final String REQUEST_ID = "REQUEST_ID";
  private static final String REQUEST_STATUS = "REQUEST_STATUS";
  private static final String TO_STRING_FORMAT = "(%s, requestId: \"%s\", requestStatus: \"%s\", userData: \"%s\", receipts: %s, hasMore: \"%b\")";
  private static final String USER_DATA = "USER_DATA";
  private final boolean hasMore;
  private final List<Receipt> receipts;
  private final RequestId requestId;
  private final RequestStatus requestStatus;
  private final UserData userData;

  public PurchaseUpdatesResponse(PurchaseUpdatesResponseBuilder paramPurchaseUpdatesResponseBuilder)
  {
    d.a(paramPurchaseUpdatesResponseBuilder.getRequestId(), "requestId");
    d.a(paramPurchaseUpdatesResponseBuilder.getRequestStatus(), "requestStatus");
    if (RequestStatus.SUCCESSFUL == paramPurchaseUpdatesResponseBuilder.getRequestStatus())
    {
      d.a(paramPurchaseUpdatesResponseBuilder.getUserData(), "userData");
      d.a(paramPurchaseUpdatesResponseBuilder.getReceipts(), "receipts");
    }
    this.requestId = paramPurchaseUpdatesResponseBuilder.getRequestId();
    this.requestStatus = paramPurchaseUpdatesResponseBuilder.getRequestStatus();
    this.userData = paramPurchaseUpdatesResponseBuilder.getUserData();
    if (paramPurchaseUpdatesResponseBuilder.getReceipts() == null);
    for (Object localObject = new ArrayList(); ; localObject = paramPurchaseUpdatesResponseBuilder.getReceipts())
    {
      this.receipts = ((List)localObject);
      this.hasMore = paramPurchaseUpdatesResponseBuilder.hasMore();
      return;
    }
  }

  public List<Receipt> getReceipts()
  {
    return this.receipts;
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

  public boolean hasMore()
  {
    return this.hasMore;
  }

  public JSONObject toJSON()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("REQUEST_ID", this.requestId);
    localJSONObject.put("REQUEST_STATUS", this.requestStatus);
    if (this.userData != null);
    JSONArray localJSONArray;
    for (Object localObject = this.userData.toJSON(); ; localObject = "")
    {
      localJSONObject.put("USER_DATA", localObject);
      localJSONArray = new JSONArray();
      if (this.receipts == null)
        break;
      Iterator localIterator = this.receipts.iterator();
      while (localIterator.hasNext())
        localJSONArray.put(((Receipt)localIterator.next()).toJSON());
    }
    localJSONObject.put("RECEIPTS", localJSONArray);
    localJSONObject.put("HAS_MORE", this.hasMore);
    return localJSONObject;
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = super.toString();
    arrayOfObject[1] = this.requestId;
    arrayOfObject[2] = this.requestStatus;
    arrayOfObject[3] = this.userData;
    if (this.receipts != null);
    for (String str = Arrays.toString(this.receipts.toArray()); ; str = "null")
    {
      arrayOfObject[4] = str;
      arrayOfObject[5] = Boolean.valueOf(this.hasMore);
      return String.format("(%s, requestId: \"%s\", requestStatus: \"%s\", userData: \"%s\", receipts: %s, hasMore: \"%b\")", arrayOfObject);
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
 * Qualified Name:     com.amazon.device.iap.model.PurchaseUpdatesResponse
 * JD-Core Version:    0.6.2
 */