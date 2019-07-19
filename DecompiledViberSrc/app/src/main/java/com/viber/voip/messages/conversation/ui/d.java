package com.viber.voip.messages.conversation.ui;

import android.support.v4.app.Fragment;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.banner.ConversationAlertView;
import com.viber.voip.messages.conversation.ui.banner.j;
import com.viber.voip.messages.conversation.ui.banner.j.a;
import com.viber.voip.messages.d.b;
import com.viber.voip.model.entity.m;

public class d
  implements j.a
{
  private static final Logger a = ViberEnv.getLogger();
  private final Fragment b;
  private final ConversationAlertView c;
  private ConversationItemLoaderEntity d;
  private j e;
  private m f;
  private a g;
  private final b h;

  public d(Fragment paramFragment, ConversationAlertView paramConversationAlertView, b paramb, a parama)
  {
    this.b = paramFragment;
    this.c = paramConversationAlertView;
    this.h = paramb;
    this.g = parama;
  }

  public void a()
  {
    if (this.d != null)
    {
      c();
      this.g.a(this.d);
    }
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    this.d = paramConversationItemLoaderEntity;
    if (this.d.isYouInvitedAsMemberCommunity())
    {
      long l = paramConversationItemLoaderEntity.getCreatorParticipantInfoId();
      this.f = this.h.b(l);
      if (this.e == null)
        this.e = new j(this.c, this, this.b.getLayoutInflater(), this.b.getResources());
      this.c.a(this.e, false);
      this.e.a(this.f, paramConversationItemLoaderEntity.getGroupRole());
      return;
    }
    c();
  }

  public void b()
  {
    if (this.f != null)
      this.g.a(this.f);
  }

  public void c()
  {
    if (this.e != null)
      this.c.a(this.e.a(), false);
  }

  public static abstract interface a
  {
    public abstract void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity);

    public abstract void a(m paramm);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.d
 * JD-Core Version:    0.6.2
 */