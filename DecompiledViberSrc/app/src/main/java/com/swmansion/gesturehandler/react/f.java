package com.swmansion.gesturehandler.react;

import android.util.SparseArray;
import android.view.View;
import com.swmansion.gesturehandler.b;
import com.swmansion.gesturehandler.e;
import java.util.ArrayList;
import javax.annotation.Nullable;

public class f
  implements e
{
  private final SparseArray<b> a = new SparseArray();
  private final SparseArray<Integer> b = new SparseArray();
  private final SparseArray<ArrayList<b>> c = new SparseArray();

  private void a(int paramInt, b paramb)
  {
    try
    {
      if (this.b.get(paramb.d()) != null)
        throw new IllegalStateException("Handler " + paramb + " already attached");
    }
    finally
    {
    }
    this.b.put(paramb.d(), Integer.valueOf(paramInt));
    ArrayList localArrayList1 = (ArrayList)this.c.get(paramInt);
    if (localArrayList1 == null)
    {
      ArrayList localArrayList2 = new ArrayList(1);
      localArrayList2.add(paramb);
      this.c.put(paramInt, localArrayList2);
    }
    while (true)
    {
      return;
      localArrayList1.add(paramb);
    }
  }

  private void b(b paramb)
  {
    try
    {
      Integer localInteger = (Integer)this.b.get(paramb.d());
      if (localInteger != null)
      {
        this.b.remove(paramb.d());
        ArrayList localArrayList = (ArrayList)this.c.get(localInteger.intValue());
        if (localArrayList != null)
        {
          localArrayList.remove(paramb);
          if (localArrayList.size() == 0)
            this.c.remove(localInteger.intValue());
        }
      }
      if (paramb.e() != null)
        paramb.j();
      return;
    }
    finally
    {
    }
  }

  @Nullable
  public b a(int paramInt)
  {
    try
    {
      b localb = (b)this.a.get(paramInt);
      return localb;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public ArrayList<b> a(View paramView)
  {
    try
    {
      ArrayList localArrayList = c(paramView.getId());
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a()
  {
    try
    {
      this.a.clear();
      this.b.clear();
      this.c.clear();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(b paramb)
  {
    try
    {
      this.a.put(paramb.d(), paramb);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean a(int paramInt1, int paramInt2)
  {
    try
    {
      b localb = (b)this.a.get(paramInt1);
      if (localb != null)
      {
        b(localb);
        a(paramInt2, localb);
      }
      for (boolean bool = true; ; bool = false)
        return bool;
    }
    finally
    {
    }
  }

  public void b(int paramInt)
  {
    try
    {
      b localb = (b)this.a.get(paramInt);
      if (localb != null)
      {
        b(localb);
        this.a.remove(paramInt);
      }
      return;
    }
    finally
    {
    }
  }

  public ArrayList<b> c(int paramInt)
  {
    try
    {
      ArrayList localArrayList = (ArrayList)this.c.get(paramInt);
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.swmansion.gesturehandler.react.f
 * JD-Core Version:    0.6.2
 */