package com.revolsys.record.query;

import org.jeometry.common.compare.CompareUtil;

import com.revolsys.collection.map.MapEx;

public class LessThanEqual extends BinaryCondition {

  public LessThanEqual(final QueryValue left, final QueryValue right) {
    super(left, "<=", right);
  }

  @Override
  public LessThanEqual clone() {
    return (LessThanEqual)super.clone();
  }

  @Override
  public boolean test(final MapEx record) {
    final QueryValue left = getLeft();
    final Object value1 = left.getValue(record);

    final QueryValue right = getRight();
    final Object value2 = right.getValue(record);

    return CompareUtil.compare(value1, value2) <= 0;
  }

}
