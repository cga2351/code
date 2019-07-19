package com.viber.voip.calls.ui;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.attr;
import com.viber.voip.R.color;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.model.a;
import com.viber.voip.model.j;
import com.viber.voip.phone.PhoneUtils;
import com.viber.voip.util.dc;
import com.viber.voip.util.e.e;
import com.viber.voip.widget.AvatarWithInitialsView;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class x extends ab<a, AvatarWithInitialsView, y>
{
  private String i;

  public x(Context paramContext, boolean paramBoolean, ab.a parama, e parame, com.viber.voip.util.e.f paramf)
  {
    super(paramContext, paramBoolean, parama, parame, paramf);
  }

  public y a(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return new y(paramLayoutInflater.inflate(R.layout.item_recent_call, paramViewGroup, false));
  }

  public void a(y paramy, a parama, int paramInt)
  {
    Object localObject1 = null;
    paramy.a(parama);
    paramy.f.setText(parama.k());
    Object localObject4;
    Object localObject5;
    Object localObject6;
    Object localObject2;
    if (!TextUtils.isEmpty(this.i))
    {
      Iterator localIterator = parama.f().entrySet().iterator();
      for (localObject4 = null; localIterator.hasNext(); localObject4 = localObject6)
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (!((String)localEntry.getKey()).contains(this.i))
          break label391;
        localObject5 = (com.viber.voip.model.f)localEntry.getValue();
        localObject6 = parama.a((String)localEntry.getKey());
        localObject1 = localObject5;
      }
      localObject2 = localObject1;
    }
    for (Object localObject3 = localObject4; ; localObject3 = null)
    {
      TreeMap localTreeMap;
      if (localObject2 == null)
      {
        localTreeMap = parama.f();
        localObject3 = parama.n();
        if ((localObject3 != null) && (!TextUtils.isEmpty(((j)localObject3).c())))
          localObject2 = (com.viber.voip.model.f)localTreeMap.get(((j)localObject3).c());
      }
      else
      {
        if (localObject2 == null)
          break label368;
        String str = PhoneUtils.formatPhoneNumber(((com.viber.voip.model.f)localObject2).a());
        if (parama == null)
          paramy.f.setText(str);
        paramy.b(((com.viber.voip.model.f)localObject2).b());
        if (localObject3 == null)
          break label360;
        paramy.b(true);
      }
      while (true)
      {
        if (this.f)
          paramy.f.setTextColor(this.a.getResources().getColor(R.color.main_text));
        paramy.d.setBackground(dc.g(this.a, R.attr.listItemActivatedBackground));
        ((AvatarWithInitialsView)paramy.e).a(parama.m(), true);
        this.d.a(parama.o(), (ImageView)paramy.e, this.e);
        return;
        if (localTreeMap.size() <= 0)
          break;
        localObject2 = (com.viber.voip.model.f)localTreeMap.get(localTreeMap.firstKey());
        break;
        label360: paramy.b(false);
        continue;
        label368: paramy.b("");
        if (parama == null)
          paramy.f.setText(R.string.unknown);
      }
      label391: localObject5 = localObject1;
      localObject6 = localObject4;
      break;
      localObject2 = null;
    }
  }

  public void a(String paramString)
  {
    this.i = paramString;
  }

  public boolean a(Object paramObject)
  {
    return paramObject instanceof a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.calls.ui.x
 * JD-Core Version:    0.6.2
 */