package com.viber.voip.messages.conversation.ui;

import android.support.v4.app.Fragment;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.d.c;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.ui.banner.ConversationAlertView;
import com.viber.voip.messages.conversation.ui.banner.v;
import com.viber.voip.messages.conversation.ui.banner.v.a;
import com.viber.voip.messages.d.b;
import com.viber.voip.model.entity.m;
import com.viber.voip.registration.ao;

public class bl
  implements v.a
{
  private static final Logger a = ViberEnv.getLogger();
  private final Fragment b;
  private final ConversationAlertView c;
  private final ai d;
  private final j e;
  private final b f;
  private v g;
  private ConversationItemLoaderEntity h;
  private final c i;

  public bl(Fragment paramFragment, ConversationAlertView paramConversationAlertView, ai paramai, j paramj, b paramb, c paramc)
  {
    this.b = paramFragment;
    this.c = paramConversationAlertView;
    this.d = paramai;
    this.e = paramj;
    this.f = paramb;
    this.i = paramc;
  }

  private boolean b(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    return (paramConversationItemLoaderEntity.getContactId() == 0L) && (paramConversationItemLoaderEntity.showAddNewParticipantNumberBanner()) && (!paramConversationItemLoaderEntity.isSecret()) && (paramConversationItemLoaderEntity.isConversation1on1());
  }

  public void a()
  {
    if (this.g != null)
      this.c.a(this.g.a(), false);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity)
  {
    if (ao.f())
      return;
    this.h = paramConversationItemLoaderEntity;
    if (b(paramConversationItemLoaderEntity))
    {
      if (this.g == null)
        this.g = new v(this.b.getContext(), this.c, this, this.b.getLayoutInflater());
      this.c.a(this.g, false);
      this.g.a(paramConversationItemLoaderEntity);
      return;
    }
    a();
  }

  public void b()
  {
    this.d.d(this.h.getId(), false, null);
  }

  public void c()
  {
    m localm = this.f.b(this.h.getParticipantInfoId());
    if ((localm != null) && (this.e.a(localm)))
      this.i.a("Value Changed Unavailable", "Save New Number");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.bl
 * JD-Core Version:    0.6.2
 */