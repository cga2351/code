package com.viber.voip.contacts.ui;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.h.a;
import com.viber.voip.R.string;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.a;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.ak;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.registration.af;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.g;
import com.viber.voip.ui.dialogs.r;
import com.viber.voip.user.OnlineUserActivityHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.greenrobot.eventbus.EventBus;

public class bb extends ParticipantSelector
{
  private boolean h;

  public bb(FragmentActivity paramFragmentActivity, Handler paramHandler1, Handler paramHandler2, Handler paramHandler3, ParticipantSelector.e parame, af paramaf, s.a parama, o paramo, EventBus paramEventBus, OnlineUserActivityHelper paramOnlineUserActivityHelper, GroupController paramGroupController, a parama1, ab paramab, ak paramak, int paramInt, boolean paramBoolean, com.viber.voip.analytics.story.e.c paramc)
  {
    super(paramFragmentActivity, paramHandler1, paramHandler2, paramHandler3, parame, paramaf, parama, paramo, paramEventBus, paramOnlineUserActivityHelper, paramGroupController, parama1, paramab, paramak, paramInt, "", paramc);
    this.h = paramBoolean;
  }

  public bb(FragmentActivity paramFragmentActivity, Handler paramHandler1, Handler paramHandler2, Handler paramHandler3, ParticipantSelector.e parame, af paramaf, s.a parama, o paramo, EventBus paramEventBus, OnlineUserActivityHelper paramOnlineUserActivityHelper, GroupController paramGroupController, a parama1, ab paramab, ak paramak, boolean paramBoolean, int paramInt, com.viber.voip.analytics.story.e.c paramc)
  {
    this(paramFragmentActivity, paramHandler1, paramHandler2, paramHandler3, parame, paramaf, parama, paramo, paramEventBus, paramOnlineUserActivityHelper, paramGroupController, parama1, paramab, paramak, paramInt, paramBoolean, paramc);
  }

