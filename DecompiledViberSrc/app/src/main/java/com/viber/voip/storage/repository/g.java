package com.viber.voip.storage.repository;

import com.viber.provider.d;
import com.viber.voip.messages.controller.bv.m;
import com.viber.voip.model.entity.MessageEntity;

class g extends j
  implements bv.m
{
  g(d<?> paramd)
  {
    super(paramd);
  }

  public void a(MessageEntity paramMessageEntity, int paramInt)
  {
    if ((a(paramMessageEntity)) && (paramInt == 0))
    {
      if (this.c != null)
        this.c.a(paramMessageEntity);
      this.b.l();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.repository.g
 * JD-Core Version:    0.6.2
 */