package com.viber.voip.user.more;

import android.content.Context;
import com.viber.voip.R.string;
import com.viber.voip.billing.b.a;
import com.viber.voip.viberout.a;
import com.viber.voip.viberout.a.a;
import com.viber.voip.viberout.ui.d;

public class MoreVoBalanceInteractor
  implements a.a
{
  private final Context mContext;
  private final a mViberOutBalanceFetcher;
  private ViberOutBalanceTextChangedListener mViberOutBalanceTextChangedListener;

  MoreVoBalanceInteractor(Context paramContext, a parama)
  {
    this.mContext = paramContext;
    this.mViberOutBalanceFetcher = parama;
  }

  private CharSequence getViberOutBalanceText(String paramString, int paramInt)
  {
    return d.a(paramString, paramInt, this.mContext);
  }

  private void setViberOutBalanceText(CharSequence paramCharSequence)
  {
    if (this.mViberOutBalanceTextChangedListener != null)
      this.mViberOutBalanceTextChangedListener.onViberOutBalanceTextChanged(paramCharSequence);
  }

  public void fetchBalance(ViberOutBalanceTextChangedListener paramViberOutBalanceTextChangedListener)
  {
    this.mViberOutBalanceTextChangedListener = paramViberOutBalanceTextChangedListener;
    this.mViberOutBalanceFetcher.a(this);
    if (this.mViberOutBalanceFetcher.c())
    {
      setLocalBalance(this.mViberOutBalanceFetcher.d(), this.mViberOutBalanceFetcher.g());
      return;
    }
    this.mViberOutBalanceFetcher.h();
  }

  public void onFetchBalanceCanceled()
  {
    setViberOutBalanceText(this.mContext.getString(R.string.viberout_not_available_credit));
  }

  public void onFetchBalanceFinished(b.a parama, String paramString)
  {
    setViberOutBalanceText(getViberOutBalanceText(paramString, parama.e()));
  }

  public void onFetchBalanceStarted()
  {
    setViberOutBalanceText("");
  }

  public void setLocalBalance(String paramString, int paramInt)
  {
    setViberOutBalanceText(getViberOutBalanceText(paramString, paramInt));
  }

  public void stopBalanceFetching()
  {
    this.mViberOutBalanceTextChangedListener = null;
    this.mViberOutBalanceFetcher.b(this);
  }

  public static abstract interface ViberOutBalanceTextChangedListener
  {
    public abstract void onViberOutBalanceTextChanged(CharSequence paramCharSequence);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.MoreVoBalanceInteractor
 * JD-Core Version:    0.6.2
 */