  private void a(List<String> paramList1, List<String> paramList2, List<String> paramList3, List<String> paramList4, DialogInterface.OnClickListener paramOnClickListener)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramList1 != null) && (paramList1.size() > 0))
    {
      if (paramList1.size() > 1)
      {
        FragmentActivity localFragmentActivity8 = this.a;
        int i3 = R.string.dialog_1004_message_added_participants;
        Object[] arrayOfObject8 = new Object[1];
        arrayOfObject8[0] = Integer.valueOf(paramList1.size());
        localStringBuilder.append(com.viber.common.d.c.a(localFragmentActivity8, i3, arrayOfObject8));
        localStringBuilder.append("\n");
      }
    }
    else
    {
      if ((paramList2 != null) && (paramList2.size() > 0))
      {
        if (paramList2.size() <= 1)
          break label372;
        FragmentActivity localFragmentActivity6 = this.a;
        int i1 = R.string.dialog_1004_message_already_participants;
        Object[] arrayOfObject6 = new Object[1];
        arrayOfObject6[0] = Integer.valueOf(paramList2.size());
        localStringBuilder.append(com.viber.common.d.c.a(localFragmentActivity6, i1, arrayOfObject6));
        label153: localStringBuilder.append("\n");
      }
      if ((paramList3 != null) && (paramList3.size() > 0))
      {
        if (paramList3.size() <= 1)
          break label418;
        FragmentActivity localFragmentActivity4 = this.a;
        int m = R.string.dialog_1004_participants_not_added;
        Object[] arrayOfObject4 = new Object[1];
        arrayOfObject4[0] = Integer.valueOf(paramList3.size());
        localStringBuilder.append(com.viber.common.d.c.a(localFragmentActivity4, m, arrayOfObject4));
        label229: localStringBuilder.append("\n");
      }
      if ((paramList4 != null) && (paramList4.size() > 0))
      {
        if (paramList4.size() <= 1)
          break label464;
        FragmentActivity localFragmentActivity2 = this.a;
        int j = R.string.dialog_1004_message_cannot_add_participant;
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = String.valueOf(paramList4.size());
        localStringBuilder.append(com.viber.common.d.c.a(localFragmentActivity2, j, arrayOfObject2));
      }
    }
    while (true)
    {
      localStringBuilder.append("\n");
      if (localStringBuilder.length() != 0)
        break label511;
      return;
      FragmentActivity localFragmentActivity7 = this.a;
      int i2 = R.string.dialog_1004_message_added_participant;
      Object[] arrayOfObject7 = new Object[1];
      arrayOfObject7[0] = paramList1.get(0);
      localStringBuilder.append(com.viber.common.d.c.a(localFragmentActivity7, i2, arrayOfObject7));
      break;
      label372: FragmentActivity localFragmentActivity5 = this.a;
      int n = R.string.dialog_1004_message_already_participant;
      Object[] arrayOfObject5 = new Object[1];
      arrayOfObject5[0] = paramList2.get(0);
      localStringBuilder.append(com.viber.common.d.c.a(localFragmentActivity5, n, arrayOfObject5));
      break label153;
      label418: FragmentActivity localFragmentActivity3 = this.a;
      int k = R.string.dialog_1004_message_participant_not_added;
      Object[] arrayOfObject3 = new Object[1];
      arrayOfObject3[0] = paramList3.get(0);
      localStringBuilder.append(com.viber.common.d.c.a(localFragmentActivity3, k, arrayOfObject3));
      break label229;
      label464: FragmentActivity localFragmentActivity1 = this.a;
      int i = R.string.dialog_1004_message_cannot_add_participant;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = paramList4.get(0);
      localStringBuilder.append(com.viber.common.d.c.a(localFragmentActivity1, i, arrayOfObject1));
    }
    label511: localStringBuilder.deleteCharAt(-1 + localStringBuilder.length());
    ViberDialogHandlers.g localg = new ViberDialogHandlers.g();
    localg.a = paramOnClickListener;
    r.c().a(localStringBuilder.toString()).a(localg).a(this.a);
  }

  protected void a(Activity paramActivity, Set<ParticipantSelector.Participant> paramSet, Map<String, String> paramMap1, Map<String, String> paramMap2, Map<String, String> paramMap3, Map<String, String> paramMap4, Map<String, String> paramMap5, DialogInterface.OnClickListener paramOnClickListener)
  {
    ArrayList localArrayList1 = new ArrayList();
    Iterator localIterator1 = this.c.entrySet().iterator();
    while (localIterator1.hasNext())
    {
      Map.Entry localEntry4 = (Map.Entry)localIterator1.next();
      ParticipantSelector.Participant localParticipant = (ParticipantSelector.Participant)localEntry4.getKey();
      String str4 = localParticipant.getMemberId();
      if ((!((ParticipantSelector.a)localEntry4.getValue()).c) && (paramMap1.get(str4) == null) && (paramMap2.get(str4) == null) && (paramMap3.get(str4) == null))
        localArrayList1.add(localParticipant.getDisplayNameNotNull(paramActivity));
    }
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator2 = paramMap1.entrySet().iterator();
    if (localIterator2.hasNext())
    {
      Map.Entry localEntry3 = (Map.Entry)localIterator2.next();
      if (TextUtils.isEmpty((CharSequence)localEntry3.getValue()));
      for (String str3 = (String)localEntry3.getKey(); ; str3 = (String)localEntry3.getValue())
      {
        localArrayList2.add(str3);
        break;
      }
    }
    ArrayList localArrayList3 = new ArrayList();
    Iterator localIterator3 = paramMap2.entrySet().iterator();
    if (localIterator3.hasNext())
    {
      Map.Entry localEntry2 = (Map.Entry)localIterator3.next();
      if (TextUtils.isEmpty((CharSequence)localEntry2.getValue()));
      for (String str2 = (String)localEntry2.getKey(); ; str2 = (String)localEntry2.getValue())
      {
        localArrayList3.add(str2);
        break;
      }
    }
    ArrayList localArrayList4 = new ArrayList();
    Iterator localIterator4 = paramMap3.entrySet().iterator();
    if (localIterator4.hasNext())
    {
      Map.Entry localEntry1 = (Map.Entry)localIterator4.next();
      if (TextUtils.isEmpty((CharSequence)localEntry1.getValue()));
      for (String str1 = (String)localEntry1.getKey(); ; str1 = (String)localEntry1.getValue())
      {
        localArrayList4.add(str1);
        break;
      }
    }
    a(localArrayList1, localArrayList2, localArrayList3, localArrayList4, paramOnClickListener);
  }

  protected void a(Activity paramActivity, boolean paramBoolean, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramBoolean)
    {
      if (paramOnClickListener != null)
        paramOnClickListener.onClick(null, -1);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.c.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (!((ParticipantSelector.a)localEntry.getValue()).c)
        localArrayList.add(((ParticipantSelector.Participant)localEntry.getKey()).getDisplayName());
    }
    a(localArrayList, null, null, null, paramOnClickListener);
  }

  protected boolean c()
  {
    return this.h;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.bb
 * JD-Core Version:    0.6.2
 */