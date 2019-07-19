package com.viber.voip.messages.d;

import com.viber.voip.messages.conversation.aa;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.util.bz;

public class l
{
  private long a = -1L;
  private long b;
  private int c;

  @Deprecated
  public l()
  {
  }

  private l(long paramLong1, long paramLong2, int paramInt)
  {
    this.a = paramLong1;
    this.b = paramLong2;
    this.c = paramInt;
  }

  public l(aa paramaa)
  {
  }

  public l(l paraml)
  {
    this(paraml.a, paraml.b, paraml.c);
  }

  public l(MessageEntity paramMessageEntity)
  {
  }

  private boolean a(int paramInt)
  {
    return (this.c != 0) && (this.c == paramInt);
  }

  private boolean a(long paramLong)
  {
    return (this.b != 0L) && (this.b == paramLong);
  }

  private boolean a(l paraml)
  {
    return (a(paraml.c())) || (a(paraml.b()));
  }

  public long a()
  {
    return this.a;
  }

  public long b()
  {
    return this.b;
  }

  public int c()
  {
    return this.c;
  }

  public boolean equals(Object paramObject)
  {
    if (paramObject == null);
    while (!(paramObject instanceof l))
      return false;
    if (paramObject == this)
      return true;
    return a((l)paramObject);
  }

  public int hashCode()
  {
    if (this.c != 0)
      return this.c;
    return bz.a(this.b);
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(this.c);
    arrayOfObject[1] = Long.valueOf(this.b);
    arrayOfObject[2] = Long.valueOf(this.a);
    return String.format("UniqueId: [seq = %s, token = %s, id = %s]", arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.d.l
 * JD-Core Version:    0.6.2
 */