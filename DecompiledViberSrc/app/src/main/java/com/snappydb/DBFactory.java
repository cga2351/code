package com.snappydb;

import android.content.Context;
import com.esotericsoftware.kryo.Kryo;
import com.snappydb.internal.DBImpl;
import java.io.File;

public class DBFactory
{
  private static final String DEFAULT_DBNAME = "snappydb";

  public static DB open(Context paramContext, String paramString, Kryo[] paramArrayOfKryo)
    throws SnappydbException
  {
    return open(paramContext.getFilesDir().getAbsolutePath(), paramString, paramArrayOfKryo);
  }

  public static DB open(Context paramContext, Kryo[] paramArrayOfKryo)
    throws SnappydbException
  {
    return open(paramContext, "snappydb", paramArrayOfKryo);
  }

  public static DB open(String paramString1, String paramString2, Kryo[] paramArrayOfKryo)
    throws SnappydbException
  {
    return new DBImpl(paramString1 + File.separator + paramString2, paramArrayOfKryo);
  }

  public static DB open(String paramString, Kryo[] paramArrayOfKryo)
    throws SnappydbException
  {
    return open(paramString, "snappydb", paramArrayOfKryo);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.snappydb.DBFactory
 * JD-Core Version:    0.6.2
 */