package com.yandex.metrica.impl.ob;

public class pn extends pf<String>
{
  public pn(int paramInt, String paramString)
  {
    this(paramInt, paramString, of.g());
  }

  public pn(int paramInt, String paramString, of paramof)
  {
    super(paramInt, paramString, paramof);
  }

  public String a(String paramString)
  {
    if ((paramString != null) && (paramString.length() > a()))
    {
      String str = paramString.substring(0, a());
      if (this.a.c())
      {
        of localof = this.a;
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = b();
        arrayOfObject[1] = paramString;
        arrayOfObject[2] = Integer.valueOf(a());
        localof.b("\"%s\" %s size exceeded limit of %d characters", arrayOfObject);
      }
      paramString = str;
    }
    return paramString;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.pn
 * JD-Core Version:    0.6.2
 */