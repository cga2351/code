package android.support.multidex;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.util.Log;
import dalvik.system.DexFile;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipFile;

public final class a
{
  private static final Set<File> a = new HashSet();
  private static final boolean b = a(System.getProperty("java.vm.version"));

  private static File a(Context paramContext, File paramFile, String paramString)
    throws IOException
  {
    File localFile1 = new File(paramFile, "code_cache");
    try
    {
      a(localFile1);
      File localFile2 = new File(localFile1, paramString);
      a(localFile2);
      return localFile2;
    }
    catch (IOException localIOException)
    {
      while (true)
      {
        localFile1 = new File(paramContext.getFilesDir(), "code_cache");
        a(localFile1);
      }
    }
  }

  public static void a(Context paramContext)
  {
    Log.i("MultiDex", "Installing application");
    if (b)
    {
      Log.i("MultiDex", "VM has multidex support, MultiDex support library is disabled.");
      return;
    }
    if (Build.VERSION.SDK_INT < 4)
      throw new RuntimeException("MultiDex installation failed. SDK " + Build.VERSION.SDK_INT + " is unsupported. Min SDK version is " + 4 + ".");
    ApplicationInfo localApplicationInfo;
    try
    {
      localApplicationInfo = b(paramContext);
      if (localApplicationInfo == null)
      {
        Log.i("MultiDex", "No ApplicationInfo available, i.e. running on a test Context: MultiDex support library is disabled.");
        return;
      }
    }
    catch (Exception localException)
    {
      Log.e("MultiDex", "MultiDex installation failure", localException);
      throw new RuntimeException("MultiDex installation failed (" + localException.getMessage() + ").");
    }
    a(paramContext, new File(localApplicationInfo.sourceDir), new File(localApplicationInfo.dataDir), "secondary-dexes", "", true);
    Log.i("MultiDex", "install done");
  }

