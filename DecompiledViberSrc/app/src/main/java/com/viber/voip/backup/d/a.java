package com.viber.voip.backup.d;

import android.database.Cursor;
import com.viber.dexshared.Logger;
import com.viber.jni.backup.BackupEntity;
import com.viber.provider.b;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.backup.d.a.a.c;
import com.viber.voip.backup.o;
import com.viber.voip.messages.orm.entity.impl.MessageEntityHelper;
import com.viber.voip.util.af;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

abstract class a<T extends BackupEntity>
  implements com.viber.voip.backup.d
{
  private static final Logger c = ViberEnv.getLogger();
  protected List<c> a;
  protected List<com.viber.voip.backup.d.a.a.a> b;
  private final Class<T> d;
  private volatile boolean e;
  private volatile CountDownLatch f;
  private final o g;
  private a<T>.a h;
  private BlockingQueue<T[]> i = new ArrayBlockingQueue(3);

  public a(Class<T> paramClass, o paramo)
  {
    this.g = paramo;
    this.d = paramClass;
  }

  private void a(int paramInt)
  {
    this.g.a(paramInt);
  }

  // ERROR //
  private void b(Cursor paramCursor)
    throws com.viber.voip.backup.c.d
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +4 -> 5
    //   4: return
    //   5: aload_1
    //   6: invokeinterface 75 1 0
    //   11: ifeq -7 -> 4
    //   14: iconst_0
    //   15: istore_3
    //   16: new 77	java/util/ArrayList
    //   19: dup
    //   20: sipush 500
    //   23: invokespecial 78	java/util/ArrayList:<init>	(I)V
    //   26: astore 4
    //   28: aload_0
    //   29: aload_1
    //   30: invokevirtual 81	com/viber/voip/backup/d/a:a	(Landroid/database/Cursor;)Lcom/viber/jni/backup/BackupEntity;
    //   33: astore 7
    //   35: aload_0
    //   36: getfield 61	com/viber/voip/backup/d/a:e	Z
    //   39: ifeq +102 -> 141
    //   42: new 83	com/viber/voip/backup/c/b
    //   45: dup
    //   46: invokespecial 84	com/viber/voip/backup/c/b:<init>	()V
    //   49: athrow
    //   50: astore_2
    //   51: new 83	com/viber/voip/backup/c/b
    //   54: dup
    //   55: invokespecial 84	com/viber/voip/backup/c/b:<init>	()V
    //   58: athrow
    //   59: astore 5
    //   61: iload_3
    //   62: iconst_1
    //   63: iadd
    //   64: istore 6
    //   66: iload_3
    //   67: iconst_5
    //   68: if_icmplt +129 -> 197
    //   71: aload 4
    //   73: invokevirtual 87	java/util/ArrayList:isEmpty	()Z
    //   76: ifne +9 -> 85
    //   79: aload_0
    //   80: aload 4
    //   82: invokespecial 90	com/viber/voip/backup/d/a:c	(Ljava/util/List;)V
    //   85: aload_0
    //   86: new 92	java/util/concurrent/CountDownLatch
    //   89: dup
    //   90: iconst_1
    //   91: invokespecial 93	java/util/concurrent/CountDownLatch:<init>	(I)V
    //   94: putfield 95	com/viber/voip/backup/d/a:f	Ljava/util/concurrent/CountDownLatch;
    //   97: aload_0
    //   98: invokestatic 101	java/util/Collections:emptyList	()Ljava/util/List;
    //   101: invokespecial 90	com/viber/voip/backup/d/a:c	(Ljava/util/List;)V
    //   104: aload_0
    //   105: getfield 95	com/viber/voip/backup/d/a:f	Ljava/util/concurrent/CountDownLatch;
    //   108: invokevirtual 104	java/util/concurrent/CountDownLatch:await	()V
    //   111: aload_0
    //   112: getfield 106	com/viber/voip/backup/d/a:h	Lcom/viber/voip/backup/d/a$a;
    //   115: invokestatic 111	com/viber/voip/backup/d/a$a:a	(Lcom/viber/voip/backup/d/a$a;)Lcom/viber/voip/backup/c/d;
    //   118: ifnull -114 -> 4
    //   121: aload_0
    //   122: getfield 106	com/viber/voip/backup/d/a:h	Lcom/viber/voip/backup/d/a$a;
    //   125: invokestatic 111	com/viber/voip/backup/d/a$a:a	(Lcom/viber/voip/backup/d/a$a;)Lcom/viber/voip/backup/c/d;
    //   128: athrow
    //   129: aload_1
    //   130: invokeinterface 114 1 0
    //   135: ifne -107 -> 28
    //   138: goto -67 -> 71
    //   141: aload 4
    //   143: aload 7
    //   145: invokevirtual 118	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   148: pop
    //   149: aload 4
    //   151: invokevirtual 122	java/util/ArrayList:size	()I
    //   154: sipush 500
    //   157: if_icmpne +32 -> 189
    //   160: aload_0
    //   161: getfield 106	com/viber/voip/backup/d/a:h	Lcom/viber/voip/backup/d/a$a;
    //   164: invokestatic 111	com/viber/voip/backup/d/a$a:a	(Lcom/viber/voip/backup/d/a$a;)Lcom/viber/voip/backup/c/d;
    //   167: ifnull +11 -> 178
    //   170: aload_0
    //   171: getfield 106	com/viber/voip/backup/d/a:h	Lcom/viber/voip/backup/d/a$a;
    //   174: invokestatic 111	com/viber/voip/backup/d/a$a:a	(Lcom/viber/voip/backup/d/a$a;)Lcom/viber/voip/backup/c/d;
    //   177: athrow
    //   178: aload_0
    //   179: aload 4
    //   181: invokespecial 90	com/viber/voip/backup/d/a:c	(Ljava/util/List;)V
    //   184: aload 4
    //   186: invokevirtual 125	java/util/ArrayList:clear	()V
    //   189: aload_0
    //   190: iconst_1
    //   191: invokespecial 126	com/viber/voip/backup/d/a:a	(I)V
    //   194: goto -65 -> 129
    //   197: iload 6
    //   199: istore_3
    //   200: goto -71 -> 129
    //
    // Exception table:
    //   from	to	target	type
    //   5	14	50	java/lang/InterruptedException
    //   16	28	50	java/lang/InterruptedException
    //   28	35	50	java/lang/InterruptedException
    //   35	50	50	java/lang/InterruptedException
    //   71	85	50	java/lang/InterruptedException
    //   85	129	50	java/lang/InterruptedException
    //   129	138	50	java/lang/InterruptedException
    //   141	178	50	java/lang/InterruptedException
    //   178	189	50	java/lang/InterruptedException
    //   189	194	50	java/lang/InterruptedException
    //   28	35	59	java/lang/IllegalStateException
  }

  private void c(List<T> paramList)
    throws InterruptedException
  {
    BackupEntity[] arrayOfBackupEntity = (BackupEntity[])Array.newInstance(this.d, paramList.size());
    this.i.put(paramList.toArray(arrayOfBackupEntity));
  }

  private String[] g()
  {
    String[] arrayOfString1 = d();
    ArrayList localArrayList = new ArrayList(MessageEntityHelper.PROJECTIONS.length + arrayOfString1.length);
    for (String str : com.viber.voip.model.entity.u.a)
      localArrayList.add("messages." + str);
    Collections.addAll(localArrayList, arrayOfString1);
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }

  private Cursor h()
  {
    b localb = b();
    String[] arrayOfString = g();
    StringBuilder localStringBuilder = new StringBuilder(1200);
    localStringBuilder.append("SELECT ");
    com.viber.voip.s.a.a(arrayOfString, localStringBuilder);
    return localb.a(4194304, a(localStringBuilder).toString(), null);
  }

  protected abstract T a(Cursor paramCursor);

  StringBuilder a(StringBuilder paramStringBuilder)
  {
    StringBuilder localStringBuilder = e();
    paramStringBuilder.append(" FROM ").append(c());
    if (localStringBuilder.length() > 0)
    {
      paramStringBuilder.append(" WHERE ").append(localStringBuilder);
      a(paramStringBuilder, false);
    }
    while (true)
    {
      b(paramStringBuilder, true);
      return paramStringBuilder;
      a(paramStringBuilder, true);
    }
  }

  public void a()
  {
    this.e = true;
  }

  void a(e parame)
    throws com.viber.voip.backup.c.d
  {
    b(parame);
    if (this.e)
      return;
    Cursor localCursor = null;
    try
    {
      localCursor = h();
      this.h = new a(parame);
      new Thread(this.h, "writeBackupThread").start();
      b(localCursor);
      return;
    }
    catch (Exception localException)
    {
      throw new com.viber.voip.backup.c.d("Select data error", localException);
    }
    finally
    {
      af.a(localCursor);
    }
  }

  protected abstract void a(e parame, T[] paramArrayOfT)
    throws com.viber.voip.backup.c.d;

  protected void a(StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    if (!com.viber.voip.util.u.a(this.a))
    {
      if (paramBoolean)
        paramStringBuilder.append(" WHERE ");
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
        ((c)localIterator.next()).a(paramStringBuilder);
    }
  }

  public void a(List<c> paramList)
  {
    if (paramList != null)
    {
      if (this.a == null)
        this.a = new ArrayList(paramList);
    }
    else
      return;
    this.a.addAll(paramList);
  }

  protected b b()
  {
    return com.viber.provider.messages.b.d.a(ViberApplication.getApplication());
  }

  protected abstract void b(e parame)
    throws com.viber.voip.backup.c.d;

  protected void b(StringBuilder paramStringBuilder, boolean paramBoolean)
  {
    if (!com.viber.voip.util.u.a(this.b))
    {
      if (paramBoolean)
        paramStringBuilder.append(" ORDER BY ");
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
        ((com.viber.voip.backup.d.a.a.a)localIterator.next()).a(paramStringBuilder);
    }
  }

  public void b(List<com.viber.voip.backup.d.a.a.a> paramList)
  {
    if (paramList != null)
    {
      if (this.b == null)
        this.b = new ArrayList(paramList);
    }
    else
      return;
    this.b.addAll(paramList);
  }

  protected abstract String c();

  protected abstract String[] d();

  protected abstract StringBuilder e();

  public int f()
  {
    b localb = b();
    StringBuilder localStringBuilder = new StringBuilder(750);
    localStringBuilder.append("SELECT COUNT(*)");
    return (int)localb.a(localb.b(a(localStringBuilder).toString()));
  }

  public class a
    implements Runnable
  {
    private e b;
    private volatile com.viber.voip.backup.c.d c;

    public a(e arg2)
    {
      Object localObject;
      this.b = localObject;
    }

    public void run()
    {
      try
      {
        while (true)
        {
          boolean bool = a.a(a.this);
          if (bool)
            return;
          BackupEntity[] arrayOfBackupEntity = (BackupEntity[])a.b(a.this).take();
          if (arrayOfBackupEntity != null)
          {
            int i = arrayOfBackupEntity.length;
            if (i > 0);
          }
          else
          {
            return;
          }
          a.this.a(this.b, arrayOfBackupEntity);
        }
      }
      catch (InterruptedException localInterruptedException)
      {
      }
      catch (com.viber.voip.backup.c.d locald)
      {
        this.c = locald;
        return;
      }
      finally
      {
        if (a.c(a.this) != null)
          a.c(a.this).countDown();
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.d.a
 * JD-Core Version:    0.6.2
 */