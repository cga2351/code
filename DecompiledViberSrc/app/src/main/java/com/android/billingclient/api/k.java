package com.android.billingclient.api;

import java.util.ArrayList;
import java.util.List;

public class k
{
  private String a;
  private List<String> b;

  public static a c()
  {
    return new a(null);
  }

  public String a()
  {
    return this.a;
  }

  public List<String> b()
  {
    return this.b;
  }

  public static class a
  {
    private String a;
    private List<String> b;

    public a a(String paramString)
    {
      this.a = paramString;
      return this;
    }

    public a a(List<String> paramList)
    {
      this.b = new ArrayList(paramList);
      return this;
    }

    public k a()
    {
      k localk = new k();
      k.a(localk, this.a);
      k.a(localk, this.b);
      return localk;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.android.billingclient.api.k
 * JD-Core Version:    0.6.2
 */