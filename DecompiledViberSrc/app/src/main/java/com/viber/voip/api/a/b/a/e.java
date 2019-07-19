package com.viber.voip.api.a.b.a;

import com.google.d.a.c;
import java.util.Arrays;

public class e
{

  @c(a="status")
  private int a;

  @c(a="credit")
  private l b;

  @c(a="plans")
  private b[] c;

  public int a()
  {
    return this.a;
  }

  public l b()
  {
    return this.b;
  }

  public b[] c()
  {
    return this.c;
  }

  public String toString()
  {
    return "GetBalanceResponse{status=" + this.a + ", credit=" + this.b + ", plans=" + Arrays.toString(this.c) + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.api.a.b.a.e
 * JD-Core Version:    0.6.2
 */