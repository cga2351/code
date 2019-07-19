package android.support.v14.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v7.preference.R.attr;
import android.support.v7.preference.R.styleable;
import android.support.v7.preference.TwoStatePreference;
import android.support.v7.preference.l;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.Switch;

public class SwitchPreference extends TwoStatePreference
{
  private final a b = new a();
  private CharSequence c;
  private CharSequence d;

  public SwitchPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, TypedArrayUtils.getAttr(paramContext, R.attr.switchPreferenceStyle, 16843629));
  }

  public SwitchPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }

  public SwitchPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SwitchPreference, paramInt1, paramInt2);
    e(TypedArrayUtils.getString(localTypedArray, R.styleable.SwitchPreference_summaryOn, R.styleable.SwitchPreference_android_summaryOn));
    f(TypedArrayUtils.getString(localTypedArray, R.styleable.SwitchPreference_summaryOff, R.styleable.SwitchPreference_android_summaryOff));
    a(TypedArrayUtils.getString(localTypedArray, R.styleable.SwitchPreference_switchTextOn, R.styleable.SwitchPreference_android_switchTextOn));
    a_(TypedArrayUtils.getString(localTypedArray, R.styleable.SwitchPreference_switchTextOff, R.styleable.SwitchPreference_android_switchTextOff));
    g(TypedArrayUtils.getBoolean(localTypedArray, R.styleable.SwitchPreference_disableDependentsState, R.styleable.SwitchPreference_android_disableDependentsState, false));
    localTypedArray.recycle();
  }

  private void c(View paramView)
  {
    if (!((AccessibilityManager)I().getSystemService("accessibility")).isEnabled())
      return;
    d(paramView.findViewById(16908352));
    b(paramView.findViewById(16908304));
  }

  private void d(View paramView)
  {
    if ((paramView instanceof Switch))
      ((Switch)paramView).setOnCheckedChangeListener(null);
    if ((paramView instanceof Checkable))
      ((Checkable)paramView).setChecked(this.a);
    if ((paramView instanceof Switch))
    {
      Switch localSwitch = (Switch)paramView;
      localSwitch.setTextOn(this.c);
      localSwitch.setTextOff(this.d);
      localSwitch.setOnCheckedChangeListener(this.b);
    }
  }

  public void a(l paraml)
  {
    super.a(paraml);
    d(paraml.a(16908352));
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

  public void a_(CharSequence paramCharSequence)
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
      if (!SwitchPreference.this.b(Boolean.valueOf(paramBoolean)))
      {
        if (!paramBoolean);
        for (boolean bool = true; ; bool = false)
        {
          paramCompoundButton.setChecked(bool);
          return;
        }
      }
      SwitchPreference.this.f(paramBoolean);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v14.preference.SwitchPreference
 * JD-Core Version:    0.6.2
 */