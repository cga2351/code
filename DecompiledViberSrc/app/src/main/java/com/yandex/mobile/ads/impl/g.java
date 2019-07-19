package com.yandex.mobile.ads.impl;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.view.View;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class g
{
  private static final Comparator<Map.Entry<Integer, Integer>> a = new Comparator()
  {
  };

  public static void a(View paramView1, View paramView2)
  {
    Bitmap localBitmap = dh.c(paramView2);
    Integer localInteger;
    if (localBitmap == null)
      localInteger = Integer.valueOf(0);
    while (true)
    {
      paramView1.setBackgroundColor(localInteger.intValue());
      return;
      ArrayList localArrayList1 = new ArrayList();
      int[] arrayOfInt1 = { 16, 16, 16 };
      int[][][] arrayOfInt = (int[][][])Array.newInstance(Integer.TYPE, arrayOfInt1);
      for (int i = 0; i < 16; i++)
        for (int i10 = 0; i10 < 16; i10++)
          for (int i11 = 0; i11 < 16; i11++)
            arrayOfInt[i11][i10][i] = 0;
      int j = localBitmap.getWidth();
      int k = localBitmap.getHeight();
      int m = j * k;
      int[] arrayOfInt2 = new int[m];
      localBitmap.getPixels(arrayOfInt2, 0, j, 0, 0, j, k);
      label308: for (int n = 0; ; n++)
      {
        if (n >= k)
          break label314;
        for (int i5 = 0; ; i5++)
        {
          if (i5 >= j)
            break label308;
          int i6 = arrayOfInt2[(i5 + n * j)];
          if (Color.alpha(i6) != 255)
          {
            localArrayList1.add(Integer.valueOf(i6));
            if (localArrayList1.size() >= 0.1F * m)
            {
              localInteger = Integer.valueOf(0);
              break;
            }
          }
          int i7 = Color.red(i6) / 16;
          int i8 = Color.green(i6) / 16;
          int i9 = Color.blue(i6) / 16;
          arrayOfInt[i7][i8][i9] = (1 + arrayOfInt[i7][i8][i9]);
        }
      }
      label314: HashMap localHashMap = new HashMap(4096);
      for (int i1 = 0; i1 < 16; i1++)
        for (int i2 = 0; i2 < 16; i2++)
          for (int i3 = 0; i3 < 16; i3++)
          {
            int i4 = arrayOfInt[i3][i2][i1];
            if (i4 > 0)
              localHashMap.put(Integer.valueOf(Color.rgb(i3 * 16, i2 * 16, i1 * 16)), Integer.valueOf(i4));
          }
      ArrayList localArrayList2 = new ArrayList();
      localArrayList2.addAll(localHashMap.entrySet());
      localInteger = (Integer)((Map.Entry)Collections.max(localArrayList2, a)).getKey();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.g
 * JD-Core Version:    0.6.2
 */