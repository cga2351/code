package com.viber.voip.messages.conversation.ui.presenter;

import android.arch.lifecycle.h;
import android.net.Uri;
import android.os.Handler;
import com.viber.common.b.b;
import com.viber.dexshared.Logger;
import com.viber.voip.R.drawable;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.g.a;
import com.viber.voip.invitelinks.d;
import com.viber.voip.invitelinks.d.c;
import com.viber.voip.messages.conversation.ui.view.ScreenshotConversationData;
import com.viber.voip.messages.conversation.ui.view.p;
import com.viber.voip.mvp.core.BaseMvpPresenter;
import com.viber.voip.mvp.core.State;
import com.viber.voip.registration.af;
import com.viber.voip.settings.d.au;
import com.viber.voip.user.InvitationCreator;
import com.viber.voip.util.ae;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class ShareScreenshotPresenter extends BaseMvpPresenter<p, State>
{
  private final Logger a = ViberEnv.getLogger(getClass());
  private ScreenshotConversationData b;
  private String c;
  private String d;
  private final String e;
  private final float f;
  private final EventBus g;
  private final Handler h;
  private final d i;
  private final af j;
  private final a k;

  public ShareScreenshotPresenter(ScreenshotConversationData paramScreenshotConversationData, EventBus paramEventBus, Handler paramHandler, d paramd, af paramaf, a parama)
  {
    this.b = paramScreenshotConversationData;
    this.c = paramScreenshotConversationData.getSceenshotUri().toString();
    this.d = this.c;
    this.f = paramScreenshotConversationData.getScreenshotRatio();
    this.e = paramScreenshotConversationData.getScreenshotFileTag();
    this.g = paramEventBus;
    this.h = paramHandler;
    this.i = paramd;
    this.j = paramaf;
    this.k = parama;
  }

  private void a(String paramString)
  {
    a locala = this.k;
    if (this.b.hasDoodle());
    for (String str = "Doodle Included"; ; str = "Standard")
    {
      locala.a(paramString, str, this.b.getAnalyticsChatType(), ae.b());
      return;
    }
  }

  private void d()
  {
    this.h.post(new x(this));
  }

  private void e()
  {
    ((p)this.mView).a();
    ((p)this.mView).a(R.drawable.forward_button_selector, R.string.share_screenshot_forward, new y(this));
    ((p)this.mView).a(R.drawable.share_button_selector, R.string.share_screenshot_share, new z(this));
  }

  private void f()
  {
    ((p)this.mView).a(this.c, this.b);
    a("Forward");
  }

  private void g()
  {
    int m;
    if (this.b.isCommunity())
      if (this.b.hasNameAndLink())
      {
        m = R.string.share_screenshot_shared_from_community;
        if ((!this.j.p()) && (!d.au.b.d()))
          break label106;
      }
    label106: for (boolean bool = true; ; bool = false)
    {
      String str = InvitationCreator.getInviteUrl(this.j.n(), InvitationCreator.INVITE_LINK_IGNORE_SOURCE.intValue(), bool);
      ((p)this.mView).a(m, this.c, this.b, str);
      a("Share Externally");
      return;
      m = R.string.share_screenshot_share_from_viber_link;
      break;
      m = R.string.share_screenshot_share_from_viber_link;
      break;
    }
  }

  public void a()
  {
    ((p)this.mView).b();
  }

  public void a(boolean paramBoolean)
  {
    this.b.setHasDoodle(paramBoolean);
    ((p)this.mView).a(this.c, this.f);
  }

  public void b()
  {
    ((p)this.mView).a(this.c, this.e);
  }

  public void onDestroy(h paramh)
  {
    super.onDestroy(paramh);
    this.g.unregister(this);
  }

  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onInviteLinkReceived(d.c paramc)
  {
    if (paramc.c == 0)
      this.b.setCommunityShareLink(paramc.d);
  }

  public void onResume(h paramh)
  {
    super.onResume(paramh);
    ((p)this.mView).a(this.c, this.f);
    e();
  }

  public void onStart(h paramh)
  {
    super.onStart(paramh);
    ((p)this.mView).a(this.d);
    if (this.b.isCommunity())
      d();
  }

  protected void onViewAttached(State paramState)
  {
    super.onViewAttached(paramState);
    if (!this.g.isRegistered(this))
      this.g.register(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.presenter.ShareScreenshotPresenter
 * JD-Core Version:    0.6.2
 */