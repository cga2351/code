package com.viber.voip.storage.a;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.storage.model.ConversationMediaSize.a;
import com.viber.voip.storage.model.ConversationWithMediaSizesEntity;
import com.viber.voip.storage.repository.p;
import com.viber.voip.storage.repository.p.a;
import com.viber.voip.storage.repository.u;
import com.viber.voip.util.i.e;

class c
  implements Runnable
{
  private static final Logger a = ViberEnv.getLogger();
  private final a b;
  private final p c;
  private final u d;
  private final e e;
  private final com.viber.voip.analytics.story.g.a f;
  private final a g;
  private final b h;
  private i.a i;
  private int j = -1;
  private double k = 0.0D;
  private p.a l;

  c(a parama, p paramp, u paramu, e parame, com.viber.voip.analytics.story.g.a parama1, b paramb, i.a parama2, a parama3)
  {
    this.b = parama;
    this.c = paramp;
    this.d = paramu;
    this.e = parame;
    this.f = parama1;
    this.h = paramb;
    this.i = parama2;
    this.g = parama3;
  }

  private void a(int paramInt)
  {
    if (this.j != paramInt)
    {
      this.j = paramInt;
      try
      {
        this.i.a(this.j);
        return;
      }
      finally
      {
      }
    }
  }

  private void b(i.a parama)
  {
    if (parama != null);
    while (true)
    {
      this.i = parama;
      return;
      parama = i.a;
    }
  }

  public long a()
  {
    return this.b.a();
  }

  public void a(i.a parama)
  {
    if (parama != null);
    try
    {
      if (this.l != null)
        parama.a(this.l);
      while (true)
      {
        b(parama);
        return;
        if (this.j > -1)
          parama.a(this.j);
      }
    }
    finally
    {
    }
  }

  public void run()
  {
    this.e.a();
    a(0);
    this.h.a();
    d locald = new d(this, Math.max(1L, this.b.c() / 100L));
    Object localObject1 = null;
    for (ConversationWithMediaSizesEntity localConversationWithMediaSizesEntity3 : this.b.b())
    {
      p.a locala1 = this.c.a(localConversationWithMediaSizesEntity3.getId(), this.b.d(), locald);
      if ((localObject1 == null) || (!locala1.a()))
        localObject1 = locala1;
    }
    this.l = localObject1;
    a(100);
    try
    {
      this.i.a(this.l);
      this.g.a(this);
      if (this.k > 0.0D)
        for (ConversationWithMediaSizesEntity localConversationWithMediaSizesEntity1 : this.b.b())
        {
          ConversationMediaSize.a locala = new ConversationMediaSize.a(localConversationWithMediaSizesEntity1.getMediaSize());
          locala.a(this.b.d());
          ConversationWithMediaSizesEntity localConversationWithMediaSizesEntity2 = new ConversationWithMediaSizesEntity(localConversationWithMediaSizesEntity1, locala.a());
          this.d.a(localConversationWithMediaSizesEntity2, true);
        }
    }
    finally
    {
    }
    this.h.b();
  }

  public static abstract interface a
  {
    public abstract void a(c paramc);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.a.c
 * JD-Core Version:    0.6.2
 */