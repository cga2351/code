package com.viber.voip.report.community;

import android.app.Dialog;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.EditText;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.e.a;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.i.a;
import com.viber.common.dialogs.l.a;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.m.a;
import com.viber.common.dialogs.z;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.report.a.a.e;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.ce;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.cf;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.ui.dialogs.k;
import com.viber.voip.util.ParcelableInt;

public class d extends com.viber.voip.mvp.core.d<CommunityReportPresenter>
  implements c
{
  private final Fragment a;
  private final m.a b = new ViberDialogHandlers.ce();
  private final m.a c = new ViberDialogHandlers.cf();

  public d(Fragment paramFragment, CommunityReportPresenter paramCommunityReportPresenter, View paramView)
  {
    super(paramCommunityReportPresenter, paramView);
    this.a = paramFragment;
  }

  public void a()
  {
    com.viber.voip.ui.dialogs.d.u().a(this.a).b(this.a);
  }

  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      ad.b().b(true).a(false).a(this.a).b(this.a);
      return;
    }
    z.b(this.a, DialogCode.D_PROGRESS);
  }

  public void b()
  {
    com.viber.voip.ui.dialogs.d.v().a(this.a).b(this.a);
  }

  public void c()
  {
    com.viber.voip.ui.dialogs.d.t().b(this.a);
  }

  public void d()
  {
    h.a locala = k.n();
    int i = R.string.dialog_339_message_with_reason;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.a.getString(R.string.dialog_339_reason_send_report);
    locala.b(i, arrayOfObject).b(this.a);
  }

  public boolean onDialogAction(m paramm, int paramInt)
  {
    if (paramm.a(DialogCode.D_PROGRESS))
    {
      if (paramInt == -1000)
        ((CommunityReportPresenter)this.mPresenter).a();
      return true;
    }
    if (paramm.a(DialogCode.DC47))
    {
      if (paramInt == -1)
      {
        EditText localEditText = (EditText)paramm.getDialog().findViewById(R.id.user_edit_name);
        ((CommunityReportPresenter)this.mPresenter).a(localEditText.getText().toString());
      }
      this.b.onDialogAction(paramm, paramInt);
      return true;
    }
    return false;
  }

  public void onDialogDataListAction(m paramm, int paramInt, Object paramObject)
  {
    e locale;
    if (paramm.a(DialogCode.D_COMMUNITY_REPORT_REASONS))
    {
      locale = ViberDialogHandlers.cf.a(((ParcelableInt)paramObject).getValue());
      if (locale != null);
    }
    else
    {
      return;
    }
    ((CommunityReportPresenter)this.mPresenter).a(locale);
  }

  public void onDialogDataListBind(m paramm, i.a parama)
  {
    if (paramm.a(DialogCode.D_COMMUNITY_REPORT_REASONS))
      this.c.onDialogDataListBind(paramm, parama);
  }

  public void onDialogShow(m paramm)
  {
    if (paramm.a(DialogCode.DC47))
      this.b.onDialogShow(paramm);
    while (!paramm.a(DialogCode.D_COMMUNITY_REPORT_REASONS))
      return;
    this.c.onDialogShow(paramm);
  }

  public void onPrepareDialogView(m paramm, View paramView, int paramInt)
  {
    if (paramm.a(DialogCode.DC47))
      this.b.onPrepareDialogView(paramm, paramView, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.report.community.d
 * JD-Core Version:    0.6.2
 */