package android.support.v4.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.support.v4.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry;
import android.support.v4.content.res.FontResourcesParserCompat.FontFileResourceEntry;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

public class TypefaceCompatApi26Impl extends TypefaceCompatApi21Impl
{
  private static final String ABORT_CREATION_METHOD = "abortCreation";
  private static final String ADD_FONT_FROM_ASSET_MANAGER_METHOD = "addFontFromAssetManager";
  private static final String ADD_FONT_FROM_BUFFER_METHOD = "addFontFromBuffer";
  private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
  private static final String DEFAULT_FAMILY = "sans-serif";
  private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
  private static final String FREEZE_METHOD = "freeze";
  private static final int RESOLVE_BY_FONT_TABLE = -1;
  private static final String TAG = "TypefaceCompatApi26Impl";
  protected final Method mAbortCreation;
  protected final Method mAddFontFromAssetManager;
  protected final Method mAddFontFromBuffer;
  protected final Method mCreateFromFamiliesWithDefault;
  protected final Class mFontFamily;
  protected final Constructor mFontFamilyCtor;
  protected final Method mFreeze;

  public TypefaceCompatApi26Impl()
  {
    try
    {
      Class localClass2 = obtainFontFamily();
      Constructor localConstructor2 = obtainFontFamilyCtor(localClass2);
      Method localMethod6 = obtainAddFontFromAssetManagerMethod(localClass2);
      Method localMethod7 = obtainAddFontFromBufferMethod(localClass2);
      Method localMethod8 = obtainFreezeMethod(localClass2);
      Method localMethod9 = obtainAbortCreationMethod(localClass2);
      Method localMethod10 = obtainCreateFromFamiliesWithDefaultMethod(localClass2);
      localMethod1 = localMethod10;
      localMethod2 = localMethod9;
      localMethod3 = localMethod8;
      localMethod4 = localMethod7;
      localMethod5 = localMethod6;
      localConstructor1 = localConstructor2;
      localClass1 = localClass2;
      this.mFontFamily = localClass1;
      this.mFontFamilyCtor = localConstructor1;
      this.mAddFontFromAssetManager = localMethod5;
      this.mAddFontFromBuffer = localMethod4;
      this.mFreeze = localMethod3;
      this.mAbortCreation = localMethod2;
      this.mCreateFromFamiliesWithDefault = localMethod1;
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      while (true)
      {
        Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class " + localClassNotFoundException.getClass().getName(), localClassNotFoundException);
        Method localMethod1 = null;
        Method localMethod2 = null;
        Method localMethod3 = null;
        Method localMethod4 = null;
        Method localMethod5 = null;
        Constructor localConstructor1 = null;
        Class localClass1 = null;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label128: break label128;
    }
  }

  private void abortCreation(Object paramObject)
  {
    try
    {
      this.mAbortCreation.invoke(paramObject, new Object[0]);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      label15: break label15;
    }
  }

  private boolean addFontFromAssetManager(Context paramContext, Object paramObject, String paramString, int paramInt1, int paramInt2, int paramInt3, FontVariationAxis[] paramArrayOfFontVariationAxis)
  {
    try
    {
      Method localMethod = this.mAddFontFromAssetManager;
      Object[] arrayOfObject = new Object[8];
      arrayOfObject[0] = paramContext.getAssets();
      arrayOfObject[1] = paramString;
      arrayOfObject[2] = Integer.valueOf(0);
      arrayOfObject[3] = Boolean.valueOf(false);
      arrayOfObject[4] = Integer.valueOf(paramInt1);
      arrayOfObject[5] = Integer.valueOf(paramInt2);
      arrayOfObject[6] = Integer.valueOf(paramInt3);
      arrayOfObject[7] = paramArrayOfFontVariationAxis;
      boolean bool = ((Boolean)localMethod.invoke(paramObject, arrayOfObject)).booleanValue();
      return bool;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      label98: break label98;
    }
  }

  private boolean addFontFromBuffer(Object paramObject, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      Method localMethod = this.mAddFontFromBuffer;
      Object[] arrayOfObject = new Object[5];
      arrayOfObject[0] = paramByteBuffer;
      arrayOfObject[1] = Integer.valueOf(paramInt1);
      arrayOfObject[2] = null;
      arrayOfObject[3] = Integer.valueOf(paramInt2);
      arrayOfObject[4] = Integer.valueOf(paramInt3);
      boolean bool = ((Boolean)localMethod.invoke(paramObject, arrayOfObject)).booleanValue();
      return bool;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      label69: break label69;
    }
  }

