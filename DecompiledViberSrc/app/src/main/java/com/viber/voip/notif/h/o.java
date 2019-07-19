package com.viber.voip.notif.h;

import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.notif.g.f;
import com.viber.voip.util.LongSparseSet;

public class o
  implements m
{
  private final i a;
  private final com.viber.voip.model.entity.m b;
  private final h c;
  private final n d;

  public o(i parami, com.viber.voip.model.entity.m paramm, h paramh, n paramn)
  {
    this.a = parami;
    this.b = paramm;
    this.c = paramh;
    this.d = paramn;
  }

  public com.viber.voip.notif.d.e a(f paramf, com.viber.voip.notif.g.e parame)
  {
    return paramf.b(this, parame);
  }

  public MessageEntity c()
  {
    return this.a.a();
  }

  public com.viber.voip.model.entity.m d()
  {
    return this.b;
  }

  public h e()
  {
    return this.c;
  }

  public n f()
  {
    return this.d;
  }

  public LongSparseSet g()
  {
    long[] arrayOfLong = new long[1];
    arrayOfLong[0] = this.a.a().getId();
    return LongSparseSet.from(arrayOfLong);
  }

  public boolean h()
  {
    return this.a.c();
  }

  public int hashCode()
  {
    return 31 * j() + (int)(c().getId() ^ c().getId() >>> 32);
  }

  public int i()
  {
    return this.a.b();
  }

  public int j()
  {
    return this.a.d();
  }

  public int k()
  {
    return 1;
  }

  public String toString()
  {
    return "NotificationStatisticItem{mMessageInfo=" + this.a + ", mParticipantInfo=" + this.b + ", mConversation=" + this.c + ", mPublicAccountNotificationInfo=" + this.d + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.h.o
 * JD-Core Version:    0.6.2
 */