package android.support.v7.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.res.TypedArrayUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class CheckBoxPreference extends TwoStatePreference
{
  private final a b = new a();

  public CheckBoxPreference(Context paramContext)
  {
    this(paramContext, null);
  }

  public CheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, TypedArrayUtils.getAttr(paramContext, R.attr.checkBoxPreferenceStyle, 16842895));
  }

  public CheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, 0);
  }

  public CheckBoxPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CheckBoxPreference, paramInt1, paramInt2);
    e(TypedArrayUtils.getString(localTypedArray, R.styleable.CheckBoxPreference_summaryOn, R.styleable.CheckBoxPreference_android_summaryOn));
    f(TypedArrayUtils.getString(localTypedArray, R.styleable.CheckBoxPreference_summaryOff, R.styleable.CheckBoxPreference_android_summaryOff));
    g(TypedArrayUtils.getBoolean(localTypedArray, R.styleable.CheckBoxPreference_disableDependentsState, R.styleable.CheckBoxPreference_android_disableDependentsState, false));
    localTypedArray.recycle();
  }

  private void c(View paramView)
  {
    if (!((AccessibilityManager)I().getSystemService("accessibility")).isEnabled())
      return;
    d(paramView.findViewById(16908289));
    b(paramView.findViewById(16908304));
  }

  private void d(View paramView)
  {
    if ((paramView instanceof CompoundButton))
      ((CompoundButton)paramView).setOnCheckedChangeListener(null);
    if ((paramView instanceof Checkable))
      ((Checkable)paramView).setChecked(this.a);
    if ((paramView instanceof CompoundButton))
      ((CompoundButton)paramView).setOnCheckedChangeListener(this.b);
  }

  public void a(l paraml)
  {
    super.a(paraml);
    d(paraml.a(16908289));
    b(paraml);
  }

  protected void a(View paramView)
  {
    super.a(paramView);
    c(paramView);
  }

  private class a
    implements CompoundButton.OnCheckedChangeListener
  {
    a()
    {
    }

    public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      if (!CheckBoxPreference.this.b(Boolean.valueOf(paramBoolean)))
      {
        if (!paramBoolean);
        for (boolean bool = true; ; bool = false)
        {
          paramCompoundButton.setChecked(bool);
          return;
        }
      }
      CheckBoxPreference.this.f(paramBoolean);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.preference.CheckBoxPreference
 * JD-Core Version:    0.6.2
 */