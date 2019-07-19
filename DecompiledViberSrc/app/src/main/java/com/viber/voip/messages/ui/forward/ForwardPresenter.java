package com.viber.voip.messages.ui.forward;

import android.arch.lifecycle.e;
import android.arch.lifecycle.e.b;
import android.arch.lifecycle.h;
import android.content.Intent;
import com.viber.voip.invitelinks.f;
import com.viber.voip.invitelinks.f.a;
import com.viber.voip.invitelinks.g;
import com.viber.voip.messages.conversation.publicaccount.PublicGroupConversationItemLoaderEntity;
import com.viber.voip.messages.forward.GroupReferralForwardInfo;
import com.viber.voip.mvp.core.BaseMvpPresenter;
import dagger.a;

public class ForwardPresenter extends BaseMvpPresenter<c, ForwardPresenterState>
  implements f.a
{
  private final a<f> a;
  private GroupReferralForwardInfo b;
  private boolean c;
  private Intent d;

  public ForwardPresenter(a<f> parama, GroupReferralForwardInfo paramGroupReferralForwardInfo)
  {
    this.a = parama;
    this.b = paramGroupReferralForwardInfo;
  }

  private void a(String paramString)
  {
    this.c = true;
    if (this.b != null)
      this.b.setInviteLink(paramString);
    if ((this.d != null) && (this.mLifecycle != null) && (this.mLifecycle.a().a(e.b.d)))
    {
      ((c)this.mView).a(false);
      ((c)this.mView).a(this.d, this.b);
    }
  }

  private void g()
  {
    a(null);
  }

  public void a()
  {
    g();
  }

  public void a(long paramLong, String paramString)
  {
    a(paramString);
  }

  public void a(Intent paramIntent)
  {
    if ((this.b != null) && (!this.c))
    {
      this.d = paramIntent;
      ((c)this.mView).a(true);
      return;
    }
    ((c)this.mView).a(paramIntent);
  }

  public void a(PublicGroupConversationItemLoaderEntity paramPublicGroupConversationItemLoaderEntity, String paramString)
  {
    g.a(this, paramPublicGroupConversationItemLoaderEntity, paramString);
  }

  protected void a(ForwardPresenterState paramForwardPresenterState)
  {
    super.onViewAttached(paramForwardPresenterState);
    if (paramForwardPresenterState != null)
    {
      this.b = paramForwardPresenterState.getGroupReferralForwardInfo();
      this.c = paramForwardPresenterState.isGroupLinkRequestFinished();
      this.d = paramForwardPresenterState.getPendingForwardIntent();
    }
    if ((this.b != null) && (!this.c))
      ((f)this.a.get()).a(this.b.getGroupId(), this.b.getGroupRole(), true, this);
  }

  public void b()
  {
    g();
  }

  public void c()
  {
    g();
  }

  public void d()
  {
    g();
  }

  protected ForwardPresenterState e()
  {
    if ((this.b != null) || (this.d != null))
      return new ForwardPresenterState(this.b, this.c, this.d);
    return (ForwardPresenterState)super.getSaveState();
  }

  public GroupReferralForwardInfo f()
  {
    if (this.c)
      return this.b;
    return null;
  }

  public void onStart(h paramh)
  {
    super.onStart(paramh);
    if ((this.d != null) && (this.c))
    {
      ((c)this.mView).a(false);
      ((c)this.mView).a(this.d, this.b);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.forward.ForwardPresenter
 * JD-Core Version:    0.6.2
 */