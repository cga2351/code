package com.viber.voip.messages.conversation;

import android.content.Context;
import android.support.v4.app.LoaderManager;
import com.viber.provider.d;
import com.viber.provider.d.a;
import com.viber.provider.messages.b.c.d;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.e;
import com.viber.voip.messages.controller.bv.n;
import com.viber.voip.messages.controller.bz;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.model.entity.m;
import dagger.a;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract class c<T> extends d<T>
{
  protected final a<bv> l;
  private String m;
  private bv.e n;
  private final bv.n o = new bv.n()
  {
    public void onChange(Set<Long> paramAnonymousSet, Set<String> paramAnonymousSet1, boolean paramAnonymousBoolean)
    {
      c.this.l();
    }

    public void onContactStatusChanged(Map paramAnonymousMap)
    {
      bz.a(this, paramAnonymousMap);
    }

    public void onInitCache()
    {
      c.this.l();
    }

    public void onNewInfo(List paramAnonymousList, boolean paramAnonymousBoolean)
    {
      bz.a(this, paramAnonymousList, paramAnonymousBoolean);
    }

    public void onParticipantDeleted(m paramAnonymousm)
    {
      bz.a(this, paramAnonymousm);
    }
  };

  protected c(int paramInt1, Context paramContext, LoaderManager paramLoaderManager, a<bv> parama, d.a parama1, int paramInt2)
  {
    super(paramInt1, c.d.c, paramContext, paramLoaderManager, parama1, paramInt2);
    this.l = parama;
    a(ab.g);
  }

  private bv.e s()
  {
    if (this.n == null)
      this.n = r();
    return this.n;
  }

  public final void f(String paramString)
  {
    this.m = paramString;
    b(new String[] { paramString });
  }

  public void p()
  {
    super.p();
    ((bv)this.l.get()).a(s());
    ((bv)this.l.get()).a(this.o);
  }

  public void q()
  {
    super.q();
    if (this.n != null)
      ((bv)this.l.get()).b(this.n);
    ((bv)this.l.get()).b(this.o);
  }

  protected abstract bv.e r();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.c
 * JD-Core Version:    0.6.2
 */