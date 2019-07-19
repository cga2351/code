package android.support.v4.graphics;

import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.util.Pair;

public final class PaintCompat
{
  private static final String EM_STRING = "m";
  private static final String TOFU_STRING = "󟿽";
  private static final ThreadLocal<Pair<Rect, Rect>> sRectThreadLocal = new ThreadLocal();

  public static boolean hasGlyph(Paint paramPaint, String paramString)
  {
    boolean bool2;
    if (Build.VERSION.SDK_INT >= 23)
      bool2 = paramPaint.hasGlyph(paramString);
    int i;
    float f1;
    float f3;
    boolean bool5;
    do
    {
      boolean bool4;
      do
      {
        float f2;
        boolean bool1;
        do
        {
          return bool2;
          i = paramString.length();
          if ((i == 1) && (Character.isWhitespace(paramString.charAt(0))))
            return true;
          f1 = paramPaint.measureText("󟿽");
          f2 = paramPaint.measureText("m");
          f3 = paramPaint.measureText(paramString);
          bool1 = f3 < 0.0F;
          bool2 = false;
        }
        while (!bool1);
        if (paramString.codePointCount(0, paramString.length()) <= 1)
          break;
        bool4 = f3 < f2 * 2.0F;
        bool2 = false;
      }
      while (bool4);
      float f4 = 0.0F;
      int j = 0;
      while (j < i)
      {
        int k = Character.charCount(paramString.codePointAt(j));
        f4 += paramPaint.measureText(paramString, j, j + k);
        j += k;
      }
      bool5 = f3 < f4;
      bool2 = false;
    }
    while (!bool5);
    if (f3 != f1)
      return true;
    Pair localPair = obtainEmptyRects();
    paramPaint.getTextBounds("󟿽", 0, "󟿽".length(), (Rect)localPair.first);
    paramPaint.getTextBounds(paramString, 0, i, (Rect)localPair.second);
    if (!((Rect)localPair.first).equals(localPair.second));
    for (boolean bool3 = true; ; bool3 = false)
      return bool3;
  }

  private static Pair<Rect, Rect> obtainEmptyRects()
  {
    Pair localPair1 = (Pair)sRectThreadLocal.get();
    if (localPair1 == null)
    {
      Pair localPair2 = new Pair(new Rect(), new Rect());
      sRectThreadLocal.set(localPair2);
      return localPair2;
    }
    ((Rect)localPair1.first).setEmpty();
    ((Rect)localPair1.second).setEmpty();
    return localPair1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.graphics.PaintCompat
 * JD-Core Version:    0.6.2
 */