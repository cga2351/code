package com.appnexus.opensdk.ut.adresponse;

import java.util.ArrayList;

public class CSMSDKAdResponse extends BaseAdResponse
{
  private String a;
  private String b;
  private String c;
  private String d;

  public CSMSDKAdResponse(int paramInt1, int paramInt2, String paramString1, String paramString2, ArrayList<String> paramArrayList, String paramString3)
  {
    super(paramInt1, paramInt2, paramString1, paramArrayList, paramString3);
    this.d = paramString2;
  }

  public String getClassName()
  {
    return this.b;
  }

  public String getId()
  {
    return this.a;
  }

  public String getParam()
  {
    return this.c;
  }

  public String getResponseUrl()
  {
    return this.d;
  }

  public void setClassName(String paramString)
  {
    this.b = paramString;
  }

  public void setId(String paramString)
  {
    this.a = paramString;
  }

  public void setParam(String paramString)
  {
    this.c = paramString;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.ut.adresponse.CSMSDKAdResponse
 * JD-Core Version:    0.6.2
 */