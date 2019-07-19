package com.viber.voip.model.entity;

import android.content.ContentValues;
import com.viber.voip.messages.orm.annotation.ViberEntityField;
import com.viber.voip.messages.orm.creator.Creator;
import com.viber.voip.model.d;

public abstract class b
  implements d
{

  @ViberEntityField(projection="_id")
  protected long id = -1L;

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    b localb;
    do
    {
      return true;
      if (paramObject == null)
        return false;
      if (getClass() != paramObject.getClass())
        return false;
      localb = (b)paramObject;
    }
    while (this.id == localb.id);
    return false;
  }

  public ContentValues getContentValues()
  {
    return null;
  }

  public Creator getCreator()
  {
    return null;
  }

  public long getId()
  {
    return this.id;
  }

  public String getTable()
  {
    return null;
  }

  public int hashCode()
  {
    if (this.id != -1L)
      return 31 + (int)(this.id ^ this.id >>> 32);
    return super.hashCode();
  }

  public boolean isIdValid()
  {
    return this.id > 0L;
  }

  public d setId(long paramLong)
  {
    this.id = paramLong;
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.model.entity.b
 * JD-Core Version:    0.6.2
 */