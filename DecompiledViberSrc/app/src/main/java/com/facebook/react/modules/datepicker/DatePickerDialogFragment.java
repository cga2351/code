package com.facebook.react.modules.datepicker;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.DatePicker;
import java.util.Calendar;
import java.util.Locale;
import javax.annotation.Nullable;

@SuppressLint({"ValidFragment"})
public class DatePickerDialogFragment extends DialogFragment
{
  private static final long DEFAULT_MIN_DATE = -2208988800001L;

  @Nullable
  private DatePickerDialog.OnDateSetListener mOnDateSetListener;

  @Nullable
  private DialogInterface.OnDismissListener mOnDismissListener;

  static Dialog createDialog(Bundle paramBundle, Context paramContext, @Nullable DatePickerDialog.OnDateSetListener paramOnDateSetListener)
  {
    Calendar localCalendar = Calendar.getInstance();
    if ((paramBundle != null) && (paramBundle.containsKey("date")))
      localCalendar.setTimeInMillis(paramBundle.getLong("date"));
    int i = localCalendar.get(1);
    int j = localCalendar.get(2);
    int k = localCalendar.get(5);
    DatePickerMode localDatePickerMode = DatePickerMode.DEFAULT;
    if ((paramBundle != null) && (paramBundle.getString("mode", null) != null))
      localDatePickerMode = DatePickerMode.valueOf(paramBundle.getString("mode").toUpperCase(Locale.US));
    DismissableDatePickerDialog localDismissableDatePickerDialog2;
    DismissableDatePickerDialog localDismissableDatePickerDialog1;
    DatePicker localDatePicker;
    if (Build.VERSION.SDK_INT >= 21)
      switch (1.$SwitchMap$com$facebook$react$modules$datepicker$DatePickerMode[localDatePickerMode.ordinal()])
      {
      default:
        localDismissableDatePickerDialog2 = null;
        localDismissableDatePickerDialog1 = localDismissableDatePickerDialog2;
        localDatePicker = localDismissableDatePickerDialog1.getDatePicker();
        if ((paramBundle != null) && (paramBundle.containsKey("minDate")))
        {
          localCalendar.setTimeInMillis(paramBundle.getLong("minDate"));
          localCalendar.set(11, 0);
          localCalendar.set(12, 0);
          localCalendar.set(13, 0);
          localCalendar.set(14, 0);
          localDatePicker.setMinDate(localCalendar.getTimeInMillis());
        }
        break;
      case 1:
      case 2:
      case 3:
      }
    while (true)
    {
      if ((paramBundle != null) && (paramBundle.containsKey("maxDate")))
      {
        localCalendar.setTimeInMillis(paramBundle.getLong("maxDate"));
        localCalendar.set(11, 23);
        localCalendar.set(12, 59);
        localCalendar.set(13, 59);
        localCalendar.set(14, 999);
        localDatePicker.setMaxDate(localCalendar.getTimeInMillis());
      }
      return localDismissableDatePickerDialog1;
      localDismissableDatePickerDialog2 = new DismissableDatePickerDialog(paramContext, paramContext.getResources().getIdentifier("CalendarDatePickerDialog", "style", paramContext.getPackageName()), paramOnDateSetListener, i, j, k);
      break;
      localDismissableDatePickerDialog2 = new DismissableDatePickerDialog(paramContext, paramContext.getResources().getIdentifier("SpinnerDatePickerDialog", "style", paramContext.getPackageName()), paramOnDateSetListener, i, j, k);
      break;
      localDismissableDatePickerDialog2 = new DismissableDatePickerDialog(paramContext, paramOnDateSetListener, i, j, k);
      break;
      localDismissableDatePickerDialog1 = new DismissableDatePickerDialog(paramContext, paramOnDateSetListener, i, j, k);
      switch (1.$SwitchMap$com$facebook$react$modules$datepicker$DatePickerMode[localDatePickerMode.ordinal()])
      {
      default:
        break;
      case 1:
        localDismissableDatePickerDialog1.getDatePicker().setCalendarViewShown(true);
        localDismissableDatePickerDialog1.getDatePicker().setSpinnersShown(false);
        break;
      case 2:
        localDismissableDatePickerDialog1.getDatePicker().setCalendarViewShown(false);
        break;
        localDatePicker.setMinDate(-2208988800001L);
      }
    }
  }

  public Dialog onCreateDialog(Bundle paramBundle)
  {
    return createDialog(getArguments(), getActivity(), this.mOnDateSetListener);
  }

  public void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    if (this.mOnDismissListener != null)
      this.mOnDismissListener.onDismiss(paramDialogInterface);
  }

  void setOnDateSetListener(@Nullable DatePickerDialog.OnDateSetListener paramOnDateSetListener)
  {
    this.mOnDateSetListener = paramOnDateSetListener;
  }

  void setOnDismissListener(@Nullable DialogInterface.OnDismissListener paramOnDismissListener)
  {
    this.mOnDismissListener = paramOnDismissListener;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.datepicker.DatePickerDialogFragment
 * JD-Core Version:    0.6.2
 */