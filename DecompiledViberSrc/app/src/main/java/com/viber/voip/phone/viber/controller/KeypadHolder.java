package com.viber.voip.phone.viber.controller;

import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.viber.common.b.b;
import com.viber.jni.Engine;
import com.viber.voip.R.id;
import com.viber.voip.ViberApplication;
import com.viber.voip.phone.RTCCall;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.settings.d.m;
import com.viber.voip.sound.WebrtcDTMFGenerator;
import com.viber.voip.sound.tones.IRingtonePlayer;
import com.viber.voip.ui.ViberEditText;

public class KeypadHolder
  implements TextWatcher, View.OnTouchListener
{
  private static final int DTMF_TONE_DEFAULT_DURATION_MS = 400;
  private static final int DTMF_TONE_PLUS_DURATION_MS = 1500;
  private View mCloseKeypad;
  private View.OnClickListener mCloseKeypadListener;
  private boolean mDrawablesShown = true;
  private Drawable[] mPhoneFieldCompoundDrawables;
  private ViberEditText phoneTypeField;

  public KeypadHolder()
  {
  }

  public KeypadHolder(View paramView)
  {
    if (paramView != null)
      initKeypad(paramView);
  }

  private void checkPhoneInputDrawables(CharSequence paramCharSequence)
  {
    if ((paramCharSequence.length() > 0) && (!this.mDrawablesShown))
    {
      this.phoneTypeField.setCompoundDrawablesWithIntrinsicBounds(this.mPhoneFieldCompoundDrawables[0], this.mPhoneFieldCompoundDrawables[1], this.mPhoneFieldCompoundDrawables[2], this.mPhoneFieldCompoundDrawables[3]);
      this.mDrawablesShown = true;
    }
    while ((paramCharSequence.length() != 0) || (!this.mDrawablesShown))
      return;
    this.phoneTypeField.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    this.mDrawablesShown = false;
  }

  private RTCCall getViberRtcCall()
  {
    return ViberApplication.getInstance().getEngine(false).getCallHandler().getRTCCall();
  }

  public void afterTextChanged(Editable paramEditable)
  {
  }

  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
  }

  public void initKeypad(View paramView)
  {
    this.phoneTypeField = ((ViberEditText)paramView.findViewById(R.id.tone_input));
    this.phoneTypeField.requestFocus();
    this.phoneTypeField.setInputType(0);
    this.phoneTypeField.setOnTouchListener(this);
    this.phoneTypeField.addTextChangedListener(this);
    this.mPhoneFieldCompoundDrawables = this.phoneTypeField.getCompoundDrawables();
    checkPhoneInputDrawables(this.phoneTypeField.getText().toString());
    this.mCloseKeypad = paramView.findViewById(R.id.phone_close_keypad);
    if ((this.mCloseKeypadListener != null) && (this.mCloseKeypad != null))
      this.mCloseKeypad.setOnClickListener(this.mCloseKeypadListener);
    paramView.findViewById(R.id.one).setOnClickListener(new DtmfKeyListener("1", 1));
    paramView.findViewById(R.id.two).setOnClickListener(new DtmfKeyListener("2", 2));
    paramView.findViewById(R.id.three).setOnClickListener(new DtmfKeyListener("3", 3));
    paramView.findViewById(R.id.four).setOnClickListener(new DtmfKeyListener("4", 4));
    paramView.findViewById(R.id.five).setOnClickListener(new DtmfKeyListener("5", 5));
    paramView.findViewById(R.id.six).setOnClickListener(new DtmfKeyListener("6", 6));
    paramView.findViewById(R.id.seven).setOnClickListener(new DtmfKeyListener("7", 7));
    paramView.findViewById(R.id.eight).setOnClickListener(new DtmfKeyListener("8", 8));
    paramView.findViewById(R.id.nine).setOnClickListener(new DtmfKeyListener("9", 9));
    paramView.findViewById(R.id.zero).setOnClickListener(new DtmfKeyListener("0", 0));
    paramView.findViewById(R.id.star).setOnClickListener(new DtmfKeyListener("*", 10));
    paramView.findViewById(R.id.pound).setOnClickListener(new DtmfKeyListener("#", 11));
    paramView.findViewById(R.id.zero).setOnLongClickListener(new ZeroKeyLongClickListener(null));
  }

  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    checkPhoneInputDrawables(paramCharSequence);
  }

  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      EditText localEditText = (EditText)paramView;
      Drawable localDrawable = localEditText.getCompoundDrawables()[2];
      int i = (int)paramMotionEvent.getX();
      if ((localDrawable != null) && (i >= paramView.getWidth() - (localDrawable.getBounds().width() + 2 * localEditText.getCompoundDrawablePadding())))
        localEditText.getText().clear();
    }
    return false;
  }

  public void setOnCloseListener(View.OnClickListener paramOnClickListener)
  {
    this.mCloseKeypadListener = paramOnClickListener;
    if (this.mCloseKeypad != null)
      this.mCloseKeypad.setOnClickListener(paramOnClickListener);
  }

  private class DtmfKeyListener
    implements View.OnClickListener
  {
    private final int dtmfEvent;
    private final String symbol;

    static
    {
      if (!KeypadHolder.class.desiredAssertionStatus());
      for (boolean bool = true; ; bool = false)
      {
        $assertionsDisabled = bool;
        return;
      }
    }

    public DtmfKeyListener(String paramInt, int arg3)
    {
      assert (paramInt != null);
      this.symbol = paramInt;
      int i;
      this.dtmfEvent = i;
    }

    public void onClick(View paramView)
    {
      KeypadHolder.this.phoneTypeField.requestFocus();
      KeypadHolder.this.phoneTypeField.getText().append(this.symbol);
      WebrtcDTMFGenerator.sendDTMFTone(this.dtmfEvent);
      RTCCall localRTCCall = KeypadHolder.this.getViberRtcCall();
      if (localRTCCall != null)
        localRTCCall.sendDtmf(this.symbol, 400);
    }
  }

  private class ZeroKeyLongClickListener
    implements View.OnLongClickListener
  {
    private ZeroKeyLongClickListener()
    {
    }

    public boolean onLongClick(View paramView)
    {
      KeypadHolder.this.phoneTypeField.getText().append("+");
      RTCCall localRTCCall = KeypadHolder.this.getViberRtcCall();
      if (localRTCCall != null)
        localRTCCall.sendDtmf("0", 1500);
      if (d.m.d.d())
        ViberApplication.getInstance().getRingtonePlayer().vibrate(35);
      return true;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.controller.KeypadHolder
 * JD-Core Version:    0.6.2
 */