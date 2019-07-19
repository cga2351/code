package com.viber.svg.jni;

import android.content.Context;
import android.view.View;

public abstract interface SvgViewCommon extends TimeAware
{
  public abstract View asView();

  public abstract SvgViewBackend getBackend();

  public abstract void load(String paramString1, String paramString2, int paramInt);

  public abstract void loadFromAsset(Context paramContext, String paramString1, String paramString2, int paramInt);

  public abstract void setBackend(SvgViewBackend paramSvgViewBackend);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.svg.jni.SvgViewCommon
 * JD-Core Version:    0.6.2
 */