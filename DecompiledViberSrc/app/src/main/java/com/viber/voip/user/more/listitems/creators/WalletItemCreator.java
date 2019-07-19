package com.viber.voip.user.more.listitems.creators;

import android.content.Context;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.settings.a.a.b;
import com.viber.voip.util.dg;

public class WalletItemCreator
  implements PreferenceItemCreator
{
  private final Context mContext;
  private final com.viber.voip.wallet.a mWalletController;
  private final com.viber.common.b.b mWalletNewFeaturePref;
  private final int mWalletTextColor;

  public WalletItemCreator(Context paramContext, com.viber.voip.wallet.a parama, com.viber.common.b.b paramb, int paramInt)
  {
    this.mContext = paramContext;
    this.mWalletController = parama;
    this.mWalletNewFeaturePref = paramb;
    this.mWalletTextColor = paramInt;
  }

  public com.viber.voip.settings.a.a create()
  {
    com.viber.voip.g.b.b local1 = new com.viber.voip.g.b.b()
    {
      protected CharSequence initInstance()
      {
        return dg.a(WalletItemCreator.this.mContext.getString(R.string.new_feature), WalletItemCreator.this.mWalletTextColor);
      }
    };
    a.b localb = new a.b(this.mContext, R.id.open_wallet).a(new WalletItemCreator..Lambda.0(this)).b(new WalletItemCreator..Lambda.1(this, local1)).c(R.drawable.more_send_money_icon);
    com.viber.voip.wallet.a locala = this.mWalletController;
    locala.getClass();
    return localb.a(WalletItemCreator..Lambda.2.get$Lambda(locala)).a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.listitems.creators.WalletItemCreator
 * JD-Core Version:    0.6.2
 */