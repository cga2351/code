package com.my.target;

import android.content.Context;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class bl
{
  private final ArrayList<n> a;
  private final ArrayList<m> b;
  private WeakReference<View> c;
  private float d = -1.0F;

  protected bl(ArrayList<n> paramArrayList, ArrayList<m> paramArrayList1)
  {
    this.b = paramArrayList1;
    this.a = paramArrayList;
  }

  public static bl a(q paramq)
  {
    return new bl(paramq.b(), paramq.c());
  }

  protected void a(double paramDouble, float paramFloat, Context paramContext)
  {
    if ((this.a.isEmpty()) && (this.b.isEmpty()));
    ArrayList localArrayList;
    do
    {
      while (true)
      {
        return;
        if (paramContext != null)
          break;
        Iterator localIterator2 = this.b.iterator();
        while (localIterator2.hasNext())
          ((m)localIterator2.next()).b(-1.0F);
      }
      localArrayList = new ArrayList();
      while ((!this.a.isEmpty()) && (((n)this.a.get(-1 + this.a.size())).e() <= paramFloat))
      {
        n localn = (n)this.a.remove(-1 + this.a.size());
        int i = localn.g();
        boolean bool = localn.a();
        if (((i <= paramDouble) && (bool)) || ((i > paramDouble) && (!bool)))
          localArrayList.add(localn);
      }
      Iterator localIterator1 = this.b.iterator();
      while (localIterator1.hasNext())
      {
        m localm = (m)localIterator1.next();
        if (localm.g() > paramDouble)
          localm.b(-1.0F);
        else if ((localm.b() >= 0.0F) && (paramFloat > localm.b()))
        {
          if (paramFloat - localm.b() >= localm.a())
          {
            localArrayList.add(localm);
            localIterator1.remove();
          }
        }
        else
          localm.b(paramFloat);
      }
    }
    while (localArrayList.isEmpty());
    bi.a(localArrayList, paramContext);
  }

  public void a(float paramFloat)
  {
    if (Math.abs(paramFloat - this.d) < 1.0F)
      return;
    Context localContext;
    double d1;
    if (this.c != null)
    {
      View localView = (View)this.c.get();
      if (localView != null)
      {
        double d2 = bm.a(localView);
        localContext = localView.getContext();
        d1 = d2;
      }
    }
    while (true)
    {
      a(d1, paramFloat, localContext);
      this.d = paramFloat;
      return;
      d1 = 0.0D;
      localContext = null;
    }
  }

  public void a(View paramView)
  {
    if ((paramView == null) && (this.c != null))
    {
      this.c.clear();
      return;
    }
    this.c = new WeakReference(paramView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.bl
 * JD-Core Version:    0.6.2
 */