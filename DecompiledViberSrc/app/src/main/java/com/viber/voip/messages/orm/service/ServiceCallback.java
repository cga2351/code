package com.viber.voip.messages.orm.service;

import com.viber.voip.model.d;

public abstract interface ServiceCallback
{
  public abstract boolean isPaused();

  public abstract void onDataChange(EntityService<?> paramEntityService, int paramInt, d[] paramArrayOfd);

  public abstract void onDataReady(EntityService<?> paramEntityService);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.service.ServiceCallback
 * JD-Core Version:    0.6.2
 */