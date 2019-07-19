package com.viber.voip.contacts.adapters;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TrustedContactsAdapter extends BaseAdapter
{
  private LayoutInflater a;
  private a b;
  private ArrayList<TrustedContactAdapterItem> c;
  private Drawable d;
  private Drawable e;
  private Comparator<TrustedContactAdapterItem> f = new Comparator()
  {
    private Collator b = Collator.getInstance();

    public int a(TrustedContactsAdapter.TrustedContactAdapterItem paramAnonymousTrustedContactAdapterItem1, TrustedContactsAdapter.TrustedContactAdapterItem paramAnonymousTrustedContactAdapterItem2)
    {
      return this.b.compare(paramAnonymousTrustedContactAdapterItem1.displayName, paramAnonymousTrustedContactAdapterItem2.displayName);
    }
  };

  public TrustedContactsAdapter(Context paramContext, a parama, LayoutInflater paramLayoutInflater)
  {
    this.b = parama;
    this.a = paramLayoutInflater;
    this.c = new ArrayList();
    this.d = ContextCompat.getDrawable(paramContext, R.drawable.ic_secure_chat_trusted_normal);
    this.e = ContextCompat.getDrawable(paramContext, R.drawable.ic_secure_chat_breach_normal);
  }

  public TrustedContactAdapterItem a(int paramInt)
  {
    return (TrustedContactAdapterItem)this.c.get(paramInt);
  }

  public ArrayList<TrustedContactAdapterItem> a()
  {
    return this.c;
  }

  public void a(TrustedContactAdapterItem paramTrustedContactAdapterItem)
  {
    this.c.remove(paramTrustedContactAdapterItem);
    notifyDataSetChanged();
  }

  public void a(List<TrustedContactAdapterItem> paramList)
  {
    this.c.clear();
    this.c.addAll(paramList);
    Collections.sort(this.c, this.f);
    notifyDataSetChanged();
  }

  public int getCount()
  {
    return this.c.size();
  }

  public long getItemId(int paramInt)
  {
    return 0L;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    b localb;
    final TrustedContactAdapterItem localTrustedContactAdapterItem;
    TextView localTextView;
    if (paramView == null)
    {
      paramView = this.a.inflate(R.layout.trusted_contact_list_item, paramViewGroup, false);
      localb = new b(paramView);
      paramView.setTag(localb);
      localTrustedContactAdapterItem = a(paramInt);
      localb.b.setText(localTrustedContactAdapterItem.displayName);
      localTextView = localb.b;
      if (!localTrustedContactAdapterItem.isBreach)
        break label116;
    }
    label116: for (Drawable localDrawable = this.e; ; localDrawable = this.d)
    {
      localTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, localDrawable, null);
      localb.c.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if (TrustedContactsAdapter.a(TrustedContactsAdapter.this) != null)
            TrustedContactsAdapter.a(TrustedContactsAdapter.this).a(localTrustedContactAdapterItem);
        }
      });
      return paramView;
      localb = (b)paramView.getTag();
      break;
    }
  }

  public static class TrustedContactAdapterItem
    implements Parcelable
  {
    public static final Parcelable.Creator<TrustedContactAdapterItem> CREATOR = new Parcelable.Creator()
    {
      public TrustedContactsAdapter.TrustedContactAdapterItem a(Parcel paramAnonymousParcel)
      {
        return new TrustedContactsAdapter.TrustedContactAdapterItem(paramAnonymousParcel);
      }

      public TrustedContactsAdapter.TrustedContactAdapterItem[] a(int paramAnonymousInt)
      {
        return new TrustedContactsAdapter.TrustedContactAdapterItem[paramAnonymousInt];
      }
    };
    public final String displayName;
    public final boolean isBreach;
    public final String memberId;
    public final String number;

    protected TrustedContactAdapterItem(Parcel paramParcel)
    {
      this.memberId = paramParcel.readString();
      this.number = paramParcel.readString();
      this.displayName = paramParcel.readString();
      if (paramParcel.readByte() == i);
      while (true)
      {
        this.isBreach = i;
        return;
        i = 0;
      }
    }

    public TrustedContactAdapterItem(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
    {
      this.memberId = paramString1;
      this.number = paramString2;
      this.displayName = paramString3;
      this.isBreach = paramBoolean;
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.memberId);
      paramParcel.writeString(this.number);
      paramParcel.writeString(this.displayName);
      if (this.isBreach);
      for (int i = 1; ; i = 0)
      {
        paramParcel.writeByte((byte)i);
        return;
      }
    }
  }

  public static abstract interface a
  {
    public abstract void a(TrustedContactsAdapter.TrustedContactAdapterItem paramTrustedContactAdapterItem);
  }

  private static class b
  {
    public final View a;
    public final TextView b;
    public final Button c;

    public b(View paramView)
    {
      this.a = paramView;
      this.b = ((TextView)paramView.findViewById(R.id.txt_trusted_contact));
      this.c = ((Button)paramView.findViewById(R.id.btn_clear_trusted_contact));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.adapters.TrustedContactsAdapter
 * JD-Core Version:    0.6.2
 */