package com.viber.voip.user.viberid.connectaccount.freestickers;

import android.support.v4.util.LongSparseArray;
import android.view.View;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.ViberEnv;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.stickers.f;

public class StickersViewContainer
{
  private static final Logger L = ViberEnv.getLogger();
  public static final int SINGLE_VIEW_NUMBER = 1;
  private final boolean mAnimateStickers;
  private final LongSparseArray<StickerViewHolder> mHolders = new LongSparseArray(3);
  private final int mNumberOfViews;
  private final ViberIdStickerAnimationController mViberIdStickerAnimationController;

  public StickersViewContainer(View paramView, f paramf, boolean paramBoolean, int paramInt)
  {
    this.mViberIdStickerAnimationController = new ViberIdStickerAnimationController(paramView.getContext());
    this.mHolders.put(0L, new StickerViewHolder(paramView.findViewById(R.id.sticker_view_1), paramf, this.mViberIdStickerAnimationController));
    this.mHolders.put(1L, new StickerViewHolder(paramView.findViewById(R.id.sticker_view_2), paramf, this.mViberIdStickerAnimationController));
    this.mHolders.put(2L, new StickerViewHolder(paramView.findViewById(R.id.sticker_view_3), paramf, this.mViberIdStickerAnimationController));
    this.mAnimateStickers = paramBoolean;
    this.mNumberOfViews = paramInt;
  }

  void bind(Sticker[] paramArrayOfSticker)
  {
    int i = Math.min(paramArrayOfSticker.length, this.mNumberOfViews);
    for (int j = 0; j < i; j++)
      ((StickerViewHolder)this.mHolders.get(j)).bind(paramArrayOfSticker[j], this.mAnimateStickers);
  }

  public void pauseAnimation()
  {
    this.mViberIdStickerAnimationController.pause();
  }

  public void resumeAnimation()
  {
    this.mViberIdStickerAnimationController.resume();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.connectaccount.freestickers.StickersViewContainer
 * JD-Core Version:    0.6.2
 */