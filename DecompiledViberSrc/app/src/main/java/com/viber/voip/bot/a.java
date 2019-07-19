package com.viber.voip.bot;

import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.a;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton.b;
import com.viber.voip.messages.orm.entity.json.action.Action;
import com.viber.voip.model.entity.MessageEntity;

public class a
{
  private MessageEntity a;
  private Action b;
  private String c;
  private String d;
  private String e;
  private long f;
  private ReplyButton.a g;
  private ReplyButton.b h;
  private boolean i;
  private int j;

  public MessageEntity a()
  {
    return this.a;
  }

  public void a(int paramInt)
  {
    this.j = paramInt;
  }

  public void a(long paramLong)
  {
    this.f = paramLong;
  }

  public void a(ReplyButton.a parama)
  {
    this.g = parama;
  }

  public void a(ReplyButton.b paramb)
  {
    this.h = paramb;
  }

  public void a(Action paramAction)
  {
    this.b = paramAction;
  }

  public void a(MessageEntity paramMessageEntity)
  {
    this.a = paramMessageEntity;
  }

  public void a(String paramString)
  {
    this.c = paramString;
  }

  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }

  public Action b()
  {
    return this.b;
  }

  public void b(String paramString)
  {
    this.d = paramString;
  }

  public String c()
  {
    return this.c;
  }

  public void c(String paramString)
  {
    this.e = paramString;
  }

  public String d()
  {
    return this.d;
  }

  public String e()
  {
    if (this.f > 0L)
      return "";
    return this.e;
  }

  public long f()
  {
    return this.f;
  }

  public ReplyButton.b g()
  {
    return this.h;
  }

  public boolean h()
  {
    return this.i;
  }

  public int i()
  {
    return this.j;
  }

  public ReplyButton.a j()
  {
    return this.g;
  }

  public String toString()
  {
    return "BotReply{mMessage=" + this.a + ", mAction=" + this.b + ", mPublicAccountId='" + this.c + '\'' + ", mReplyContext='" + this.d + '\'' + ", mPeerMID='" + this.e + '\'' + ", mGroupId=" + this.f + ", mActionType=" + this.g + ", mReplyType=" + this.h + ", mIsSilent=" + this.i + ", mFlags=" + this.j + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.bot.a
 * JD-Core Version:    0.6.2
 */