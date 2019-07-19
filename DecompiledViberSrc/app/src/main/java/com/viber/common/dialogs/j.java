package com.viber.common.dialogs;

import android.os.Bundle;

public class j extends g
{
  private int a;

  protected j(a<?> parama)
  {
    super(parama);
    this.a = a.a(parama);
  }

  public static a<?> m()
  {
    return new a();
  }

  protected void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    paramBundle.putInt("selected_list_item", this.a);
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    j localj;
    do
    {
      return true;
      if (!(paramObject instanceof j))
        return false;
      if (!super.equals(paramObject))
        return false;
      localj = (j)paramObject;
    }
    while (this.a == localj.a);
    return false;
  }

  public int hashCode()
  {
    return 31 * super.hashCode() + this.a;
  }

  protected int k()
  {
    return 1;
  }

  public a<?> l()
  {
    return new a(this);
  }

  public static class a<T extends a<T>> extends g.a<T>
  {
    private int a;

    protected a()
    {
    }

    protected a(j paramj)
    {
      super();
      this.a = j.a(paramj);
    }

    protected void a()
    {
      super.a();
      this.a = -1;
    }

    j h()
    {
      return new j(this);
    }

    public T i(int paramInt)
    {
      this.a = paramInt;
      return (a)b();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.dialogs.j
 * JD-Core Version:    0.6.2
 */