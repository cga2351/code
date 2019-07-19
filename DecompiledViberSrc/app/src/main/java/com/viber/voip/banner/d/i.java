package com.viber.voip.banner.d;

import android.content.ContentValues;
import android.text.format.DateFormat;

public class i extends d
{
  private long g;

  public g a()
  {
    return g.c;
  }

  public void c(long paramLong)
  {
    this.g = paramLong;
  }

  public ContentValues getContentValues()
  {
    ContentValues localContentValues = a.a(this);
    localContentValues.put("location", Long.toString(this.g));
    return localContentValues;
  }

  public String toString()
  {
    return "RemoteStickerClicker{, messageToken=" + this.a + ", endTime=" + DateFormat.format("dd-MM-yyyy kk:mm:ss", this.c) + ", meta=" + this.b + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.d.i
 * JD-Core Version:    0.6.2
 */