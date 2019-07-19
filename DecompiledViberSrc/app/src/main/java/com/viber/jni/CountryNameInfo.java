package com.viber.jni;

public class CountryNameInfo
{
  public final String countryName;
  public final String countryShortName;

  private CountryNameInfo(String paramString1, String paramString2)
  {
    this.countryName = paramString1;
    this.countryShortName = paramString2;
  }

  public String toString()
  {
    return "CountryNameInfo [countryName=" + this.countryName + ", countryShortName=" + this.countryShortName + "]";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.CountryNameInfo
 * JD-Core Version:    0.6.2
 */