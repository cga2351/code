package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

public final class CompoundButtonCompat
{
  private static final String TAG = "CompoundButtonCompat";
  private static Field sButtonDrawableField;
  private static boolean sButtonDrawableFieldFetched;

  public static Drawable getButtonDrawable(CompoundButton paramCompoundButton)
  {
    if (Build.VERSION.SDK_INT >= 23)
      return paramCompoundButton.getButtonDrawable();
    if (!sButtonDrawableFieldFetched);
    try
    {
      sButtonDrawableField = CompoundButton.class.getDeclaredField("mButtonDrawable");
      sButtonDrawableField.setAccessible(true);
      sButtonDrawableFieldFetched = true;
      if (sButtonDrawableField == null);
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      try
      {
        Drawable localDrawable = (Drawable)sButtonDrawableField.get(paramCompoundButton);
        return localDrawable;
        localNoSuchFieldException = localNoSuchFieldException;
        Log.i("CompoundButtonCompat", "Failed to retrieve mButtonDrawable field", localNoSuchFieldException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        Log.i("CompoundButtonCompat", "Failed to get button drawable via reflection", localIllegalAccessException);
        sButtonDrawableField = null;
      }
    }
    return null;
  }

  public static ColorStateList getButtonTintList(CompoundButton paramCompoundButton)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return paramCompoundButton.getButtonTintList();
    if ((paramCompoundButton instanceof TintableCompoundButton))
      return ((TintableCompoundButton)paramCompoundButton).getSupportButtonTintList();
    return null;
  }

  public static PorterDuff.Mode getButtonTintMode(CompoundButton paramCompoundButton)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return paramCompoundButton.getButtonTintMode();
    if ((paramCompoundButton instanceof TintableCompoundButton))
      return ((TintableCompoundButton)paramCompoundButton).getSupportButtonTintMode();
    return null;
  }

  public static void setButtonTintList(CompoundButton paramCompoundButton, ColorStateList paramColorStateList)
  {
    if (Build.VERSION.SDK_INT >= 21)
      paramCompoundButton.setButtonTintList(paramColorStateList);
    while (!(paramCompoundButton instanceof TintableCompoundButton))
      return;
    ((TintableCompoundButton)paramCompoundButton).setSupportButtonTintList(paramColorStateList);
  }

  public static void setButtonTintMode(CompoundButton paramCompoundButton, PorterDuff.Mode paramMode)
  {
    if (Build.VERSION.SDK_INT >= 21)
      paramCompoundButton.setButtonTintMode(paramMode);
    while (!(paramCompoundButton instanceof TintableCompoundButton))
      return;
    ((TintableCompoundButton)paramCompoundButton).setSupportButtonTintMode(paramMode);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.widget.CompoundButtonCompat
 * JD-Core Version:    0.6.2
 */