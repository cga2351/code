package com.viber.voip.validation;

import com.viber.voip.widget.TextViewWithDescription;
import com.viber.voip.widget.ViewWithDescription.a;

public class g
  implements i<a>
{
  private TextViewWithDescription a;
  private boolean b;

  public g(TextViewWithDescription paramTextViewWithDescription)
  {
    this.a = paramTextViewWithDescription;
  }

  private ViewWithDescription.a b(a parama)
  {
    switch (1.a[parama.a.ordinal()])
    {
    default:
      return ViewWithDescription.a.a;
    case 1:
      return ViewWithDescription.a.a;
    case 2:
      if (this.b)
        return ViewWithDescription.a.b;
      return ViewWithDescription.a.a;
    case 3:
      return ViewWithDescription.a.c;
    case 4:
    }
    return ViewWithDescription.a.e;
  }

  public g a(boolean paramBoolean)
  {
    this.b = paramBoolean;
    return this;
  }

  public void a()
  {
    this.a.setStatus(ViewWithDescription.a.d);
  }

  public void a(a parama)
  {
    ViewWithDescription.a locala = b(parama);
    if (parama.b != null)
    {
      this.a.a(locala, parama.b);
      return;
    }
    if (parama.c != 0)
    {
      this.a.a(locala, parama.c);
      return;
    }
    this.a.setStatus(locala);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.validation.g
 * JD-Core Version:    0.6.2
 */