package com.viber.voip.user.more.listitems.creators;

import android.content.Context;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.settings.a.a;
import com.viber.voip.settings.a.a.b;
import com.viber.voip.user.viberid.ViberIdTriggerStateHolder;

public class GetFreeStickersItemCreator
  implements PreferenceItemCreator
{
  private final Context mContext;
  private final ViberIdTriggerStateHolder mViberIdTriggerStateHolder;

  public GetFreeStickersItemCreator(Context paramContext, ViberIdTriggerStateHolder paramViberIdTriggerStateHolder)
  {
    this.mContext = paramContext;
    this.mViberIdTriggerStateHolder = paramViberIdTriggerStateHolder;
  }

  public a create()
  {
    a.b localb = new a.b(this.mContext, R.id.get_free_stickers).a(R.string.viber_id_more_item_title).c(R.drawable.more_rakuten_icon);
    ViberIdTriggerStateHolder localViberIdTriggerStateHolder = this.mViberIdTriggerStateHolder;
    localViberIdTriggerStateHolder.getClass();
    return localb.a(GetFreeStickersItemCreator..Lambda.0.get$Lambda(localViberIdTriggerStateHolder)).a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.listitems.creators.GetFreeStickersItemCreator
 * JD-Core Version:    0.6.2
 */