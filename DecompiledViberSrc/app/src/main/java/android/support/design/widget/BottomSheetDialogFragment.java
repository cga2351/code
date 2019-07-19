package android.support.design.widget;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.g;

public class BottomSheetDialogFragment extends g
{
  public Dialog onCreateDialog(Bundle paramBundle)
  {
    return new BottomSheetDialog(getContext(), getTheme());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.widget.BottomSheetDialogFragment
 * JD-Core Version:    0.6.2
 */