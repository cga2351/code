package com.google.android.gms.internal.ads;

public final class zzsm
{
  private boolean isOpen;

  public final void block()
    throws InterruptedException
  {
    try
    {
      if (!this.isOpen)
        wait();
    }
    finally
    {
    }
  }

  public final boolean zzjx()
  {
    boolean bool1 = true;
    try
    {
      boolean bool2 = this.isOpen;
      if (bool2)
        bool1 = false;
      while (true)
      {
        return bool1;
        this.isOpen = true;
        notifyAll();
      }
    }
    finally
    {
    }
  }

  public final boolean zzjy()
  {
    try
    {
      boolean bool = this.isOpen;
      this.isOpen = false;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzsm
 * JD-Core Version:    0.6.2
 */