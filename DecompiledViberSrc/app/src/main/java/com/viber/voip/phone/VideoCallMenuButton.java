package com.viber.voip.phone;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.Checkable;
import android.widget.ImageButton;
import com.viber.voip.R.styleable;

public class VideoCallMenuButton extends ImageButton
  implements Checkable
{
  private static final int[] STATE_CHECKED = { 16842912 };
  private boolean mIsChecked;

  public VideoCallMenuButton(Context paramContext)
  {
    this(paramContext, null);
  }

  public VideoCallMenuButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.VideoCall);
    int i = localTypedArray.getInt(R.styleable.VideoCall_rotation, 0);
    if (i != 0)
      setRotation(i);
    localTypedArray.recycle();
  }

  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    invalidate();
  }

  public boolean isChecked()
  {
    return this.mIsChecked;
  }

  public int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(paramInt + 1);
    if (this.mIsChecked)
      mergeDrawableStates(arrayOfInt, STATE_CHECKED);
    return arrayOfInt;
  }

  public void setChecked(boolean paramBoolean)
  {
    if (this.mIsChecked != paramBoolean)
    {
      this.mIsChecked = paramBoolean;
      refreshDrawableState();
    }
  }

  public void toggle()
  {
    if (!this.mIsChecked);
    for (boolean bool = true; ; bool = false)
    {
      setChecked(bool);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.VideoCallMenuButton
 * JD-Core Version:    0.6.2
 */