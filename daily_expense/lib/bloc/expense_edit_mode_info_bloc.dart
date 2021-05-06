
import 'package:flutter_bloc/flutter_bloc.dart';

class ExpenseEditModeInfoBloc extends Bloc<ExpenseEditModeInfoEvent, ExpenseEditModeInfoState> {
  ExpenseEditModeInfoBloc(ExpenseEditModeInfoState initialState) : super(initialState);
  // ExpenseEditModeInfoState get initialState => ExpenseEditModeInfoState(0);

  @override
  Stream<ExpenseEditModeInfoState> mapEventToState(ExpenseEditModeInfoEvent event) async* {
    if(event is ExpenseEditModeInfoEvent) {
      yield ExpenseEditModeInfoState(event.selectedCount);
    }
  }
}

// --------------------- event ---------------------
class ExpenseEditModeInfoEvent {
  int selectedCount;

  ExpenseEditModeInfoEvent(this.selectedCount);
}

// --------------------- state ---------------------
class ExpenseEditModeInfoState {
  int selectedCount;

  ExpenseEditModeInfoState(this.selectedCount);
}

