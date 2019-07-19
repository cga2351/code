package com.viber.voip.util.e;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.Allocation.MipmapControl;
import android.support.v8.renderscript.Element;
import android.support.v8.renderscript.RenderScript;
import android.support.v8.renderscript.ScriptIntrinsicBlur;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public class c
{
  private static final Logger a = ViberEnv.getLogger();
  private static volatile c b;
  private final RenderScript c;

  private c(Context paramContext)
  {
    this.c = RenderScript.create(paramContext);
  }

  public static c a(Context paramContext)
  {
    if (b == null);
    try
    {
      if (b == null)
        b = new c(paramContext);
      return b;
    }
    finally
    {
    }
  }

  private Bitmap b(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    Bitmap.Config localConfig;
    Bitmap localBitmap;
    if ((!paramBitmap.isMutable()) || (paramBitmap.getConfig() == null))
    {
      localConfig = paramBitmap.getConfig();
      if (localConfig != null)
        localBitmap = Bitmap.createBitmap(paramBitmap.getWidth(), paramBitmap.getHeight(), localConfig);
    }
    while (true)
    {
      Allocation localAllocation1 = Allocation.createFromBitmap(this.c, paramBitmap, Allocation.MipmapControl.MIPMAP_NONE, 1);
      Allocation localAllocation2 = Allocation.createTyped(this.c, localAllocation1.getType());
      ScriptIntrinsicBlur localScriptIntrinsicBlur = ScriptIntrinsicBlur.create(this.c, Element.U8_4(this.c));
      localScriptIntrinsicBlur.setRadius(paramInt);
      localScriptIntrinsicBlur.setInput(localAllocation1);
      localScriptIntrinsicBlur.forEach(localAllocation2);
      localAllocation2.copyTo(localBitmap);
      localAllocation1.destroy();
      localAllocation2.destroy();
      if (paramBoolean)
        paramBitmap.recycle();
      return localBitmap;
      localConfig = Bitmap.Config.ARGB_8888;
      break;
      localBitmap = paramBitmap;
      paramBoolean = false;
    }
  }

  public Bitmap a(Bitmap paramBitmap, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Bitmap localBitmap1 = a(paramBitmap, paramInt1, paramBoolean);
    if ((localBitmap1.getWidth() != paramInt2) && (paramInt3 != localBitmap1.getHeight()))
    {
      Bitmap localBitmap2 = Bitmap.createScaledBitmap(localBitmap1, paramInt2, paramInt3, true);
      if ((paramBoolean) || (localBitmap1 != paramBitmap))
        localBitmap1.recycle();
      return localBitmap2;
    }
    return localBitmap1;
  }

  public Bitmap a(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    return a(paramBitmap, paramInt, paramBoolean, false);
  }

  public Bitmap a(Bitmap paramBitmap, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 2;
    int j = 8;
    int k = paramBitmap.getWidth();
    int m = paramBitmap.getHeight();
    int n;
    float f;
    if (k > m)
    {
      n = k;
      f = 1.0F;
      if (n <= 80)
        break label180;
      f = 80.0F / n;
      paramInt = Math.round(f * paramInt);
      if (paramInt <= j)
        break label174;
      f *= 3.2F / i;
      i = j;
      label78: if (i <= j)
        break label186;
      f = 0;
    }
    while (true)
    {
      int i1 = Math.round(f * k);
      int i2 = Math.round(f * m);
      if ((!paramBoolean2) && ((i1 < paramBitmap.getWidth()) || (i2 < paramBitmap.getHeight())))
      {
        Bitmap localBitmap = Bitmap.createScaledBitmap(paramBitmap, i1, i2, true);
        if (paramBoolean1)
          paramBitmap.recycle();
        paramBitmap = localBitmap;
        paramBoolean1 = true;
      }
      return b(paramBitmap, j, paramBoolean1);
      n = m;
      break;
      label174: if (paramInt < i)
        break label78;
      label180: i = paramInt;
      break label78;
      label186: j = i;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.e.c
 * JD-Core Version:    0.6.2
 */