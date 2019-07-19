package com.viber.voip.util;

import android.content.IntentFilter;

class Reachability$2 extends IntentFilter
{
  Reachability$2(cj paramcj)
  {
    addAction("android.net.conn.CONNECTIVITY_CHANGE");
    addAction("android.net.conn.BACKGROUND_DATA_SETTING_CHANGED");
    addAction("android.intent.action.AIRPLANE_MODE");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.Reachability.2
 * JD-Core Version:    0.6.2
 */