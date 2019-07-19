package com.viber.voip.messages.conversation.ui.view.a.b;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.support.percent.PercentRelativeLayout.a;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.widget.TextView;
import com.viber.voip.R.attr;
import com.viber.voip.R.dimen;
import com.viber.voip.R.fraction;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.adapter.k;
import com.viber.voip.messages.conversation.ui.ConversationFragment;
import com.viber.voip.messages.conversation.ui.SpamController;
import com.viber.voip.messages.conversation.ui.SpamController.b;
import com.viber.voip.messages.conversation.ui.presenter.banners.center.CenterBannerPresenter;
import com.viber.voip.messages.d.c;
import com.viber.voip.util.da;
import com.viber.voip.util.dc;
import com.viber.voip.util.dg;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f.a;
import com.viber.voip.widget.AvatarWithInitialsView;

public class b extends com.viber.voip.messages.conversation.ui.view.b.a<CenterBannerPresenter>
  implements SpamController.b, a
{
  private final SpamController a;
  private k b;
  private com.viber.voip.banner.notificationsoff.f g;
  private View h;
  private View i;
  private View j;

  public b(CenterBannerPresenter paramCenterBannerPresenter, Activity paramActivity, ConversationFragment paramConversationFragment, View paramView, boolean paramBoolean, SpamController paramSpamController)
  {
    super(paramCenterBannerPresenter, paramActivity, paramConversationFragment, paramView, paramBoolean);
    this.a = paramSpamController;
    this.a.a(this);
  }

  public void L_()
  {
    ((CenterBannerPresenter)this.mPresenter).b();
    this.g.i();
  }

  public void a()
  {
    if (this.i != null)
    {
      if ((!dj.c(this.d.getContext())) || (r()))
        break label46;
      if (this.i.getVisibility() == 0)
        dj.c(this.i, false);
    }
    return;
    label46: if (this.i.getVisibility() == 4)
      dj.c(this.i, true);
    View localView = this.i.findViewById(R.id.avatar);
    PercentRelativeLayout.a locala = (PercentRelativeLayout.a)localView.getLayoutParams();
    if (this.a.e())
    {
      locala.a().d = -1.0F;
      locala.topMargin = this.d.getResources().getDimensionPixelOffset(R.dimen.secret_chat_banner_margin_top_extra);
    }
    while (true)
    {
      localView.setLayoutParams(locala);
      return;
      locala.a().d = this.d.getResources().getFraction(R.fraction.secret_chat_banner_margin_top, 1, 1);
    }
  }

  public void a(int paramInt)
  {
    if (this.h == null)
    {
      this.h = new View(this.c);
      this.h.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      this.h.setClickable(true);
      ((ViewGroup)this.c.getWindow().getDecorView().getRootView()).addView(this.h);
    }
    switch (paramInt)
    {
    default:
      return;
    case 1:
      dj.c(this.h, 0);
      return;
    case 2:
    case 3:
    }
    dj.c(this.h, 8);
  }

  public void a(com.viber.voip.banner.notificationsoff.f paramf)
  {
    this.g = paramf;
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    if ((paramConversationItemLoaderEntity == null) || (!paramConversationItemLoaderEntity.isSecret()))
    {
      dj.b(this.i, false);
      return;
    }
    if (this.i == null)
      this.i = ((ViewStub)this.mRootView.findViewById(R.id.secret_chat_empty_banner_stub)).inflate();
    if (this.j == null)
    {
      ViewStub localViewStub = (ViewStub)this.mRootView.findViewById(R.id.empty_banner_options_stub);
      localViewStub.setLayoutResource(R.layout.secret_chat_empty_banner_options);
      this.j = localViewStub.inflate();
    }
    label111: AvatarWithInitialsView localAvatarWithInitialsView;
    Uri localUri;
    int k;
    if ((paramBoolean) && (dj.c(this.d.getActivity())))
    {
      dj.c(this.i, false);
      if (!paramBoolean)
        break label278;
      localAvatarWithInitialsView = (AvatarWithInitialsView)this.i.findViewById(R.id.avatar);
      if (!paramConversationItemLoaderEntity.isGroupBehavior())
        break label280;
      localUri = paramConversationItemLoaderEntity.getIconUri();
      k = dc.a(this.d.getActivity(), R.attr.conversationsListItemDefaultCommunityImage);
      localAvatarWithInitialsView.a(null, false);
    }
    while (true)
    {
      com.viber.voip.util.e.f localf = com.viber.voip.util.e.f.c(k).f().a(Integer.valueOf(k)).b(Integer.valueOf(k)).c();
      e.a(this.d.getActivity()).a(localUri, localAvatarWithInitialsView, localf);
      ConversationFragment localConversationFragment = this.d;
      int m = R.string.secret_chat_banner_title;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = dg.b(paramConversationItemLoaderEntity);
      String str2 = localConversationFragment.getString(m, arrayOfObject);
      ((TextView)this.i.findViewById(R.id.title)).setText(str2);
      a();
      return;
      dj.b(this.i, paramBoolean);
      break label111;
      label278: break;
      label280: String str1 = paramConversationItemLoaderEntity.getParticipantMemberId();
      localUri = c.c().a(str1, 1);
      k = dc.a(this.d.getActivity(), R.attr.contactDefaultPhotoMedium);
      localAvatarWithInitialsView.a(da.f(paramConversationItemLoaderEntity.getParticipantName()), true);
    }
  }

  public void a(k paramk)
  {
    this.b = paramk;
  }

  public void b()
  {
    a();
  }

  public void b(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    this.a.a(paramConversationItemLoaderEntity, this.b, paramBoolean);
  }

  public void c()
  {
    a();
  }

  public void d()
  {
    a();
  }

  public void e()
  {
    this.g.h();
  }

  public void f()
  {
    this.g.i();
  }

  public void g()
  {
    this.g.i();
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    a();
  }

  public void onStart()
  {
    this.g.f();
  }

  public void onStop()
  {
    this.g.g();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.view.a.b.b
 * JD-Core Version:    0.6.2
 */