package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class u
{
  public static final class a
  {
    public static final int a = Color.parseColor("#fffeec95");
    static final int b = Color.parseColor("#fff5cf60");
    static final int c = Color.parseColor("#ffd8d8d8");
  }

  static final class b
  {
    static final ColorDrawable a = new ColorDrawable(Color.parseColor("#80ffffff"));
    static final LayerDrawable b = localLayerDrawable;

    static
    {
      int[] arrayOfInt1 = { 0, 0 };
      GradientDrawable localGradientDrawable1 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, arrayOfInt1);
      localGradientDrawable1.setCornerRadius(0.0F);
      int[] arrayOfInt2 = new int[2];
      arrayOfInt2[0] = u.a.b;
      arrayOfInt2[1] = u.a.b;
      GradientDrawable localGradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.LEFT_RIGHT, arrayOfInt2);
      localGradientDrawable2.setCornerRadius(0.0F);
      LayerDrawable localLayerDrawable = new LayerDrawable(new Drawable[] { localGradientDrawable1, new ClipDrawable(localGradientDrawable2, 3, 1) });
      localLayerDrawable.setId(0, 16908288);
      localLayerDrawable.setId(1, 16908301);
    }

    static StateListDrawable a()
    {
      ColorDrawable localColorDrawable1 = new ColorDrawable(u.a.a);
      ColorDrawable localColorDrawable2 = new ColorDrawable(0);
      int[] arrayOfInt1 = { 16842919 };
      int[] arrayOfInt2 = new int[0];
      StateListDrawable localStateListDrawable = new StateListDrawable();
      localStateListDrawable.addState(arrayOfInt1, localColorDrawable1);
      localStateListDrawable.addState(arrayOfInt2, localColorDrawable2);
      return localStateListDrawable;
    }
  }

  static final class c
  {
    static LinearLayout.LayoutParams a()
    {
      return new LinearLayout.LayoutParams(-2, -1);
    }
  }

  static final class d
  {
    static ImageView a(Context paramContext, String paramString, int paramInt)
    {
      ImageView localImageView = new ImageView(paramContext);
      localImageView.setImageBitmap(cw.a(paramString));
      localImageView.setAdjustViewBounds(true);
      localImageView.setPadding(paramInt, paramInt, paramInt, paramInt);
      localImageView.setBackgroundDrawable(u.b.a());
      return localImageView;
    }
  }

  private static enum e
  {
    private static final Map<String, Object> d;

    static
    {
      e[] arrayOfe = new e[3];
      arrayOfe[0] = a;
      arrayOfe[1] = b;
      arrayOfe[2] = c;
      e = arrayOfe;
      HashMap localHashMap = new HashMap();
      d = localHashMap;
      localHashMap.put(a.a("values_dimen_%s"), Integer.valueOf(48));
      d.put(a.a("values_dimen_%s_sw600dp"), Integer.valueOf(56));
      d.put(b.a("values_dimen_%s"), Integer.valueOf(15));
      d.put(b.a("values_dimen_%s_sw600dp"), Integer.valueOf(17));
      d.put(c.a("values_dimen_%s"), Integer.valueOf(19));
      d.put(c.a("values_dimen_%s_sw600dp"), Integer.valueOf(23));
    }

    private String a(String paramString)
    {
      return a(paramString, name());
    }

    private static String a(String paramString1, String paramString2)
    {
      return String.format(Locale.US, paramString1, new Object[] { paramString2 });
    }

    final int a(Context paramContext)
    {
      try
      {
        StringBuilder localStringBuilder = new StringBuilder(name());
        if (dh.g(paramContext) >= 600)
          localStringBuilder.append("_sw600dp");
        String str2 = a("values_dimen_%s", localStringBuilder.toString());
        Integer localInteger2 = (Integer)d.get(str2);
        if (localInteger2 != null)
        {
          int j = localInteger2.intValue();
          return j;
        }
      }
      catch (Exception localException1)
      {
        try
        {
          String str1 = a("values_dimen_%s", name());
          Integer localInteger1 = (Integer)d.get(str1);
          if (localInteger1 != null)
          {
            int i = localInteger1.intValue();
            return i;
          }
        }
        catch (Exception localException2)
        {
        }
      }
      return 0;
    }

    final int b(Context paramContext)
    {
      return dh.a(paramContext, a(paramContext));
    }

    public final String toString()
    {
      return name();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.u
 * JD-Core Version:    0.6.2
 */