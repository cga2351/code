package com.viber.voip.messages.orm.creator;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;
import com.viber.voip.ViberApplication;
import com.viber.voip.messages.orm.manager.ViberEntityManager;
import com.viber.voip.model.d;
import com.viber.voip.util.af;

public abstract class CreatorHelper extends Creator
{
  private final Class<?> type;

  public CreatorHelper(Class<?> paramClass)
  {
    this.type = paramClass;
  }

  public static String[] addProjections(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if ((paramArrayOfString2 == null) || (paramArrayOfString2.length == 0))
      return paramArrayOfString1;
    String[] arrayOfString = new String[paramArrayOfString1.length + paramArrayOfString2.length];
    System.arraycopy(paramArrayOfString1, 0, arrayOfString, 0, paramArrayOfString1.length);
    System.arraycopy(paramArrayOfString2, 0, arrayOfString, paramArrayOfString1.length, paramArrayOfString2.length);
    return arrayOfString;
  }

  public static d findLimitedSync(Creator paramCreator, int paramInt, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    Object localObject1 = null;
    try
    {
      if ((!TextUtils.isEmpty(paramString1)) || (paramInt <= 0))
        break label34;
      throw new IllegalArgumentException("Can't make query with LIMIT and without ORDER");
    }
    finally
    {
    }
    af.a((Cursor)localObject1);
    throw localObject2;
    label34: if (paramInt > 0);
    for (String str = paramString1 + " LIMIT " + paramInt; ; str = paramString1)
    {
      Cursor localCursor = af.a(ViberApplication.getApplication(), paramCreator.getContentUri(), paramCreator.getProjections(), paramString2, str, paramArrayOfString);
      if (localCursor != null);
      try
      {
        if (localCursor.moveToFirst())
        {
          d locald = paramCreator.createInstance(localCursor);
          af.a(localCursor);
          return locald;
        }
        af.a(localCursor);
        return null;
      }
      finally
      {
        localObject1 = localCursor;
      }
      break;
    }
  }

  public static d findSync(Creator paramCreator, String paramString, String[] paramArrayOfString)
  {
    return findLimitedSync(paramCreator, 0, null, paramString, paramArrayOfString);
  }

  public ContentValues getContentValues(d paramd)
  {
    return paramd.getContentValues();
  }

  public int getProjectionColumn(String paramString)
  {
    return ViberEntityManager.getProjectionColumn(this.type, paramString);
  }

  public int getProjectionColumn(String paramString, int paramInt)
  {
    return paramInt + ViberEntityManager.getProjectionColumn(this.type, paramString);
  }

  public String[] getProjections()
  {
    return ViberEntityManager.getProjections(this.type);
  }

  public String getTable()
  {
    return ViberEntityManager.getTableName(this.type);
  }

  public boolean updateInstance(d paramd, ContentValues paramContentValues)
  {
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.creator.CreatorHelper
 * JD-Core Version:    0.6.2
 */