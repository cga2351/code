package com.viber.voip.model.entity;

import com.viber.voip.messages.orm.creator.CreatorHelper;
import com.viber.voip.model.AggregatedCall;
import com.viber.voip.model.f;

public class AggregatedCallEntity extends CallEntity
  implements AggregatedCall
{
  public static final CreatorHelper JOIN_CREATOR = new com.viber.voip.contacts.b.a.a();
  private d contact;
  private int count;
  private k numberData;

  public com.viber.voip.model.a getContact()
  {
    return this.contact;
  }

  public int getCount()
  {
    return this.count;
  }

  public f getNumberData()
  {
    return this.numberData;
  }

  public void setContact(d paramd)
  {
    this.contact = paramd;
  }

  public void setCount(int paramInt)
  {
    this.count = paramInt;
  }

  public void setNumberData(k paramk)
  {
    this.numberData = paramk;
  }

  public String toString()
  {
    return "AgregatedCallEntityImpl [" + super.toString() + ", count=" + this.count + ", contact=" + this.contact + "]";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.model.entity.AggregatedCallEntity
 * JD-Core Version:    0.6.2
 */