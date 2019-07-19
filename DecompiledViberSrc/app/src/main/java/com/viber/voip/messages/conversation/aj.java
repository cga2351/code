package com.viber.voip.messages.conversation;

import android.os.Handler;
import android.support.v4.util.Pair;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.stickers.a.a;
import com.viber.voip.util.av;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class aj
{
  private static final Logger a = ViberEnv.getLogger();
  private a b;
  private List<Runnable> c = Collections.synchronizedList(new ArrayList());
  private Handler d = av.e.f.a();
  private boolean e = true;
  private b f;

  public aj(a parama)
  {
    this.b = parama;
  }

  private void a(aa paramaa, long paramLong)
  {
    c localc = new c(paramaa);
    this.c.add(localc);
    this.d.postDelayed(localc, paramLong);
  }

  private void a(String paramString, List<aa> paramList)
  {
  }

  public void a()
  {
    if (!this.e);
    while (true)
    {
      return;
      if (!this.c.isEmpty())
      {
        ArrayList localArrayList = new ArrayList(this.c);
        this.c.clear();
        Iterator localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
        {
          Runnable localRunnable = (Runnable)localIterator.next();
          this.d.removeCallbacks(localRunnable);
        }
      }
    }
  }

  public void a(b paramb)
  {
    this.f = paramb;
  }

  public void a(List<Pair<aa, Boolean>> paramList)
  {
    if (!this.e)
      return;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    long l1 = System.currentTimeMillis();
    long l2 = 9223372036854775807L;
    Object localObject1 = null;
    int i = 0;
    label40: Pair localPair;
    Object localObject2;
    int j;
    label103: int k;
    label124: long l4;
    if (i < paramList.size())
    {
      localPair = (Pair)paramList.get(i);
      localObject2 = (aa)localPair.first;
      boolean bool = this.b.c((aa)localObject2);
      if ((bool) && (((aa)localObject2).ai()))
      {
        j = 1;
        if ((!bool) || (j != 0) || (!((aa)localObject2).ah()))
          break label192;
        k = 1;
        if (k == 0)
          break label198;
        localArrayList1.add(localObject2);
        label138: if (j == 0)
          break label333;
        l4 = ((aa)localObject2).J() - l1;
        if ((l4 <= 0L) || (l4 >= l2))
          break label333;
      }
    }
    for (long l3 = l4; ; l3 = l2)
    {
      i++;
      l2 = l3;
      localObject1 = localObject2;
      break label40;
      j = 0;
      break label103;
      label192: k = 0;
      break label124;
      label198: if ((!((Boolean)localPair.second).booleanValue()) || (j == 0) || (av.c(((aa)localObject2).K(), 1)))
        break label138;
      localArrayList2.add(localObject2);
      break label138;
      if (!localArrayList1.isEmpty())
      {
        a("clickersToFetch", localArrayList1);
        this.b.a(localArrayList1);
      }
      if (!localArrayList2.isEmpty())
      {
        a("clickersToReport", localArrayList2);
        a locala = new a(localArrayList2);
        this.c.add(locala);
        this.d.postDelayed(locala, 1000L);
      }
      if (localObject1 == null)
        break;
      a(localObject1, l2);
      return;
      label333: localObject2 = localObject1;
    }
  }

  public void a(boolean paramBoolean)
  {
    if (!paramBoolean)
      a();
    this.e = paramBoolean;
  }

  public void b()
  {
    a();
  }

  private class a
    implements Runnable
  {
    private List<aa> b;

    public a()
    {
      Object localObject;
      this.b = localObject;
    }

    public void run()
    {
      aj.a(aj.this).a(1, this.b);
      aj.b(aj.this).remove(this);
    }
  }

  public static abstract interface b
  {
    public abstract void a(aa paramaa);
  }

  private class c
    implements Runnable
  {
    aa a;

    public c(aa arg2)
    {
      Object localObject;
      this.a = localObject;
    }

    public void run()
    {
      aj.b(aj.this).remove(this);
      av.e.a.a().post(new Runnable()
      {
        public void run()
        {
          if (aj.c(aj.this) != null)
            aj.c(aj.this).a(aj.c.this.a);
        }
      });
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.aj
 * JD-Core Version:    0.6.2
 */