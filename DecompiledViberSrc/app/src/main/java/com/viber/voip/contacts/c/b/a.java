package com.viber.voip.contacts.c.b;

import android.content.Context;
import android.os.Handler;
import android.util.Pair;
import com.viber.dexshared.Logger;
import com.viber.jni.BlockListInfo;
import com.viber.jni.Engine;
import com.viber.jni.Engine.InitializedListener;
import com.viber.jni.connection.ConnectionDelegate;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.block.g;
import com.viber.voip.contacts.c.c.a.c;
import com.viber.voip.contacts.c.c.c.a;
import com.viber.voip.memberid.Member;
import com.viber.voip.memberid.a.a;
import com.viber.voip.memberid.d;
import com.viber.voip.memberid.d.a;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.d.p;
import java.util.Set;

public class a extends b
  implements ConnectionDelegate
{
  private static final Logger a = ViberEnv.getLogger();
  private Engine b;
  private com.viber.voip.contacts.c.e.a c;
  private c d;
  private int e;
  private c.a f = new c.a()
  {
    public void a(Set<Member> paramAnonymousSet, boolean paramAnonymousBoolean)
    {
      a.a(a.this, true);
      a.a(a.this);
    }

    public void b(Set<Member> paramAnonymousSet, boolean paramAnonymousBoolean)
    {
      a.a(a.this, true);
      a.a(a.this);
    }
  };
  private d.a g = new d.a(av.a(av.e.c), false)
  {
    public void a()
    {
      a.a(a.this);
    }
  };
  private a.a h = new a.a(av.a(av.e.c), false)
  {
    public void a()
    {
      a.a(a.this);
    }
  };
  private Engine.InitializedListener i = new Engine.InitializedListener()
  {
    public void initialized(Engine paramAnonymousEngine)
    {
      if (!ao.f())
        a.a(a.this);
      while (true)
      {
        a.b(a.this).removeInitializedListener(this);
        return;
        g.b();
      }
    }
  };

  public a(Context paramContext)
  {
    this.c = new com.viber.voip.contacts.c.e.a(paramContext);
  }

  private void a(boolean paramBoolean)
  {
    d.p.m.a(paramBoolean);
  }

  private void b()
  {
    if (!ViberApplication.isActivated())
      return;
    Pair localPair = this.c.a();
    g.a((Set)localPair.first);
    this.e = this.b.getPhoneController().generateSequence();
    boolean bool = c();
    this.b.getPhoneController().handleBlockListByReason((BlockListInfo[])localPair.second, this.e, bool);
  }

  private boolean c()
  {
    return d.p.m.d();
  }

  public void a()
  {
    this.b.removeInitializedListener(this.i);
    this.b = null;
    this.d.b(this.f);
    this.d = null;
    d.b(this.g);
    d.b(this.h);
  }

  public void a(Engine paramEngine)
  {
    this.b = paramEngine;
    this.b.addInitializedListener(this.i);
    this.d = new c();
    this.d.a(this.f);
    d.a(this.g);
    d.a(this.h);
  }

  public void onBlockListReply(int paramInt)
  {
    if (this.e == paramInt)
      a(false);
  }

  public void onConnect()
  {
  }

  public void onConnectionStateChange(int paramInt)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.c.b.a
 * JD-Core Version:    0.6.2
 */