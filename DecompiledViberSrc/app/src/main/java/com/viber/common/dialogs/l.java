package com.viber.common.dialogs;

import android.content.Context;
import android.os.Bundle;
import com.viber.common.R.string;

public class l extends h
{
  private final String a;
  private final int b;
  private final int c;
  private final String d;
  private final boolean e;

  protected l(a<?> parama)
  {
    super(parama);
    this.a = a.a(parama);
    this.b = a.b(parama);
    this.c = a.c(parama);
    this.d = a.d(parama);
    this.e = a.e(parama);
  }

  public static a<?> n()
  {
    return new a();
  }

  protected void b(Bundle paramBundle)
  {
    paramBundle.putString("negative_button", this.a);
    paramBundle.putInt("negative_button_id", this.b);
    paramBundle.putInt("negative_action_request_code", this.c);
    paramBundle.putString("analytics_negative_button", this.d);
    paramBundle.putBoolean("disable_dismiss_on_negative_button", this.e);
    super.b(paramBundle);
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool3;
    if (this == paramObject)
      bool3 = bool1;
    l locall;
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
          bool2 = paramObject instanceof l;
          bool3 = false;
        }
        while (!bool2);
        bool4 = super.equals(paramObject);
        bool3 = false;
      }
      while (!bool4);
      locall = (l)paramObject;
      i = this.b;
      j = locall.b;
      bool3 = false;
    }
    while (i != j);
    if (this.a != null)
      bool1 = this.a.equals(locall.a);
    while (true)
    {
      return bool1;
      if (locall.a != null)
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

  public a<?> m()
  {
    return new a(this);
  }

  public static class a<T extends a<T>> extends h.a<T>
  {
    private String a;
    private int b = -1;
    private int c;
    private String d;
    private boolean e = false;

    protected a()
    {
    }

    protected a(l paraml)
    {
      super();
      this.a = l.a(paraml);
      this.b = l.b(paraml);
      this.c = l.c(paraml);
      this.d = l.d(paraml);
      this.e = l.e(paraml);
    }

    protected void a()
    {
      super.a();
      m(R.string.dialog_button_cancel);
      n(-2);
      i("Cancel");
    }

    public T d(int paramInt, String paramString)
    {
      this.b = paramInt;
      return h(paramString);
    }

    public T e(int paramInt1, int paramInt2)
    {
      this.b = paramInt1;
      return m(paramInt2);
    }

    public T h(String paramString)
    {
      this.a = paramString;
      return (a)b();
    }

    public T i(String paramString)
    {
      this.d = paramString;
      return (a)b();
    }

    public T m(int paramInt)
    {
      return h(y.a().getString(paramInt));
    }

    l m()
    {
      return new l(this);
    }

    public T n()
    {
      d(-1, null);
      return (a)super.g();
    }

    public T n(int paramInt)
    {
      this.c = paramInt;
      return (a)b();
    }

    public T o()
    {
      this.e = true;
      return (a)b();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.dialogs.l
 * JD-Core Version:    0.6.2
 */