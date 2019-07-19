package com.snappydb;

import android.content.Context;
import android.text.TextUtils;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.Serializer;
import java.io.File;

public class SnappyDB
{
  private static volatile DB singleton = null;

  public static DB with(Context paramContext)
    throws SnappydbException
  {
    if ((singleton == null) || (!singleton.isOpen()));
    try
    {
      if ((singleton == null) || (!singleton.isOpen()))
        singleton = new Builder(paramContext).build();
      return singleton;
    }
    finally
    {
    }
  }

  public static class Builder
  {
    private final Context context;
    private String dir;
    private Kryo kryo;
    private String name;

    public Builder(Context paramContext)
    {
      if (paramContext == null)
        throw new IllegalArgumentException("Context must not be null.");
      this.context = paramContext.getApplicationContext();
      this.kryo = new Kryo();
      this.kryo.setAsmEnabled(true);
    }

    public DB build()
      throws SnappydbException
    {
      if (this.dir != null)
      {
        File localFile = new File(this.dir);
        if (((localFile.mkdirs()) || (localFile.isDirectory())) && (localFile.canWrite()))
        {
          if (this.name != null)
          {
            String str2 = this.dir;
            String str3 = this.name;
            Kryo[] arrayOfKryo2 = new Kryo[1];
            arrayOfKryo2[0] = this.kryo;
            return DBFactory.open(str2, str3, arrayOfKryo2);
          }
          String str1 = this.dir;
          Kryo[] arrayOfKryo1 = new Kryo[1];
          arrayOfKryo1[0] = this.kryo;
          return DBFactory.open(str1, arrayOfKryo1);
        }
        throw new IllegalStateException("Can't create or access directory " + this.dir);
      }
      if (this.name != null)
      {
        Context localContext2 = this.context;
        String str4 = this.name;
        Kryo[] arrayOfKryo4 = new Kryo[1];
        arrayOfKryo4[0] = this.kryo;
        return DBFactory.open(localContext2, str4, arrayOfKryo4);
      }
      Context localContext1 = this.context;
      Kryo[] arrayOfKryo3 = new Kryo[1];
      arrayOfKryo3[0] = this.kryo;
      return DBFactory.open(localContext1, arrayOfKryo3);
    }

    public Builder directory(String paramString)
    {
      if (TextUtils.isEmpty(paramString))
        throw new IllegalArgumentException("Database directory must not be empty or null.");
      this.dir = paramString;
      return this;
    }

    public Builder name(String paramString)
    {
      if (TextUtils.isEmpty(paramString))
        throw new IllegalArgumentException("Database name must not be empty or null.");
      this.name = paramString;
      return this;
    }

    public Builder registerSerializers(Class paramClass, Serializer paramSerializer)
    {
      if (paramClass == null)
        throw new IllegalArgumentException("Class type must not be null.");
      if (paramSerializer == null)
        throw new IllegalArgumentException("Serializer must not be null.");
      this.kryo.register(paramClass, paramSerializer);
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.snappydb.SnappyDB
 * JD-Core Version:    0.6.2
 */