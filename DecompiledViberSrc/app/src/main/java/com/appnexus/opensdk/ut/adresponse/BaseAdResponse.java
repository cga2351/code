package com.appnexus.opensdk.ut.adresponse;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class BaseAdResponse
{
  private int a;
  private int b;
  private String c = "";
  private String d;
  private String e;
  private String f;
  private ArrayList<String> g = new ArrayList();
  private HashMap<String, Object> h = new HashMap();

  public BaseAdResponse(int paramInt1, int paramInt2, String paramString1, ArrayList<String> paramArrayList, String paramString2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.d = paramString1;
    this.c = paramString2;
    this.g = paramArrayList;
  }

  public void addToExtras(String paramString, Object paramObject)
  {
    this.h.put(paramString, paramObject);
  }

  public String getAdContent()
  {
    return this.f;
  }

  public String getAdType()
  {
    return this.d;
  }

  public String getContentSource()
  {
    return this.e;
  }

  public String getCreativeId()
  {
    return this.c;
  }

  public HashMap<String, Object> getExtras()
  {
    return this.h;
  }

  public int getHeight()
  {
    return this.b;
  }

  public ArrayList<String> getImpressionURLs()
  {
    return this.g;
  }

  public int getWidth()
  {
    return this.a;
  }

  public void setAdContent(String paramString)
  {
    this.f = paramString;
  }

  public void setAdType(String paramString)
  {
    this.d = paramString;
  }

  public void setContentSource(String paramString)
  {
    this.e = paramString;
  }

  public void setCreativeId(String paramString)
  {
    this.c = paramString;
  }

  public void setExtras(HashMap<String, Object> paramHashMap)
  {
    this.h = paramHashMap;
  }

  public void setHeight(int paramInt)
  {
    this.b = paramInt;
  }

  public void setImpressionURLs(ArrayList<String> paramArrayList)
  {
    this.g = paramArrayList;
  }

  public void setWidth(int paramInt)
  {
    this.a = paramInt;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.ut.adresponse.BaseAdResponse
 * JD-Core Version:    0.6.2
 */