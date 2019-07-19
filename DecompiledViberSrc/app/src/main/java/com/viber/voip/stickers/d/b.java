package com.viber.voip.stickers.d;

import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.svg.jni.SvgViewBackend;
import com.viber.voip.ViberEnv;
import com.viber.voip.sound.MessageSoundPlayer;
import com.viber.voip.stickers.v;
import com.viber.voip.stickers.v.a;
import com.viber.voip.stickers.v.c;

public class b
  implements v.a<String>
{
  private static final Logger a = ViberEnv.getLogger();
  private String b;
  private v.c<String> c;
  private v.c<String> d;
  private SvgViewBackend e;
  private final v<String> f = new a(paramContext, this);
  private boolean g;

  public b(Context paramContext)
  {
  }

  public void a()
  {
    this.g = true;
    if (this.c != null)
      this.f.b(this.c);
  }

  public void a(v.c<String> paramc)
  {
    this.d = paramc;
    this.f.a(paramc);
  }

  public void a(String paramString)
  {
  }

  public void b()
  {
    this.g = false;
  }

  public void b(v.c<String> paramc)
  {
    if (this.d == paramc)
      this.d = null;
    this.f.b(paramc);
  }

  public void b(String paramString)
  {
  }

  public void c(String paramString)
  {
    if ((paramString != null) && (this.d != null) && (paramString.equals(this.d.getUniqueId())))
    {
      this.b = paramString;
      this.c = this.d;
      this.d = null;
    }
  }

  public boolean c()
  {
    return !this.g;
  }

  public String d()
  {
    return this.b;
  }

  public void d(String paramString)
  {
  }

  public SvgViewBackend e()
  {
    return this.e;
  }

  public boolean e(String paramString)
  {
    if (paramString.equals(this.b))
    {
      this.c = null;
      this.b = null;
      return true;
    }
    return false;
  }

  public void f(String paramString)
  {
    this.f.a(paramString);
  }

  public void g(String paramString)
  {
    this.f.c(paramString);
  }

  public v.c<String> getCurrentlyPlayedStickerView()
  {
    return this.c;
  }

  public void h(String paramString)
  {
    this.f.d(paramString);
  }

  public void updateCurrentlyPlayedSvgViewBackend(SvgViewBackend paramSvgViewBackend)
  {
    this.e = paramSvgViewBackend;
  }

  private class a extends v<String>
  {
    a(v.a<String> arg2)
    {
      super(locala);
    }

    public void a(String paramString)
    {
      super.a(paramString);
      if ((b.a(b.this)) && (b.b(b.this) != null))
        b.b(b.this).stopAnimation();
    }

    public void b(String paramString)
    {
      super.onSoundStarted(paramString);
      if (b.a(b.this))
        this.b.stop(paramString);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.stickers.d.b
 * JD-Core Version:    0.6.2
 */