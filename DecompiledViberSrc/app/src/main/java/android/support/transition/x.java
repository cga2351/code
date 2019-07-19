package android.support.transition;

import android.os.Build.VERSION;
import android.view.ViewGroup;

class x
{
  static w a(ViewGroup paramViewGroup)
  {
    if (Build.VERSION.SDK_INT >= 18)
      return new v(paramViewGroup);
    return u.a(paramViewGroup);
  }

  static void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 18)
    {
      z.a(paramViewGroup, paramBoolean);
      return;
    }
    y.a(paramViewGroup, paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.transition.x
 * JD-Core Version:    0.6.2
 */