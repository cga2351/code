package com.viber.voip.user.viberid.connectaccount.freestickers;

import android.os.Handler;
import android.support.v4.util.LongSparseArray;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.stickers.e.b;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.stickers.i;
import com.viber.voip.stickers.n;
import com.viber.voip.user.viberid.ViberIdPromoStickerPackHelper.ViberIdPromoStickerPackInfo;
import com.viber.voip.util.dd;

public class ViberIdStickerController
{
  private static final Logger L = ViberEnv.getLogger();
  private ViberIdPromoStickerPackHelper.ViberIdPromoStickerPackInfo mInfo;
  private final i mStickerController;
  private final b mStickerDeploymentListener = new n()
  {
    public void onStickerDeployed(Sticker paramAnonymousSticker)
    {
      if (ViberIdStickerController.this.addStickerIfNeeded(paramAnonymousSticker))
        ViberIdStickerController.this.tryShowStickers();
    }
  };
  private LongSparseArray<Sticker> mStickers;
  private StickersViewContainer mViewBinder;
  private final Handler mWorkerHandler;

  public ViberIdStickerController(i parami, Handler paramHandler)
  {
    this.mStickerController = parami;
    this.mWorkerHandler = paramHandler;
    this.mStickers = new LongSparseArray(3);
  }

  private boolean addStickerIfNeeded(Sticker paramSticker)
  {
    ViberIdPromoStickerPackHelper.ViberIdPromoStickerPackInfo localViberIdPromoStickerPackInfo = this.mInfo;
    boolean bool = false;
    if (localViberIdPromoStickerPackInfo == null);
    while (true)
    {
      return bool;
      for (int k : this.mInfo.promo_ids)
        if (paramSticker.id == k)
        {
          this.mStickers.put(paramSticker.id, paramSticker);
          bool = true;
        }
    }
  }

  private void loadStickers()
  {
    final ViberIdPromoStickerPackHelper.ViberIdPromoStickerPackInfo localViberIdPromoStickerPackInfo = this.mInfo;
    final LongSparseArray localLongSparseArray = new LongSparseArray(this.mInfo.promo_ids.length);
    this.mWorkerHandler.post(new Runnable()
    {
      public void run()
      {
        for (int i = 0; i < localViberIdPromoStickerPackInfo.promo_ids.length; i++)
        {
          Sticker localSticker = ViberIdStickerController.this.mStickerController.u(localViberIdPromoStickerPackInfo.promo_ids[i]);
          if ((localSticker.isReady()) && (localSticker.isInDatabase()))
            localLongSparseArray.put(localSticker.id, localSticker);
        }
        dd.a(new Runnable()
        {
          public void run()
          {
            if (ViberIdStickerController.this.mInfo.equals(ViberIdStickerController.2.this.val$info))
            {
              ViberIdStickerController.access$402(ViberIdStickerController.this, ViberIdStickerController.2.this.val$stickersToBind);
              ViberIdStickerController.this.tryShowStickers();
            }
          }
        });
      }
    });
  }

  private void tryBind()
  {
    if (!tryShowStickers())
      loadStickers();
  }

  private boolean tryShowStickers()
  {
    int i = this.mStickers.size();
    int j = this.mInfo.promo_ids.length;
    boolean bool = false;
    if (i == j)
    {
      Sticker[] arrayOfSticker = new Sticker[this.mStickers.size()];
      for (int k = 0; k < this.mInfo.promo_ids.length; k++)
        arrayOfSticker[k] = ((Sticker)this.mStickers.get(this.mInfo.promo_ids[k]));
      if (this.mViewBinder != null)
        this.mViewBinder.bind(arrayOfSticker);
      bool = true;
    }
    return bool;
  }

  public void attach(ViberIdPromoStickerPackHelper.ViberIdPromoStickerPackInfo paramViberIdPromoStickerPackInfo, StickersViewContainer paramStickersViewContainer)
  {
    if ((paramViberIdPromoStickerPackInfo != null) && (!paramViberIdPromoStickerPackInfo.equals(this.mInfo)))
    {
      this.mStickers.clear();
      this.mStickerController.a(this.mStickerDeploymentListener);
      this.mViewBinder = paramStickersViewContainer;
      this.mInfo = paramViberIdPromoStickerPackInfo;
      tryBind();
    }
  }

  public void detach()
  {
    this.mStickerController.b(this.mStickerDeploymentListener);
    this.mViewBinder = null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.connectaccount.freestickers.ViberIdStickerController
 * JD-Core Version:    0.6.2
 */