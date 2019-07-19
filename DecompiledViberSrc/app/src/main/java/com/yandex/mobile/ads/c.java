package com.yandex.mobile.ads;

import android.content.Context;
import com.yandex.mobile.ads.impl.aj;
import com.yandex.mobile.ads.impl.aj.a;
import java.io.Serializable;

public abstract class c
  implements Serializable
{
  private static final long serialVersionUID = -7571518881522543353L;
  private final aj a;

  protected c(int paramInt1, int paramInt2, aj.a parama)
  {
    this.a = new aj(paramInt1, paramInt2, parama);
  }

  final aj a()
  {
    return this.a;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
      return false;
    c localc = (c)paramObject;
    return this.a.equals(localc.a);
  }

  public int getHeight()
  {
    return this.a.b();
  }

  public int getHeight(Context paramContext)
  {
    return this.a.a(paramContext);
  }

  public int getHeightInPixels(Context paramContext)
  {
    return this.a.c(paramContext);
  }

  public int getWidth()
  {
    return this.a.a();
  }

  public int getWidth(Context paramContext)
  {
    return this.a.b(paramContext);
  }

  public int getWidthInPixels(Context paramContext)
  {
    return this.a.d(paramContext);
  }

  public int hashCode()
  {
    return this.a.hashCode();
  }

  public String toString()
  {
    return this.a.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.c
 * JD-Core Version:    0.6.2
 */