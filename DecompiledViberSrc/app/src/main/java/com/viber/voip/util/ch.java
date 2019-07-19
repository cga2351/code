package com.viber.voip.util;

import com.viber.voip.messages.ui.media.player.MediaPlayer;
import com.viber.voip.messages.ui.media.player.MediaPlayerControls;

public final class ch
{
  public static int a(long paramLong1, long paramLong2)
  {
    boolean bool = paramLong1 < 0L;
    int i = 0;
    if (bool)
      i = (int)(0.5F + 100.0F * ((float)paramLong2 / (float)paramLong1));
    return Math.min(100, i);
  }

  public static long a(long paramLong, int paramInt)
  {
    return ()(0.5F + paramInt / 100.0F * (float)paramLong);
  }

  public static void a(MediaPlayer paramMediaPlayer, int paramInt)
  {
    long l = paramMediaPlayer.getDurationMillis();
    if (l > 0L)
      paramMediaPlayer.a(a(l, paramInt));
  }

  public static void a(MediaPlayerControls paramMediaPlayerControls, long paramLong1, long paramLong2)
  {
    if (paramLong1 > 0L)
      paramMediaPlayerControls.a(a(paramLong1, paramLong2), paramLong1, paramLong2);
  }

  public static boolean a(int paramInt)
  {
    return -1 != paramInt;
  }

  public static boolean a(int paramInt, boolean paramBoolean)
  {
    boolean bool;
    if ((3 == paramInt) || (4 == paramInt) || (5 == paramInt) || (6 == paramInt))
      bool = true;
    do
    {
      do
      {
        return bool;
        bool = false;
      }
      while (paramBoolean);
      if (1 == paramInt)
        break;
      bool = false;
    }
    while (2 != paramInt);
    return true;
  }

  public static boolean a(MediaPlayer paramMediaPlayer)
  {
    return paramMediaPlayer.getDurationMillis() <= 0L;
  }

  public static boolean b(int paramInt)
  {
    return a(paramInt, false);
  }

  public static boolean b(int paramInt, boolean paramBoolean)
  {
    if ((3 == paramInt) || (5 == paramInt));
    do
    {
      return true;
      if (paramBoolean)
        break;
    }
    while (1 == paramInt);
    return false;
    return false;
  }

  public static boolean c(int paramInt)
  {
    return b(paramInt, false);
  }

  public static boolean c(int paramInt, boolean paramBoolean)
  {
    boolean bool;
    if ((3 == paramInt) || (4 == paramInt) || (5 == paramInt) || (6 == paramInt) || (-1 == paramInt))
      bool = true;
    do
    {
      do
      {
        return bool;
        bool = false;
      }
      while (paramBoolean);
      if ((1 == paramInt) || (2 == paramInt))
        break;
      bool = false;
    }
    while (paramInt != 0);
    return true;
  }

  public static boolean d(int paramInt)
  {
    return c(paramInt, false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.ch
 * JD-Core Version:    0.6.2
 */