package com.viber.voip.util.e.b;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.RectF;
import com.viber.voip.R.dimen;
import com.viber.voip.util.e.b;
import com.viber.voip.util.e.j;

public class a
  implements b
{
  private final int a;
  private final int b;

  public a(Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    this.b = localResources.getDimensionPixelSize(R.dimen.public_group_info_background_icon_size);
    this.a = localResources.getDimensionPixelSize(R.dimen.public_group_info_background_icon_corner_radius);
  }

  public Bitmap a(Bitmap paramBitmap)
  {
    Bitmap localBitmap = j.a(j.a(paramBitmap), this.b, 4, false);
    Path localPath = new Path();
    localPath.addRoundRect(new RectF(0.0F, 0.0F, this.b, this.b), this.a, this.a, Path.Direction.CCW);
    return j.a(localPath, localBitmap);
  }

  public String a()
  {
    return "[BackgroundIconPostProcessor]";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.e.b.a
 * JD-Core Version:    0.6.2
 */