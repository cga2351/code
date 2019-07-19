package c.b.a.a;

import java.io.InputStream;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

final class f
{
  private static final Logger a = Logger.getLogger(f.class.getName());
  private final e b;
  private final ConcurrentHashMap<Integer, k.b> c = new ConcurrentHashMap();
  private final ConcurrentHashMap<String, k.b> d = new ConcurrentHashMap();
  private final Set<Integer> e = a.a();
  private final Set<String> f = m.a();

  f(e parame)
  {
    this.b = parame;
  }

  // ERROR //
  private static k.c a(InputStream paramInputStream)
  {
    // Byte code:
    //   0: new 64	java/io/ObjectInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 67	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
    //   8: astore_1
    //   9: new 69	c/b/a/a/k$c
    //   12: dup
    //   13: invokespecial 70	c/b/a/a/k$c:<init>	()V
    //   16: astore_2
    //   17: aload_2
    //   18: aload_1
    //   19: invokevirtual 74	c/b/a/a/k$c:readExternal	(Ljava/io/ObjectInput;)V
    //   22: aload_1
    //   23: ifnull +54 -> 77
    //   26: aload_1
    //   27: invokevirtual 77	java/io/ObjectInputStream:close	()V
    //   30: aload_2
    //   31: areturn
    //   32: astore 7
    //   34: new 79	java/lang/RuntimeException
    //   37: dup
    //   38: ldc 81
    //   40: aload 7
    //   42: invokespecial 84	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   45: athrow
    //   46: astore_3
    //   47: aconst_null
    //   48: astore_1
    //   49: aload_1
    //   50: ifnull +50 -> 100
    //   53: aload_1
    //   54: invokevirtual 77	java/io/ObjectInputStream:close	()V
    //   57: aload_3
    //   58: athrow
    //   59: astore 5
    //   61: new 79	java/lang/RuntimeException
    //   64: dup
    //   65: ldc 81
    //   67: aload 5
    //   69: invokespecial 84	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   72: athrow
    //   73: astore_3
    //   74: goto -25 -> 49
    //   77: aload_0
    //   78: invokevirtual 87	java/io/InputStream:close	()V
    //   81: aload_2
    //   82: areturn
    //   83: astore 6
    //   85: getstatic 34	c/b/a/a/f:a	Ljava/util/logging/Logger;
    //   88: getstatic 93	java/util/logging/Level:WARNING	Ljava/util/logging/Level;
    //   91: ldc 95
    //   93: aload 6
    //   95: invokevirtual 99	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   98: aload_2
    //   99: areturn
    //   100: aload_0
    //   101: invokevirtual 87	java/io/InputStream:close	()V
    //   104: goto -47 -> 57
    //   107: astore 4
    //   109: getstatic 34	c/b/a/a/f:a	Ljava/util/logging/Logger;
    //   112: getstatic 93	java/util/logging/Level:WARNING	Ljava/util/logging/Level;
    //   115: ldc 95
    //   117: aload 4
    //   119: invokevirtual 99	java/util/logging/Logger:log	(Ljava/util/logging/Level;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   122: goto -65 -> 57
    //
    // Exception table:
    //   from	to	target	type
    //   0	9	32	java/io/IOException
    //   0	9	46	finally
    //   34	46	46	finally
    //   17	22	59	java/io/IOException
    //   9	17	73	finally
    //   17	22	73	finally
    //   61	73	73	finally
    //   26	30	83	java/io/IOException
    //   77	81	83	java/io/IOException
    //   53	57	107	java/io/IOException
    //   100	104	107	java/io/IOException
  }

  private static List<k.b> a(String paramString, e parame)
  {
    InputStream localInputStream = parame.a(paramString);
    if (localInputStream == null)
      throw new IllegalStateException("missing metadata: " + paramString);
    List localList = a(localInputStream).a();
    if (localList.size() == 0)
      throw new IllegalStateException("empty metadata: " + paramString);
    return localList;
  }

  <T> k.b a(T paramT, ConcurrentHashMap<T, k.b> paramConcurrentHashMap, String paramString)
  {
    k.b localb1 = (k.b)paramConcurrentHashMap.get(paramT);
    if (localb1 != null)
      return localb1;
    String str = paramString + "_" + paramT;
    List localList = a(str, this.b);
    if (localList.size() > 1)
      a.log(Level.WARNING, "more than one metadata in file " + str);
    k.b localb2 = (k.b)localList.get(0);
    k.b localb3 = (k.b)paramConcurrentHashMap.putIfAbsent(paramT, localb2);
    if (localb3 != null);
    while (true)
    {
      return localb3;
      localb3 = localb2;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.b.a.a.f
 * JD-Core Version:    0.6.2
 */