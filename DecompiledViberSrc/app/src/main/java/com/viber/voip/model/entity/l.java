package com.viber.voip.model.entity;

import android.content.ContentValues;
import com.viber.voip.messages.orm.entity.impl.ParticipantEntityHelper;

public class l extends b
{
  private long a;
  private long b;
  private long c;
  private int d;
  private int e;
  private int f;

  public long a()
  {
    return this.b;
  }

  public void a(int paramInt)
  {
    this.d = paramInt;
  }

  public void a(int paramInt1, int paramInt2)
  {
    this.e = paramInt1;
    this.f = paramInt2;
  }

  public void a(long paramLong)
  {
    this.b = paramLong;
  }

  public long b()
  {
    return this.a;
  }

  public void b(long paramLong)
  {
    this.a = paramLong;
  }

  public long c()
  {
    return this.c;
  }

  public void c(long paramLong)
  {
    this.c = paramLong;
  }

  public int d()
  {
    return this.d;
  }

  public int e()
  {
    return this.e;
  }

  public int f()
  {
    return this.f;
  }

  public ContentValues getContentValues()
  {
    return ParticipantEntityHelper.getContentValues(this);
  }

  public String getTable()
  {
    return "participants";
  }

  public String toString()
  {
    return "ParticipantEntity{conversationId=" + this.a + ", participantInfoId=" + this.b + ", lastMessageId=" + this.c + ", status=" + this.d + ", role=" + this.e + ", roleLocal=" + this.f + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.model.entity.l
 * JD-Core Version:    0.6.2
 */