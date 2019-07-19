package com.viber.voip.invitelinks;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.z;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.analytics.g;
import com.viber.voip.flatbuffers.model.msginfo.GroupReferralInfo;
import com.viber.voip.messages.a.c.b;
import com.viber.voip.messages.a.c.g;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.model.entity.h;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.util.ViberActionRunner;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class j extends i
  implements q.a
{
  private final Handler n;
  private final q o;
  private final Runnable p = new k(this);

  public j(Context paramContext, ab paramab, Handler paramHandler1, Handler paramHandler2, bv parambv, PhoneController paramPhoneController, GroupController paramGroupController, g paramg, CommunityFollowerData paramCommunityFollowerData, EventBus paramEventBus, q paramq)
  {
    super(paramContext, paramab, paramHandler1, parambv, paramPhoneController, paramGroupController, paramg, paramCommunityFollowerData, paramEventBus);
    this.n = paramHandler2;
    this.o = paramq;
  }

  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
      this.h.unregister(this);
    this.f = -1;
    this.b.b(this.g);
  }

  private void e(h paramh)
  {
    if (this.e.groupReferralInfo == null);
    for (boolean bool = true; ; bool = false)
    {
      a(bool);
      if (this.e.groupReferralInfo == null)
        break;
      this.o.a(this.e.groupReferralInfo, paramh, this);
      return;
    }
    j();
  }

  private void j()
  {
    this.n.removeCallbacks(this.p);
    z.a(this.i, DialogCode.D_PROGRESS);
  }

  public void a()
  {
  }

  protected void a(int paramInt)
  {
    a(true);
    super.a(paramInt);
    j();
  }

  public void a(h paramh)
  {
    this.h.unregister(this);
    j();
    d(paramh);
  }

  public void a(h paramh, long paramLong1, long paramLong2)
  {
    this.h.unregister(this);
    j();
    Intent localIntent = com.viber.voip.messages.m.a(paramh.getId(), paramLong1, paramLong2, 2000L, paramh.k(), "", "", paramh.j(), "", "", paramh.o(), -1, false, false, paramh.R(), paramh.aj(), paramh.ao()).putExtra("extra_search_message", true);
    ViberActionRunner.b(this.i, localIntent);
  }

  public void a(String paramString, GroupReferralInfo paramGroupReferralInfo)
  {
    this.h.unregister(this);
    com.viber.voip.ui.dialogs.k.n().d();
    j();
  }

  public void b()
  {
  }

  protected void b(h paramh)
  {
    e(paramh);
  }

  protected void d()
  {
    e(null);
  }

  protected void f()
  {
    this.f = this.c.generateSequence();
    this.b.a(this.g, this.k);
    if (!this.h.isRegistered(this))
      this.h.register(this);
    this.d.a(this.f, this.e.groupId, this.e.groupName, this.e.iconUri, this.e.tagLine, this.e.inviteToken, "", true, this.e.joinSource);
  }

  protected void g()
  {
  }

  public void h()
  {
    this.n.postDelayed(this.p, 300L);
    super.h();
  }

  @Subscribe(threadMode=ThreadMode.POSTING)
  public void onCancelReferralJoinEvent(c.b paramb)
  {
    this.k.post(new m(this, paramb));
  }

  @Subscribe(threadMode=ThreadMode.POSTING)
  public void onLastMessageIdReady(c.g paramg)
  {
    this.k.post(new l(this, paramg));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.invitelinks.j
 * JD-Core Version:    0.6.2
 */