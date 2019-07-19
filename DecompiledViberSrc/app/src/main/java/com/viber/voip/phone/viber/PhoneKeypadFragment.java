package com.viber.voip.phone.viber;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.R.layout;
import com.viber.voip.phone.viber.controller.KeypadHolder;

public class PhoneKeypadFragment extends CallViewHolder
{
  private View mContent;
  private KeypadHolder mKeypadHolder;
  private KeypadVisibilityListener mKeypadVisibilityListener;

  public PhoneKeypadFragment(CallFragment paramCallFragment)
  {
    super(paramCallFragment);
  }

  public KeypadHolder getKeypadHolder()
  {
    if (this.mKeypadHolder == null)
      this.mKeypadHolder = new KeypadHolder();
    return this.mKeypadHolder;
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mContent = paramLayoutInflater.inflate(R.layout.phone_call_keypad, paramViewGroup, false);
    if (this.mKeypadHolder == null)
      this.mKeypadHolder = new KeypadHolder(this.mContent);
    while (true)
    {
      return this.mContent;
      this.mKeypadHolder.initKeypad(this.mContent);
    }
  }

  public void onDestroy()
  {
    this.mContent = null;
    this.mKeypadHolder = null;
    setFragment(null);
  }

  public void onHide()
  {
    if (this.mKeypadVisibilityListener != null)
      this.mKeypadVisibilityListener.onKeypadHide();
  }

  public void onShow()
  {
    if (this.mKeypadVisibilityListener != null)
      this.mKeypadVisibilityListener.onKeypadShow();
  }

  public void setKeypadVisibilityListener(KeypadVisibilityListener paramKeypadVisibilityListener)
  {
    this.mKeypadVisibilityListener = paramKeypadVisibilityListener;
  }

  public static abstract interface KeypadVisibilityListener
  {
    public abstract void onKeypadHide();

    public abstract void onKeypadShow();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.PhoneKeypadFragment
 * JD-Core Version:    0.6.2
 */