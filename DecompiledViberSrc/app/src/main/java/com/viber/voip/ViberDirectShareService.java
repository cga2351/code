package com.viber.voip;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Bundle;
import android.service.chooser.ChooserTarget;
import android.service.chooser.ChooserTargetService;
import android.text.TextUtils;
import com.viber.common.app.a;
import com.viber.dexshared.Logger;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.conversation.ui.ConversationData;
import com.viber.voip.messages.d.b;
import com.viber.voip.messages.d.c;
import com.viber.voip.model.entity.h;
import com.viber.voip.model.entity.m;
import com.viber.voip.util.dg;
import com.viber.voip.util.dq;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ViberDirectShareService extends ChooserTargetService
{
  private static final Logger a = ViberEnv.getLogger();

  public static ConversationData a(Intent paramIntent)
  {
    long l = paramIntent.getLongExtra("conversation_id", -1L);
    int i = paramIntent.getIntExtra("conversation_type", -1);
    if ((l != -1L) && (i != -1))
      return new ConversationData(l, 0L, "", "", i, "", "");
    return null;
  }

  private static List<Uri> a(long[] paramArrayOfLong)
  {
    LinkedList localLinkedList = new LinkedList();
    int i = paramArrayOfLong.length;
    for (int j = 0; j < i; j++)
    {
      long l = paramArrayOfLong[j];
      m localm = c.c().b(l);
      if (localm != null)
        localLinkedList.add(localm.p());
    }
    return localLinkedList;
  }

  public List<ChooserTarget> onGetChooserTargets(ComponentName paramComponentName, IntentFilter paramIntentFilter)
  {
    Application localApplication = ViberApplication.getApplication();
    int i = localApplication.getResources().getDimensionPixelSize(R.dimen.direct_share_icon_size);
    ArrayList localArrayList = new ArrayList();
    ComponentName localComponentName = new ComponentName(getPackageName(), getPackageName() + ".WelcomeShareActivity");
    Iterator localIterator = ab.b().B().iterator();
    h localh;
    Object localObject1;
    Bitmap localBitmap;
    Object localObject2;
    boolean bool2;
    if (localIterator.hasNext())
    {
      localh = (h)localIterator.next();
      localObject1 = null;
      if (localh.b())
      {
        Uri localUri2 = localh.r();
        localBitmap = null;
        if (localUri2 != null)
          localBitmap = e.a(localApplication, localUri2, false);
        if (localBitmap == null)
        {
          long[] arrayOfLong = new long[4];
          arrayOfLong[0] = localh.V();
          arrayOfLong[1] = localh.W();
          arrayOfLong[2] = localh.X();
          arrayOfLong[3] = localh.Y();
          List localList = a(arrayOfLong);
          localBitmap = j.a(localApplication, R.drawable.generic_image_thirty_x_thirty, i, i, (Uri[])localList.toArray(new Uri[localList.size()]));
        }
        localObject2 = dg.b(localh.o());
        bool2 = false;
        label229: if (localBitmap == null)
          break label437;
      }
    }
    label437: for (Icon localIcon = Icon.createWithBitmap(j.a(localApplication, localBitmap, i, i, (String)localObject1, bool2)); ; localIcon = null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putLong("conversation_id", localh.getId());
      localBundle.putInt("conversation_type", localh.j());
      localArrayList.add(new ChooserTarget((CharSequence)localObject2, localIcon, 1.0F, localComponentName, localBundle));
      break;
      m localm = c.c().b(localh.V());
      if (localm == null)
        break;
      Uri localUri1 = localm.p();
      localBitmap = null;
      if (localUri1 != null)
        localBitmap = e.a(localApplication, localUri1, false);
      boolean bool1 = false;
      if (localBitmap == null)
      {
        localBitmap = dq.a(localApplication.getResources(), R.drawable.generic_image_thirty_x_thirty);
        bool1 = true;
      }
      String str = localm.a(localh);
      if (!TextUtils.isEmpty(str))
      {
        localObject1 = str;
        localObject2 = str;
        bool2 = bool1;
        break label229;
      }
      localObject2 = localApplication.getResources().getString(R.string.unknown);
      bool2 = bool1;
      localObject1 = null;
      break label229;
      return localArrayList;
    }
  }

  public void startActivities(Intent[] paramArrayOfIntent, Bundle paramBundle)
  {
    a.a(new bi(this, paramArrayOfIntent, paramBundle), paramArrayOfIntent);
  }

  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    a.a(new bh(this, paramIntent, paramBundle), new Intent[] { paramIntent });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ViberDirectShareService
 * JD-Core Version:    0.6.2
 */