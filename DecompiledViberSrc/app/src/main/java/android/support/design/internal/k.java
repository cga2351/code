package android.support.design.internal;

import android.graphics.PorterDuff.Mode;
import android.support.v4.view.ViewCompat;
import android.view.View;

public class k
{
  public static PorterDuff.Mode a(int paramInt, PorterDuff.Mode paramMode)
  {
    switch (paramInt)
    {
    case 4:
    case 6:
    case 7:
    case 8:
    case 10:
    case 11:
    case 12:
    case 13:
    default:
      return paramMode;
    case 3:
      return PorterDuff.Mode.SRC_OVER;
    case 5:
      return PorterDuff.Mode.SRC_IN;
    case 9:
      return PorterDuff.Mode.SRC_ATOP;
    case 14:
      return PorterDuff.Mode.MULTIPLY;
    case 15:
      return PorterDuff.Mode.SCREEN;
    case 16:
    }
    return PorterDuff.Mode.ADD;
  }

  public static boolean a(View paramView)
  {
    return ViewCompat.getLayoutDirection(paramView) == 1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.internal.k
 * JD-Core Version:    0.6.2
 */