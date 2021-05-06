import 'package:dailyexpense/constants.dart';
import 'package:dailyexpense/data_provider/cached_local_data.dart';
import 'package:flutter/material.dart';

class SelectExpenseTypeSheet {
  BuildContext? _buildContext;
  List<String> _expenseTypes = [];
  String _selectedExpenseType = "";
  int _selectedExpenseTypeIndex = 0;
  ScrollController scrollController = ScrollController();

  Future<String?> show(BuildContext buildContext, String selectedExpenseType) {
    _buildContext = buildContext;

    _expenseTypes = CachedLocalData.instance.expenseTypes;
    if (_expenseTypes.contains(selectedExpenseType)) {
      _selectedExpenseType = selectedExpenseType;
      _selectedExpenseTypeIndex = _expenseTypes.indexOf(selectedExpenseType);
    } else {
      _selectedExpenseType = _expenseTypes.length > 0 ? _expenseTypes[0] : "";
      _selectedExpenseTypeIndex = 0;
    }

    print("SelectExpenseTypeSheet.showSheet(), expenseTypes=$_expenseTypes");

    return showModalBottomSheet<String> (
        context: _buildContext!,
        shape: RoundedRectangleBorder(
            borderRadius: BorderRadius.vertical(top: Radius.circular(20))),
        builder: (context) {
          return SizedBox(
            height: 600,
            child: Container(
              padding: EdgeInsets.fromLTRB(20, 20, 20, 10),
              child: Column(
                crossAxisAlignment: CrossAxisAlignment.start,
                children: [
                  Text(
                    "Select Expense Type:",
                    style: TextStyle(fontSize: 18),
                  ),
                  SizedBox(
                    height: 10,
                  ),
                  Expanded(
                    child: _expenseTypes.isEmpty
                        ? Center(child: Text("No Expense Type, Please Add."),)
                        : buildExpenseTypeList(),
                  ),
                  SizedBox(
                    height: 10,
                  ),
                  TextButton(
                    style: TextButton.styleFrom(
                      primary: Colors.white,
                      backgroundColor: Colors.lightBlue,
                      shape: RoundedRectangleBorder(
                        borderRadius: BorderRadius.all(Radius.circular(5)),
                      ),
                      minimumSize: Size(double.infinity, 50)
                    ),
                    child: Text("OK"),
                    onPressed: () {
                      Navigator.pop(_buildContext!, _selectedExpenseType);
                    },
                  ),
                ],
              ),
            ),
          );
        });
  }

  ListView buildExpenseTypeList() {
    double itemHeight = 45.0;

    // scroll to selected item
    Future.delayed(Duration(milliseconds: 100), (){
      scrollController.animateTo(itemHeight * _selectedExpenseTypeIndex, duration: Duration(milliseconds: 500), curve: Curves.easeInOut);
      // scrollController.jumpTo(itemHeight * _selectedExpenseTypeIndex);
    });

    return ListView.separated(
      controller: scrollController,
      itemBuilder: (context, index) {
        return InkWell(
          onTap: () {
            _selectedExpenseType = _expenseTypes[index];
            (context as Element).markNeedsBuild();
          },
          child: SizedBox(
            height: itemHeight,
            child: Row(
              children: [
                Radio<String>(
                    value: _expenseTypes[index],
                    groupValue: _selectedExpenseType,
                    onChanged: (value) {
                      if (null == value) {
                        _selectedExpenseType = Constants.SpecialExpenseType_NoExpense;
                      } else {
                        _selectedExpenseType = value;
                      }

                      (context as Element).markNeedsBuild();
                    },
                    materialTapTargetSize: MaterialTapTargetSize.padded),
                Text(
                  _expenseTypes[index],
                  style: TextStyle(fontSize: 15),
                ),
              ],
            ),
          ),
        );
      },
      separatorBuilder: (context, index) {
        return Divider(height: 1);
      },
      itemCount: _expenseTypes.length,
    );
  }
}