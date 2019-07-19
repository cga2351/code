package com.viber.voip.invitelinks;

import android.content.Context;
import android.os.Handler;
import com.viber.common.dialogs.h.a;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.analytics.g;
import com.viber.voip.messages.a.d.d;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.model.entity.h;
import com.viber.voip.ui.dialogs.d;
import com.viber.voip.ui.dialogs.k;
import org.greenrobot.eventbus.EventBus;

public class i extends a
{
  protected final EventBus h;
  private final g n;

  public i(Context paramContext, ab paramab, Handler paramHandler, bv parambv, PhoneController paramPhoneController, GroupController paramGroupController, g paramg, CommunityFollowerData paramCommunityFollowerData, EventBus paramEventBus)
  {
    super(paramContext, paramab, paramHandler, parambv, paramPhoneController, paramGroupController, paramCommunityFollowerData);
    this.n = paramg;
    this.h = paramEventBus;
  }

  protected void a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      k.n().d();
      return;
    case 7:
      d.m().d();
      return;
    case 8:
    }
    d.q().d();
  }

  protected void b(h paramh)
  {
    d(paramh);
  }

  protected void c()
  {
    this.n.a(com.viber.voip.analytics.a.i.b(this.e.groupId));
    this.h.post(new d.d(5));
    g();
  }

  protected void d()
  {
    g();
  }

  protected void g()
  {
    new ad(this.i, this.j, this.k, this.e.groupId, this.m).h();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.invitelinks.i
 * JD-Core Version:    0.6.2
 */