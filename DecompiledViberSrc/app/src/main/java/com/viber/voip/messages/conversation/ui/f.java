package com.viber.voip.messages.conversation.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.widget.ImageViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.viber.common.app.a;
import com.viber.voip.R.attr;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.model.entity.MessageCallEntity;
import com.viber.voip.util.ae;
import com.viber.voip.util.dc;
import com.viber.voip.util.dg;
import java.text.FieldPosition;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class f extends DialogFragment
{
  private LayoutInflater a;
  private ListView b;
  private a c;
  private b d;
  private int e;
  private ColorStateList f;
  private int g;
  private ColorStateList h;

  public static f a(aa paramaa, List<MessageCallEntity> paramList, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelableArrayList("extra_calls", new ArrayList(paramList));
    localBundle.putBoolean("has_viber", paramBoolean);
    if ((paramaa.bK()) && (paramaa.bL()))
      localBundle.putParcelable("extra_conference_info", paramaa.bM());
    f localf = new f();
    localf.setArguments(localBundle);
    return localf;
  }

  public void a(b paramb)
  {
    this.d = paramb;
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setStyle(1, 0);
    if (getArguments() == null)
      dismiss();
    ArrayList localArrayList = getArguments().getParcelableArrayList("extra_calls");
    boolean bool = getArguments().getBoolean("has_viber", true);
    ConferenceInfo localConferenceInfo = (ConferenceInfo)getArguments().getParcelable("extra_conference_info");
    FragmentActivity localFragmentActivity = getActivity();
    this.c = new a(localFragmentActivity, localArrayList, localConferenceInfo, bool);
    this.e = dc.d(localFragmentActivity, R.attr.contactDetailsCallItemTypeNormalColor);
    this.f = dc.e(localFragmentActivity, R.attr.contactDetailsCallItemTypeNormalIconTint);
    this.g = dc.d(localFragmentActivity, R.attr.contactDetailsCallItemTypeMissedColor);
    this.h = dc.e(localFragmentActivity, R.attr.contactDetailsCallItemTypeMissedIconTint);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    View localView = paramLayoutInflater.inflate(R.layout._ics_message_call_list_dialog, null);
    this.a = paramLayoutInflater;
    this.b = ((ListView)localView.findViewById(R.id.list));
    this.b.setAdapter(this.c);
    return localView;
  }

  public void startActivity(Intent paramIntent, Bundle paramBundle)
  {
    a.a(new g(this, paramIntent, paramBundle), new Intent[] { paramIntent });
  }

  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    a.a(new h(this, paramIntent, paramInt, paramBundle), new Intent[] { paramIntent });
  }

  private class a extends BaseAdapter
  {
    private List<MessageCallEntity> b;
    private ConferenceInfo c;
    private boolean d;
    private java.text.DateFormat e;
    private java.text.DateFormat f;
    private FieldPosition g;
    private final View.OnClickListener h = new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        if ((paramAnonymousView.getTag() instanceof f.c))
        {
          int i = f.c.a((f.c)paramAnonymousView.getTag());
          MessageCallEntity localMessageCallEntity = f.a.this.a(i);
          if (f.a(f.this) != null)
            f.a(f.this).a(localMessageCallEntity, f.a.a(f.a.this), f.a.b(f.a.this));
          f.this.dismiss();
        }
      }
    };

    public a(List<MessageCallEntity> paramConferenceInfo, ConferenceInfo paramBoolean, boolean arg4)
    {
      this.b = paramBoolean;
      Object localObject;
      this.c = localObject;
      boolean bool;
      this.d = bool;
      this.e = android.text.format.DateFormat.getLongDateFormat(paramConferenceInfo);
      this.f = android.text.format.DateFormat.getTimeFormat(paramConferenceInfo);
      this.g = new FieldPosition(3);
    }

    private String a(MessageCallEntity paramMessageCallEntity)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      this.e.format(new Date(paramMessageCallEntity.getDate()), localStringBuffer, this.g);
      localStringBuffer.append(' ').append(' ');
      this.f.format(new Date(paramMessageCallEntity.getDate()), localStringBuffer, this.g);
      return localStringBuffer.toString().toUpperCase();
    }

    private void a(f.c paramc, MessageCallEntity paramMessageCallEntity)
    {
      int i;
      ColorStateList localColorStateList;
      int j;
      String str;
      int k;
      if (paramMessageCallEntity.isMissed())
      {
        i = R.drawable._ics_message_call_arrow_missed;
        localColorStateList = f.c(f.this);
        j = f.d(f.this);
        str = dg.a(paramMessageCallEntity);
        if ((paramMessageCallEntity.isMissed()) || (paramMessageCallEntity.isAnswerredOnAnotherDevice()))
          break label184;
        k = 1;
        label52: if (k == 0)
          break label190;
        f.c.b(paramc).setVisibility(0);
        f.c.b(paramc).setText(ae.g(paramMessageCallEntity.getDuration()));
      }
      while (true)
      {
        f.c.c(paramc).setText(str);
        f.c.c(paramc).setTextColor(j);
        f.c.d(paramc).setImageResource(i);
        ImageViewCompat.setImageTintList(f.c.d(paramc), localColorStateList);
        f.c.e(paramc).setText(a(paramMessageCallEntity));
        return;
        if (paramMessageCallEntity.isIncoming())
        {
          i = R.drawable._ics_message_call_arrow_incoming;
          localColorStateList = f.e(f.this);
          j = f.f(f.this);
          break;
        }
        i = R.drawable._ics_message_call_arrow_outgoing;
        localColorStateList = f.e(f.this);
        j = f.f(f.this);
        break;
        label184: k = 0;
        break label52;
        label190: f.c.b(paramc).setVisibility(8);
      }
    }

    public MessageCallEntity a(int paramInt)
    {
      return (MessageCallEntity)this.b.get(paramInt);
    }

    public int getCount()
    {
      return this.b.size();
    }

    public long getItemId(int paramInt)
    {
      return ((MessageCallEntity)this.b.get(paramInt)).getId();
    }

    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = f.b(f.this).inflate(R.layout._ics_message_call_list_item, null);
        paramView.setTag(new f.c(f.this, paramView, paramInt, null));
        paramView.setOnClickListener(this.h);
      }
      a((f.c)paramView.getTag(), a(paramInt));
      return paramView;
    }
  }

  public static abstract interface b
  {
    public abstract void a(MessageCallEntity paramMessageCallEntity, ConferenceInfo paramConferenceInfo, boolean paramBoolean);
  }

  private class c
  {
    private final TextView b;
    private final TextView c;
    private final TextView d;
    private final ImageView e;
    private final int f;

    private c(View paramInt, int arg3)
    {
      this.e = ((ImageView)paramInt.findViewById(R.id.call_image_type));
      this.b = ((TextView)paramInt.findViewById(R.id.call_text_type));
      this.c = ((TextView)paramInt.findViewById(R.id.call_date));
      this.d = ((TextView)paramInt.findViewById(R.id.call_duration));
      int i;
      this.f = i;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.f
 * JD-Core Version:    0.6.2
 */