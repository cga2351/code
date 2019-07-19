package com.adjust.sdk;

import org.json.JSONObject;

public class AdjustEventFailure
{
  public String adid;
  public String callbackId;
  public String eventToken;
  public JSONObject jsonResponse;
  public String message;
  public String timestamp;
  public boolean willRetry;

  public String toString()
  {
    Object[] arrayOfObject = new Object[7];
    arrayOfObject[0] = this.message;
    arrayOfObject[1] = this.timestamp;
    arrayOfObject[2] = this.adid;
    arrayOfObject[3] = this.eventToken;
    arrayOfObject[4] = this.callbackId;
    arrayOfObject[5] = Boolean.valueOf(this.willRetry);
    arrayOfObject[6] = this.jsonResponse;
    return Util.formatString("Event Failure msg:%s time:%s adid:%s event:%s cid:%s retry:%b json:%s", arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.AdjustEventFailure
 * JD-Core Version:    0.6.2
 */