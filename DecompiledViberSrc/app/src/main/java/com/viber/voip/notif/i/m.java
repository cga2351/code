package com.viber.voip.notif.i;

import android.os.Handler;
import android.support.v4.util.SparseArrayCompat;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.stickers.e.b;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.stickers.entity.a;
import com.viber.voip.stickers.i;
import com.viber.voip.util.LongSparseSet;
import com.viber.voip.util.upload.ObjectId;

public class m
{
  private static final Logger b = ViberEnv.getLogger();
  final SparseArrayCompat<LongSparseSet> a = new SparseArrayCompat();
  private final i c;
  private final Handler d;
  private h e;
  private final b f = new b()
  {
    public void onStickerDeployed(Sticker paramAnonymousSticker)
    {
      m.a(m.this).post(new n(this, paramAnonymousSticker));
    }

    public void onStickerPackageDeployed(a paramAnonymousa)
    {
    }

    public void onStickerPackageDownloadError(boolean paramAnonymousBoolean, a paramAnonymousa)
    {
    }

    public void onStickerPackageDownloadScheduled(a paramAnonymousa)
    {
    }

    public void onStickerPackageDownloadStarted(a paramAnonymousa)
    {
    }

    public void onStickerPackageDownloading(a paramAnonymousa, int paramAnonymousInt)
    {
    }
  };

  public m(i parami, Handler paramHandler)
  {
    this.c = parami;
    this.d = paramHandler;
  }

  public i a()
  {
    return this.c;
  }

  public void a(MessageEntity paramMessageEntity)
  {
    ObjectId localObjectId = paramMessageEntity.getObjectId();
    if (localObjectId == ObjectId.EMPTY);
    Sticker localSticker;
    do
    {
      return;
      localSticker = this.c.u(localObjectId.toStickerId());
    }
    while (localSticker.isReady());
    long l = paramMessageEntity.getConversationId();
    synchronized (this.a)
    {
      LongSparseSet localLongSparseSet = (LongSparseSet)this.a.get(localSticker.id);
      if (localLongSparseSet == null)
      {
        localLongSparseSet = new LongSparseSet();
        this.a.put(localSticker.id, localLongSparseSet);
      }
      localLongSparseSet.add(l);
      return;
    }
  }

  public void a(h paramh)
  {
    synchronized (this.a)
    {
      this.e = paramh;
      this.c.a(this.f);
      return;
    }
  }

  void a(Sticker paramSticker)
  {
    synchronized (this.a)
    {
      LongSparseSet localLongSparseSet = (LongSparseSet)this.a.get(paramSticker.id);
      if ((localLongSparseSet != null) && (paramSticker.isReady()))
      {
        this.a.remove(paramSticker.id);
        if (this.e != null)
          this.e.a(localLongSparseSet);
      }
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.i.m
 * JD-Core Version:    0.6.2
 */