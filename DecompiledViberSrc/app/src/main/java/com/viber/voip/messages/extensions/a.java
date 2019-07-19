package com.viber.voip.messages.extensions;

import android.support.v4.util.LongSparseArray;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class a
{
  private final ReadWriteLock a = new ReentrantReadWriteLock();
  private final LongSparseArray<a> b = new LongSparseArray();

  public a a(long paramLong)
  {
    Lock localLock = this.a.readLock();
    try
    {
      localLock.lock();
      a locala = (a)this.b.get(paramLong);
      return locala;
    }
    finally
    {
      localLock.unlock();
    }
  }

  public void a(long paramLong, String paramString1, String paramString2, boolean paramBoolean, BotReplyConfig paramBotReplyConfig)
  {
    Lock localLock = this.a.writeLock();
    try
    {
      localLock.lock();
      this.b.put(paramLong, new a(paramString1, paramString2, paramBoolean, paramBotReplyConfig));
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }

  public String b(long paramLong)
  {
    Lock localLock = this.a.readLock();
    try
    {
      localLock.lock();
      a locala = (a)this.b.get(paramLong);
      if (locala != null);
      for (String str = locala.a; ; str = null)
        return str;
    }
    finally
    {
      localLock.unlock();
    }
  }

  public boolean c(long paramLong)
  {
    Lock localLock = this.a.readLock();
    try
    {
      localLock.lock();
      int i = this.b.indexOfKey(paramLong);
      if (i >= 0)
      {
        bool = true;
        return bool;
      }
      boolean bool = false;
    }
    finally
    {
      localLock.unlock();
    }
  }

  public void d(long paramLong)
  {
    Lock localLock = this.a.writeLock();
    try
    {
      localLock.lock();
      this.b.remove(paramLong);
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }

  public static class a
  {
    public final String a;
    public final String b;
    public final boolean c;
    public final BotReplyConfig d;

    a(String paramString1, String paramString2, boolean paramBoolean, BotReplyConfig paramBotReplyConfig)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramBoolean;
      this.d = paramBotReplyConfig;
    }

    public String toString()
    {
      return "Entry{chatExUri='" + this.a + "',searchQuery='" + this.b + "',silentQuery=" + this.c + ",replyConfig=" + this.d + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.a
 * JD-Core Version:    0.6.2
 */