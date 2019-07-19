package com.viber.voip.banner.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.OnClickListener;
import com.viber.voip.banner.d.g;

public class f extends b
  implements View.OnClickListener
{
  private a mListener;
  private com.viber.voip.banner.d.f mRemoteBanner;

  public f(Context paramContext)
  {
    super(paramContext);
  }

  public f(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public f(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public f(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
  }

  public long getBannerId()
  {
    if (this.mRemoteBanner != null)
      return this.mRemoteBanner.getId();
    return 0L;
  }

  public long getMessageToken()
  {
    if (this.mRemoteBanner != null)
      return this.mRemoteBanner.b();
    return 0L;
  }

  public g getRemotePromoType()
  {
    if (this.mRemoteBanner != null)
      return this.mRemoteBanner.a();
    return g.d;
  }

  public boolean isDummyBanner()
  {
    return (this.mRemoteBanner != null) && (this.mRemoteBanner.f());
  }

  protected void onAction(String paramString, int paramInt)
  {
    boolean bool = true;
    if (this.mListener != null)
      bool = this.mListener.onBannerAction(getMessageToken(), paramString, paramInt, this);
    if (!bool)
      return;
    super.onAction(paramString, paramInt);
  }

  protected void onClose()
  {
    if (this.mListener != null)
      this.mListener.onBannerCloseAction(getMessageToken(), this);
  }

  public void setActionListener(a parama)
  {
    this.mListener = parama;
  }

  public void setRemoteBanner(com.viber.voip.banner.d.f paramf)
  {
    this.mRemoteBanner = paramf;
  }

  public static abstract interface a
  {
    public abstract boolean onBannerAction(long paramLong, String paramString, int paramInt, f paramf);

    public abstract void onBannerCloseAction(long paramLong, f paramf);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.view.f
 * JD-Core Version:    0.6.2
 */