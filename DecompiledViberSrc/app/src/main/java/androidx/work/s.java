package androidx.work;

import android.content.Context;

public abstract class s
{
  private static final String a = i.a("WorkerFactory");

  public static s a()
  {
    return new s()
    {
      public ListenableWorker a(Context paramAnonymousContext, String paramAnonymousString, WorkerParameters paramAnonymousWorkerParameters)
      {
        return null;
      }
    };
  }

  public abstract ListenableWorker a(Context paramContext, String paramString, WorkerParameters paramWorkerParameters);

  // ERROR //
  public final ListenableWorker b(Context paramContext, String paramString, WorkerParameters paramWorkerParameters)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: aload_2
    //   3: aload_3
    //   4: invokevirtual 32	androidx/work/s:a	(Landroid/content/Context;Ljava/lang/String;Landroidx/work/WorkerParameters;)Landroidx/work/ListenableWorker;
    //   7: astore 4
    //   9: aload 4
    //   11: ifnull +6 -> 17
    //   14: aload 4
    //   16: areturn
    //   17: aload_2
    //   18: invokestatic 38	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   21: ldc 40
    //   23: invokevirtual 44	java/lang/Class:asSubclass	(Ljava/lang/Class;)Ljava/lang/Class;
    //   26: astore 6
    //   28: aload 6
    //   30: iconst_2
    //   31: anewarray 34	java/lang/Class
    //   34: dup
    //   35: iconst_0
    //   36: ldc 46
    //   38: aastore
    //   39: dup
    //   40: iconst_1
    //   41: ldc 48
    //   43: aastore
    //   44: invokevirtual 52	java/lang/Class:getDeclaredConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   47: iconst_2
    //   48: anewarray 4	java/lang/Object
    //   51: dup
    //   52: iconst_0
    //   53: aload_1
    //   54: aastore
    //   55: dup
    //   56: iconst_1
    //   57: aload_3
    //   58: aastore
    //   59: invokevirtual 58	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   62: checkcast 40	androidx/work/ListenableWorker
    //   65: astore 8
    //   67: aload 8
    //   69: areturn
    //   70: astore 5
    //   72: invokestatic 61	androidx/work/i:a	()Landroidx/work/i;
    //   75: getstatic 17	androidx/work/s:a	Ljava/lang/String;
    //   78: new 63	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   85: ldc 66
    //   87: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: aload_2
    //   91: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: iconst_0
    //   98: anewarray 76	java/lang/Throwable
    //   101: invokevirtual 80	androidx/work/i:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Throwable;)V
    //   104: aconst_null
    //   105: areturn
    //   106: astore 7
    //   108: invokestatic 61	androidx/work/i:a	()Landroidx/work/i;
    //   111: getstatic 17	androidx/work/s:a	Ljava/lang/String;
    //   114: new 63	java/lang/StringBuilder
    //   117: dup
    //   118: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   121: ldc 82
    //   123: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload_2
    //   127: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   133: iconst_1
    //   134: anewarray 76	java/lang/Throwable
    //   137: dup
    //   138: iconst_0
    //   139: aload 7
    //   141: aastore
    //   142: invokevirtual 80	androidx/work/i:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Throwable;)V
    //   145: aconst_null
    //   146: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   17	28	70	java/lang/ClassNotFoundException
    //   28	67	106	java/lang/Exception
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.s
 * JD-Core Version:    0.6.2
 */