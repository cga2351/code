package com.viber.voip.messages.controller.publicaccount;

import android.location.Location;
import com.viber.voip.bot.a;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.messages.controller.ai.n;
import com.viber.voip.util.ViberActionRunner.PublicAccountInviteData;

public abstract interface d
{
  public abstract void a();

  public abstract void a(int paramInt1, int paramInt2, long paramLong1, String[] paramArrayOfString, long paramLong2, ViberActionRunner.PublicAccountInviteData paramPublicAccountInviteData);

  public abstract void a(int paramInt, long paramLong, String paramString1, String paramString2);

  public abstract void a(long paramLong);

  public abstract void a(long paramLong, boolean paramBoolean);

  public abstract void a(a parama);

  public abstract void a(a parama, Location paramLocation);

  public abstract void a(ai.n paramn);

  public abstract void a(BotReplyRequest paramBotReplyRequest);

  public abstract void a(BotReplyRequest paramBotReplyRequest, double paramDouble1, double paramDouble2, String paramString);

  public abstract void a(BotReplyRequest paramBotReplyRequest, MsgInfo paramMsgInfo);

  public abstract void a(SendRichMessageRequest paramSendRichMessageRequest);

  public abstract void a(String paramString);

  public abstract void a(String paramString, boolean paramBoolean);

  public abstract void b(a parama);

  public abstract void b(BotReplyRequest paramBotReplyRequest);

  public abstract void b(SendRichMessageRequest paramSendRichMessageRequest);

  public abstract boolean b(String paramString);

  public abstract boolean c(String paramString);

  public abstract void d(String paramString);

  public abstract boolean e(String paramString);

  public abstract boolean f(String paramString);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.publicaccount.d
 * JD-Core Version:    0.6.2
 */