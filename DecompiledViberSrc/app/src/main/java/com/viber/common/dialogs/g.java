package com.viber.common.dialogs;

import android.content.Context;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;

public class g extends a
{
  private ArrayList<String> a;

  protected g(a<?> parama)
  {
    super(parama);
    this.a = a.a(parama);
  }

  public static a<?> j()
  {
    return new a();
  }

  protected void b(Bundle paramBundle)
  {
    paramBundle.putBoolean("has_list", true);
    paramBundle.putStringArrayList("list_items", this.a);
    paramBundle.putInt("list_style", k());
    super.b(paramBundle);
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    g localg;
    do
    {
      return true;
      if (!(paramObject instanceof g))
        return false;
      if (!super.equals(paramObject))
        return false;
      localg = (g)paramObject;
    }
    while ((this.a.equals(localg.a)) && (k() == localg.k()));
    return false;
  }

  public int hashCode()
  {
    return 31 * (31 * super.hashCode() + this.a.hashCode()) + k();
  }

  public a<?> i()
  {
    return new a(this);
  }

  protected int k()
  {
    return 0;
  }

  public static class a<T extends a<T>> extends a.a<T>
  {
    private ArrayList<String> a;

    protected a()
    {
    }

    protected a(g paramg)
    {
      super();
      this.a = g.a(paramg);
    }

    public T a(ArrayList<String> paramArrayList)
    {
      this.a = paramArrayList;
      return (a)b();
    }

    public T a(int[] paramArrayOfInt)
    {
      int i = 0;
      String[] arrayOfString = new String[paramArrayOfInt.length];
      int j = paramArrayOfInt.length;
      int n;
      for (int k = 0; i < j; k = n)
      {
        int m = paramArrayOfInt[i];
        n = k + 1;
        arrayOfString[k] = y.a().getString(m);
        i++;
      }
      return a(arrayOfString);
    }

    public T a(String[] paramArrayOfString)
    {
      return a(new ArrayList(Arrays.asList(paramArrayOfString)));
    }

    protected void a()
    {
      super.a();
      a(new ArrayList());
    }

    g g()
    {
      return new g(this);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.dialogs.g
 * JD-Core Version:    0.6.2
 */