package com.viber.voip.contacts.c.d.a;

import android.accounts.Account;
import android.content.ContentUris;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.provider.ContactsContract.Contacts;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.contacts.c.d.f;
import com.viber.voip.contacts.c.d.g;
import com.viber.voip.contacts.c.d.g.b;
import com.viber.voip.contacts.c.d.g.h;
import com.viber.voip.contacts.c.d.i;
import com.viber.voip.contacts.c.d.n;
import com.viber.voip.contacts.c.f.a.a.a.c;
import com.viber.voip.contacts.c.f.b.c;
import com.viber.voip.memberid.Member;
import com.viber.voip.util.dd;
import com.viber.voip.util.e.e;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class b extends i
  implements a.c
{
  private static final Logger k = ViberEnv.getLogger("ContactsManagerPrimaryImpl [Primary]");
  private static b l;
  private Handler m;
  private com.viber.voip.contacts.c.f.a.a.a n;
  private com.viber.voip.contacts.c.f.b.a.a o;
  private a p;
  private Set<g.b> q = Collections.synchronizedSet(new HashSet());
  private Boolean r;
  private Runnable s = new Runnable()
  {
    public void run()
    {
      b.b(b.this).j();
    }
  };

  private b(Context paramContext, ViberApplication paramViberApplication)
  {
    super(paramContext, paramViberApplication);
    dd.b();
    this.m = av.a(av.e.c);
    this.o = new com.viber.voip.contacts.c.f.b.a.a(paramContext, this.d, this, this.f);
    this.n = new com.viber.voip.contacts.c.f.a.a.a(paramContext, this.d, this);
    this.p = new a(paramContext, this.f);
    this.r = Boolean.TRUE;
    com.viber.service.contacts.sync.a.a().a(com.viber.voip.contacts.c.f.a.a(paramContext));
    this.d.getEngine(false).addInitializedListener(this);
  }

  public static g a(Context paramContext, ViberApplication paramViberApplication)
  {
    if ((l == null) && (com.viber.voip.o.a.a == com.viber.voip.o.a.a()));
    try
    {
      if (l == null)
        l = new b(paramContext, paramViberApplication);
      return l;
    }
    finally
    {
    }
  }

  public void a()
  {
    super.a();
    this.n.b();
    try
    {
      l = null;
      return;
    }
    finally
    {
    }
  }

  public void a(Account paramAccount, String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, g.h paramh)
  {
    this.n.a(paramAccount, paramString1, paramString2, paramString3, paramBitmap, paramh);
  }

  public void a(Member paramMember)
  {
    d().a(paramMember);
  }

  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.o != null))
    {
      this.m.removeCallbacks(this.s);
      this.m.postDelayed(this.s, 1000L);
    }
    d(this.i);
  }

  public void b()
  {
    if (ViberApplication.getInstance().getEngine(false).isInitialized())
      try
      {
        this.r = Boolean.valueOf(false);
        this.n.a(true);
        return;
      }
      finally
      {
      }
    try
    {
      this.r = Boolean.valueOf(true);
      return;
    }
    finally
    {
    }
  }

  public void b(HashMap<Long, Long> paramHashMap, Set<Long> paramSet)
  {
    j();
    this.p.a(paramHashMap, paramSet);
    a(paramHashMap, paramSet);
  }

  public void b(Map<String, Long> paramMap)
  {
    this.p.a(paramMap);
    a(paramMap);
  }

  public c d()
  {
    return this.o;
  }

  public void e(Set<Long> paramSet)
  {
    this.p.a(paramSet);
    HashSet localHashSet = new HashSet(paramSet.size());
    Iterator localIterator = paramSet.iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      localHashSet.add(ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, localLong.longValue()));
    }
    e.a(this.c).a(localHashSet);
  }

  public void f(Set<Long> paramSet)
  {
    this.p.b();
    b(paramSet);
  }

  public void initialized(Engine paramEngine)
  {
    super.initialized(paramEngine);
    try
    {
      boolean bool = this.r.booleanValue();
      int i = 0;
      if (bool)
      {
        this.r = Boolean.valueOf(false);
        i = 1;
      }
      if (i != 0)
        this.n.a(true);
      return;
    }
    finally
    {
    }
  }

  protected f k()
  {
    return this.p;
  }

  protected void l()
  {
    this.a.postDelayed(new Runnable()
    {
      public void run()
      {
        com.viber.service.contacts.a.a.a(b.a(b.this));
      }
    }
    , 5000L);
  }

  protected void m()
  {
    com.viber.service.contacts.a.a.a(this.c);
  }

  public boolean n()
  {
    return this.n.c();
  }

  public void s()
  {
    e().b();
    d().e();
  }

  public void t()
  {
    this.o.onShareAddressBook();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.c.d.a.b
 * JD-Core Version:    0.6.2
 */