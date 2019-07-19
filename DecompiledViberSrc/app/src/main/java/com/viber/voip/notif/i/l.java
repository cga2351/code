package com.viber.voip.notif.i;

import com.viber.voip.sound.tones.IRingtonePlayer;
import com.viber.voip.stickers.b;
import dagger.a;

public class l
{
  private final a<IRingtonePlayer> a;
  private final b b;

  public l(a<IRingtonePlayer> parama, b paramb)
  {
    this.a = parama;
    this.b = paramb;
  }

  public boolean a()
  {
    return (((IRingtonePlayer)this.a.get()).canPlaySound()) && (!this.b.a());
  }

  public boolean b()
  {
    return ((IRingtonePlayer)this.a.get()).canVibrate();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.i.l
 * JD-Core Version:    0.6.2
 */