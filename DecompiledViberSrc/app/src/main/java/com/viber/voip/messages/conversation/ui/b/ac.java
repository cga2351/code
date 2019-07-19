package com.viber.voip.messages.conversation.ui.b;

import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.conversation.aa;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ac
  implements ad
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private ab c;
  private com.viber.voip.messages.controller.manager.o d;
  private final List<ad> e = new ArrayList();

  public ac(Context paramContext, ab paramab, com.viber.voip.messages.controller.manager.o paramo)
  {
    this.b = paramContext;
    this.c = paramab;
    this.d = paramo;
  }

  public File a(aa paramaa)
  {
    if (paramaa.aM())
      return com.viber.voip.util.upload.o.a(paramaa.bx().getThumbnailUrl(), 1005, this.b);
    return com.viber.voip.util.upload.o.a(paramaa.C(), paramaa.q(), this.b);
  }

  public void a(long paramLong)
  {
    if (this.c.p() > 0)
      this.d.a(paramLong, 0L, true);
  }

  public void a(ConferenceInfo paramConferenceInfo, boolean paramBoolean)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
      ((ad)localIterator.next()).a(paramConferenceInfo, paramBoolean);
  }

  public void a(ad paramad)
  {
    this.e.add(paramad);
  }

  public void a(String paramString, BotReplyConfig paramBotReplyConfig, ReplyButton paramReplyButton)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
      ((ad)localIterator.next()).a(paramString, paramBotReplyConfig, paramReplyButton);
  }

  public void a(String paramString, BotReplyConfig paramBotReplyConfig, ReplyButton paramReplyButton, boolean paramBoolean, int paramInt)
  {
    a(paramString, paramBotReplyConfig, paramReplyButton, paramBoolean, null, paramInt);
  }

  public void a(String paramString1, BotReplyConfig paramBotReplyConfig, ReplyButton paramReplyButton, boolean paramBoolean, String paramString2, int paramInt)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
      ((ad)localIterator.next()).a(paramString1, paramBotReplyConfig, paramReplyButton, paramBoolean, paramString2, paramInt);
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
      ((ad)localIterator.next()).a(paramBoolean1, paramBoolean2, false, false, paramBoolean3);
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    ae.a(this, paramBoolean1, paramBoolean2, paramBoolean3, paramBoolean4, paramBoolean5);
  }

  public void b(ad paramad)
  {
    this.e.remove(paramad);
  }

  public void b(boolean paramBoolean)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
      ((ad)localIterator.next()).b(paramBoolean);
  }

  public void b_(boolean paramBoolean)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
      ((ad)localIterator.next()).b_(paramBoolean);
  }

  public void c_(String paramString)
  {
    Iterator localIterator = this.e.iterator();
    while (localIterator.hasNext())
      ((ad)localIterator.next()).c_(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.b.ac
 * JD-Core Version:    0.6.2
 */