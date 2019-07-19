package com.viber.voip.contacts.c.d;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.Handler;
import android.text.TextUtils;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.ci;
import com.viber.voip.messages.controller.ci.a;
import com.viber.voip.messages.controller.manager.ak;
import com.viber.voip.messages.k;
import com.viber.voip.messages.orm.creator.Creator;
import com.viber.voip.model.entity.g;
import com.viber.voip.model.entity.m;
import com.viber.voip.util.af;
import com.viber.voip.util.cj;
import com.viber.voip.util.x;

public abstract class r
{
  private static final Logger c = ViberEnv.getLogger();
  protected String a;
  protected String b;
  private final Handler d = av.e.c.a();
  private final Handler e = av.e.a.a();
  private final Context f;
  private g.a g;
  private boolean h;
  private boolean i;

  protected r(Context paramContext, g.a parama, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.f = paramContext.getApplicationContext();
    this.a = paramString1;
    this.b = paramString2;
    this.g = parama;
    this.h = paramBoolean;
  }

  private void a(ci.a parama, m paramm)
  {
    if (paramm != null)
      parama.onGetUserDetail(new m[] { paramm });
  }

  private void a(final g paramg, final int paramInt)
  {
    this.d.post(new Runnable()
    {
      public void run()
      {
        r.a(r.this, false);
        r.a(r.this, paramg, paramInt);
      }
    });
  }

  private void b(final g paramg, final int paramInt)
  {
    this.e.post(new Runnable()
    {
      public void run()
      {
        r.c(r.this).a(paramg, paramInt);
      }
    });
  }

  private void f()
  {
    if ((TextUtils.isEmpty(this.a)) && (TextUtils.isEmpty(this.b)))
      a(null, -1);
    ci.a local2;
    ci localci;
    do
    {
      return;
      local2 = new ci.a()
      {
        public void onGetUserDetail(m[] paramAnonymousArrayOfm)
        {
          g localg = x.a(paramAnonymousArrayOfm[0]);
          r.b(r.this, localg, 0);
        }

        public void onGetUserError()
        {
          if (TextUtils.isEmpty(r.this.a))
          {
            r.b(r.this, null, -1);
            return;
          }
          r.b(r.this, x.a(r.this.a, r.this.a, null, null), 1);
        }
      };
      localci = ViberApplication.getInstance().getMessagesManager().e();
      ak localak = ak.a();
      if (TextUtils.isEmpty(this.b))
      {
        a(local2, localak.b(this.a, 1));
        localci.b(this.a, local2, false);
        return;
      }
      m localm = localak.c(new Member(this.b), 1);
      if ((localm != null) && (!TextUtils.isEmpty(localm.getNumber())))
        a(local2, localm);
    }
    while (!cj.b(this.f));
    localci.a(this.b, local2, false);
  }

  protected final g a(String paramString, String[] paramArrayOfString)
  {
    Creator localCreator = g.a;
    Cursor localCursor = this.f.getContentResolver().query(localCreator.getContentUri(), localCreator.getProjections(), paramString, paramArrayOfString, null);
    g localg = null;
    if (localCursor != null)
    {
      boolean bool = localCursor.moveToFirst();
      localg = null;
      if (bool)
        localg = (g)localCreator.createInstance(localCursor);
    }
    af.a(localCursor);
    return localg;
  }

  public boolean a()
  {
    return this.h;
  }

  public final void b()
  {
    this.d.post(new Runnable()
    {
      public void run()
      {
        if (r.a(r.this))
          return;
        g localg = r.this.e();
        if (localg == null)
          localg = r.this.d();
        if (localg == null)
          localg = r.this.c();
        if (localg == null)
        {
          r.a(r.this, true);
          r.b(r.this);
          return;
        }
        r.a(r.this, localg, 0);
      }
    });
  }

  protected final g c()
  {
    boolean bool = TextUtils.isEmpty(this.b);
    g localg = null;
    if (!bool)
    {
      String[] arrayOfString = new String[1];
      arrayOfString[0] = this.b;
      localg = a("vibernumbers.member_id=?", arrayOfString);
    }
    return localg;
  }

  protected final g d()
  {
    boolean bool = TextUtils.isEmpty(this.a);
    g localg = null;
    if (!bool)
    {
      String[] arrayOfString = new String[2];
      arrayOfString[0] = this.a;
      arrayOfString[1] = this.a;
      localg = a("mime_type=0 AND (phonebookdata.data1=? OR phonebookdata.data2=?)", arrayOfString);
    }
    return localg;
  }

  protected abstract g e();

  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof r)) && (this.g.equals(((r)paramObject).g));
  }

  public int hashCode()
  {
    return 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.c.d.r
 * JD-Core Version:    0.6.2
 */