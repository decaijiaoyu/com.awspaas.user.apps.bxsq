package com.awspaas.user.apps.bxsq.plugin;

import com.actionsoft.bpms.commons.at.AbstExpression;
import com.actionsoft.bpms.commons.at.ExpressionContext;

/**
 * �����ַ�������
 */
public class MyLenExpression extends AbstExpression {

    public MyLenExpression(final ExpressionContext atContext, String expressionValue) {
        super(atContext, expressionValue);
    }

    public String execute(String expression) {
        // ȡ��1������
        String str = getParameter(expression, 1);
        return String.valueOf(str.length());
    }
}
