package com.viber.voip.storage.repository;

import com.viber.provider.d;
import com.viber.voip.messages.controller.bv.l;
import com.viber.voip.messages.controller.by;
import com.viber.voip.model.entity.MessageEntity;
import java.util.Set;

class c extends j
  implements bv.l
{
  c(d<?> paramd)
  {
    super(paramd);
  }

  public void a(long paramLong1, long paramLong2, boolean paramBoolean)
  {
  }

  public void a(long paramLong, Set<Long> paramSet)
  {
  }

  public void a(MessageEntity paramMessageEntity, boolean paramBoolean)
  {
    if ((a(paramMessageEntity)) && (this.c != null))
      this.c.b(paramMessageEntity);
  }

  public void a(Set<Long> paramSet, boolean paramBoolean)
  {
  }

  public void a(Set<Long> paramSet, boolean paramBoolean1, boolean paramBoolean2)
  {
  }

  public void b(long paramLong1, long paramLong2, boolean paramBoolean)
  {
    by.b(this, paramLong1, paramLong2, paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.repository.c
 * JD-Core Version:    0.6.2
 */