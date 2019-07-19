package com.viber.voip.banner.d;

import android.content.ContentValues;
import android.text.format.DateFormat;

public class f extends d
{
  c g;
  b h;

  public g a()
  {
    return g.a;
  }

  public void a(b paramb)
  {
    this.h = paramb;
  }

  public void a(c paramc)
  {
    this.g = paramc;
  }

  public ContentValues getContentValues()
  {
    return a.a(this);
  }

  public c h()
  {
    return this.g;
  }

  public b i()
  {
    return this.h;
  }

  public String toString()
  {
    return "RemoteBanner{position=" + this.g + ", location=" + this.h + ", messageToken=" + this.a + ", endTime=" + DateFormat.format("dd-MM-yyyy kk:mm:ss", this.c) + ", tag=" + this.d + ", isDummy=" + this.f + ", meta=" + this.b + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.d.f
 * JD-Core Version:    0.6.2
 */