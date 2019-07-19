package com.viber.voip.messages.conversation.ui.presenter;

import android.net.Uri;
import com.viber.common.b.b;
import com.viber.common.b.d;
import com.viber.common.b.e;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.flatbuffers.model.conference.ConferenceParticipant;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton;
import com.viber.voip.i.c.g;
import com.viber.voip.messages.conversation.ConversationItemLoaderEntity;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.messages.conversation.q;
import com.viber.voip.messages.conversation.ui.ConversationData;
import com.viber.voip.messages.conversation.ui.at;
import com.viber.voip.messages.conversation.ui.av;
import com.viber.voip.messages.conversation.ui.b.ad;
import com.viber.voip.messages.conversation.ui.b.g;
import com.viber.voip.messages.conversation.ui.b.i;
import com.viber.voip.messages.conversation.ui.b.l;
import com.viber.voip.messages.conversation.ui.b.m;
import com.viber.voip.messages.conversation.ui.b.n;
import com.viber.voip.messages.conversation.ui.b.o;
import com.viber.voip.messages.conversation.ui.b.p;
import com.viber.voip.messages.conversation.ui.b.u;
import com.viber.voip.messages.conversation.ui.b.v;
import com.viber.voip.messages.conversation.ui.b.w;
import com.viber.voip.messages.conversation.ui.view.k;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.mvp.core.BaseMvpPresenter;
import com.viber.voip.mvp.core.State;
import com.viber.voip.settings.d.m;
import com.viber.voip.settings.d.r;
import com.viber.voip.ui.ap.a;
import com.viber.voip.ui.t.b.a;
import com.viber.voip.ui.t.c;
import com.viber.voip.util.da;
import com.viber.voip.util.dg;
import java.util.ArrayList;
import java.util.List;

