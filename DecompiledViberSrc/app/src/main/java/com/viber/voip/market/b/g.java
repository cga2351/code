package com.viber.voip.market.b;

import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.market.MarketApi.UserPublicGroupInfo;
import com.viber.voip.market.MarketApi.i;
import com.viber.voip.messages.controller.manager.z;
import com.viber.voip.model.entity.h;
import com.viber.voip.util.dd;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class g
{
  private static final Logger b = ViberEnv.getLogger();
  private MarketApi.i a;

  public void a(MarketApi.i parami)
  {
    this.a = parami;
    av.a(av.e.d).post(new Runnable()
    {
      public void run()
      {
        z localz = new z();
        String[] arrayOfString = new String[1];
        arrayOfString[0] = String.valueOf(2);
        List localList = localz.e("conversation_type = ?", arrayOfString);
        final ArrayList localArrayList = new ArrayList();
        Iterator localIterator1 = localList.iterator();
        while (localIterator1.hasNext())
          localArrayList.add(new MarketApi.UserPublicGroupInfo((h)localIterator1.next()));
        Iterator localIterator2;
        int i;
        try
        {
          dd.a(new Runnable()
          {
            public void run()
            {
              g.a(g.this).a(localArrayList);
            }
          });
          return;
        }
        catch (Exception localException)
        {
          localIterator2 = localArrayList.iterator();
          i = 0;
        }
        int j;
        if (localIterator2.hasNext())
        {
          MarketApi.UserPublicGroupInfo localUserPublicGroupInfo = (MarketApi.UserPublicGroupInfo)localIterator2.next();
          if (localUserPublicGroupInfo.groupName != null)
          {
            j = localUserPublicGroupInfo.groupName.length();
            label147: if (j <= i)
              break label213;
          }
        }
        while (true)
        {
          i = j;
          break;
          j = 0;
          break label147;
          g.a().a(localException, "GetUserPublicGroupsTask: post result intent fail! Probably intent is too big: groups count is = " + localArrayList.size() + ", maxGroupNamelength = " + i);
          throw localException;
          label213: j = i;
        }
      }
    });
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.market.b.g
 * JD-Core Version:    0.6.2
 */