  // ERROR //
  private static void a(Context paramContext, File paramFile1, File paramFile2, String paramString1, String paramString2, boolean paramBoolean)
    throws IOException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, SecurityException, ClassNotFoundException, InstantiationException
  {
    // Byte code:
    //   0: getstatic 18	android/support/multidex/a:a	Ljava/util/Set;
    //   3: astore 6
    //   5: aload 6
    //   7: monitorenter
    //   8: getstatic 18	android/support/multidex/a:a	Ljava/util/Set;
    //   11: aload_1
    //   12: invokeinterface 163 2 0
    //   17: ifeq +7 -> 24
    //   20: aload 6
    //   22: monitorexit
    //   23: return
    //   24: getstatic 18	android/support/multidex/a:a	Ljava/util/Set;
    //   27: aload_1
    //   28: invokeinterface 166 2 0
    //   33: pop
    //   34: getstatic 81	android/os/Build$VERSION:SDK_INT	I
    //   37: bipush 20
    //   39: if_icmple +68 -> 107
    //   42: ldc 65
    //   44: new 85	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 86	java/lang/StringBuilder:<init>	()V
    //   51: ldc 168
    //   53: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: getstatic 81	android/os/Build$VERSION:SDK_INT	I
    //   59: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   62: ldc 170
    //   64: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: bipush 20
    //   69: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: ldc 172
    //   74: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: ldc 174
    //   79: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: ldc 176
    //   84: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: ldc 20
    //   89: invokestatic 26	java/lang/System:getProperty	(Ljava/lang/String;)Ljava/lang/String;
    //   92: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: ldc 178
    //   97: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokestatic 181	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;)I
    //   106: pop
    //   107: aload_0
    //   108: invokevirtual 185	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   111: astore 11
    //   113: aload 11
    //   115: ifnonnull +39 -> 154
    //   118: ldc 65
    //   120: ldc 187
    //   122: invokestatic 189	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   125: pop
    //   126: aload 6
    //   128: monitorexit
    //   129: return
    //   130: astore 7
    //   132: aload 6
    //   134: monitorexit
    //   135: aload 7
    //   137: athrow
    //   138: astore 9
    //   140: ldc 65
    //   142: ldc 191
    //   144: aload 9
    //   146: invokestatic 193	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   149: pop
    //   150: aload 6
    //   152: monitorexit
    //   153: return
    //   154: aload_0
    //   155: invokestatic 196	android/support/multidex/a:c	(Landroid/content/Context;)V
    //   158: aload_0
    //   159: aload_2
    //   160: aload_3
    //   161: invokestatic 198	android/support/multidex/a:a	(Landroid/content/Context;Ljava/io/File;Ljava/lang/String;)Ljava/io/File;
    //   164: astore 14
    //   166: new 200	android/support/multidex/b
    //   169: dup
    //   170: aload_1
    //   171: aload 14
    //   173: invokespecial 203	android/support/multidex/b:<init>	(Ljava/io/File;Ljava/io/File;)V
    //   176: astore 15
    //   178: aconst_null
    //   179: astore 16
    //   181: aload 15
    //   183: aload_0
    //   184: aload 4
    //   186: iconst_0
    //   187: invokevirtual 206	android/support/multidex/b:a	(Landroid/content/Context;Ljava/lang/String;Z)Ljava/util/List;
    //   190: astore 19
    //   192: aload 11
    //   194: aload 14
    //   196: aload 19
    //   198: invokestatic 209	android/support/multidex/a:a	(Ljava/lang/ClassLoader;Ljava/io/File;Ljava/util/List;)V
    //   201: aload 15
    //   203: invokevirtual 212	android/support/multidex/b:close	()V
    //   206: aload 16
    //   208: ifnull +70 -> 278
    //   211: aload 16
    //   213: athrow
    //   214: astore 12
    //   216: ldc 65
    //   218: ldc 214
    //   220: aload 12
    //   222: invokestatic 193	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   225: pop
    //   226: goto -68 -> 158
    //   229: astore 20
    //   231: iload 5
    //   233: ifne +16 -> 249
    //   236: aload 20
    //   238: athrow
    //   239: astore 17
    //   241: aload 15
    //   243: invokevirtual 212	android/support/multidex/b:close	()V
    //   246: aload 17
    //   248: athrow
    //   249: ldc 65
    //   251: ldc 216
    //   253: aload 20
    //   255: invokestatic 193	android/util/Log:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   258: pop
    //   259: aload 11
    //   261: aload 14
    //   263: aload 15
    //   265: aload_0
    //   266: aload 4
    //   268: iconst_1
    //   269: invokevirtual 206	android/support/multidex/b:a	(Landroid/content/Context;Ljava/lang/String;Z)Ljava/util/List;
    //   272: invokestatic 209	android/support/multidex/a:a	(Ljava/lang/ClassLoader;Ljava/io/File;Ljava/util/List;)V
    //   275: goto -74 -> 201
    //   278: aload 6
    //   280: monitorexit
    //   281: return
    //   282: astore 16
    //   284: goto -78 -> 206
    //   287: astore 18
    //   289: goto -43 -> 246
    //
    // Exception table:
    //   from	to	target	type
    //   8	23	130	finally
    //   24	107	130	finally
    //   107	113	130	finally
    //   118	129	130	finally
    //   132	135	130	finally
    //   140	153	130	finally
    //   154	158	130	finally
    //   158	178	130	finally
    //   201	206	130	finally
    //   211	214	130	finally
    //   216	226	130	finally
    //   241	246	130	finally
    //   246	249	130	finally
    //   278	281	130	finally
    //   107	113	138	java/lang/RuntimeException
    //   154	158	214	java/lang/Throwable
    //   192	201	229	java/io/IOException
    //   181	192	239	finally
    //   192	201	239	finally
    //   236	239	239	finally
    //   249	275	239	finally
    //   201	206	282	java/io/IOException
    //   241	246	287	java/io/IOException
  }

  private static void a(File paramFile)
    throws IOException
  {
    paramFile.mkdir();
    if (!paramFile.isDirectory())
    {
      File localFile = paramFile.getParentFile();
      if (localFile == null)
        Log.e("MultiDex", "Failed to create dir " + paramFile.getPath() + ". Parent file is null.");
      while (true)
      {
        throw new IOException("Failed to create directory " + paramFile.getPath());
        Log.e("MultiDex", "Failed to create dir " + paramFile.getPath() + ". parent file is a dir " + localFile.isDirectory() + ", a file " + localFile.isFile() + ", exists " + localFile.exists() + ", readable " + localFile.canRead() + ", writable " + localFile.canWrite());
      }
    }
  }

