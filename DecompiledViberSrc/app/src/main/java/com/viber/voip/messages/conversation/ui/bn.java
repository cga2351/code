package com.viber.voip.messages.conversation.ui;

import android.support.v4.app.Fragment;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.model.msginfo.Pin;
import com.viber.voip.flatbuffers.model.msginfo.Pin.a;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.af;
import com.viber.voip.messages.conversation.ui.banner.ConversationAlertView;
import com.viber.voip.messages.conversation.ui.banner.ConversationAlertView.a;
import com.viber.voip.messages.conversation.ui.banner.w;
import com.viber.voip.messages.conversation.ui.banner.w.a;
import com.viber.voip.messages.d.b;
import com.viber.voip.util.cd;
import com.viber.voip.util.e.e;

public class bn
{
  private static final Logger a = ViberEnv.getLogger();
  private final Fragment b;
  private final ConversationAlertView c;
  private e d;
  private final w.a e;
  private b f;
  private w g;
  private af h;
  private Pin i;
  private boolean j;

  public bn(Fragment paramFragment, ConversationAlertView paramConversationAlertView, e parame, w.a parama, b paramb)
  {
    this.b = paramFragment;
    this.c = paramConversationAlertView;
    this.d = parame;
    this.e = parama;
    this.f = paramb;
  }

  public void a()
  {
    this.c.a(ConversationAlertView.a.j, false);
    this.h = null;
  }

  public void a(Pin paramPin)
  {
    this.i = paramPin;
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, af paramaf, boolean paramBoolean)
  {
    this.j = false;
    this.h = paramaf;
    this.i = null;
    if (paramConversationItemLoaderEntity != null)
      a(paramConversationItemLoaderEntity, paramBoolean);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    if ((paramConversationItemLoaderEntity != null) && (paramConversationItemLoaderEntity.isGroupBehavior()) && (!paramConversationItemLoaderEntity.isSecret()) && ((!paramConversationItemLoaderEntity.isDisabledConversation()) || (paramConversationItemLoaderEntity.isPublicGroupBehavior())) && (((this.h != null) && ((!paramConversationItemLoaderEntity.isCommunityType()) || (cd.b(paramConversationItemLoaderEntity.getGroupRole())) || (!this.h.i())) && (Pin.a.CREATE == this.h.d().getAction())) || ((this.i != null) && (Pin.a.CREATE == this.i.getAction()))))
    {
      if (this.g == null)
        this.g = new w(this.b.getContext(), this.c, this.d, this.e, this.f, this.b.getLayoutInflater());
      this.c.a(this.g, this.j);
      if (this.h != null)
      {
        this.g.a(paramConversationItemLoaderEntity, this.h, paramBoolean);
        return;
      }
      this.g.a(paramConversationItemLoaderEntity, this.i);
      return;
    }
    this.c.a(ConversationAlertView.a.j, false);
    this.h = null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.bn
 * JD-Core Version:    0.6.2
 */