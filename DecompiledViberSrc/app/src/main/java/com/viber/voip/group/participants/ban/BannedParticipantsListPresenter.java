package com.viber.voip.group.participants.ban;

import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.im2.CGroupBanUserReplyMsg;
import com.viber.jni.im2.CGroupBanUserReplyMsg.Receiver;
import com.viber.jni.im2.Im2Exchanger;
import com.viber.voip.ViberEnv;
import com.viber.voip.group.participants.settings.d;
import com.viber.voip.group.participants.settings.d.a;
import com.viber.voip.invitelinks.linkscreen.g.a;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.mvp.core.BaseMvpPresenter;

public class BannedParticipantsListPresenter extends BaseMvpPresenter<a, BannedParticipantsPresenterState>
  implements CGroupBanUserReplyMsg.Receiver, d.a, g.a
{
  private static final Logger a = ViberEnv.getLogger();
  private long b;
  private PhoneController c;
  private com.viber.voip.messages.controller.a d;
  private com.viber.voip.invitelinks.linkscreen.g e;
  private d f;
  private Handler g;
  private Im2Exchanger h;
  private h i;
  private int j;
  private boolean k;
  private boolean l;
  private boolean m;
  private Runnable n = new g(this);

  public BannedParticipantsListPresenter(long paramLong, Handler paramHandler, Im2Exchanger paramIm2Exchanger, PhoneController paramPhoneController, com.viber.voip.messages.controller.a parama, com.viber.voip.invitelinks.linkscreen.g paramg, d paramd, h paramh)
  {
    this.e = paramg;
    this.f = paramd;
    this.d = parama;
    this.c = paramPhoneController;
    this.b = paramLong;
    this.g = paramHandler;
    this.h = paramIm2Exchanger;
    this.i = paramh;
    this.e.a();
  }

  private void c(boolean paramBoolean)
  {
    this.g.removeCallbacks(this.n);
    if (paramBoolean)
    {
      this.g.postDelayed(this.n, 500L);
      return;
    }
    ((a)this.mView).b(false);
  }

  public void a(int paramInt1, int paramInt2)
  {
    this.i.a(paramInt1, paramInt2);
  }

  protected void a(BannedParticipantsPresenterState paramBannedParticipantsPresenterState)
  {
    boolean bool1 = true;
    super.onViewAttached(paramBannedParticipantsPresenterState);
    int i1;
    boolean bool2;
    if (paramBannedParticipantsPresenterState != null)
    {
      i1 = paramBannedParticipantsPresenterState.getActionSequence();
      this.j = i1;
      if ((paramBannedParticipantsPresenterState == null) || (!paramBannedParticipantsPresenterState.isListWasRequested()))
        break label79;
      bool2 = bool1;
      label35: this.m = bool2;
      if ((paramBannedParticipantsPresenterState == null) || (!paramBannedParticipantsPresenterState.isEditModeEnabled()))
        break label85;
    }
    while (true)
    {
      this.k = bool1;
      ((a)this.mView).c(this.k);
      return;
      i1 = 0;
      break;
      label79: bool2 = false;
      break label35;
      label85: bool1 = false;
    }
  }

  public void a(String paramString)
  {
    if (this.c.isConnected())
    {
      ConversationItemLoaderEntity localConversationItemLoaderEntity = this.e.b();
      if (localConversationItemLoaderEntity != null)
      {
        c(true);
        this.j = this.c.generateSequence();
        this.d.b(this.j, paramString, localConversationItemLoaderEntity.getGroupId());
      }
      return;
    }
    ((a)this.mView).c();
  }

  public void a(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }

  public boolean a()
  {
    return this.k;
  }

  public void b(boolean paramBoolean)
  {
    int i1 = this.f.c();
    ConversationItemLoaderEntity localConversationItemLoaderEntity = this.e.b();
    if ((i1 > 0) && ((localConversationItemLoaderEntity == null) || (!localConversationItemLoaderEntity.isCommunityBlocked())));
    for (boolean bool = true; ; bool = false)
    {
      ((a)this.mView).b();
      if ((paramBoolean) || (this.l != bool))
      {
        this.l = bool;
        ((a)this.mView).a(bool);
      }
      return;
    }
  }

  public boolean b()
  {
    return this.l;
  }

  protected BannedParticipantsPresenterState c()
  {
    return new BannedParticipantsPresenterState(this.j, this.m, this.k);
  }

  public void d()
  {
    this.i.a();
  }

  public void onCGroupBanUserReplyMsg(CGroupBanUserReplyMsg paramCGroupBanUserReplyMsg)
  {
    if (paramCGroupBanUserReplyMsg.seq != this.j)
      return;
    this.j = -1;
    c(false);
    switch (paramCGroupBanUserReplyMsg.status)
    {
    case 0:
    default:
      ((a)this.mView).e();
      return;
    case 4:
    }
    ((a)this.mView).d();
  }

  public void onConversationDeleted()
  {
    ((a)this.mView).a();
  }

  public void onConversationReceived(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    ((a)this.mView).a(paramConversationItemLoaderEntity);
    if ((this.f.c() > 0) && (!paramConversationItemLoaderEntity.isCommunityBlocked()));
    for (boolean bool = true; ; bool = false)
    {
      if (this.l != bool)
      {
        this.l = bool;
        if (!bool)
          this.k = false;
        ((a)this.mView).a(bool);
      }
      if ((!this.m) && (this.c.isConnected()))
      {
        this.d.a(paramConversationItemLoaderEntity.getGroupId());
        this.m = true;
      }
      return;
    }
  }

  public void onDestroy(android.arch.lifecycle.h paramh)
  {
    super.onDestroy(paramh);
    this.e.d();
    this.f.b();
  }

  public void onStart(android.arch.lifecycle.h paramh)
  {
    super.onStart(paramh);
    this.e.a(this);
    this.f.a(this);
    this.f.a(this.b);
    this.h.registerDelegate(this, this.g);
    c(this.d.a(this.j));
  }

  public void onStop(android.arch.lifecycle.h paramh)
  {
    super.onStop(paramh);
    this.e.c();
    this.f.a();
    this.h.removeDelegate(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.group.participants.ban.BannedParticipantsListPresenter
 * JD-Core Version:    0.6.2
 */