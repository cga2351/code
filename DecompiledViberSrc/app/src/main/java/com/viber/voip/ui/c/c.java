package com.viber.voip.ui.c;

import android.content.Intent;
import android.os.Bundle;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public abstract class c
{
  protected Logger a = ViberEnv.getLogger();
  protected a b;

  public c(a parama)
  {
    this.b = parama;
  }

  public static Intent a(Intent paramIntent)
  {
    return paramIntent.putExtra("ActivityDecorator.decoration_type", 1);
  }

  public abstract void a();

  public abstract void a(Intent paramIntent, Bundle paramBundle);

  public abstract void a(Bundle paramBundle);

  public abstract void b(Intent paramIntent);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.c.c
 * JD-Core Version:    0.6.2
 */