package com.viber.voip.videoconvert.gpu.a;

import android.os.Build;

public class a
{
  private String a = new String();
  private String b = new String();

  public a()
  {
    this.a = Build.MANUFACTURER;
    this.b = Build.DEVICE;
  }

  public a(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }

  public boolean equals(Object paramObject)
  {
    a locala = (a)paramObject;
    return (locala != null) && (this.a.equalsIgnoreCase(locala.a)) && (this.b.equalsIgnoreCase(locala.b));
  }

  public String toString()
  {
    return "(manufacturer=" + this.a + ", deviceName=" + this.b + ")";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.gpu.a.a
 * JD-Core Version:    0.6.2
 */