package com.viber.voip.messages.conversation.chatinfo.e;

import android.content.Context;
import android.content.res.ColorStateList;
import com.viber.voip.R.attr;
import com.viber.voip.ui.ap;
import com.viber.voip.util.dc;

public class c extends ap<b>
{
  public c(Context paramContext)
  {
    super(paramContext);
  }

  protected b a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return new b();
    case 1:
    }
    return new a();
  }

  class a
    implements b
  {
    private ColorStateList b;
    private ColorStateList c;

    a()
    {
    }

    public ColorStateList a()
    {
      ColorStateList localColorStateList = dc.a(this.b, c.c(c.this), R.attr.chatInfoSecretThumbColor);
      this.b = localColorStateList;
      return localColorStateList;
    }

    public ColorStateList b()
    {
      ColorStateList localColorStateList = dc.a(this.c, c.d(c.this), R.attr.chatInfoSecretTrackColor);
      this.c = localColorStateList;
      return localColorStateList;
    }
  }

  class b
    implements b
  {
    private ColorStateList b;
    private ColorStateList c;

    b()
    {
    }

    public ColorStateList a()
    {
      ColorStateList localColorStateList = dc.a(this.b, c.a(c.this), R.attr.chatInfoGeneralThumbColor);
      this.b = localColorStateList;
      return localColorStateList;
    }

    public ColorStateList b()
    {
      ColorStateList localColorStateList = dc.a(this.c, c.b(c.this), R.attr.chatInfoGeneralTrackColor);
      this.c = localColorStateList;
      return localColorStateList;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.chatinfo.e.c
 * JD-Core Version:    0.6.2
 */