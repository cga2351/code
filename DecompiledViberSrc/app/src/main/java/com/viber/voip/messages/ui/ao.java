package com.viber.voip.messages.ui;

import android.support.v4.util.SparseArrayCompat;
import android.view.View;
import com.viber.voip.messages.ui.expanel.ExpandablePanelLayout.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ao
  implements ExpandablePanelLayout.b
{
  private ExpandablePanelLayout.b a;
  private SparseArrayCompat<a> b = new SparseArrayCompat();
  private List<a> c = new ArrayList();

  public ao(ExpandablePanelLayout.b paramb, SparseArrayCompat<a> paramSparseArrayCompat)
  {
    this.a = paramb;
    for (int i = 0; i < paramSparseArrayCompat.size(); i++)
    {
      a locala = (a)paramSparseArrayCompat.valueAt(i);
      this.c.add(locala);
      this.b.put(paramSparseArrayCompat.keyAt(i), locala);
    }
  }

  private void a(a parama)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (!locala.equals(parama))
        locala.h();
    }
  }

  private int e(int paramInt)
  {
    if (this.a == null)
      return paramInt;
    return paramInt - this.a.a();
  }

  private int f(int paramInt)
  {
    if (this.a == null)
      return paramInt;
    return paramInt + this.a.a();
  }

  public int a()
  {
    if (this.a != null)
      return this.a.a() + this.c.size();
    return this.c.size();
  }

  public View a(int paramInt, View paramView)
  {
    if (paramInt == -1)
      return null;
    if ((this.a != null) && (this.a.a() > paramInt))
      return this.a.a(paramInt, paramView);
    a locala = (a)this.c.get(e(paramInt));
    a(locala);
    if (locala != null);
    for (View localView = locala.a(paramView); ; localView = null)
      return localView;
  }

  public void a(int paramInt)
  {
    if ((paramInt > -1) && (this.a != null) && (this.c.size() > paramInt))
    {
      a locala = (a)this.c.get(e(paramInt));
      if (locala != null)
        locala.i();
    }
  }

  public void b(int paramInt)
  {
    if ((paramInt > -1) && (this.a != null) && (this.c.size() > paramInt))
    {
      a locala = (a)this.c.get(e(paramInt));
      if (locala != null)
        locala.j();
    }
  }

  public int c(int paramInt)
  {
    if ((this.a != null) && (this.a.a() > paramInt))
      return this.a.c(paramInt);
    a locala = (a)this.c.get(e(paramInt));
    if (locala != null)
    {
      int i = this.b.indexOfValue(locala);
      if (-1 != i)
        return this.b.keyAt(i);
    }
    return -1;
  }

  public int d(int paramInt)
  {
    if (this.a != null)
    {
      int i = this.a.d(paramInt);
      if (-1 != i)
        return i;
    }
    a locala = (a)this.b.get(paramInt);
    if (locala != null)
      return f(this.c.indexOf(locala));
    return -1;
  }

  public static abstract interface a
  {
    public abstract View a(View paramView);

    public abstract void h();

    public abstract void i();

    public abstract void j();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.ao
 * JD-Core Version:    0.6.2
 */