package com.viber.voip.user.viberid.connectaccount.freestickers;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.viber.dexshared.Logger;
import com.viber.svg.jni.SvgViewBackend;
import com.viber.voip.R.id;
import com.viber.voip.ViberEnv;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.stickers.ui.StickerSvgContainer;
import com.viber.voip.stickers.ui.StickerSvgContainer.a;
import com.viber.voip.stickers.v.c;
import com.viber.voip.stickers.w;
import com.viber.voip.util.dj;

class StickerViewHolder
  implements StickerSvgContainer.a, v.c<Integer>
{
  private static final Logger L = ViberEnv.getLogger();
  private Sticker mSticker;
  private final View mStickerContent;
  private final com.viber.voip.stickers.ui.f mStickerImageLoader;
  private final ImageView mStickerView;
  private final StickerSvgContainer mSvgStickerView;
  private final ViberIdStickerAnimationController mViberIdStickerAnimationController;

  StickerViewHolder(View paramView, com.viber.voip.stickers.f paramf, ViberIdStickerAnimationController paramViberIdStickerAnimationController)
  {
    this.mStickerContent = paramView;
    this.mViberIdStickerAnimationController = paramViberIdStickerAnimationController;
    this.mStickerView = ((ImageView)paramView.findViewById(R.id.sticker_image));
    this.mSvgStickerView = ((StickerSvgContainer)paramView.findViewById(R.id.sticker_svg_container));
    this.mStickerImageLoader = new com.viber.voip.stickers.ui.f(paramf, this.mStickerView, (ImageView)paramView.findViewById(R.id.sticker_frame));
    this.mSvgStickerView.setAnimationCallback(this);
  }

  private void prepareContent(Sticker paramSticker)
  {
    resetContent();
    prepareStickerViewProportions(paramSticker);
    dj.b(this.mStickerContent, true);
    dj.b(this.mSvgStickerView, paramSticker.isAnimated());
  }

  private void prepareStickerViewProportions(Sticker paramSticker)
  {
    int i = this.mStickerContent.getLayoutParams().height;
    float f1 = paramSticker.getColSpan();
    float f2 = paramSticker.getRowSpan();
    if (i > 0)
    {
      int j = Math.round(f1 * i / f2);
      if (this.mStickerContent.getLayoutParams().width != j)
        this.mStickerContent.getLayoutParams().width = j;
    }
  }

  private void resetContent()
  {
    this.mStickerView.setImageDrawable(null);
    this.mStickerImageLoader.b();
    this.mSvgStickerView.c();
    this.mSvgStickerView.d();
    this.mSvgStickerView.b();
    this.mSvgStickerView.setSticker(null);
  }

  void bind(Sticker paramSticker, boolean paramBoolean)
  {
    this.mSticker = paramSticker;
    prepareContent(this.mSticker);
    this.mStickerImageLoader.a(this.mSticker);
    this.mStickerImageLoader.a(false, true, w.a);
    if ((paramBoolean) && (this.mSticker.isAnimated()))
    {
      this.mSvgStickerView.setSticker(this.mSticker);
      this.mViberIdStickerAnimationController.scheduleNextPlay(this);
    }
  }

  public SvgViewBackend getBackend()
  {
    return this.mSvgStickerView.getBackend();
  }

  public String getSoundPath()
  {
    return "";
  }

  public Integer getUniqueId()
  {
    return Integer.valueOf(this.mSticker.id);
  }

  public boolean hasSound()
  {
    return false;
  }

  public boolean isAnimatedSticker()
  {
    return this.mSticker.isAnimated();
  }

  public void loadImage(boolean paramBoolean)
  {
    this.mStickerImageLoader.a(false, false, false, true, w.a, paramBoolean, null);
  }

  public void onPlayAnimation()
  {
    this.mViberIdStickerAnimationController.onPlayAnimation(getUniqueId());
  }

  public void onStartAnimation()
  {
    dj.b(this.mStickerView, false);
    this.mViberIdStickerAnimationController.onStartAnimation(getUniqueId());
  }

  public void onStopAnimation()
  {
    dj.b(this.mStickerView, true);
    dj.b(this.mSvgStickerView, false);
    this.mViberIdStickerAnimationController.onStopAnimation(getUniqueId());
  }

  public boolean pauseAnimation()
  {
    return this.mSvgStickerView.f();
  }

  public boolean resumeAnimation()
  {
    return this.mSvgStickerView.g();
  }

  public void startAnimation()
  {
    this.mSvgStickerView.e();
  }

  public void stopAnimation()
  {
    this.mSvgStickerView.h();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.connectaccount.freestickers.StickerViewHolder
 * JD-Core Version:    0.6.2
 */