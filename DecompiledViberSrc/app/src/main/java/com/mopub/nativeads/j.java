package com.mopub.nativeads;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;

class j
{

  @VisibleForTesting
  static final j h = new j();
  View a;
  TextView b;
  TextView c;
  TextView d;
  ImageView e;
  ImageView f;
  ImageView g;

  static j a(View paramView, ViewBinder paramViewBinder)
  {
    j localj = new j();
    localj.a = paramView;
    try
    {
      localj.b = ((TextView)paramView.findViewById(paramViewBinder.b));
      localj.c = ((TextView)paramView.findViewById(paramViewBinder.c));
      localj.d = ((TextView)paramView.findViewById(paramViewBinder.d));
      localj.e = ((ImageView)paramView.findViewById(paramViewBinder.e));
      localj.f = ((ImageView)paramView.findViewById(paramViewBinder.f));
      localj.g = ((ImageView)paramView.findViewById(paramViewBinder.g));
      return localj;
    }
    catch (ClassCastException localClassCastException)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.ERROR, new Object[] { "Could not cast from id in ViewBinder to expected View type", localClassCastException });
    }
    return h;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.nativeads.j
 * JD-Core Version:    0.6.2
 */