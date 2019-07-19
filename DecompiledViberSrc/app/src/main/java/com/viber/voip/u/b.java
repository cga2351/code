package com.viber.voip.u;

import com.viber.voip.model.entity.MessageEntity;

public class b
{
  final int a;
  final int b;
  final MessageEntity c;

  private b(int paramInt1, int paramInt2, MessageEntity paramMessageEntity)
  {
    this.b = paramInt1;
    this.a = paramInt2;
    this.c = paramMessageEntity;
  }

  public static b a(int paramInt)
  {
    if (paramInt == 3)
      throw new IllegalArgumentException("Use createError(int) for error events and provide an appropriate error code");
    if (paramInt == 0)
      throw new IllegalArgumentException("Use createStopped(MessageEntity) for stopped events and provide a new message");
    return new b(paramInt, -1, null);
  }

  public static b a(MessageEntity paramMessageEntity)
  {
    return new b(0, -1, paramMessageEntity);
  }

  public static b b(int paramInt)
  {
    return new b(3, paramInt, null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.u.b
 * JD-Core Version:    0.6.2
 */