package com.google.firebase.components;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;

@KeepForSdk
public final class n
{
  private final Class<?> a;
  private final int b;
  private final int c;

  private n(Class<?> paramClass, int paramInt1, int paramInt2)
  {
    this.a = ((Class)Preconditions.checkNotNull(paramClass, "Null dependency anInterface."));
    this.b = paramInt1;
    this.c = paramInt2;
  }

  @KeepForSdk
  public static n a(Class<?> paramClass)
  {
    return new n(paramClass, 1, 0);
  }

  @KeepForSdk
  public static n b(Class<?> paramClass)
  {
    return new n(paramClass, 2, 0);
  }

  public Class<?> a()
  {
    return this.a;
  }

  public boolean b()
  {
    return this.b == 1;
  }

  public boolean c()
  {
    return this.b == 2;
  }

  public boolean d()
  {
    return this.c == 0;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof n;
    boolean bool2 = false;
    if (bool1)
    {
      n localn = (n)paramObject;
      Class localClass1 = this.a;
      Class localClass2 = localn.a;
      bool2 = false;
      if (localClass1 == localClass2)
      {
        int i = this.b;
        int j = localn.b;
        bool2 = false;
        if (i == j)
        {
          int k = this.c;
          int m = localn.c;
          bool2 = false;
          if (k == m)
            bool2 = true;
        }
      }
    }
    return bool2;
  }

  public int hashCode()
  {
    return 1000003 * (1000003 * (0xF4243 ^ this.a.hashCode()) ^ this.b) ^ this.c;
  }

  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("Dependency{anInterface=").append(this.a).append(", type=");
    String str;
    StringBuilder localStringBuilder2;
    if (this.b == 1)
    {
      str = "required";
      localStringBuilder2 = localStringBuilder1.append(str).append(", direct=");
      if (this.c != 0)
        break label88;
    }
    label88: for (boolean bool = true; ; bool = false)
    {
      return bool + "}";
      if (this.b == 0)
      {
        str = "optional";
        break;
      }
      str = "set";
      break;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.components.n
 * JD-Core Version:    0.6.2
 */