  private boolean freeze(Object paramObject)
  {
    try
    {
      boolean bool = ((Boolean)this.mFreeze.invoke(paramObject, new Object[0])).booleanValue();
      return bool;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      label22: break label22;
    }
  }

  private boolean isFontFamilyPrivateAPIAvailable()
  {
    if (this.mAddFontFromAssetManager == null)
      Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
    return this.mAddFontFromAssetManager != null;
  }

  private Object newFamily()
  {
    try
    {
      Object localObject = this.mFontFamilyCtor.newInstance(new Object[0]);
      return localObject;
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new RuntimeException(localInstantiationException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label15;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      label15: break label15;
    }
  }

  protected Typeface createFromFamiliesWithDefault(Object paramObject)
  {
    try
    {
      Object localObject = Array.newInstance(this.mFontFamily, 1);
      Array.set(localObject, 0, paramObject);
      Method localMethod = this.mCreateFromFamiliesWithDefault;
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = localObject;
      arrayOfObject[1] = Integer.valueOf(-1);
      arrayOfObject[2] = Integer.valueOf(-1);
      Typeface localTypeface = (Typeface)localMethod.invoke(null, arrayOfObject);
      return localTypeface;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      label65: break label65;
    }
  }

  public Typeface createFromFontFamilyFilesResourceEntry(Context paramContext, FontResourcesParserCompat.FontFamilyFilesResourceEntry paramFontFamilyFilesResourceEntry, Resources paramResources, int paramInt)
  {
    if (!isFontFamilyPrivateAPIAvailable())
      return super.createFromFontFamilyFilesResourceEntry(paramContext, paramFontFamilyFilesResourceEntry, paramResources, paramInt);
    Object localObject = newFamily();
    for (FontResourcesParserCompat.FontFileResourceEntry localFontFileResourceEntry : paramFontFamilyFilesResourceEntry.getEntries())
    {
      String str = localFontFileResourceEntry.getFileName();
      int k = localFontFileResourceEntry.getTtcIndex();
      int m = localFontFileResourceEntry.getWeight();
      if (localFontFileResourceEntry.isItalic());
      for (int n = 1; !addFontFromAssetManager(paramContext, localObject, str, k, m, n, FontVariationAxis.fromFontVariationSettings(localFontFileResourceEntry.getVariationSettings())); n = 0)
      {
        abortCreation(localObject);
        return null;
      }
    }
    if (!freeze(localObject))
      return null;
    return createFromFamiliesWithDefault(localObject);
  }

  // ERROR //
  public Typeface createFromFontInfo(Context paramContext, android.os.CancellationSignal paramCancellationSignal, android.support.v4.provider.FontsContractCompat.FontInfo[] paramArrayOfFontInfo, int paramInt)
  {
    // Byte code:
    //   0: aload_3
    //   1: arraylength
    //   2: iconst_1
    //   3: if_icmpge +9 -> 12
    //   6: aconst_null
    //   7: astore 19
    //   9: aload 19
    //   11: areturn
    //   12: aload_0
    //   13: invokespecial 190	android/support/v4/graphics/TypefaceCompatApi26Impl:isFontFamilyPrivateAPIAvailable	()Z
    //   16: ifne +200 -> 216
    //   19: aload_0
    //   20: aload_3
    //   21: iload 4
    //   23: invokevirtual 242	android/support/v4/graphics/TypefaceCompatApi26Impl:findBestInfo	([Landroid/support/v4/provider/FontsContractCompat$FontInfo;I)Landroid/support/v4/provider/FontsContractCompat$FontInfo;
    //   26: astore 15
    //   28: aload_1
    //   29: invokevirtual 246	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   32: astore 16
    //   34: aload 16
    //   36: aload 15
    //   38: invokevirtual 252	android/support/v4/provider/FontsContractCompat$FontInfo:getUri	()Landroid/net/Uri;
    //   41: ldc 254
    //   43: aload_2
    //   44: invokevirtual 260	android/content/ContentResolver:openFileDescriptor	(Landroid/net/Uri;Ljava/lang/String;Landroid/os/CancellationSignal;)Landroid/os/ParcelFileDescriptor;
    //   47: astore 18
    //   49: aload 18
    //   51: ifnonnull +39 -> 90
    //   54: aconst_null
    //   55: astore 19
    //   57: aload 18
    //   59: ifnull -50 -> 9
    //   62: iconst_0
    //   63: ifeq +20 -> 83
    //   66: aload 18
    //   68: invokevirtual 265	android/os/ParcelFileDescriptor:close	()V
    //   71: aconst_null
    //   72: areturn
    //   73: astore 20
    //   75: aconst_null
    //   76: aload 20
    //   78: invokevirtual 268	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   81: aconst_null
    //   82: areturn
    //   83: aload 18
    //   85: invokevirtual 265	android/os/ParcelFileDescriptor:close	()V
    //   88: aconst_null
    //   89: areturn
    //   90: new 270	android/graphics/Typeface$Builder
    //   93: dup
    //   94: aload 18
    //   96: invokevirtual 274	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   99: invokespecial 277	android/graphics/Typeface$Builder:<init>	(Ljava/io/FileDescriptor;)V
    //   102: aload 15
    //   104: invokevirtual 278	android/support/v4/provider/FontsContractCompat$FontInfo:getWeight	()I
    //   107: invokevirtual 282	android/graphics/Typeface$Builder:setWeight	(I)Landroid/graphics/Typeface$Builder;
    //   110: aload 15
    //   112: invokevirtual 283	android/support/v4/provider/FontsContractCompat$FontInfo:isItalic	()Z
    //   115: invokevirtual 287	android/graphics/Typeface$Builder:setItalic	(Z)Landroid/graphics/Typeface$Builder;
    //   118: invokevirtual 291	android/graphics/Typeface$Builder:build	()Landroid/graphics/Typeface;
    //   121: astore 26
    //   123: aload 26
    //   125: astore 19
    //   127: aload 18
    //   129: ifnull -120 -> 9
    //   132: iconst_0
    //   133: ifeq +22 -> 155
    //   136: aload 18
    //   138: invokevirtual 265	android/os/ParcelFileDescriptor:close	()V
    //   141: aload 19
    //   143: areturn
    //   144: astore 27
    //   146: aconst_null
    //   147: aload 27
    //   149: invokevirtual 268	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   152: aload 19
    //   154: areturn
    //   155: aload 18
    //   157: invokevirtual 265	android/os/ParcelFileDescriptor:close	()V
    //   160: aload 19
    //   162: areturn
    //   163: astore 24
    //   165: aload 24
    //   167: athrow
    //   168: astore 25
    //   170: aload 24
    //   172: astore 22
    //   174: aload 25
    //   176: astore 21
    //   178: aload 18
    //   180: ifnull +13 -> 193
    //   183: aload 22
    //   185: ifnull +23 -> 208
    //   188: aload 18
    //   190: invokevirtual 265	android/os/ParcelFileDescriptor:close	()V
    //   193: aload 21
    //   195: athrow
    //   196: astore 23
    //   198: aload 22
    //   200: aload 23
    //   202: invokevirtual 268	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   205: goto -12 -> 193
    //   208: aload 18
    //   210: invokevirtual 265	android/os/ParcelFileDescriptor:close	()V
    //   213: goto -20 -> 193
    //   216: aload_1
    //   217: aload_3
    //   218: aload_2
    //   219: invokestatic 297	android/support/v4/provider/FontsContractCompat:prepareFontData	(Landroid/content/Context;[Landroid/support/v4/provider/FontsContractCompat$FontInfo;Landroid/os/CancellationSignal;)Ljava/util/Map;
    //   222: astore 5
    //   224: aload_0
    //   225: invokespecial 194	android/support/v4/graphics/TypefaceCompatApi26Impl:newFamily	()Ljava/lang/Object;
    //   228: astore 6
    //   230: aload_3
    //   231: arraylength
    //   232: istore 7
    //   234: iconst_0
    //   235: istore 8
    //   237: iconst_0
    //   238: istore 9
    //   240: iload 8
    //   242: iload 7
    //   244: if_icmpge +99 -> 343
    //   247: aload_3
    //   248: iload 8
    //   250: aaload
    //   251: astore 10
    //   253: aload 5
    //   255: aload 10
    //   257: invokevirtual 252	android/support/v4/provider/FontsContractCompat$FontInfo:getUri	()Landroid/net/Uri;
    //   260: invokeinterface 303 2 0
    //   265: checkcast 305	java/nio/ByteBuffer
    //   268: astore 11
    //   270: aload 11
    //   272: ifnonnull +9 -> 281
    //   275: iinc 8 1
    //   278: goto -38 -> 240
    //   281: aload 10
    //   283: invokevirtual 306	android/support/v4/provider/FontsContractCompat$FontInfo:getTtcIndex	()I
    //   286: istore 12
    //   288: aload 10
    //   290: invokevirtual 278	android/support/v4/provider/FontsContractCompat$FontInfo:getWeight	()I
    //   293: istore 13
    //   295: aload 10
    //   297: invokevirtual 283	android/support/v4/provider/FontsContractCompat$FontInfo:isItalic	()Z
    //   300: ifeq +31 -> 331
    //   303: iconst_1
    //   304: istore 14
    //   306: aload_0
    //   307: aload 6
    //   309: aload 11
    //   311: iload 12
    //   313: iload 13
    //   315: iload 14
    //   317: invokespecial 308	android/support/v4/graphics/TypefaceCompatApi26Impl:addFontFromBuffer	(Ljava/lang/Object;Ljava/nio/ByteBuffer;III)Z
    //   320: ifne +17 -> 337
    //   323: aload_0
    //   324: aload 6
    //   326: invokespecial 228	android/support/v4/graphics/TypefaceCompatApi26Impl:abortCreation	(Ljava/lang/Object;)V
    //   329: aconst_null
    //   330: areturn
    //   331: iconst_0
    //   332: istore 14
    //   334: goto -28 -> 306
    //   337: iconst_1
    //   338: istore 9
    //   340: goto -65 -> 275
    //   343: iload 9
    //   345: ifne +11 -> 356
    //   348: aload_0
    //   349: aload 6
    //   351: invokespecial 228	android/support/v4/graphics/TypefaceCompatApi26Impl:abortCreation	(Ljava/lang/Object;)V
    //   354: aconst_null
    //   355: areturn
    //   356: aload_0
    //   357: aload 6
    //   359: invokespecial 230	android/support/v4/graphics/TypefaceCompatApi26Impl:freeze	(Ljava/lang/Object;)Z
    //   362: ifne +5 -> 367
    //   365: aconst_null
    //   366: areturn
    //   367: aload_0
    //   368: aload 6
    //   370: invokevirtual 232	android/support/v4/graphics/TypefaceCompatApi26Impl:createFromFamiliesWithDefault	(Ljava/lang/Object;)Landroid/graphics/Typeface;
    //   373: iload 4
    //   375: invokestatic 312	android/graphics/Typeface:create	(Landroid/graphics/Typeface;I)Landroid/graphics/Typeface;
    //   378: areturn
    //   379: astore 21
    //   381: aconst_null
    //   382: astore 22
    //   384: goto -206 -> 178
    //   387: astore 17
    //   389: aconst_null
    //   390: areturn
    //
    // Exception table:
    //   from	to	target	type
    //   66	71	73	java/lang/Throwable
    //   136	141	144	java/lang/Throwable
    //   90	123	163	java/lang/Throwable
    //   165	168	168	finally
    //   188	193	196	java/lang/Throwable
    //   90	123	379	finally
    //   34	49	387	java/io/IOException
    //   66	71	387	java/io/IOException
    //   75	81	387	java/io/IOException
    //   83	88	387	java/io/IOException
    //   136	141	387	java/io/IOException
    //   146	152	387	java/io/IOException
    //   155	160	387	java/io/IOException
    //   188	193	387	java/io/IOException
    //   193	196	387	java/io/IOException
    //   198	205	387	java/io/IOException
    //   208	213	387	java/io/IOException
  }

  public Typeface createFromResourcesFontFile(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2)
  {
    Typeface localTypeface;
    if (!isFontFamilyPrivateAPIAvailable())
      localTypeface = super.createFromResourcesFontFile(paramContext, paramResources, paramInt1, paramString, paramInt2);
    Object localObject;
    boolean bool;
    do
    {
      return localTypeface;
      localObject = newFamily();
      if (!addFontFromAssetManager(paramContext, localObject, paramString, 0, -1, -1, null))
      {
        abortCreation(localObject);
        return null;
      }
      bool = freeze(localObject);
      localTypeface = null;
    }
    while (!bool);
    return createFromFamiliesWithDefault(localObject);
  }

  protected Method obtainAbortCreationMethod(Class paramClass)
    throws NoSuchMethodException
  {
    return paramClass.getMethod("abortCreation", new Class[0]);
  }

  protected Method obtainAddFontFromAssetManagerMethod(Class paramClass)
    throws NoSuchMethodException
  {
    Class[] arrayOfClass = new Class[8];
    arrayOfClass[0] = AssetManager.class;
    arrayOfClass[1] = String.class;
    arrayOfClass[2] = Integer.TYPE;
    arrayOfClass[3] = Boolean.TYPE;
    arrayOfClass[4] = Integer.TYPE;
    arrayOfClass[5] = Integer.TYPE;
    arrayOfClass[6] = Integer.TYPE;
    arrayOfClass[7] = [Landroid.graphics.fonts.FontVariationAxis.class;
    return paramClass.getMethod("addFontFromAssetManager", arrayOfClass);
  }

  protected Method obtainAddFontFromBufferMethod(Class paramClass)
    throws NoSuchMethodException
  {
    Class[] arrayOfClass = new Class[5];
    arrayOfClass[0] = ByteBuffer.class;
    arrayOfClass[1] = Integer.TYPE;
    arrayOfClass[2] = [Landroid.graphics.fonts.FontVariationAxis.class;
    arrayOfClass[3] = Integer.TYPE;
    arrayOfClass[4] = Integer.TYPE;
    return paramClass.getMethod("addFontFromBuffer", arrayOfClass);
  }

  protected Method obtainCreateFromFamiliesWithDefaultMethod(Class paramClass)
    throws NoSuchMethodException
  {
    Object localObject = Array.newInstance(paramClass, 1);
    Class[] arrayOfClass = new Class[3];
    arrayOfClass[0] = localObject.getClass();
    arrayOfClass[1] = Integer.TYPE;
    arrayOfClass[2] = Integer.TYPE;
    Method localMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", arrayOfClass);
    localMethod.setAccessible(true);
    return localMethod;
  }

  protected Class obtainFontFamily()
    throws ClassNotFoundException
  {
    return Class.forName("android.graphics.FontFamily");
  }

  protected Constructor obtainFontFamilyCtor(Class paramClass)
    throws NoSuchMethodException
  {
    return paramClass.getConstructor(new Class[0]);
  }

  protected Method obtainFreezeMethod(Class paramClass)
    throws NoSuchMethodException
  {
    return paramClass.getMethod("freeze", new Class[0]);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.graphics.TypefaceCompatApi26Impl
 * JD-Core Version:    0.6.2
 */