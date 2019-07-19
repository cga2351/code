package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

public final class zzdw
{
  public static String zza(String paramString, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    Preconditions.checkNotNull(paramArrayOfString1);
    Preconditions.checkNotNull(paramArrayOfString2);
    int i = Math.min(paramArrayOfString1.length, paramArrayOfString2.length);
    for (int j = 0; j < i; j++)
    {
      String str = paramArrayOfString1[j];
      boolean bool;
      if ((paramString == null) && (str == null))
        bool = true;
      while (bool)
      {
        return paramArrayOfString2[j];
        if (paramString == null)
          bool = false;
        else
          bool = paramString.equals(str);
      }
    }
    return null;
  }

  // ERROR //
  public static Object zze(Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnonnull +5 -> 6
    //   4: aconst_null
    //   5: areturn
    //   6: new 31	java/io/ByteArrayOutputStream
    //   9: dup
    //   10: invokespecial 35	java/io/ByteArrayOutputStream:<init>	()V
    //   13: astore_1
    //   14: new 37	java/io/ObjectOutputStream
    //   17: dup
    //   18: aload_1
    //   19: invokespecial 40	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   22: astore_2
    //   23: aload_2
    //   24: aload_0
    //   25: invokevirtual 44	java/io/ObjectOutputStream:writeObject	(Ljava/lang/Object;)V
    //   28: aload_2
    //   29: invokevirtual 47	java/io/ObjectOutputStream:flush	()V
    //   32: new 49	java/io/ObjectInputStream
    //   35: dup
    //   36: new 51	java/io/ByteArrayInputStream
    //   39: dup
    //   40: aload_1
    //   41: invokevirtual 55	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   44: invokespecial 58	java/io/ByteArrayInputStream:<init>	([B)V
    //   47: invokespecial 61	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   50: astore 4
    //   52: aload 4
    //   54: invokevirtual 65	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
    //   57: astore 7
    //   59: aload_2
    //   60: invokevirtual 68	java/io/ObjectOutputStream:close	()V
    //   63: aload 4
    //   65: invokevirtual 69	java/io/ObjectInputStream:close	()V
    //   68: aload 7
    //   70: areturn
    //   71: aload_2
    //   72: ifnull +7 -> 79
    //   75: aload_2
    //   76: invokevirtual 68	java/io/ObjectOutputStream:close	()V
    //   79: aload 4
    //   81: ifnull +8 -> 89
    //   84: aload 4
    //   86: invokevirtual 69	java/io/ObjectInputStream:close	()V
    //   89: aload_3
    //   90: athrow
    //   91: astore 6
    //   93: aconst_null
    //   94: areturn
    //   95: astore 5
    //   97: aconst_null
    //   98: areturn
    //   99: astore_3
    //   100: aconst_null
    //   101: astore 4
    //   103: goto -32 -> 71
    //   106: astore_3
    //   107: goto -36 -> 71
    //   110: astore_3
    //   111: aconst_null
    //   112: astore 4
    //   114: aconst_null
    //   115: astore_2
    //   116: goto -45 -> 71
    //
    // Exception table:
    //   from	to	target	type
    //   59	68	91	java/io/IOException
    //   75	79	91	java/io/IOException
    //   84	89	91	java/io/IOException
    //   89	91	91	java/io/IOException
    //   59	68	95	java/lang/ClassNotFoundException
    //   75	79	95	java/lang/ClassNotFoundException
    //   84	89	95	java/lang/ClassNotFoundException
    //   89	91	95	java/lang/ClassNotFoundException
    //   23	52	99	finally
    //   52	59	106	finally
    //   6	23	110	finally
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzdw
 * JD-Core Version:    0.6.2
 */