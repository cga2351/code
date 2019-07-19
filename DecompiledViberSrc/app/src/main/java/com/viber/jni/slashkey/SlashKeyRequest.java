package com.viber.jni.slashkey;

import java.util.HashMap;
import java.util.Map;

public class SlashKeyRequest
{
  private String category;
  private String country;
  private Map<String, String> extraParameters;
  private String lang;
  private Double latitude;
  private Double longitude;
  private String near;
  private String query;

  public String getCategory()
  {
    return this.category;
  }

  public String getCountry()
  {
    return this.country;
  }

  public Map<String, String> getExtraParams()
  {
    return this.extraParameters;
  }

  public String getLang()
  {
    return this.lang;
  }

  public double getLatitude()
  {
    if (this.latitude == null)
      return 0.0D;
    return this.latitude.doubleValue();
  }

  public double getLongitude()
  {
    if (this.longitude == null)
      return 0.0D;
    return this.longitude.doubleValue();
  }

  public String getNear()
  {
    return this.near;
  }

  public String getQuery()
  {
    return this.query;
  }

  public void setCategory(String paramString)
  {
    this.category = paramString;
  }

  public void setCountry(String paramString)
  {
    this.country = paramString;
  }

  public void setExtraParam(String paramString1, String paramString2)
  {
    if (this.extraParameters == null)
      this.extraParameters = new HashMap();
    this.extraParameters.put(paramString1, paramString2);
  }

  public void setExtraParams(Map<String, String> paramMap)
  {
    this.extraParameters = paramMap;
  }

  public void setLang(String paramString)
  {
    this.lang = paramString;
  }

  public void setLatitude(double paramDouble)
  {
    this.latitude = Double.valueOf(paramDouble);
  }

  public void setLongitude(double paramDouble)
  {
    this.longitude = Double.valueOf(paramDouble);
  }

  public void setNear(String paramString)
  {
    this.near = paramString;
  }

  public void setQuery(String paramString)
  {
    this.query = paramString;
  }

  public String toString()
  {
    return "SlashKeyRequest{query='" + this.query + '\'' + ", category='" + this.category + '\'' + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", near='" + this.near + '\'' + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.slashkey.SlashKeyRequest
 * JD-Core Version:    0.6.2
 */