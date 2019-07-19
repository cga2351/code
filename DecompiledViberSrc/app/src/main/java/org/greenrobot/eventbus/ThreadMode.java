package org.greenrobot.eventbus;

public enum ThreadMode
{
  static
  {
    MAIN = new ThreadMode("MAIN", 1);
    MAIN_ORDERED = new ThreadMode("MAIN_ORDERED", 2);
    BACKGROUND = new ThreadMode("BACKGROUND", 3);
    ASYNC = new ThreadMode("ASYNC", 4);
    ThreadMode[] arrayOfThreadMode = new ThreadMode[5];
    arrayOfThreadMode[0] = POSTING;
    arrayOfThreadMode[1] = MAIN;
    arrayOfThreadMode[2] = MAIN_ORDERED;
    arrayOfThreadMode[3] = BACKGROUND;
    arrayOfThreadMode[4] = ASYNC;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.greenrobot.eventbus.ThreadMode
 * JD-Core Version:    0.6.2
 */