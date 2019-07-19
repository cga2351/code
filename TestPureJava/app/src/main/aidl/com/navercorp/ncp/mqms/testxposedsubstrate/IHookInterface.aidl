// IHookInterface.aidl
package com.navercorp.ncp.mqms.testxposedsubstrate;

import com.navercorp.ncp.mqms.testxposedsubstrate.bean.Param1;

interface IHookInterface {
    String getTargetAppPackageName();
    String getTargetAppLibAbsPath();
}
