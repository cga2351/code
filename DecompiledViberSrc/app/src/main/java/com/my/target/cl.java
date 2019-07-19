package com.my.target;

import android.graphics.Paint;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class cl
{
  static List<String> a(String paramString, float paramFloat, Paint paramPaint)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    String[] arrayOfString = paramString.split("\\s");
    int i = arrayOfString.length;
    int j = 0;
    if (j < i)
    {
      String str = arrayOfString[j];
      if (paramPaint.measureText(str) < paramFloat)
        a(paramFloat, paramPaint, localArrayList1, localArrayList2, str);
      while (true)
      {
        j++;
        break;
        Iterator localIterator = b(str, paramFloat, paramPaint).iterator();
        while (localIterator.hasNext())
          a(paramFloat, paramPaint, localArrayList1, localArrayList2, (String)localIterator.next());
      }
    }
    if (!localArrayList2.isEmpty())
      localArrayList1.add(TextUtils.join(" ", localArrayList2));
    return localArrayList1;
  }

  private static void a(float paramFloat, Paint paramPaint, ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, String paramString)
  {
    paramArrayList2.add(paramString);
    if (paramPaint.measureText(TextUtils.join(" ", paramArrayList2)) >= paramFloat)
    {
      paramArrayList2.remove(-1 + paramArrayList2.size());
      paramArrayList1.add(TextUtils.join(" ", paramArrayList2));
      paramArrayList2.clear();
      paramArrayList2.add(paramString);
    }
  }

  private static List<String> b(String paramString, float paramFloat, Paint paramPaint)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramPaint.measureText(paramString) <= paramFloat))
      return Collections.singletonList(paramString);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    for (int j = 1; j <= paramString.length(); j++)
    {
      if (paramPaint.measureText(paramString.substring(i, j)) >= paramFloat)
      {
        localArrayList.add(paramString.substring(i, j - 1));
        i = j - 1;
      }
      if (j == paramString.length())
        localArrayList.add(paramString.substring(i, j));
    }
    return localArrayList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.cl
 * JD-Core Version:    0.6.2
 */