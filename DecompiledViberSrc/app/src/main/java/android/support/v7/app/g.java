package android.support.v7.app;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.Window;

public class g extends DialogFragment
{
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    return new f(getContext(), getTheme());
  }

  public void setupDialog(Dialog paramDialog, int paramInt)
  {
    if ((paramDialog instanceof f))
    {
      f localf = (f)paramDialog;
      switch (paramInt)
      {
      default:
        return;
      case 3:
        paramDialog.getWindow().addFlags(24);
      case 1:
      case 2:
      }
      localf.supportRequestWindowFeature(1);
      return;
    }
    super.setupDialog(paramDialog, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.app.g
 * JD-Core Version:    0.6.2
 */