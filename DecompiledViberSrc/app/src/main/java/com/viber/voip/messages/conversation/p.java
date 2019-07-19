package com.viber.voip.messages.conversation;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.app.LoaderManager;
import android.util.SparseArray;
import com.viber.provider.d.a;
import com.viber.voip.messages.k;
import com.viber.voip.util.ae;
import dagger.a;
import java.util.ArrayList;
import java.util.List;
import org.greenrobot.eventbus.EventBus;

public class p extends v
{
  private int l;
  private SparseArray m;

  public p(Context paramContext, LoaderManager paramLoaderManager, a<k> parama, d.a parama1, EventBus paramEventBus, int paramInt)
  {
    super(paramContext, paramLoaderManager, parama, parama1, paramEventBus);
    this.l = paramInt;
  }

  private SparseArray t()
  {
    SparseArray localSparseArray = new SparseArray();
    long l1 = 0L;
    int i = -1;
    int j = 0;
    int k = 0;
    if ((k < getCount()) && (b_(k)))
    {
      long l2 = this.f.getLong(2);
      int i2;
      if ((k == 0) || (ae.a(l1, l2)))
      {
        int n = i + 1;
        localSparseArray.append(n, new a().a(Integer.valueOf(k)));
        int i1 = n + 1;
        localSparseArray.append(i1, new b().a(Integer.valueOf(k)));
        j = 0;
        i2 = i1;
      }
      while (true)
      {
        j++;
        k++;
        i = i2;
        l1 = l2;
        break;
        if (j == this.l)
        {
          int i3 = i + 1;
          localSparseArray.append(i3, new b().a(Integer.valueOf(k)));
          i2 = i3;
          j = 0;
        }
        else
        {
          if (localSparseArray.get(i) != null)
            ((b)localSparseArray.get(i)).a(Integer.valueOf(k));
          i2 = i;
        }
      }
    }
    return localSparseArray;
  }

  public c e(int paramInt)
  {
    return (c)this.m.get(paramInt);
  }

  protected void m()
  {
    super.m();
    this.m = t();
  }

  public int s()
  {
    return this.m.size();
  }

  public class a extends p.c
  {
    public a()
    {
      super();
    }
  }

  public class b extends p.c
  {
    public b()
    {
      super();
    }
  }

  public class c
  {
    private List<Integer> a = new ArrayList();

    public c()
    {
    }

    public c a(Integer paramInteger)
    {
      this.a.add(paramInteger);
      return this;
    }

    public aa[] a()
    {
      aa[] arrayOfaa = new aa[this.a.size()];
      for (int i = 0; i < this.a.size(); i++)
        arrayOfaa[i] = p.this.f(((Integer)this.a.get(i)).intValue());
      return arrayOfaa;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.p
 * JD-Core Version:    0.6.2
 */