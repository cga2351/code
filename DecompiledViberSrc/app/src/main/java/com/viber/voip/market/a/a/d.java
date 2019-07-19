package com.viber.voip.market.a.a;

import android.util.SparseArray;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class d
  implements c
{
  private static final Logger c = ViberEnv.getLogger();
  protected List<a> a = new ArrayList();
  protected SparseArray<a> b = new SparseArray();

  public d(List<? extends com.viber.voip.stickers.entity.d> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      a locala = new a((com.viber.voip.stickers.entity.d)localIterator.next());
      this.a.add(locala);
      this.b.append(locala.e(), locala);
    }
  }

  public int a()
  {
    return 0;
  }

  public a a(int paramInt)
  {
    return (a)this.a.get(paramInt);
  }

  protected void a(a parama)
  {
    this.a.add(parama);
    this.b.append(parama.e(), parama);
  }

  public void a(List<? extends com.viber.voip.stickers.entity.d> paramList)
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator1 = paramList.iterator();
    while (localIterator1.hasNext())
    {
      com.viber.voip.stickers.entity.d locald = (com.viber.voip.stickers.entity.d)localIterator1.next();
      localHashSet.add(Integer.valueOf(locald.e()));
      a locala2 = (a)this.b.get(locald.e());
      if (locala2 != null)
        locala2.a(locald);
      else
        a(new a(locald));
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator2 = this.a.iterator();
    while (localIterator2.hasNext())
    {
      a locala1 = (a)localIterator2.next();
      if (!localHashSet.contains(Integer.valueOf(locala1.e())))
      {
        localArrayList.add(locala1);
        this.b.remove(locala1.e());
      }
    }
    this.a.removeAll(localArrayList);
  }

  public boolean a(int paramInt1, int paramInt2)
  {
    return false;
  }

  public int b()
  {
    return this.a.size();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.market.a.a.d
 * JD-Core Version:    0.6.2
 */