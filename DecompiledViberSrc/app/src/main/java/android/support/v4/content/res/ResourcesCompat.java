package android.support.v4.content.res;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.content.res.Resources.Theme;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.graphics.TypefaceCompat;
import android.support.v4.util.Preconditions;
import android.util.Log;
import android.util.TypedValue;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParserException;

public final class ResourcesCompat
{
  private static final String TAG = "ResourcesCompat";

  public static int getColor(Resources paramResources, int paramInt, Resources.Theme paramTheme)
    throws Resources.NotFoundException
  {
    if (Build.VERSION.SDK_INT >= 23)
      return paramResources.getColor(paramInt, paramTheme);
    return paramResources.getColor(paramInt);
  }

  public static ColorStateList getColorStateList(Resources paramResources, int paramInt, Resources.Theme paramTheme)
    throws Resources.NotFoundException
  {
    if (Build.VERSION.SDK_INT >= 23)
      return paramResources.getColorStateList(paramInt, paramTheme);
    return paramResources.getColorStateList(paramInt);
  }

  public static Drawable getDrawable(Resources paramResources, int paramInt, Resources.Theme paramTheme)
    throws Resources.NotFoundException
  {
    if (Build.VERSION.SDK_INT >= 21)
      return paramResources.getDrawable(paramInt, paramTheme);
    return paramResources.getDrawable(paramInt);
  }

  public static Drawable getDrawableForDensity(Resources paramResources, int paramInt1, int paramInt2, Resources.Theme paramTheme)
    throws Resources.NotFoundException
  {
    if (Build.VERSION.SDK_INT >= 21)
      return paramResources.getDrawableForDensity(paramInt1, paramInt2, paramTheme);
    if (Build.VERSION.SDK_INT >= 15)
      return paramResources.getDrawableForDensity(paramInt1, paramInt2);
    return paramResources.getDrawable(paramInt1);
  }

  public static Typeface getFont(Context paramContext, int paramInt)
    throws Resources.NotFoundException
  {
    if (paramContext.isRestricted())
      return null;
    return loadFont(paramContext, paramInt, new TypedValue(), 0, null, null, false);
  }

  public static Typeface getFont(Context paramContext, int paramInt1, TypedValue paramTypedValue, int paramInt2, FontCallback paramFontCallback)
    throws Resources.NotFoundException
  {
    if (paramContext.isRestricted())
      return null;
    return loadFont(paramContext, paramInt1, paramTypedValue, paramInt2, paramFontCallback, null, true);
  }

  public static void getFont(Context paramContext, int paramInt, FontCallback paramFontCallback, Handler paramHandler)
    throws Resources.NotFoundException
  {
    Preconditions.checkNotNull(paramFontCallback);
    if (paramContext.isRestricted())
    {
      paramFontCallback.callbackFailAsync(-4, paramHandler);
      return;
    }
    loadFont(paramContext, paramInt, new TypedValue(), 0, paramFontCallback, paramHandler, false);
  }

  private static Typeface loadFont(Context paramContext, int paramInt1, TypedValue paramTypedValue, int paramInt2, FontCallback paramFontCallback, Handler paramHandler, boolean paramBoolean)
  {
    Resources localResources = paramContext.getResources();
    localResources.getValue(paramInt1, paramTypedValue, true);
    Typeface localTypeface = loadFont(paramContext, localResources, paramTypedValue, paramInt1, paramInt2, paramFontCallback, paramHandler, paramBoolean);
    if ((localTypeface == null) && (paramFontCallback == null))
      throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(paramInt1) + " could not be retrieved.");
    return localTypeface;
  }

  private static Typeface loadFont(Context paramContext, Resources paramResources, TypedValue paramTypedValue, int paramInt1, int paramInt2, FontCallback paramFontCallback, Handler paramHandler, boolean paramBoolean)
  {
    if (paramTypedValue.string == null)
      throw new Resources.NotFoundException("Resource \"" + paramResources.getResourceName(paramInt1) + "\" (" + Integer.toHexString(paramInt1) + ") is not a Font: " + paramTypedValue);
    String str = paramTypedValue.string.toString();
    Typeface localTypeface;
    if (!str.startsWith("res/"))
    {
      if (paramFontCallback != null)
        paramFontCallback.callbackFailAsync(-3, paramHandler);
      localTypeface = null;
    }
    while (true)
    {
      return localTypeface;
      localTypeface = TypefaceCompat.findFromCache(paramResources, paramInt1, paramInt2);
      if (localTypeface != null)
      {
        if (paramFontCallback != null)
        {
          paramFontCallback.callbackSuccessAsync(localTypeface, paramHandler);
          return localTypeface;
        }
      }
      else
        try
        {
          if (str.toLowerCase().endsWith(".xml"))
          {
            FontResourcesParserCompat.FamilyResourceEntry localFamilyResourceEntry = FontResourcesParserCompat.parse(paramResources.getXml(paramInt1), paramResources);
            if (localFamilyResourceEntry == null)
            {
              Log.e("ResourcesCompat", "Failed to find font-family tag");
              if (paramFontCallback != null)
                paramFontCallback.callbackFailAsync(-3, paramHandler);
            }
            else
            {
              return TypefaceCompat.createFromResourcesFamilyXml(paramContext, localFamilyResourceEntry, paramResources, paramInt1, paramInt2, paramFontCallback, paramHandler, paramBoolean);
            }
          }
          else
          {
            localTypeface = TypefaceCompat.createFromResourcesFontFile(paramContext, paramResources, paramInt1, str, paramInt2);
            if (paramFontCallback == null)
              continue;
            if (localTypeface != null)
            {
              paramFontCallback.callbackSuccessAsync(localTypeface, paramHandler);
              return localTypeface;
            }
          }
        }
        catch (XmlPullParserException localXmlPullParserException)
        {
          Log.e("ResourcesCompat", "Failed to parse xml resource " + str, localXmlPullParserException);
          if (paramFontCallback != null)
            paramFontCallback.callbackFailAsync(-3, paramHandler);
          return null;
          paramFontCallback.callbackFailAsync(-3, paramHandler);
          return localTypeface;
        }
        catch (IOException localIOException)
        {
          while (true)
            Log.e("ResourcesCompat", "Failed to read xml resource " + str, localIOException);
        }
    }
    return null;
  }

  public static abstract class FontCallback
  {
    public final void callbackFailAsync(final int paramInt, Handler paramHandler)
    {
      if (paramHandler == null)
        paramHandler = new Handler(Looper.getMainLooper());
      paramHandler.post(new Runnable()
      {
        public void run()
        {
          ResourcesCompat.FontCallback.this.onFontRetrievalFailed(paramInt);
        }
      });
    }

    public final void callbackSuccessAsync(final Typeface paramTypeface, Handler paramHandler)
    {
      if (paramHandler == null)
        paramHandler = new Handler(Looper.getMainLooper());
      paramHandler.post(new Runnable()
      {
        public void run()
        {
          ResourcesCompat.FontCallback.this.onFontRetrieved(paramTypeface);
        }
      });
    }

    public abstract void onFontRetrievalFailed(int paramInt);

    public abstract void onFontRetrieved(Typeface paramTypeface);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.content.res.ResourcesCompat
 * JD-Core Version:    0.6.2
 */