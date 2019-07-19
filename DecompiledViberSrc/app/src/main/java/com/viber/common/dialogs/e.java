package com.viber.common.dialogs;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;

public class e extends a
{
  private transient ArrayList<? extends Parcelable> a;
  private int b;

  protected e(a<?> parama)
  {
    super(parama);
    this.a = a.a(parama);
    this.b = a.b(parama);
  }

  public static a<?> j()
  {
    return new a();
  }

  protected void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.a != null)
      paramBundle.putParcelableArrayList("data_list_items", this.a);
  }

  protected void b(Bundle paramBundle)
  {
    paramBundle.putBoolean("has_list", true);
    paramBundle.putParcelableArrayList("data_list_items", this.a);
    paramBundle.putInt("data_list_item_layout_id", this.b);
    super.b(paramBundle);
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1 = true;
    boolean bool3;
    if (this == paramObject)
      bool3 = bool1;
    e locale;
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
          bool2 = paramObject instanceof e;
          bool3 = false;
        }
        while (!bool2);
        bool4 = super.equals(paramObject);
        bool3 = false;
      }
      while (!bool4);
      locale = (e)paramObject;
      i = this.b;
      j = locale.b;
      bool3 = false;
    }
    while (i != j);
    if (this.a != null)
      bool1 = this.a.equals(locale.a);
    while (true)
    {
      return bool1;
      if (locale.a != null)
        bool1 = false;
    }
  }

  public int hashCode()
  {
    int i = 31 * (31 * super.hashCode() + this.b);
    if (this.a != null);
    for (int j = this.a.hashCode(); ; j = 0)
      return j + i;
  }

  public a<?> i()
  {
    return new a(this);
  }

  public static class a<T extends a<T>> extends a.a<T>
  {
    private ArrayList<? extends Parcelable> a;
    private int b;

    protected a()
    {
    }

    protected a(e parame)
    {
      super();
      this.a = e.a(parame);
      this.b = e.b(parame);
    }

    public <P extends Parcelable> T a(ArrayList<P> paramArrayList)
    {
      this.a = paramArrayList;
      return (a)b();
    }

    protected void a()
    {
      super.a();
      g(true);
      a(new ArrayList());
    }

    public T b(Bundle paramBundle)
    {
      super.a(paramBundle);
      this.a = paramBundle.getParcelableArrayList("data_list_items");
      return (a)b();
    }

    public final T g(boolean paramBoolean)
    {
      return (a)super.c(true);
    }

    e g()
    {
      return new e(this);
    }

    public T i(int paramInt)
    {
      this.b = paramInt;
      return (a)b();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.dialogs.e
 * JD-Core Version:    0.6.2
 */