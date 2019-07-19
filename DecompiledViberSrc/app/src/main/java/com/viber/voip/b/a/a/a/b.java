package com.viber.voip.b.a.a.a;

import android.graphics.Bitmap;
import com.viber.voip.util.e.j;

public class b
{
  private int a;
  private Bitmap b;
  private String c;
  private int d;

  public b(Bitmap paramBitmap, String paramString)
  {
    this.c = paramString;
    this.b = paramBitmap;
    this.d = j.d(paramBitmap);
  }

  public Bitmap a()
  {
    return this.b;
  }

  public void b()
  {
    this.a = (1 + this.a);
  }

  public int c()
  {
    return this.d;
  }

  public void d()
  {
    this.a = (-1 + this.a);
    if ((this.b != null) && (this.a <= 0))
    {
      j.c(this.b);
      this.b = null;
    }
  }

  public String toString()
  {
    return this.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.b.a.a.a.b
 * JD-Core Version:    0.6.2
 */