package com.viber.voip.storage.repository;

import com.viber.dexshared.Logger;
import com.viber.provider.d;
import com.viber.voip.ViberEnv;
import com.viber.voip.model.entity.MessageEntity;
import java.util.Set;

class j
{
  protected static final Logger a = ViberEnv.getLogger();
  protected final d<?> b;
  protected i c;
  private long d = -1L;

  j(d<?> paramd)
  {
    this.b = paramd;
  }

  public void a(long paramLong)
  {
    this.d = paramLong;
  }

  public void a(i parami)
  {
    this.c = parami;
  }

  protected boolean a(MessageEntity paramMessageEntity)
  {
    return (this.d == -1L) || (this.d == paramMessageEntity.getConversationId());
  }

  protected boolean a(Set<Long> paramSet)
  {
    return (this.d == -1L) || (paramSet.contains(Long.valueOf(this.d)));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.repository.j
 * JD-Core Version:    0.6.2
 */