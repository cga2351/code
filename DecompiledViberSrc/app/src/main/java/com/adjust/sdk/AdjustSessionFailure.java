package com.adjust.sdk;

import org.json.JSONObject;

public class AdjustSessionFailure
{
  public String adid;
  public JSONObject jsonResponse;
  public String message;
  public String timestamp;
  public boolean willRetry;

  public String toString()
  {
    Object[] arrayOfObject = new Object[5];
    arrayOfObject[0] = this.message;
    arrayOfObject[1] = this.timestamp;
    arrayOfObject[2] = this.adid;
    arrayOfObject[3] = Boolean.valueOf(this.willRetry);
    arrayOfObject[4] = this.jsonResponse;
    return Util.formatString("Session Failure msg:%s time:%s adid:%s retry:%b json:%s", arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adjust.sdk.AdjustSessionFailure
 * JD-Core Version:    0.6.2
 */