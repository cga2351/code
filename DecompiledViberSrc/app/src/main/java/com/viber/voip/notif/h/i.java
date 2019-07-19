package com.viber.voip.notif.h;

import com.viber.voip.model.entity.MessageEntity;

class i
{
  private final MessageEntity a;
  private final boolean b;
  private final int c;

  i(MessageEntity paramMessageEntity, int paramInt, boolean paramBoolean)
  {
    this.a = paramMessageEntity;
    this.c = paramInt;
    this.b = paramBoolean;
  }

  MessageEntity a()
  {
    return this.a;
  }

  public int b()
  {
    return this.c;
  }

  public boolean c()
  {
    return this.b;
  }

  public int d()
  {
    if (this.a.isOutgoing())
      return 1;
    return a().getUnread();
  }

  public String toString()
  {
    return "AggregatedMessageNotificationInfo{mMessage=" + this.a + ", mSmart=" + this.b + ", mItemType=" + this.c + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.h.i
 * JD-Core Version:    0.6.2
 */