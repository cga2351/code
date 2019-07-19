package com.viber.voip.messages.conversation.chatinfo.presentation.b;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.k.a;
import com.viber.common.dialogs.l.a;
import com.viber.jni.PeerTrustState.PeerTrustEnum;
import com.viber.jni.cdr.CdrConst.OriginalScreen;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.ae;
import com.viber.voip.messages.o.a;
import com.viber.voip.messages.ui.ConversationActivity;
import com.viber.voip.messages.ui.ConversationGalleryActivity;
import com.viber.voip.permissions.n;
import com.viber.voip.ui.dialogs.s;
import com.viber.voip.util.ViberActionRunner.aa;
import com.viber.voip.util.ViberActionRunner.an;
import com.viber.voip.util.ViberActionRunner.bm;
import com.viber.voip.util.ViberActionRunner.g;
import com.viber.voip.util.da;
import com.viber.voip.util.dg;

@SuppressLint({"SwitchIntDef"})
public class h
  implements g
{
  protected final Context a;
  private final j b;
  private final ICdrController c;

  public h(Context paramContext, j paramj, ICdrController paramICdrController)
  {
    this.a = paramContext;
    this.b = paramj;
    this.c = paramICdrController;
  }

  public void a()
  {
    b.a(this);
  }

  public void a(int paramInt)
  {
    if (this.b.s() == null)
      return;
    switch (paramInt)
    {
    default:
      return;
    case 1:
    }
    this.b.A();
  }

  public void a(int paramInt, boolean paramBoolean)
  {
    boolean bool = true;
    ConversationItemLoaderEntity localConversationItemLoaderEntity = this.b.s();
    if (localConversationItemLoaderEntity == null)
      return;
    switch (paramInt)
    {
    default:
      return;
    case 1:
      j localj2 = this.b;
      if (!localConversationItemLoaderEntity.isMuteConversation());
      while (true)
      {
        localj2.f(bool);
        return;
        bool = false;
      }
    case 2:
      this.b.g(false);
      return;
    case 3:
      this.b.x();
      return;
    case 4:
      this.b.H();
      return;
    case 5:
    }
    j localj1 = this.b;
    if (!paramBoolean);
    while (true)
    {
      localj1.i(bool);
      return;
      bool = false;
    }
  }

  public void a(PeerTrustState.PeerTrustEnum paramPeerTrustEnum)
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = this.b.s();
    if (localConversationItemLoaderEntity == null);
    Fragment localFragment;
    do
    {
      return;
      localFragment = this.b.r();
      if ((!localConversationItemLoaderEntity.isSecure()) && (PeerTrustState.PeerTrustEnum.SECURE_UNTRUSTED != paramPeerTrustEnum))
      {
        s.b().a(localFragment).b(localFragment);
        return;
      }
      if (PeerTrustState.PeerTrustEnum.SECURE_UNTRUSTED == paramPeerTrustEnum)
      {
        s.a(localConversationItemLoaderEntity.getParticipantName()).a(localFragment).b(localFragment);
        return;
      }
      if (PeerTrustState.PeerTrustEnum.SECURE_TRUSTED_BREACH == paramPeerTrustEnum)
      {
        s.b(localConversationItemLoaderEntity.getParticipantName()).a(localFragment).b(localFragment);
        return;
      }
    }
    while (PeerTrustState.PeerTrustEnum.SECURE_TRUSTED != paramPeerTrustEnum);
    s.a().b(localFragment);
  }

  public void a(aa paramaa)
  {
    if (this.b.q().a(n.m))
    {
      ConversationItemLoaderEntity localConversationItemLoaderEntity = this.b.s();
      if (localConversationItemLoaderEntity == null)
        return;
      ViberActionRunner.bm.a(this.a, paramaa.aD(), paramaa.a(), localConversationItemLoaderEntity);
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("is_wink", paramaa.aD());
    localBundle.putLong("message_id", paramaa.a());
    this.b.q().a(this.a, 130, n.m, localBundle);
  }

  public void a(ae paramae)
  {
    this.b.a(paramae);
  }

  public void b()
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = this.b.s();
    if (localConversationItemLoaderEntity == null)
      return;
    if (localConversationItemLoaderEntity.isCommunityType())
    {
      ViberActionRunner.g.a(this.a, localConversationItemLoaderEntity);
      return;
    }
    Intent localIntent = new Intent("com.viber.voip.action.BACKGROUND_GALLERY");
    localIntent.putExtra("thread_id", localConversationItemLoaderEntity.getId());
    if (localConversationItemLoaderEntity.isSecret())
      localIntent = com.viber.voip.ui.c.c.a(localIntent);
    this.b.startActivityForResult(localIntent, 2001);
  }

  public void b(int paramInt)
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = this.b.s();
    if (localConversationItemLoaderEntity == null)
      return;
    switch (paramInt)
    {
    case 4:
    default:
      return;
    case 2:
      this.b.a(1, "Participants List");
      return;
    case 3:
      ViberActionRunner.an.b(this.a, localConversationItemLoaderEntity);
      return;
    case 5:
    }
    this.b.v();
  }

  public void c()
  {
    e.a(this);
  }

  public void c(int paramInt)
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = this.b.s();
    if (localConversationItemLoaderEntity == null);
    String str;
    do
    {
      return;
      switch (paramInt)
      {
      case 3:
      case 5:
      case 8:
      case 9:
      case 13:
      default:
        return;
      case 1:
        this.b.I();
        return;
      case 2:
        ViberActionRunner.aa.a(this.b.r(), this.b.r().getChildFragmentManager(), o.a.h);
        return;
      case 4:
        this.b.J();
        return;
      case 6:
        this.b.h(true);
        return;
      case 7:
        this.b.h(false);
        return;
      case 10:
        this.b.M();
        return;
      case 11:
        this.b.j(true);
        return;
      case 12:
        this.b.j(false);
        return;
      case 14:
      }
      str = localConversationItemLoaderEntity.getParticipantMemberId();
    }
    while (da.a(str));
    this.b.c(str);
  }

  public void d()
  {
    e.b(this);
  }

  public void e()
  {
    e.c(this);
  }

  public void f()
  {
    FragmentActivity localFragmentActivity = this.b.getActivity();
    if ((localFragmentActivity instanceof ConversationActivity))
    {
      localConversationItemLoaderEntity = this.b.s();
      if (localConversationItemLoaderEntity != null);
    }
    while (localFragmentActivity == null)
    {
      ConversationItemLoaderEntity localConversationItemLoaderEntity;
      return;
      ((ConversationActivity)localFragmentActivity).a(localConversationItemLoaderEntity, null);
      return;
    }
    localFragmentActivity.finish();
  }

  public void g()
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = this.b.s();
    if (localConversationItemLoaderEntity == null)
      return;
    int i = CdrConst.OriginalScreen.fromConversationType(localConversationItemLoaderEntity.getConversationType());
    this.c.handleReportScreenDisplay(2, i);
    j localj = this.b;
    long l = localConversationItemLoaderEntity.getId();
    int j = localConversationItemLoaderEntity.getConversationType();
    if (!localConversationItemLoaderEntity.isNotShareablePublicAccount());
    for (boolean bool = true; ; bool = false)
    {
      localj.startActivity(ConversationGalleryActivity.a(l, j, bool, false, dg.b(localConversationItemLoaderEntity), localConversationItemLoaderEntity.getGroupRole()));
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.presentation.b.h
 * JD-Core Version:    0.6.2
 */