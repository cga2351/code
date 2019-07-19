package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.View;
import android.view.Window;

public final class WindowCompat
{
  public static final int FEATURE_ACTION_BAR = 8;
  public static final int FEATURE_ACTION_BAR_OVERLAY = 9;
  public static final int FEATURE_ACTION_MODE_OVERLAY = 10;

  public static <T extends View> T requireViewById(Window paramWindow, int paramInt)
  {
    View localView;
    if (Build.VERSION.SDK_INT >= 28)
      localView = paramWindow.requireViewById(paramInt);
    do
    {
      return localView;
      localView = paramWindow.findViewById(paramInt);
    }
    while (localView != null);
    throw new IllegalArgumentException("ID does not reference a View inside this Window");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.view.WindowCompat
 * JD-Core Version:    0.6.2
 */