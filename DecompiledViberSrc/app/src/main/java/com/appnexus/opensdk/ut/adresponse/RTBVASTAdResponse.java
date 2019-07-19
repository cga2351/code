package com.appnexus.opensdk.ut.adresponse;

import java.util.ArrayList;

public class RTBVASTAdResponse extends BaseAdResponse
{
  private String a;

  public RTBVASTAdResponse(int paramInt1, int paramInt2, String paramString1, String paramString2, ArrayList<String> paramArrayList, String paramString3)
  {
    super(paramInt1, paramInt2, paramString1, paramArrayList, paramString3);
    this.a = paramString2;
  }

  public String getNotifyUrl()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.ut.adresponse.RTBVASTAdResponse
 * JD-Core Version:    0.6.2
 */