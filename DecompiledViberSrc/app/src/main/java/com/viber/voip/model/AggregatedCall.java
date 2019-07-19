package com.viber.voip.model;

import com.viber.voip.model.entity.d;

public abstract interface AggregatedCall extends Call
{
  public abstract a getContact();

  public abstract int getCount();

  public abstract f getNumberData();

  public abstract void setContact(d paramd);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.model.AggregatedCall
 * JD-Core Version:    0.6.2
 */