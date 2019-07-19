package com.viber.voip.backup;

import com.viber.common.b.d;
import com.viber.common.b.e;
import com.viber.common.b.h;
import com.viber.voip.k.a;
import com.viber.voip.settings.d.j;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

public class f
  implements a
{
  private static volatile f c;
  private final ReentrantReadWriteLock.ReadLock a;
  private final ReentrantReadWriteLock.WriteLock b;

  private f()
  {
    ReentrantReadWriteLock localReentrantReadWriteLock = new ReentrantReadWriteLock();
    this.a = localReentrantReadWriteLock.readLock();
    this.b = localReentrantReadWriteLock.writeLock();
  }

  public static f b()
  {
    if (c == null);
    try
    {
      if (c == null)
        c = new f();
      return c;
    }
    finally
    {
    }
  }

  private void f()
  {
    d.j.b.e();
    d.j.d.e();
    d.j.e.e();
    d.j.c.e();
    d.j.f.e();
  }

  public String a()
  {
    this.a.lock();
    try
    {
      String str = d.j.a.d();
      return str;
    }
    finally
    {
      this.a.unlock();
    }
  }

  public void a(BackupInfo paramBackupInfo)
  {
    this.b.lock();
    try
    {
      String str1 = d.j.a.d();
      String str2 = paramBackupInfo.getAccount();
      if ((str1 == null) && (str2 != null))
      {
        d.j.a.a(str2);
        if (paramBackupInfo.getDriveFileId() == null)
          break label141;
        if (d.j.d.d() < paramBackupInfo.getUpdateTime())
        {
          d.j.b.a(paramBackupInfo.getDriveFileId());
          d.j.d.a(paramBackupInfo.getUpdateTime());
          d.j.e.a(paramBackupInfo.getSize());
          d.j.f.a(paramBackupInfo.getMetaDataVersion());
        }
      }
      while (true)
      {
        d.j.c.a(System.currentTimeMillis());
        return;
        if (str2 != null)
        {
          boolean bool = str2.equals(str1);
          if (bool)
            break;
        }
        return;
        label141: d.j.b.e();
        d.j.d.e();
        d.j.e.e();
        d.j.f.e();
      }
    }
    finally
    {
      this.b.unlock();
    }
  }

  public void a(String paramString)
  {
    this.b.lock();
    try
    {
      String str = d.j.a.d();
      if ((str != null) && (!str.equals(paramString)))
        f();
      d.j.a.a(paramString);
      return;
    }
    finally
    {
      this.b.unlock();
    }
  }

  public void c()
  {
    this.b.lock();
    try
    {
      f();
      return;
    }
    finally
    {
      this.b.unlock();
    }
  }

  public long d()
  {
    this.a.lock();
    try
    {
      long l = d.j.c.d();
      return l;
    }
    finally
    {
      this.a.unlock();
    }
  }

  public BackupInfo e()
  {
    this.a.lock();
    try
    {
      BackupInfo localBackupInfo = new BackupInfo(d.j.a.d(), d.j.b.d(), d.j.d.d(), d.j.e.d(), d.j.f.d());
      return localBackupInfo;
    }
    finally
    {
      this.a.unlock();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.f
 * JD-Core Version:    0.6.2
 */