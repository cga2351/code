package com.viber.voip.messages.orm.creator;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.viber.voip.model.d;

public abstract class Creator
{
  public abstract d createEntity();

  public abstract d createInstance(Cursor paramCursor);

  public abstract d createInstance(Cursor paramCursor, int paramInt);

  public int getAggregateField()
  {
    return -1;
  }

  public abstract Uri getContentUri();

  public abstract ContentValues getContentValues(d paramd);

  public abstract String[] getProjections();

  public abstract String getTable();

  public abstract boolean updateInstance(d paramd, ContentValues paramContentValues);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.creator.Creator
 * JD-Core Version:    0.6.2
 */