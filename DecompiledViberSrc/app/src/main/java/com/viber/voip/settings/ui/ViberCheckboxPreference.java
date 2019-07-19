package com.viber.voip.settings.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.Preference.c;
import android.support.v7.preference.l;
import android.util.AttributeSet;
import android.widget.TextView;
import com.viber.voip.R.layout;
import com.viber.voip.R.styleable;
import com.viber.voip.widget.x;

public class ViberCheckboxPreference extends CheckBoxPreference
{
  private final x b = new x();
  private TextView c;
  private TextView d;
  private int e = 1;
  private int f = 1;
  private boolean g = false;
  private Preference.c h;

  public ViberCheckboxPreference(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  public ViberCheckboxPreference(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }

  public ViberCheckboxPreference(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    c(R.layout._ics_custom_preference_layout);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ViberCheckboxPreference);
    int i = localTypedArray.getIndexCount();
    int j = 0;
    if (j < i)
    {
      int k = localTypedArray.getIndex(j);
      if (k == R.styleable.ViberCheckboxPreference_title_max_lines)
        this.e = localTypedArray.getInt(k, 1);
      while (true)
      {
        j++;
        break;
        if (k == R.styleable.ViberCheckboxPreference_summary_max_lines)
          this.f = localTypedArray.getInt(k, 1);
        else if (k == R.styleable.ViberCheckboxPreference_handle_links)
          this.g = localTypedArray.getBoolean(k, false);
      }
    }
    localTypedArray.recycle();
  }

  public void a(l paraml)
  {
    super.a(paraml);
    this.d = ((TextView)paraml.a(16908304));
    this.c = ((TextView)paraml.a(16908310));
    if (this.e > 1)
    {
      this.c.setMaxLines(this.e);
      this.c.setSingleLine(false);
    }
    if (this.f > 1)
    {
      this.d.setMaxLines(this.f);
      this.d.setSingleLine(false);
    }
    if (this.g)
      this.d.setOnTouchListener(this.b);
  }

  public void b(Preference.c paramc)
  {
    this.h = paramc;
  }

  protected void k()
  {
    if ((this.h != null) && (this.h.a(this)))
      return;
    super.k();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.ViberCheckboxPreference
 * JD-Core Version:    0.6.2
 */