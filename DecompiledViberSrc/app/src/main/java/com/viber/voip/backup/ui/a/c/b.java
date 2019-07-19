package com.viber.voip.backup.ui.a.c;

import android.view.View;
import android.view.View.OnClickListener;
import com.viber.voip.ui.ViberTextView;
import com.viber.voip.util.dj;
import com.viber.voip.widget.ProgressBar;

public class b
  implements View.OnClickListener
{
  private a a;
  private View b;
  private ViberTextView c;
  private ViberTextView d;
  private ProgressBar e;
  private final a f;

  public b(a parama, a parama1)
  {
    this.a = parama;
    this.f = parama1;
  }

  public b(a parama, a parama1, View paramView, ViberTextView paramViberTextView)
  {
    this.a = parama;
    this.b = paramView;
    this.c = paramViberTextView;
    this.f = parama1;
    this.b.setOnClickListener(this);
  }

  public b(a parama, a parama1, View paramView, ViberTextView paramViberTextView1, ViberTextView paramViberTextView2)
  {
    this.a = parama;
    this.b = paramView;
    this.c = paramViberTextView1;
    this.d = paramViberTextView2;
    this.f = parama1;
    this.b.setOnClickListener(this);
  }

  public b(a parama, a parama1, View paramView, ViberTextView paramViberTextView1, ViberTextView paramViberTextView2, ProgressBar paramProgressBar)
  {
    this.a = parama;
    this.b = paramView;
    this.c = paramViberTextView1;
    this.d = paramViberTextView2;
    this.e = paramProgressBar;
    this.f = parama1;
    this.b.setOnClickListener(this);
  }

  public a a()
  {
    return this.a;
  }

  public void a(int paramInt)
  {
    if (this.d != null)
      this.d.setText(paramInt);
  }

  public void a(CharSequence paramCharSequence)
  {
    if (this.c != null)
      this.c.setText(paramCharSequence);
  }

  public void a(boolean paramBoolean)
  {
    dj.b(this.d, paramBoolean);
  }

  public void b(int paramInt)
  {
    if (this.e != null)
      this.e.setProgress(paramInt);
  }

  public void b(CharSequence paramCharSequence)
  {
    if (this.d != null)
      this.d.setText(paramCharSequence);
  }

  public void b(boolean paramBoolean)
  {
    dj.b(this.e, paramBoolean);
  }

  public void c(boolean paramBoolean)
  {
    dj.b(this.b, paramBoolean);
    b(paramBoolean);
  }

  public void d(boolean paramBoolean)
  {
    if (this.b != null)
      this.b.setEnabled(paramBoolean);
  }

  public void onClick(View paramView)
  {
    this.f.a(this.a);
  }

  public static abstract interface a
  {
    public abstract void a(a parama);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.ui.a.c.b
 * JD-Core Version:    0.6.2
 */