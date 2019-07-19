package com.viber.voip.ui.dialogs.a;

import android.widget.TextView;
import com.viber.common.dialogs.i.a;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.m.a;
import com.viber.voip.R.string;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.util.ParcelableInt;
import com.viber.voip.util.ViberActionRunner.ay;

public class c
{
  public static class a extends m.a
  {
    public void onDialogDataListBind(m paramm, i.a parama)
    {
      TextView localTextView;
      if (paramm.a(DialogCode.D460a))
        localTextView = (TextView)parama.itemView;
      switch (((ParcelableInt)parama.a()).getValue())
      {
      default:
        return;
      case -1:
        localTextView.setText(R.string.dialog_button_iam_above_16);
        return;
      case -2:
      }
      localTextView.setText(R.string.dialog_button_iam_below_16);
    }
  }

  public static class b extends m.a
  {
    public void onDialogAction(m paramm, int paramInt)
    {
      if (-1 == paramInt)
        ViberActionRunner.ay.k(paramm.getContext());
    }
  }

  public static class c extends m.a
  {
    public void onDialogAction(m paramm, int paramInt)
    {
      if (-1 == paramInt)
        ViberActionRunner.ay.e(paramm.getContext());
    }
  }

  public static class d extends m.a
  {
    public void onDialogAction(m paramm, int paramInt)
    {
      if (-1 == paramInt)
        ViberActionRunner.ay.h(paramm.getContext());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.dialogs.a.c
 * JD-Core Version:    0.6.2
 */