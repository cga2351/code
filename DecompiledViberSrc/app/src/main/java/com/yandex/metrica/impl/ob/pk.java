package com.yandex.metrica.impl.ob;

public class pk
{
  private final pn a;
  private final pn b;
  private final ph c;
  private final of d;
  private final String e;

  public pk(int paramInt1, int paramInt2, int paramInt3, String paramString, of paramof)
  {
    this.c = new ph(paramInt1);
    this.a = new pn(paramInt2, paramString + "map key", paramof);
    this.b = new pn(paramInt3, paramString + "map value", paramof);
    this.e = paramString;
    this.d = paramof;
  }

  public pn a()
  {
    return this.a;
  }

  public void a(String paramString)
  {
    if (this.d.c())
    {
      of localof = this.d;
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = this.e;
      arrayOfObject[1] = Integer.valueOf(this.c.a());
      arrayOfObject[2] = paramString;
      localof.b("The %s has reached the limit of %d items. Item with key %s will be ignored", arrayOfObject);
    }
  }

  public pn b()
  {
    return this.b;
  }

  public ph c()
  {
    return this.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.pk
 * JD-Core Version:    0.6.2
 */