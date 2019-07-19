package com.viber.voip.phone.viber.controller;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Paint;
import android.widget.TextView;
import com.viber.voip.R.string;
import java.lang.ref.WeakReference;

public class CallReconnect
  implements Runnable
{
  private int mDots = 0;
  private int mGravityTmp = 0;
  private int mMinWidthTmp = 0;
  private boolean mStarted = false;
  private WeakReference<TextView> mTextViewRef;
  private int mWidth;
  private int mWidthTmp = 0;

  public CallReconnect(TextView paramTextView)
  {
    this.mTextViewRef = new WeakReference(paramTextView);
    if (paramTextView != null)
    {
      Paint localPaint = new Paint();
      localPaint.setTextSize(paramTextView.getTextSize());
      localPaint.setTextScaleX(paramTextView.getTextScaleX());
      this.mWidth = ((int)localPaint.measureText(paramTextView.getResources().getString(R.string.call_reconnecting).concat("...")));
    }
  }

  @SuppressLint({"SetTextI18n"})
  public void run()
  {
    TextView localTextView = (TextView)this.mTextViewRef.get();
    if (localTextView == null);
    int j;
    do
    {
      return;
      char[] arrayOfChar = new char[3];
      int i = 0;
      if (i < arrayOfChar.length)
      {
        if (i < this.mDots);
        for (int k = 46; ; k = 32)
        {
          arrayOfChar[i] = k;
          i++;
          break;
        }
      }
      localTextView.setText(localTextView.getResources().getString(R.string.call_reconnecting) + new String(arrayOfChar));
      if (this.mStarted)
        localTextView.postDelayed(this, 300L);
      j = 1 + this.mDots;
      this.mDots = j;
    }
    while (j <= 3);
    this.mDots = 0;
  }

  public void start()
  {
    TextView localTextView = (TextView)this.mTextViewRef.get();
    if (localTextView == null);
    do
    {
      return;
      localTextView.post(this);
    }
    while (this.mStarted);
    this.mStarted = true;
    this.mGravityTmp = localTextView.getGravity();
    this.mWidthTmp = localTextView.getWidth();
    try
    {
      this.mMinWidthTmp = localTextView.getMinWidth();
      label58: localTextView.setGravity(17);
      localTextView.setMinWidth(this.mWidth);
      localTextView.setWidth(this.mWidth);
      return;
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      break label58;
    }
  }

  public void stop()
  {
    TextView localTextView = (TextView)this.mTextViewRef.get();
    if (localTextView == null);
    do
    {
      return;
      localTextView.removeCallbacks(this);
    }
    while (!this.mStarted);
    localTextView.setGravity(this.mGravityTmp);
    try
    {
      localTextView.setMinWidth(this.mMinWidthTmp);
      label45: localTextView.setWidth(this.mWidthTmp);
      this.mStarted = false;
      return;
    }
    catch (NoSuchMethodError localNoSuchMethodError)
    {
      break label45;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.controller.CallReconnect
 * JD-Core Version:    0.6.2
 */