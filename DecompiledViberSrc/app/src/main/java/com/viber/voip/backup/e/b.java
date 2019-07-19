package com.viber.voip.backup.e;

import com.viber.jni.backup.BackupEntity;
import com.viber.jni.backup.BackupHeader;
import com.viber.jni.backup.BackupReader;
import com.viber.jni.backup.GroupMessageBackupEntity;
import com.viber.jni.backup.MessageBackupEntity;
import com.viber.voip.backup.c.d;
import com.viber.voip.backup.m;
import java.util.ArrayList;
import java.util.Iterator;

public class b extends BackupReader
  implements m
{
  private long a;
  private final BackupHeader b;

  public b(String paramString)
    throws d
  {
    this.a = nativeCreate(paramString);
    if (this.a == 0L)
      throw new d("Error initializing backup from " + paramString);
    this.b = nativeReadImportHeader(this.a);
  }

  public void a()
  {
    if (this.a != 0L)
    {
      nativeDestroy(this.a);
      this.a = 0L;
    }
  }

  public BackupHeader b()
    throws d
  {
    return this.b;
  }

  public Iterable<MessageBackupEntity> c()
  {
    nativeStartImportingMessages(this.a);
    return new Iterable()
    {
      public Iterator<MessageBackupEntity> iterator()
      {
        return new b.c(b.a(b.this), b.b(b.this));
      }
    };
  }

  public Iterable<GroupMessageBackupEntity> d()
  {
    nativeStartImportingGroupMessages(this.a);
    return new Iterable()
    {
      public Iterator<GroupMessageBackupEntity> iterator()
      {
        return new b.b(b.a(b.this), b.b(b.this));
      }
    };
  }

  public void finalize()
    throws Throwable
  {
    a();
    super.finalize();
  }

  public static abstract class a<ENTITY extends BackupEntity>
    implements Iterator<ENTITY>
  {
    final ArrayList<ENTITY> a = new ArrayList(2000);
    int b = 0;
    int c;

    public a(int paramInt)
    {
      this.c = paramInt;
    }

    public ENTITY a()
    {
      ArrayList localArrayList = this.a;
      int i = this.b;
      this.b = (i + 1);
      return (BackupEntity)localArrayList.get(i);
    }

    protected abstract void a(ArrayList<ENTITY> paramArrayList, int paramInt);

    public boolean hasNext()
    {
      if (this.b >= this.a.size())
      {
        this.b = 0;
        this.a.clear();
        if (this.c == 0);
        do
        {
          return false;
          int i = Math.min(2000, this.c);
          a(this.a, i);
          this.c -= this.a.size();
        }
        while (this.a.size() == 0);
      }
      return true;
    }

    public void remove()
    {
      throw new UnsupportedOperationException("unsupported");
    }
  }

  private static class b extends b.a<GroupMessageBackupEntity>
  {
    private final long d;

    b(BackupHeader paramBackupHeader, long paramLong)
    {
      super();
      this.d = paramLong;
    }

    protected void a(ArrayList<GroupMessageBackupEntity> paramArrayList, int paramInt)
    {
      b.b(this.d, paramArrayList, paramInt);
    }
  }

  private static class c extends b.a<MessageBackupEntity>
  {
    private final long d;

    c(BackupHeader paramBackupHeader, long paramLong)
    {
      super();
      this.d = paramLong;
    }

    protected void a(ArrayList<MessageBackupEntity> paramArrayList, int paramInt)
    {
      b.a(this.d, paramArrayList, paramInt);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.e.b
 * JD-Core Version:    0.6.2
 */