package com.viber.voip.banner.d;

import android.content.ContentValues;
import android.text.format.DateFormat;

public class e extends f
{
  public g a()
  {
    return g.d;
  }

  public ContentValues getContentValues()
  {
    return a.a(this);
  }

  public String toString()
  {
    return "RemoteAdsAfterCall{, messageToken=" + this.a + ", endTime=" + DateFormat.format("dd-MM-yyyy kk:mm:ss", this.c) + ", meta=" + this.b + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.d.e
 * JD-Core Version:    0.6.2
 */