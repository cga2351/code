package android.support.v4.widget;

import android.os.Build.VERSION;

public abstract interface AutoSizeableTextView
{
  public static final boolean PLATFORM_SUPPORTS_AUTOSIZE;

  static
  {
    if (Build.VERSION.SDK_INT >= 27);
    for (boolean bool = true; ; bool = false)
    {
      PLATFORM_SUPPORTS_AUTOSIZE = bool;
      return;
    }
  }

  public abstract int getAutoSizeMaxTextSize();

  public abstract int getAutoSizeMinTextSize();

  public abstract int getAutoSizeStepGranularity();

  public abstract int[] getAutoSizeTextAvailableSizes();

  public abstract int getAutoSizeTextType();

  public abstract void setAutoSizeTextTypeUniformWithConfiguration(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    throws IllegalArgumentException;

  public abstract void setAutoSizeTextTypeUniformWithPresetSizes(int[] paramArrayOfInt, int paramInt)
    throws IllegalArgumentException;

  public abstract void setAutoSizeTextTypeWithDefaults(int paramInt);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.widget.AutoSizeableTextView
 * JD-Core Version:    0.6.2
 */