  private static void a(ClassLoader paramClassLoader, File paramFile, List<? extends File> paramList)
    throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException, SecurityException, ClassNotFoundException, InstantiationException
  {
    if (!paramList.isEmpty())
    {
      if (Build.VERSION.SDK_INT >= 19)
        b.a(paramClassLoader, paramList, paramFile);
    }
    else
      return;
    if (Build.VERSION.SDK_INT >= 14)
    {
      a.a(paramClassLoader, paramList);
      return;
    }
    c.a(paramClassLoader, paramList);
  }

  static boolean a(String paramString)
  {
    boolean bool1 = false;
    Matcher localMatcher;
    if (paramString != null)
    {
      localMatcher = Pattern.compile("(\\d+)\\.(\\d+)(\\.\\d+)?").matcher(paramString);
      boolean bool2 = localMatcher.matches();
      bool1 = false;
      if (!bool2);
    }
    try
    {
      int i = Integer.parseInt(localMatcher.group(1));
      int j = Integer.parseInt(localMatcher.group(2));
      if (i <= 2)
      {
        bool1 = false;
        if (i == 2)
        {
          bool1 = false;
          if (j < 1);
        }
      }
      else
      {
        bool1 = true;
      }
      StringBuilder localStringBuilder = new StringBuilder().append("VM with version ").append(paramString);
      if (bool1);
      for (String str = " has multidex support"; ; str = " does not have multidex support")
      {
        Log.i("MultiDex", str);
        return bool1;
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (true)
        bool1 = false;
    }
  }

  private static ApplicationInfo b(Context paramContext)
  {
    try
    {
      ApplicationInfo localApplicationInfo = paramContext.getApplicationInfo();
      return localApplicationInfo;
    }
    catch (RuntimeException localRuntimeException)
    {
      Log.w("MultiDex", "Failure while trying to obtain ApplicationInfo from Context. Must be running in test mode. Skip patching.", localRuntimeException);
    }
    return null;
  }

  private static Field b(Object paramObject, String paramString)
    throws NoSuchFieldException
  {
    Class localClass = paramObject.getClass();
    while (localClass != null)
      try
      {
        Field localField = localClass.getDeclaredField(paramString);
        if (!localField.isAccessible())
          localField.setAccessible(true);
        return localField;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        localClass = localClass.getSuperclass();
      }
    throw new NoSuchFieldException("Field " + paramString + " not found in " + paramObject.getClass());
  }

  private static Method b(Object paramObject, String paramString, Class<?>[] paramArrayOfClass)
    throws NoSuchMethodException
  {
    Class localClass = paramObject.getClass();
    while (localClass != null)
      try
      {
        Method localMethod = localClass.getDeclaredMethod(paramString, paramArrayOfClass);
        if (!localMethod.isAccessible())
          localMethod.setAccessible(true);
        return localMethod;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        localClass = localClass.getSuperclass();
      }
    throw new NoSuchMethodException("Method " + paramString + " with parameters " + Arrays.asList(paramArrayOfClass) + " not found in " + paramObject.getClass());
  }

  private static void b(Object paramObject, String paramString, Object[] paramArrayOfObject)
    throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException
  {
    Field localField = b(paramObject, paramString);
    Object[] arrayOfObject1 = (Object[])localField.get(paramObject);
    Object[] arrayOfObject2 = (Object[])Array.newInstance(arrayOfObject1.getClass().getComponentType(), arrayOfObject1.length + paramArrayOfObject.length);
    System.arraycopy(arrayOfObject1, 0, arrayOfObject2, 0, arrayOfObject1.length);
    System.arraycopy(paramArrayOfObject, 0, arrayOfObject2, arrayOfObject1.length, paramArrayOfObject.length);
    localField.set(paramObject, arrayOfObject2);
  }

  private static void c(Context paramContext)
    throws Exception
  {
    File localFile1 = new File(paramContext.getFilesDir(), "secondary-dexes");
    File[] arrayOfFile;
    if (localFile1.isDirectory())
    {
      Log.i("MultiDex", "Clearing old secondary dex dir (" + localFile1.getPath() + ").");
      arrayOfFile = localFile1.listFiles();
      if (arrayOfFile == null)
        Log.w("MultiDex", "Failed to list secondary dex dir content (" + localFile1.getPath() + ").");
    }
    else
    {
      return;
    }
    int i = arrayOfFile.length;
    int j = 0;
    if (j < i)
    {
      File localFile2 = arrayOfFile[j];
      Log.i("MultiDex", "Trying to delete old file " + localFile2.getPath() + " of size " + localFile2.length());
      if (!localFile2.delete())
        Log.w("MultiDex", "Failed to delete old file " + localFile2.getPath());
      while (true)
      {
        j++;
        break;
        Log.i("MultiDex", "Deleted old file " + localFile2.getPath());
      }
    }
    if (!localFile1.delete())
    {
      Log.w("MultiDex", "Failed to delete secondary dex dir " + localFile1.getPath());
      return;
    }
    Log.i("MultiDex", "Deleted old secondary dex dir " + localFile1.getPath());
  }

  private static final class a
  {
    private static final int a = ".zip".length();
    private final a b;

    private a()
      throws ClassNotFoundException, SecurityException, NoSuchMethodException
    {
      Class localClass = Class.forName("dalvik.system.DexPathList$Element");
      try
      {
        localObject = new b(localClass);
        this.b = ((a)localObject);
        return;
      }
      catch (NoSuchMethodException localNoSuchMethodException1)
      {
        while (true)
          try
          {
            localObject = new c(localClass);
          }
          catch (NoSuchMethodException localNoSuchMethodException2)
          {
            Object localObject = new d(localClass);
          }
      }
    }

    private static String a(File paramFile)
    {
      File localFile = paramFile.getParentFile();
      String str = paramFile.getName();
      return new File(localFile, str.substring(0, str.length() - a) + ".dex").getPath();
    }

    static void a(ClassLoader paramClassLoader, List<? extends File> paramList)
      throws IOException, SecurityException, IllegalArgumentException, ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchFieldException
    {
      Object localObject = a.a(paramClassLoader, "pathList").get(paramClassLoader);
      Object[] arrayOfObject = new a().a(paramList);
      try
      {
        a.a(localObject, "dexElements", arrayOfObject);
        return;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        Log.w("MultiDex", "Failed find field 'dexElements' attempting 'pathElements'", localNoSuchFieldException);
        a.a(localObject, "pathElements", arrayOfObject);
      }
    }

    private Object[] a(List<? extends File> paramList)
      throws IOException, SecurityException, IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException
    {
      Object[] arrayOfObject = new Object[paramList.size()];
      for (int i = 0; i < arrayOfObject.length; i++)
      {
        File localFile = (File)paramList.get(i);
        arrayOfObject[i] = this.b.a(localFile, DexFile.loadDex(localFile.getPath(), a(localFile), 0));
      }
      return arrayOfObject;
    }

    private static abstract interface a
    {
      public abstract Object a(File paramFile, DexFile paramDexFile)
        throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException;
    }

    private static class b
      implements a.a.a
    {
      private final Constructor<?> a;

      b(Class<?> paramClass)
        throws SecurityException, NoSuchMethodException
      {
        this.a = paramClass.getConstructor(new Class[] { File.class, ZipFile.class, DexFile.class });
        this.a.setAccessible(true);
      }

      public Object a(File paramFile, DexFile paramDexFile)
        throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException, IOException
      {
        Constructor localConstructor = this.a;
        Object[] arrayOfObject = new Object[3];
        arrayOfObject[0] = paramFile;
        arrayOfObject[1] = new ZipFile(paramFile);
        arrayOfObject[2] = paramDexFile;
        return localConstructor.newInstance(arrayOfObject);
      }
    }

    private static class c
      implements a.a.a
    {
      private final Constructor<?> a;

      c(Class<?> paramClass)
        throws SecurityException, NoSuchMethodException
      {
        this.a = paramClass.getConstructor(new Class[] { File.class, File.class, DexFile.class });
        this.a.setAccessible(true);
      }

      public Object a(File paramFile, DexFile paramDexFile)
        throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException
      {
        return this.a.newInstance(new Object[] { paramFile, paramFile, paramDexFile });
      }
    }

    private static class d
      implements a.a.a
    {
      private final Constructor<?> a;

      d(Class<?> paramClass)
        throws SecurityException, NoSuchMethodException
      {
        Class[] arrayOfClass = new Class[4];
        arrayOfClass[0] = File.class;
        arrayOfClass[1] = Boolean.TYPE;
        arrayOfClass[2] = File.class;
        arrayOfClass[3] = DexFile.class;
        this.a = paramClass.getConstructor(arrayOfClass);
        this.a.setAccessible(true);
      }

      public Object a(File paramFile, DexFile paramDexFile)
        throws IllegalArgumentException, InstantiationException, IllegalAccessException, InvocationTargetException
      {
        Constructor localConstructor = this.a;
        Object[] arrayOfObject = new Object[4];
        arrayOfObject[0] = paramFile;
        arrayOfObject[1] = Boolean.FALSE;
        arrayOfObject[2] = paramFile;
        arrayOfObject[3] = paramDexFile;
        return localConstructor.newInstance(arrayOfObject);
      }
    }
  }

  private static final class b
  {
    static void a(ClassLoader paramClassLoader, List<? extends File> paramList, File paramFile)
      throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, InvocationTargetException, NoSuchMethodException, IOException
    {
      Object localObject1 = a.a(paramClassLoader, "pathList").get(paramClassLoader);
      ArrayList localArrayList = new ArrayList();
      a.a(localObject1, "dexElements", a(localObject1, new ArrayList(paramList), paramFile, localArrayList));
      if (localArrayList.size() > 0)
      {
        Iterator localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
          Log.w("MultiDex", "Exception in makeDexElement", (IOException)localIterator.next());
        Field localField = a.a(localObject1, "dexElementsSuppressedExceptions");
        IOException[] arrayOfIOException1 = (IOException[])localField.get(localObject1);
        if (arrayOfIOException1 == null);
        IOException[] arrayOfIOException2;
        for (Object localObject2 = (IOException[])localArrayList.toArray(new IOException[localArrayList.size()]); ; localObject2 = arrayOfIOException2)
        {
          localField.set(localObject1, localObject2);
          IOException localIOException = new IOException("I/O exception during makeDexElement");
          localIOException.initCause((Throwable)localArrayList.get(0));
          throw localIOException;
          arrayOfIOException2 = new IOException[localArrayList.size() + arrayOfIOException1.length];
          localArrayList.toArray(arrayOfIOException2);
          System.arraycopy(arrayOfIOException1, 0, arrayOfIOException2, localArrayList.size(), arrayOfIOException1.length);
        }
      }
    }

    private static Object[] a(Object paramObject, ArrayList<File> paramArrayList, File paramFile, ArrayList<IOException> paramArrayList1)
      throws IllegalAccessException, InvocationTargetException, NoSuchMethodException
    {
      return (Object[])a.a(paramObject, "makeDexElements", new Class[] { ArrayList.class, File.class, ArrayList.class }).invoke(paramObject, new Object[] { paramArrayList, paramFile, paramArrayList1 });
    }
  }

  private static final class c
  {
    static void a(ClassLoader paramClassLoader, List<? extends File> paramList)
      throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, IOException
    {
      int i = paramList.size();
      Field localField = a.a(paramClassLoader, "path");
      StringBuilder localStringBuilder = new StringBuilder((String)localField.get(paramClassLoader));
      String[] arrayOfString = new String[i];
      File[] arrayOfFile = new File[i];
      ZipFile[] arrayOfZipFile = new ZipFile[i];
      DexFile[] arrayOfDexFile = new DexFile[i];
      ListIterator localListIterator = paramList.listIterator();
      while (localListIterator.hasNext())
      {
        File localFile = (File)localListIterator.next();
        String str = localFile.getAbsolutePath();
        localStringBuilder.append(':').append(str);
        int j = localListIterator.previousIndex();
        arrayOfString[j] = str;
        arrayOfFile[j] = localFile;
        arrayOfZipFile[j] = new ZipFile(localFile);
        arrayOfDexFile[j] = DexFile.loadDex(str, str + ".dex", 0);
      }
      localField.set(paramClassLoader, localStringBuilder.toString());
      a.a(paramClassLoader, "mPaths", arrayOfString);
      a.a(paramClassLoader, "mFiles", arrayOfFile);
      a.a(paramClassLoader, "mZips", arrayOfZipFile);
      a.a(paramClassLoader, "mDexs", arrayOfDexFile);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.multidex.a
 * JD-Core Version:    0.6.2
 */