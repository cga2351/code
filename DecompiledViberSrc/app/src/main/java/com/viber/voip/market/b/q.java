package com.viber.voip.market.b;

import android.app.Application;
import android.content.Intent;
import android.os.Handler;
import android.os.SystemClock;
import com.viber.common.dialogs.a.a;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.market.MarketPublicGroupInfo;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.messages.controller.bs.e;
import com.viber.voip.messages.controller.bs.e.a;
import com.viber.voip.messages.controller.bs.f;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.bv.d;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.messages.k;
import com.viber.voip.messages.m;
import com.viber.voip.model.entity.h;
import com.viber.voip.publicaccount.d.a;
import com.viber.voip.publicaccount.d.e;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.util.ViberActionRunner.aq;
import com.viber.voip.viberout.ui.TermsAndConditionsActivity.a;
import java.util.Set;

public class q
{
  private static final Logger c = ViberEnv.getLogger();
  protected MarketPublicGroupInfo a;
  protected String b;

  private void b(h paramh)
  {
    ViberActionRunner.aq.b(ViberApplication.getApplication(), paramh);
  }

  private void c(h paramh)
  {
    Intent localIntent = m.a(paramh.getId(), paramh.j(), false, false, false, false);
    localIntent.setFlags(0x10000000 | localIntent.getFlags());
    ViberApplication.getApplication().startActivity(localIntent);
  }

  protected void a(h paramh)
  {
    if (paramh == null)
      return;
    boolean bool = e.d();
    if (paramh.j() == 2)
    {
      if (bool)
      {
        b(paramh);
        return;
      }
      c(paramh);
      return;
    }
    com.viber.voip.model.entity.r localr = ab.b().d(paramh.k());
    if (localr.z())
    {
      if (bool);
      for (TermsAndConditionsActivity.a locala = TermsAndConditionsActivity.a.b; ; locala = TermsAndConditionsActivity.a.a)
      {
        com.viber.voip.ui.dialogs.r.b((int)SystemClock.elapsedRealtime(), paramh.getId(), paramh.k(), null, localr.d(), paramh.o(), 0L, "", locala, null).d();
        return;
      }
    }
    if (bool)
    {
      b(paramh);
      return;
    }
    c(paramh);
  }

  public void b(MarketPublicGroupInfo paramMarketPublicGroupInfo)
  {
    this.a = paramMarketPublicGroupInfo;
    c(paramMarketPublicGroupInfo);
  }

  protected void c(final MarketPublicGroupInfo paramMarketPublicGroupInfo)
  {
    if (a.a().e())
    {
      o.a().b(0, paramMarketPublicGroupInfo.groupId, 2, 5);
      return;
    }
    av.a(av.e.d).post(new Runnable()
    {
      public void run()
      {
        final ab localab = ab.b();
        h localh = localab.b(paramMarketPublicGroupInfo.groupId);
        if (localh != null)
        {
          q.this.a(localh);
          return;
        }
        Engine localEngine = ViberApplication.getInstance().getEngine(true);
        bs localbs = new bs(ViberApplication.getApplication());
        int i = localEngine.getPhoneController().generateSequence();
        PublicAccount localPublicAccount = new PublicAccount();
        localPublicAccount.setGroupID(paramMarketPublicGroupInfo.groupId);
        localPublicAccount.setGroupRole(3);
        localPublicAccount.setRevision(paramMarketPublicGroupInfo.revision);
        localPublicAccount.setGroupUri(paramMarketPublicGroupInfo.groupUri);
        bs.e locale = bs.e.a().a(true).a();
        final bs.f localf = localbs.a(i, paramMarketPublicGroupInfo.groupId, 3, localPublicAccount, locale);
        ViberApplication.getInstance().getMessagesManager().b().a(new bv.d()
        {
          public void onChange(Set<Long> paramAnonymous2Set, int paramAnonymous2Int, boolean paramAnonymous2Boolean1, boolean paramAnonymous2Boolean2)
          {
            h localh;
            if ((paramAnonymous2Boolean1) && (paramAnonymous2Set.contains(Long.valueOf(localf.f.getId()))))
            {
              ViberApplication.getInstance().getMessagesManager().b().b(this);
              localh = localab.b(q.1.this.a.groupId);
              if (localh != null);
            }
            else
            {
              return;
            }
            q.this.a(localh);
          }
        });
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.market.b.q
 * JD-Core Version:    0.6.2
 */