package com.viber.voip.api.a.b.a;

import com.google.d.a.c;
import java.util.Arrays;

public class g
{

  @c(a="status")
  private int a;

  @c(a="plans")
  private j[] b;

  @c(a="credits")
  private d[] c;

  @c(a="rates")
  private m[] d;

  public int a()
  {
    return this.a;
  }

  public j[] b()
  {
    return this.b;
  }

  public d[] c()
  {
    return this.c;
  }

  public m[] d()
  {
    return this.d;
  }

  public String toString()
  {
    return "GetProductsResponse{status=" + this.a + ", plans=" + Arrays.toString(this.b) + ", credits=" + Arrays.toString(this.c) + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.api.a.b.a.g
 * JD-Core Version:    0.6.2
 */