package com.viber.common.dialogs;

import android.content.Context;
import android.os.Bundle;
import com.viber.common.R.string;

public class h extends a
{
  private final String a;
  private final int b;
  private final int c;
  private final String d;
  private final boolean e;

  protected h(a<?> parama)
  {
    super(parama);
    this.a = a.a(parama);
    this.b = a.b(parama);
    this.c = a.c(parama);
    this.d = a.d(parama);
    this.e = a.e(parama);
  }

  public static a<?> j()
  {
    return new a();
  }

  protected void b(Bundle paramBundle)
  {
    paramBundle.putString("positive_button", this.a);
    paramBundle.putInt("positive_button_id", this.b);
    paramBundle.putInt("positive_action_request_code", this.c);
    paramBundle.putString("analytics_positive_button", this.d);
    paramBundle.putBoolean("disable_dismiss_on_positive_button", this.e);
    super.b(paramBundle);
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool3;
    if (this == paramObject)
      bool3 = bool1;
    h localh;
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
          bool2 = paramObject instanceof h;
          bool3 = false;
        }
        while (!bool2);
        bool4 = super.equals(paramObject);
        bool3 = false;
      }
      while (!bool4);
      localh = (h)paramObject;
      i = this.b;
      j = localh.b;
      bool3 = false;
    }
    while (i != j);
    if (this.a != null)
      bool1 = this.a.equals(localh.a);
    while (true)
    {
      return bool1;
      if (localh.a != null)
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

  public a<?> i()
  {
    return new a(this);
  }

  public static class a<T extends a<T>> extends a.a<T>
  {
    private String a;
    private int b = -1;
    private int c;
    private String d;
    private boolean e = false;

    protected a()
    {
    }

    protected a(h paramh)
    {
      super();
      this.a = h.a(paramh);
      this.b = h.b(paramh);
      this.c = h.c(paramh);
      this.d = h.d(paramh);
      this.e = h.e(paramh);
    }

    protected void a()
    {
      super.a();
      i(R.string.dialog_button_ok);
      j(-1);
      e("Ok");
    }

    public T b(int paramInt, String paramString)
    {
      this.b = paramInt;
      return d(paramString);
    }

    public T c(int paramInt1, int paramInt2)
    {
      this.b = paramInt1;
      return i(paramInt2);
    }

    public T d(String paramString)
    {
      this.a = paramString;
      return (a)b();
    }

    public T e(String paramString)
    {
      this.d = paramString;
      return (a)b();
    }

    public T g()
    {
      b(-1, null);
      return (a)super.c();
    }

    public T h()
    {
      this.e = true;
      return (a)b();
    }

    public T i(int paramInt)
    {
      return d(y.a().getString(paramInt));
    }

    h i()
    {
      return new h(this);
    }

    public T j(int paramInt)
    {
      this.c = paramInt;
      return (a)b();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.dialogs.h
 * JD-Core Version:    0.6.2
 */