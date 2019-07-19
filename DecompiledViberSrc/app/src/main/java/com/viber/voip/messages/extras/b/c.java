package com.viber.voip.messages.extras.b;

import android.location.Address;

public class c
{
  public Address a;
  public String b;

  public c(Address paramAddress, String paramString)
  {
    this.a = paramAddress;
    this.b = paramString;
  }

  public String toString()
  {
    return "LocationData [address = " + this.a.toString() + ", addressString = " + this.b + "]";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extras.b.c
 * JD-Core Version:    0.6.2
 */