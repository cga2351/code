package com.viber.voip.api.a.b.a;

import java.util.Arrays;

public class m
{

  @com.google.d.a.c(a="country")
  private c a;

  @com.google.d.a.c(a="destinations")
  private a[] b;

  public c a()
  {
    return this.a;
  }

  public a[] b()
  {
    return this.b;
  }

  public String toString()
  {
    return "Rate{country=" + this.a + ", destinations=" + Arrays.toString(this.b) + '}';
  }

  public static class a
  {

    @com.google.d.a.c(a="name")
    private String a;

    @com.google.d.a.c(a="type")
    private String b;

    @com.google.d.a.c(a="rate")
    private l c;

    public String a()
    {
      return this.a;
    }

    public String b()
    {
      return this.b;
    }

    public l c()
    {
      return this.c;
    }

    public String toString()
    {
      return "Destination{name='" + this.a + '\'' + ", type='" + this.b + '\'' + ", rate=" + this.c + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.api.a.b.a.m
 * JD-Core Version:    0.6.2
 */