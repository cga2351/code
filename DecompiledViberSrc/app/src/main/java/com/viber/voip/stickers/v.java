package com.viber.voip.stickers;

import android.content.Context;
import android.net.Uri;
import com.viber.dexshared.Logger;
import com.viber.svg.jni.SvgViewBackend;
import com.viber.voip.ViberEnv;
import com.viber.voip.sound.MessageSoundPlayer;
import com.viber.voip.sound.MessageSoundPlayer.Listener;

public class v<T>
  implements MessageSoundPlayer.Listener<T>
{
  private static final Logger a = ViberEnv.getLogger();
  protected MessageSoundPlayer<T> b = new MessageSoundPlayer(paramContext.getApplicationContext(), this);
  protected b c;
  protected b d;
  protected boolean e;
  protected boolean f;
  protected a<T> g;

  public v(Context paramContext, a<T> parama)
  {
    this.g = parama;
  }

  public void a()
  {
    this.c = null;
    this.d = null;
    this.e = false;
    this.f = false;
  }

  public void a(c<T> paramc)
  {
    a();
    if (paramc.isAnimatedSticker())
      paramc.startAnimation();
    while (paramc.hasSound())
    {
      Uri localUri = Uri.parse(paramc.getSoundPath());
      Object localObject = paramc.getUniqueId();
      if (!this.b.play(localObject, localUri))
        this.d = b.b;
      return;
      this.c = b.b;
    }
    this.d = b.b;
  }

  public void a(T paramT)
  {
    this.c = b.a;
    c localc = this.g.getCurrentlyPlayedStickerView();
    if (localc != null)
      localc.stopAnimation();
    if (!this.e)
    {
      this.e = true;
      this.g.setCurrentlyPlayedItem(paramT);
    }
  }

  public void b(c<T> paramc)
  {
    if (paramc.isAnimatedSticker())
      paramc.stopAnimation();
    if (paramc.hasSound())
      this.b.stop(paramc.getUniqueId());
  }

  public boolean b()
  {
    return this.b.isPlaying(this.g.getCurrentlyPlayedItem());
  }

  public boolean b(T paramT)
  {
    return (paramT.equals(this.g.getCurrentlyPlayedItem())) && ((b.a == this.c) || (b.a == this.d));
  }

  public void c(c<T> paramc)
  {
    if ((paramc.isAnimatedSticker()) && (!paramc.resumeAnimation()))
      this.c = b.b;
    if (paramc.hasSound())
    {
      this.b.resume(paramc.getUniqueId());
      this.g.notifySoundStarted(paramc.getUniqueId());
    }
  }

  public void c(T paramT)
  {
    if (!this.f)
    {
      this.f = true;
      this.g.onPlay(paramT);
    }
    c localc = this.g.getCurrentlyPlayedStickerView();
    if (localc != null)
      this.g.updateCurrentlyPlayedSvgViewBackend(localc.getBackend());
  }

  public void d(c<T> paramc)
  {
    if ((paramc.isAnimatedSticker()) && (!paramc.pauseAnimation()))
      this.c = b.b;
    if (paramc.hasSound())
    {
      this.b.pause(paramc.getUniqueId());
      this.g.notifySoundStopped(paramc.getUniqueId());
    }
  }

  public void d(T paramT)
  {
    this.c = b.b;
    if ((b.b == this.d) && (this.g.onStop(paramT)))
      this.g.updateCurrentlyPlayedSvgViewBackend(null);
  }

  public void onSoundStarted(T paramT)
  {
    this.d = b.a;
    this.g.notifySoundStarted(paramT);
    if (!this.e)
    {
      this.e = true;
      this.g.setCurrentlyPlayedItem(paramT);
    }
    if (!this.f)
    {
      this.f = true;
      this.g.onPlay(paramT);
    }
  }

  public void onSoundStopped(T paramT, int paramInt)
  {
    c localc = this.g.getCurrentlyPlayedStickerView();
    this.g.notifySoundStopped(paramT);
    if ((1 == paramInt) && (localc != null) && (localc.isAnimatedSticker()) && (localc.getUniqueId().equals(paramT)))
      localc.stopAnimation();
    this.d = b.b;
    if (b.b == this.c)
      this.g.onStop(paramT);
  }

  public static abstract interface a<T>
  {
    public abstract T getCurrentlyPlayedItem();

    public abstract v.c<T> getCurrentlyPlayedStickerView();

    public abstract void notifySoundStarted(T paramT);

    public abstract void notifySoundStopped(T paramT);

    public abstract void onPlay(T paramT);

    public abstract boolean onStop(T paramT);

    public abstract void setCurrentlyPlayedItem(T paramT);

    public abstract void updateCurrentlyPlayedSvgViewBackend(SvgViewBackend paramSvgViewBackend);
  }

  private static enum b
  {
    static
    {
      b[] arrayOfb = new b[2];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
    }
  }

  public static abstract interface c<T>
  {
    public abstract SvgViewBackend getBackend();

    public abstract String getSoundPath();

    public abstract T getUniqueId();

    public abstract boolean hasSound();

    public abstract boolean isAnimatedSticker();

    public abstract void loadImage(boolean paramBoolean);

    public abstract boolean pauseAnimation();

    public abstract boolean resumeAnimation();

    public abstract void startAnimation();

    public abstract void stopAnimation();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.stickers.v
 * JD-Core Version:    0.6.2
 */