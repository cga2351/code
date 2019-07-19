package com.viber.voip.b.c.a;

import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.b.c.a.a.e;
import com.viber.voip.b.c.a.a.h;
import com.viber.voip.engagement.c.d;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.stickers.entity.b;
import com.viber.voip.stickers.i;
import com.viber.voip.util.b.a.a;
import com.viber.voip.util.u;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class n extends c
{
  private static final Logger d = ViberEnv.getLogger();
  private com.viber.voip.stickers.b.a e;

  public n(Context paramContext, com.viber.voip.stickers.b.a parama)
  {
    super(paramContext);
    this.e = parama;
  }

  private List<File> a(com.viber.voip.stickers.entity.a parama, f paramf)
  {
    List localList = this.e.c(parama.e());
    if ((localList == null) || (localList.size() == 0))
      return Collections.emptyList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
      ((Sticker)localIterator.next()).markFiles(paramf);
    return paramf.a(parama.a(this.c));
  }

  private void f()
  {
    com.viber.voip.engagement.data.a locala = new d().a();
    List localList1;
    if (locala != null)
    {
      localList1 = locala.a().b();
      if (!u.a(localList1))
        break label111;
    }
    label111: HashSet localHashSet;
    for (Object localObject = Collections.emptySet(); ; localObject = localHashSet)
    {
      List localList2 = this.e.a((Set)localObject);
      if ((localList2 != null) && (localList2.size() > 0))
      {
        i locali = i.a();
        Iterator localIterator2 = localList2.iterator();
        while (true)
          if (localIterator2.hasNext())
          {
            locali.v(((Integer)localIterator2.next()).intValue());
            continue;
            localList1 = null;
            break;
            localHashSet = new HashSet(localList1.size());
            Iterator localIterator1 = localList1.iterator();
            while (localIterator1.hasNext())
              localHashSet.add(Integer.valueOf(((a.a)localIterator1.next()).a()));
          }
      }
      return;
    }
  }

  public void a()
  {
    this.b = new f(new e(new h(new com.viber.voip.b.c.a.a.g(new com.viber.voip.b.c.a.a.a()), 86400000L)), 512);
    this.b.b(true);
  }

  protected void b()
  {
    f();
    List localList1 = this.e.c();
    ArrayList localArrayList = new ArrayList();
    HashSet localHashSet = new HashSet();
    Iterator localIterator1 = localList1.iterator();
    b localb;
    if (localIterator1.hasNext())
    {
      localb = (b)localIterator1.next();
      if (!this.a);
    }
    label224: List localList2;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (!localb.F())
              break label224;
            localArrayList.addAll(a(localb, this.b));
            this.b.d();
            localHashSet.add(localb.a(this.c).getPath());
            if (localArrayList.size() < this.b.b())
              break;
          }
          while (this.a);
          this.b.a(localArrayList);
        }
        while ((localArrayList.size() >= this.b.b()) || (this.a));
        this.b.a(localHashSet);
        Iterator localIterator2 = this.e.b().iterator();
        while (localIterator2.hasNext())
          ((Sticker)localIterator2.next()).markFiles(this.b);
        Iterator localIterator3 = this.e.c(localb.e()).iterator();
        while (localIterator3.hasNext())
          ((Sticker)localIterator3.next()).markFiles(localHashSet);
        break;
        this.b.b(true);
      }
      while (this.a);
      localList2 = this.b.a(com.viber.voip.stickers.c.g.a(this.c));
    }
    while (this.a);
    this.b.a(localList2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.b.c.a.n
 * JD-Core Version:    0.6.2
 */