package com.viber.voip.messages.orm.creator;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.viber.voip.model.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class JoinCreator extends CreatorHelper
{
  private Uri contentUri;
  private Creator[] creators;
  private Map<Creator, Integer> offsets = new HashMap();
  private String[] projections;

  public JoinCreator(Uri paramUri, Class<?> paramClass, Creator[] paramArrayOfCreator)
  {
    super(paramClass);
    this.contentUri = paramUri;
    this.projections = createProjections(paramArrayOfCreator);
    this.creators = paramArrayOfCreator;
  }

  public JoinCreator(Class<?> paramClass, Creator[] paramArrayOfCreator)
  {
    super(paramClass);
    this.projections = createProjections(paramArrayOfCreator);
    this.creators = paramArrayOfCreator;
  }

  private int createProjections(List<String> paramList, String paramString, String[] paramArrayOfString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    String str1 = paramString + '.';
    int i = paramList.size();
    int j = 0;
    int k = paramArrayOfString.length;
    if (j < k)
    {
      String str2 = paramArrayOfString[j];
      if (bool)
        paramList.add(str2);
      while (true)
      {
        j++;
        break;
        paramList.add(str1 + str2);
      }
    }
    return i;
  }

  private String[] createProjections(Creator[] paramArrayOfCreator)
  {
    ArrayList localArrayList = new ArrayList();
    for (int i = 0; i < paramArrayOfCreator.length; i++)
    {
      int j = createProjections(localArrayList, paramArrayOfCreator[i].getTable(), paramArrayOfCreator[i].getProjections());
      this.offsets.put(paramArrayOfCreator[i], Integer.valueOf(j));
    }
    return (String[])localArrayList.toArray(new String[0]);
  }

  public d createEntity()
  {
    return null;
  }

  public d createInstance(Cursor paramCursor, int paramInt)
  {
    throw new IllegalArgumentException("not implemented");
  }

  protected d createInstancesInternal(Cursor paramCursor, Creator paramCreator)
  {
    return paramCreator.createInstance(paramCursor, ((Integer)this.offsets.get(paramCreator)).intValue());
  }

  protected d createInstancesInternal(Cursor paramCursor, Creator paramCreator1, Creator paramCreator2)
  {
    return paramCreator2.createInstance(paramCursor, ((Integer)this.offsets.get(paramCreator1)).intValue());
  }

  protected d[] createInstancesInternal(Cursor paramCursor)
  {
    d[] arrayOfd = new d[this.creators.length];
    for (int i = 0; i < this.creators.length; i++)
      arrayOfd[i] = this.creators[i].createInstance(paramCursor, ((Integer)this.offsets.get(this.creators[i])).intValue());
    return arrayOfd;
  }

  public final Uri getContentUri()
  {
    return this.contentUri;
  }

  protected int getProjectionColumn(Creator paramCreator, String paramString)
  {
    if (TextUtils.isEmpty(paramCreator.getTable()));
    for (int i = 0; ; i++)
    {
      if (i >= this.projections.length)
        break label72;
      if (this.projections[i].equals(paramString))
      {
        return i;
        paramString = paramCreator.getTable() + "." + paramString;
        break;
      }
    }
    label72: return -1;
  }

  public String[] getProjections()
  {
    return this.projections;
  }

  protected boolean moveToNext(Cursor paramCursor, long paramLong)
  {
    return (paramCursor.moveToNext()) && (paramLong == paramCursor.getLong(getAggregateField()));
  }

  public boolean updateInstance(d paramd, ContentValues paramContentValues)
  {
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.orm.creator.JoinCreator
 * JD-Core Version:    0.6.2
 */