package com.viber.voip.user.more.listitems.creators;

import android.content.Context;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.i.f;
import com.viber.voip.settings.a.a;
import com.viber.voip.settings.a.a.b;
import com.viber.voip.util.dg;

public class VlnItemCreator
  implements PreferenceItemCreator
{
  private final Context mContext;
  private final com.viber.common.b.b mShowActiveBadgePref;
  private final com.viber.common.b.b mShowNewBadgePref;
  private final f mVlnFeature;
  private final int mVlnTextColor;

  public VlnItemCreator(Context paramContext, f paramf, com.viber.common.b.b paramb1, com.viber.common.b.b paramb2, int paramInt)
  {
    this.mContext = paramContext;
    this.mVlnFeature = paramf;
    this.mShowActiveBadgePref = paramb1;
    this.mShowNewBadgePref = paramb2;
    this.mVlnTextColor = paramInt;
  }

  public a create()
  {
    com.viber.voip.g.b.b local1 = new com.viber.voip.g.b.b()
    {
      protected CharSequence initInstance()
      {
        if (VlnItemCreator.this.mShowActiveBadgePref.d())
          return dg.a(VlnItemCreator.this.mContext.getString(R.string.more_item_active_label), VlnItemCreator.this.mVlnTextColor);
        return VlnItemCreator.this.mContext.getString(R.string.more_vln_item_get_local_number_text);
      }
    };
    a.b localb1 = new a.b(this.mContext, R.id.viber_local_number).a(R.string.more_viber_local_number);
    local1.getClass();
    a.b localb2 = localb1.b(VlnItemCreator..Lambda.0.get$Lambda(local1)).c(R.drawable.more_vln_icon);
    com.viber.common.b.b localb = this.mShowNewBadgePref;
    localb.getClass();
    a.b localb3 = localb2.b(VlnItemCreator..Lambda.1.get$Lambda(localb));
    f localf = this.mVlnFeature;
    localf.getClass();
    return localb3.a(VlnItemCreator..Lambda.2.get$Lambda(localf)).a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.listitems.creators.VlnItemCreator
 * JD-Core Version:    0.6.2
 */