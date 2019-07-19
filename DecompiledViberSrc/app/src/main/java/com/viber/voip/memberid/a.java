package com.viber.voip.memberid;

import android.net.Uri;
import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.memberid.MemberIdMigrationWrapper;
import com.viber.jni.memberid.PhoneNumberToMidInfo;
import com.viber.jni.memberid.UsersMemberIdsMigrationDelegate;
import com.viber.jni.memberid.UsersMembersIdsMigrationListener;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.backup.g;
import com.viber.voip.backup.j;
import com.viber.voip.backup.t;
import com.viber.voip.settings.d.ac;
import com.viber.voip.settings.d.al;

public class a
  implements UsersMemberIdsMigrationDelegate, j
{
  public static final Logger a = ViberEnv.getLogger();
  d.al b;
  private final Engine c;
  private final dagger.a<b> d;
  private final Handler e;
  private int f;
  private d.a g = new d.a(av.e.f.a(), true)
  {
    public void a()
    {
      g.a().b(a.this);
      try
      {
        if (!d.ac.c.d())
          a.a(a.this);
        return;
      }
      finally
      {
      }
    }
  };

  a(Engine paramEngine, dagger.a<b> parama, Handler paramHandler)
  {
    com.viber.common.b.a[] arrayOfa = new com.viber.common.b.a[1];
    arrayOfa[0] = d.ac.a;
    this.b = new d.al(arrayOfa)
    {
      public void onPreferencesChanged(com.viber.common.b.a paramAnonymousa)
      {
        if (d.ac.a.d())
          a.a(a.this);
      }
    };
    this.c = paramEngine;
    this.d = parama;
    this.e = paramHandler;
    d.a(this.g);
    com.viber.voip.settings.d.a(this.b);
  }

  private b a()
  {
    return (b)this.d.get();
  }

  static void a(a parama)
  {
    try
    {
      com.viber.voip.settings.d.a(parama);
      if ((parama.b()) && (d.ac.c.d()))
        parama.onPreferencesChanged(d.ac.c);
      return;
    }
    finally
    {
    }
  }

  private void b()
  {
    this.e.post(new Runnable()
    {
      public void run()
      {
        try
        {
          d.ac.c.a(false);
          a.b(a.this);
          a.c(a.this);
          return;
        }
        finally
        {
        }
      }
    });
  }

  static void b(a parama)
  {
    com.viber.voip.settings.d.b(parama);
  }

  private void c()
  {
    a().a();
  }

  private void d()
  {
    String[] arrayOfString = a().b();
    if (arrayOfString.length > 0)
    {
      this.f = this.c.getPhoneController().generateSequence();
      this.c.getDelegatesManager().getUsersMembersIdsListener().registerDelegate(this, this.e);
      this.c.getMemberIdMigrationController().handleGetUserMemberIDs(arrayOfString, this.f);
      return;
    }
    a().c();
    e();
  }

  private void e()
  {
    try
    {
      d.ac.c.a(true);
      a().d();
      this.c.getDelegatesManager().getUsersMembersIdsListener().removeDelegate(this);
      return;
    }
    finally
    {
    }
  }

  public void a(Uri paramUri, int paramInt)
  {
  }

  public void a(Uri paramUri, com.viber.voip.backup.c.d paramd)
  {
  }

  public boolean a(Uri paramUri)
  {
    return false;
  }

  public void b(Uri paramUri)
  {
    if (t.d(paramUri))
      b();
  }

  public void c(Uri paramUri)
  {
  }

  public void onEnableMidMapping(boolean paramBoolean)
  {
  }

  public void onGetUserMemberIDsReply(PhoneNumberToMidInfo[] paramArrayOfPhoneNumberToMidInfo, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    if (this.f != paramInt1);
    do
    {
      return;
      if (paramInt3 == 0)
        a().a(paramArrayOfPhoneNumberToMidInfo);
    }
    while ((!paramBoolean) && (paramInt3 == 0));
    d();
  }

  public void onStartClientMigrateToMid()
  {
  }

  public static abstract class a extends d.b
  {
    public a(Handler paramHandler, boolean paramBoolean)
    {
      super(d.ac.c, paramBoolean);
    }

    public void onPreferencesChanged(com.viber.common.b.a parama)
    {
      if (d.ac.c.d())
        super.onPreferencesChanged(parama);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.memberid.a
 * JD-Core Version:    0.6.2
 */