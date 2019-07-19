package com.viber.voip.banner.d;

import android.content.ContentValues;
import android.text.format.DateFormat;

public class h extends d
{
  j g;

  public g a()
  {
    return g.b;
  }

  public void a(j paramj)
  {
    this.g = paramj;
  }

  public ContentValues getContentValues()
  {
    return a.a(this);
  }

  public j h()
  {
    return this.g;
  }

  public String toString()
  {
    return "RemoteSplash{location=" + this.g + ", messageToken=" + this.a + ", endTime=" + DateFormat.format("dd-MM-yyyy kk:mm:ss", this.c) + ", tag=" + this.d + ", isDummy=" + this.f + ", meta=" + this.b + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.d.h
 * JD-Core Version:    0.6.2
 */