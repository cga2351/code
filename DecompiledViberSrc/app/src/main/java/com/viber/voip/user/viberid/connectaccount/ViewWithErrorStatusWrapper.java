package com.viber.voip.user.viberid.connectaccount;

import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

public class ViewWithErrorStatusWrapper
{
  private final boolean mHideErrorOnTextChange;
  private TextChangeListener mTextChangeListener;
  private final TextInputLayout mTextInputLayout;
  private ViewWithProgressWrapper mViewWithProgressWrapper;

  public ViewWithErrorStatusWrapper(TextInputLayout paramTextInputLayout)
  {
    this(paramTextInputLayout, true);
  }

  public ViewWithErrorStatusWrapper(TextInputLayout paramTextInputLayout, boolean paramBoolean)
  {
    this.mTextInputLayout = paramTextInputLayout;
    this.mHideErrorOnTextChange = paramBoolean;
    EditText localEditText = this.mTextInputLayout.getEditText();
    if (localEditText != null)
      localEditText.addTextChangedListener(new TextWatcher()
      {
        public void afterTextChanged(Editable paramAnonymousEditable)
        {
        }

        public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
        }

        public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
        {
          if (ViewWithErrorStatusWrapper.this.mHideErrorOnTextChange)
            ViewWithErrorStatusWrapper.this.setError(null);
          if (ViewWithErrorStatusWrapper.this.mTextChangeListener != null)
            ViewWithErrorStatusWrapper.this.mTextChangeListener.onTextChanged(paramAnonymousCharSequence.toString());
        }
      });
  }

  public EditText getEditText()
  {
    return this.mTextInputLayout.getEditText();
  }

  public View getView()
  {
    return this.mTextInputLayout;
  }

  public void hideLoadding()
  {
    if (this.mViewWithProgressWrapper != null)
    {
      this.mViewWithProgressWrapper.hideLoadding();
      setEnabled(true);
    }
  }

  public void setEnabled(boolean paramBoolean)
  {
    this.mTextInputLayout.setEnabled(paramBoolean);
  }

  public void setError(CharSequence paramCharSequence)
  {
    this.mTextInputLayout.setError(paramCharSequence);
  }

  public void setTextChangeListener(TextChangeListener paramTextChangeListener)
  {
    this.mTextChangeListener = paramTextChangeListener;
  }

  public void showLoading()
  {
    if (this.mViewWithProgressWrapper == null)
      this.mViewWithProgressWrapper = new ViewWithProgressWrapper(getEditText());
    this.mViewWithProgressWrapper.showLoading();
    setEnabled(false);
  }

  public static abstract interface TextChangeListener
  {
    public abstract void onTextChanged(String paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.connectaccount.ViewWithErrorStatusWrapper
 * JD-Core Version:    0.6.2
 */