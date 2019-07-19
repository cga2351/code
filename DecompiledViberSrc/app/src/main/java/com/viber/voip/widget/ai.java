package com.viber.voip.widget;

import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;
import com.viber.common.d.c;
import com.viber.voip.R.id;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;

public class ai
{
  a a;
  SwitchCompat b;
  private View c;
  private TextView d;
  private TextView e;
  private CharSequence f;
  private CharSequence g;
  private boolean h;

  public ai(View paramView, boolean paramBoolean)
  {
    this.c = paramView;
    this.c.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        SwitchCompat localSwitchCompat = ai.this.b;
        if (!ai.this.b.isChecked());
        for (boolean bool = true; ; bool = false)
        {
          localSwitchCompat.setChecked(bool);
          return;
        }
      }
    });
    this.d = ((TextView)paramView.findViewById(R.id.title));
    this.e = ((TextView)paramView.findViewById(R.id.summary));
    this.b = ((SwitchCompat)paramView.findViewById(R.id.checker));
    this.b.setChecked(paramBoolean);
    this.b.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        ai.this.a();
        if ((!ai.a(ai.this)) && (ai.this.a != null))
          ai.this.a.a(paramAnonymousBoolean);
        ai.a(ai.this, false);
      }
    });
    if (c.a())
      this.e.setGravity(3);
    a();
  }

  void a()
  {
    CharSequence localCharSequence;
    TextView localTextView;
    if (this.b.isChecked())
    {
      localCharSequence = this.f;
      localTextView = this.e;
      if (da.a(localCharSequence))
        break label65;
    }
    label65: for (boolean bool = true; ; bool = false)
    {
      dj.b(localTextView, bool);
      if (!this.e.getText().equals(localCharSequence))
        this.e.setText(localCharSequence);
      return;
      localCharSequence = this.g;
      break;
    }
  }

  public void a(a parama)
  {
    this.a = parama;
  }

  public void a(CharSequence paramCharSequence)
  {
    this.d.setText(paramCharSequence);
  }

  public void a(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    this.f = paramCharSequence1;
    this.g = paramCharSequence2;
    a();
  }

  public void a(boolean paramBoolean)
  {
    a(paramBoolean, true);
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1 != this.b.isChecked())
      if (paramBoolean2)
        break label35;
    label35: for (boolean bool = true; ; bool = false)
    {
      this.h = bool;
      this.b.setChecked(paramBoolean1);
      a();
      return;
    }
  }

  public View b()
  {
    return this.c;
  }

  public void b(CharSequence paramCharSequence)
  {
    a(paramCharSequence, paramCharSequence);
  }

  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.ai
 * JD-Core Version:    0.6.2
 */