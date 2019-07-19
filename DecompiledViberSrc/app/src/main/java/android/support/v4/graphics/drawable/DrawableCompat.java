package android.support.v4.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.InsetDrawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class DrawableCompat
{
  private static final String TAG = "DrawableCompat";
  private static Method sGetLayoutDirectionMethod;
  private static boolean sGetLayoutDirectionMethodFetched;
  private static Method sSetLayoutDirectionMethod;
  private static boolean sSetLayoutDirectionMethodFetched;

  public static void applyTheme(Drawable paramDrawable, Resources.Theme paramTheme)
  {
    if (Build.VERSION.SDK_INT >= 21)
      paramDrawable.applyTheme(paramTheme);
  }

  public static boolean canApplyTheme(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return paramDrawable.canApplyTheme();
    return false;
  }

  public static void clearColorFilter(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 23)
      paramDrawable.clearColorFilter();
    while (true)
    {
      return;
      if (Build.VERSION.SDK_INT < 21)
        break;
      paramDrawable.clearColorFilter();
      if ((paramDrawable instanceof InsetDrawable))
      {
        clearColorFilter(((InsetDrawable)paramDrawable).getDrawable());
        return;
      }
      if ((paramDrawable instanceof WrappedDrawable))
      {
        clearColorFilter(((WrappedDrawable)paramDrawable).getWrappedDrawable());
        return;
      }
      if ((paramDrawable instanceof DrawableContainer))
      {
        DrawableContainer.DrawableContainerState localDrawableContainerState = (DrawableContainer.DrawableContainerState)((DrawableContainer)paramDrawable).getConstantState();
        if (localDrawableContainerState != null)
        {
          int i = 0;
          int j = localDrawableContainerState.getChildCount();
          while (i < j)
          {
            Drawable localDrawable = localDrawableContainerState.getChild(i);
            if (localDrawable != null)
              clearColorFilter(localDrawable);
            i++;
          }
        }
      }
    }
    paramDrawable.clearColorFilter();
  }

  public static int getAlpha(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 19)
      return paramDrawable.getAlpha();
    return 0;
  }

  public static ColorFilter getColorFilter(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return paramDrawable.getColorFilter();
    return null;
  }

  public static int getLayoutDirection(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 23)
      return paramDrawable.getLayoutDirection();
    if (Build.VERSION.SDK_INT >= 17)
    {
      if (!sGetLayoutDirectionMethodFetched);
      try
      {
        sGetLayoutDirectionMethod = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
        sGetLayoutDirectionMethod.setAccessible(true);
        sGetLayoutDirectionMethodFetched = true;
        if (sGetLayoutDirectionMethod == null);
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        try
        {
          int i = ((Integer)sGetLayoutDirectionMethod.invoke(paramDrawable, new Object[0])).intValue();
          return i;
          localNoSuchMethodException = localNoSuchMethodException;
          Log.i("DrawableCompat", "Failed to retrieve getLayoutDirection() method", localNoSuchMethodException);
        }
        catch (Exception localException)
        {
          Log.i("DrawableCompat", "Failed to invoke getLayoutDirection() via reflection", localException);
          sGetLayoutDirectionMethod = null;
        }
      }
      return 0;
    }
    return 0;
  }

  public static void inflate(Drawable paramDrawable, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, Resources.Theme paramTheme)
    throws XmlPullParserException, IOException
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramDrawable.inflate(paramResources, paramXmlPullParser, paramAttributeSet, paramTheme);
      return;
    }
    paramDrawable.inflate(paramResources, paramXmlPullParser, paramAttributeSet);
  }

  public static boolean isAutoMirrored(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 19)
      return paramDrawable.isAutoMirrored();
    return false;
  }

  @Deprecated
  public static void jumpToCurrentState(Drawable paramDrawable)
  {
    paramDrawable.jumpToCurrentState();
  }

  public static void setAutoMirrored(Drawable paramDrawable, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 19)
      paramDrawable.setAutoMirrored(paramBoolean);
  }

  public static void setHotspot(Drawable paramDrawable, float paramFloat1, float paramFloat2)
  {
    if (Build.VERSION.SDK_INT >= 21)
      paramDrawable.setHotspot(paramFloat1, paramFloat2);
  }

  public static void setHotspotBounds(Drawable paramDrawable, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (Build.VERSION.SDK_INT >= 21)
      paramDrawable.setHotspotBounds(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public static boolean setLayoutDirection(Drawable paramDrawable, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23)
      return paramDrawable.setLayoutDirection(paramInt);
    if (Build.VERSION.SDK_INT >= 17)
    {
      if (!sSetLayoutDirectionMethodFetched);
      try
      {
        Class[] arrayOfClass = new Class[1];
        arrayOfClass[0] = Integer.TYPE;
        sSetLayoutDirectionMethod = Drawable.class.getDeclaredMethod("setLayoutDirection", arrayOfClass);
        sSetLayoutDirectionMethod.setAccessible(true);
        sSetLayoutDirectionMethodFetched = true;
        if (sSetLayoutDirectionMethod != null)
          try
          {
            Method localMethod = sSetLayoutDirectionMethod;
            Object[] arrayOfObject = new Object[1];
            arrayOfObject[0] = Integer.valueOf(paramInt);
            localMethod.invoke(paramDrawable, arrayOfObject);
            return true;
          }
          catch (Exception localException)
          {
            Log.i("DrawableCompat", "Failed to invoke setLayoutDirection(int) via reflection", localException);
            sSetLayoutDirectionMethod = null;
          }
        return false;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        while (true)
          Log.i("DrawableCompat", "Failed to retrieve setLayoutDirection(int) method", localNoSuchMethodException);
      }
    }
    return false;
  }

  public static void setTint(Drawable paramDrawable, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 21)
      paramDrawable.setTint(paramInt);
    while (!(paramDrawable instanceof TintAwareDrawable))
      return;
    ((TintAwareDrawable)paramDrawable).setTint(paramInt);
  }

  public static void setTintList(Drawable paramDrawable, ColorStateList paramColorStateList)
  {
    if (Build.VERSION.SDK_INT >= 21)
      paramDrawable.setTintList(paramColorStateList);
    while (!(paramDrawable instanceof TintAwareDrawable))
      return;
    ((TintAwareDrawable)paramDrawable).setTintList(paramColorStateList);
  }

  public static void setTintMode(Drawable paramDrawable, PorterDuff.Mode paramMode)
  {
    if (Build.VERSION.SDK_INT >= 21)
      paramDrawable.setTintMode(paramMode);
    while (!(paramDrawable instanceof TintAwareDrawable))
      return;
    ((TintAwareDrawable)paramDrawable).setTintMode(paramMode);
  }

  public static <T extends Drawable> T unwrap(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof WrappedDrawable))
      paramDrawable = ((WrappedDrawable)paramDrawable).getWrappedDrawable();
    return paramDrawable;
  }

  public static Drawable wrap(Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT >= 23);
    do
    {
      do
      {
        return paramDrawable;
        if (Build.VERSION.SDK_INT < 21)
          break;
      }
      while ((paramDrawable instanceof TintAwareDrawable));
      return new WrappedDrawableApi21(paramDrawable);
    }
    while ((paramDrawable instanceof TintAwareDrawable));
    return new WrappedDrawableApi14(paramDrawable);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.graphics.drawable.DrawableCompat
 * JD-Core Version:    0.6.2
 */