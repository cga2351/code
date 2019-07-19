package com.appnexus.opensdk.ut.adresponse;

import java.util.ArrayList;

public class SSMHTMLAdResponse extends BaseAdResponse
{
  private String a;
  private int b;
  private String c;

  public SSMHTMLAdResponse(int paramInt1, int paramInt2, String paramString1, String paramString2, ArrayList<String> paramArrayList, String paramString3)
  {
    super(paramInt1, paramInt2, paramString1, paramArrayList, paramString3);
    this.c = paramString2;
  }

  public String getAdUrl()
  {
    return this.a;
  }

  public String getResponseURL()
  {
    return this.c;
  }

  public int getSsmTimeout()
  {
    return this.b;
  }

  public void setAdUrl(String paramString)
  {
    this.a = paramString;
  }

  public void setSsmTimeout(int paramInt)
  {
    this.b = paramInt;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.ut.adresponse.SSMHTMLAdResponse
 * JD-Core Version:    0.6.2
 */