package com.viber.voip.messages.orm.entity;

import android.database.Cursor;
import com.viber.voip.model.entity.b;

public abstract interface EntityHelper<T extends b>
{
  public abstract T createEntity(Cursor paramCursor);

  public abstract T createEntity(Cursor paramCursor, int paramInt);

  public abstract String[] getProjections();

  public abstract String getTable();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.entity.EntityHelper
 * JD-Core Version:    0.6.2
 */