package com.viber.common.dialogs;

import android.content.Context;
import android.os.Bundle;

public class k extends l
{
  private final String a;
  private final int b;
  private final int c;
  private final String d;
  private final boolean e;

  protected k(a<?> parama)
  {
    super(parama);
    this.a = a.a(parama);
    this.b = a.b(parama);
    this.c = a.c(parama);
    this.d = a.d(parama);
    this.e = a.e(parama);
  }

  public static a<?> l()
  {
    return new a();
  }

  protected void b(Bundle paramBundle)
  {
    paramBundle.putString("neutral_button", this.a);
    paramBundle.putInt("neutral_button_id", this.b);
    paramBundle.putInt("neutral_action_request_code", this.c);
    paramBundle.putString("analytics_neutral_button", this.d);
    paramBundle.putBoolean("disable_dismiss_on_neutral_button", this.e);
    super.b(paramBundle);
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool3;
    if (this == paramObject)
      bool3 = bool1;
    k localk;
    int i;
    int j;
    do
    {
      boolean bool4;
      do
      {
        boolean bool2;
        do
        {
          return bool3;
          bool2 = paramObject instanceof k;
          bool3 = false;
        }
        while (!bool2);
        bool4 = super.equals(paramObject);
        bool3 = false;
      }
      while (!bool4);
      localk = (k)paramObject;
      i = this.b;
      j = localk.b;
      bool3 = false;
    }
    while (i != j);
    if (this.a != null)
      bool1 = this.a.equals(localk.a);
    while (true)
    {
      return bool1;
      if (localk.a != null)
        bool1 = false;
    }
  }

  public int hashCode()
  {
    int i = 31 * super.hashCode();
    if (this.a != null);
    for (int j = this.a.hashCode(); ; j = 0)
      return 31 * (j + i) + this.b;
  }

  public a<?> k()
  {
    return new a(this);
  }

  public static class a<T extends a<T>> extends l.a<T>
  {
    private String a;
    private int b = -1;
    private int c;
    private String d;
    private boolean e = false;

    protected a()
    {
    }

    protected a(k paramk)
    {
      super();
      this.a = k.a(paramk);
      this.b = k.b(paramk);
      this.c = k.c(paramk);
      this.d = k.d(paramk);
      this.e = k.e(paramk);
    }

    protected void a()
    {
      super.a();
      l(-3);
    }

    public T c(int paramInt, String paramString)
    {
      this.b = paramInt;
      return f(paramString);
    }

    public T d(int paramInt1, int paramInt2)
    {
      this.b = paramInt1;
      return k(paramInt2);
    }

    public T f(String paramString)
    {
      this.a = paramString;
      return (a)b();
    }

    public T g(String paramString)
    {
      this.d = paramString;
      return (a)b();
    }

    public T j()
    {
      c(-1, null);
      return (a)super.n();
    }

    public T k()
    {
      this.e = true;
      return (a)b();
    }

    public T k(int paramInt)
    {
      return f(y.a().getString(paramInt));
    }

    public T l(int paramInt)
    {
      this.c = paramInt;
      return (a)b();
    }

    k l()
    {
      return new k(this);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.dialogs.k
 * JD-Core Version:    0.6.2
 */