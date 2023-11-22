package com.pufi.Model.Expressions;

import com.pufi.Exceptions.*;
import com.pufi.Model.Types.InterfaceType;
import com.pufi.Model.Values.InterfaceValue;
import com.pufi.Model.ADT.*;

public interface Expression {
    InterfaceValue evaluate(InterfaceDictionary<String, InterfaceValue> table) throws EvalException;
    String toString();
}
