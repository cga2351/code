package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.support.v4.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry;
import android.support.v4.content.res.FontResourcesParserCompat.FontFileResourceEntry;
import android.support.v4.provider.FontsContractCompat.FontInfo;
import android.support.v4.util.SimpleArrayMap;
import android.util.Log;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.List;

class TypefaceCompatApi24Impl extends TypefaceCompatBaseImpl
{
  private static final String ADD_FONT_WEIGHT_STYLE_METHOD = "addFontWeightStyle";
  private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
  private static final String FONT_FAMILY_CLASS = "android.graphics.FontFamily";
  private static final String TAG = "TypefaceCompatApi24Impl";
  private static final Method sAddFontWeightStyle;
  private static final Method sCreateFromFamiliesWithDefault;
  private static final Class sFontFamily;
  private static final Constructor sFontFamilyCtor;

  static
  {
    try
    {
      Class localClass2 = Class.forName("android.graphics.FontFamily");
      Constructor localConstructor2 = localClass2.getConstructor(new Class[0]);
      Class[] arrayOfClass1 = new Class[5];
      arrayOfClass1[0] = ByteBuffer.class;
      arrayOfClass1[1] = Integer.TYPE;
      arrayOfClass1[2] = List.class;
      arrayOfClass1[3] = Integer.TYPE;
      arrayOfClass1[4] = Boolean.TYPE;
      Method localMethod3 = localClass2.getMethod("addFontWeightStyle", arrayOfClass1);
      Object localObject = Array.newInstance(localClass2, 1);
      Class[] arrayOfClass2 = new Class[1];
      arrayOfClass2[0] = localObject.getClass();
      Method localMethod4 = Typeface.class.getMethod("createFromFamiliesWithDefault", arrayOfClass2);
      localMethod1 = localMethod4;
      localMethod2 = localMethod3;
      localConstructor1 = localConstructor2;
      localClass1 = localClass2;
      sFontFamilyCtor = localConstructor1;
      sFontFamily = localClass1;
      sAddFontWeightStyle = localMethod2;
      sCreateFromFamiliesWithDefault = localMethod1;
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      while (true)
      {
        Log.e("TypefaceCompatApi24Impl", localClassNotFoundException.getClass().getName(), localClassNotFoundException);
        Method localMethod1 = null;
        Method localMethod2 = null;
        Constructor localConstructor1 = null;
        Class localClass1 = null;
      }
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      label136: break label136;
    }
  }

  private static boolean addFontWeightStyle(Object paramObject, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    try
    {
      Method localMethod = sAddFontWeightStyle;
      Object[] arrayOfObject = new Object[5];
      arrayOfObject[0] = paramByteBuffer;
      arrayOfObject[1] = Integer.valueOf(paramInt1);
      arrayOfObject[2] = null;
      arrayOfObject[3] = Integer.valueOf(paramInt2);
      arrayOfObject[4] = Boolean.valueOf(paramBoolean);
      boolean bool = ((Boolean)localMethod.invoke(paramObject, arrayOfObject)).booleanValue();
      return bool;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      label67: break label67;
    }
  }

  private static Typeface createFromFamiliesWithDefault(Object paramObject)
  {
    try
    {
      Object localObject = Array.newInstance(sFontFamily, 1);
      Array.set(localObject, 0, paramObject);
      Typeface localTypeface = (Typeface)sCreateFromFamiliesWithDefault.invoke(null, new Object[] { localObject });
      return localTypeface;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException(localIllegalAccessException);
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      label36: break label36;
    }
  }

  public static boolean isUsable()
  {
    if (sAddFontWeightStyle == null)
      Log.w("TypefaceCompatApi24Impl", "Unable to collect necessary private methods.Fallback to legacy implementation.");
    return sAddFontWeightStyle != null;
  }

  private static Object newFamily()
  {
    try
    {
      Object localObject = sFontFamilyCtor.newInstance(new Object[0]);
      return localObject;
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new RuntimeException(localInstantiationException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      break label14;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      label14: break label14;
    }
  }

  public Typeface createFromFontFamilyFilesResourceEntry(Context paramContext, FontResourcesParserCompat.FontFamilyFilesResourceEntry paramFontFamilyFilesResourceEntry, Resources paramResources, int paramInt)
  {
    Object localObject = newFamily();
    for (FontResourcesParserCompat.FontFileResourceEntry localFontFileResourceEntry : paramFontFamilyFilesResourceEntry.getEntries())
    {
      ByteBuffer localByteBuffer = TypefaceCompatUtil.copyToDirectBuffer(paramContext, paramResources, localFontFileResourceEntry.getResourceId());
      if (localByteBuffer == null);
      while (!addFontWeightStyle(localObject, localByteBuffer, localFontFileResourceEntry.getTtcIndex(), localFontFileResourceEntry.getWeight(), localFontFileResourceEntry.isItalic()))
        return null;
    }
    return createFromFamiliesWithDefault(localObject);
  }

  public Typeface createFromFontInfo(Context paramContext, CancellationSignal paramCancellationSignal, FontsContractCompat.FontInfo[] paramArrayOfFontInfo, int paramInt)
  {
    Object localObject = newFamily();
    SimpleArrayMap localSimpleArrayMap = new SimpleArrayMap();
    int i = paramArrayOfFontInfo.length;
    for (int j = 0; j < i; j++)
    {
      FontsContractCompat.FontInfo localFontInfo = paramArrayOfFontInfo[j];
      Uri localUri = localFontInfo.getUri();
      ByteBuffer localByteBuffer = (ByteBuffer)localSimpleArrayMap.get(localUri);
      if (localByteBuffer == null)
      {
        localByteBuffer = TypefaceCompatUtil.mmap(paramContext, paramCancellationSignal, localUri);
        localSimpleArrayMap.put(localUri, localByteBuffer);
      }
      if (!addFontWeightStyle(localObject, localByteBuffer, localFontInfo.getTtcIndex(), localFontInfo.getWeight(), localFontInfo.isItalic()))
        return null;
    }
    return Typeface.create(createFromFamiliesWithDefault(localObject), paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.graphics.TypefaceCompatApi24Impl
 * JD-Core Version:    0.6.2
 */