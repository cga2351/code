package com.facebook.react.views.textinput;

import android.os.Build.VERSION;
import android.text.SpannableStringBuilder;
import android.widget.EditText;

public final class ReactTextInputLocalData
{
  private final int mBreakStrategy;
  private final int mInputType;
  private final int mMaxLines;
  private final int mMinLines;
  private final CharSequence mPlaceholder;
  private final SpannableStringBuilder mText;
  private final float mTextSize;

  public ReactTextInputLocalData(EditText paramEditText)
  {
    this.mText = new SpannableStringBuilder(paramEditText.getText());
    this.mTextSize = paramEditText.getTextSize();
    this.mInputType = paramEditText.getInputType();
    this.mPlaceholder = paramEditText.getHint();
    this.mMinLines = paramEditText.getMinLines();
    this.mMaxLines = paramEditText.getMaxLines();
    if (Build.VERSION.SDK_INT >= 23)
    {
      this.mBreakStrategy = paramEditText.getBreakStrategy();
      return;
    }
    this.mBreakStrategy = 0;
  }

  public void apply(EditText paramEditText)
  {
    paramEditText.setText(this.mText);
    paramEditText.setTextSize(0, this.mTextSize);
    paramEditText.setMinLines(this.mMinLines);
    paramEditText.setMaxLines(this.mMaxLines);
    paramEditText.setInputType(this.mInputType);
    paramEditText.setHint(this.mPlaceholder);
    if (Build.VERSION.SDK_INT >= 23)
      paramEditText.setBreakStrategy(this.mBreakStrategy);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.textinput.ReactTextInputLocalData
 * JD-Core Version:    0.6.2
 */