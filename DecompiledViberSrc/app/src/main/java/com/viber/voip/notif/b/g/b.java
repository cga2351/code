package com.viber.voip.notif.b.g;

import android.content.Context;
import com.viber.voip.R.string;
import com.viber.voip.notif.c.o;
import com.viber.voip.util.ViberActionRunner;

public class b extends com.viber.voip.notif.b.b
{
  private final CharSequence a;
  private final int b;

  public b(CharSequence paramCharSequence, int paramInt)
  {
    this.a = paramCharSequence;
    this.b = paramInt;
  }

  public int a()
  {
    return 202;
  }

  protected void a(Context paramContext, o paramo)
  {
    a(paramo.b(paramContext, 1, ViberActionRunner.b(paramContext), 0));
  }

  public int b()
  {
    return this.b;
  }

  public CharSequence b(Context paramContext)
  {
    return this.a;
  }

  public CharSequence b_(Context paramContext)
  {
    return paramContext.getText(R.string.app_name);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.g.b
 * JD-Core Version:    0.6.2
 */