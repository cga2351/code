package com.viber.voip.ui.i;

import android.support.design.widget.Snackbar;
import android.support.v4.content.ContextCompat;
import android.view.View;
import com.viber.voip.R.color;
import com.viber.voip.R.string;
import com.viber.voip.util.dj;

public class a
{
  public static Snackbar a(View paramView)
  {
    Snackbar localSnackbar = Snackbar.make(paramView, R.string.community_poll_tooltip, -2);
    dj.a(localSnackbar, R.color.negative);
    dj.b(localSnackbar, 3);
    localSnackbar.getView().setBackgroundColor(ContextCompat.getColor(paramView.getContext(), R.color.solid));
    return localSnackbar;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.i.a
 * JD-Core Version:    0.6.2
 */