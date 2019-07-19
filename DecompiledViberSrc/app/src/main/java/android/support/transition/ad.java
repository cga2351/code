package android.support.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.util.Property;
import android.view.View;
import java.lang.reflect.Field;

class ad
{
  static final Property<View, Float> a;
  static final Property<View, Rect> b;
  private static final ah c;
  private static Field d;
  private static boolean e;

  static
  {
    if (Build.VERSION.SDK_INT >= 22)
      c = new ag();
    while (true)
    {
      a = new Property(Float.class, "translationAlpha")
      {
        public Float a(View paramAnonymousView)
        {
          return Float.valueOf(ad.c(paramAnonymousView));
        }

        public void a(View paramAnonymousView, Float paramAnonymousFloat)
        {
          ad.a(paramAnonymousView, paramAnonymousFloat.floatValue());
        }
      };
      b = new Property(Rect.class, "clipBounds")
      {
        public Rect a(View paramAnonymousView)
        {
          return ViewCompat.getClipBounds(paramAnonymousView);
        }

        public void a(View paramAnonymousView, Rect paramAnonymousRect)
        {
          ViewCompat.setClipBounds(paramAnonymousView, paramAnonymousRect);
        }
      };
      return;
      if (Build.VERSION.SDK_INT >= 21)
        c = new af();
      else if (Build.VERSION.SDK_INT >= 19)
        c = new ae();
      else
        c = new ah();
    }
  }

  static ac a(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 18)
      return new ab(paramView);
    return aa.d(paramView);
  }

  private static void a()
  {
    if (!e);
    try
    {
      d = View.class.getDeclaredField("mViewFlags");
      d.setAccessible(true);
      e = true;
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      while (true)
        Log.i("ViewUtils", "fetchViewFlagsField: ");
    }
  }

  static void a(View paramView, float paramFloat)
  {
    c.a(paramView, paramFloat);
  }

  static void a(View paramView, int paramInt)
  {
    a();
    if (d != null);
    try
    {
      int i = d.getInt(paramView);
      d.setInt(paramView, paramInt | i & 0xFFFFFFF3);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
    }
  }

  static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    c.a(paramView, paramInt1, paramInt2, paramInt3, paramInt4);
  }

  static void a(View paramView, Matrix paramMatrix)
  {
    c.a(paramView, paramMatrix);
  }

  static al b(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 18)
      return new ak(paramView);
    return new aj(paramView.getWindowToken());
  }

  static void b(View paramView, Matrix paramMatrix)
  {
    c.b(paramView, paramMatrix);
  }

  static float c(View paramView)
  {
    return c.a(paramView);
  }

  static void d(View paramView)
  {
    c.b(paramView);
  }

  static void e(View paramView)
  {
    c.c(paramView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.transition.ad
 * JD-Core Version:    0.6.2
 */