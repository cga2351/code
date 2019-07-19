package com.viber.voip.util;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.IBinder;
import android.os.RemoteException;
import com.viber.common.app.a;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.VideoConverterPreparedRequest;
import com.viber.voip.VideoConverterReply;
import com.viber.voip.VideoConverterReply.a;
import com.viber.voip.VideoConverterRequest;
import com.viber.voip.ag;
import com.viber.voip.ag.a;
import com.viber.voip.ah.a;
import com.viber.voip.settings.d.ad;
import com.viber.voip.videoconvert.VideoConverterService;
import java.io.File;
import java.io.FileFilter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class dy
  implements ServiceConnection
{
  private static final Logger a = ViberEnv.getLogger();
  private static dy b;
  private Context c;
  private ag d;
  private Map<String, b> e;
  private ah.a f = new ah.a()
  {
    public void a(VideoConverterPreparedRequest paramAnonymousVideoConverterPreparedRequest)
      throws RemoteException
    {
    }

    public void a(VideoConverterPreparedRequest paramAnonymousVideoConverterPreparedRequest, int paramAnonymousInt)
      throws RemoteException
    {
    }

    public void a(VideoConverterPreparedRequest paramAnonymousVideoConverterPreparedRequest, VideoConverterReply paramAnonymousVideoConverterReply)
      throws RemoteException
    {
      dy.a(dy.this, paramAnonymousVideoConverterPreparedRequest.request().source().getPath());
    }

    public void a(VideoConverterPreparedRequest paramAnonymousVideoConverterPreparedRequest, String paramAnonymousString)
      throws RemoteException
    {
      dy.b().a(new RuntimeException("mBackgroundProgressCallback got message to be delivered to VideoConverter developers"), paramAnonymousVideoConverterPreparedRequest + "\n" + paramAnonymousString);
    }
  };
  private ah.a g = new ah.a()
  {
    public void a(VideoConverterPreparedRequest paramAnonymousVideoConverterPreparedRequest)
      throws RemoteException
    {
    }

    public void a(VideoConverterPreparedRequest paramAnonymousVideoConverterPreparedRequest, int paramAnonymousInt)
      throws RemoteException
    {
    }

    public void a(VideoConverterPreparedRequest paramAnonymousVideoConverterPreparedRequest, VideoConverterReply paramAnonymousVideoConverterReply)
      throws RemoteException
    {
      dy.b localb = dy.a(dy.this, paramAnonymousVideoConverterPreparedRequest.request().source().getPath());
      if (localb != null)
      {
        if (paramAnonymousVideoConverterReply.status() == VideoConverterReply.a.b)
          localb.a("Failed to convert");
      }
      else
        return;
      if (paramAnonymousVideoConverterReply.status() == VideoConverterReply.a.c)
      {
        localb.d();
        return;
      }
      localb.a(paramAnonymousVideoConverterReply.fileToUse());
    }

    public void a(VideoConverterPreparedRequest paramAnonymousVideoConverterPreparedRequest, String paramAnonymousString)
    {
      dy.b().a(new RuntimeException("got message to be delivered to VideoConverter developers"), paramAnonymousVideoConverterPreparedRequest + "\n" + paramAnonymousString);
    }
  };

  private dy(Context paramContext)
  {
    this.c = paramContext;
    this.e = new HashMap();
  }

  private b a(String paramString)
  {
    synchronized (this.e)
    {
      b localb = (b)this.e.get(paramString);
      this.e.remove(paramString);
      if (this.e.isEmpty())
      {
        e();
        this.d = null;
      }
      return localb;
    }
  }

  public static dy a()
  {
    try
    {
      if (b == null)
        b = new dy(ViberApplication.getApplication());
      dy localdy = b;
      return localdy;
    }
    finally
    {
    }
  }

  private static File a(File paramFile, Context paramContext)
  {
    String str1 = paramFile.getName();
    int i = str1.lastIndexOf('.');
    if (i != -1)
      str1 = str1.substring(0, i);
    String str2 = str1 + "_" + paramFile.length();
    String str3 = str2 + "_" + paramFile.lastModified();
    return dv.I.b(paramContext, str3, false);
  }

  private Map<String, Boolean> a(List<Uri> paramList, IBinder paramIBinder)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Uri localUri = (Uri)localIterator.next();
      File localFile = at.a(this.c, localUri);
      if (localFile == null)
      {
        localHashMap.put(localUri.getPath(), Boolean.valueOf(false));
      }
      else
      {
        c();
        VideoConverterRequest localVideoConverterRequest = new VideoConverterRequest(Uri.fromFile(localFile), Uri.fromFile(a(localFile, this.c)), 50000000L, d.ad.H.d());
        if (paramIBinder == null);
        while (true)
        {
          try
          {
            localVideoConverterPreparedRequest = this.d.a(localVideoConverterRequest);
            switch (5.a[localVideoConverterPreparedRequest.forecast().ordinal()])
            {
            default:
              localHashMap.put(localUri.getPath(), Boolean.valueOf(false));
            case 1:
            }
          }
          catch (RemoteException localRemoteException)
          {
            localHashMap.put(localUri.getPath(), Boolean.valueOf(false));
          }
          break;
          VideoConverterPreparedRequest localVideoConverterPreparedRequest = ag.a.a(paramIBinder).a(localVideoConverterRequest);
        }
        localHashMap.put(localUri.getPath(), Boolean.valueOf(true));
      }
    }
    return localHashMap;
  }

  private void a(b paramb)
  {
    VideoConverterRequest localVideoConverterRequest = new VideoConverterRequest(paramb.b(), paramb.c(), 25000000L, d.ad.H.d());
    VideoConverterPreparedRequest localVideoConverterPreparedRequest;
    try
    {
      localVideoConverterPreparedRequest = this.d.a(localVideoConverterRequest);
      switch (5.a[localVideoConverterPreparedRequest.forecast().ordinal()])
      {
      case 1:
        this.d.a(localVideoConverterPreparedRequest, this.g);
        paramb.a(localVideoConverterPreparedRequest);
        return;
      case 2:
      case 3:
      }
    }
    catch (Exception localException)
    {
      a(paramb.b().getPath());
      paramb.a("Failed to post action");
      return;
    }
    this.d.a(localVideoConverterPreparedRequest, this.f);
    paramb.a(localVideoConverterPreparedRequest);
    paramb.a("Let's try to convert video in background as it can be dangerous");
    return;
    a(paramb.b().getPath());
    paramb.a("Definitely bad idea to convert, abort");
  }

  public static File b(Uri paramUri)
  {
    Application localApplication = ViberApplication.getApplication();
    File localFile1 = at.a(localApplication, paramUri);
    if (localFile1 == null)
      localFile1 = new File(paramUri.getPath());
    File localFile2;
    do
    {
      return localFile1;
      localFile2 = a(localFile1, localApplication);
    }
    while (localFile2.getParent().equals(localFile1.getParent()));
    return localFile2;
  }

  private void b(final List<Uri> paramList, final a parama)
  {
    final Intent localIntent = new Intent(this.c, VideoConverterService.class);
    ServiceConnection local1 = new ServiceConnection()
    {
      public void onServiceConnected(ComponentName paramAnonymousComponentName, IBinder paramAnonymousIBinder)
      {
        if (parama != null)
          parama.a(dy.a(dy.this, paramList, paramAnonymousIBinder));
        dy.a(dy.this).unbindService(this);
        dy.a(dy.this).stopService(localIntent);
      }

      public void onServiceDisconnected(ComponentName paramAnonymousComponentName)
      {
      }
    };
    if ((!a.a(this.c, localIntent, local1, 1)) && (parama != null))
    {
      HashMap localHashMap = new HashMap();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
        localHashMap.put(((Uri)localIterator.next()).getPath(), Boolean.valueOf(false));
      parama.a(localHashMap);
    }
  }

  private b c(Uri paramUri)
  {
    synchronized (this.e)
    {
      b localb = (b)this.e.get(paramUri.getPath());
      return localb;
    }
  }

  private boolean c()
  {
    int i = 0;
    File localFile = dv.I.a(this.c);
    if (!localFile.exists());
    File[] arrayOfFile;
    do
    {
      return false;
      arrayOfFile = localFile.listFiles(new FileFilter()
      {
        public boolean accept(File paramAnonymousFile)
        {
          return (paramAnonymousFile.getPath().endsWith(as.d.a())) && (System.currentTimeMillis() - paramAnonymousFile.lastModified() > 604800000L);
        }
      });
    }
    while (arrayOfFile == null);
    int j = arrayOfFile.length;
    while (i < j)
    {
      at.f(arrayOfFile[i]);
      i++;
    }
    return true;
  }

  private void d()
  {
    Intent localIntent = new Intent(this.c, VideoConverterService.class);
    if (!a.a(this.c, localIntent, this, 1))
    {
      Iterator localIterator = f().iterator();
      while (localIterator.hasNext())
        ((b)localIterator.next()).a("Failed to bind service");
      g();
    }
  }

  private void e()
  {
    this.c.unbindService(this);
    this.c.stopService(new Intent(this.c, VideoConverterService.class));
  }

  private Set<b> f()
  {
    synchronized (this.e)
    {
      HashSet localHashSet = new HashSet(this.e.values());
      return localHashSet;
    }
  }

  private void g()
  {
    synchronized (this.e)
    {
      this.e.clear();
      return;
    }
  }

  public void a(Uri paramUri)
  {
    if (paramUri != null)
    {
      File localFile1 = at.a(this.c, paramUri);
      if (localFile1 != null)
      {
        b localb = c(Uri.fromFile(localFile1));
        if ((localb != null) && (localb.a() != null) && (this.d != null))
          try
          {
            synchronized (this.d)
            {
              this.d.a(localb.a());
              File localFile2 = b(paramUri);
              if ((localFile2 != null) && (localFile2.exists()))
                localFile2.delete();
              label91: return;
            }
          }
          catch (RemoteException localRemoteException)
          {
            break label91;
          }
      }
    }
  }

  public void a(Uri paramUri, dy.b.a parama)
  {
    File localFile1 = at.a(this.c, paramUri);
    if (localFile1 == null)
      if (parama != null)
        parama.a("File is empty");
    Uri localUri1;
    Uri localUri2;
    do
    {
      File localFile2;
      do
      {
        return;
        localUri1 = Uri.fromFile(localFile1);
        synchronized (this.e)
        {
          b localb1 = (b)this.e.get(localUri1.getPath());
          if (localb1 != null)
          {
            localb1.a(parama);
            return;
          }
        }
        c();
        localFile2 = a(localFile1, this.c);
        if (localFile2 != null)
          break;
      }
      while (parama == null);
      parama.a("SDCard is not mounted");
      return;
      localUri2 = Uri.fromFile(localFile2);
      if (!localFile2.exists())
        break;
    }
    while (parama == null);
    parama.a(localUri1, localUri2);
    return;
    b localb2 = new b(localUri1, localUri2, parama);
    synchronized (this.e)
    {
      this.e.put(localUri1.getPath(), localb2);
      if (this.d == null)
      {
        d();
        return;
      }
    }
    a(localb2);
  }

  public void a(List<Uri> paramList, a parama)
  {
    if (this.d == null)
      b(paramList, parama);
    while (parama == null)
      return;
    parama.a(a(paramList, null));
  }

  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    this.d = ag.a.a(paramIBinder);
    Iterator localIterator = f().iterator();
    while (localIterator.hasNext())
      a((b)localIterator.next());
  }

  public void onServiceDisconnected(ComponentName paramComponentName)
  {
    this.d = null;
    Iterator localIterator = f().iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).a("Service disconnected while still there were tasks in the queue");
    g();
  }

  public static abstract interface a
  {
    public abstract void a(Map<String, Boolean> paramMap);
  }

  public static class b
  {
    private CopyOnWriteArrayList<a> a = new CopyOnWriteArrayList();
    private Uri b;
    private Uri c;
    private VideoConverterPreparedRequest d;

    public b(Uri paramUri1, Uri paramUri2, a parama)
    {
      this.b = paramUri1;
      this.c = paramUri2;
      a(parama);
    }

    public VideoConverterPreparedRequest a()
    {
      return this.d;
    }

    public void a(Uri paramUri)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
        ((a)localIterator.next()).a(this.b, paramUri);
    }

    public void a(VideoConverterPreparedRequest paramVideoConverterPreparedRequest)
    {
      this.d = paramVideoConverterPreparedRequest;
    }

    public void a(a parama)
    {
      if (parama != null)
        this.a.addIfAbsent(parama);
    }

    public void a(String paramString)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
        ((a)localIterator.next()).a(paramString);
    }

    public Uri b()
    {
      return this.b;
    }

    public Uri c()
    {
      return this.c;
    }

    public void d()
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
        ((a)localIterator.next()).a(this.b);
    }

    public static abstract interface a
    {
      public abstract void a(Uri paramUri);

      public abstract void a(Uri paramUri1, Uri paramUri2);

      public abstract void a(String paramString);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.dy
 * JD-Core Version:    0.6.2
 */