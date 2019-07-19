package android.support.v4.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.support.v4.content.res.FontResourcesParserCompat.FontFamilyFilesResourceEntry;
import android.support.v4.content.res.FontResourcesParserCompat.FontFileResourceEntry;
import android.support.v4.provider.FontsContractCompat.FontInfo;
import java.io.File;
import java.io.InputStream;

class TypefaceCompatBaseImpl
{
  private static final String CACHE_FILE_PREFIX = "cached_font_";
  private static final String TAG = "TypefaceCompatBaseImpl";

  private FontResourcesParserCompat.FontFileResourceEntry findBestEntry(FontResourcesParserCompat.FontFamilyFilesResourceEntry paramFontFamilyFilesResourceEntry, int paramInt)
  {
    return (FontResourcesParserCompat.FontFileResourceEntry)findBestFont(paramFontFamilyFilesResourceEntry.getEntries(), paramInt, new StyleExtractor()
    {
      public int getWeight(FontResourcesParserCompat.FontFileResourceEntry paramAnonymousFontFileResourceEntry)
      {
        return paramAnonymousFontFileResourceEntry.getWeight();
      }

      public boolean isItalic(FontResourcesParserCompat.FontFileResourceEntry paramAnonymousFontFileResourceEntry)
      {
        return paramAnonymousFontFileResourceEntry.isItalic();
      }
    });
  }

  private static <T> T findBestFont(T[] paramArrayOfT, int paramInt, StyleExtractor<T> paramStyleExtractor)
  {
    int i;
    int j;
    label19: Object localObject1;
    int n;
    label33: T ?;
    int i2;
    if ((paramInt & 0x1) == 0)
    {
      i = 400;
      if ((paramInt & 0x2) == 0)
        break label123;
      j = 1;
      localObject1 = null;
      int k = 2147483647;
      int m = paramArrayOfT.length;
      n = 0;
      if (n >= m)
        break label135;
      ? = paramArrayOfT[n];
      int i1 = 2 * Math.abs(paramStyleExtractor.getWeight(?) - i);
      if (paramStyleExtractor.isItalic(?) != j)
        break label129;
      i2 = 0;
      label79: int i3 = i2 + i1;
      if ((localObject1 != null) && (k <= i3))
        break label138;
      k = i3;
    }
    label129: label135: label138: for (Object localObject2 = ?; ; localObject2 = localObject1)
    {
      n++;
      localObject1 = localObject2;
      break label33;
      i = 700;
      break;
      label123: j = 0;
      break label19;
      i2 = 1;
      break label79;
      return localObject1;
    }
  }

  public Typeface createFromFontFamilyFilesResourceEntry(Context paramContext, FontResourcesParserCompat.FontFamilyFilesResourceEntry paramFontFamilyFilesResourceEntry, Resources paramResources, int paramInt)
  {
    FontResourcesParserCompat.FontFileResourceEntry localFontFileResourceEntry = findBestEntry(paramFontFamilyFilesResourceEntry, paramInt);
    if (localFontFileResourceEntry == null)
      return null;
    return TypefaceCompat.createFromResourcesFontFile(paramContext, paramResources, localFontFileResourceEntry.getResourceId(), localFontFileResourceEntry.getFileName(), paramInt);
  }

