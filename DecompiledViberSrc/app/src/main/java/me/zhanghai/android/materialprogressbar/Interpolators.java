package me.zhanghai.android.materialprogressbar;

import android.graphics.Path;
import android.support.v4.view.animation.PathInterpolatorCompat;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;

class Interpolators
{
  public static class INDETERMINATE_HORIZONTAL_RECT1_SCALE_X
  {
    public static final Interpolator INSTANCE = PathInterpolatorCompat.create(PATH_INDETERMINATE_HORIZONTAL_RECT1_SCALE_X);
    private static final Path PATH_INDETERMINATE_HORIZONTAL_RECT1_SCALE_X = new Path();

    static
    {
      PATH_INDETERMINATE_HORIZONTAL_RECT1_SCALE_X.moveTo(0.0F, 0.0F);
      PATH_INDETERMINATE_HORIZONTAL_RECT1_SCALE_X.lineTo(0.3665F, 0.0F);
      PATH_INDETERMINATE_HORIZONTAL_RECT1_SCALE_X.cubicTo(0.4725262F, 0.06240991F, 0.6154161F, 0.5F, 0.68325F, 0.5F);
      PATH_INDETERMINATE_HORIZONTAL_RECT1_SCALE_X.cubicTo(0.7547506F, 0.5F, 0.757258F, 0.8145101F, 1.0F, 1.0F);
    }
  }

  public static class INDETERMINATE_HORIZONTAL_RECT1_TRANSLATE_X
  {
    public static final Interpolator INSTANCE = PathInterpolatorCompat.create(PATH_INDETERMINATE_HORIZONTAL_RECT1_TRANSLATE_X);
    private static final Path PATH_INDETERMINATE_HORIZONTAL_RECT1_TRANSLATE_X = new Path();

    static
    {
      PATH_INDETERMINATE_HORIZONTAL_RECT1_TRANSLATE_X.moveTo(0.0F, 0.0F);
      PATH_INDETERMINATE_HORIZONTAL_RECT1_TRANSLATE_X.lineTo(0.2F, 0.0F);
      PATH_INDETERMINATE_HORIZONTAL_RECT1_TRANSLATE_X.cubicTo(0.3958333F, 0.0F, 0.4748451F, 0.2067976F, 0.5916666F, 0.4170829F);
      PATH_INDETERMINATE_HORIZONTAL_RECT1_TRANSLATE_X.cubicTo(0.715161F, 0.6393796F, 0.81625F, 0.9745569F, 1.0F, 1.0F);
    }
  }

  public static class INDETERMINATE_HORIZONTAL_RECT2_SCALE_X
  {
    public static final Interpolator INSTANCE = PathInterpolatorCompat.create(PATH_INDETERMINATE_HORIZONTAL_RECT2_SCALE_X);
    private static final Path PATH_INDETERMINATE_HORIZONTAL_RECT2_SCALE_X = new Path();

    static
    {
      PATH_INDETERMINATE_HORIZONTAL_RECT2_SCALE_X.moveTo(0.0F, 0.0F);
      PATH_INDETERMINATE_HORIZONTAL_RECT2_SCALE_X.cubicTo(0.06834272F, 0.01992567F, 0.1922033F, 0.1585543F, 0.3333333F, 0.3492616F);
      PATH_INDETERMINATE_HORIZONTAL_RECT2_SCALE_X.cubicTo(0.3841043F, 0.4147791F, 0.5494579F, 0.68136F, 0.6666667F, 0.6827996F);
      PATH_INDETERMINATE_HORIZONTAL_RECT2_SCALE_X.cubicTo(0.7525863F, 0.6817962F, 0.737254F, 0.8788962F, 1.0F, 1.0F);
    }
  }

  public static class INDETERMINATE_HORIZONTAL_RECT2_TRANSLATE_X
  {
    public static final Interpolator INSTANCE = PathInterpolatorCompat.create(PATH_INDETERMINATE_HORIZONTAL_RECT2_TRANSLATE_X);
    private static final Path PATH_INDETERMINATE_HORIZONTAL_RECT2_TRANSLATE_X = new Path();

    static
    {
      PATH_INDETERMINATE_HORIZONTAL_RECT2_TRANSLATE_X.moveTo(0.0F, 0.0F);
      PATH_INDETERMINATE_HORIZONTAL_RECT2_TRANSLATE_X.cubicTo(0.0375F, 0.0F, 0.1287646F, 0.0895381F, 0.25F, 0.2185535F);
      PATH_INDETERMINATE_HORIZONTAL_RECT2_TRANSLATE_X.cubicTo(0.3224103F, 0.2956106F, 0.4366667F, 0.4175914F, 0.4833333F, 0.4898262F);
      PATH_INDETERMINATE_HORIZONTAL_RECT2_TRANSLATE_X.cubicTo(0.69F, 0.809723F, 0.7933334F, 0.9500161F, 1.0F, 1.0F);
    }
  }

  public static class LINEAR
  {
    public static final Interpolator INSTANCE = new LinearInterpolator();
  }

  public static class TRIM_PATH_END
  {
    public static final Interpolator INSTANCE = PathInterpolatorCompat.create(PATH_TRIM_PATH_END);
    private static final Path PATH_TRIM_PATH_END = new Path();

    static
    {
      PATH_TRIM_PATH_END.cubicTo(0.2F, 0.0F, 0.1F, 1.0F, 0.5F, 1.0F);
      PATH_TRIM_PATH_END.lineTo(1.0F, 1.0F);
    }
  }

  public static class TRIM_PATH_START
  {
    public static final Interpolator INSTANCE = PathInterpolatorCompat.create(PATH_TRIM_PATH_START);
    private static final Path PATH_TRIM_PATH_START = new Path();

    static
    {
      PATH_TRIM_PATH_START.lineTo(0.5F, 0.0F);
      PATH_TRIM_PATH_START.cubicTo(0.7F, 0.0F, 0.6F, 1.0F, 1.0F, 1.0F);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     me.zhanghai.android.materialprogressbar.Interpolators
 * JD-Core Version:    0.6.2
 */