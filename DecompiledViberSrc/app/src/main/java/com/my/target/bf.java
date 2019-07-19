package com.my.target;

public class bf
{
  public static boolean a()
  {
    try
    {
      Class.forName("com.google.android.exoplayer2.j");
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      dp.a("ExoPlayer doesn't exist, add ExoPlayer dependency to play video");
    }
    return false;
  }

  public static boolean b()
  {
    try
    {
      Class.forName("com.google.android.exoplayer2.source.c.j$a");
      return true;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.bf
 * JD-Core Version:    0.6.2
 */