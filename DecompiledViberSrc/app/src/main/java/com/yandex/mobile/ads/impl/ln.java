package com.yandex.mobile.ads.impl;

public class ln
{
  private String a;
  private boolean b;

  public final String a()
  {
    return this.a;
  }

  public final void a(String paramString)
  {
    this.a = paramString;
  }

  public final void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    ln localln;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localln = (ln)paramObject;
      if (this.b != localln.b)
        return false;
      if (this.a != null)
        return this.a.equals(localln.a);
    }
    while (localln.a == null);
    return false;
  }

  public int hashCode()
  {
    if (this.a != null);
    for (int i = this.a.hashCode(); ; i = 0)
    {
      int j = i * 31;
      boolean bool = this.b;
      int k = 0;
      if (bool)
        k = 1;
      return j + k;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.ln
 * JD-Core Version:    0.6.2
 */