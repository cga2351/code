package com.viber.voip.messages.controller.publicaccount;

import android.content.Context;
import android.content.Intent;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.api.scheme.action.y;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.a;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.b;
import com.viber.voip.messages.a.i.b;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.extensions.c;
import com.viber.voip.util.ViberActionRunner.u;
import org.greenrobot.eventbus.EventBus;

public class ag
{
  private static final Logger a = ViberEnv.getLogger();
  private final EventBus b;
  private final com.viber.voip.messages.k c;
  private BotReplyRequest d;
  private final c e;
  private final String f;
  private final String g;
  private final String h;

  public ag(EventBus paramEventBus, com.viber.voip.messages.k paramk, BotReplyRequest paramBotReplyRequest, c paramc, String paramString1, String paramString2, String paramString3)
  {
    this.b = paramEventBus;
    this.c = paramk;
    this.d = paramBotReplyRequest;
    this.e = paramc;
    this.f = paramString1;
    this.g = paramString2;
    this.h = paramString3;
  }

  private void a(Context paramContext, long paramLong)
  {
    if (paramLong == this.d.conversationId)
    {
      this.d = BotReplyRequest.a.a(this.d).a(true).a(ReplyButton.a.OPEN_URL, ReplyButton.b.MESSAGE).a();
      a(this.d);
      return;
    }
    this.c.c().a(paramLong, new ah(this, paramContext));
  }

  private void a(BotReplyRequest paramBotReplyRequest)
  {
    SendRichMessageRequest localSendRichMessageRequest = new SendRichMessageRequest(paramBotReplyRequest, this.f, this.g, this.h, true);
    this.c.h().b(localSendRichMessageRequest);
    this.b.post(new i.b(1));
  }

  private void b(Context paramContext)
  {
    SendRichMessageRequest localSendRichMessageRequest = new SendRichMessageRequest(this.d, this.f, this.g, this.h, true);
    Intent localIntent = ViberActionRunner.u.a(new int[] { 0 });
    localIntent.putExtra("send_rich_message", localSendRichMessageRequest);
    localIntent.putExtra("extra_forward_chatex", true);
    localIntent.putExtra("show_broadcast_list_extra", false);
    localIntent.putExtra("show_secret_chats_extra", false);
    localIntent.addFlags(536870912);
    y.a(paramContext, localIntent);
    this.b.post(new i.b(4));
  }

  public void a(Context paramContext)
  {
    long l = this.c.a().b(true);
    if (l == -1L)
    {
      b(paramContext);
      return;
    }
    a(paramContext, l);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.publicaccount.ag
 * JD-Core Version:    0.6.2
 */