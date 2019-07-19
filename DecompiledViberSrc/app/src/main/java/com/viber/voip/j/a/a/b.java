package com.viber.voip.j.a.a;

import com.google.d.a.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class b
{

  @c(a="ab_size_all")
  private final int a;

  @c(a="ab_size_viber")
  private final int b;

  @c(a="ab_size_email_phone")
  private final int c;

  @c(a="ab_size_viber_email_phone")
  private final int d;

  @c(a="ab_size_email")
  private final int e;

  public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramInt5;
  }

  public final boolean a()
  {
    return (this.a >= 0) && (this.b >= 0) && (this.c >= 0) && (this.d >= 0) && (this.e >= 0);
  }

  public final int b()
  {
    return this.c;
  }

  public final int c()
  {
    return this.e;
  }

  public boolean equals(@Nullable Object paramObject)
  {
    boolean bool1;
    int i;
    int j;
    label59: int k;
    label81: int m;
    if (this != paramObject)
    {
      boolean bool2 = paramObject instanceof b;
      bool1 = false;
      if (!bool2)
        break label134;
      b localb = (b)paramObject;
      if (this.a != localb.a)
        break label136;
      i = 1;
      bool1 = false;
      if (i == 0)
        break label134;
      if (this.b != localb.b)
        break label142;
      j = 1;
      bool1 = false;
      if (j == 0)
        break label134;
      if (this.c != localb.c)
        break label148;
      k = 1;
      bool1 = false;
      if (k == 0)
        break label134;
      if (this.d != localb.d)
        break label154;
      m = 1;
      label103: bool1 = false;
      if (m == 0)
        break label134;
      if (this.e != localb.e)
        break label160;
    }
    label134: label136: label142: label148: label154: label160: for (int n = 1; ; n = 0)
    {
      bool1 = false;
      if (n != 0)
        bool1 = true;
      return bool1;
      i = 0;
      break;
      j = 0;
      break label59;
      k = 0;
      break label81;
      m = 0;
      break label103;
    }
  }

  public int hashCode()
  {
    return 31 * (31 * (31 * (31 * Integer.hashCode(this.a) + Integer.hashCode(this.b)) + Integer.hashCode(this.c)) + Integer.hashCode(this.d)) + Integer.hashCode(this.e);
  }

  @NotNull
  public String toString()
  {
    return "EmailsAbStatisticsData(allContactsCount=" + this.a + ", viberContacts=" + this.b + ", emailsWithPhone=" + this.c + ", viberContactsWithEmailAndPhone=" + this.d + ", emailsWithoutPhone=" + this.e + ")";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.j.a.a.b
 * JD-Core Version:    0.6.2
 */