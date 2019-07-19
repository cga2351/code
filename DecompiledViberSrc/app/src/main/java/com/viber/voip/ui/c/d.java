package com.viber.voip.ui.c;

import android.content.Intent;
import android.os.Bundle;
import com.viber.voip.ui.ap.a;
import com.viber.voip.ui.c;
import com.viber.voip.ui.j.av;

public class d extends g
{
  private final c d;
  private final ap.a<com.viber.voip.ui.a> e;

  public d(f paramf, a parama, av paramav)
  {
    super(parama, paramav);
    this.d = new c(parama.getActivity(), paramf);
    this.e = new e(parama);
    this.d.a(this.e);
  }

  private int b(Intent paramIntent, Bundle paramBundle)
  {
    Bundle localBundle = paramIntent.getExtras();
    if (paramBundle != null);
    while (true)
    {
      return paramBundle.getInt("ActivityDecorator.decoration_type", 0);
      if (localBundle != null)
        paramBundle = localBundle;
      else
        paramBundle = Bundle.EMPTY;
    }
  }

  public void a(Intent paramIntent, Bundle paramBundle)
  {
    int i = b(paramIntent, paramBundle);
    this.d.d(i);
  }

  public void a(Bundle paramBundle)
  {
    paramBundle.putInt("ActivityDecorator.decoration_type", this.d.b());
  }

  protected int c(Intent paramIntent)
  {
    int i = b(paramIntent, null);
    int j = this.c.a(this.d.c(i));
    this.b.getActivity();
    return j;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.c.d
 * JD-Core Version:    0.6.2
 */