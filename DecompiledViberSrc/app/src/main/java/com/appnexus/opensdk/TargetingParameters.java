package com.appnexus.opensdk;

import android.location.Location;
import android.util.Pair;
import java.util.ArrayList;

public class TargetingParameters
{
  private String a = null;
  private String b = null;
  private ArrayList<Pair<String, String>> c = new ArrayList();
  private AdView.GENDER d = AdView.GENDER.UNKNOWN;
  private Location e = null;

  TargetingParameters()
  {
  }

  public TargetingParameters(String paramString1, AdView.GENDER paramGENDER, ArrayList<Pair<String, String>> paramArrayList, Location paramLocation, String paramString2)
  {
    this.a = paramString1;
    this.d = paramGENDER;
    this.c = paramArrayList;
    this.e = paramLocation;
    this.b = paramString2;
  }

  public String getAge()
  {
    return this.a;
  }

  public ArrayList<Pair<String, String>> getCustomKeywords()
  {
    return this.c;
  }

  public String getExternalUid()
  {
    return this.b;
  }

  public AdView.GENDER getGender()
  {
    return this.d;
  }

  public Location getLocation()
  {
    return this.e;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.TargetingParameters
 * JD-Core Version:    0.6.2
 */