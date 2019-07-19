package com.viber.voip.messages.controller.publicaccount;

import android.location.Location;
import android.os.Handler;
import com.viber.voip.bot.a;
import com.viber.voip.flatbuffers.model.msginfo.MsgInfo;
import com.viber.voip.messages.controller.ai.n;
import com.viber.voip.util.ViberActionRunner.PublicAccountInviteData;

public class e
  implements d
{
  private final d a;
  private final Handler b;
  private final Handler c;

  public e(Handler paramHandler1, Handler paramHandler2, d paramd)
  {
    this.a = paramd;
    this.b = paramHandler1;
    this.c = paramHandler2;
  }

  private void b(a parama)
  {
    this.b.post(new f(this, parama));
  }

  public void a()
  {
    this.a.a();
  }

  public void a(int paramInt1, int paramInt2, long paramLong1, String[] paramArrayOfString, long paramLong2, ViberActionRunner.PublicAccountInviteData paramPublicAccountInviteData)
  {
    b(new i(paramInt1, paramInt2, paramLong1, paramArrayOfString, paramLong2, paramPublicAccountInviteData));
  }

  public void a(int paramInt, long paramLong, String paramString1, String paramString2)
  {
    b(new s(paramInt, paramLong, paramString1, paramString2));
  }

  public void a(long paramLong)
  {
    this.c.post(new o(this, paramLong));
  }

  public void a(long paramLong, boolean paramBoolean)
  {
    b(new q(paramLong, paramBoolean));
  }

  public void a(a parama)
  {
    b(new u(parama));
  }

  public void a(a parama, Location paramLocation)
  {
    b(new v(parama, paramLocation));
  }

  public void a(ai.n paramn)
  {
    b(new t(paramn));
  }

  public void a(BotReplyRequest paramBotReplyRequest)
  {
    b(new g(paramBotReplyRequest));
  }

  public void a(BotReplyRequest paramBotReplyRequest, double paramDouble1, double paramDouble2, String paramString)
  {
    b(new j(paramBotReplyRequest, paramDouble1, paramDouble2, paramString));
  }

  public void a(BotReplyRequest paramBotReplyRequest, MsgInfo paramMsgInfo)
  {
    b(new h(paramBotReplyRequest, paramMsgInfo));
  }

  public void a(SendRichMessageRequest paramSendRichMessageRequest)
  {
    b(new m(paramSendRichMessageRequest));
  }

  public void a(String paramString)
  {
    b(new r(paramString));
  }

  public void a(String paramString, boolean paramBoolean)
  {
    b(new p(paramString, paramBoolean));
  }

  public void b(a parama)
  {
    b(new l(this, parama));
  }

  public void b(BotReplyRequest paramBotReplyRequest)
  {
    b(new k(paramBotReplyRequest));
  }

  public void b(SendRichMessageRequest paramSendRichMessageRequest)
  {
    b(new n(paramSendRichMessageRequest));
  }

  public boolean b(String paramString)
  {
    return this.a.b(paramString);
  }

  public boolean c(String paramString)
  {
    return this.a.c(paramString);
  }

  public void d(String paramString)
  {
    this.a.d(paramString);
  }

  public boolean e(String paramString)
  {
    return this.a.e(paramString);
  }

  public boolean f(String paramString)
  {
    return this.a.f(paramString);
  }

  private static abstract interface a
  {
    public abstract void a(d paramd);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.publicaccount.e
 * JD-Core Version:    0.6.2
 */