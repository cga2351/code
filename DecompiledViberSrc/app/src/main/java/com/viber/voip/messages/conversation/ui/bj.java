package com.viber.voip.messages.conversation.ui;

import android.app.Activity;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.banner.ConversationAlertView;
import com.viber.voip.messages.conversation.ui.banner.u;
import com.viber.voip.messages.conversation.ui.banner.u.a;
import com.viber.voip.messages.d.b;
import com.viber.voip.model.entity.m;
import java.util.Collections;
import java.util.Set;

public class bj
  implements u.a
{
  private static final Logger a = ViberEnv.getLogger();
  private final Fragment b;
  private final ConversationAlertView c;
  private a d;
  private ConversationItemLoaderEntity e;
  private u f;
  private m g;
  private Handler h;
  private boolean i;
  private boolean j;
  private final b k;

  public bj(Fragment paramFragment, ConversationAlertView paramConversationAlertView, b paramb, Handler paramHandler, boolean paramBoolean1, boolean paramBoolean2, a parama)
  {
    this.b = paramFragment;
    this.c = paramConversationAlertView;
    this.k = paramb;
    this.i = paramBoolean1;
    this.j = paramBoolean2;
    this.h = paramHandler;
    this.d = parama;
  }

  public void a()
  {
    if (this.g != null)
      this.d.a(this.g);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    this.e = paramConversationItemLoaderEntity;
    if (this.e.isNotJoinedCommunity())
    {
      long l = paramConversationItemLoaderEntity.getCreatorParticipantInfoId();
      this.g = this.k.b(l);
      if (this.f == null)
        this.f = new u(this.c, this, this.b.getLayoutInflater(), this.b.getResources());
      this.c.a(this.f, false);
      this.f.a(this.g, paramConversationItemLoaderEntity.getGroupRole(), this.j);
      return;
    }
    b();
  }

  public void a(boolean paramBoolean)
  {
    if ((this.g == null) || (this.g.a() == null));
    FragmentActivity localFragmentActivity;
    do
    {
      do
      {
        return;
        Set localSet = Collections.singleton(Member.from(this.g));
        this.h.postDelayed(new bk(localSet, paramBoolean), 500L);
        this.d.a(this.e.getId());
      }
      while (this.i);
      localFragmentActivity = this.b.getActivity();
    }
    while ((localFragmentActivity == null) || (localFragmentActivity.isFinishing()));
    localFragmentActivity.finish();
  }

  public void b()
  {
    if (this.f != null)
      this.c.a(this.f.a(), false);
  }

  public static abstract interface a
  {
    public abstract void a(long paramLong);

    public abstract void a(m paramm);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.bj
 * JD-Core Version:    0.6.2
 */