package com.example.cga2351.testksoapandroid;

/*
import javax.xml.namespace.QName;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;
import org.apache.axis2.transport.http.HTTPConstants;

public class TestAxis2GetById {

	public static void main(String[] args) {
		getRPCServiceClient();
	}

	public static void getRPCServiceClient() {
		RPCServiceClient serviceClient;

		// 指定sum方法的参数值
		// 指定sum方法返回值的数据类型的Class对象
		Class[] classesBoolean = new Class[]{boolean.class};
		Class[] classesString = new Class[]{String.class};
		try {
			serviceClient = new RPCServiceClient();
			Options options = serviceClient.getOptions();
			options.setAction("http://tempuri.org/GetPrescriptionByID");
			options.setProperty(HTTPConstants.CHUNKED, "false");// 设置不受限制.
			// EndpointReference targetEPR = new
			// EndpointReference("http://192.168.1.20:8000/BMService.asmx?wsdl");
			EndpointReference targetEPR = new EndpointReference("http://192.168.169.155:8011/BMService.asmx?wsdl");
			options.setTo(targetEPR);
			QName opQName = new QName("http://tempuri.org/", "GetPrescriptionByID");
			Object[] opArgs = new Object[]{"000010901"};
			Object[] ret = serviceClient.invokeBlocking(opQName, opArgs, classesString);
			System.out.println(ret[0]);
			// ServiceClient sender = new ServiceClient();
			//
			// sender.setOptions(options);
			// OMFactory fac = OMAbstractFactory.getOMFactory();
			// OMNamespace omNs = fac.createOMNamespace("http://tempuri.org/",
			// "");
			// OMElement method = fac.createOMElement("GetPrescriptionByID",
			// omNs);
			// OMElement name = fac.createOMElement("strEP_NO", omNs);// 设置入参名称
			// name.setText("00000010");// 设置入参值
			// method.addChild(name);
			// method.build();
			//
			// System.out.println("method：" + method.toString());
			// OMElement response = sender.sendReceive(method);
			// System.out.println("response:" + response);
			// Iterator iterator = response.getAllAttributes();
			// if (iterator.hasNext()) {
			// String strtmp = (String) iterator.next();
			// System.out.println(strtmp);
			// }
			// OMElement elementReturn = response.getFirstElement();
			// System.out.println("cityCode:" + elementReturn.getText());
		} catch (AxisFault e) {
			e.printStackTrace();
		}
	}
}
*/