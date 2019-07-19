package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.yandex.metrica.impl.bw;
import com.yandex.metrica.impl.w;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class fs
  implements fr
{
  private final Context a;
  private final String b;
  private File c;
  private fi d;
  private FileLock e;
  private RandomAccessFile f;
  private FileChannel g;

  public fs(Context paramContext, String paramString)
  {
    this.a = paramContext;
    this.b = paramString;
  }

  // ERROR //
  public SQLiteDatabase a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: new 34	java/io/File
    //   6: dup
    //   7: aload_0
    //   8: getfield 27	com/yandex/metrica/impl/ob/fs:a	Landroid/content/Context;
    //   11: invokevirtual 40	android/content/Context:getFilesDir	()Ljava/io/File;
    //   14: new 42	java/lang/StringBuilder
    //   17: dup
    //   18: invokespecial 43	java/lang/StringBuilder:<init>	()V
    //   21: new 34	java/io/File
    //   24: dup
    //   25: aload_0
    //   26: getfield 29	com/yandex/metrica/impl/ob/fs:b	Ljava/lang/String;
    //   29: invokespecial 46	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: invokevirtual 50	java/io/File:getName	()Ljava/lang/String;
    //   35: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc 56
    //   40: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokespecial 62	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   49: putfield 64	com/yandex/metrica/impl/ob/fs:c	Ljava/io/File;
    //   52: aload_0
    //   53: new 66	java/io/RandomAccessFile
    //   56: dup
    //   57: aload_0
    //   58: getfield 64	com/yandex/metrica/impl/ob/fs:c	Ljava/io/File;
    //   61: ldc 68
    //   63: invokespecial 69	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   66: putfield 71	com/yandex/metrica/impl/ob/fs:f	Ljava/io/RandomAccessFile;
    //   69: aload_0
    //   70: aload_0
    //   71: getfield 71	com/yandex/metrica/impl/ob/fs:f	Ljava/io/RandomAccessFile;
    //   74: invokevirtual 75	java/io/RandomAccessFile:getChannel	()Ljava/nio/channels/FileChannel;
    //   77: putfield 77	com/yandex/metrica/impl/ob/fs:g	Ljava/nio/channels/FileChannel;
    //   80: aload_0
    //   81: aload_0
    //   82: getfield 77	com/yandex/metrica/impl/ob/fs:g	Ljava/nio/channels/FileChannel;
    //   85: invokevirtual 83	java/nio/channels/FileChannel:lock	()Ljava/nio/channels/FileLock;
    //   88: putfield 85	com/yandex/metrica/impl/ob/fs:e	Ljava/nio/channels/FileLock;
    //   91: aload_0
    //   92: new 87	com/yandex/metrica/impl/ob/fi
    //   95: dup
    //   96: aload_0
    //   97: getfield 27	com/yandex/metrica/impl/ob/fs:a	Landroid/content/Context;
    //   100: aload_0
    //   101: getfield 29	com/yandex/metrica/impl/ob/fs:b	Ljava/lang/String;
    //   104: invokestatic 92	com/yandex/metrica/impl/ob/ff:c	()Lcom/yandex/metrica/impl/ob/fo;
    //   107: invokespecial 95	com/yandex/metrica/impl/ob/fi:<init>	(Landroid/content/Context;Ljava/lang/String;Lcom/yandex/metrica/impl/ob/fo;)V
    //   110: putfield 97	com/yandex/metrica/impl/ob/fs:d	Lcom/yandex/metrica/impl/ob/fi;
    //   113: aload_0
    //   114: getfield 97	com/yandex/metrica/impl/ob/fs:d	Lcom/yandex/metrica/impl/ob/fi;
    //   117: invokevirtual 100	com/yandex/metrica/impl/ob/fi:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   120: astore 4
    //   122: aload 4
    //   124: astore_3
    //   125: aload_0
    //   126: monitorexit
    //   127: aload_3
    //   128: areturn
    //   129: astore_2
    //   130: aconst_null
    //   131: astore_3
    //   132: goto -7 -> 125
    //   135: astore_1
    //   136: aload_0
    //   137: monitorexit
    //   138: aload_1
    //   139: athrow
    //
    // Exception table:
    //   from	to	target	type
    //   2	122	129	java/lang/Exception
    //   2	122	135	finally
  }

  public void a(SQLiteDatabase paramSQLiteDatabase)
  {
    if (paramSQLiteDatabase != null);
    try
    {
      paramSQLiteDatabase.close();
      label10: bw.a(this.d);
      this.c.getAbsolutePath();
      w.a(this.e);
      bw.a(this.f);
      bw.a(this.g);
      this.d = null;
      this.f = null;
      this.e = null;
      this.g = null;
      return;
    }
    catch (Exception localException)
    {
      break label10;
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.fs
 * JD-Core Version:    0.6.2
 */