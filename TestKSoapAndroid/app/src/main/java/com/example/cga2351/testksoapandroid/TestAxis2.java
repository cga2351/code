package com.example.cga2351.testksoapandroid;


/*
import javax.xml.namespace.QName;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

public class TestAxis2 {

	public static void main(String[] args) {
		getRPCServiceClient();
	}

	public static void getRPCServiceClient() {
		RPCServiceClient serviceClient;
		try {
			serviceClient = new RPCServiceClient();
			Options options = serviceClient.getOptions();
			// EndpointReference targetEPR = new
			// EndpointReference("http://192.168.1.20:8000/BMService.asmx?wsdl");
			EndpointReference targetEPR = new EndpointReference("http://192.168.169.155:8000/BMService.asmx?wsdl");
			// EndpointReference targetEPR = new
			// EndpointReference("http://192.168.1.20:8090/admin/services/LessonAction?wsdl");
			options.setTo(targetEPR);

			// 指定sum方法的参数值
			// 指定sum方法返回值的数据类型的Class对象
			Class[] classesBoolean = new Class[]{boolean.class};
			Class[] classesString = new Class[]{String.class};
			// 获得委托单号
			options.setAction("http://tempuri.org/GetDelegateFormId");
			Object[] opAddEntryArgs = new Object[]{"10001", "明医"};
			QName opAddEntry = new QName("http://tempuri.org/", "GetDelegateFormId");
			Object[] result = serviceClient.invokeBlocking(opAddEntry, opAddEntryArgs, classesString);
			System.out.println(result[0]);
		} catch (AxisFault e) {
			e.printStackTrace();
		}
	}
}
*/