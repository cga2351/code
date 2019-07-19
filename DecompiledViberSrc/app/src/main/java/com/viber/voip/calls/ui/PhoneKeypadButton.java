package com.viber.voip.calls.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.viber.voip.R.attr;
import com.viber.voip.R.dimen;
import com.viber.voip.R.styleable;
import com.viber.voip.ViberApplication;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;

public class PhoneKeypadButton extends LinearLayout
{
  public PhoneKeypadButton(Context paramContext)
  {
    this(paramContext, null);
  }

  public PhoneKeypadButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public PhoneKeypadButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    int i = 1;
    int j;
    int k;
    String str1;
    String str2;
    ColorStateList localColorStateList2;
    int m;
    label134: TextView localTextView1;
    TextView localTextView2;
    if ((dj.c(paramContext)) && (!ViberApplication.isTablet(paramContext)))
    {
      j = i;
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.PhoneKeypadButton);
      k = localTypedArray.getInt(R.styleable.PhoneKeypadButton_keyDigit, -1);
      str1 = localTypedArray.getString(R.styleable.PhoneKeypadButton_keySign);
      str2 = localTypedArray.getString(R.styleable.PhoneKeypadButton_keyLetters);
      ColorStateList localColorStateList1 = localTypedArray.getColorStateList(R.styleable.PhoneKeypadButton_keyTextColorPrimary);
      localColorStateList2 = localTypedArray.getColorStateList(R.styleable.PhoneKeypadButton_keyTextColorSecondary);
      localTypedArray.recycle();
      if (localColorStateList1 == null)
        localColorStateList1 = dc.e(paramContext, R.attr.keypadTextPrimaryColor);
      if (localColorStateList2 == null)
        localColorStateList2 = dc.e(paramContext, R.attr.keypadTextSecondaryColor);
      if (j != 0)
        i = 0;
      setOrientation(i);
      if (j == 0)
        break label335;
      m = 19;
      setGravity(m);
      localTextView1 = new TextView(paramContext);
      localTextView1.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.keypad_digit_text_size));
      localTextView1.setTypeface(Typeface.create("sans-serif-light", 0));
      localTextView1.setTextColor(localColorStateList1);
      addView(localTextView1, new LinearLayout.LayoutParams(-2, -2));
      if (j != 0)
        ((ViewGroup.MarginLayoutParams)localTextView1.getLayoutParams()).leftMargin = getResources().getDimensionPixelSize(R.dimen.keypad_digit_left_margin);
      localTextView2 = new TextView(paramContext);
      localTextView2.setTextSize(0, getResources().getDimensionPixelSize(R.dimen.keypad_letters_text_size));
      localTextView2.setTextColor(localColorStateList2);
      addView(localTextView2, new LinearLayout.LayoutParams(-2, -2));
      if (j != 0)
        break label342;
      ((ViewGroup.MarginLayoutParams)localTextView2.getLayoutParams()).topMargin = getResources().getDimensionPixelSize(R.dimen.keypad_letters_top_margin);
    }
    while (true)
    {
      if (k == -1)
        break label366;
      localTextView1.setText(String.valueOf(k));
      localTextView2.setText(str2);
      return;
      j = 0;
      break;
      label335: m = 17;
      break label134;
      label342: ((ViewGroup.MarginLayoutParams)localTextView2.getLayoutParams()).leftMargin = getResources().getDimensionPixelSize(R.dimen.keypad_letters_left_margin);
    }
    label366: localTextView1.setTextColor(localColorStateList2);
    localTextView1.setText(str1);
    localTextView2.setVisibility(8);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.calls.ui.PhoneKeypadButton
 * JD-Core Version:    0.6.2
 */