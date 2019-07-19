package com.viber.voip.phone.vptt;

import com.viber.voip.widget.d.a;

public abstract interface VideoPttPlayer
{
  public abstract void dispose();

  public abstract void restartUnmuted(Completion paramCompletion);

  public abstract void startVideoPttPlay(int paramInt, String paramString, a parama, boolean paramBoolean, Completion paramCompletion1, Completion paramCompletion2);

  public abstract void stopVideoPttPlay(Completion paramCompletion);

  public static abstract interface Completion
  {
    public abstract void onCompletion(Error paramError);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.vptt.VideoPttPlayer
 * JD-Core Version:    0.6.2
 */