package com.viber.voip.messages.extensions.ui;

import android.support.v4.util.SparseArrayCompat;
import com.viber.voip.messages.ui.aj;

public final class n
{
  private final aj a;
  private final SparseArrayCompat<m> b;

  public n(aj paramaj)
  {
    this.a = paramaj;
    this.b = new SparseArrayCompat(2);
  }

  public m a(int paramInt)
  {
    Object localObject = (m)this.b.get(paramInt);
    if (localObject == null)
      switch (paramInt)
      {
      default:
        localObject = new m.c(this.a);
      case 1:
      case 2:
      }
    while (true)
    {
      this.b.put(paramInt, localObject);
      return localObject;
      localObject = new m.d(this.a);
      continue;
      localObject = new m.a(this.a);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.ui.n
 * JD-Core Version:    0.6.2
 */