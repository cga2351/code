package com.viber.voip.stickers;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.stickers.e.b;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.stickers.entity.a;
import java.util.ArrayList;
import java.util.Iterator;

public class o
  implements b
{
  private static final Logger a = ViberEnv.getLogger();
  private ArrayList<b> b = new ArrayList();

  private ArrayList<b> a()
  {
    try
    {
      ArrayList localArrayList = new ArrayList(this.b);
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(b paramb)
  {
    try
    {
      if (!this.b.contains(paramb))
        this.b.add(paramb);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void b(b paramb)
  {
    try
    {
      this.b.remove(paramb);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void onStickerDeployed(Sticker paramSticker)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).onStickerDeployed(paramSticker);
  }

  public void onStickerPackageDeployed(a parama)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).onStickerPackageDeployed(parama);
  }

  public void onStickerPackageDownloadError(boolean paramBoolean, a parama)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).onStickerPackageDownloadError(paramBoolean, parama);
  }

  public void onStickerPackageDownloadScheduled(a parama)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).onStickerPackageDownloadScheduled(parama);
  }

  public void onStickerPackageDownloadStarted(a parama)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).onStickerPackageDownloadStarted(parama);
  }

  public void onStickerPackageDownloading(a parama, int paramInt)
  {
    Iterator localIterator = a().iterator();
    while (localIterator.hasNext())
      ((b)localIterator.next()).onStickerPackageDownloading(parama, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.stickers.o
 * JD-Core Version:    0.6.2
 */