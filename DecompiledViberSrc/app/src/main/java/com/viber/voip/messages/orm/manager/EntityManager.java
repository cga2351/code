package com.viber.voip.messages.orm.manager;

import android.app.Application;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.orm.creator.Creator;
import com.viber.voip.model.d;
import com.viber.voip.util.af;
import java.util.Iterator;

public class EntityManager
  implements Iterable<d>
{
  private static final Logger L = ViberEnv.getLogger();
  protected Context mContext = ViberApplication.getApplication();
  protected boolean mCountRequest;
  protected Creator mCreator;
  private Cursor mDataCursor;
  protected int[] mPositions;
  private int position;

  public EntityManager(Creator paramCreator)
  {
    this.mCreator = paramCreator;
  }

  public EntityManager(Creator paramCreator, Cursor paramCursor)
  {
    this.mCreator = paramCreator;
    setDataCursor(paramCursor);
  }

  private void checkPositions(Cursor paramCursor)
  {
    long l1 = -1L;
    while (true)
    {
      long l2;
      try
      {
        int[] arrayOfInt = new int[paramCursor.getCount()];
        int i = this.mCreator.getAggregateField();
        boolean bool = paramCursor.moveToFirst();
        j = 0;
        if (bool)
        {
          k = 0;
          l2 = paramCursor.getLong(i);
          if (l2 == l1)
            break label128;
          j = k + 1;
          arrayOfInt[k] = paramCursor.getPosition();
          if (paramCursor.moveToNext());
        }
        else
        {
          this.mPositions = new int[j];
          System.arraycopy(arrayOfInt, 0, this.mPositions, 0, j);
          return;
        }
      }
      finally
      {
      }
      int k = j;
      l1 = l2;
      continue;
      label128: int j = k;
    }
  }

  public static int delete(Creator paramCreator, String paramString, String[] paramArrayOfString)
  {
    return getContentResolver().delete(paramCreator.getContentUri(), paramString, paramArrayOfString);
  }

  public static int delete(d paramd, Creator paramCreator)
  {
    boolean bool = paramd.getId() < -1L;
    int i = 0;
    if (bool)
    {
      String str = String.valueOf(paramd.getId());
      i = getContentResolver().delete(paramCreator.getContentUri(), "_id=?", new String[] { str });
    }
    return i;
  }

  private static ContentResolver getContentResolver()
  {
    return ViberApplication.getApplication().getContentResolver();
  }

  public static boolean save(d paramd, Creator paramCreator)
  {
    Uri localUri = getContentResolver().insert(paramCreator.getContentUri(), paramCreator.getContentValues(paramd));
    if (localUri != null);
    for (boolean bool = true; ; bool = false)
    {
      if (bool)
        paramd.setId(Long.parseLong(localUri.getLastPathSegment()));
      return bool;
    }
  }

  public static int update(d paramd, Creator paramCreator)
  {
    boolean bool = paramd.getId() < -1L;
    int i = 0;
    if (bool)
    {
      String str = String.valueOf(paramd.getId());
      ContentValues localContentValues = paramCreator.getContentValues(paramd);
      i = getContentResolver().update(paramCreator.getContentUri(), localContentValues, "_id=?", new String[] { str });
    }
    return i;
  }

  public static int update(d paramd, Creator paramCreator, String paramString, String[] paramArrayOfString)
  {
    ContentValues localContentValues = paramCreator.getContentValues(paramd);
    return getContentResolver().update(paramCreator.getContentUri(), localContentValues, paramString, paramArrayOfString);
  }

  public boolean closeCursor()
  {
    try
    {
      if (isCursorOpen())
      {
        af.a(this.mDataCursor);
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  public int delete(d paramd)
  {
    return delete(paramd, this.mCreator);
  }

  public int delete(String paramString, String[] paramArrayOfString)
  {
    return delete(this.mCreator, paramString, paramArrayOfString);
  }

  public void fillCursor(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    Cursor localCursor = af.a(this.mContext, this.mCreator.getContentUri(), this.mCreator.getProjections(), paramString2, paramString1, paramArrayOfString);
    if (localCursor != null)
      localCursor.moveToFirst();
    processMessagesReplyInternal(localCursor);
  }

  public int fullUpdate(ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return this.mContext.getContentResolver().update(this.mCreator.getContentUri(), paramContentValues, paramString, paramArrayOfString);
  }

  public Context getContext()
  {
    return this.mContext;
  }

  public int getCount()
  {
    try
    {
      boolean bool = isCursorOpen();
      int i = 0;
      if (bool)
      {
        int j = this.mDataCursor.getCount();
        i = 0;
        if (j > 0)
        {
          if ((!this.mCountRequest) || (!this.mDataCursor.moveToFirst()))
            break label69;
          int m = this.mDataCursor.getInt(0);
          i = m;
        }
      }
      while (true)
      {
        return i;
        label69: if (this.mPositions != null)
        {
          i = this.mPositions.length;
        }
        else
        {
          int k = this.mDataCursor.getCount();
          i = k;
        }
      }
    }
    finally
    {
    }
  }

  public Cursor getDataCursor()
  {
    try
    {
      Cursor localCursor = this.mDataCursor;
      return localCursor;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public d getEntity(int paramInt)
  {
    return getEntity(paramInt, this.mCreator);
  }

  public d getEntity(int paramInt, Creator paramCreator)
  {
    try
    {
      if (isPositionAvailable(paramInt))
      {
        if (this.mPositions != null)
          paramInt = this.mPositions[paramInt];
        this.position = paramInt;
      }
      while (true)
      {
        try
        {
          this.mDataCursor.moveToPosition(this.position);
          d locald2 = paramCreator.createInstance(this.mDataCursor);
          locald1 = locald2;
          return locald1;
        }
        catch (Exception localException)
        {
        }
        d locald1 = null;
      }
    }
    finally
    {
    }
  }

  public int getInt(int paramInt1, int paramInt2)
  {
    if (this.mPositions != null)
      paramInt1 = this.mPositions[paramInt1];
    if (isPositionAvailable(paramInt1))
    {
      this.mDataCursor.moveToPosition(paramInt1);
      return this.mDataCursor.getInt(paramInt2);
    }
    return -1;
  }

  public long getLong(int paramInt)
  {
    try
    {
      if (isCursorOpen())
      {
        long l2 = this.mDataCursor.getLong(paramInt);
        l1 = l2;
        return l1;
      }
      long l1 = -1L;
    }
    finally
    {
    }
  }

  public long getLong(int paramInt1, int paramInt2)
  {
    if (this.mPositions != null)
      paramInt1 = this.mPositions[paramInt1];
    if (isPositionAvailable(paramInt1))
    {
      this.mDataCursor.moveToPosition(paramInt1);
      return this.mDataCursor.getLong(paramInt2);
    }
    return -1L;
  }

  public long getLong(int paramInt, String paramString)
  {
    if (isPositionAvailable(paramInt))
    {
      int i = this.mDataCursor.getColumnIndex(paramString);
      if (i != -1)
      {
        this.mDataCursor.moveToPosition(paramInt);
        return this.mDataCursor.getLong(i);
      }
    }
    return -1L;
  }

  public int getPosition()
  {
    try
    {
      if ((isCursorOpen()) && (this.mDataCursor.moveToNext()))
      {
        int j = this.mDataCursor.getPosition();
        i = j;
        return i;
      }
      int i = -1;
    }
    finally
    {
    }
  }

  public String getString(int paramInt1, int paramInt2)
  {
    if (this.mPositions != null)
      paramInt1 = this.mPositions[paramInt1];
    if (isPositionAvailable(paramInt1))
    {
      this.mDataCursor.moveToPosition(paramInt1);
      return this.mDataCursor.getString(paramInt2);
    }
    return null;
  }

  public boolean isCursorOpen()
  {
    try
    {
      if (this.mDataCursor != null)
      {
        boolean bool2 = this.mDataCursor.isClosed();
        if (!bool2)
        {
          bool1 = true;
          return bool1;
        }
      }
      boolean bool1 = false;
    }
    finally
    {
    }
  }

  protected boolean isPositionAvailable(int paramInt)
  {
    try
    {
      if (isCursorOpen())
      {
        int i = this.mDataCursor.getCount();
        if (paramInt < i)
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
    finally
    {
    }
  }

  public Iterator<d> iterator()
  {
    return new EntityIterator(null);
  }

  public boolean moveToFirst()
  {
    try
    {
      if (!af.b(this.mDataCursor))
      {
        boolean bool2 = this.mDataCursor.moveToFirst();
        if (bool2)
        {
          bool1 = true;
          return bool1;
        }
      }
      boolean bool1 = false;
    }
    finally
    {
    }
  }

  public boolean moveToNext()
  {
    try
    {
      if (this.mDataCursor != null)
      {
        boolean bool2 = this.mDataCursor.moveToNext();
        if (bool2)
        {
          bool1 = true;
          return bool1;
        }
      }
      boolean bool1 = false;
    }
    finally
    {
    }
  }

  protected void processMessagesReplyInternal(Cursor paramCursor)
  {
    try
    {
      boolean bool = af.b(paramCursor);
      if (bool);
      while (true)
      {
        return;
        closeCursor();
        setDataCursor(paramCursor);
      }
    }
    finally
    {
    }
  }

  public boolean save(d paramd)
  {
    return save(paramd, this.mCreator);
  }

  protected void setDataCursor(Cursor paramCursor)
  {
    if (paramCursor != null);
    try
    {
      paramCursor.moveToFirst();
      if (this.mCreator != null)
      {
        int i = this.mCreator.getAggregateField();
        if (i == -1);
      }
      try
      {
        checkPositions(paramCursor);
        label40: this.mDataCursor = paramCursor;
        return;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        break label40;
      }
    }
    finally
    {
    }
  }

  public int update(d paramd)
  {
    return update(paramd, this.mCreator);
  }

  public int update(d paramd, String paramString, String[] paramArrayOfString)
  {
    return update(paramd, this.mCreator, paramString, paramArrayOfString);
  }

  private class EntityIterator
    implements Iterator<d>
  {
    int position = 0;

    private EntityIterator()
    {
    }

    public boolean hasNext()
    {
      return (EntityManager.this.mDataCursor != null) && (!EntityManager.this.mDataCursor.isClosed()) && (EntityManager.this.mDataCursor.getCount() > this.position);
    }

    public d next()
    {
      EntityManager localEntityManager = EntityManager.this;
      int i = this.position;
      this.position = (i + 1);
      return localEntityManager.getEntity(i);
    }

    public void remove()
    {
      throw new UnsupportedOperationException();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.manager.EntityManager
 * JD-Core Version:    0.6.2
 */