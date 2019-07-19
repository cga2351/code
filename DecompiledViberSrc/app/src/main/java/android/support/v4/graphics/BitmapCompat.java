package android.support.v4.graphics;

import android.graphics.Bitmap;
import android.os.Build.VERSION;

public final class BitmapCompat
{
  public static int getAllocationByteCount(Bitmap paramBitmap)
  {
    if (Build.VERSION.SDK_INT >= 19)
      return paramBitmap.getAllocationByteCount();
    return paramBitmap.getByteCount();
  }

  public static boolean hasMipMap(Bitmap paramBitmap)
  {
    if (Build.VERSION.SDK_INT >= 18)
      return paramBitmap.hasMipMap();
    return false;
  }

  public static void setHasMipMap(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 18)
      paramBitmap.setHasMipMap(paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.graphics.BitmapCompat
 * JD-Core Version:    0.6.2
 */