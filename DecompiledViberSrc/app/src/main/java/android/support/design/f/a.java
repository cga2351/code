package android.support.design.f;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.support.v4.graphics.ColorUtils;
import android.util.StateSet;

public class a
{
  public static final boolean a;
  private static final int[] b;
  private static final int[] c;
  private static final int[] d;
  private static final int[] e;
  private static final int[] f;
  private static final int[] g;
  private static final int[] h;
  private static final int[] i;
  private static final int[] j;

  static
  {
    if (Build.VERSION.SDK_INT >= 21);
    for (boolean bool = true; ; bool = false)
    {
      a = bool;
      b = new int[] { 16842919 };
      c = new int[] { 16843623, 16842908 };
      d = new int[] { 16842908 };
      e = new int[] { 16843623 };
      f = new int[] { 16842913, 16842919 };
      g = new int[] { 16842913, 16843623, 16842908 };
      h = new int[] { 16842913, 16842908 };
      i = new int[] { 16842913, 16843623 };
      j = new int[] { 16842913 };
      return;
    }
  }

  @TargetApi(21)
  private static int a(int paramInt)
  {
    return ColorUtils.setAlphaComponent(paramInt, Math.min(2 * Color.alpha(paramInt), 255));
  }

  private static int a(ColorStateList paramColorStateList, int[] paramArrayOfInt)
  {
    if (paramColorStateList != null);
    for (int k = paramColorStateList.getColorForState(paramArrayOfInt, paramColorStateList.getDefaultColor()); ; k = 0)
    {
      if (a)
        k = a(k);
      return k;
    }
  }

  public static ColorStateList a(ColorStateList paramColorStateList)
  {
    if (a)
    {
      int[][] arrayOfInt3 = new int[2][];
      int[] arrayOfInt4 = new int[2];
      arrayOfInt3[0] = j;
      arrayOfInt4[0] = a(paramColorStateList, f);
      arrayOfInt3[1] = StateSet.NOTHING;
      arrayOfInt4[1] = a(paramColorStateList, b);
      return new ColorStateList(arrayOfInt3, arrayOfInt4);
    }
    int[][] arrayOfInt1 = new int[10][];
    int[] arrayOfInt2 = new int[10];
    arrayOfInt1[0] = f;
    arrayOfInt2[0] = a(paramColorStateList, f);
    arrayOfInt1[1] = g;
    arrayOfInt2[1] = a(paramColorStateList, g);
    arrayOfInt1[2] = h;
    arrayOfInt2[2] = a(paramColorStateList, h);
    arrayOfInt1[3] = i;
    arrayOfInt2[3] = a(paramColorStateList, i);
    arrayOfInt1[4] = j;
    arrayOfInt2[4] = 0;
    arrayOfInt1[5] = b;
    arrayOfInt2[5] = a(paramColorStateList, b);
    arrayOfInt1[6] = c;
    arrayOfInt2[6] = a(paramColorStateList, c);
    arrayOfInt1[7] = d;
    arrayOfInt2[7] = a(paramColorStateList, d);
    arrayOfInt1[8] = e;
    arrayOfInt2[8] = a(paramColorStateList, e);
    arrayOfInt1[9] = StateSet.NOTHING;
    arrayOfInt2[9] = 0;
    return new ColorStateList(arrayOfInt1, arrayOfInt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.f.a
 * JD-Core Version:    0.6.2
 */