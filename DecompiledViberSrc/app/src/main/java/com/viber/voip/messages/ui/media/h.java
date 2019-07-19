package com.viber.voip.messages.ui.media;

import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.sound.audiofocus.AudioFocusManager;
import com.viber.voip.sound.audiofocus.AudioFocusable;
import com.viber.voip.sound.audiofocus.SimpleAudioFocusable;

public class h
{
  private static final Logger a = ViberEnv.getLogger();
  private final AudioFocusManager b;
  private a c;
  private boolean d = false;
  private boolean e = false;
  private final AudioFocusable f = new SimpleAudioFocusable()
  {
    public void onGainAudioFocus()
    {
      if ((h.a(h.this) == null) || (!h.a(h.this).a()))
        h.this.a();
    }

    public void onLossAudioFocus()
    {
      if ((h.a(h.this) == null) || (!h.a(h.this).b()))
        h.this.a();
    }
  };

  public h(Context paramContext)
  {
    this.b = new AudioFocusManager(paramContext);
  }

  public void a()
  {
    try
    {
      if (this.e)
      {
        this.e = false;
        this.c = null;
        this.b.abandonAudioFocus();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(a parama)
  {
    try
    {
      boolean bool = this.d;
      if (bool);
      while (true)
      {
        return;
        if (this.c != parama)
          this.c = parama;
        if (!this.e)
        {
          this.e = true;
          this.b.requestAudioFocus(this.f, 3, 1);
        }
      }
    }
    finally
    {
    }
  }

  public void b()
  {
    try
    {
      this.d = true;
      a();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public boolean c()
  {
    try
    {
      boolean bool1 = this.d;
      if (!bool1)
      {
        bool2 = true;
        return bool2;
      }
      boolean bool2 = false;
    }
    finally
    {
    }
  }

  public static abstract interface a
  {
    public abstract boolean a();

    public abstract boolean b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.h
 * JD-Core Version:    0.6.2
 */