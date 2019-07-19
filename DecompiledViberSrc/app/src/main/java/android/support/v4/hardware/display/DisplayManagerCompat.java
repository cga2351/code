package android.support.v4.hardware.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.WindowManager;
import java.util.WeakHashMap;

public final class DisplayManagerCompat
{
  public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";
  private static final WeakHashMap<Context, DisplayManagerCompat> sInstances = new WeakHashMap();
  private final Context mContext;

  private DisplayManagerCompat(Context paramContext)
  {
    this.mContext = paramContext;
  }

  public static DisplayManagerCompat getInstance(Context paramContext)
  {
    synchronized (sInstances)
    {
      DisplayManagerCompat localDisplayManagerCompat = (DisplayManagerCompat)sInstances.get(paramContext);
      if (localDisplayManagerCompat == null)
      {
        localDisplayManagerCompat = new DisplayManagerCompat(paramContext);
        sInstances.put(paramContext, localDisplayManagerCompat);
      }
      return localDisplayManagerCompat;
    }
  }

  public Display getDisplay(int paramInt)
  {
    Display localDisplay;
    if (Build.VERSION.SDK_INT >= 17)
      localDisplay = ((DisplayManager)this.mContext.getSystemService("display")).getDisplay(paramInt);
    do
    {
      return localDisplay;
      localDisplay = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay();
    }
    while (localDisplay.getDisplayId() == paramInt);
    return null;
  }

  public Display[] getDisplays()
  {
    if (Build.VERSION.SDK_INT >= 17)
      return ((DisplayManager)this.mContext.getSystemService("display")).getDisplays();
    return new Display[] { ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay() };
  }

  public Display[] getDisplays(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 17)
      return ((DisplayManager)this.mContext.getSystemService("display")).getDisplays(paramString);
    if (paramString == null)
      return new Display[0];
    return new Display[] { ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay() };
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.hardware.display.DisplayManagerCompat
 * JD-Core Version:    0.6.2
 */