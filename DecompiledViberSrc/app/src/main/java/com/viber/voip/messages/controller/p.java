package com.viber.voip.messages.controller;

import android.os.Handler;
import android.support.v4.util.SparseArrayCompat;
import com.google.d.f;
import com.google.d.g;
import com.viber.dexshared.Logger;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.PgGeneralQueryReplyDelegate;
import com.viber.jni.PgGeneralQueryReplyListener;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberEnv;
import com.viber.voip.contacts.ui.list.i;
import com.viber.voip.contacts.ui.list.i.a;
import com.viber.voip.contacts.ui.list.i.a.a;
import com.viber.voip.memberid.Member;
import com.viber.voip.util.dx;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class p
  implements PgGeneralQueryReplyDelegate
{
  private static final Logger a = ViberEnv.getLogger();
  private final PhoneController b;
  private final EngineDelegatesManager c;
  private final Handler d;
  private final SparseArrayCompat<b> e;
  private final Set<Long> f;

  public p(PhoneController paramPhoneController, EngineDelegatesManager paramEngineDelegatesManager, Handler paramHandler)
  {
    this.b = paramPhoneController;
    this.c = paramEngineDelegatesManager;
    this.d = paramHandler;
    this.e = new SparseArrayCompat();
    this.f = new HashSet();
  }

  public void a()
  {
    this.c.getPgGeneralQueryReplyListener().registerDelegate(new PgGeneralQueryReplyDelegate[] { this });
  }

  public void a(long paramLong, int paramInt1, int paramInt2, a parama)
  {
    synchronized (this.f)
    {
      if (this.f.contains(Long.valueOf(paramLong)))
        return;
      this.f.add(Long.valueOf(paramLong));
      this.d.post(new q(this, parama, paramLong, paramInt1, paramInt2));
      return;
    }
  }

  public void b()
  {
    this.c.getPgGeneralQueryReplyListener().removeDelegate(this);
    this.e.clear();
    this.f.clear();
  }

  public void onPGGeneralQueryReply(int paramInt1, long paramLong, String paramString, int paramInt2)
  {
    b localb = (b)this.e.get(paramInt1);
    if (localb == null)
      return;
    if (paramInt2 == 0)
    {
      i locali = (i)new g().a().a(paramString, i.class);
      LinkedHashSet localLinkedHashSet = new LinkedHashSet(locali.b.d.size());
      for (int i = 0; i < locali.b.d.size(); i++)
      {
        i.a.a locala = (i.a.a)locali.b.d.get(i);
        localLinkedHashSet.add(new Member(locala.c, locala.c, dx.a(locala.a), locala.b, null, null, locala.c));
      }
      localb.a.a(localLinkedHashSet, locali.b.b);
    }
    while (true)
    {
      this.e.remove(paramInt1);
      synchronized (this.f)
      {
        this.f.remove(Long.valueOf(paramLong));
        return;
      }
      localb.a.a(paramInt2);
    }
  }

  public static abstract interface a
  {
    public abstract void a(int paramInt);

    public abstract void a(Set<Member> paramSet, boolean paramBoolean);
  }

  private static class b
  {
    p.a a;

    public b(p.a parama)
    {
      this.a = parama;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.p
 * JD-Core Version:    0.6.2
 */