  // ERROR //
  public Typeface createFromFontInfo(Context paramContext, android.os.CancellationSignal paramCancellationSignal, FontsContractCompat.FontInfo[] paramArrayOfFontInfo, int paramInt)
  {
    // Byte code:
    //   0: aload_3
    //   1: arraylength
    //   2: iconst_1
    //   3: if_icmpge +5 -> 8
    //   6: aconst_null
    //   7: areturn
    //   8: aload_0
    //   9: aload_3
    //   10: iload 4
    //   12: invokevirtual 77	android/support/v4/graphics/TypefaceCompatBaseImpl:findBestInfo	([Landroid/support/v4/provider/FontsContractCompat$FontInfo;I)Landroid/support/v4/provider/FontsContractCompat$FontInfo;
    //   15: astore 5
    //   17: aload_1
    //   18: invokevirtual 83	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   21: aload 5
    //   23: invokevirtual 89	android/support/v4/provider/FontsContractCompat$FontInfo:getUri	()Landroid/net/Uri;
    //   26: invokevirtual 95	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   29: astore 10
    //   31: aload 10
    //   33: astore 7
    //   35: aload_0
    //   36: aload_1
    //   37: aload 7
    //   39: invokevirtual 99	android/support/v4/graphics/TypefaceCompatBaseImpl:createFromInputStream	(Landroid/content/Context;Ljava/io/InputStream;)Landroid/graphics/Typeface;
    //   42: astore 12
    //   44: aload 7
    //   46: invokestatic 105	android/support/v4/graphics/TypefaceCompatUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   49: aload 12
    //   51: areturn
    //   52: astore 9
    //   54: aconst_null
    //   55: astore 7
    //   57: aload 7
    //   59: invokestatic 105	android/support/v4/graphics/TypefaceCompatUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   62: aconst_null
    //   63: areturn
    //   64: astore 6
    //   66: aconst_null
    //   67: astore 7
    //   69: aload 6
    //   71: astore 8
    //   73: aload 7
    //   75: invokestatic 105	android/support/v4/graphics/TypefaceCompatUtil:closeQuietly	(Ljava/io/Closeable;)V
    //   78: aload 8
    //   80: athrow
    //   81: astore 8
    //   83: goto -10 -> 73
    //   86: astore 11
    //   88: goto -31 -> 57
    //
    // Exception table:
    //   from	to	target	type
    //   17	31	52	java/io/IOException
    //   17	31	64	finally
    //   35	44	81	finally
    //   35	44	86	java/io/IOException
  }

  protected Typeface createFromInputStream(Context paramContext, InputStream paramInputStream)
  {
    File localFile = TypefaceCompatUtil.getTempFile(paramContext);
    if (localFile == null)
      return null;
    try
    {
      boolean bool = TypefaceCompatUtil.copyToFile(localFile, paramInputStream);
      if (!bool)
        return null;
      Typeface localTypeface = Typeface.createFromFile(localFile.getPath());
      return localTypeface;
    }
    catch (RuntimeException localRuntimeException)
    {
      return null;
    }
    finally
    {
      localFile.delete();
    }
  }

  public Typeface createFromResourcesFontFile(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2)
  {
    File localFile = TypefaceCompatUtil.getTempFile(paramContext);
    if (localFile == null)
      return null;
    try
    {
      boolean bool = TypefaceCompatUtil.copyToFile(localFile, paramResources, paramInt1);
      if (!bool)
        return null;
      Typeface localTypeface = Typeface.createFromFile(localFile.getPath());
      return localTypeface;
    }
    catch (RuntimeException localRuntimeException)
    {
      return null;
    }
    finally
    {
      localFile.delete();
    }
  }

  protected FontsContractCompat.FontInfo findBestInfo(FontsContractCompat.FontInfo[] paramArrayOfFontInfo, int paramInt)
  {
    return (FontsContractCompat.FontInfo)findBestFont(paramArrayOfFontInfo, paramInt, new StyleExtractor()
    {
      public int getWeight(FontsContractCompat.FontInfo paramAnonymousFontInfo)
      {
        return paramAnonymousFontInfo.getWeight();
      }

      public boolean isItalic(FontsContractCompat.FontInfo paramAnonymousFontInfo)
      {
        return paramAnonymousFontInfo.isItalic();
      }
    });
  }

  private static abstract interface StyleExtractor<T>
  {
    public abstract int getWeight(T paramT);

    public abstract boolean isItalic(T paramT);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.graphics.TypefaceCompatBaseImpl
 * JD-Core Version:    0.6.2
 */