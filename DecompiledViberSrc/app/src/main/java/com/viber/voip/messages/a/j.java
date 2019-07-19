package com.viber.voip.messages.a;

import com.viber.voip.model.entity.MessageEntity;

public class j
{
  public static class a
  {
    public final MessageEntity a;

    public a(MessageEntity paramMessageEntity)
    {
      this.a = paramMessageEntity;
    }

    public String toString()
    {
      return "EditMessageEvent{message=" + this.a + '}';
    }
  }

  public static class b
  {
    public final long a;

    public b(long paramLong)
    {
      this.a = paramLong;
    }

    public String toString()
    {
      return "LocalUnpinEvent{conversationId=" + this.a + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.a.j
 * JD-Core Version:    0.6.2
 */