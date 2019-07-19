package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.R.attr;
import android.support.design.R.styleable;
import android.support.v7.widget.TintTypedArray;
import android.util.AttributeSet;

public final class j
{
  private static final int[] a;
  private static final int[] b = arrayOfInt2;

  static
  {
    int[] arrayOfInt1 = new int[1];
    arrayOfInt1[0] = R.attr.colorPrimary;
    a = arrayOfInt1;
    int[] arrayOfInt2 = new int[1];
    arrayOfInt2[0] = R.attr.colorSecondary;
  }

  public static TypedArray a(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt1, int paramInt1, int paramInt2, int[] paramArrayOfInt2)
  {
    a(paramContext, paramAttributeSet, paramInt1, paramInt2);
    c(paramContext, paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2, paramArrayOfInt2);
    return paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2);
  }

  public static void a(Context paramContext)
  {
    a(paramContext, a, "Theme.AppCompat");
  }

  private static void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ThemeEnforcement, paramInt1, paramInt2);
    boolean bool = localTypedArray.getBoolean(R.styleable.ThemeEnforcement_enforceMaterialTheme, false);
    localTypedArray.recycle();
    if (bool)
      b(paramContext);
    a(paramContext);
  }

  private static void a(Context paramContext, int[] paramArrayOfInt, String paramString)
  {
    if (!a(paramContext, paramArrayOfInt))
      throw new IllegalArgumentException("The style on this component requires your app theme to be " + paramString + " (or a descendant).");
  }

  private static boolean a(Context paramContext, int[] paramArrayOfInt)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramArrayOfInt);
    boolean bool = localTypedArray.hasValue(0);
    localTypedArray.recycle();
    return bool;
  }

  public static TintTypedArray b(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt1, int paramInt1, int paramInt2, int[] paramArrayOfInt2)
  {
    a(paramContext, paramAttributeSet, paramInt1, paramInt2);
    c(paramContext, paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2, paramArrayOfInt2);
    return TintTypedArray.obtainStyledAttributes(paramContext, paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2);
  }

  public static void b(Context paramContext)
  {
    a(paramContext, b, "Theme.MaterialComponents");
  }

  private static void c(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt1, int paramInt1, int paramInt2, int[] paramArrayOfInt2)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ThemeEnforcement, paramInt1, paramInt2);
    if (!localTypedArray.getBoolean(R.styleable.ThemeEnforcement_enforceTextAppearance, false))
    {
      localTypedArray.recycle();
      return;
    }
    if ((paramArrayOfInt2 == null) || (paramArrayOfInt2.length == 0))
    {
      int i = localTypedArray.getResourceId(R.styleable.ThemeEnforcement_android_textAppearance, -1);
      bool = false;
      if (i == -1);
    }
    for (boolean bool = true; ; bool = d(paramContext, paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2, paramArrayOfInt2))
    {
      localTypedArray.recycle();
      if (bool)
        break;
      throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
    }
  }

  private static boolean d(Context paramContext, AttributeSet paramAttributeSet, int[] paramArrayOfInt1, int paramInt1, int paramInt2, int[] paramArrayOfInt2)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, paramArrayOfInt1, paramInt1, paramInt2);
    int i = paramArrayOfInt2.length;
    for (int j = 0; j < i; j++)
      if (localTypedArray.getResourceId(paramArrayOfInt2[j], -1) == -1)
      {
        localTypedArray.recycle();
        return false;
      }
    localTypedArray.recycle();
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.internal.j
 * JD-Core Version:    0.6.2
 */