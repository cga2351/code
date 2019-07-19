package com.b.a.a;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.SectionIndexer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class a extends BaseAdapter
  implements SectionIndexer
{
  protected d a = new d(null);

  protected List<ListAdapter> a()
  {
    return this.a.b();
  }

  public void a(View paramView)
  {
    a(paramView, false);
  }

  public void a(View paramView, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList(1);
    localArrayList.add(paramView);
    a(localArrayList, paramBoolean);
  }

  public void a(ListAdapter paramListAdapter)
  {
    this.a.a(paramListAdapter);
    paramListAdapter.registerDataSetObserver(new a(null));
  }

  public void a(ListAdapter paramListAdapter, boolean paramBoolean)
  {
    this.a.a(paramListAdapter, paramBoolean);
    notifyDataSetChanged();
  }

  public void a(List<View> paramList, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(new b(paramList));
      return;
    }
    a(new com.b.a.b.a(paramList));
  }

  public boolean areAllItemsEnabled()
  {
    return false;
  }

  public void b(View paramView, boolean paramBoolean)
  {
    this.a.a(paramView, paramBoolean);
    notifyDataSetChanged();
  }

  public int getCount()
  {
    Iterator localIterator = a().iterator();
    int i = 0;
    while (localIterator.hasNext())
      i += ((ListAdapter)localIterator.next()).getCount();
    return i;
  }

  public Object getItem(int paramInt)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      ListAdapter localListAdapter = (ListAdapter)localIterator.next();
      int i = localListAdapter.getCount();
      if (paramInt < i)
        return localListAdapter.getItem(paramInt);
      paramInt -= i;
    }
    return null;
  }

  public long getItemId(int paramInt)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      ListAdapter localListAdapter = (ListAdapter)localIterator.next();
      int i = localListAdapter.getCount();
      if (paramInt < i)
        return localListAdapter.getItemId(paramInt);
      paramInt -= i;
    }
    return -1L;
  }

  public int getItemViewType(int paramInt)
  {
    Iterator localIterator = this.a.a().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc.b)
      {
        int j = localc.a.getCount();
        if (paramInt < j)
          return i + localc.a.getItemViewType(paramInt);
        paramInt -= j;
      }
      i += localc.a.getViewTypeCount();
    }
    return -1;
  }

  public int getPositionForSection(int paramInt)
  {
    Iterator localIterator = a().iterator();
    int i = 0;
    boolean bool = localIterator.hasNext();
    int j = 0;
    ListAdapter localListAdapter;
    Object[] arrayOfObject;
    if (bool)
    {
      localListAdapter = (ListAdapter)localIterator.next();
      if (!(localListAdapter instanceof SectionIndexer))
        break label103;
      arrayOfObject = ((SectionIndexer)localListAdapter).getSections();
      if (arrayOfObject == null)
        break label116;
    }
    label103: label116: for (int k = arrayOfObject.length; ; k = 0)
    {
      if (paramInt < k)
      {
        j = i + ((SectionIndexer)localListAdapter).getPositionForSection(paramInt);
        return j;
      }
      if (arrayOfObject != null)
        paramInt -= k;
      i += localListAdapter.getCount();
      break;
    }
  }

  public int getSectionForPosition(int paramInt)
  {
    Iterator localIterator = a().iterator();
    int i = 0;
    boolean bool1 = localIterator.hasNext();
    int j = 0;
    ListAdapter localListAdapter;
    int k;
    if (bool1)
    {
      localListAdapter = (ListAdapter)localIterator.next();
      k = localListAdapter.getCount();
      if (paramInt >= k)
        break label87;
      boolean bool2 = localListAdapter instanceof SectionIndexer;
      j = 0;
      if (bool2)
        j = i + ((SectionIndexer)localListAdapter).getSectionForPosition(paramInt);
    }
    return j;
    label87: Object[] arrayOfObject;
    if ((localListAdapter instanceof SectionIndexer))
    {
      arrayOfObject = ((SectionIndexer)localListAdapter).getSections();
      if (arrayOfObject == null);
    }
    for (int m = i + arrayOfObject.length; ; m = i)
    {
      paramInt -= k;
      i = m;
      break;
    }
  }

  public Object[] getSections()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      ListAdapter localListAdapter = (ListAdapter)localIterator.next();
      if ((localListAdapter instanceof SectionIndexer))
      {
        Object[] arrayOfObject = ((SectionIndexer)localListAdapter).getSections();
        if (arrayOfObject != null)
          Collections.addAll(localArrayList, arrayOfObject);
      }
    }
    if (localArrayList.size() == 0)
      return new String[0];
    return localArrayList.toArray(new Object[0]);
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      ListAdapter localListAdapter = (ListAdapter)localIterator.next();
      int i = localListAdapter.getCount();
      if (paramInt < i)
        return localListAdapter.getView(paramInt, paramView, paramViewGroup);
      paramInt -= i;
    }
    return null;
  }

  public int getViewTypeCount()
  {
    Iterator localIterator = this.a.a().iterator();
    int i = 0;
    while (localIterator.hasNext())
      i += ((c)localIterator.next()).a.getViewTypeCount();
    return Math.max(i, 1);
  }

  public boolean isEnabled(int paramInt)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
    {
      ListAdapter localListAdapter = (ListAdapter)localIterator.next();
      int i = localListAdapter.getCount();
      if (paramInt < i)
        return localListAdapter.isEnabled(paramInt);
      paramInt -= i;
    }
    return false;
  }

  private class a extends DataSetObserver
  {
    private a()
    {
    }

    public void onChanged()
    {
      a.this.notifyDataSetChanged();
    }

    public void onInvalidated()
    {
      a.this.notifyDataSetInvalidated();
    }
  }

  private static class b extends com.b.a.b.a
  {
    public b(List<View> paramList)
    {
      super();
    }

    public boolean areAllItemsEnabled()
    {
      return true;
    }

    public boolean isEnabled(int paramInt)
    {
      return true;
    }
  }

  private static class c
  {
    ListAdapter a;
    boolean b = true;

    c(ListAdapter paramListAdapter, boolean paramBoolean)
    {
      this.a = paramListAdapter;
      this.b = paramBoolean;
    }
  }

  private static class d
  {
    protected ArrayList<a.c> a = new ArrayList();
    protected ArrayList<ListAdapter> b = null;

    List<a.c> a()
    {
      return this.a;
    }

    void a(View paramView, boolean paramBoolean)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        a.c localc = (a.c)localIterator.next();
        if (((localc.a instanceof com.b.a.b.a)) && (((com.b.a.b.a)localc.a).a(paramView)))
        {
          localc.b = paramBoolean;
          this.b = null;
        }
      }
    }

    void a(ListAdapter paramListAdapter)
    {
      this.a.add(new a.c(paramListAdapter, true));
    }

    void a(ListAdapter paramListAdapter, boolean paramBoolean)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        a.c localc = (a.c)localIterator.next();
        if (localc.a == paramListAdapter)
        {
          localc.b = paramBoolean;
          this.b = null;
        }
      }
    }

    List<ListAdapter> b()
    {
      if (this.b == null)
      {
        this.b = new ArrayList();
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext())
        {
          a.c localc = (a.c)localIterator.next();
          if (localc.b)
            this.b.add(localc.a);
        }
      }
      return this.b;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.b.a.a.a
 * JD-Core Version:    0.6.2
 */