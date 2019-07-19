package com.iab.a.a.a.a;

import com.iab.a.b;
import com.iab.a.b.d;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class a
  implements com.iab.a.a.a
{
  private final com.iab.a.a a;

  public a(com.iab.a.a parama)
  {
    this.a = parama;
  }

  private boolean c(int paramInt)
  {
    int i = this.a.a(174, 12);
    int j = k();
    int k = 186;
    for (int m = 0; m < i; m++)
    {
      boolean bool = this.a.a(k);
      int n = k + 1;
      if (bool)
      {
        int i2 = this.a.a(n, 16);
        int i3 = n + 16;
        int i4 = this.a.a(i3, 16);
        k = i3 + 16;
        if ((i2 > i4) || (i4 > j))
          throw new d("Start VendorId must not be greater than End VendorId and End VendorId must not be greater than Max Vendor Id");
        if ((paramInt >= i2) && (paramInt <= i4))
          return true;
      }
      else
      {
        int i1 = this.a.a(n, 16);
        k = n + 16;
        if (i1 > j)
          throw new d("VendorId in the range entries must not be greater than Max VendorId");
        if (i1 == paramInt)
          return true;
      }
    }
    return false;
  }

  private int l()
  {
    return this.a.a(172, 1);
  }

  public long a()
  {
    return this.a.c(6, 36);
  }

  public boolean a(int paramInt)
  {
    int i = 1;
    int j = k();
    if ((paramInt < i) || (paramInt > j))
      i = 0;
    boolean bool;
    do
    {
      return i;
      if (l() != i)
        break;
      bool = this.a.a(173);
    }
    while (c(paramInt) != bool);
    return false;
    return this.a.a(-1 + (paramInt + 173));
  }

  public boolean a(b paramb)
  {
    return b(paramb.a());
  }

  public boolean b(int paramInt)
  {
    if ((paramInt < 1) || (paramInt > 24))
      return false;
    return this.a.a(-1 + (paramInt + 132));
  }

  public byte[] b()
  {
    return this.a.a();
  }

  public int c()
  {
    return this.a.a(0, 6);
  }

  public long d()
  {
    return this.a.c(42, 36);
  }

  public int e()
  {
    return this.a.a(78, 12);
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
      return false;
    a locala = (a)paramObject;
    return Arrays.equals(this.a.a(), locala.a.a());
  }

  public int f()
  {
    return this.a.a(90, 12);
  }

  public int g()
  {
    return this.a.a(102, 6);
  }

  public String h()
  {
    return this.a.d(108, 12);
  }

  public int hashCode()
  {
    return Arrays.hashCode(this.a.a());
  }

  public int i()
  {
    return this.a.a(120, 12);
  }

  public Set<Integer> j()
  {
    HashSet localHashSet = new HashSet();
    for (int i = 132; i < 156; i++)
      if (this.a.a(i))
        localHashSet.add(Integer.valueOf(1 + (i - 132)));
    return localHashSet;
  }

  public int k()
  {
    return this.a.a(156, 16);
  }

  public String toString()
  {
    return "ByteBufferVendorConsent{Version=" + c() + ",Created=" + a() + ",LastUpdated=" + d() + ",CmpId=" + e() + ",CmpVersion=" + f() + ",ConsentScreen=" + g() + ",ConsentLanguage=" + h() + ",VendorListVersion=" + i() + ",PurposesAllowed=" + j() + ",MaxVendorId=" + k() + ",EncodingType=" + l() + "}";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.a.a.a.a.a
 * JD-Core Version:    0.6.2
 */