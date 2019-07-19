package com.viber.voip.viberout.ui.products.countryplans;

import android.content.Context;
import android.content.res.Resources;
import android.support.constraint.ConstraintLayout;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.util.dj;
import com.viber.voip.util.u;
import com.viber.voip.viberout.ui.products.c;
import com.viber.voip.viberout.ui.products.e;
import com.viber.voip.viberout.ui.products.model.CreditModel;
import com.viber.voip.viberout.ui.products.model.DestinationModel;
import com.viber.voip.viberout.ui.products.model.RateModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a extends ConstraintLayout
  implements View.OnClickListener, AdapterView.OnItemSelectedListener
{
  private Button g;
  private TableLayout h;
  private Spinner i;
  private TextView j;
  private ArrayAdapter<String> k;
  private a l;
  private c m;

  public a(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  private void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(R.layout.vo_country_credits_view, this, true);
    this.g = ((Button)findViewById(R.id.buy_button));
    this.h = ((TableLayout)findViewById(R.id.destinations));
    this.i = ((Spinner)findViewById(R.id.plan_picker));
    this.j = ((TextView)findViewById(R.id.rate_equation));
    this.i.setAdapter(getAdapter());
    this.g.setOnClickListener(this);
  }

  private ArrayAdapter<String> getAdapter()
  {
    if (this.k == null)
    {
      this.k = new ArrayAdapter(getContext(), R.layout.vo_rate_picker_item, R.id.rate_picker_item_text);
      this.k.setDropDownViewResource(R.layout.vo_dropdown_rate_picker_item);
    }
    return this.k;
  }

  private void setDestinations(List<DestinationModel> paramList)
  {
    this.h.removeAllViews();
    if (!u.a(paramList))
      this.m.a(this.h, paramList);
  }

  private void setRateEquation(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("= ");
    Resources localResources = getResources();
    int n = R.string.vo_plan_offer;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = String.valueOf(paramInt);
    localStringBuilder.append(localResources.getString(n, arrayOfObject));
    this.j.setText(localStringBuilder.toString());
  }

  public void a(e parame)
  {
    if (parame.b() != null)
      ViewCompat.setBackgroundTintList(this.g, parame.b());
  }

  public void a(List<CreditModel> paramList, int paramInt, CreditModel paramCreditModel)
  {
    ArrayAdapter localArrayAdapter = getAdapter();
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      localArrayList.add(((CreditModel)localIterator.next()).getFormattedAmount());
    localArrayAdapter.clear();
    localArrayAdapter.addAll(localArrayList);
    localArrayAdapter.notifyDataSetChanged();
    this.i.setOnItemSelectedListener(null);
    this.i.setSelection(paramInt, false);
    this.i.setOnItemSelectedListener(this);
    this.g.setText(paramCreditModel.getFormattedAmount());
    this.g.setTag(paramCreditModel);
  }

  public void onClick(View paramView)
  {
    if (this.l != null)
      this.l.a((CreditModel)this.g.getTag());
  }

  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.l != null)
      this.l.a(paramInt);
  }

  public void onNothingSelected(AdapterView<?> paramAdapterView)
  {
  }

  public void setCountryCreditViewListener(a parama)
  {
    this.l = parama;
  }

  public void setRate(RateModel paramRateModel)
  {
    if (paramRateModel == null)
    {
      dj.b(this.h, false);
      return;
    }
    dj.b(this.h, true);
    setDestinations(paramRateModel.getDestinations());
    setRateEquation(paramRateModel.getMaxMinutes());
  }

  public void setUiHelper(c paramc)
  {
    this.m = paramc;
  }

  public static abstract interface a
  {
    public abstract void a(int paramInt);

    public abstract void a(CreditModel paramCreditModel);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.countryplans.a
 * JD-Core Version:    0.6.2
 */