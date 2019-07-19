package com.viber.voip.market.b;

import android.os.Bundle;
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
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.publicaccount.ae;
import com.viber.voip.messages.k;
import com.viber.voip.model.entity.h;
import com.viber.voip.viberout.ui.TermsAndConditionsActivity.a;
import java.util.Collections;

public class a extends q
{
  private static final Logger c = ViberEnv.getLogger();
  private boolean d;

  private void d(MarketPublicGroupInfo paramMarketPublicGroupInfo)
  {
    h localh = ab.b().b(paramMarketPublicGroupInfo.groupId);
    if (localh == null)
      return;
    new bs(ViberApplication.getApplication()).a(Collections.singleton(Long.valueOf(localh.getId())), localh.j());
  }

  public void a(MarketPublicGroupInfo paramMarketPublicGroupInfo, boolean paramBoolean1, boolean paramBoolean2, ae paramae)
  {
    this.a = paramMarketPublicGroupInfo;
    this.d = paramBoolean1;
    this.b = paramae.name();
    if (paramBoolean2)
    {
      super.c(this.a);
      return;
    }
    av.a(av.e.d).post(new b(this, paramMarketPublicGroupInfo));
  }

  protected void a(h paramh)
  {
    com.viber.voip.model.entity.r localr = ab.b().d(paramh.k());
    Engine localEngine = ViberApplication.getInstance().getEngine(true);
    ae localae = ae.valueOf(this.b);
    if ((localr != null) && (localr.z()) && (this.d))
    {
      Bundle localBundle = new Bundle();
      localBundle.putSerializable("follow_source", localae);
      com.viber.voip.ui.dialogs.r.b((int)SystemClock.elapsedRealtime(), paramh.getId(), paramh.k(), null, localr.d(), paramh.o(), 0L, "", TermsAndConditionsActivity.a.c, null).a(localBundle).d();
      return;
    }
    int i = localEngine.getPhoneController().generateSequence();
    ViberApplication.getInstance().getMessagesManager().d().a(i, this.a.groupId, this.a.groupUri, paramh.o(), paramh.q(), this.a.invitationToken, this.a.invitationNumber, false, localae);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.market.b.a
 * JD-Core Version:    0.6.2
 */