package com.amazon.device.iap.model;

import com.amazon.device.iap.internal.model.UserDataResponseBuilder;
import com.amazon.device.iap.internal.util.d;
import org.json.JSONException;
import org.json.JSONObject;

public final class UserDataResponse
{
  private static final String REQUEST_ID = "REQUEST_ID";
  private static final String REQUEST_STATUS = "REQUEST_STATUS";
  private static final String TO_STRING_FORMAT = "(%s, requestId: \"%s\", requestStatus: \"%s\", userData: \"%s\")";
  private static final String USER_DATA = "USER_DATA";
  private final RequestId requestId;
  private final RequestStatus requestStatus;
  private final UserData userData;

  public UserDataResponse(UserDataResponseBuilder paramUserDataResponseBuilder)
  {
    d.a(paramUserDataResponseBuilder.getRequestId(), "requestId");
    d.a(paramUserDataResponseBuilder.getRequestStatus(), "requestStatus");
    this.requestId = paramUserDataResponseBuilder.getRequestId();
    this.requestStatus = paramUserDataResponseBuilder.getRequestStatus();
    this.userData = paramUserDataResponseBuilder.getUserData();
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
    localJSONObject.put("REQUEST_ID", this.requestId);
    localJSONObject.put("REQUEST_STATUS", this.requestStatus);
    if (this.userData != null);
    for (Object localObject = this.userData.toJSON(); ; localObject = "")
    {
      localJSONObject.put("USER_DATA", localObject);
      return localJSONObject;
    }
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = super.toString();
    arrayOfObject[1] = this.requestId;
    String str1;
    if (this.requestStatus != null)
    {
      str1 = this.requestStatus.toString();
      arrayOfObject[2] = str1;
      if (this.userData == null)
        break label70;
    }
    label70: for (String str2 = this.userData.toString(); ; str2 = "null")
    {
      arrayOfObject[3] = str2;
      return String.format("(%s, requestId: \"%s\", requestStatus: \"%s\", userData: \"%s\")", arrayOfObject);
      str1 = "null";
      break;
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
 * Qualified Name:     com.amazon.device.iap.model.UserDataResponse
 * JD-Core Version:    0.6.2
 */