package com.adjust.sdk;

import org.json.JSONObject;

public class AdjustEventSuccess
{
  public String adid;
  public String callbackId;
  public String eventToken;
  public JSONObject jsonResponse;
  public String message;
  public String timestamp;

  public String toString()
  {
    Object[] arrayOfObject = new Object[6];
    arrayOfObject[0] = this.message;
    arrayOfObject[1] = this.timestamp;
    arrayOfObject[2] = this.adid;
    arrayOfObject[3] = this.eventToken;
    arrayOfObject[4] = this.callbackId;
    arrayOfObject[5] = this.jsonResponse;
    return Util.formatString("Event Success msg:%s time:%s adid:%s event:%s cid:%s json:%s", arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.AdjustEventSuccess
 * JD-Core Version:    0.6.2
 */