public class OptionsMenuPresenter extends BaseMvpPresenter<k, State>
  implements ad, g, l, o, v, ap.a<at>
{
  private static final Logger a = ViberEnv.getLogger();
  private final i b;
  private final com.viber.voip.messages.conversation.ui.b.f c;
  private n d;
  private com.viber.voip.messages.conversation.ac e;
  private u f;
  private final av g;
  private final com.viber.voip.messages.conversation.ui.b.ac h;

  public OptionsMenuPresenter(u paramu, n paramn, i parami, com.viber.voip.messages.conversation.ui.b.f paramf, av paramav, com.viber.voip.messages.conversation.ui.b.ac paramac)
  {
    this.f = paramu;
    this.d = paramn;
    this.b = parami;
    this.c = paramf;
    this.g = paramav;
    this.h = paramac;
  }

  private ConferenceInfo g()
  {
    if (this.e == null)
      return null;
    ConferenceInfo localConferenceInfo = new ConferenceInfo();
    ArrayList localArrayList = new ArrayList();
    int i = this.e.getCount();
    int j = 0;
    while (j < i)
    {
      com.viber.voip.messages.conversation.ae localae = this.e.e(j);
      if (localae.isOwner())
      {
        j++;
      }
      else
      {
        ConferenceParticipant localConferenceParticipant = new ConferenceParticipant();
        localConferenceParticipant.setMemberId(localae.h());
        localConferenceParticipant.setName(dg.a(localae));
        Uri localUri = localae.j();
        if (localUri != null);
        for (String str = localUri.toString(); ; str = null)
        {
          localConferenceParticipant.setImage(str);
          localArrayList.add(localConferenceParticipant);
          break;
        }
      }
    }
    localConferenceInfo.setParticipants((ConferenceParticipant[])localArrayList.toArray(new ConferenceParticipant[0]));
    localConferenceInfo.setIsSelfInitiated(true);
    return localConferenceInfo;
  }

  public void G_()
  {
    w.a(this);
  }

  public void a(long paramLong1, int paramInt, long paramLong2)
  {
    m.a(this, paramLong1, paramInt, paramLong2);
  }

  public void a(ConferenceInfo paramConferenceInfo, boolean paramBoolean)
  {
    com.viber.voip.messages.conversation.ui.b.ae.a(this, paramConferenceInfo, paramBoolean);
  }

  public void a(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    c();
  }

  public void a(aa paramaa)
  {
    com.viber.voip.messages.conversation.adapter.f.a(this, paramaa);
  }

  public void a(com.viber.voip.messages.conversation.ac paramac, boolean paramBoolean)
  {
    this.e = paramac;
    c();
  }

  public void a(q paramq, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    m.a(this, paramq, paramBoolean1, paramInt, paramBoolean2);
  }

  public void a(ConversationData paramConversationData)
  {
    w.a(this, paramConversationData);
  }

  public void a(at paramat)
  {
    ((k)this.mView).a(paramat);
  }

  public void a(MessageEntity paramMessageEntity, int paramInt, String paramString)
  {
    m.a(this, paramMessageEntity, paramInt, paramString);
  }

  public void a(t.c paramc, t.b.a parama)
  {
    w.a(this, paramc, parama);
  }

  public void a(t.c paramc, t.b.a parama, long paramLong)
  {
    w.a(this, paramc, parama, paramLong);
  }

  public void a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    w.a(this, paramCharSequence, paramBoolean);
  }

  public void a(String paramString)
  {
    w.a(this, paramString);
  }

  public void a(String paramString, BotReplyConfig paramBotReplyConfig, ReplyButton paramReplyButton)
  {
    com.viber.voip.messages.conversation.ui.b.ae.a(this, paramString, paramBotReplyConfig, paramReplyButton);
  }

  public void a(String paramString1, BotReplyConfig paramBotReplyConfig, ReplyButton paramReplyButton, boolean paramBoolean, String paramString2, int paramInt)
  {
    com.viber.voip.messages.conversation.ui.b.ae.a(this, paramString1, paramBotReplyConfig, paramReplyButton, paramBoolean, paramString2, paramInt);
  }

  public void a(boolean paramBoolean)
  {
    w.a(this, paramBoolean);
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      ((k)this.mView).a();
      return;
    }
    c();
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    com.viber.voip.messages.conversation.ui.b.ae.a(this, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
  }

  public void b()
  {
    ((k)this.mView).a(this.c.b());
  }

  public void b(long paramLong)
  {
    com.viber.voip.messages.conversation.ui.b.h.b(this, paramLong);
  }

  public void b(ConversationItemLoaderEntity paramConversationItemLoaderEntity, boolean paramBoolean)
  {
    com.viber.voip.messages.conversation.ui.b.h.a(this, paramConversationItemLoaderEntity, paramBoolean);
  }

  public void b(com.viber.voip.model.h paramh)
  {
    p.a(this, paramh);
  }

  public void b(boolean paramBoolean)
  {
    com.viber.voip.messages.conversation.ui.b.ae.b(this, paramBoolean);
  }

  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.h.a(paramBoolean1, paramBoolean2, false);
  }

  public void b_(long paramLong)
  {
    com.viber.voip.messages.conversation.ui.b.h.a(this, paramLong);
  }

  public void b_(boolean paramBoolean)
  {
    com.viber.voip.messages.conversation.ui.b.ae.a(this, paramBoolean);
  }

  public void c()
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = this.c.b();
    if (localConversationItemLoaderEntity == null);
    while (this.b.a())
      return;
    int i = this.d.a();
    if (this.c.c() > 0);
    for (boolean bool = true; ; bool = false)
    {
      ((k)this.mView).a(bool, localConversationItemLoaderEntity, i);
      return;
    }
  }

  public void c_(String paramString)
  {
    com.viber.voip.messages.conversation.ui.b.ae.a(this, paramString);
  }

  public void d()
  {
    ConferenceInfo localConferenceInfo = g();
    if (localConferenceInfo != null)
      this.h.a(localConferenceInfo, false);
  }

  public void e()
  {
    ConversationItemLoaderEntity localConversationItemLoaderEntity = this.c.b();
    if (localConversationItemLoaderEntity == null);
    label12: String str;
    do
    {
      long l1;
      long l2;
      do
      {
        do
        {
          break label12;
          do
            return;
          while ((!c.g.a.e()) || (!d.m.v.d()) || (!c.g.a.e()));
          l1 = System.currentTimeMillis();
        }
        while (l1 < d.m.t.d());
        l2 = d.r.C.d() - 1814400000L;
      }
      while ((l2 < 0L) || (l1 - l2 < 1000L));
      str = localConversationItemLoaderEntity.getGroupName();
    }
    while ((!localConversationItemLoaderEntity.isGroupType()) || (da.a(str)) || (this.d.a() > d.m.w.d()));
    ((k)this.mView).a(str);
  }

  public void f()
  {
    d.m.v.a(false);
  }

  public void i()
  {
    com.viber.voip.messages.conversation.ui.b.h.a(this);
  }

  public void j()
  {
    m.a(this);
  }

  public void onDestroy(android.arch.lifecycle.h paramh)
  {
    super.onDestroy(paramh);
    this.c.b(this);
    this.d.b(this);
    this.f.b(this);
    this.b.b(this);
    this.g.b(this);
    this.h.b(this);
  }

  protected void onViewAttached(State paramState)
  {
    super.onViewAttached(paramState);
    this.c.a(this);
    this.d.a(this);
    this.f.a(this);
    this.b.a(this);
    this.g.a(this);
    this.h.a(this);
    ((k)this.mView).a((at)this.g.a());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.presenter.OptionsMenuPresenter
 * JD-Core Version:    0.6.2
 */