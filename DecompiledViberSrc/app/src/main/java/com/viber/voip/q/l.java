package com.viber.voip.q;

import com.viber.voip.model.entity.MessageEntity;

public class l
{
  final int a;
  final int b;
  final MessageEntity c;

  private l(int paramInt1, int paramInt2, MessageEntity paramMessageEntity)
  {
    this.b = paramInt1;
    this.a = paramInt2;
    this.c = paramMessageEntity;
  }

  public static l a(int paramInt)
  {
    if (paramInt == 3)
      throw new IllegalArgumentException("Use createError(int) for error events and provide an appropriate error code");
    if (paramInt == 0)
      throw new IllegalArgumentException("Use createStopped(MessageEntity) for stopped events and provide a new message");
    return new l(paramInt, -1, null);
  }

  public static l a(MessageEntity paramMessageEntity)
  {
    return new l(0, -1, paramMessageEntity);
  }

  public static l b(int paramInt)
  {
    return new l(3, paramInt, null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.q.l
 * JD-Core Version:    0.6.2
 */