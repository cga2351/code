package com.viber.voip.j.a.a;

import androidx.work.g;
import androidx.work.j;
import androidx.work.k;
import androidx.work.k.a;
import androidx.work.o;
import androidx.work.o.a;
import androidx.work.p;
import com.viber.voip.registration.ActivationController;
import com.viber.voip.workers.EmailCollectionWorker;
import d.d.b.h;
import java.util.Arrays;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;

public final class c
{
  public static final a a = new a(null);
  private final d.d.a.a<Boolean> b;
  private final com.viber.common.b.b c;
  private final dagger.a<p> d;
  private final dagger.a<com.viber.common.permission.c> e;
  private final dagger.a<com.viber.voip.contacts.c.d.n> f;
  private final dagger.a<ActivationController> g;
  private final a h;
  private final d i;

  public c(@NotNull d.d.a.a<Boolean> parama, @NotNull com.viber.common.b.b paramb, @NotNull dagger.a<p> parama1, @NotNull dagger.a<com.viber.common.permission.c> parama2, @NotNull dagger.a<com.viber.voip.contacts.c.d.n> parama3, @NotNull dagger.a<ActivationController> parama4, @NotNull a parama5, @NotNull d paramd)
  {
    this.b = parama;
    this.c = paramb;
    this.d = parama1;
    this.e = parama2;
    this.f = parama3;
    this.g = parama4;
    this.h = parama5;
    this.i = paramd;
  }

  private final void c()
  {
    if ((e()) && (f()) && (!((Boolean)this.b.a()).booleanValue()))
    {
      com.viber.common.permission.c localc = (com.viber.common.permission.c)this.e.get();
      String[] arrayOfString = com.viber.voip.permissions.n.j;
      if (localc.a((String[])Arrays.copyOf(arrayOfString, arrayOfString.length)))
      {
        Object localObject1 = this.g.get();
        h.a(localObject1, "activationController.get()");
        if (((ActivationController)localObject1).isActivationCompleted())
        {
          Object localObject2 = this.f.get();
          h.a(localObject2, "contactsStateManager.get()");
          if (!((com.viber.voip.contacts.c.d.n)localObject2).a())
            d();
        }
      }
    }
  }

  private final void d()
  {
    p localp = (p)this.d.get();
    g localg = g.b;
    k.a locala = new k.a(EmailCollectionWorker.class);
    androidx.work.c.a locala1 = new androidx.work.c.a().a(j.b).b(true);
    if (com.viber.common.d.a.j())
      locala1.a(true);
    localp.a("EmailsAbStatTask", localg, (k)((k.a)locala.a(locala1.a())).e());
  }

  private final boolean e()
  {
    return !this.c.d();
  }

  private final boolean f()
  {
    Object localObject1 = ((p)this.d.get()).b("EmailsAbStatTask").get();
    h.a(localObject1, "workManager.get()\n      …END_REPORT_JOB_TAG).get()");
    Iterator localIterator = ((Iterable)localObject1).iterator();
    Object localObject2;
    int j;
    if (localIterator.hasNext())
    {
      localObject2 = localIterator.next();
      o localo = (o)localObject2;
      h.a(localo, "it");
      if ((localo.a() == o.a.a) || (localo.a() == o.a.b))
      {
        j = 1;
        label93: if (j == 0)
          break label108;
      }
    }
    while (true)
    {
      if (localObject2 != null)
        break label115;
      return true;
      j = 0;
      break label93;
      label108: break;
      localObject2 = null;
    }
    label115: return false;
  }

  public final void a()
  {
    c();
  }

  public final void b()
  {
    b localb = this.h.a();
    if (localb.a())
    {
      boolean bool = this.i.a(localb);
      if (bool)
        this.c.a(bool);
    }
  }

  public static final class a
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.j.a.a.c
 * JD-Core Version:    0.6.2
 */