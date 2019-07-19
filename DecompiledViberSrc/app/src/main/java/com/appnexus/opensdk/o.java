package com.appnexus.opensdk;

class o extends f
{
  MRAIDImplementation e;

  o(AdView paramAdView, MRAIDImplementation paramMRAIDImplementation)
  {
    super(paramAdView, null);
    this.c = MRAIDImplementation.a[MRAIDImplementation.MRAID_INIT_STATE.STARTING_EXPANDED.ordinal()];
    this.e = paramMRAIDImplementation;
  }

  void r()
  {
    super.r();
    this.e.b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.o
 * JD-Core Version:    0.6.2
 */