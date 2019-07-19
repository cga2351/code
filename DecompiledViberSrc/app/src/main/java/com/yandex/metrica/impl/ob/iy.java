package com.yandex.metrica.impl.ob;

public class iy
{
  public final String a;
  public final boolean b;

  public iy(String paramString, boolean paramBoolean)
  {
    this.a = paramString;
    this.b = paramBoolean;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1;
    if (this == paramObject)
      bool1 = true;
    iy localiy;
    boolean bool2;
    boolean bool3;
    do
    {
      Class localClass1;
      Class localClass2;
      do
      {
        do
        {
          return bool1;
          bool1 = false;
        }
        while (paramObject == null);
        localClass1 = getClass();
        localClass2 = paramObject.getClass();
        bool1 = false;
      }
      while (localClass1 != localClass2);
      localiy = (iy)paramObject;
      bool2 = this.b;
      bool3 = localiy.b;
      bool1 = false;
    }
    while (bool2 != bool3);
    return this.a.equals(localiy.a);
  }

  public int hashCode()
  {
    int i = 31 * this.a.hashCode();
    if (this.b);
    for (int j = 1; ; j = 0)
      return j + i;
  }

  public String toString()
  {
    return "PermissionState{name='" + this.a + '\'' + ", granted=" + this.b + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.iy
 * JD-Core Version:    0.6.2
 */