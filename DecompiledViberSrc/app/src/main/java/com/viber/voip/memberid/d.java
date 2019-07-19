package com.viber.voip.memberid;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import c.a.a.a.c;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.connection.ConnectionDelegate;
import com.viber.jni.connection.ConnectionListener;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.memberid.MemberIdMigrationWrapper;
import com.viber.jni.memberid.PhoneNumberToMidInfo;
import com.viber.jni.memberid.UsersMemberIdsMigrationDelegate;
import com.viber.jni.memberid.UsersMembersIdsMigrationListener;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.messages.controller.manager.ak;
import com.viber.voip.model.e;
import com.viber.voip.model.entity.m;
import com.viber.voip.settings.d.ac;
import com.viber.voip.settings.d.al;
import com.viber.voip.util.IntPair;
import com.viber.voip.util.ce;
import com.viber.voip.util.cj;
import com.viber.voip.util.i;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class d
  implements ConnectionDelegate, UsersMemberIdsMigrationDelegate, com.viber.voip.util.d.b
{
  public static final Logger a = ViberEnv.getLogger();
  private static d b;
  private Engine c;
  private Context d;
  private ViberApplication e;
  private a f;
  private dagger.a<b> g;
  private Handler h;
  private Object i;
  private IntPair j;
  private int k;

  private d(Context paramContext, ViberApplication paramViberApplication, Engine paramEngine)
  {
    this.d = paramContext;
    this.e = paramViberApplication;
    this.c = paramEngine;
    this.h = av.e.f.a();
    this.i = new Object();
    this.g = new com.viber.voip.g.b.b()
    {
      protected b a()
      {
        return new b(d.a(d.this));
      }
    };
    this.f = new a(this.c, this.g, this.h);
    if (c())
      return;
    this.c.getDelegatesManager().getUsersMembersIdsListener().registerDelegate(this, this.h);
  }

  public static void a()
  {
    if (!d())
      return;
    try
    {
      d.ac.b.a(c.f.ordinal());
      return;
    }
    finally
    {
    }
  }

  public static void a(Context paramContext, ViberApplication paramViberApplication, Engine paramEngine)
  {
    if ((b == null) && (d()))
      try
      {
        if (b == null)
          b = new d(paramContext, paramViberApplication, paramEngine);
        return;
      }
      finally
      {
      }
  }

  private static void a(Bundle paramBundle, String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (!"unknown_number".equals(paramString2)))
      paramBundle.putString(paramString1, paramString2);
  }

  public static void a(a.a parama)
  {
    if (!d())
      return;
    a.a(parama);
  }

  public static void a(a parama)
  {
    if (!d())
      return;
    try
    {
      if ((parama.b()) && (c()))
      {
        parama.onPreferencesChanged(d.ac.b);
        return;
      }
    }
    finally
    {
    }
    com.viber.voip.settings.d.a(parama);
  }

  private void a(c paramc)
  {
    int m = paramc.ordinal();
    try
    {
      int n = d.ac.b.d();
      if (m != n)
      {
        d.ac.b.a(m);
        com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.story.l.d.a(c.values()[m].name()));
      }
      if (c.i())
        com.crashlytics.android.a.a("MigrationState", n + "->" + m);
      switch (3.a[paramc.ordinal()])
      {
      default:
        return;
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      }
    }
    finally
    {
    }
    f();
    return;
    g();
    return;
    h();
    return;
    i();
    return;
    j();
  }

  public static void a(String[] paramArrayOfString, Bundle paramBundle)
  {
    Iterator localIterator = ak.a().b(new HashSet(Arrays.asList(paramArrayOfString))).iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      a(paramBundle, localm.a(), localm.getNumber());
    }
  }

  public static boolean a(String paramString)
  {
    return (c()) && (ce.l.matcher(paramString).matches());
  }

  public static boolean a(String paramString, Bundle paramBundle)
  {
    Set localSet1 = e.b(paramString);
    Set localSet2 = paramBundle.keySet();
    ArrayList localArrayList = new ArrayList(localSet1.size());
    Iterator localIterator = localSet1.iterator();
    int m = 0;
    if (localIterator.hasNext())
    {
      com.viber.voip.model.a.d.a locala = (com.viber.voip.model.a.d.a)localIterator.next();
      if (localSet2.contains(locala.b()))
        localArrayList.add(com.viber.voip.model.a.d.a.a(paramString, paramBundle.getString(locala.b()), (String)locala.c()));
      for (int n = m + 1; ; n = m)
      {
        m = n;
        break;
      }
    }
    e.a(localArrayList);
    return true;
  }

  public static void b()
  {
    try
    {
      d.ac.b.e();
      return;
    }
    finally
    {
    }
  }

  public static void b(a.a parama)
  {
    if (!d())
      return;
    a.b(parama);
  }

  public static void b(a parama)
  {
    if (!d())
      return;
    com.viber.voip.settings.d.b(parama);
  }

  public static void b(String[] paramArrayOfString, Bundle paramBundle)
  {
    Iterator localIterator = ak.a().a(new HashSet(Arrays.asList(paramArrayOfString))).iterator();
    while (localIterator.hasNext())
    {
      m localm = (m)localIterator.next();
      a(paramBundle, localm.getNumber(), localm.a());
    }
  }

  public static boolean c()
  {
    boolean bool = true;
    if (!d())
      return bool;
    while (true)
    {
      try
      {
        c localc = c.values()[d.ac.b.d()];
        if ((c.f == localc) || (c.f == localc))
          return bool;
      }
      finally
      {
      }
      bool = false;
    }
  }

  private static boolean d()
  {
    return com.viber.voip.o.a.a == com.viber.voip.o.a.a();
  }

  private b e()
  {
    return (b)this.g.get();
  }

  private void f()
  {
    com.viber.voip.util.d.c(this);
  }

  private void g()
  {
    com.viber.voip.util.d.d(this);
    e().a();
    a(c.c);
  }

  private void h()
  {
    String[] arrayOfString = e().b();
    if (arrayOfString.length == 0)
    {
      a(c.d);
      return;
    }
    this.k = this.c.getPhoneController().generateSequence();
    this.j = new IntPair(this.k, arrayOfString.length);
    this.c.getMemberIdMigrationController().handleGetUserMemberIDs(arrayOfString, this.k);
  }

  private void i()
  {
    this.c.getMemberIdMigrationController().handleDoneMidMapping();
  }

  private void j()
  {
    this.c.getDelegatesManager().getUsersMembersIdsListener().removeDelegate(this);
  }

  private boolean k()
  {
    return 2 == com.viber.voip.backup.g.a().c();
  }

  public void onAppStopped()
  {
    i.c(this);
  }

  public void onBackground()
  {
    this.h.removeCallbacksAndMessages(this.i);
    this.h.postAtTime(new Runnable()
    {
      public void run()
      {
        boolean bool = d.b(d.this).getPhoneController().isConnected();
        if (d.c(d.this));
        do
        {
          return;
          com.viber.voip.util.d.d(d.this);
        }
        while (!bool);
        d.a(d.this, d.c.b);
      }
    }
    , this.i, 10000L + SystemClock.uptimeMillis());
  }

  public void onConnect()
  {
    this.c.getDelegatesManager().getConnectionListener().removeDelegate(this);
    a(c.f);
  }

  public void onConnectionStateChange(int paramInt)
  {
  }

  public void onEnableMidMapping(boolean paramBoolean)
  {
    boolean bool = this.e.isOnForeground();
    if ((paramBoolean) && (!c()))
      if ((!bool) && (!k()))
        break label39;
    label39: for (c localc = c.a; ; localc = c.b)
    {
      a(localc);
      return;
    }
  }

  public void onForeground()
  {
    this.h.removeCallbacksAndMessages(this.i);
  }

  public void onForegroundStateChanged(boolean paramBoolean)
  {
    i.a(this, paramBoolean);
  }

  public void onGetUserMemberIDsReply(PhoneNumberToMidInfo[] paramArrayOfPhoneNumberToMidInfo, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    if (this.k != paramInt1);
    do
    {
      return;
      if (paramInt3 != 0)
      {
        int m = -1;
        if ((this.j != null) && (this.j.first == paramInt1))
          m = this.j.second;
        com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.story.l.d.a(c.values()[d.ac.b.d()].name(), paramInt3, m, cj.g(this.d)));
      }
      if (paramInt3 == 0)
        e().a(paramArrayOfPhoneNumberToMidInfo);
    }
    while ((!paramBoolean) && (paramInt3 == 0));
    a(c.b);
  }

  public void onStartClientMigrateToMid()
  {
    e().c();
    e().d();
    this.c.getDelegatesManager().getConnectionListener().registerDelegate(new com.viber.voip.util.d.b[] { this });
    this.c.getMemberIdMigrationController().handleDoneClientMigrationToMid();
  }

  public static abstract class a extends d.b
  {
    public a(Handler paramHandler, boolean paramBoolean)
    {
      super(d.ac.b, paramBoolean);
    }

    public void onPreferencesChanged(com.viber.common.b.a parama)
    {
      if (d.c())
        super.onPreferencesChanged(parama);
    }
  }

  static abstract class b extends d.al
  {
    private Handler a;
    private boolean b;

    protected b(Handler paramHandler, com.viber.common.b.a parama, boolean paramBoolean)
    {
      super(new com.viber.common.b.a[] { parama });
      this.a = paramHandler;
      this.b = paramBoolean;
    }

    public abstract void a();

    public boolean b()
    {
      return this.b;
    }

    public void onPreferencesChanged(com.viber.common.b.a parama)
    {
      if (Looper.myLooper() == this.a.getLooper())
      {
        a();
        return;
      }
      this.a.post(new Runnable()
      {
        public void run()
        {
          d.b.this.a();
        }
      });
    }
  }

  private static enum c
  {
    static
    {
      c[] arrayOfc = new c[6];
      arrayOfc[0] = a;
      arrayOfc[1] = b;
      arrayOfc[2] = c;
      arrayOfc[3] = d;
      arrayOfc[4] = e;
      arrayOfc[5] = f;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.memberid.d
 * JD-Core Version:    0.6.2
 */