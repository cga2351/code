package com.viber.voip.calls.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.styleable;

public class KeypadButton extends RelativeLayout
{
  private char[] a;

  public KeypadButton(Context paramContext)
  {
    this(paramContext, null);
  }

  public KeypadButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public KeypadButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
    setClickable(true);
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet == null);
    String str1;
    int k;
    do
    {
      return;
      int i = getResources().getDimensionPixelSize(R.dimen.keypad_letters_left_padding);
      int j = getResources().getDimensionPixelSize(R.dimen.keypad_letters_bottom_padding);
      float f = getResources().getDimension(R.dimen.call_keypad_letters_text_size) / getResources().getDisplayMetrics().density;
      TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.KeypadButton);
      str1 = localTypedArray.getString(R.styleable.KeypadButton_keyTextPrior);
      String str2 = localTypedArray.getString(R.styleable.KeypadButton_keyTextSecond);
      ColorStateList localColorStateList = localTypedArray.getColorStateList(R.styleable.KeypadButton_keyTextColorPrimary);
      Drawable localDrawable = localTypedArray.getDrawable(R.styleable.KeypadButton_keySrc);
      k = localTypedArray.getInt(R.styleable.KeypadButton_keyNumber, -1);
      localTypedArray.recycle();
      ImageView localImageView = new ImageView(paramContext);
      localImageView.setId(R.id.image);
      localImageView.setDuplicateParentStateEnabled(true);
      addView(localImageView);
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams1.addRule(13);
      localImageView.setLayoutParams(localLayoutParams1);
      localImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      localImageView.setImageDrawable(localDrawable);
      LinearLayout localLinearLayout = new LinearLayout(paramContext);
      localLinearLayout.setDuplicateParentStateEnabled(true);
      addView(localLinearLayout);
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams2.addRule(5, R.id.image);
      localLayoutParams2.addRule(8, R.id.image);
      localLinearLayout.setLayoutParams(localLayoutParams2);
      localLinearLayout.setOrientation(1);
      localLinearLayout.setPadding(i, 0, 0, j);
      TextView localTextView1 = new TextView(paramContext);
      localTextView1.setDuplicateParentStateEnabled(true);
      localLinearLayout.addView(localTextView1);
      localTextView1.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
      if (str1 != null)
        localTextView1.setText(str1);
      if (localColorStateList != null)
        localTextView1.setTextColor(localColorStateList);
      localTextView1.setTextSize(1, f);
      if (TextUtils.isEmpty(str1))
        localTextView1.setVisibility(8);
      TextView localTextView2 = new TextView(paramContext);
      localTextView2.setDuplicateParentStateEnabled(true);
      localLinearLayout.addView(localTextView2);
      localTextView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
      if (str2 != null)
        localTextView2.setText(str2);
      if (localColorStateList != null)
        localTextView2.setTextColor(localColorStateList);
      localTextView2.setTextSize(1, f);
      if (TextUtils.isEmpty(str2))
        localTextView2.setVisibility(8);
      if (!TextUtils.isEmpty(str1))
        break;
    }
    while (!a(k));
    this.a = new char[1];
    this.a[0] = Character.forDigit(k, 10);
    return;
    char[] arrayOfChar = str1.toCharArray();
    if (!a(k))
    {
      this.a = arrayOfChar;
      return;
    }
    this.a = new char[1 + arrayOfChar.length];
    System.arraycopy(arrayOfChar, 0, this.a, 0, arrayOfChar.length);
    this.a[(-1 + this.a.length)] = Character.forDigit(k, 10);
  }

  private boolean a(int paramInt)
  {
    return (paramInt >= 0) && (paramInt <= 9);
  }

  public char[] getChars()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.calls.ui.KeypadButton
 * JD-Core Version:    0.6.2
 */