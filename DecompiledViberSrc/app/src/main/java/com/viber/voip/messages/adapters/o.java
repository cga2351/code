package com.viber.voip.messages.adapters;

import android.app.Application;
import android.content.res.Resources;
import com.viber.voip.ViberApplication;

public class o
  implements p
{
  protected int a;
  protected int b;

  public o(int paramInt1, int paramInt2)
  {
    this.b = paramInt1;
    this.a = paramInt2;
  }

  public String a()
  {
    Resources localResources = ViberApplication.getApplication().getResources();
    int i = this.b;
    int j = this.a;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(this.a);
    return localResources.getQuantityString(i, j, arrayOfObject);
  }

  public int b()
  {
    return 3;
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
 * Qualified Name:     com.viber.voip.messages.adapters.o
 * JD-Core Version:    0.6.2
 */