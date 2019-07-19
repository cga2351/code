package com.viber.voip.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RatingBar;
import com.viber.voip.messages.o;
import com.viber.voip.messages.ui.PinDialogLayout.a;

public class PinView extends RatingBar
{
  private String a;
  private PinDialogLayout.a b;
  private o c;

  public PinView(Context paramContext)
  {
    super(paramContext);
    c();
  }

  public PinView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }

  public PinView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    c();
  }

  private void c()
  {
    this.a = "";
    setMax(4);
  }

  private void d()
  {
    setProgress(this.a.length());
  }

  private void setPinString(String paramString)
  {
    this.a = paramString;
    d();
  }

  public void a()
  {
    if (this.a.length() > 0)
      this.a = this.a.substring(0, -1 + this.a.length());
    d();
  }

  public void a(char paramChar)
  {
    if (this.a.length() < 4)
      this.a += paramChar;
    if (this.b != null)
    {
      this.b.a(this.a);
      if (this.a.length() == 4)
      {
        this.c.a(this.a);
        postDelayed(new w(this), 200L);
      }
    }
    d();
  }

  public void setOnEnterClickListener(PinDialogLayout.a parama)
  {
    this.b = parama;
  }

  public void setScreenData(o paramo)
  {
    this.c = paramo;
    setOnEnterClickListener(paramo.c());
    if (this.c.p() != null)
      setPinString(this.c.p());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.PinView
 * JD-Core Version:    0.6.2
 */