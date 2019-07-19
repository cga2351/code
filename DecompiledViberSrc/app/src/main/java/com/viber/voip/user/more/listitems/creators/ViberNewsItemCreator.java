package com.viber.voip.user.more.listitems.creators;

import android.content.Context;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.news.q;
import com.viber.voip.settings.a.a.b;
import com.viber.voip.util.cv;

public class ViberNewsItemCreator
  implements PreferenceItemCreator
{
  private final cv mBadgesManager;
  private final Context mContext;
  private final dagger.a<q> mViberNewsManager;

  public ViberNewsItemCreator(Context paramContext, cv paramcv, dagger.a<q> parama)
  {
    this.mContext = paramContext;
    this.mBadgesManager = paramcv;
    this.mViberNewsManager = parama;
  }

  public com.viber.voip.settings.a.a create()
  {
    return new a.b(this.mContext, R.id.news).a(R.string.more_viber_news).b(R.string.your_news_feed).c(R.drawable.more_news_icon).c(new ViberNewsItemCreator..Lambda.0(this)).a(new ViberNewsItemCreator..Lambda.1(this)).a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.listitems.creators.ViberNewsItemCreator
 * JD-Core Version:    0.6.2
 */