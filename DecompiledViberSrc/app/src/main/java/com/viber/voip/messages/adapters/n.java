package com.viber.voip.messages.adapters;

import android.content.res.Resources;
import com.viber.voip.ViberApplication;

public class n
  implements p
{
  protected int a;
  protected int b;
  protected int c;

  public n(int paramInt1, int paramInt2, int paramInt3)
  {
    this.c = paramInt1;
    this.a = paramInt2;
    this.b = paramInt3;
  }

  public String a()
  {
    String str = ViberApplication.getLocalizedResources().getString(this.c);
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(this.a);
    arrayOfObject[1] = Integer.valueOf(this.b);
    return String.format(str, arrayOfObject);
  }

  public int b()
  {
    return 2;
  }

  public int c()
  {
    return 0;
  }

  public long d()
  {
    return 0L;
  }

  public long e()
  {
    return 0L;
  }

  public int f()
  {
    return q.a(this);
  }

  public long i()
  {
    return 0L;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.adapters.n
 * JD-Core Version:    0.6.2
 */