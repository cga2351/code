package android.support.v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v7.widget.SwitchCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class SwitchPreferenceCompat extends TwoStatePreference
{
  private final a b = new a();
  private CharSequence c;
  private CharSequence d;

  public SwitchPreferenceCompat(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.switchPreferenceCompatStyle);
  }

  public SwitchPreferenceCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }

  public SwitchPreferenceCompat(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SwitchPreferenceCompat, paramInt1, paramInt2);
    e(TypedArrayUtils.getString(localTypedArray, R.styleable.SwitchPreferenceCompat_summaryOn, R.styleable.SwitchPreferenceCompat_android_summaryOn));
    f(TypedArrayUtils.getString(localTypedArray, R.styleable.SwitchPreferenceCompat_summaryOff, R.styleable.SwitchPreferenceCompat_android_summaryOff));
    a(TypedArrayUtils.getString(localTypedArray, R.styleable.SwitchPreferenceCompat_switchTextOn, R.styleable.SwitchPreferenceCompat_android_switchTextOn));
    d(TypedArrayUtils.getString(localTypedArray, R.styleable.SwitchPreferenceCompat_switchTextOff, R.styleable.SwitchPreferenceCompat_android_switchTextOff));
    g(TypedArrayUtils.getBoolean(localTypedArray, R.styleable.SwitchPreferenceCompat_disableDependentsState, R.styleable.SwitchPreferenceCompat_android_disableDependentsState, false));
    localTypedArray.recycle();
  }

  private void c(View paramView)
  {
    if (!((AccessibilityManager)I().getSystemService("accessibility")).isEnabled())
      return;
    d(paramView.findViewById(R.id.switchWidget));
    b(paramView.findViewById(16908304));
  }

  private void d(View paramView)
  {
    if ((paramView instanceof SwitchCompat))
      ((SwitchCompat)paramView).setOnCheckedChangeListener(null);
    if ((paramView instanceof Checkable))
      ((Checkable)paramView).setChecked(this.a);
    if ((paramView instanceof SwitchCompat))
    {
      SwitchCompat localSwitchCompat = (SwitchCompat)paramView;
      localSwitchCompat.setTextOn(this.c);
      localSwitchCompat.setTextOff(this.d);
      localSwitchCompat.setOnCheckedChangeListener(this.b);
    }
  }

  public void a(l paraml)
  {
    super.a(paraml);
    d(paraml.a(R.id.switchWidget));
    b(paraml);
  }

  protected void a(View paramView)
  {
    super.a(paramView);
    c(paramView);
  }

  public void a(CharSequence paramCharSequence)
  {
    this.c = paramCharSequence;
    d_();
  }

  public void d(CharSequence paramCharSequence)
  {
    this.d = paramCharSequence;
    d_();
  }

  private class a
    implements CompoundButton.OnCheckedChangeListener
  {
    a()
    {
    }

    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      if (!SwitchPreferenceCompat.this.b(Boolean.valueOf(paramBoolean)))
      {
        if (!paramBoolean);
        for (boolean bool = true; ; bool = false)
        {
          paramCompoundButton.setChecked(bool);
          return;
        }
      }
      SwitchPreferenceCompat.this.f(paramBoolean);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.preference.SwitchPreferenceCompat
 * JD-Core Version:    0.6.2
 */