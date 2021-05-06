
import 'package:dailyexpense/constants.dart';
import 'package:dailyexpense/model/test_api_data.dart';
import 'package:dailyexpense/model/expense_item.dart';
import 'dart:collection';
import 'package:dio/dio.dart';

class HttpReqIf {
  ////////////////////////////////////////////////////////////////////////////////////////
  static Future<void> testHttpGetGoogleUrl({Map<String, dynamic>? params}) async {
    print("testHttpGetGoogleUrl(), params=$params");

    // query params
    Map<String, dynamic> queryParams = Map();
    if (null != params) {
      queryParams.addAll(params);
    }

    // get with params req
    Response response = await Dio().get(
        'http://www.google.com',
        queryParameters: queryParams,
        options: Options(sendTimeout: 5000, receiveTimeout: 5000)
    );
    printHttpResponse(response);
    return null;
  }

  static Future<TestApiSubData?> testHttpGetWithParams({Map<String, dynamic>? params}) async {
    print("testHttpGetWithParams(), params=$params");

    // query params
    Map<String, dynamic> queryParams = Map();
    if (null != params) {
      queryParams.addAll(params);
    }

    // get with params req
    Response response = await Dio().get(
        'http://10.34.135.103:8080/api/test1/getWithParam',
        queryParameters: queryParams,
        options: Options(sendTimeout: 5000, receiveTimeout: 5000)
    );
    printHttpResponse(response);

    // parse response and return result
    if (null == response.data) {
      return null;
    } else {
      return TestApiSubData.fromJson(response.data);
    }
  }

  static Future<TestApiData?> testHttpPostJson(Map<String, dynamic> postData) async {
    print("testHttpPostJson(), postData=$postData");

    // post json req
    Response response = await Dio().post('http://10.34.135.103:8080/api/test2/postJson', data: postData);
    printHttpResponse(response);

    // parse response and return result
    if (null == response.data) {
      return null;
    } else {
      return TestApiData.fromJson(response.data);
    }
  }

  ////////////////////////////////////////////////////////////////////////////////////////
  static void printHttpResponse(Response response) {
    print("printHttpResponse(), response.data=${response.data}");
    print("printHttpResponse(), response.data.runtimeType=${response.data.runtimeType}");
    print("printHttpResponse(), response.realUri=${response.realUri}");
    print("printHttpResponse(), response.extra=${response.extra}");
    print("printHttpResponse(), response.isRedirect=${response.isRedirect}");
    print("printHttpResponse(), response.statusCode=${response.statusCode}");
    print("printHttpResponse(), response.statusMessage=${response.statusMessage}");
  }

  static T? convertResponseMapData<T>(dynamic data, T converter(Map<String, dynamic> srcData)) {
    if (null == data || data is! Map<String, dynamic>) {
      return null;
    } else {
      return converter(data);
    }
  }

  static T? convertResponseStringData<T>(dynamic data, T converter(String data)) {
    if (null == data || data is! String) {
      return null;
    } else {
      return converter(data);
    }
  }

  static ResType? convertRespData<DataType, ResType>(
      dynamic data,
      ResType converter(DataType srcData)) {
    print("convertRespData(), data.runtimeType = ${data.runtimeType}");
    if (null == data || data is! DataType) {
      return null;
    } else {
      return converter(data);
    }
  }

  // get expense item by id
  static Future<ExpenseItem?> getExpenseItemByServerId(int id) async {
    print("getExpenseItemByServerId(), entry, id=$id");

    // query params
    Map<String, dynamic> queryParams = Map()..["id"] = id;

    // post json req, dio default convert the data to json string,
    Response response = await Dio().get(Constants.apiGetExpenseItemByServerId, queryParameters: queryParams);
    printHttpResponse(response);

    ExpenseItem? expenseItem = convertRespData<Map<String, dynamic>, ExpenseItem>(response.data, (Map<String, dynamic> data) {
      return ExpenseItem.fromJson(data);
    });

    return expenseItem;
  }

  // get all expense items
  static Future<List<ExpenseItem>?> getAllExpenseItems() async {
    print("getAllExpenseItems(), entry");

    // post json req, dio default convert the data to json string,
    Response response = await Dio().get(Constants.apiGetAllExpenseItems);
    printHttpResponse(response);

    List<ExpenseItem>? allExpenseItems = convertRespData<List, List<ExpenseItem>>(response.data, (srcData) {
      return srcData.map((e) => ExpenseItem.fromJson(e)).toList();
    });

    return allExpenseItems;

  }

  static Future<ExpenseItem?> addExpenseItem(ExpenseItem expenseItem) async {
    print("addExpenseItem(), entry, expenseItem=$expenseItem");

    // post json req, dio default convert the data to json string,
    Response response = await Dio().post(Constants.apiAddExpenseItem, data: expenseItem);
    printHttpResponse(response);

    // parse response and return result
    ExpenseItem? uploadedExpenseItem = convertRespData<Map<String, dynamic>, ExpenseItem>(response.data, (srcData) {
      return ExpenseItem.fromJson(srcData);
    });

    return uploadedExpenseItem;
  }

  static Future<List<ExpenseItem>?> addExpenseItemList(List<ExpenseItem> expenseItems) async {
    expenseItems.forEach((element) {
      print("addExpenseItemList(), expenseItem=$element");
    });

    // post json req, dio default convert the data to json string,
    Response response = await Dio().post(Constants.apiAddExpenseItemList, data: expenseItems);
    printHttpResponse(response);

    // parse response and return result
    List<ExpenseItem>? uploadedExpenseItem = convertRespData<List, List<ExpenseItem>>(response.data, (srcData) {
      return srcData.map((e) {
        return ExpenseItem.fromJson(e);
      }).toList();
    });

    return uploadedExpenseItem;
  }

  static Future<ExpenseItem?> updateExpenseItem(ExpenseItem expenseItem) async {
    print("updateExpenseItem(), expenseItem=$expenseItem");

    // post json req, dio default convert the data to json string,
    Response response = await Dio().post(Constants.apiUpdateExpenseItem, data: expenseItem);
    printHttpResponse(response);

    // parse response and return result
    ExpenseItem? updatedExpenseItem = convertRespData<Map<String, dynamic>, ExpenseItem>(response.data, (srcData) {
      return ExpenseItem.fromJson(srcData);
    });

    return updatedExpenseItem;
  }

  static Future<List<ExpenseItem>?> updateExpenseItemList(List<ExpenseItem> expenseItems) async {
    expenseItems.forEach((element) {
      print("updateExpenseItemList(), expenseItem=$element");
    });

    // post json req, dio default convert the data to json string,
    Response response = await Dio().post(Constants.apiUpdateExpenseItemList, data: expenseItems);
    printHttpResponse(response);

    // parse response and return result
    List<ExpenseItem>? updatedExpenseItems = convertRespData<List, List<ExpenseItem>>(response.data, (srcData) {
      return srcData.map((e) {
        return ExpenseItem.fromJson(e);
      }).toList();
    });

    return updatedExpenseItems;
  }

  static Future<int?> deleteExpenseItemList(List<ExpenseItem> expenseItems) async {
    expenseItems.forEach((element) {
      print("deleteExpenseItemList(), expenseItem=$element");
    });

    // post json req, dio default convert the data to json string,
    Response response = await Dio().post(Constants.apiDeleteExpenseItemList, data: expenseItems);
    printHttpResponse(response);

    // parse response and return result
    int? updatedExpenseItems = convertRespData<int, int>(response.data, (srcData) {
      return srcData;
    });

    return updatedExpenseItems;
  }
}