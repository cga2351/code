package com.viber.voip.widget;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.Layout;
import android.text.TextPaint;
import android.view.View.BaseSavedState;
import com.viber.voip.ui.ViberTextView;

public class VerticalTextView extends ViberTextView
{
  private int a;
  private final Rect b;

  private void a(Canvas paramCanvas)
  {
    int i = getWidth();
    int j = getHeight();
    Drawable[] arrayOfDrawable = getCompoundDrawables();
    if (arrayOfDrawable != null)
    {
      if (arrayOfDrawable[0] != null)
      {
        arrayOfDrawable[0].copyBounds(this.b);
        paramCanvas.save();
        paramCanvas.translate(getPaddingLeft(), (i - this.b.height()) / 2);
        arrayOfDrawable[0].draw(paramCanvas);
        paramCanvas.restore();
      }
      if (arrayOfDrawable[1] != null)
      {
        arrayOfDrawable[1].copyBounds(this.b);
        paramCanvas.save();
        paramCanvas.translate((j - this.b.width()) / 2, getPaddingTop());
        arrayOfDrawable[1].draw(paramCanvas);
        paramCanvas.restore();
      }
      if (arrayOfDrawable[2] != null)
      {
        arrayOfDrawable[2].copyBounds(this.b);
        paramCanvas.save();
        paramCanvas.translate(j - this.b.width() - getPaddingRight(), (i - this.b.height()) / 2);
        arrayOfDrawable[2].draw(paramCanvas);
        paramCanvas.restore();
      }
      if (arrayOfDrawable[3] != null)
      {
        arrayOfDrawable[3].copyBounds(this.b);
        paramCanvas.save();
        paramCanvas.translate((j - this.b.width()) / 2, i - this.b.height() - getPaddingBottom());
        arrayOfDrawable[3].draw(paramCanvas);
        paramCanvas.restore();
      }
    }
  }

  public int getTextOrientation()
  {
    return this.a;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    TextPaint localTextPaint = getPaint();
    localTextPaint.setColor(getCurrentTextColor());
    localTextPaint.drawableState = getDrawableState();
    int i = paramCanvas.save();
    int j = getHeight();
    int k = getWidth();
    int m;
    if (this.a == 0)
    {
      paramCanvas.translate(0.0F, j);
      paramCanvas.rotate(-90.0F);
      a(paramCanvas);
      switch (0x70 & getGravity())
      {
      default:
        m = (k - getLineCount() * getLineHeight()) / 2;
      case 48:
      case 80:
      }
    }
    while (true)
    {
      paramCanvas.translate(getCompoundPaddingLeft(), m);
      getLayout().draw(paramCanvas);
      paramCanvas.restoreToCount(i);
      return;
      paramCanvas.translate(k, 0.0F);
      paramCanvas.rotate(90.0F);
      break;
      m = getCompoundPaddingTop();
      continue;
      m = k - getLineCount() * getLineHeight() - getCompoundPaddingBottom();
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt2, paramInt1);
    setMeasuredDimension(getMeasuredHeight(), getMeasuredWidth());
  }

  public void onRestoreInstanceState(Parcelable paramParcelable)
  {
    if (!(paramParcelable instanceof SavedState))
    {
      super.onRestoreInstanceState(paramParcelable);
      return;
    }
    SavedState localSavedState = (SavedState)paramParcelable;
    super.onRestoreInstanceState(localSavedState.getSuperState());
    this.a = localSavedState.textOrientation;
  }

  public Parcelable onSaveInstanceState()
  {
    SavedState localSavedState = new SavedState(super.onSaveInstanceState());
    localSavedState.textOrientation = this.a;
    return localSavedState;
  }

  public void setTextOrientation(int paramInt)
  {
    if (this.a != paramInt)
    {
      this.a = paramInt;
      invalidate();
    }
  }

  static final class SavedState extends View.BaseSavedState
  {
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public VerticalTextView.SavedState a(Parcel paramAnonymousParcel)
      {
        return new VerticalTextView.SavedState(paramAnonymousParcel);
      }

      public VerticalTextView.SavedState[] a(int paramAnonymousInt)
      {
        return new VerticalTextView.SavedState[paramAnonymousInt];
      }
    };
    int textOrientation;

    SavedState(Parcel paramParcel)
    {
      super();
      this.textOrientation = paramParcel.readInt();
    }

    public SavedState(Parcelable paramParcelable)
    {
      super();
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeInt(this.textOrientation);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.VerticalTextView
 * JD-Core Version:    0.6.2
 */