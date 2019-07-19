package com.google.android.exoplayer2.g;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

final class ab
  implements k
{
  private final Handler a;

  public ab(Handler paramHandler)
  {
    this.a = paramHandler;
  }

  public Looper a()
  {
    return this.a.getLooper();
  }

  public Message a(int paramInt1, int paramInt2, int paramInt3)
  {
    return this.a.obtainMessage(paramInt1, paramInt2, paramInt3);
  }

  public Message a(int paramInt1, int paramInt2, int paramInt3, Object paramObject)
  {
    return this.a.obtainMessage(paramInt1, paramInt2, paramInt3, paramObject);
  }

  public Message a(int paramInt, Object paramObject)
  {
    return this.a.obtainMessage(paramInt, paramObject);
  }

  public boolean a(int paramInt)
  {
    return this.a.sendEmptyMessage(paramInt);
  }

  public boolean a(int paramInt, long paramLong)
  {
    return this.a.sendEmptyMessageAtTime(paramInt, paramLong);
  }

  public void b(int paramInt)
  {
    this.a.removeMessages(paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.g.ab
 * JD-Core Version:    0.6.2
 */