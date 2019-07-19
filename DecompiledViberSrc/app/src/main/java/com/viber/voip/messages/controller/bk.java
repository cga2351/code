package com.viber.voip.messages.controller;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.viber.common.b.b;
import com.viber.common.d.i;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.l.a;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.secure.SecureMessagesController;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.e.a.e;
import com.viber.voip.i.c.m;
import com.viber.voip.i.f;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.model.entity.h;
import com.viber.voip.settings.d.af;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.ab;
import com.viber.voip.ui.dialogs.k;
import com.viber.voip.util.at;
import com.viber.voip.util.cj;
import com.viber.voip.util.dv;
import com.viber.voip.util.upload.a;
import com.viber.voip.util.upload.n.a;
import com.viber.voip.util.upload.q;
import com.viber.voip.util.upload.r;
import com.viber.voip.util.upload.s;
import com.viber.voip.util.upload.s.d;
import com.viber.voip.util.upload.t;
import com.viber.voip.util.upload.t.c;
import java.io.File;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class bk
{
  private static final Logger b = ViberEnv.getLogger();
  protected ab a;
  private Context c;
  private Handler d;
  private com.viber.voip.messages.controller.manager.o e;

  public bk(Context paramContext, Handler paramHandler, com.viber.voip.messages.controller.manager.o paramo, ab paramab)
  {
    this.c = paramContext;
    this.d = paramHandler;
    this.e = paramo;
    this.a = paramab;
  }

  public static boolean a(Context paramContext)
  {
    cj localcj = cj.a(paramContext);
    boolean bool1 = d.af.b.d();
    if ((localcj.a() == 1) && (bool1));
    boolean bool2;
    do
    {
      return true;
      bool2 = d.af.a.d();
    }
    while ((localcj.a() == 0) && (bool2));
    return false;
  }

  public static boolean a(Context paramContext, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (((paramBoolean1) && (paramBoolean2)) || (paramLong > 25165824L))
      return false;
    cj localcj = cj.a(paramContext);
    boolean bool1 = d.af.b.d();
    if ((localcj.a() == 1) && (bool1))
      return true;
    if (localcj.a() == 0);
    for (int i = 1; ; i = 0)
    {
      boolean bool2 = d.af.c.d();
      if ((i != 0) && (bool2))
        break;
      boolean bool3 = c.m.a.e();
      if ((i != 0) && (bool3))
        break;
      boolean bool4 = d.af.a.d();
      if ((i == 0) || (!bool4))
        break;
      return true;
    }
  }

  public static boolean a(MessageEntity paramMessageEntity)
  {
    boolean bool = true;
    if ((paramMessageEntity.isPublicGroupBehavior()) || (paramMessageEntity.isAudioPtt()))
      bool = false;
    while (paramMessageEntity.isBroadcastList())
      return bool;
    if (paramMessageEntity.isGroupBehavior())
      return ViberApplication.getInstance().getEngine(bool).getSecureMessagesController().isGroupSecure(paramMessageEntity.getGroupId());
    h localh = ab.b().a(paramMessageEntity.getMemberId(), paramMessageEntity.isSecretMessage());
    if (localh != null)
      return localh.i(14);
    return false;
  }

  public static boolean a(MessageEntity paramMessageEntity, Context paramContext)
  {
    if (paramMessageEntity.needForceDownloadMedia());
    do
    {
      return true;
      if ((paramMessageEntity.isPublicGroupBehavior()) || (paramMessageEntity.isHiddenChat()))
        return false;
      if (paramMessageEntity.getExtraStatus() != 4)
        return false;
    }
    while ((paramMessageEntity.isAudioPtt()) || (paramMessageEntity.isVoiceMessage()) || (((paramMessageEntity.isImage()) || (paramMessageEntity.isVideoPttBehavior())) && (b(paramMessageEntity, paramContext)) && (a(paramContext))));
    return false;
  }

  private static void b(int paramInt, Uri paramUri)
  {
    if (3 == paramInt)
      com.viber.voip.util.upload.o.a(paramUri);
    while (1 != paramInt)
      return;
    com.viber.voip.util.upload.o.b(paramUri);
  }

  public static boolean b(Context paramContext)
  {
    return (cj.a(paramContext).a() != 0) || (!d.af.c.d());
  }

  public static boolean b(MessageEntity paramMessageEntity, Context paramContext)
  {
    if (paramMessageEntity == null);
    com.viber.common.permission.c localc;
    do
    {
      return false;
      localc = com.viber.common.permission.c.a(paramContext);
    }
    while (((paramMessageEntity.isImage()) || (paramMessageEntity.isVideo())) && (!localc.a(com.viber.voip.permissions.n.m)));
    return true;
  }

  public void a()
  {
    i.a();
    File localFile1 = dv.p.a(this.c);
    String[] arrayOfString = localFile1.list();
    if (arrayOfString == null);
    while (true)
    {
      return;
      List localList = this.a.m();
      HashSet localHashSet = new HashSet();
      int i = arrayOfString.length;
      for (int j = 0; j < i; j++)
      {
        String str = arrayOfString[j];
        if (!str.contains("nomedia"))
          localHashSet.add(str);
      }
      Iterator localIterator1 = localList.iterator();
      if (localIterator1.hasNext())
      {
        MessageEntity localMessageEntity = (MessageEntity)localIterator1.next();
        File localFile3;
        if (!TextUtils.isEmpty(localMessageEntity.getMediaUri()))
        {
          localFile3 = new File(Uri.parse(localMessageEntity.getMediaUri()).getPath());
          label151: if (localMessageEntity.getThumbnailUri() == null)
            break label339;
        }
        label339: for (File localFile4 = new File(localMessageEntity.getThumbnailUri().getPath()); ; localFile4 = null)
        {
          int k = 0;
          if (localFile3 != null)
          {
            boolean bool = System.currentTimeMillis() - localFile3.lastModified() < 86400000L;
            k = 0;
            if (!bool)
            {
              at.d(ViberApplication.getApplication(), Uri.parse(localMessageEntity.getMediaUri()));
              localMessageEntity.setExtraStatus(4);
              localMessageEntity.setMediaUri(null);
              k = 1;
            }
          }
          if ((localFile4 != null) && (System.currentTimeMillis() - localFile4.lastModified() >= 86400000L))
          {
            at.d(ViberApplication.getApplication(), localMessageEntity.getThumbnailUri());
            localMessageEntity.setBody(null);
            k = 1;
          }
          if (k != 0)
            this.a.b(localMessageEntity);
          if (localFile3 != null)
            localHashSet.remove(localFile3.getName());
          if (localFile4 == null)
            break;
          localHashSet.remove(localFile4.getName());
          break;
          localFile3 = null;
          break label151;
        }
      }
      Iterator localIterator2 = localHashSet.iterator();
      while (localIterator2.hasNext())
      {
        File localFile2 = new File(localFile1, (String)localIterator2.next());
        if (System.currentTimeMillis() - localFile2.lastModified() >= 86400000L)
          at.f(localFile2);
      }
    }
  }

  public void a(long paramLong)
  {
    ViberDialogHandlers.ab localab = new ViberDialogHandlers.ab();
    localab.a = paramLong;
    k.a().a(localab).d();
  }

  public void a(final MessageEntity paramMessageEntity, Uri paramUri, final boolean paramBoolean, final c paramc)
  {
    e.b().a("MEDIA", "media upload", paramMessageEntity.getMessageSeq());
    t.a(paramMessageEntity, paramUri, new q()
    {
      public void a(Uri paramAnonymousUri, final r paramAnonymousr)
      {
        bk.a(bk.this).post(new Runnable()
        {
          public void run()
          {
            e.b().b("MEDIA", "media upload", bk.1.this.a.getMessageSeq());
            e.b().a("SEND_MESSAGE", "total", "onUploadComplete", bk.1.this.a.getMessageSeq());
            bk.1.this.b.a(bk.1.this.a, paramAnonymousr);
          }
        });
      }

      public void a(Uri paramAnonymousUri, t.c paramAnonymousc)
      {
        switch (bk.4.a[paramAnonymousc.ordinal()])
        {
        default:
          if (paramBoolean)
            bk.a(bk.this).post(new Runnable()
            {
              public void run()
              {
                bk.1.this.b.b(bk.1.this.a);
              }
            });
          return;
        case 1:
        }
        bk.a(bk.this).post(new Runnable()
        {
          public void run()
          {
            bk.1.this.b.a(bk.1.this.a);
          }
        });
      }
    });
  }

  public void a(final MessageEntity paramMessageEntity, final a parama)
  {
    if (paramMessageEntity == null)
      return;
    s.a(paramMessageEntity, new a()
    {
      public void a(final long paramAnonymousLong)
      {
        bk.a(bk.this).post(new Runnable()
        {
          public void run()
          {
            bk.2.this.b.a(paramAnonymousLong);
          }
        });
      }

      public void a(final Uri paramAnonymousUri)
      {
        int i = 1;
        if (((paramMessageEntity.isVideo()) || (paramMessageEntity.isImage())) && (!paramMessageEntity.isPublicGroupBehavior()) && (!paramMessageEntity.isWink()) && (!paramMessageEntity.isHiddenContent()) && (!paramMessageEntity.isNotUploadedForwardedMediaTo1on1WithPublicAccount()))
          bk.a(paramMessageEntity.getMimeType(), paramAnonymousUri);
        int j;
        final long l;
        if ((paramMessageEntity.isMediaWithThumbnail()) && (!paramMessageEntity.isGifFile()))
        {
          j = i;
          if (j == 0)
            break label233;
          l = com.viber.voip.messages.extras.image.c.c(bk.b(bk.this), paramAnonymousUri, paramMessageEntity.getMimeType());
          if ((TextUtils.isEmpty(paramMessageEntity.getBody())) || (paramMessageEntity.getBody().startsWith("http")))
            break label222;
          label147: if (i == 0)
            break label227;
        }
        label222: label227: for (Uri localUri1 = Uri.parse(paramMessageEntity.getBody()); ; localUri1 = null)
        {
          final Uri localUri2 = com.viber.voip.messages.extras.image.c.a(bk.b(bk.this), paramAnonymousUri, localUri1, paramMessageEntity.getMimeType(), paramMessageEntity.isWink());
          bk.a(bk.this).post(new Runnable()
          {
            public void run()
            {
              bk.2.this.b.a(l, localUri2, this.c);
            }
          });
          return;
          j = 0;
          break;
          i = 0;
          break label147;
        }
        label233: bk.a(bk.this).post(new Runnable()
        {
          public void run()
          {
            bk.2.this.b.a(bk.2.this.a.getDuration(), paramAnonymousUri, null);
          }
        });
      }

      public void a(Uri paramAnonymousUri, final s.d paramAnonymousd)
      {
        bk.a(bk.this).post(new Runnable()
        {
          public void run()
          {
            bk.2.this.b.a(paramAnonymousd);
          }
        });
      }
    });
  }

  public void a(final MessageEntity paramMessageEntity, final b paramb)
  {
    t.a(paramMessageEntity, new com.viber.voip.util.upload.n()
    {
      public void a(final n.a paramAnonymousa)
      {
        bk.a(bk.this).post(new Runnable()
        {
          public void run()
          {
            MessageEntity localMessageEntity = bk.this.a.l(bk.3.this.a.getId());
            if ((localMessageEntity != null) && (-1 == localMessageEntity.getStatus()))
              bk.3.this.b.d(localMessageEntity);
            while ((localMessageEntity == null) || (localMessageEntity.isDeleted()))
              return;
            switch (bk.4.b[paramAnonymousa.ordinal()])
            {
            default:
              return;
            case 1:
              bk.3.this.b.a(localMessageEntity);
              return;
            case 2:
              bk.3.this.b.b(localMessageEntity);
              return;
            case 3:
            }
            bk.3.this.b.c(localMessageEntity);
          }
        });
      }
    });
  }

  public void a(Set<Long> paramSet)
  {
    Set localSet1 = this.a.j(paramSet);
    if (localSet1.size() > 0)
      this.e.a(localSet1);
    Set localSet2 = s.a();
    Iterator localIterator = this.a.a(paramSet, localSet2).iterator();
    while (localIterator.hasNext())
    {
      MessageEntity localMessageEntity = (MessageEntity)localIterator.next();
      t.a(localMessageEntity);
      s.a(localMessageEntity.getDownloadIdOrPublicAccountDownloadUrl(), true);
    }
  }

  public static abstract interface a
  {
    public abstract void a(long paramLong);

    public abstract void a(long paramLong, Uri paramUri1, Uri paramUri2);

    public abstract void a(s.d paramd);
  }

  public static abstract interface b
  {
    public abstract void a(MessageEntity paramMessageEntity);

    public abstract void b(MessageEntity paramMessageEntity);

    public abstract void c(MessageEntity paramMessageEntity);

    public abstract void d(MessageEntity paramMessageEntity);
  }

  public static abstract interface c
  {
    public abstract void a(MessageEntity paramMessageEntity);

    public abstract void a(MessageEntity paramMessageEntity, r paramr);

    public abstract void b(MessageEntity paramMessageEntity);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.controller.bk
 * JD-Core Version:    0.6.2
 */