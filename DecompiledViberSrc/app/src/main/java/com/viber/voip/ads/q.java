package com.viber.voip.ads;

import android.net.Uri;

public abstract interface q
{
  public abstract a a(Uri paramUri);

  public static class a
  {
    public final String a;
    public final int b;

    public a(String paramString, int paramInt)
    {
      this.a = paramString;
      this.b = paramInt;
    }

    public String toString()
    {
      return "AdsResponse{data='" + this.a + '\'' + ", status=" + this.b + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.q
 * JD-Core Version:    0.6.2
 */