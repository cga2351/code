package com.viber.voip.user.viberid.connectaccount.freestickers;

import android.content.Context;
import android.support.v4.util.CircularArray;
import com.viber.dexshared.Logger;
import com.viber.svg.jni.SvgViewBackend;
import com.viber.voip.ViberEnv;
import com.viber.voip.stickers.v;
import com.viber.voip.stickers.v.a;
import com.viber.voip.stickers.v.c;

class ViberIdStickerAnimationController
  implements v.a<Integer>
{
  private static final Logger L = ViberEnv.getLogger();
  private Integer mCurrentlyPlayedItem;
  private v.c<Integer> mCurrentlyPlayedStickerView;
  private boolean mIsActive = true;
  private final v<Integer> mStateHandler = new v(paramContext, this);
  private CircularArray<v.c<Integer>> mStickersQueue = new CircularArray(3);

  ViberIdStickerAnimationController(Context paramContext)
  {
  }

  public Integer getCurrentlyPlayedItem()
  {
    return this.mCurrentlyPlayedItem;
  }

  public v.c<Integer> getCurrentlyPlayedStickerView()
  {
    return this.mCurrentlyPlayedStickerView;
  }

  public void notifySoundStarted(Integer paramInteger)
  {
  }

  public void notifySoundStopped(Integer paramInteger)
  {
  }

  public void onPlay(Integer paramInteger)
  {
  }

  void onPlayAnimation(Integer paramInteger)
  {
    this.mStateHandler.c(paramInteger);
  }

  void onStartAnimation(Integer paramInteger)
  {
    this.mStateHandler.a(paramInteger);
  }

  public boolean onStop(Integer paramInteger)
  {
    if (paramInteger.equals(this.mCurrentlyPlayedItem))
    {
      this.mCurrentlyPlayedStickerView = null;
      this.mCurrentlyPlayedItem = null;
      this.mStickersQueue.popLast();
      if ((this.mIsActive) && (!this.mStickersQueue.isEmpty()))
        this.mStateHandler.a((v.c)this.mStickersQueue.getLast());
      return true;
    }
    return false;
  }

  void onStopAnimation(Integer paramInteger)
  {
    this.mStateHandler.d(paramInteger);
  }

  void pause()
  {
    this.mIsActive = false;
    if (this.mCurrentlyPlayedStickerView != null)
      this.mStateHandler.d(this.mCurrentlyPlayedStickerView);
  }

  void resume()
  {
    this.mIsActive = true;
    if (this.mCurrentlyPlayedStickerView != null)
      this.mStateHandler.c(this.mCurrentlyPlayedStickerView);
  }

  void scheduleNextPlay(v.c<Integer> paramc)
  {
    boolean bool = this.mStickersQueue.isEmpty();
    this.mStickersQueue.addFirst(paramc);
    if ((this.mIsActive) && (bool))
      this.mStateHandler.a(paramc);
  }

  public void setCurrentlyPlayedItem(Integer paramInteger)
  {
    if (this.mStickersQueue.isEmpty());
    v.c localc;
    do
    {
      return;
      localc = (v.c)this.mStickersQueue.getLast();
    }
    while ((paramInteger == null) || (!paramInteger.equals(localc.getUniqueId())));
    this.mCurrentlyPlayedStickerView = localc;
    this.mCurrentlyPlayedItem = paramInteger;
  }

  public void updateCurrentlyPlayedSvgViewBackend(SvgViewBackend paramSvgViewBackend)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.connectaccount.freestickers.ViberIdStickerAnimationController
 * JD-Core Version:    0.6.2
 */