package com.facebook.react.views.text;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.widget.AppCompatTextView;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextUtils.TruncateAt;
import android.view.ViewGroup.LayoutParams;
import com.facebook.common.logging.FLog;
import com.facebook.react.uimanager.ReactCompoundView;
import com.facebook.react.views.view.ReactViewBackgroundManager;
import javax.annotation.Nullable;

public class ReactTextView extends AppCompatTextView
  implements ReactCompoundView
{
  private static final ViewGroup.LayoutParams EMPTY_LAYOUT_PARAMS = new ViewGroup.LayoutParams(0, 0);
  private boolean mContainsImages;
  private int mDefaultGravityHorizontal = 0x800007 & getGravity();
  private int mDefaultGravityVertical = 0x70 & getGravity();
  private TextUtils.TruncateAt mEllipsizeLocation = TextUtils.TruncateAt.END;
  private int mNumberOfLines = 2147483647;
  private ReactViewBackgroundManager mReactBackgroundManager = new ReactViewBackgroundManager(this);
  private Spannable mSpanned;
  private int mTextAlign = 0;

  public ReactTextView(Context paramContext)
  {
    super(paramContext);
  }

  public Spannable getSpanned()
  {
    return this.mSpanned;
  }

  public boolean hasOverlappingRendering()
  {
    return false;
  }

  public void invalidateDrawable(Drawable paramDrawable)
  {
    int i = 0;
    if ((this.mContainsImages) && ((getText() instanceof Spanned)))
    {
      Spanned localSpanned = (Spanned)getText();
      TextInlineImageSpan[] arrayOfTextInlineImageSpan = (TextInlineImageSpan[])localSpanned.getSpans(0, localSpanned.length(), TextInlineImageSpan.class);
      int j = arrayOfTextInlineImageSpan.length;
      while (i < j)
      {
        if (arrayOfTextInlineImageSpan[i].getDrawable() == paramDrawable)
          invalidate();
        i++;
      }
    }
    super.invalidateDrawable(paramDrawable);
  }

  public void onAttachedToWindow()
  {
    int i = 0;
    super.onAttachedToWindow();
    if ((this.mContainsImages) && ((getText() instanceof Spanned)))
    {
      Spanned localSpanned = (Spanned)getText();
      TextInlineImageSpan[] arrayOfTextInlineImageSpan = (TextInlineImageSpan[])localSpanned.getSpans(0, localSpanned.length(), TextInlineImageSpan.class);
      int j = arrayOfTextInlineImageSpan.length;
      while (i < j)
      {
        arrayOfTextInlineImageSpan[i].onAttachedToWindow();
        i++;
      }
    }
  }

  public void onDetachedFromWindow()
  {
    int i = 0;
    super.onDetachedFromWindow();
    if ((this.mContainsImages) && ((getText() instanceof Spanned)))
    {
      Spanned localSpanned = (Spanned)getText();
      TextInlineImageSpan[] arrayOfTextInlineImageSpan = (TextInlineImageSpan[])localSpanned.getSpans(0, localSpanned.length(), TextInlineImageSpan.class);
      int j = arrayOfTextInlineImageSpan.length;
      while (i < j)
      {
        arrayOfTextInlineImageSpan[i].onDetachedFromWindow();
        i++;
      }
    }
  }

  public void onFinishTemporaryDetach()
  {
    int i = 0;
    super.onFinishTemporaryDetach();
    if ((this.mContainsImages) && ((getText() instanceof Spanned)))
    {
      Spanned localSpanned = (Spanned)getText();
      TextInlineImageSpan[] arrayOfTextInlineImageSpan = (TextInlineImageSpan[])localSpanned.getSpans(0, localSpanned.length(), TextInlineImageSpan.class);
      int j = arrayOfTextInlineImageSpan.length;
      while (i < j)
      {
        arrayOfTextInlineImageSpan[i].onFinishTemporaryDetach();
        i++;
      }
    }
  }

  public void onStartTemporaryDetach()
  {
    int i = 0;
    super.onStartTemporaryDetach();
    if ((this.mContainsImages) && ((getText() instanceof Spanned)))
    {
      Spanned localSpanned = (Spanned)getText();
      TextInlineImageSpan[] arrayOfTextInlineImageSpan = (TextInlineImageSpan[])localSpanned.getSpans(0, localSpanned.length(), TextInlineImageSpan.class);
      int j = arrayOfTextInlineImageSpan.length;
      while (i < j)
      {
        arrayOfTextInlineImageSpan[i].onStartTemporaryDetach();
        i++;
      }
    }
  }

  public int reactTagForTouch(float paramFloat1, float paramFloat2)
  {
    CharSequence localCharSequence = getText();
    int i = getId();
    int j = (int)paramFloat1;
    int k = (int)paramFloat2;
    Layout localLayout = getLayout();
    if (localLayout == null);
    while (true)
    {
      return i;
      int m = localLayout.getLineForVertical(k);
      int n = (int)localLayout.getLineLeft(m);
      int i1 = (int)localLayout.getLineRight(m);
      if (((localCharSequence instanceof Spanned)) && (j >= n) && (j <= i1))
      {
        Spanned localSpanned = (Spanned)localCharSequence;
        float f = j;
        try
        {
          int i2 = localLayout.getOffsetForHorizontal(m, f);
          ReactTagSpan[] arrayOfReactTagSpan = (ReactTagSpan[])localSpanned.getSpans(i2, i2, ReactTagSpan.class);
          if (arrayOfReactTagSpan != null)
          {
            int i3 = localCharSequence.length();
            for (int i4 = 0; i4 < arrayOfReactTagSpan.length; i4++)
            {
              int i5 = localSpanned.getSpanStart(arrayOfReactTagSpan[i4]);
              int i6 = localSpanned.getSpanEnd(arrayOfReactTagSpan[i4]);
              if ((i6 > i2) && (i6 - i5 <= i3))
              {
                i = arrayOfReactTagSpan[i4].getReactTag();
                i3 = i6 - i5;
              }
            }
          }
        }
        catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
        {
          FLog.e("ReactNative", "Crash in HorizontalMeasurementProvider: " + localArrayIndexOutOfBoundsException.getMessage());
        }
      }
    }
    return i;
  }

  public void setBackgroundColor(int paramInt)
  {
    this.mReactBackgroundManager.setBackgroundColor(paramInt);
  }

  public void setBorderColor(int paramInt, float paramFloat1, float paramFloat2)
  {
    this.mReactBackgroundManager.setBorderColor(paramInt, paramFloat1, paramFloat2);
  }

  public void setBorderRadius(float paramFloat)
  {
    this.mReactBackgroundManager.setBorderRadius(paramFloat);
  }

  public void setBorderRadius(float paramFloat, int paramInt)
  {
    this.mReactBackgroundManager.setBorderRadius(paramFloat, paramInt);
  }

  public void setBorderStyle(@Nullable String paramString)
  {
    this.mReactBackgroundManager.setBorderStyle(paramString);
  }

  public void setBorderWidth(int paramInt, float paramFloat)
  {
    this.mReactBackgroundManager.setBorderWidth(paramInt, paramFloat);
  }

  public void setEllipsizeLocation(TextUtils.TruncateAt paramTruncateAt)
  {
    this.mEllipsizeLocation = paramTruncateAt;
  }

  void setGravityHorizontal(int paramInt)
  {
    if (paramInt == 0)
      paramInt = this.mDefaultGravityHorizontal;
    setGravity(paramInt | 0xFF7FFFF8 & (0xFFFFFFF8 & getGravity()));
  }

  void setGravityVertical(int paramInt)
  {
    if (paramInt == 0)
      paramInt = this.mDefaultGravityVertical;
    setGravity(paramInt | 0xFFFFFF8F & getGravity());
  }

  public void setNumberOfLines(int paramInt)
  {
    int i = 1;
    if (paramInt == 0)
      paramInt = 2147483647;
    this.mNumberOfLines = paramInt;
    if (this.mNumberOfLines == i);
    while (true)
    {
      setSingleLine(i);
      setMaxLines(this.mNumberOfLines);
      return;
      int j = 0;
    }
  }

  public void setSpanned(Spannable paramSpannable)
  {
    this.mSpanned = paramSpannable;
  }

  public void setText(ReactTextUpdate paramReactTextUpdate)
  {
    this.mContainsImages = paramReactTextUpdate.containsImages();
    if (getLayoutParams() == null)
      setLayoutParams(EMPTY_LAYOUT_PARAMS);
    setText(paramReactTextUpdate.getText());
    setPadding((int)Math.floor(paramReactTextUpdate.getPaddingLeft()), (int)Math.floor(paramReactTextUpdate.getPaddingTop()), (int)Math.floor(paramReactTextUpdate.getPaddingRight()), (int)Math.floor(paramReactTextUpdate.getPaddingBottom()));
    int i = paramReactTextUpdate.getTextAlign();
    if (this.mTextAlign != i)
      this.mTextAlign = i;
    setGravityHorizontal(this.mTextAlign);
    if ((Build.VERSION.SDK_INT >= 23) && (getBreakStrategy() != paramReactTextUpdate.getTextBreakStrategy()))
      setBreakStrategy(paramReactTextUpdate.getTextBreakStrategy());
    if ((Build.VERSION.SDK_INT >= 26) && (getJustificationMode() != paramReactTextUpdate.getJustificationMode()))
      setJustificationMode(paramReactTextUpdate.getJustificationMode());
  }

  public void updateView()
  {
    if (this.mNumberOfLines == 2147483647);
    for (TextUtils.TruncateAt localTruncateAt = null; ; localTruncateAt = this.mEllipsizeLocation)
    {
      setEllipsize(localTruncateAt);
      return;
    }
  }

  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    int i = 0;
    if ((this.mContainsImages) && ((getText() instanceof Spanned)))
    {
      Spanned localSpanned = (Spanned)getText();
      TextInlineImageSpan[] arrayOfTextInlineImageSpan = (TextInlineImageSpan[])localSpanned.getSpans(0, localSpanned.length(), TextInlineImageSpan.class);
      int j = arrayOfTextInlineImageSpan.length;
      while (i < j)
      {
        if (arrayOfTextInlineImageSpan[i].getDrawable() == paramDrawable)
          return true;
        i++;
      }
    }
    return super.verifyDrawable(paramDrawable);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.text.ReactTextView
 * JD-Core Version:    0.6.2
 */