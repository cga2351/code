package com.viber.voip.messages.conversation.adapter;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.at;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class k extends BaseAdapter
{
  private static final Logger a = ViberEnv.getLogger();
  private HashMap<String, Integer> b = new HashMap();
  private int c;
  private int d;
  private ArrayList<b> e = new ArrayList();
  private ArrayList<b> f = new ArrayList();
  private ConversationItemLoaderEntity g;
  private d h;
  private a i;
  private at j;

  public k(d paramd, at paramat)
  {
    this.h = paramd;
    this.j = paramat;
    this.c = this.h.getViewTypeCount();
    this.d = (6 + this.c);
    this.i = new a(null);
    paramd.registerDataSetObserver(this.i);
  }

  private int a(k.b.a parama, List<b> paramList)
  {
    int k = paramList.size();
    if (k == 0)
      return 0;
    int m = 1.a[parama.ordinal()];
    int n = 0;
    switch (m)
    {
    default:
    case 1:
    case 2:
    }
    for (int i1 = k - 1; i1 >= 0; i1--)
      if (((b)paramList.get(i1)).b() != k.b.a.c)
      {
        return Math.min(k, i1 + 1);
        do
        {
          n++;
          if (n >= k)
            break;
        }
        while (((b)paramList.get(n)).b() == k.b.a.a);
        return n;
        return k;
        return k;
      }
    return 0;
  }

  private b a(int paramInt)
  {
    int k = c();
    if (paramInt < k)
      return (b)this.e.get(paramInt);
    return (b)this.f.get(paramInt - (k + this.h.getCount()));
  }

  private void a(String paramString)
  {
    if (!this.b.containsKey(paramString))
    {
      this.c = (1 + this.c);
      if (this.c == 6)
        throw new RuntimeException("Unable to create new type, increment HEADER_FOOTER_TYPES_COUNT for new type");
      this.b.put(paramString, Integer.valueOf(this.c));
    }
  }

  public int a(k.b.a parama, boolean paramBoolean)
  {
    Iterator localIterator = this.e.iterator();
    int k = 0;
    b localb;
    int m;
    while (true)
      if (localIterator.hasNext())
      {
        localb = (b)localIterator.next();
        if (localb.b() == parama)
        {
          View localView = localb.a();
          if (localView != null)
            m = k + localView.getLayoutParams().height;
        }
      }
    while (true)
    {
      k = m;
      break;
      if ((paramBoolean) && (localb.c() > 0))
      {
        m = k + localb.c();
        continue;
        return k;
      }
      else
      {
        m = k;
      }
    }
  }

  public d a()
  {
    return this.h;
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    this.g = paramConversationItemLoaderEntity;
  }

  public void a(at paramat)
  {
    this.j = paramat;
  }

  public boolean a(b paramb)
  {
    if (!this.e.contains(paramb))
    {
      a(paramb.getClass().getName());
      this.e.add(a(paramb.b(), this.e), paramb);
      notifyDataSetChanged();
      return true;
    }
    return false;
  }

  public boolean a(b paramb, boolean paramBoolean)
  {
    if (this.e.contains(paramb))
    {
      this.e.remove(paramb);
      if (paramBoolean)
        notifyDataSetChanged();
      return true;
    }
    return false;
  }

  public void b()
  {
    if (this.h != null)
    {
      this.h.unregisterDataSetObserver(this.i);
      this.h.c();
      this.h = null;
    }
  }

  public boolean b(b paramb)
  {
    return a(paramb, true);
  }

  public boolean b(b paramb, boolean paramBoolean)
  {
    if (this.f.contains(paramb))
    {
      this.f.remove(paramb);
      if (paramBoolean)
        notifyDataSetChanged();
      return true;
    }
    return false;
  }

  public int c()
  {
    return this.e.size();
  }

  public boolean c(b paramb)
  {
    if (!this.f.contains(paramb))
    {
      a(paramb.getClass().getName());
      this.f.add(a(paramb.b(), this.f), paramb);
      notifyDataSetChanged();
      return true;
    }
    return false;
  }

  public int d()
  {
    return this.f.size();
  }

  public int getCount()
  {
    if (this.h != null);
    for (int k = this.h.getCount(); ; k = 0)
      return k + c() + d();
  }

  public Object getItem(int paramInt)
  {
    if (getItemViewType(paramInt) >= this.h.getViewTypeCount())
      return null;
    return this.h.b(paramInt - c());
  }

  public long getItemId(int paramInt)
  {
    if (getItemViewType(paramInt) >= this.h.getViewTypeCount())
      return 0L;
    return this.h.getItemId(paramInt - c());
  }

  public int getItemViewType(int paramInt)
  {
    int k = c();
    int m = this.h.getCount();
    if (paramInt >= getCount())
      return 0;
    if (paramInt < k)
      return ((Integer)this.b.get(((b)this.e.get(paramInt)).getClass().getName())).intValue();
    if (paramInt < m + k)
      return this.h.getItemViewType(paramInt - k);
    return ((Integer)this.b.get(((b)this.f.get(paramInt - (k + m))).getClass().getName())).intValue();
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int k;
    int m;
    if (paramView != null)
    {
      k = ((Integer)paramView.getTag(R.id.list_item_type)).intValue();
      m = getItemViewType(paramInt);
      if ((paramView != null) && (k != m))
        paramView = null;
      if (m < this.h.getViewTypeCount())
        break label124;
      b localb = a(paramInt);
      if ((localb.a() == null) || (paramView != localb.a()))
        paramView = localb.a(paramViewGroup, paramView);
      localb.a(this.g, this.j);
    }
    while (true)
    {
      paramView.setTag(R.id.list_item_type, Integer.valueOf(m));
      return paramView;
      k = -1;
      break;
      label124: paramView = this.h.getView(paramInt - c(), paramView, paramViewGroup);
    }
  }

  public int getViewTypeCount()
  {
    return this.d;
  }

  private class a extends DataSetObserver
  {
    private a()
    {
    }

    public void onChanged()
    {
      k.this.notifyDataSetChanged();
    }

    public void onInvalidated()
    {
      k.this.notifyDataSetInvalidated();
    }
  }

  public static abstract interface b
  {
    public abstract View a();

    public abstract View a(ViewGroup paramViewGroup, View paramView);

    public abstract void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, at paramat);

    public abstract a b();

    public abstract int c();

    public static enum a
    {
      static
      {
        a[] arrayOfa = new a[3];
        arrayOfa[0] = a;
        arrayOfa[1] = b;
        arrayOfa[2] = c;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.k
 * JD-Core Version:    0.6.2
 */