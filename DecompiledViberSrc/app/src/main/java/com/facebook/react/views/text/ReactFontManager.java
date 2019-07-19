package com.facebook.react.views.text;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.SparseArray;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

public class ReactFontManager
{
  private static final String[] EXTENSIONS = { "", "_bold", "_italic", "_bold_italic" };
  private static final String[] FILE_EXTENSIONS = { ".ttf", ".otf" };
  private static final String FONTS_ASSET_PATH = "fonts/";
  private static ReactFontManager sReactFontManagerInstance;
  private Map<String, FontFamily> mFontCache = new HashMap();

  @Nullable
  private static Typeface createTypeface(String paramString, int paramInt, AssetManager paramAssetManager)
  {
    String str1 = EXTENSIONS[paramInt];
    String[] arrayOfString = FILE_EXTENSIONS;
    int i = arrayOfString.length;
    int j = 0;
    while (j < i)
    {
      String str2 = arrayOfString[j];
      String str3 = "fonts/" + paramString + str1 + str2;
      try
      {
        Typeface localTypeface = Typeface.createFromAsset(paramAssetManager, str3);
        return localTypeface;
      }
      catch (RuntimeException localRuntimeException)
      {
        j++;
      }
    }
    return Typeface.create(paramString, paramInt);
  }

  public static ReactFontManager getInstance()
  {
    if (sReactFontManagerInstance == null)
      sReactFontManagerInstance = new ReactFontManager();
    return sReactFontManagerInstance;
  }

  @Nullable
  public Typeface getTypeface(String paramString, int paramInt, AssetManager paramAssetManager)
  {
    FontFamily localFontFamily = (FontFamily)this.mFontCache.get(paramString);
    if (localFontFamily == null)
    {
      localFontFamily = new FontFamily(null);
      this.mFontCache.put(paramString, localFontFamily);
    }
    Typeface localTypeface = localFontFamily.getTypeface(paramInt);
    if (localTypeface == null)
    {
      localTypeface = createTypeface(paramString, paramInt, paramAssetManager);
      if (localTypeface != null)
        localFontFamily.setTypeface(paramInt, localTypeface);
    }
    return localTypeface;
  }

  public void setTypeface(String paramString, int paramInt, Typeface paramTypeface)
  {
    if (paramTypeface != null)
    {
      FontFamily localFontFamily = (FontFamily)this.mFontCache.get(paramString);
      if (localFontFamily == null)
      {
        localFontFamily = new FontFamily(null);
        this.mFontCache.put(paramString, localFontFamily);
      }
      localFontFamily.setTypeface(paramInt, paramTypeface);
    }
  }

  private static class FontFamily
  {
    private SparseArray<Typeface> mTypefaceSparseArray = new SparseArray(4);

    public Typeface getTypeface(int paramInt)
    {
      return (Typeface)this.mTypefaceSparseArray.get(paramInt);
    }

    public void setTypeface(int paramInt, Typeface paramTypeface)
    {
      this.mTypefaceSparseArray.put(paramInt, paramTypeface);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.text.ReactFontManager
 * JD-Core Version:    0.6.2
 */