package android.support.v7.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class UnPressableLinearLayout extends LinearLayout
{
  public UnPressableLinearLayout(Context paramContext)
  {
    this(paramContext, null);
  }

  public UnPressableLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  protected void dispatchSetPressed(boolean paramBoolean)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.preference.UnPressableLinearLayout
 * JD-Core Version:    0.6.2
 */