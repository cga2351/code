package com.google.android.exoplayer2.g;

public final class e
{
  private boolean a;

  public boolean a()
  {
    boolean bool1 = true;
    try
    {
      boolean bool2 = this.a;
      if (bool2)
        bool1 = false;
      while (true)
      {
        return bool1;
        this.a = true;
        notifyAll();
      }
    }
    finally
    {
    }
  }

  public boolean b()
  {
    try
    {
      boolean bool = this.a;
      this.a = false;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void c()
    throws InterruptedException
  {
    try
    {
      if (!this.a)
        wait();
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.g.e
 * JD-Core Version:    0.6.2
 */