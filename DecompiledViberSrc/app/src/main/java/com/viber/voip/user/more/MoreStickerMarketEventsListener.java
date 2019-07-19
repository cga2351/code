package com.viber.voip.user.more;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.viber.voip.schedule.o;

class MoreStickerMarketEventsListener extends BroadcastReceiver
{
  private final Context mContext;
  private final IntentFilter mIntentFilter;
  private NewStickerPackageCountChangedListener mNewStickerPackageCountChangedListener;
  private final o mStickerPackagesCountManager;

  MoreStickerMarketEventsListener(Context paramContext, IntentFilter paramIntentFilter, o paramo)
  {
    this.mContext = paramContext;
    this.mIntentFilter = paramIntentFilter;
    this.mStickerPackagesCountManager = paramo;
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((this.mNewStickerPackageCountChangedListener != null) && (this.mIntentFilter.countActions() > 0) && (this.mIntentFilter.hasAction(paramIntent.getAction())))
      this.mNewStickerPackageCountChangedListener.onNewStickerPackageCountChanged(this.mStickerPackagesCountManager.h());
  }

  void register(NewStickerPackageCountChangedListener paramNewStickerPackageCountChangedListener)
  {
    this.mNewStickerPackageCountChangedListener = paramNewStickerPackageCountChangedListener;
    this.mContext.registerReceiver(this, this.mIntentFilter);
  }

  void unregister()
  {
    this.mNewStickerPackageCountChangedListener = null;
    this.mContext.unregisterReceiver(this);
  }

  static abstract interface NewStickerPackageCountChangedListener
  {
    public abstract void onNewStickerPackageCountChanged(int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.MoreStickerMarketEventsListener
 * JD-Core Version:    0.6.2
 */