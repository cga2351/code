package com.viber.voip.messages.orm.service;

import com.viber.voip.messages.orm.creator.Creator;
import com.viber.voip.model.d;

public abstract interface EntityService<T extends d>
{
  public static final int NO_ID = -1;
  public static final int SEARCH_DELAY = 300;

  public abstract d findEntity(long paramLong);

  public abstract int getCount();

  public abstract d getEntity(int paramInt);

  public abstract Creator getHelper();

  public abstract boolean isInit();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.service.EntityService
 * JD-Core Version:    0.6.2
 */